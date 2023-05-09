package com.mycompany.juegopeleasgui;

import com.mycompany.juegopeleasgui.be.articulos.Articulo;
import com.mycompany.juegopeleasgui.be.inventarios.ListaGenerica;
import com.mycompany.juegopeleasgui.be.jugadores.IA;
import com.mycompany.juegopeleasgui.be.jugadores.Usuario;
import com.mycompany.juegopeleasgui.be.personajes.Jugable;
import com.mycompany.juegopeleasgui.be.personajes.NoJugable;
import com.mycompany.juegopeleasgui.be.personajes.Personaje;
import com.mycompany.juegopeleasgui.be.tablero.Tablero;
import com.mycompany.juegopeleasgui.fe.TableroDeJuego;
import com.mycompany.juegopeleasgui.fe.Tienda;
import java.util.Random;
import java.util.Scanner;

public class Partida {

    private Usuario usuario;
    private IA ia;
    private Scanner leer;
    private Random random;
    private int filas;
    private int columnas;
    private String id;
    private NoJugable enemigos;
    private Jugable jugables;
    private Articulo articulo;
    private Tablero tablero;
    private Jugable personajePrincipalUsuario;
    private ListaGenerica<NoJugable> inventarioIA;
    private ListaGenerica<Jugable> inventarioUsuario;
    private ListaGenerica<Articulo> inventarioArticulos;

    private boolean turno;
    private boolean usuarioVive;
    private boolean iaVive;

    public Partida(Usuario usuario, IA ia, Tablero tableroNuevo) {
        this.usuario = usuario;
        this.ia = ia;
        this.tablero = tableroNuevo;
        leer = new Scanner(System.in);
        random = new Random();
        enemigos = new NoJugable(1);
        jugables = new Jugable(1);
        articulo = new Articulo(); 
        personajePrincipalUsuario = usuario.getPersonajePrincipalUsuario();
        inventarioUsuario = usuario.getInventarioUsuario();
        inventarioArticulos = usuario.getInventarioArticulos();
        inventarioIA = ia.getInventarioIA();
        usuarioVive = true;
        iaVive = true;
    }

    public void iniciarPartida() {
        System.out.println("Iniciando partida");
    }

    
    private void definirPersonajeInicial() {
        int val = random.nextInt(100);
        turno = val >= 49;
    }

    private void mostrarEleccionTablero() {

    }

    private void mostrarOpcionesJugadorTurno() {

    }

    private void mostrarOpcionesJugadorMovimiento() {

    }

    private void mostrarOpcionesJugadorAtaque() {

    }

    private void mostrarOpcionesIAMovimiento() {

    }

    private void cambiarTurno() {
        turno = !turno;
    }

    private boolean ganoJugador() {
        int oro;
        int recompensa = 250;
        if (jugables.estaVivo() == true && enemigos.estaVivo() == false) {
            System.out.println("Ganaste");
            oro = usuario.getOro();
            oro += recompensa;
            return true;
        } else if (jugables.estaVivo() == false && enemigos.estaVivo() == true) {
            System.out.println("Perdiste");
            return false;
        }
        return false;
    }

    public boolean esTurnoJugador() {
        return turno;
    }

}
