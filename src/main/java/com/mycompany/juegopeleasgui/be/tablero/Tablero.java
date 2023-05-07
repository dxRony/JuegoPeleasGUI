package com.mycompany.juegopeleasgui.be.tablero;

import com.mycompany.juegopeleasgui.be.Casilla;
import com.mycompany.juegopeleasgui.be.terrenos.Agua;
import com.mycompany.juegopeleasgui.be.terrenos.Arbol;
import com.mycompany.juegopeleasgui.be.terrenos.Lava;
import com.mycompany.juegopeleasgui.be.terrenos.Planicie;
import com.mycompany.juegopeleasgui.fe.AbrirTablero;
import java.awt.Toolkit;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Tablero {

    private String ruta = "tableros.txt";

    private Casilla casillas[][];
    private int filas;
    private int columnas;
    private String nombre;

    public Tablero(String id, int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.casillas = new Casilla[filas][columnas];
    }

    public JButton[][] crearTablero() {
        int tamaño = 100;
        int posicionX = 10;
        int posicionY = 10;
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                casillas[i][j] = new Casilla(tamaño);
                casillas[i][j].setBounds(posicionX, posicionY, 100, 100);
                AbrirTablero panelNueva = new AbrirTablero();
                panelNueva.mostrarTablero(casillas);
                posicionX += 160;
            }
            posicionX = 10;
            posicionY += 70;
        }
        return casillas;
    }

    public void crearTableroVacio() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                casillas[i][j] = new Casilla(((int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / casillas.length)) * 2 / 3);
                casillas[i][j].setPosicionX(j);
                casillas[i][j].setPosicionY(i);
            }
        }
        System.out.println("filas = " + filas);
        System.out.println("columnas = " + columnas);
    }

    public boolean agregarLinea(String linea, int posicion) throws IOException {
        String[] caracteres = linea.split(",");
        int agua = 0;
        int arbol = 0;
        int lava = 0;
        int planicie = 0;
        try {
            if (caracteres.length <= columnas) {
                if (posicion <= filas) {
                    for (int i = 0; i < caracteres.length; i++) {
                        System.out.print(caracteres[i]);

                        if (caracteres[i].equals("~")) {
                            casillas[posicion][i] = new Agua(((int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / casillas.length)) * 2 / 3);
                            agua++;
                        } else if (caracteres[i].equals("T")) {
                            casillas[posicion][i] = new Arbol(((int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / casillas.length)) * 2 / 3);
                            arbol++;
                        } else if (caracteres[i].equals("#")) {
                            casillas[posicion][i] = new Lava(((int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / casillas.length)) * 2 / 3);
                            lava++;
                        } else if (caracteres[i].equals("-")) {
                            casillas[posicion][i] = new Planicie(((int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / casillas.length)) * 2 / 3);
                            planicie++;
                        }
                    }
                }
                System.out.println("\nplanicie = " + planicie);
                System.out.println("agua = " + agua);
                System.out.println("lava = " + lava);
                System.out.println("arbol = " + arbol);
            }
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Unexpected error");
            return false;
        }
        return true;
    }

    public void pintarMapa() {
        System.out.println("filas = " + filas);
        System.out.println("columnas = " + columnas);
        System.out.println("El tablero de juego es...");
        for (int x = 0; x < columnas; x++) {
            for (int y = 0; y < filas; y++) {
                System.out.print(casillas[x][y] + " ");
            }
            System.out.println();
        }
    }

    public void getId(String id) {
        this.nombre = id;
    }
}
