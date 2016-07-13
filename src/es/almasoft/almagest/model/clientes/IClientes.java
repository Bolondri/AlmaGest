/*
 * IClientes.java
 *
 * Creado el 22-may-2016  13:49:55
 *
 * Copyright(c)2016. Alma Software. Todos los derechos reservados.
 *
 */

package es.almasoft.almagest.model.clientes;
import java.util.List;
import java.util.TreeSet;

/**
 * {Insertar descripción del interfaz aquí} 
 *
 * @author Alfonso Maldonado. amdelgado@gmail.com
 */

public interface IClientes {
    
    public void insertarCliente(ClientesDTO cliente);
    public void eliminarCliente(ClientesDTO cliente);
    public void actualizarCliente(ClientesDTO cliente);
    TreeSet<ClientesDTO> listaClientes();
    TreeSet<ClientesDTO> buscarPorId(Integer clientePk);
    TreeSet<ClientesDTO> buscarPorNombre(String nombreCliente);

}
