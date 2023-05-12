package com.mycompany.juegopeleasgui.fe;

import com.mycompany.juegopeleasgui.Partida;
import com.mycompany.juegopeleasgui.be.articulos.Articulo;
import com.mycompany.juegopeleasgui.be.inventarios.ListaGenerica;
import com.mycompany.juegopeleasgui.be.jugadores.GuardarJugador;
import com.mycompany.juegopeleasgui.be.jugadores.IA;
import com.mycompany.juegopeleasgui.be.jugadores.Usuario;
import com.mycompany.juegopeleasgui.be.personajes.Jugable;

public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    private Usuario usuario;
    private IA ia;
    private ListaGenerica<Jugable> inventarioUsuario;
    private ListaGenerica<Articulo> inventarioArticulos;

    public MenuPrincipal(Usuario usuario, IA ia) {
        initComponents();

        this.usuario = usuario;
        this.ia = ia;
        btnIniciarPartida.setEnabled(false);
        btnTienda.setEnabled(false);
        btnGeneracionTablero.setEnabled(false);
        btnInventario.setEnabled(false);
        btnRanking.setEnabled(false);
        lblIngresarNombre.setVisible(false);
        fieldNombre.setVisible(false);
        btnAceptar.setVisible(false);
        btnGuardarJugador.setVisible(false);
        inventarioUsuario = usuario.getInventarioUsuario();
        inventarioArticulos = usuario.getInventarioArticulos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFrame = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblBienvenida = new javax.swing.JLabel();
        btnIniciarPartida = new javax.swing.JButton();
        btnTienda = new javax.swing.JButton();
        btnGeneracionTablero = new javax.swing.JButton();
        btnInventario = new javax.swing.JButton();
        btnRanking = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        lblNombre = new javax.swing.JLabel();
        fieldNombre = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        lblOro = new javax.swing.JLabel();
        lblCantidadOro = new javax.swing.JLabel();
        lblNombreTexto = new javax.swing.JLabel();
        lblIngresarNombre = new javax.swing.JLabel();
        btnNuevoJugador = new javax.swing.JButton();
        btnCargarJugador = new javax.swing.JButton();
        btnGuardarJugador = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlFrame.setBackground(new java.awt.Color(51, 102, 255));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(0, 0, 0));
        lblTitulo.setText("¡¡¡JUEGO PELEAS!!!");

        lblBienvenida.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblBienvenida.setForeground(new java.awt.Color(0, 0, 0));
        lblBienvenida.setText("BIENVENIDO");

        btnIniciarPartida.setBackground(new java.awt.Color(255, 255, 255));
        btnIniciarPartida.setForeground(new java.awt.Color(0, 0, 0));
        btnIniciarPartida.setText("Iniciar Partida");
        btnIniciarPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarPartidaActionPerformed(evt);
            }
        });

        btnTienda.setBackground(new java.awt.Color(255, 255, 255));
        btnTienda.setForeground(new java.awt.Color(0, 0, 0));
        btnTienda.setText("Tienda");
        btnTienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTiendaActionPerformed(evt);
            }
        });

        btnGeneracionTablero.setBackground(new java.awt.Color(255, 255, 255));
        btnGeneracionTablero.setForeground(new java.awt.Color(0, 0, 0));
        btnGeneracionTablero.setText("Generación Tablero");
        btnGeneracionTablero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGeneracionTableroActionPerformed(evt);
            }
        });

        btnInventario.setBackground(new java.awt.Color(255, 255, 255));
        btnInventario.setForeground(new java.awt.Color(0, 0, 0));
        btnInventario.setText("Inventario");
        btnInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventarioActionPerformed(evt);
            }
        });

        btnRanking.setBackground(new java.awt.Color(255, 255, 255));
        btnRanking.setForeground(new java.awt.Color(0, 0, 0));
        btnRanking.setText("Ranking");
        btnRanking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRankingActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(255, 255, 255));
        btnSalir.setForeground(new java.awt.Color(0, 0, 0));
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        lblNombre.setForeground(new java.awt.Color(0, 0, 0));
        lblNombre.setText("Nombre del Jugador:");

        fieldNombre.setBackground(new java.awt.Color(204, 0, 51));
        fieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNombreActionPerformed(evt);
            }
        });

        btnAceptar.setBackground(new java.awt.Color(255, 255, 255));
        btnAceptar.setForeground(new java.awt.Color(0, 0, 0));
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        lblOro.setForeground(new java.awt.Color(0, 0, 0));
        lblOro.setText("Oro del Jugador:");

        lblNombreTexto.setBackground(new java.awt.Color(0, 0, 0));
        lblNombreTexto.setForeground(new java.awt.Color(0, 0, 0));
        lblNombreTexto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblIngresarNombre.setText("Ingresa tu nombre");

        btnNuevoJugador.setText("Nuevo Jugador");
        btnNuevoJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoJugadorActionPerformed(evt);
            }
        });

        btnCargarJugador.setText("Cargar Jugador");
        btnCargarJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarJugadorActionPerformed(evt);
            }
        });

        btnGuardarJugador.setText("Guardar Jugador");
        btnGuardarJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarJugadorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFrameLayout = new javax.swing.GroupLayout(pnlFrame);
        pnlFrame.setLayout(pnlFrameLayout);
        pnlFrameLayout.setHorizontalGroup(
            pnlFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFrameLayout.createSequentialGroup()
                .addGroup(pnlFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFrameLayout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(lblBienvenida))
                    .addGroup(pnlFrameLayout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(lblTitulo))
                    .addGroup(pnlFrameLayout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(btnIniciarPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlFrameLayout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(btnTienda, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlFrameLayout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(btnGeneracionTablero, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlFrameLayout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(btnInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlFrameLayout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(btnRanking, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlFrameLayout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlFrameLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblNombre)
                        .addGap(108, 108, 108)
                        .addComponent(lblOro))
                    .addGroup(pnlFrameLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblNombreTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108)
                        .addComponent(lblCantidadOro, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlFrameLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblIngresarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNuevoJugador))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlFrameLayout.createSequentialGroup()
                                .addComponent(btnCargarJugador)
                                .addGap(18, 18, 18)
                                .addComponent(btnGuardarJugador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pnlFrameLayout.createSequentialGroup()
                                .addComponent(fieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        pnlFrameLayout.setVerticalGroup(
            pnlFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFrameLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblBienvenida)
                .addGap(6, 6, 6)
                .addComponent(lblTitulo)
                .addGap(12, 12, 12)
                .addComponent(btnIniciarPartida)
                .addGap(18, 18, 18)
                .addComponent(btnTienda)
                .addGap(18, 18, 18)
                .addComponent(btnGeneracionTablero)
                .addGap(18, 18, 18)
                .addComponent(btnInventario)
                .addGap(18, 18, 18)
                .addComponent(btnRanking)
                .addGap(12, 12, 12)
                .addComponent(btnSalir)
                .addGap(24, 24, 24)
                .addGroup(pnlFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlFrameLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(lblOro)))
                .addGap(6, 6, 6)
                .addGroup(pnlFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombreTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCantidadOro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevoJugador)
                    .addComponent(btnCargarJugador)
                    .addComponent(btnGuardarJugador))
                .addGap(18, 18, 18)
                .addGroup(pnlFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIngresarNombre)
                    .addComponent(fieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptar))
                .addContainerGap(73, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFrame, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNombreActionPerformed

    }//GEN-LAST:event_fieldNombreActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        String nombre = fieldNombre.getText();
        usuario.setNombre(nombre);
        lblNombreTexto.setText(usuario.getNombre() + "");
        lblCantidadOro.setText(usuario.getOro() + "");
        btnIniciarPartida.setEnabled(true);
        btnTienda.setEnabled(true);
        btnGeneracionTablero.setEnabled(true);
        btnInventario.setEnabled(true);
        btnRanking.setEnabled(true);
        fieldNombre.setVisible(false);
        btnAceptar.setVisible(false);
        btnAceptar.setEnabled(false);
        lblIngresarNombre.setVisible(false);
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnTiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTiendaActionPerformed
        Tienda tienda = new Tienda(usuario, ia);
        tienda.setVisible(true);
        lblCantidadOro.setText(usuario.getOro() + "");
    }//GEN-LAST:event_btnTiendaActionPerformed

    private void btnInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventarioActionPerformed
        Inventario inventario = new Inventario(usuario);
        inventario.setVisible(true);
        lblCantidadOro.setText(usuario.getOro() + "");
        // inventarioUsuario.mostrarLista();
    }//GEN-LAST:event_btnInventarioActionPerformed

    private void btnRankingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRankingActionPerformed
        // TODO add your handling code here:
        lblCantidadOro.setText(usuario.getOro() + "");
    }//GEN-LAST:event_btnRankingActionPerformed

    private void btnGeneracionTableroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGeneracionTableroActionPerformed
        GenerarTablero generarTablero = new GenerarTablero(usuario, ia);
        generarTablero.setVisible(true);
    }//GEN-LAST:event_btnGeneracionTableroActionPerformed

    private void btnIniciarPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarPartidaActionPerformed
        Tienda tienda = new Tienda(usuario, ia);
        tienda.setVisible(true);
        lblCantidadOro.setText(usuario.getOro() + "");

    }//GEN-LAST:event_btnIniciarPartidaActionPerformed

    private void btnNuevoJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoJugadorActionPerformed
        lblIngresarNombre.setVisible(true);
        fieldNombre.setVisible(true);
        btnAceptar.setVisible(true);
        btnCargarJugador.setVisible(false);
        btnNuevoJugador.setVisible(false);
        btnGuardarJugador.setVisible(true);
    }//GEN-LAST:event_btnNuevoJugadorActionPerformed

    private void btnCargarJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarJugadorActionPerformed
        GuardarJugador cargarJugador = new GuardarJugador();
        this.usuario = cargarJugador.leerArchivoBinario();
    }//GEN-LAST:event_btnCargarJugadorActionPerformed

    private void btnGuardarJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarJugadorActionPerformed
        GuardarJugador guardarJugador = new GuardarJugador();
        guardarJugador.guardarArchivoBinario(usuario);
    }//GEN-LAST:event_btnGuardarJugadorActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCargarJugador;
    private javax.swing.JButton btnGeneracionTablero;
    private javax.swing.JButton btnGuardarJugador;
    private javax.swing.JButton btnIniciarPartida;
    private javax.swing.JButton btnInventario;
    private javax.swing.JButton btnNuevoJugador;
    private javax.swing.JButton btnRanking;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnTienda;
    private javax.swing.JTextField fieldNombre;
    private javax.swing.JLabel lblBienvenida;
    private javax.swing.JLabel lblCantidadOro;
    private javax.swing.JLabel lblIngresarNombre;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombreTexto;
    private javax.swing.JLabel lblOro;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlFrame;
    // End of variables declaration//GEN-END:variables
}
