/*
 * ClientesDAO.java
 *
 * Creado el 22-may-2016  14:00:22
 *
 * Copyright(c)2016. Alma Software. Todos los derechos reservados.
 *
 */
package es.almasoft.almagest.DAO.clientes;

import es.almasoft.almagest.model.clientes.ClientesDTO;
import es.almasoft.almagest.model.clientes.IClientes;
import es.almasoft.almagest.view.main.ErrorDialog;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeSet;

/**
 * {Insertar descripción de la clase aquí}
 *
 * @author Alfonso Maldonado. amdelgado@gmail.com
 */
public class ClientesDAO implements IClientes {

    private ClientesDTO clientesDTO;
    private Connection conn;
    private TreeSet<ClientesDTO> listaClientes;

    public ClientesDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insertarCliente(ClientesDTO cliente) {
        this.clientesDTO = cliente;
        String insertaCliente = "INSERT INTO clientes("
                + "nif, nombre, apellido1, apellido2, fechanacimiento,"
                + "direccion, poblacionpk, codigopostal, clienteactivo)"
                + "VALUES (?, ?, ?, ?, ?, ?,"
                + "?, ?, ?)";

        try {

            PreparedStatement pst = conn.prepareStatement(insertaCliente);
            pst.setString(1, cliente.getNifCliente());
            pst.setString(2, cliente.getNombreCliente());
            pst.setString(3, cliente.getApellidoPaternoCliente());
            pst.setString(4, cliente.getApellidoMaternoCliente());
            pst.setDate(5, (Date) cliente.getFechaNacimientoCliente());
            pst.setString(6, cliente.getDireccionCliente());
            pst.setInt(7, cliente.getPoblacionPk());
            pst.setInt(8, cliente.getCodigoPostalCliente());
            pst.setBoolean(9, true);
            pst.executeUpdate();
            conn.commit();

        } catch (SQLException e) {
            ErrorDialog errorDialog = new ErrorDialog("Error insertando el cliente.", e);
            errorDialog.setVisible(true);
            //dialogoError = new DialogoError(e);
        } catch (NullPointerException e) {
            ErrorDialog errorDialog = new ErrorDialog("Error insertando el cliente.", e);
            errorDialog.setVisible(true);
        }
    }

    @Override
    public void eliminarCliente(ClientesDTO cliente) {

        String eliminaCliente = "DELETE FROM CLIENTES WHERE clientepk=?";
        try {

            PreparedStatement pst = conn.prepareStatement(eliminaCliente);
            pst.setInt(1, cliente.getClientePk());
            pst.executeUpdate();
            conn.commit();

        } catch (SQLException e) {
            ErrorDialog errorDialog = new ErrorDialog("Error eliminando el cliente.", e);
            errorDialog.setVisible(true);
        } catch (NullPointerException e) {
            ErrorDialog errorDialog = new ErrorDialog("Error eliminando el cliente.", e);
            errorDialog.setVisible(true);
        }

    }

    @Override
    public void actualizarCliente(ClientesDTO cliente) {
        this.clientesDTO = cliente;
        String actualizarCliente = "UPDATE clientes SET nif=?,nombre=?,apellido1=?,apellido2=?,fechanacimiento=?,direccion=?,poblacionpk=?,codigopostal=?,clienteactivo=? "
                + " WHERE clientepk=?";

        try {

            PreparedStatement pst = conn.prepareStatement(actualizarCliente);
            pst.setString(1, cliente.getNifCliente());
            pst.setString(2, cliente.getNombreCliente());
            pst.setString(3, cliente.getApellidoPaternoCliente());
            pst.setString(4, cliente.getApellidoMaternoCliente());
            pst.setDate(5, (Date) cliente.getFechaNacimientoCliente());
            pst.setString(6, cliente.getDireccionCliente());
            pst.setInt(7, cliente.getPoblacionPk());
            pst.setInt(8, cliente.getCodigoPostalCliente());
            pst.setBoolean(9, true);
            pst.setInt(10, cliente.getClientePk());
            pst.executeUpdate();
            conn.commit();

        } catch (SQLException e) {
            ErrorDialog errorDialog = new ErrorDialog("Error actualizando el cliente.", e);
            errorDialog.setVisible(true);
        } catch (NullPointerException e) {
            ErrorDialog errorDialog = new ErrorDialog("Error actualizando el cliente.", e);
            errorDialog.setVisible(true);
        }

    }

