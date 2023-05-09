package com.mycompany.juegopeleasgui.be.tablero;

import com.mycompany.juegopeleasgui.be.Casilla;
import com.mycompany.juegopeleasgui.be.inventarios.ListaGenerica;
import com.mycompany.juegopeleasgui.be.jugadores.IA;
import com.mycompany.juegopeleasgui.be.jugadores.Usuario;
import com.mycompany.juegopeleasgui.be.personajes.Jugable;
import com.mycompany.juegopeleasgui.be.personajes.NoJugable;
import com.mycompany.juegopeleasgui.be.terrenos.Agua;
import com.mycompany.juegopeleasgui.be.terrenos.Arbol;
import com.mycompany.juegopeleasgui.be.terrenos.Lava;
import com.mycompany.juegopeleasgui.be.terrenos.Planicie;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Tablero {

    private String ruta = "tableros.txt";

    private Casilla casillas[][];
    private int filas;
    private int columnas;
    private String nombre;
    private Random random;
    private Usuario usuario;
    private IA ia;
    private Scanner leer;
    private int dificultad;
    private ListaGenerica<NoJugable> inventarioIA;
    private Jugable personajePrincipalUsuario;
    private NoJugable personajePrincipalIA;
    private NoJugable[] listaEnemigos;

    private String posicionJugador;
    private int posicionYJugador;
    private int posicionXJugador;

    private String posicionEnemigo;
    private int posicionYEnemigo;
    private int posicionXEnemigo;

    private String posicionEnemigo1;
    private int posicionYEnemigo1;
    private int posicionXEnemigo1;

    private String posicionEnemigo2;
    private int posicionYEnemigo2;
    private int posicionXEnemigo2;

    private String posicionEnemigo3;
    private int posicionYEnemigo3;
    private int posicionXEnemigo3;

    private String posicionEnemigo4;
    private int posicionYEnemigo4;
    private int posicionXEnemigo4;

    private String posicionEnemigo5;
    private int posicionYEnemigo5;
    private int posicionXEnemigo5;

    private String posicionEnemigo6;
    private int posicionYEnemigo6;
    private int posicionXEnemigo6;

    private String posicionEnemigo7;
    private int posicionYEnemigo7;
    private int posicionXEnemigo7;

    private String posicionEnemigo8;
    private int posicionYEnemigo8;
    private int posicionXEnemigo8;

    public Tablero(Usuario usuario, IA ia, String id, int filas, int columnas) {
        this.casillas = new Casilla[filas][columnas];
        this.filas = filas;
        this.columnas = columnas;
        this.usuario = usuario;
        this.ia = ia;
        random = new Random();
        leer = new Scanner(System.in);
        inventarioIA = ia.getInventarioIA();
        personajePrincipalUsuario = usuario.getPersonajePrincipalUsuario();
        personajePrincipalIA = ia.getPersonajePrincipalIA();
        listaEnemigos = ia.getListaEnemigos();
        dificultad = ia.getDificultad();
    }

    public void crearTableroVacio() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                casillas[i][j] = new Casilla(((int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / casillas.length)) * 2 / 3);
                casillas[i][j].setPosicionX(j);
                casillas[i][j].setPosicionY(i);
            }
        }
    }

    public boolean agregarLineas(String linea, int posicion, int dificultad) throws IOException {
        dificultad = this.dificultad;
        String[] caracteres = linea.split(",");
        try {
            if (caracteres.length <= columnas) {
                if (posicion <= filas) {
                    for (int i = 0; i < caracteres.length; i++) {
                        if (caracteres[i].equals("~")) {
                            casillas[posicion][i] = new Agua(((int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / casillas.length)) * 2 / 3);
                        } else if (caracteres[i].equals("T")) {
                            casillas[posicion][i] = new Arbol(((int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / casillas.length)) * 2 / 3);
                        } else if (caracteres[i].equals("#")) {
                            casillas[posicion][i] = new Lava(((int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / casillas.length)) * 2 / 3);
                        } else if (caracteres[i].equals("-")) {
                            casillas[posicion][i] = new Planicie(((int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / casillas.length)) * 2 / 3);
                        }
                    }
                }
            }
            generarPersonajes(ia.getDificultad());
            crearPosiciones(ia.getDificultad());
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Unexpected error");
            return false;
        }
        return true;
    }

    public void pintarMapa() {
        System.out.println("El tablero de juego es...");
        for (int x = 0; x < columnas; x++) {
            for (int y = 0; y < filas; y++) {
                System.out.print(casillas[x][y] + " ");
            }
            System.out.println();
        }
    }

    public void anadirBotones(JPanel pnlJuego, JFrame pnlTableroDeJuego) {
        pnlJuego.setLayout(new GridLayout(filas, columnas));
        for (int i = 0; i < columnas; i++) {
            for (int j = 0; j < filas; j++) {
                pnlJuego.add(casillas[i][j]);
            }
        }
        pnlTableroDeJuego.getContentPane().add(pnlJuego);
        pnlTableroDeJuego.setVisible(true);
    }

    public void generarPersonajes(int dificultad) {
        casillas[7][8] = personajePrincipalUsuario;
        posicionJugador = "";
        posicionYJugador = 7;
        posicionXJugador = 8;
        if (dificultad == 1) {
            casillas[3][3] = listaEnemigos[4];
            casillas[4][4] = listaEnemigos[3];
            casillas[5][5] = listaEnemigos[2];
            posicionEnemigo1 = "";
            posicionYEnemigo1 = 3;
            posicionXEnemigo1 = 3;
            posicionEnemigo2 = "";
            posicionYEnemigo2 = 4;
            posicionXEnemigo2 = 4;
            posicionEnemigo3 = "";
            posicionYEnemigo3 = 5;
            posicionXEnemigo3 = 5;
        } else if (dificultad
                == 2) {
            casillas[3][3] = listaEnemigos[4];
            casillas[4][4] = listaEnemigos[3];
            casillas[5][5] = listaEnemigos[2];
            casillas[1][1] = listaEnemigos[1];
            posicionEnemigo1 = "";
            posicionYEnemigo1 = 3;
            posicionXEnemigo1 = 3;
            posicionEnemigo2 = "";
            posicionYEnemigo2 = 4;
            posicionXEnemigo2 = 4;
            posicionEnemigo3 = "";
            posicionYEnemigo3 = 5;
            posicionXEnemigo3 = 5;
            posicionEnemigo4 = "";
            posicionYEnemigo4 = 1;
            posicionXEnemigo4 = 1;
        } else if (dificultad
                == 3) {
            casillas[3][3] = listaEnemigos[4];
            casillas[4][4] = listaEnemigos[3];
            casillas[5][5] = listaEnemigos[2];
            casillas[1][1] = listaEnemigos[1];
            casillas[8][8] = listaEnemigos[0];
            posicionEnemigo1 = "";
            posicionYEnemigo1 = 3;
            posicionXEnemigo1 = 3;
            posicionEnemigo2 = "";
            posicionYEnemigo2 = 4;
            posicionXEnemigo2 = 4;
            posicionEnemigo3 = "";
            posicionYEnemigo3 = 5;
            posicionXEnemigo3 = 5;
            posicionEnemigo4 = "";
            posicionYEnemigo4 = 1;
            posicionXEnemigo4 = 1;
            posicionEnemigo5 = "";
            posicionYEnemigo5 = 8;
            posicionXEnemigo5 = 8;
        }
    }

    public void crearPosiciones(int dificultad) {
        posicionJugador = posicionYJugador + "" + posicionXJugador;
        posicionEnemigo = posicionYEnemigo + "" + posicionXEnemigo;
        if (dificultad == 1) {
            posicionEnemigo1 = posicionYEnemigo1 + "" + posicionXEnemigo1;
            posicionEnemigo2 = posicionYEnemigo2 + "" + posicionXEnemigo2;
        } else if (dificultad == 2) {
            posicionEnemigo1 = posicionYEnemigo1 + "" + posicionXEnemigo1;
            posicionEnemigo2 = posicionYEnemigo2 + "" + posicionXEnemigo2;
            posicionEnemigo3 = posicionYEnemigo3 + "" + posicionXEnemigo3;
        } else if (dificultad == 3) {
            posicionEnemigo1 = posicionYEnemigo1 + "" + posicionXEnemigo1;
            posicionEnemigo2 = posicionYEnemigo2 + "" + posicionXEnemigo2;
            posicionEnemigo3 = posicionYEnemigo3 + "" + posicionXEnemigo3;
            posicionEnemigo4 = posicionYEnemigo4 + "" + posicionXEnemigo4;
            posicionEnemigo5 = posicionYEnemigo5 + "" + posicionXEnemigo5;
        }
    }

    public void getId(String id) {
        this.nombre = id;
    }

    public Casilla[][] getCasillas() {
        return casillas;
    }

}
