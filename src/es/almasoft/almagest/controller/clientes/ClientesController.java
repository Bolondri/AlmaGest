/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.almasoft.almagest.controller.clientes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static java.util.Objects.isNull;
import javax.swing.JDesktopPane;
import es.almasoft.almagest.DAO.clientes.ClientesDAO;
import es.almasoft.almagest.model.clientes.ClientesDTO;
import es.almasoft.almagest.view.clientes.ClientesPanel;
import java.sql.Connection;

/**
 *
 * @author amdel
 */
/**
 *
 * @author amdel
 */
public class ClientesController implements ActionListener, MouseListener {

    private Connection conn = null;
    private ClientesPanel clientesPanel;
    private ClientesDTO clientesDTO;
    private ClientesDAO clientesDAO;
    
    public ClientesController(JDesktopPane pane, Connection conexion) {
        this.conn = conexion;
        if (isNull(clientesPanel)) {
            clientesPanel = ClientesPanel.getInstance();
            pane.add(clientesPanel);
        }

        clientesPanel.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String accion = e.getActionCommand();

        switch (accion) {
            case "insertarCliente":
                System.out.println("Pulsado insertar");
            case "eliminarCliente":
                System.out.println("Pulsado eliminar");
            case "actualizarCliente":
                System.out.println("Pulsado actualizar");
            case "listar":
                System.out.println("Obtener lista clientes");
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
