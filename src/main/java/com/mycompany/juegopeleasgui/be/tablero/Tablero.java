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
        System.out.println("anadiendo botones");
        // pnlTableroDeJuego.getContentPane().add(pnlJuego);
        //pnlTableroDeJuego.setVisible(true);
    }

    public void generarPersonajes(int dificultad) {
        casillas[7][8] = personajePrincipalUsuario;
        posicionJugador = "";
        posicionYJugador = 7;
        posicionXJugador = 8;
        switch (dificultad) {
            case 1:
                inventarioIA.agregar(listaEnemigos[4]);
                inventarioIA.agregar(listaEnemigos[3]);
                inventarioIA.agregar(listaEnemigos[2]);
                casillas[3][3] = inventarioIA.seleccionar(0);
                casillas[4][4] = inventarioIA.seleccionar(1);
                casillas[5][5] = inventarioIA.seleccionar(2);
                posicionEnemigo1 = "";
                posicionYEnemigo1 = 3;
                posicionXEnemigo1 = 3;
                posicionEnemigo2 = "";
                posicionYEnemigo2 = 4;
                posicionXEnemigo2 = 4;
                posicionEnemigo3 = "";
                posicionYEnemigo3 = 5;
                posicionXEnemigo3 = 5;
                break;
            case 2:
                inventarioIA.agregar(listaEnemigos[4]);
                inventarioIA.agregar(listaEnemigos[3]);
                inventarioIA.agregar(listaEnemigos[2]);
                inventarioIA.agregar(listaEnemigos[1]);
                casillas[3][3] = inventarioIA.seleccionar(0);
                casillas[4][4] = inventarioIA.seleccionar(1);
                casillas[5][5] = inventarioIA.seleccionar(2);
                casillas[1][1] = inventarioIA.seleccionar(3);
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
                break;
            case 3:
                inventarioIA.agregar(listaEnemigos[4]);
                inventarioIA.agregar(listaEnemigos[3]);
                inventarioIA.agregar(listaEnemigos[2]);
                inventarioIA.agregar(listaEnemigos[1]);
                inventarioIA.agregar(listaEnemigos[0]);
                casillas[3][3] = inventarioIA.seleccionar(0);
                casillas[4][4] = inventarioIA.seleccionar(1);
                casillas[5][5] = inventarioIA.seleccionar(2);
                casillas[1][1] = inventarioIA.seleccionar(3);
                casillas[8][8] = inventarioIA.seleccionar(4);
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
                break;
            default:
                break;
        }
    }

    public void crearPosiciones(int dificultad) {
        posicionJugador = posicionYJugador + "" + posicionXJugador;
        posicionEnemigo = posicionYEnemigo + "" + posicionXEnemigo;
        switch (dificultad) {
            case 1:
                posicionEnemigo1 = posicionYEnemigo1 + "" + posicionXEnemigo1;
                posicionEnemigo2 = posicionYEnemigo2 + "" + posicionXEnemigo2;
                posicionEnemigo1 = posicionYEnemigo1 + "" + posicionXEnemigo1;
                break;
            case 2:
                posicionEnemigo1 = posicionYEnemigo1 + "" + posicionXEnemigo1;
                posicionEnemigo2 = posicionYEnemigo2 + "" + posicionXEnemigo2;
                posicionEnemigo3 = posicionYEnemigo3 + "" + posicionXEnemigo3;
                posicionEnemigo4 = posicionYEnemigo4 + "" + posicionXEnemigo4;
                break;
            case 3:
                posicionEnemigo1 = posicionYEnemigo1 + "" + posicionXEnemigo1;
                posicionEnemigo2 = posicionYEnemigo2 + "" + posicionXEnemigo2;
                posicionEnemigo3 = posicionYEnemigo3 + "" + posicionXEnemigo3;
                posicionEnemigo4 = posicionYEnemigo4 + "" + posicionXEnemigo4;
                posicionEnemigo5 = posicionYEnemigo5 + "" + posicionXEnemigo5;
                break;
            default:
                break;
        }
    }

    public void moverJugadorY(boolean arriba) {

        boolean vuela = personajePrincipalUsuario.isVuela();
        int movimiento = personajePrincipalUsuario.getMovimiento();
        if (arriba == true) {//realiza el movimiento hacia arriba
            movimiento = movimiento * -1;
            int tmp1 = 0;
            tmp1 = Integer.parseInt(posicionJugador);

            while (posicionYJugador + movimiento < 0//verifica que los valores no sobrepasen la matriz
                    || casillas[posicionYJugador + movimiento][posicionXJugador] instanceof Arbol && posicionYJugador + movimiento < 0) {
                movimiento++;
            }
            while (posicionYJugador + movimiento >= filas
                    || casillas[posicionYJugador + movimiento][posicionXJugador] instanceof Arbol && posicionYJugador + movimiento >= filas) {
                movimiento--;
            }
            if (posicionYJugador + movimiento >= 0 && posicionYJugador + movimiento < filas) {
                if (casillas[posicionYJugador + movimiento][posicionXJugador] instanceof Planicie
                        || casillas[posicionYJugador + movimiento][posicionXJugador] instanceof Agua && vuela == true
                        || casillas[posicionYJugador + movimiento][posicionXJugador] instanceof Arbol && vuela == true) {//verifica que la siguiente casilla sea campo
                    casillas[posicionYJugador][posicionXJugador] = new Planicie(((int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / casillas.length)) * 2 / 3);;//reemplaza la casilla por campo, de donde se movio el vehiculo
                    casillas[posicionYJugador + movimiento][posicionXJugador] = personajePrincipalUsuario;//cambia al vehiculo del jugador a la nueva posicion

                    tmp1 = tmp1 + (movimiento * 10);
                    if (tmp1 < 10) {
                        posicionJugador = 0 + "" + tmp1;
                    } else {
                        posicionJugador = String.valueOf(tmp1);
                    }
                    posicionYJugador = tmp1 / 10;
                    posicionXJugador = tmp1 % 10;
                }
            }
            movimiento = movimiento * -1;
            System.out.println("Te moviste: " + movimiento + " casillas en direccion al norte");
        } else if (arriba == false) {//realiza el movimiento hacia abajo
            int tmp1 = 0;
            tmp1 = Integer.parseInt(posicionJugador);

            while (posicionYJugador + movimiento < 0
                    || casillas[posicionYJugador + movimiento][posicionXJugador] instanceof Arbol && posicionYJugador + movimiento < 0) {
                movimiento++;
            }
            while (posicionYJugador + movimiento >= filas
                    || casillas[posicionYJugador + movimiento][posicionXJugador] instanceof Arbol && posicionYJugador + movimiento >= filas) {
                movimiento--;
            }
            if (posicionYJugador + movimiento >= 0 && posicionYJugador + movimiento < filas) {
                if (casillas[posicionYJugador + movimiento][posicionXJugador] instanceof Planicie
                        || casillas[posicionYJugador + movimiento][posicionXJugador] instanceof Agua && vuela == true
                        || casillas[posicionYJugador + movimiento][posicionXJugador] instanceof Arbol && vuela == true) {
                    casillas[posicionYJugador][posicionXJugador] = new Planicie(((int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / casillas.length)) * 2 / 3);;
                    casillas[posicionYJugador + movimiento][posicionXJugador] = personajePrincipalUsuario;

                    tmp1 = tmp1 + (movimiento * 10);
                    if (tmp1 < 10) {
                        posicionJugador = 0 + "" + tmp1;
                    } else {
                        posicionJugador = String.valueOf(tmp1);
                    }
                    posicionYJugador = tmp1 / 10;
                    posicionXJugador = tmp1 % 10;
                }
            }
            System.out.println("Te moviste: " + movimiento + " casillas en direccion al sur");
        }
    }

    public void moverJugadorX(boolean derecha) {
        int movimiento = personajePrincipalUsuario.getMovimiento();
        boolean vuela = personajePrincipalUsuario.isVuela();
        if (derecha == true) {//realiza el movimiento hacia la derecha
            int tmp1 = 0;
            tmp1 = Integer.parseInt(posicionJugador);//convierte la posicion en un int
            while (posicionXJugador + movimiento < 0
                    || casillas[posicionYJugador][posicionXJugador + movimiento] instanceof Arbol && posicionXJugador + movimiento < 0) {
                movimiento++;
            }
            while (posicionXJugador + movimiento >= columnas
                    || casillas[posicionYJugador][posicionXJugador + movimiento] instanceof Arbol && posicionXJugador + movimiento >= columnas) {
                movimiento--;
            }
            if (posicionXJugador + movimiento >= 0 && posicionXJugador + movimiento < columnas) {
                if (casillas[posicionYJugador][posicionXJugador + movimiento] instanceof Planicie
                        || casillas[posicionYJugador][posicionXJugador + movimiento] instanceof Agua && vuela == true
                        || casillas[posicionYJugador][posicionXJugador + movimiento] instanceof Arbol && vuela == true) {

                    casillas[posicionYJugador][posicionXJugador] = new Planicie(((int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / casillas.length)) * 2 / 3);;
                    casillas[posicionYJugador][posicionXJugador + movimiento] = personajePrincipalUsuario;
                    tmp1 = tmp1 + (movimiento);
                    if (tmp1 < 10) {
                        posicionJugador = 0 + "" + tmp1;
                    } else {
                        posicionJugador = String.valueOf(tmp1);
                    }
                    posicionYJugador = tmp1 / 10;
                    posicionXJugador = tmp1 % 10;
                }
            }
            System.out.println("Te moviste: " + movimiento + " casillas en direccion al este");

        } else if (derecha == false) {//realiza el movimiento hacia la izquierda
            movimiento = movimiento * -1;
            int tmp1 = 0;
            tmp1 = Integer.parseInt(posicionJugador);

            while (posicionXJugador + movimiento < 0
                    || casillas[posicionYJugador][posicionXJugador + movimiento] instanceof Arbol && posicionXJugador + movimiento < 0) {
                movimiento++;
            }
            while (posicionXJugador + movimiento >= columnas
                    || casillas[posicionYJugador][posicionXJugador + movimiento] instanceof Arbol && posicionXJugador + movimiento >= columnas) {
                movimiento--;
            }
            if (posicionXJugador + movimiento >= 0 && posicionXJugador + movimiento < columnas) {
                if (casillas[posicionYJugador][posicionXJugador + movimiento] instanceof Planicie
                        || casillas[posicionYJugador][posicionXJugador + movimiento] instanceof Agua && vuela == true
                        || casillas[posicionYJugador][posicionXJugador + movimiento] instanceof Arbol && vuela == true) {

                    casillas[posicionYJugador][posicionXJugador] = new Planicie(((int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / casillas.length)) * 2 / 3);
                    casillas[posicionYJugador][posicionXJugador + movimiento] = personajePrincipalUsuario;

                    tmp1 = tmp1 + (movimiento);
                    if (tmp1 < 10) {
                        posicionJugador = 0 + "" + tmp1;
                    } else {
                        posicionJugador = String.valueOf(tmp1);
                    }
                    posicionYJugador = tmp1 / 10;
                    posicionXJugador = tmp1 % 10;
                }
            }
            movimiento = movimiento * -1;
            System.out.println("Te moviste: " + movimiento + " casillas en direccion al oeste");
        }
    }

    public void moverEnemigosX(boolean derecha, int personajeMueve) {
        switch (personajeMueve + 1) {
            case 1:
                if (inventarioIA.seleccionar(0).getPuntosDeVida() > 0) {
                    personajePrincipalIA = inventarioIA.seleccionar(0);
                    posicionYEnemigo = posicionYEnemigo1;
                    posicionXEnemigo = posicionXEnemigo1;
                    posicionEnemigo = posicionYEnemigo + "" + posicionXEnemigo;
                }
                break;
            case 2:
                if (inventarioIA.seleccionar(1).getPuntosDeVida() > 0) {
                    personajePrincipalIA = inventarioIA.seleccionar(1);
                    posicionYEnemigo = posicionYEnemigo2;
                    posicionXEnemigo = posicionXEnemigo2;
                    posicionEnemigo = posicionYEnemigo + "" + posicionXEnemigo;
                }
                break;
            case 3:
                if (inventarioIA.seleccionar(2).getPuntosDeVida() > 0) {
                    personajePrincipalIA = inventarioIA.seleccionar(2);
                    posicionYEnemigo = posicionYEnemigo3;
                    posicionXEnemigo = posicionXEnemigo3;
                    posicionEnemigo = posicionYEnemigo + "" + posicionXEnemigo;
                }
                break;
            case 4:
                if (inventarioIA.seleccionar(3).getPuntosDeVida() > 0) {
                    personajePrincipalIA = inventarioIA.seleccionar(3);
                    posicionYEnemigo = posicionYEnemigo4;
                    posicionXEnemigo = posicionXEnemigo4;
                    posicionEnemigo = posicionYEnemigo + "" + posicionXEnemigo;
                }
                break;
            case 5:
                if (inventarioIA.seleccionar(4).getPuntosDeVida() > 0) {
                    personajePrincipalIA = inventarioIA.seleccionar(4);
                    posicionYEnemigo = posicionYEnemigo5;
                    posicionXEnemigo = posicionXEnemigo5;
                    posicionEnemigo = posicionYEnemigo + "" + posicionXEnemigo;
                }
                break;
            default:
                break;
        }
        System.out.println("personajePrincipalIA(vida)=" + personajePrincipalIA.getPuntosDeVida());
        System.out.println("personajeMueve = " + personajeMueve);
        System.out.println("personajePrincipalIA = " + personajePrincipalIA.getNombre());
        if (personajePrincipalIA.getPuntosDeVida() > 0) {
            int movimiento = personajePrincipalIA.getMovimiento();
            boolean vuela = personajePrincipalIA.isVuela();
            if (derecha == true) {
                int tmp1 = 0;
                posicionEnemigo = posicionYEnemigo + "" + posicionXEnemigo;//suma la posicion "X" y "Y", para hacerlos un numero unico
                tmp1 = Integer.parseInt(posicionEnemigo);//convierte la posicion en un int

                while (posicionXEnemigo + movimiento < 0
                        || casillas[posicionYEnemigo][posicionXEnemigo + movimiento] instanceof Arbol && posicionXEnemigo + movimiento < 0) {
                    movimiento++;
                }

                while (posicionXEnemigo + movimiento >= columnas
                        || casillas[posicionYEnemigo][posicionXEnemigo + movimiento] instanceof Arbol && posicionXEnemigo + movimiento >= columnas) {
                    movimiento--;
                }
                if (posicionXEnemigo + movimiento >= 0 && posicionXEnemigo + movimiento < columnas) {
                    if (casillas[posicionYEnemigo][posicionXEnemigo + movimiento] instanceof Planicie
                            || casillas[posicionYEnemigo][posicionXEnemigo + movimiento] instanceof Agua && vuela == true
                            || casillas[posicionYEnemigo][posicionXEnemigo + movimiento] instanceof Arbol && vuela == true) {

                        casillas[posicionYEnemigo][posicionXEnemigo] = new Planicie(((int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / casillas.length)) * 2 / 3);
                        casillas[posicionYEnemigo][posicionXEnemigo + movimiento] = personajePrincipalIA;
                        tmp1 = tmp1 + (movimiento);
                        if (tmp1 < 10) {
                            posicionEnemigo = 0 + "" + tmp1;
                        } else {
                            posicionEnemigo = String.valueOf(tmp1);
                        }
                        posicionYEnemigo = tmp1 / 10;
                        posicionXEnemigo = tmp1 % 10;
                    }
                }
                System.out.println(personajePrincipalIA + " se movio: " + movimiento + " casillas en direccion al este");
            } else if (derecha == false) {
                movimiento = movimiento * -1;
                int tmp1 = 0;
                posicionEnemigo = posicionYEnemigo + "" + posicionXEnemigo;//suma la posicion "X" y "Y", para hacerlos un numero unico
                tmp1 = Integer.parseInt(posicionEnemigo);//convierte la posicion en un int
                while (posicionXEnemigo + movimiento < 0
                        || casillas[posicionYEnemigo][posicionXEnemigo + movimiento] instanceof Arbol && posicionXEnemigo + movimiento < 0) {
                    movimiento++;
                }
                while (posicionXEnemigo + movimiento >= columnas
                        || casillas[posicionYEnemigo][posicionXEnemigo + movimiento] instanceof Arbol && posicionXEnemigo + movimiento >= columnas) {
                    movimiento--;
                }
                if (posicionXEnemigo + movimiento >= 0 && posicionXEnemigo + movimiento < columnas) {
                    if (casillas[posicionYEnemigo][posicionXEnemigo + movimiento] instanceof Planicie
                            || casillas[posicionYEnemigo][posicionXEnemigo + movimiento] instanceof Agua && vuela == true
                            || casillas[posicionYEnemigo][posicionXEnemigo + movimiento] instanceof Arbol && vuela == true) {

                        casillas[posicionYEnemigo][posicionXEnemigo] = new Planicie(((int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / casillas.length)) * 2 / 3);
                        casillas[posicionYEnemigo][posicionXEnemigo + movimiento] = personajePrincipalIA;

                        tmp1 = tmp1 + (movimiento);
                        if (tmp1 < 10) {
                            posicionEnemigo = 0 + "" + tmp1;
                        } else {
                            posicionEnemigo = String.valueOf(tmp1);
                        }
                        posicionYEnemigo = tmp1 / 10;
                        posicionXEnemigo = tmp1 % 10;
                    }
                }
                movimiento = movimiento * -1;
                System.out.println(personajePrincipalIA + " se movio: " + movimiento + " casillas en direccion al oeste");
            }
        }
        if (personajeMueve == 1) {
            posicionYEnemigo1 = posicionYEnemigo;
            posicionXEnemigo1 = posicionXEnemigo;
            posicionEnemigo1 = posicionYEnemigo1 + "" + posicionXEnemigo1;
            ataqueEnemigosY(true, 1);
            ataqueEnemigosY(false, 1);
            ataqueEnemigosX(true, 1);
            ataqueEnemigosX(false, 1);
        } else if (personajeMueve == 2) {
            posicionYEnemigo2 = posicionYEnemigo;
            posicionXEnemigo2 = posicionXEnemigo;
            posicionEnemigo2 = posicionYEnemigo2 + "" + posicionXEnemigo2;
            ataqueEnemigosY(true, 2);
            ataqueEnemigosY(false, 2);
            ataqueEnemigosX(true, 2);
            ataqueEnemigosX(false, 2);
        } else if (personajeMueve == 3) {
            posicionYEnemigo3 = posicionYEnemigo;
            posicionXEnemigo3 = posicionXEnemigo;
            posicionEnemigo3 = posicionYEnemigo3 + "" + posicionXEnemigo3;
            ataqueEnemigosY(true, 3);
            ataqueEnemigosY(false, 3);
            ataqueEnemigosX(true, 3);
            ataqueEnemigosX(false, 3);
        } else if (personajeMueve == 4) {
            posicionYEnemigo4 = posicionYEnemigo;
            posicionXEnemigo4 = posicionXEnemigo;
            posicionEnemigo4 = posicionYEnemigo4 + "" + posicionXEnemigo4;
            ataqueEnemigosY(true, 4);
            ataqueEnemigosY(false, 4);
            ataqueEnemigosX(true, 4);
            ataqueEnemigosX(false, 4);
        } else if (personajeMueve == 5) {
            posicionYEnemigo5 = posicionYEnemigo;
            posicionXEnemigo5 = posicionXEnemigo;
            posicionEnemigo5 = posicionYEnemigo5 + "" + posicionXEnemigo5;
            ataqueEnemigosY(true, 5);
            ataqueEnemigosY(false, 5);
            ataqueEnemigosX(true, 5);
            ataqueEnemigosX(false, 5);
        }

        personajePrincipalIA = listaEnemigos[5];
    }

    public void moverEnemigosY(boolean arriba, int personajeMueve) {
        switch (personajeMueve + 1) {
            case 1:
                if (inventarioIA.seleccionar(0).getPuntosDeVida() > 0) {
                    personajePrincipalIA = inventarioIA.seleccionar(0);
                    posicionYEnemigo = posicionYEnemigo1;
                    posicionXEnemigo = posicionXEnemigo1;
                    posicionEnemigo = posicionYEnemigo1 + "" + posicionXEnemigo1;
                }
                break;
            case 2:
                if (inventarioIA.seleccionar(1).getPuntosDeVida() > 0) {
                    personajePrincipalIA = inventarioIA.seleccionar(1);
                    posicionYEnemigo = posicionYEnemigo2;
                    posicionXEnemigo = posicionXEnemigo2;
                    posicionEnemigo = posicionYEnemigo2 + "" + posicionXEnemigo2;
                }
                break;
            case 3:
                if (inventarioIA.seleccionar(2).getPuntosDeVida() > 0) {
                    personajePrincipalIA = inventarioIA.seleccionar(2);
                    posicionYEnemigo = posicionYEnemigo3;
                    posicionXEnemigo = posicionXEnemigo3;
                    posicionEnemigo = posicionYEnemigo3 + "" + posicionXEnemigo3;
                }
                break;
            case 4:
                if (inventarioIA.seleccionar(3).getPuntosDeVida() > 0) {
                    personajePrincipalIA = inventarioIA.seleccionar(3);
                    posicionYEnemigo = posicionYEnemigo4;
                    posicionXEnemigo = posicionXEnemigo4;
                    posicionEnemigo = posicionYEnemigo4 + "" + posicionXEnemigo4;
                }
                break;
            case 5:
                if (inventarioIA.seleccionar(4).getPuntosDeVida() > 0) {
                    personajePrincipalIA = inventarioIA.seleccionar(4);
                    posicionYEnemigo = posicionYEnemigo5;
                    posicionXEnemigo = posicionXEnemigo5;
                    posicionEnemigo = posicionYEnemigo5 + "" + posicionXEnemigo5;
                }
                break;
            default:
                break;
        }
        System.out.println("personajePrincipalIA(vida)=" + personajePrincipalIA.getPuntosDeVida());
        System.out.println("personajeMueve = " + personajeMueve);
        System.out.println("personajePrincipalIA = " + personajePrincipalIA.getNombre());
        if (personajePrincipalIA.getPuntosDeVida() > 0) {
            boolean vuela = personajePrincipalIA.isVuela();
            int movimiento = personajePrincipalIA.getMovimiento();
            if (arriba == true) {
                movimiento = movimiento * -1;
                int tmp1 = 0;
                tmp1 = Integer.parseInt(posicionEnemigo);//convierte la posicion en un int
                while (posicionYEnemigo + movimiento < 0
                        || casillas[posicionYEnemigo + movimiento][posicionXEnemigo] instanceof Arbol && posicionYEnemigo + movimiento < 0) {
                    movimiento++;
                }
                while (posicionYEnemigo + movimiento >= filas
                        || casillas[posicionYEnemigo + movimiento][posicionXEnemigo] instanceof Arbol && posicionYEnemigo + movimiento >= filas) {
                    movimiento--;
                }
                if (posicionYEnemigo + movimiento >= 0 && posicionYEnemigo + movimiento < filas) {
                    if (casillas[posicionYEnemigo + movimiento][posicionXEnemigo] instanceof Planicie
                            || casillas[posicionYEnemigo + movimiento][posicionXEnemigo] instanceof Agua && vuela == true
                            || casillas[posicionYEnemigo + movimiento][posicionXEnemigo] instanceof Arbol && vuela == true) {//verifica que la siguiente casilla sea campo
                        casillas[posicionYEnemigo][posicionXEnemigo] = new Planicie(((int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / casillas.length)) * 2 / 3);//reemplaza la casilla por campo, de donde se movio el vehiculo
                        casillas[posicionYEnemigo + movimiento][posicionXEnemigo] = personajePrincipalIA;//cambia al vehiculo del jugador a la nueva posicion

                        tmp1 = tmp1 + (movimiento * 10);
                        if (tmp1 < 10) {//pasa el valor de la posicion de int a string
                            posicionEnemigo = 0 + "" + tmp1;
                        } else {
                            posicionEnemigo = String.valueOf(tmp1);
                        }
                        posicionYEnemigo = tmp1 / 10;//individualiza la posicion del vehiculo en el eje "Y"
                        posicionXEnemigo = tmp1 % 10;//individualiza la posicion del vehiculo en el eje "X"
                    }
                }
                movimiento = movimiento * -1;
                System.out.println(personajePrincipalIA + " se movio: " + movimiento + " casillas en direccion al norte");
            } else if (arriba == false) {
                int tmp1 = 0;
                posicionEnemigo = posicionYEnemigo + "" + posicionXEnemigo;//suma la posicion "X" y "Y", para hacerlos un numero unico
                tmp1 = Integer.parseInt(posicionEnemigo);//convierte la posicion en un int
                while (posicionYEnemigo + movimiento >= filas
                        || casillas[posicionYEnemigo + movimiento][posicionXEnemigo] instanceof Arbol && posicionYEnemigo + movimiento >= filas) {
                    movimiento--;
                }
                if (posicionYEnemigo + movimiento >= 0 && posicionYEnemigo + movimiento < filas) {
                    if (casillas[posicionYEnemigo + movimiento][posicionXEnemigo] instanceof Planicie
                            || casillas[posicionYEnemigo + movimiento][posicionXEnemigo] instanceof Agua && vuela == true
                            || casillas[posicionYEnemigo + movimiento][posicionXEnemigo] instanceof Arbol && vuela == true) {//verifica que la siguiente casilla sea campo
                        casillas[posicionYEnemigo][posicionXEnemigo] = new Planicie(((int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / casillas.length)) * 2 / 3);//reemplaza la casilla por campo, de donde se movio el vehiculo
                        casillas[posicionYEnemigo + movimiento][posicionXEnemigo] = personajePrincipalIA;//cambia al vehiculo del jugador a la nueva posicion

                        tmp1 = tmp1 + (movimiento * 10);//modifica el valor de la posicion del vehiculo
                        if (tmp1 < 10) {//pasa el valor de la posicion de int a string
                            posicionEnemigo = 0 + "" + tmp1;
                        } else {
                            posicionEnemigo = String.valueOf(tmp1);
                        }
                        posicionYEnemigo = tmp1 / 10;//individualiza la posicion del vehiculo en el eje "Y"
                        posicionXEnemigo = tmp1 % 10;//individualiza la posicion del vehiculo en el eje "X"
                    }
                }
                System.out.println(personajePrincipalIA + " se movio: " + movimiento + " casillas en direccion al sur");
            }
        }
        if (personajeMueve == 1) {
            posicionYEnemigo1 = posicionYEnemigo;
            posicionXEnemigo1 = posicionXEnemigo;
            posicionEnemigo1 = posicionYEnemigo1 + "" + posicionXEnemigo1;
            ataqueEnemigosY(true, 1);
            ataqueEnemigosY(false, 1);
            ataqueEnemigosX(true, 1);
            ataqueEnemigosX(false, 1);
        } else if (personajeMueve == 2) {
            posicionYEnemigo2 = posicionYEnemigo;
            posicionXEnemigo2 = posicionXEnemigo;
            posicionEnemigo2 = posicionYEnemigo2 + "" + posicionXEnemigo2;
            ataqueEnemigosY(true, 2);
            ataqueEnemigosY(false, 2);
            ataqueEnemigosX(true, 2);
            ataqueEnemigosX(false, 2);
        } else if (personajeMueve == 3) {
            posicionYEnemigo3 = posicionYEnemigo;
            posicionXEnemigo3 = posicionXEnemigo;
            posicionEnemigo3 = posicionYEnemigo3 + "" + posicionXEnemigo3;
            ataqueEnemigosY(true, 3);
            ataqueEnemigosY(false, 3);
            ataqueEnemigosX(true, 3);
            ataqueEnemigosX(false, 3);
        } else if (personajeMueve == 4) {
            posicionYEnemigo4 = posicionYEnemigo;
            posicionXEnemigo4 = posicionXEnemigo;
            posicionEnemigo4 = posicionYEnemigo4 + "" + posicionXEnemigo4;
            ataqueEnemigosY(true, 4);
            ataqueEnemigosY(false, 4);
            ataqueEnemigosX(true, 4);
            ataqueEnemigosX(false, 4);
        } else if (personajeMueve == 5) {
            posicionYEnemigo5 = posicionYEnemigo;
            posicionXEnemigo5 = posicionXEnemigo;
            posicionEnemigo5 = posicionYEnemigo5 + "" + posicionXEnemigo5;
            ataqueEnemigosY(true, 5);
            ataqueEnemigosY(false, 5);
            ataqueEnemigosX(true, 5);
            ataqueEnemigosX(false, 5);
        }
        personajePrincipalIA = listaEnemigos[5];
    }

    public void ataqueJugadorY(boolean arriba) {
        int distanciaAtaque = personajePrincipalUsuario.getDistanciaAtaque();
        if (arriba == true) {
            System.out.println("Atacaste al enemigo en direccion al norte");
            distanciaAtaque = distanciaAtaque * -1;
            while (posicionYJugador + distanciaAtaque < 0) {
                distanciaAtaque++;
            }
            while (posicionYJugador + distanciaAtaque >= filas) {
                distanciaAtaque--;
            }
            for (int i = posicionYJugador; i >= posicionYJugador + distanciaAtaque; i--) {//posicion y-1?
                if (casillas[i][posicionXJugador] instanceof NoJugable) {
                    NoJugable enemigoGolpeado = (NoJugable) casillas[i][posicionXJugador];//casteo
                    if (casillas[i][posicionXJugador] instanceof NoJugable) {
                        enemigoGolpeado = (NoJugable) casillas[i][posicionXJugador];
                    }
                    personajePrincipalUsuario.ataque(enemigoGolpeado);
                }
            }
        } else if (arriba == false) {
            System.out.println("Atacaste al enemigo en direccion al sur");
            while (posicionYJugador + distanciaAtaque < 0) {
                distanciaAtaque++;
            }
            while (posicionYJugador + distanciaAtaque >= filas) {
                distanciaAtaque--;
            }
            for (int i = posicionYJugador; i <= posicionYJugador + distanciaAtaque; i++) {//posicion y-1?
                if (casillas[i][posicionXJugador] instanceof NoJugable) {
                    NoJugable enemigoGolpeado = (NoJugable) casillas[i][posicionXJugador];//casteo
                    if (casillas[i][posicionXJugador] instanceof NoJugable) {
                        enemigoGolpeado = (NoJugable) casillas[i][posicionXJugador];
                    }
                    personajePrincipalUsuario.ataque(enemigoGolpeado);
                }
            }
        }
    }

    public void ataqueJugadorX(boolean derecha) {
        int distanciaAtaque = personajePrincipalUsuario.getDistanciaAtaque();
        if (derecha == false) {
            System.out.println("Atacaste al enemigo en direccion al oeste");
            distanciaAtaque = distanciaAtaque * -1;
            while (posicionXJugador + distanciaAtaque < 0) {
                distanciaAtaque++;
            }
            while (posicionXJugador + distanciaAtaque >= columnas) {
                distanciaAtaque--;
            }
            for (int i = posicionXJugador; i >= posicionXJugador + distanciaAtaque; i--) {//posicion y-1?
                if (casillas[posicionYJugador][i] instanceof NoJugable) {
                    NoJugable enemigoGolpeado = (NoJugable) casillas[posicionYJugador][i];
                    if (casillas[posicionYJugador][i] instanceof NoJugable) {
                        enemigoGolpeado = (NoJugable) casillas[posicionYJugador][i];
                    }
                    personajePrincipalUsuario.ataque(enemigoGolpeado);
                }
            }
        } else if (derecha == true) {
            System.out.println("Atacaste al enemigo en direccion al este");
            while (posicionXJugador + distanciaAtaque < 0) {
                distanciaAtaque++;
            }
            while (posicionXJugador + distanciaAtaque >= columnas) {
                distanciaAtaque--;
            }
            for (int i = posicionXJugador; i < posicionXJugador + distanciaAtaque; i++) {//posicion y-1?
                if (casillas[posicionYJugador][i] instanceof NoJugable) {
                    NoJugable enemigoGolpeado = (NoJugable) casillas[posicionYJugador][i];
                    if (casillas[posicionYJugador][i] instanceof NoJugable) {
                        enemigoGolpeado = (NoJugable) casillas[posicionYJugador][i];
                    }
                    personajePrincipalUsuario.ataque(enemigoGolpeado);
                }
            }
        }
    }

    public void ataqueEnemigosY(boolean arriba, int personajeAtaca) {
        personajeAtaca = 0;
        switch (personajeAtaca) {
            case 1:
                personajePrincipalIA = inventarioIA.seleccionar(0);
                posicionYEnemigo = posicionYEnemigo1;
                posicionXEnemigo = posicionXEnemigo1;
                break;
            case 2:
                personajePrincipalIA = inventarioIA.seleccionar(1);
                posicionYEnemigo = posicionYEnemigo2;
                posicionXEnemigo = posicionXEnemigo2;
                break;
            case 3:
                personajePrincipalIA = inventarioIA.seleccionar(2);
                posicionYEnemigo = posicionYEnemigo3;
                posicionXEnemigo = posicionXEnemigo3;
                break;
            case 4:
                personajePrincipalIA = inventarioIA.seleccionar(3);
                posicionYEnemigo = posicionYEnemigo4;
                posicionXEnemigo = posicionXEnemigo4;
                break;
            case 5:
                personajePrincipalIA = inventarioIA.seleccionar(4);
                posicionYEnemigo = posicionYEnemigo5;
                posicionXEnemigo = posicionXEnemigo5;
                break;
            default:
                break;
        }
        if (arriba == true) {
            int distanciaAtaque = personajePrincipalIA.getDistanciaAtaque();
            distanciaAtaque = distanciaAtaque * -1;
            while (posicionYEnemigo + distanciaAtaque < 0) {
                distanciaAtaque++;
            }
            while (posicionYEnemigo + distanciaAtaque >= filas) {
                distanciaAtaque--;
            }
            for (int i = posicionYEnemigo; i >= posicionYEnemigo + distanciaAtaque; i--) {//posicion y-1?
                if (casillas[i][posicionXEnemigo] instanceof Jugable) {
                    Jugable jugableGolpeado = (Jugable) casillas[i][posicionXEnemigo];//casteo
                    if (casillas[i][posicionXEnemigo] instanceof Jugable) {
                        jugableGolpeado = (Jugable) casillas[i][posicionXEnemigo];
                    }
                    personajePrincipalIA.ataque(jugableGolpeado);
                }
            }
        } else if (arriba == false) {
            int distanciaAtaque = personajePrincipalIA.getDistanciaAtaque();
            while (posicionYEnemigo + distanciaAtaque < 0) {
                distanciaAtaque++;
            }
            while (posicionYEnemigo + distanciaAtaque >= columnas) {
                distanciaAtaque--;
            }
            for (int i = posicionYEnemigo; i <= posicionYEnemigo + distanciaAtaque; i++) {//posicion y-1?
                if (casillas[i][posicionXEnemigo] instanceof Jugable) {
                    Jugable jugableGolpeado = (Jugable) casillas[i][posicionXEnemigo];//casteo
                    if (casillas[i][posicionXEnemigo] instanceof NoJugable) {
                        jugableGolpeado = (Jugable) casillas[i][posicionXEnemigo];
                    }
                    personajePrincipalIA.ataque(jugableGolpeado);
                }
            }
        }
    }

    public void ataqueEnemigosX(boolean derecha, int personajeAtaca) {

        switch (personajeAtaca) {
            case 1:
                personajePrincipalIA = inventarioIA.seleccionar(0);
                posicionYEnemigo = posicionYEnemigo1;
                posicionXEnemigo = posicionXEnemigo1;
                break;
            case 2:
                personajePrincipalIA = inventarioIA.seleccionar(1);
                posicionYEnemigo = posicionYEnemigo2;
                posicionXEnemigo = posicionXEnemigo2;
                break;
            case 3:
                personajePrincipalIA = inventarioIA.seleccionar(2);
                posicionYEnemigo = posicionYEnemigo3;
                posicionXEnemigo = posicionXEnemigo3;
                break;
            case 4:
                personajePrincipalIA = inventarioIA.seleccionar(3);
                posicionYEnemigo = posicionYEnemigo4;
                posicionXEnemigo = posicionXEnemigo4;
                break;
            case 5:
                personajePrincipalIA = inventarioIA.seleccionar(4);
                posicionYEnemigo = posicionYEnemigo5;
                posicionXEnemigo = posicionXEnemigo5;
                break;
            default:
                break;
        }
        int distanciaAtaque = personajePrincipalIA.getDistanciaAtaque();
        if (derecha == false) {
            distanciaAtaque = distanciaAtaque * -1;
            while (posicionXEnemigo + distanciaAtaque < 0) {
                distanciaAtaque++;
            }
            while (posicionXEnemigo + distanciaAtaque >= columnas) {
                distanciaAtaque--;
            }
            for (int i = posicionXEnemigo; i >= posicionXEnemigo + distanciaAtaque; i--) {//posicion y-1?
                if (casillas[posicionYEnemigo][i] instanceof Jugable) {
                    Jugable jugableGolpeado = (Jugable) casillas[posicionYEnemigo][i];
                    if (casillas[posicionYEnemigo][i] instanceof Jugable) {
                        jugableGolpeado = (Jugable) casillas[posicionYEnemigo][i];
                    }
                    personajePrincipalIA.ataque(jugableGolpeado);
                }
            }
        } else if (derecha == true) {
            while (posicionXEnemigo + distanciaAtaque < 0) {
                distanciaAtaque++;
            }
            while (posicionXEnemigo + distanciaAtaque >= columnas) {
                distanciaAtaque--;
            }
            for (int i = posicionXEnemigo; i < posicionXEnemigo + distanciaAtaque; i++) {//posicion y-1?
                if (casillas[posicionYEnemigo][i] instanceof Jugable) {
                    Jugable jugableGolpeado = (Jugable) casillas[posicionYEnemigo][i];
                    if (casillas[posicionYEnemigo][i] instanceof Jugable) {
                        jugableGolpeado = (Jugable) casillas[posicionYEnemigo][i];
                    }
                    personajePrincipalIA.ataque(jugableGolpeado);
                }
            }
        }
    }

    public void eliminarJugadoresEnemigos() {
        if (casillas[posicionYEnemigo1][posicionXEnemigo1] instanceof NoJugable && inventarioIA.seleccionar(0).getPuntosDeVida() <= 0) {
            NoJugable personaje1 = (NoJugable) casillas[posicionYEnemigo1][posicionXEnemigo1];//casteo
            if (inventarioIA.seleccionar(0).getPuntosDeVida() <= 0) {//verifica que el vehiculo ya no tenga vida
                casillas[posicionYEnemigo1][posicionXEnemigo1] = new Planicie(((int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / casillas.length)) * 2 / 3);//reemplaza el espacio del vehiculo por campo
                posicionYEnemigo1 = 0;
                posicionXEnemigo1 = 0;
                posicionEnemigo1 = "";
                System.out.println("El personaje 1 ha sido eliminado, puntos de vida= " + inventarioIA.seleccionar(0).getPuntosDeVida());
            }
        }
        if (casillas[posicionYEnemigo2][posicionXEnemigo2] instanceof NoJugable && inventarioIA.seleccionar(1).getPuntosDeVida() <= 0) {
            NoJugable personaje2 = (NoJugable) casillas[posicionYEnemigo2][posicionXEnemigo2];//casteo
            if (inventarioIA.seleccionar(1).getPuntosDeVida() <= 0) {//verifica que el vehiculo ya no tenga vida
                casillas[posicionYEnemigo2][posicionXEnemigo2] = new Planicie(((int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / casillas.length)) * 2 / 3);//reemplaza el espacio del vehiculo por campo
                posicionYEnemigo2 = 2;
                posicionXEnemigo2 = 0;
                posicionEnemigo2 = "";
                System.out.println("El personaje 2 ha sido eliminado, puntos de vida= " + inventarioIA.seleccionar(1).getPuntosDeVida());
            }
        }
        if (casillas[posicionYEnemigo3][posicionXEnemigo3] instanceof NoJugable && inventarioIA.seleccionar(2).getPuntosDeVida() <= 0) {
            NoJugable personaje3 = (NoJugable) casillas[posicionYEnemigo3][posicionXEnemigo3];//casteo
            if (inventarioIA.seleccionar(2).getPuntosDeVida() <= 0) {//verifica que el vehiculo ya no tenga vida
                casillas[posicionYEnemigo3][posicionXEnemigo3] = new Planicie(((int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / casillas.length)) * 2 / 3);//reemplaza el espacio del vehiculo por campo
                posicionYEnemigo3 = 2;
                posicionXEnemigo3 = 0;
                posicionEnemigo3 = "";
                System.out.println("El personaje 3 ha sido eliminado, puntos de vida= " + inventarioIA.seleccionar(2).getPuntosDeVida());
            }
        }
        if (casillas[posicionYEnemigo4][posicionXEnemigo4] instanceof NoJugable && inventarioIA.seleccionar(3).getPuntosDeVida() <= 0) {
            NoJugable personaje4 = (NoJugable) casillas[posicionYEnemigo4][posicionXEnemigo4];//casteo
            if (inventarioIA.seleccionar(3).getPuntosDeVida() <= 0) {//verifica que el vehiculo ya no tenga vida
                casillas[posicionYEnemigo4][posicionXEnemigo4] = new Planicie(((int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / casillas.length)) * 2 / 3);//reemplaza el espacio del vehiculo por campo
                posicionYEnemigo4 = 2;
                posicionXEnemigo4 = 0;
                posicionEnemigo4 = "";
                System.out.println("El personaje 4 ha sido eliminado, puntos de vida= " + inventarioIA.seleccionar(3).getPuntosDeVida());
            }
        }
        if (casillas[posicionYEnemigo5][posicionXEnemigo5] instanceof NoJugable && inventarioIA.seleccionar(4).getPuntosDeVida() <= 0) {
            NoJugable personaje5 = (NoJugable) casillas[posicionYEnemigo5][posicionXEnemigo5];//casteo
            if (inventarioIA.seleccionar(3).getPuntosDeVida() <= 0) {
                casillas[posicionYEnemigo5][posicionXEnemigo5] = new Planicie(((int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / casillas.length)) * 2 / 3);
                posicionYEnemigo5 = 2;
                posicionXEnemigo5 = 0;
                posicionEnemigo5 = "";
                System.out.println("El personaje 5 ha sido eliminado, puntos de vida= " + inventarioIA.seleccionar(4).getPuntosDeVida());
            }
        }
    }

    public void realizarTurnoIA() {
        int tamanoInventario = 0;
        if (ia.getDificultad() == 1) {
            tamanoInventario = 3;
        } else if (ia.getDificultad() == 2) {
            tamanoInventario = 4;
        } else if (ia.getDificultad() == 3) {
            tamanoInventario = 5;
        }
        for (int i = 0; i < tamanoInventario; i++) {
            int opcionMovimiento = random.nextInt(1, 4);
            System.out.println("opcionMovimiento = " + opcionMovimiento);
            System.out.println("indice = " + i);
            switch (opcionMovimiento) {
                case 1:
                    if (inventarioIA.seleccionar(i).getPuntosDeVida() > 0) {
                        moverEnemigosY(true, i);
                        pintarMapa();
                    } else {
                        System.out.println("El personaje no tiene vida");
                    }

                    break;
                case 2:
                    if (inventarioIA.seleccionar(i).getPuntosDeVida() > 0) {
                        moverEnemigosY(false, i);
                        pintarMapa();
                    } else {
                        System.out.println("El personaje no tiene vida");
                    }
                    break;
                case 3:
                    if (inventarioIA.seleccionar(i).getPuntosDeVida() > 0) {
                        moverEnemigosX(false, i);
                        pintarMapa();
                    } else {
                        System.out.println("El personaje no tiene vida");
                    }
                    break;
                case 4:
                    if (inventarioIA.seleccionar(i).getPuntosDeVida() > 0) {
                        moverEnemigosX(true, i);
                        pintarMapa();
                    } else {
                        System.out.println("El personaje no tiene vida");
                    }
                    break;
                default:
                    break;
            }
            System.out.println("CAMBIO EL PERSONAJE");
        }

    }

    public void getId(String id) {
        this.nombre = id;
    }

    public Casilla[][] getCasillas() {
        return casillas;
    }

}
