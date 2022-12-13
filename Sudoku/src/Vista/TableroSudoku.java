/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Modelo.Sudoku;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author HP
 */
public class TableroSudoku extends JPanel {

    private JTextField[][] listaTxt;
    int altura;
    int ancho;
    int margen;
    int tamanioLetra;
    private Color panelBackground;
    private Color txtBackground1;
    private Color foreBackground1;
    private Color txtBackground2;
    private Color foreBackground2;
    private Color txtBackground3;
    private Color foreBackground3;
    private Color txtBackground4;
    private Color foreBackground4;
    private Sudoku sudoku;
    private ArrayList<JTextField> listaTxtaux;
    private ArrayList<JTextField> listaGenerados;
    private JTextField select;
    
    public TableroSudoku() {
        this.iniciarComponentes();
    }
    
    public void iniciarComponentes() {
        listaTxt = new JTextField[9][9];
        altura = 5;
        ancho = 20;
        margen = 15;
        tamanioLetra = 20;
        panelBackground = Color.BLACK;
        txtBackground1 = Color.BLACK;
        foreBackground1 = Color.WHITE;
        txtBackground2 = Color.BLACK;
        foreBackground2 = Color.WHITE;
        txtBackground3 = Color.BLACK;
        foreBackground3 = Color.WHITE;
        txtBackground4 = Color.BLACK;
        foreBackground4 = Color.WHITE;
        sudoku = new Sudoku();
        listaTxtaux = new ArrayList<>();
        listaGenerados = new ArrayList<>();
        select = new JTextField();
    }
    
    public void crearSudoku() {
        this.setLayout(null);
        this.setSize(ancho * 9 + (ancho * 4), altura * 9 + (altura * 4));
        this.setBackground(panelBackground);
        this.crearCampos();
    }
    
    public void crearCampos() {
        int x = margen;
        int y = margen;
        for (int i = 0; i < listaTxt.length; i++) {
            for (int j = 0; j < listaTxt[0].length; j++) {
                JTextField txt = new JTextField();
                this.add(txt);
                txt.setBounds(x, y, ancho, altura);
                txt.setBackground(txtBackground1);
                txt.setForeground(foreBackground1);
                txt.setFont(new Font("Monserrat", Font.BOLD, tamanioLetra));
                txt.setVisible(true);
                txt.setEditable(false);
                txt.setCursor(new Cursor(Cursor.HAND_CURSOR));
                txt.setBorder(BorderFactory.createLineBorder(panelBackground, 1));
                x += ancho;
                if ((j + 1) % 3 == 0) {
                    x += margen;
                }
                listaTxt[i][j] = txt;
                generarEventos(txt);
            }
            x = margen;
            y += altura;
            if ((i + 1) % 3 == 0) {
                y += margen;
            }
            
        }
    }
    