    @Override
    public TreeSet<ClientesDTO> listaClientes() {

        listaClientes = new TreeSet< ClientesDTO>();

        try {
            PreparedStatement consulta = conn.prepareStatement("SELECT * FROM clientes");
            ResultSet res = consulta.executeQuery();

            while (res.next()) {
                ClientesDTO cliente = new ClientesDTO();
                cliente.setClientePk(res.getInt("clientepk"));
                cliente.setNifCliente(res.getString("nif"));
                cliente.setNombreCliente(res.getString("nombre"));
                cliente.setApellidoPaternoCliente(res.getString("apellido1"));
                cliente.setApellidoMaternoCliente(res.getString("apellido2"));
                cliente.setApellidoPaternoCliente(res.getString("apellido1"));
                cliente.setFechaNacimientoCliente(res.getDate("fechanacimiento"));
                cliente.setDireccionCliente(res.getString("direccion"));
                cliente.setPoblacionPk(res.getInt("poblacionpk"));
                cliente.setCodigoPostalCliente(res.getInt("codigopostal"));
                cliente.setClienteActivo(res.getBoolean("clienteactivo"));
                listaClientes.add(cliente);
            }
            try {
                res.close();
                consulta.close();

            } catch (SQLException e) {
                ErrorDialog errorDialog = new ErrorDialog("Error cargando la lista de clientes.", e);
                errorDialog.setVisible(true);
            } catch (NullPointerException e) {
                ErrorDialog errorDialog = new ErrorDialog("Error cargando la lista de clientes.", e);
                errorDialog.setVisible(true);
            }

        } catch (Exception e) {
            //dialogoError = new DialogoError(e);
            ErrorDialog errorDialog = new ErrorDialog("Error cargando la lista de clientes.", e);
            errorDialog.setVisible(true);
        }
        return listaClientes;
    }

    @Override
    public TreeSet<ClientesDTO> buscarPorId(Integer clientePk) {
        listaClientes = new TreeSet< ClientesDTO>();
        String consultaCliente = "SELECT * FROM clientes WHERE clientepk=?";

        try {
            PreparedStatement consulta = conn.prepareStatement(consultaCliente);
            consulta.setInt(1, clientePk);
            ResultSet res = consulta.executeQuery();

            while (res.next()) {
                ClientesDTO cliente = new ClientesDTO();
                cliente.setClientePk(res.getInt("clientepk"));
                cliente.setNifCliente(res.getString("nif"));
                cliente.setNombreCliente(res.getString("nombre"));
                cliente.setApellidoPaternoCliente(res.getString("apellido1"));
                cliente.setApellidoMaternoCliente(res.getString("apellido2"));
                cliente.setApellidoPaternoCliente(res.getString("apellido1"));
                cliente.setFechaNacimientoCliente(res.getDate("fechanacimiento"));
                cliente.setDireccionCliente(res.getString("direccion"));
                cliente.setPoblacionPk(res.getInt("poblacionpk"));
                cliente.setCodigoPostalCliente(res.getInt("codigopostal"));
                cliente.setClienteActivo(res.getBoolean("clienteactivo"));
                listaClientes.add(cliente);
            }

        } catch (SQLException e) {
            ErrorDialog errorDialog = new ErrorDialog("Error buscando el clientes con ID " + clientePk, e);
            errorDialog.setVisible(true);

        } catch (Exception e) {
            ErrorDialog errorDialog = new ErrorDialog("Error buscando el clientes con ID " + clientePk, e);
            errorDialog.setVisible(true);

        }
        return listaClientes;
    }

    @Override
    public TreeSet<ClientesDTO> buscarPorNombre(String nombreCliente) {
        return listaClientes;
    }

}
