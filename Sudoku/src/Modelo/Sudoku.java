/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Random;

/**
 *
 * @author HP
 */
public class Sudoku {

    private int sudoku[][];

    public Sudoku() {
        sudoku = new int[9][9];
        this.limpiarSudoku();
    }

    public boolean resolverSudoku() {

        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[0].length; j++) {
                if (sudoku[i][j] == 0) {
                    for (int valor = 1; valor <= 9; valor++) {
                        if (this.validarFila(i, valor) && this.validarColumna(j, valor) && this.validarCuadrante(i, j, valor)) {
                            sudoku[i][j] = valor;
                            if (resolverSudoku()) {
                                return true;
                            }
                            sudoku[i][j] = 0;
                            //Backtraking
                        }
                    }
                    return false;
                }
            }
        }
        return true;

    }

    public boolean validarFila(int i, int valor) {
        boolean vf = true;
        for (int j = 0; j < sudoku[i].length; j++) {
            if (sudoku[i][j] == valor) {
                vf = false;
            }
        }
        return vf;
    }

    public boolean validarColumna(int j, int valor) {
        boolean vc = true;
        for (int i = 0; i < sudoku.length; i++) {
            if (sudoku[i][j] == valor) {
                vc = false;
            }
        }
        return vc;
    }

    public boolean validarCuadrante(int i, int j, int valor) {
        boolean b = true;
        int posi = subCuadranteAct(i);
        int posj = subCuadranteAct(j);
        for (int k = posi - 3; k < posi; k++) {
            for (int l = posj - 3; l < posj; l++) {
                if (sudoku[k][l] == valor) {
                    b = false;
                }
            }
        }
        return b;
    }

    public int subCuadranteAct(int pos) {
        int v = 0;
        if (pos <= 2) {
            v = 3;
        } else if (pos <= 5) {
            v = 6;
        } else {
            v = 9;
        }
        return v;
    }

    public void limpiarSudoku() {
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[0].length; j++) {
                sudoku[i][j] = 0;
            }
        }

    }

    public void generarSudoku(int nivel) {
        this.limpiarSudoku();
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int num = random.nextInt(9) + 1;
                if (this.validarCuadrante(i, j, num)) {
                    sudoku[i][j] = num;
                } else {
                    j--;
                }
            }
        }
        for (int i = 3; i < 6; i++) {
            for (int j = 3; j < 6; j++) {
                int num = random.nextInt(9) + 1;
                if (this.validarCuadrante(i, j, num)) {
                    sudoku[i][j] = num;
                } else {
                    j--;
                }
            }
        }
        for (int i = 6; i < 9; i++) {
            for (int j = 6; j < 9; j++) {
                int num = random.nextInt(9) + 1;
                if (this.validarCuadrante(i, j, num)) {
                    sudoku[i][j] = num;
                } else {
                    j--;
                }
            }
        }
        this.resolverSudoku();
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[0].length; j++) {
                int aux = j;
                int ran = random.nextInt(nivel + 1);
                j += ran;
                for (int k = aux; k < j && k < sudoku.length; k++) {
                    sudoku[i][k] = 0;

                }
            }
        }
    }

    public boolean verificarSudoku(){
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[0].length; j++) {
                int aux=sudoku[i][j];
                sudoku[i][j]=0;
                if(!this.validarFila(i, aux)||!this.validarColumna(j, aux)||!this.validarCuadrante(i, j, aux)){
                    sudoku[i][j]=aux;
                    return false;
                }
                sudoku[i][j]=aux;
            }
        }
        return true;
    }
    
    public int[][] getSudoku() {
        return sudoku;
    }

    public void setSudoku(int[][] sudoku) {
        this.sudoku = sudoku;
    }

//    public void mostarsk(){
//        resolverSudoku();
//        for (int i = 0; i < sudoku.length; i++) {
//            for (int j = 0; j < sudoku[0].length; j++) {
//                System.out.print(sudoku[i][j]);
//                if(!(j==sudoku[0].length-1))System.out.print(" - ");
//            }
//            System.out.println();
//        }
//    }
}
