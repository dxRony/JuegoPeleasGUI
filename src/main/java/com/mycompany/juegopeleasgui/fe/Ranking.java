/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.juegopeleasgui.fe;

import com.mycompany.juegopeleasgui.be.OrdenarRanking;
import com.mycompany.juegopeleasgui.be.jugadores.Usuario;

/**
 *
 * @author romar
 */
public class Ranking extends javax.swing.JFrame {

    /**
     * Creates new form Ranking
     */
    private Usuario usuario;
    private OrdenarRanking ranking;

    public Ranking(Usuario usuario) {
        initComponents();
        this.usuario = usuario;
        ranking = new OrdenarRanking();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlRanking = new javax.swing.JPanel();
        lblRanking = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        fieldAreaRanking = new javax.swing.JTextArea();
        lblVerRanking = new javax.swing.JLabel();
        btnMayorMenor = new javax.swing.JToggleButton();
        btnMenorMayor = new javax.swing.JButton();
        btnMenuPrincipal = new javax.swing.JButton();
        btnRankingNormal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlRanking.setLayout(null);

        lblRanking.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblRanking.setText("Ranking");
        pnlRanking.add(lblRanking);
        lblRanking.setBounds(160, 10, 80, 20);

        fieldAreaRanking.setColumns(20);
        fieldAreaRanking.setRows(5);
        jScrollPane1.setViewportView(fieldAreaRanking);

        pnlRanking.add(jScrollPane1);
        jScrollPane1.setBounds(10, 40, 390, 220);

        lblVerRanking.setText("Como deseas ver el ranking");
        pnlRanking.add(lblVerRanking);
        lblVerRanking.setBounds(130, 280, 170, 16);

        btnMayorMenor.setText("Mayor a menor");
        btnMayorMenor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMayorMenorActionPerformed(evt);
            }
        });
        pnlRanking.add(btnMayorMenor);
        btnMayorMenor.setBounds(30, 310, 130, 23);

        btnMenorMayor.setText("Menor a mayor");
        btnMenorMayor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenorMayorActionPerformed(evt);
            }
        });
        pnlRanking.add(btnMenorMayor);
        btnMenorMayor.setBounds(310, 310, 130, 23);

        btnMenuPrincipal.setText("Regresar al menu principal");
        btnMenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuPrincipalActionPerformed(evt);
            }
        });
        pnlRanking.add(btnMenuPrincipal);
        btnMenuPrincipal.setBounds(110, 350, 200, 23);

        btnRankingNormal.setText("Normal");
        btnRankingNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRankingNormalActionPerformed(evt);
            }
        });
        pnlRanking.add(btnRankingNormal);
        btnRankingNormal.setBounds(170, 310, 130, 23);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlRanking, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlRanking, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuPrincipalActionPerformed

        this.setVisible(false);
    }//GEN-LAST:event_btnMenuPrincipalActionPerformed

    private void btnMayorMenorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMayorMenorActionPerformed
        String texto;
        texto = ranking.abrirArchivo();
        String[] jugadoresDesc = ranking.ordenarJugadores(texto, true);
        String txtAsc = "";
        for (String jugador : jugadoresDesc) {
            txtAsc += jugador.concat("\n");
        }
        fieldAreaRanking.setText(txtAsc);
    }//GEN-LAST:event_btnMayorMenorActionPerformed

    private void btnRankingNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRankingNormalActionPerformed
        String texto;
        texto = ranking.abrirArchivo();
        fieldAreaRanking.setText(texto);
    }//GEN-LAST:event_btnRankingNormalActionPerformed

    private void btnMenorMayorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenorMayorActionPerformed
        String texto;
        texto = ranking.abrirArchivo();

        String[] jugadoresAsc = ranking.ordenarJugadores(texto, false);
        String txtAsc = "";
        for (String jugador : jugadoresAsc) {
            txtAsc += jugador.concat("\n");
        }
        fieldAreaRanking.setText(txtAsc);

    }//GEN-LAST:event_btnMenorMayorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnMayorMenor;
    private javax.swing.JButton btnMenorMayor;
    private javax.swing.JButton btnMenuPrincipal;
    private javax.swing.JButton btnRankingNormal;
    private javax.swing.JTextArea fieldAreaRanking;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblRanking;
    private javax.swing.JLabel lblVerRanking;
    private javax.swing.JPanel pnlRanking;
    // End of variables declaration//GEN-END:variables
}
