/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.almasoft.almagest.controller.clientes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import es.almasoft.almagest.DAO.clientes.ClientesDAO;
import es.almasoft.almagest.model.clientes.ClientesDTO;
import es.almasoft.almagest.view.clientes.ClientesPanel;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;

/**
 *
 * @author amdel
 */
/**
 *
 * @author amdel
 */
public class ClientesController implements ActionListener, WindowListener {

    private Connection conn = null;
    private ClientesPanel clientesPanel = ClientesPanel.getInstance();
    private ClientesDTO clientesDTO;
    private ClientesDAO clientesDAO;
    private JDesktopPane pane;
    

    public ClientesController(JDesktopPane pane, Connection conexion) {
        this.pane=pane;
        this.conn = conexion;
        //usefull part for you.. if open shows, if not creates new one 
        if (!this.clientesPanel.isVisible()) {
            {
                this.pane.add(this.clientesPanel);
                this.clientesPanel.setVisible(true);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e
    ) {
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
    public void windowOpened(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosing(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosed(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        clientesPanel.setVisible(false);
        this.pane.remove(clientesPanel);
        
    }

    @Override
    public void windowIconified(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
