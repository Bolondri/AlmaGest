/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.almasoft.almagest.view.clientes;

import javax.swing.WindowConstants;

/**
 *
 * @author amdel
 */
public class ClientesPanel extends javax.swing.JInternalFrame {

    /**
     * Creates new form ClientesPanel
     */
    private static ClientesPanel instanciaClientesPanel;

    public ClientesPanel() {
        initComponents();
        System.out.println("Creado Panel Clientes");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPaneClientes = new javax.swing.JTabbedPane();
        jPanelListaClientes = new javax.swing.JPanel();
        jPanelDatosPersonales = new javax.swing.JPanel();

        setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Mantenimientos de Clientes");

        org.jdesktop.layout.GroupLayout jPanelListaClientesLayout = new org.jdesktop.layout.GroupLayout(jPanelListaClientes);
        jPanelListaClientes.setLayout(jPanelListaClientesLayout);
        jPanelListaClientesLayout.setHorizontalGroup(
            jPanelListaClientesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 768, Short.MAX_VALUE)
        );
        jPanelListaClientesLayout.setVerticalGroup(
            jPanelListaClientesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 400, Short.MAX_VALUE)
        );

        jTabbedPaneClientes.addTab("Lista de Clientes", jPanelListaClientes);

        org.jdesktop.layout.GroupLayout jPanelDatosPersonalesLayout = new org.jdesktop.layout.GroupLayout(jPanelDatosPersonales);
        jPanelDatosPersonales.setLayout(jPanelDatosPersonalesLayout);
        jPanelDatosPersonalesLayout.setHorizontalGroup(
            jPanelDatosPersonalesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 768, Short.MAX_VALUE)
        );
        jPanelDatosPersonalesLayout.setVerticalGroup(
            jPanelDatosPersonalesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 400, Short.MAX_VALUE)
        );

        jTabbedPaneClientes.addTab("Datos Personales", jPanelDatosPersonales);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jTabbedPaneClientes)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jTabbedPaneClientes)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelDatosPersonales;
    private javax.swing.JPanel jPanelListaClientes;
    private javax.swing.JTabbedPane jTabbedPaneClientes;
    // End of variables declaration//GEN-END:variables

    public static ClientesPanel getInstance() {
        if (instanciaClientesPanel == null) {
            instanciaClientesPanel = new ClientesPanel();
        }
        return instanciaClientesPanel;
    }

}
