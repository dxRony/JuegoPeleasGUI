package com.mycompany.juegopeleasgui.fe;

import com.mycompany.juegopeleasgui.be.articulos.Articulo;
import com.mycompany.juegopeleasgui.be.inventarios.ListaGenerica;
import com.mycompany.juegopeleasgui.be.jugadores.GuardarJugador;
import com.mycompany.juegopeleasgui.be.jugadores.IA;
import com.mycompany.juegopeleasgui.be.jugadores.Usuario;
import com.mycompany.juegopeleasgui.be.personajes.Jugable;
import com.mycompany.juegopeleasgui.be.personajes.NoJugable;

public class ElegirUsuario extends javax.swing.JFrame {

    /**
     * Creates new form ElegirUsuario
     */
    // private Usuario usuario;
    private IA ia;
    private Jugable[] listaJugables;
    private Articulo[] listaArticulos;
    private NoJugable[] listaEnemigos;
    private ListaGenerica<NoJugable> inventarioIA;
    private ListaGenerica<Jugable> inventarioUsuario;
    private int oro;

    public ElegirUsuario() {
        initComponents();
        lblIngresarNombre.setVisible(false);
        fieldNombre.setVisible(false);
        btnAceptar.setVisible(false);
        ia = new IA();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnCargarUsuario = new javax.swing.JButton();
        btnNuevoUsuario = new javax.swing.JButton();
        lblIngresarNombre = new javax.swing.JLabel();
        fieldNombre = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Antes de iniciar elige una opcion");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(80, 20, 240, 40);

        btnCargarUsuario.setText("Cargar usuario");
        btnCargarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(btnCargarUsuario);
        btnCargarUsuario.setBounds(20, 60, 160, 23);

        btnNuevoUsuario.setText("Crear nuevo usuario");
        btnNuevoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevoUsuario);
        btnNuevoUsuario.setBounds(200, 60, 160, 23);

        lblIngresarNombre.setText("Ingresa tu nombre:");
        jPanel1.add(lblIngresarNombre);
        lblIngresarNombre.setBounds(10, 130, 120, 16);
        jPanel1.add(fieldNombre);
        fieldNombre.setBounds(120, 130, 150, 22);

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptar);
        btnAceptar.setBounds(285, 130, 90, 23);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCargarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarUsuarioActionPerformed
        GuardarJugador archivo = new GuardarJugador();
        Usuario usuarioCargado = archivo.leerArchivoBinario();
        System.out.println("nombre = " + usuarioCargado.getNombre());
        MenuPrincipal juego = new MenuPrincipal(usuarioCargado, ia);
        juego.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnCargarUsuarioActionPerformed

    private void btnNuevoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoUsuarioActionPerformed
        lblIngresarNombre.setVisible(true);
        fieldNombre.setVisible(true);
        btnAceptar.setVisible(true);
        btnNuevoUsuario.setVisible(false);
        btnCargarUsuario.setVisible(false);
    }//GEN-LAST:event_btnNuevoUsuarioActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        Usuario usuario = new Usuario();
        String nombre = fieldNombre.getText();
        usuario.setNombre(nombre);
        System.out.println("nombre = " + usuario.getNombre());
        MenuPrincipal juego = new MenuPrincipal(usuario, ia);
        juego.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAceptarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCargarUsuario;
    private javax.swing.JButton btnNuevoUsuario;
    private javax.swing.JTextField fieldNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblIngresarNombre;
    // End of variables declaration//GEN-END:variables
}