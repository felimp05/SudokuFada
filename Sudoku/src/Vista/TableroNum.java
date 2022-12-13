/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author HP
 */
public class TableroNum extends JPanel {

    private int ancho, altura, margen, tamanioLetra;
    private Color panelBackground;
    private Color txtBackground1;
    private Color txtForeground1;
    private Color txtBackground2;
    private Color txtForeground2;
    private TableroSudoku tablerosk;

    public TableroNum() {
        iniComponentes();
        tablerosk = PrincipalSudoku.tableroSudoku;
    }

    public void iniComponentes() {
        altura = 30;
        ancho = 30;
        margen = 4;
        tamanioLetra = 27;
        panelBackground = Color.BLACK;
        txtBackground1 = Color.BLACK;
        txtForeground1 = Color.WHITE;
        txtBackground2 = Color.BLACK;
        txtForeground2 = Color.WHITE;
    }

    public void crearTablero() {
        this.setLayout(null);
        this.setSize(ancho + (margen * 2), altura * 9 + (margen * 4));
        this.setBackground(panelBackground);
        this.crearCamposTxt();
    }

    public void crearCamposTxt() {
        int x = margen;
        int y = margen;
        for (int i = 0; i < 9; i++) {
            JTextField txt = new JTextField();
            this.add(txt);
            txt.setBounds(x, y, ancho, altura);
            txt.setBackground(txtBackground1);
            txt.setForeground(txtForeground1);
            txt.setCursor(new Cursor(Cursor.HAND_CURSOR));
            txt.setEditable(false);
            txt.setBorder(BorderFactory.createLineBorder(panelBackground, 1));
            txt.setFont(new Font("MontSerrat", Font.BOLD, tamanioLetra));
            txt.setText(String.valueOf(i + 1));
            y += altura;
            if ((i + 1) % 3 == 0) {
                y += margen;
            }
            this.generarEventos(txt);
        }
    }

    public void generarEventos(JTextField txt) {
        MouseListener evento = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (tablerosk.txtGenerado(tablerosk.getSelect())) {
                    return;
                }
                tablerosk.getSelect().setText(txt.getText());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                txt.setBackground(txtBackground2);
                txt.setForeground(txtForeground2);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                txt.setBackground(txtBackground1);
                txt.setForeground(txtForeground1);
            }
        };
        txt.addMouseListener(evento);
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getMargen() {
        return margen;
    }

    public void setMargen(int margen) {
        this.margen = margen;
    }

    public int getTamanioLetra() {
        return tamanioLetra;
    }

    public void setTamanioLetra(int tamanioLetra) {
        this.tamanioLetra = tamanioLetra;
    }

    public Color getPanelBackground() {
        return panelBackground;
    }

    public void setPanelBackground(Color panelBackground) {
        this.panelBackground = panelBackground;
    }

    public Color getTxtBackground1() {
        return txtBackground1;
    }

    public void setTxtBackground1(Color txtBackground1) {
        this.txtBackground1 = txtBackground1;
    }

    public Color getTxtForeground1() {
        return txtForeground1;
    }

    public void setTxtForeground1(Color txtForeground1) {
        this.txtForeground1 = txtForeground1;
    }

    public Color getTxtBackground2() {
        return txtBackground2;
    }

    public void setTxtBackground2(Color txtBackground2) {
        this.txtBackground2 = txtBackground2;
    }

    public Color getTxtForeground2() {
        return txtForeground2;
    }

    public void setTxtForeground2(Color txtForeground2) {
        this.txtForeground2 = txtForeground2;
    }

}
