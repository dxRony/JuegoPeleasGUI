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
    private Casilla boton;
    private int filas;
    private int columnas;
    private int indiceMapas = 0;
    private String nombre;
    private int indiceNombre = 0;

    public Tablero(String id, int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.casillas = new Casilla[filas][columnas];
    }

    public boolean crearCasillas(String[] lineas) throws IOException {
        try {
            for (int i = 0; i < lineas.length; i++) {
                String[] caracteres = lineas[i].split(",");
                for (int j = 0; j < caracteres.length; j++) {
                    casillas[i][j] = new Casilla(((int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / casillas.length)) * 2 / 3);
                    casillas[i][j].setPosicionX(j);
                    casillas[i][j].setPosicionY(i);

                    if (caracteres[j].equals("~")) {
                        casillas[i][j] = new Agua(((int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / casillas.length)) * 2 / 3);

                    } else if (caracteres[j].equals("T")) {
                        casillas[i][j] = new Arbol(((int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / casillas.length)) * 2 / 3);

                    } else if (caracteres[i].equals("#")) {
                        casillas[i][j] = new Lava(((int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / casillas.length)) * 2 / 3);

                    } else if (caracteres[i].equals("-")) {
                        casillas[i][j] = new Planicie(((int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / casillas.length)) * 2 / 3);
                    }
                }
                AbrirTablero panelNueva = new AbrirTablero();
                panelNueva.mostrarTablero(casillas);
            }
        } catch (IndexOutOfBoundsException ie) {
            JOptionPane.showMessageDialog(null, "Unexpected error");
            return false;
        }
        return true;
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

    public void guardarId(String id) {
        this.nombre = id;
    }
}
