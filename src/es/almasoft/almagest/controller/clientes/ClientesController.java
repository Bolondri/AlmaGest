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
import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.TreeSet;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;

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
    private final ClientesPanel clientesPanel;
    private final JDesktopPane pane;
    private ClientesDAO clientesDAO;

    public ClientesController(JDesktopPane pane, Connection conexion) {
        this.clientesPanel = ClientesPanel.getInstance();
        this.pane = pane;
        this.conn = conexion;
        //usefull part for you.. if open shows, if not creates new one 
        if (!this.clientesPanel.isVisible()) {
            {
                Dimension desktopSize = pane.getSize();
                Dimension jInternalFrameSize = this.clientesPanel.getSize();
                this.clientesPanel.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                        (desktopSize.height - jInternalFrameSize.height) / 2);
                this.pane.add(this.clientesPanel);
                this.listarClientes();
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

            case "eliminarCliente":

            case "actualizarCliente":

            case "listar":

        }
    }

    private void listarClientes() {
        //Se obtiene la lista de clientes
        clientesDAO = new ClientesDAO(conn);
        TreeSet<ClientesDTO> listaClientes = clientesDAO.listaClientes();
        ClientesDTO[] result = listaClientes.toArray(new ClientesDTO[listaClientes.size()]);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");

        while (this.clientesPanel.getModelo().getRowCount() > 0) {
            this.clientesPanel.getModelo().removeRow(0);
        }

        //se valida si se obtubo o no informacion
        if (listaClientes.size() > 0) {
            int i;
            //se recorre la lista de libros asignandose cada posicion en un objeto libro
            for (i = 0; i < result.length; i++) {
                this.clientesPanel.getModelo().insertRow(i, new Object[]{
                    i+1,
                    result[i].getNifCliente(),
                    result[i].getApellidoPaternoCliente(),
                    result[i].getApellidoMaternoCliente(),
                    result[i].getNombreCliente(),
                    sdf.format(result[i].getFechaNacimientoCliente())
                });
            }
        } else {
            JOptionPane.showMessageDialog(null, "Actualmente no "
                    + "existen registros de clientes", "INFORMACIÓN",
                    JOptionPane.INFORMATION_MESSAGE);
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
