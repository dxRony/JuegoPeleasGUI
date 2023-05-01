package com.mycompany.juegopeleasgui.fe;

import com.mycompany.juegopeleasgui.be.articulos.Articulo;
import com.mycompany.juegopeleasgui.be.inventarios.ListaGenerica;
import com.mycompany.juegopeleasgui.be.jugadores.Usuario;
import com.mycompany.juegopeleasgui.be.personajes.Jugable;

public class Inventario extends javax.swing.JFrame {

    /**
     * Creates new form Inventario
     */
    private Usuario usuario;
    private ListaGenerica<Jugable> inventarioUsuario;
    private ListaGenerica<Articulo> inventarioArticulos;

    public Inventario(Usuario usuario) {
        this.usuario = usuario;
        initComponents();
        inventarioUsuario = usuario.getInventarioUsuario();
        inventarioArticulos = usuario.getInventarioArticulos();
        txtAreaInventarioPersonajes.setText(inventarioUsuario.mostrarLista());
        txtAreaInventarioArticulos.setText(inventarioArticulos.mostrarLista());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlInventario = new javax.swing.JPanel();
        lblInventario = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaInventarioPersonajes = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaInventarioArticulos = new javax.swing.JTextArea();
        lblPersonajes = new javax.swing.JLabel();
        lblArticulos = new javax.swing.JLabel();
        btnRegresarMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlInventario.setBackground(new java.awt.Color(60, 139, 84));

        lblInventario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblInventario.setForeground(new java.awt.Color(0, 0, 0));
        lblInventario.setText("Inventario del Jugador");

        txtAreaInventarioPersonajes.setBackground(new java.awt.Color(102, 130, 224));
        txtAreaInventarioPersonajes.setColumns(20);
        txtAreaInventarioPersonajes.setRows(5);
        jScrollPane1.setViewportView(txtAreaInventarioPersonajes);

        txtAreaInventarioArticulos.setBackground(new java.awt.Color(102, 130, 224));
        txtAreaInventarioArticulos.setColumns(20);
        txtAreaInventarioArticulos.setRows(5);
        jScrollPane2.setViewportView(txtAreaInventarioArticulos);

        lblPersonajes.setText("Personajes");

        lblArticulos.setText("Articulos");

        btnRegresarMenu.setText("Regresar al Menu Principal");
        btnRegresarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlInventarioLayout = new javax.swing.GroupLayout(pnlInventario);
        pnlInventario.setLayout(pnlInventarioLayout);
        pnlInventarioLayout.setHorizontalGroup(
            pnlInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInventarioLayout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(lblPersonajes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblArticulos)
                .addGap(140, 140, 140))
            .addGroup(pnlInventarioLayout.createSequentialGroup()
                .addGroup(pnlInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInventarioLayout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(lblInventario))
                    .addGroup(pnlInventarioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlInventarioLayout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(btnRegresarMenu)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        pnlInventarioLayout.setVerticalGroup(
            pnlInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInventarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblInventario)
                .addGap(15, 15, 15)
                .addGroup(pnlInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPersonajes)
                    .addComponent(lblArticulos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addComponent(btnRegresarMenu)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlInventario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlInventario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarMenuActionPerformed
        this.setVisible(false);
        inventarioUsuario.setLista("");
        inventarioArticulos.setLista("");
    }//GEN-LAST:event_btnRegresarMenuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresarMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblArticulos;
    private javax.swing.JLabel lblInventario;
    private javax.swing.JLabel lblPersonajes;
    private javax.swing.JPanel pnlInventario;
    private javax.swing.JTextArea txtAreaInventarioArticulos;
    private javax.swing.JTextArea txtAreaInventarioPersonajes;
    // End of variables declaration//GEN-END:variables
}
