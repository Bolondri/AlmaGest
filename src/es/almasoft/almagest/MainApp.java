/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.almasoft.almagest;

import es.almasoft.almagest.DAO.clientes.ClientesDAO;
import es.almasoft.almagest.DAO.conexion.ConexionBD;
import es.almasoft.almagest.controller.main.MainController;
import es.almasoft.almagest.model.clientes.ClientesDTO;
import es.almasoft.almagest.view.main.ErrorDialog;
import java.sql.Connection;
import java.util.TreeSet;

/**
 *
 * @author amdel
 */
public class MainApp {

    public static void main(String[] args) {
        
        //MainController mainController = new MainController();
        //Se obtiene la lista de personas

        ConexionBD conexionBD = new ConexionBD();
        Connection conn = conexionBD.getConnection();
        ClientesDAO clientesDAO = new ClientesDAO(conn);
        /*TreeSet<ClientesDTO> listaClientes = clientesDAO.listaClientes();
        ClientesDTO[] result = listaClientes.toArray(new ClientesDTO[listaClientes.size()]);

        //se valida si se obtubo o no informacion
        if (listaClientes.size() > 0) {
            int i;
            //se recorre la lista de libros asignandose cada posicion en un objeto libro
            for (i = 0; i < result.length; i++) {
                System.out.println((result[i].getNombreCliente()).trim()+" "+result[i].getApellidoPaternoCliente().trim()+ " "+
                        result[i].getApellidoMaternoCliente().trim());

            }
        }*/
        ClientesDTO cliente = new ClientesDTO();
        TreeSet<ClientesDTO> lista = clientesDAO.buscarPorId(3);
        

    }

}
