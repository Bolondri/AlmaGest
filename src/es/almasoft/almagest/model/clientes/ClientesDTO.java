/*
 * Clientes.java
 *
 * Creado el 22-may-2016  10:36:35
 *
 * Copyright(c)2016. Alma Software. Todos los derechos reservados.
 *
 */
package es.almasoft.almagest.model.clientes;

import java.util.Date;

/**
 * {Clase principal para los clientes}
 *
 * @author Alfonso Maldonado. amdelgado@gmail.com
 */
public class ClientesDTO implements Comparable<ClientesDTO> {

    Integer clientePk;
    String nombreCliente;
    String apellidoPaternoCliente;
    String apellidoMaternoCliente;
    String nifCliente;
    Date fechaNacimientoCliente;
    String direccionCliente;
    Integer poblacionPk;
    Integer codigoPostalCliente;
    Boolean clienteActivo;

    public Integer getClientePk() {
        return clientePk;
    }

    public String getApellidoPaternoCliente() {
        return apellidoPaternoCliente;
    }

    public void setApellidoPaternoCliente(String apellidoPaternoCliente) {
        this.apellidoPaternoCliente = apellidoPaternoCliente;
    }

    public String getApellidoMaternoCliente() {
        return apellidoMaternoCliente;
    }

    public void setApellidoMaternoCliente(String apellidoMaternoCliente) {
        this.apellidoMaternoCliente = apellidoMaternoCliente;
    }

    public String getNifCliente() {
        return nifCliente;
    }

    public void setNifCliente(String nifCliente) {
        this.nifCliente = nifCliente;
    }

    public Date getFechaNacimientoCliente() {
        return fechaNacimientoCliente;
    }

    public void setFechaNacimientoCliente(Date fechaNacimientoCliente) {
        this.fechaNacimientoCliente = fechaNacimientoCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public Integer getPoblacionPk() {
        return poblacionPk;
    }

    public void setPoblacionPk(Integer poblacionPk) {
        this.poblacionPk = poblacionPk;
    }

    public Integer getCodigoPostalCliente() {
        return codigoPostalCliente;
    }

    public void setCodigoPostalCliente(Integer codigoPostalCliente) {
        this.codigoPostalCliente = codigoPostalCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Boolean getClienteActivo() {
        return clienteActivo;
    }

    public void setClienteActivo(Boolean clienteActivo) {
        this.clienteActivo = clienteActivo;
    }

    public void setClientePk(Integer clientePk) {
        this.clientePk = clientePk;
    }

    @Override
    public int compareTo(ClientesDTO o) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return 0;
    }

    @Override
    public String toString() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.        
        return "";
    }
}
