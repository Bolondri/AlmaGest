/*
 * MainController.java
 *
 * Creado el 22-may-2016  14:32:34
 *
 * Copyright(c)2016. Alma Software. Todos los derechos reservados.
 *
 */
package es.almasoft.almagest.controller.main;

import es.almasoft.almagest.DAO.conexion.ConexionBD;
import es.almasoft.almagest.controller.clientes.ClientesController;
import es.almasoft.almagest.view.main.MainMDI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.UIManager;
import es.almasoft.almagest.view.clientes.ClientesPanel;
import java.sql.Connection;

/**
 * {Clase controladora principal que llamaremos desde el }
 *
 * @author Alfonso Maldonado. amdelgado@gmail.com
 */
public class MainController implements ActionListener, WindowListener {

    private ConexionBD conexionBD = null;
    private Connection conn = null;
    private MainMDI mainMDI;
    private ClientesPanel clientesPanel;
    private ClientesController clientesController;

    public MainController() {

        /*Creamos la conexión con la base de datos. Esta será la conexión
        única que estará viva durante la ejecución de la aplicación
         */
        //Creamos la ventana principal
        
        //Establecemos el Look and Feel
        conexionBD = new ConexionBD();
        conn = conexionBD.getConnection();
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            //UIManager.setLookAndFeel("com.oyoaha.swing.plaf.oyoaha.OyoahaLookAndFeel");
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }
        mainMDI = new MainMDI();
        mainMDI.addWindowListener(this);
        mainMDI.getjMenuMantClientes().addActionListener(this);
        mainMDI.setVisible(true);
    }

    //Controlamos acciones efectuadas sobre la ventana principal
    @Override
    public void actionPerformed(ActionEvent e
    ) {
        String accion = e.getActionCommand();

        switch (accion) {
            case "MantClientes":
                clientesController = new ClientesController(mainMDI.getPane(), conn);
        }

    }

    @Override
    public void windowOpened(WindowEvent e
    ) {

    }

    @Override
    public void windowClosing(WindowEvent e
    ) {
        conexionBD.closeConnection();
    }

    @Override
    public void windowClosed(WindowEvent e
    ) {
        conexionBD.closeConnection();

    }

    @Override
    public void windowIconified(WindowEvent e
    ) {

    }

    @Override
    public void windowDeiconified(WindowEvent e
    ) {

    }

    @Override
    public void windowActivated(WindowEvent e
    ) {

    }

    @Override
    public void windowDeactivated(WindowEvent e
    ) {

    }

}
