/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import java.awt.Color;

/**
 *
 * @author HP
 */
public class PrincipalSudoku extends javax.swing.JFrame {

    public static TableroSudoku tableroSudoku;
    private TableroNum tableroNum;
    private FronNiveles fronNiveles;

    public PrincipalSudoku() {
        initComponents();
        this.iniciarComponentes();
    }

    public void iniciarComponentes() {
        tableroSudoku = new TableroSudoku();
        tableroSudoku.setAltura(36);
        tableroSudoku.setAncho(36);
        tableroSudoku.setMargen(4);
        tableroSudoku.setTamanioLetra(27);

        this.tableroSudoku.setPanelBackground(new Color(0, 50, 60));

        this.tableroSudoku.setTxtBackground1(Color.WHITE);
        this.tableroSudoku.setForeBackground1(new Color(0, 90, 180));
        this.tableroSudoku.setTxtBackground2(new Color(0, 150, 200));
        this.tableroSudoku.setForeBackground2(Color.WHITE);
        this.tableroSudoku.setTxtBackground3(new Color(0, 75, 75));
        this.tableroSudoku.setForeBackground3(Color.WHITE);
        this.tableroSudoku.setTxtBackground4(new Color(0, 170, 230));
        this.tableroSudoku.setForeBackground4(Color.BLACK);
        this.fondoPanel.add(tableroSudoku);
        this.tableroSudoku.setLocation(70, 60);
        this.tableroSudoku.setVisible(true);
        this.tableroSudoku.crearSudoku();

        tableroNum = new TableroNum();
        this.tableroNum.setAncho(36);
        this.tableroNum.setAltura(36);
        this.tableroNum.setMargen(4);
        this.tableroNum.setTamanioLetra(27);
        this.tableroNum.setPanelBackground(new Color(0, 50, 60));
        this.tableroNum.setTxtBackground1(new Color(0, 150, 200));
        this.tableroNum.setTxtForeground1(Color.WHITE);
        this.tableroNum.setTxtBackground1(new Color(0, 75, 75));
        this.tableroNum.setTxtForeground1(Color.WHITE);

        this.fondoPanel.add(tableroNum);
        this.tableroNum.crearTablero();
        this.tableroNum.setLocation(20, 60);
        this.tableroNum.setVisible(true);

        this.tableroSudoku.generarSudoku(2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondoPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fondoPanel.setBackground(new java.awt.Color(0, 153, 255));
        fondoPanel.setPreferredSize(new java.awt.Dimension(540, 420));
        fondoPanel.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SUDOKU");
        fondoPanel.add(jLabel1);
        jLabel1.setBounds(10, 20, 110, 30);

        jButton1.setText("Nueva partida");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        fondoPanel.add(jButton1);
        jButton1.setBounds(410, 70, 120, 22);

        jButton2.setText("Limpiar");
        jButton2.setMaximumSize(new java.awt.Dimension(104, 22));
        jButton2.setMinimumSize(new java.awt.Dimension(104, 22));
        jButton2.setPreferredSize(new java.awt.Dimension(104, 22));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        fondoPanel.add(jButton2);
        jButton2.setBounds(410, 130, 120, 22);

        jButton4.setText("Verificar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        fondoPanel.add(jButton4);
        jButton4.setBounds(410, 250, 120, 22);

        jButton5.setText("Resolver");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        fondoPanel.add(jButton5);
        jButton5.setBounds(410, 310, 120, 22);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(fondoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (fronNiveles != null) {
            this.fronNiveles.setVisible(true);
        } else {
            fronNiveles = new FronNiveles(tableroSudoku);
            fronNiveles.setVisible(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        tableroSudoku.limpiar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        tableroSudoku.verificar();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        tableroSudoku.resolver();
    }//GEN-LAST:event_jButton5ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalSudoku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel fondoPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