    public void generarEventos(JTextField txt) {
        MouseListener evento = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
            
            @Override
            public void mousePressed(MouseEvent e) {
                pressed(txt);
                select = txt;
            }
            
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
            }
        };
        KeyListener eventoTecla = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            
            @Override
            public void keyPressed(KeyEvent e) {
                
                if (txtGenerado(txt)) {
                    return;
                } else {
                    if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                        txt.setText("");
                    }
                    if (e.getKeyChar() >= 49 && e.getKeyChar() <= 57) {
                        txt.setText(String.valueOf(e.getKeyChar()));
                    }
                }
                
            }
            
            @Override
            public void keyReleased(KeyEvent e) {
            }
        };
        txt.addMouseListener(evento);
        txt.addKeyListener(eventoTecla);
    }
    
    public void pressed(JTextField txt) {
        for (JTextField jtxt : listaTxtaux) {
            jtxt.setBackground(txtBackground1);
            jtxt.setForeground(foreBackground1);
            jtxt.setBorder(BorderFactory.createLineBorder(panelBackground, 1));
        }
        for (JTextField jtxt : listaGenerados) {
            jtxt.setBackground(txtBackground4);
            jtxt.setForeground(foreBackground4);
        }
        listaTxtaux.clear();
        for (int i = 0; i < listaTxt.length; i++) {
            for (int j = 0; j < listaTxt[0].length; j++) {
                if (listaTxt[i][j] == txt) {
                    for (int k = 0; k < listaTxt.length; k++) {
                        listaTxt[k][j].setBackground(txtBackground2);
//                        listaTxt[k][j].setForeground(foreBackground2);
                        listaTxtaux.add(listaTxt[k][j]);
                    }
                    for (int k = 0; k < listaTxt[0].length; k++) {
                        listaTxt[i][k].setBackground(txtBackground2);
//                        listaTxt[i][k].setForeground(foreBackground2);
                        listaTxtaux.add(listaTxt[i][k]);
                    }
                    int posi = sudoku.subCuadranteAct(i);
                    int posj = sudoku.subCuadranteAct(j);
                    for (int k = posi - 3; k < posi; k++) {
                        for (int l = posj - 3; l < posj; l++) {
                            listaTxt[k][l].setBackground(txtBackground2);
//                            listaTxt[k][l].setForeground(foreBackground2);
                            listaTxtaux.add(listaTxt[k][l]);
                        }
                    }
                    listaTxt[i][j].setBackground(txtBackground3);
                    listaTxt[i][j].setForeground(foreBackground3);
                    listaTxt[i][j].setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
                    return;
                }
            }
        }
    }
    
    public void generarSudoku(int nivel) {
        this.limpiarTxt();
        sudoku.generarSudoku(nivel);
        int[][] sudokuGenerado = sudoku.getSudoku();
        for (int i = 0; i < listaTxt.length; i++) {
            for (int j = 0; j < listaTxt[0].length; j++) {
                if (sudokuGenerado[i][j] != 0) {
                    listaTxt[i][j].setText(String.valueOf(sudokuGenerado[i][j]));
                    listaTxt[i][j].setBackground(txtBackground4);
                    listaTxt[i][j].setForeground(foreBackground4);
                    listaGenerados.add(listaTxt[i][j]);
                }
            }
        }
    }
    
    public void limpiarTxt() {
        for (int i = 0; i < listaTxt.length; i++) {
            for (int j = 0; j < listaTxt[0].length; j++) {
                listaTxt[i][j].setText("");
                listaTxt[i][j].setBackground(txtBackground1);
                listaTxt[i][j].setForeground(foreBackground1);
            }
        }
    }
    
    public void limpiar(){
        for (int i = 0; i < listaTxt.length; i++) {
            for (int j = 0; j < listaTxt[0].length; j++) {
                boolean b=false;
                for(JTextField txt:listaGenerados){
                    if(listaTxt[i][j]==txt){
                        b=true;
                        break;
                    }
                }
                if(!b){
                    listaTxt[i][j].setText("");
                }
            }
        }
    }
    
    public void verificar(){
        int sudo[][]=new int[9][9];
        for (int i = 0; i < listaTxt.length; i++) {
            for (int j = 0; j < listaTxt[0].length; j++) {
                if(listaTxt[i][j].getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Sudoku incompleto","EROR",JOptionPane.ERROR_MESSAGE);
                    return;
                }else{
                    sudo[i][j]=Integer.parseInt(listaTxt[i][j].getText());
                }
            }
        }
        sudoku.setSudoku(sudo);
        if(sudoku.verificarSudoku()){
            JOptionPane.showMessageDialog(null, "Sudoku correcto","Sudoku",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,"No hay solución","EROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    
       public void resolver(){
        sudoku.limpiarSudoku();
        for (int i = 0; i < listaTxt.length; i++) {
            for (int j = 0; j < listaTxt[0].length; j++) {
                for (JTextField txt:listaGenerados) {
                    if(txt==listaTxt[i][j]){
                        sudoku.getSudoku()[i][j]=Integer.parseInt(txt.getText());
                    }
                }
            }
        }
        
        if(sudoku.resolverSudoku()){
            for (int i = 0; i < listaTxt.length; i++) {
                for (int j = 0; j < listaTxt[0].length; j++) {
                    listaTxt[i][j].setText(String.valueOf(sudoku.getSudoku()[i][j]));
                }
            }
        }else{
            JOptionPane.showMessageDialog(null,"No hay solución","Error",JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public boolean txtGenerado(JTextField txt) {
        for (JTextField jtxt : listaGenerados) {
            if (txt == jtxt) {
                return true;
            }
        }
        return false;
    }
    
    public JTextField[][] getListaTxt() {
        return listaTxt;
    }
    
    public void setListaTxt(JTextField[][] listaTxt) {
        this.listaTxt = listaTxt;
    }
    
    public int getAltura() {
        return altura;
    }
    
    public void setAltura(int altura) {
        this.altura = altura;
    }
    
    public int getAncho() {
        return ancho;
    }
    
    public void setAncho(int ancho) {
        this.ancho = ancho;
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
    
    public void setPanelBackground(Color PanelBackground) {
        this.panelBackground = PanelBackground;
    }
    
    public Color getTxtBackground1() {
        return txtBackground1;
    }
    
    public void setTxtBackground1(Color txtBackground1) {
        this.txtBackground1 = txtBackground1;
    }
    
    public Color getForeBackground1() {
        return foreBackground1;
    }
    
    public void setForeBackground1(Color foreBackground1) {
        this.foreBackground1 = foreBackground1;
    }
    
    public Color getTxtBackground2() {
        return txtBackground2;
    }
    
    public void setTxtBackground2(Color txtBackground2) {
        this.txtBackground2 = txtBackground2;
    }
    
    public Color getForeBackground2() {
        return foreBackground2;
    }
    
    public void setForeBackground2(Color foreBackground2) {
        this.foreBackground2 = foreBackground2;
    }
    
    public Color getTxtBackground3() {
        return txtBackground3;
    }
    
    public void setTxtBackground3(Color txtBackground3) {
        this.txtBackground3 = txtBackground3;
    }
    
    public Color getForeBackground3() {
        return foreBackground3;
    }
    
    public void setForeBackground3(Color foreBackground3) {
        this.foreBackground3 = foreBackground3;
    }
    
    public Color getTxtBackground4() {
        return txtBackground4;
    }
    
    public void setTxtBackground4(Color txtBackground4) {
        this.txtBackground4 = txtBackground4;
    }
    
    public Color getForeBackground4() {
        return foreBackground4;
    }
    
    public void setForeBackground4(Color foreBackground4) {
        this.foreBackground4 = foreBackground4;
    }
    
    public JTextField getSelect() {
        return select;
    }
    
    public void setSelect(JTextField select) {
        this.select = select;
    }
    
}
