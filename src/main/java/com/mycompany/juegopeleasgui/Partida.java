package com.mycompany.juegopeleasgui;

import com.mycompany.juegopeleasgui.be.articulos.Articulo;
import com.mycompany.juegopeleasgui.be.inventarios.ListaGenerica;
import com.mycompany.juegopeleasgui.be.jugadores.IA;
import com.mycompany.juegopeleasgui.be.jugadores.Usuario;
import com.mycompany.juegopeleasgui.be.personajes.Jugable;
import com.mycompany.juegopeleasgui.be.personajes.NoJugable;
import com.mycompany.juegopeleasgui.be.personajes.Personaje;
import com.mycompany.juegopeleasgui.be.tablero.Tablero;
import com.mycompany.juegopeleasgui.fe.MenuPrincipal;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Partida {

    private Usuario usuario;
    private IA ia;
    private Scanner leer;
    private Random random;
    private int filas;
    private int columnas;
    private String id;
    private NoJugable noJugable;
    private Jugable jugable;
    private Articulo articulo;
    private Tablero tablero;
    private Jugable personajePrincipalUsuario;
    private ListaGenerica<NoJugable> inventarioIA;
    private ListaGenerica<Jugable> inventarioUsuario;
    private ListaGenerica<Articulo> inventarioArticulos;
    private JButton btnAtacar;
    private JButton btnMover;
    private JButton btnUsarArticulo;
    private JFrame frameTablero;

    private boolean turno;
    private boolean usuarioVive;
    private boolean iaVive;

    public Partida(Usuario usuario, IA ia, Tablero tableroNuevo, JFrame frameTablero) {
        this.usuario = usuario;
        this.ia = ia;
        this.tablero = tableroNuevo;
        this.frameTablero = frameTablero;
        leer = new Scanner(System.in);
        random = new Random();
        noJugable = new NoJugable(1);
        jugable = new Jugable(1);
        articulo = new Articulo();
        personajePrincipalUsuario = usuario.getPersonajePrincipalUsuario();
        inventarioUsuario = usuario.getInventarioUsuario();
        inventarioArticulos = usuario.getInventarioArticulos();
        inventarioIA = ia.getInventarioIA();
        usuarioVive = true;
        iaVive = true;

    }

    public void iniciarPartida() {
        definirPersonajeInicial();
        System.out.println("------------------------Partida Iniciada------------------------");
        do {
            Personaje personajeAtacante = obtenerPersonajeAtacante();
            Personaje personajeAtacado = obtenerPersonajeAtacado();
            if (isTurno()) {
                System.out.println("Es tu turno");
                leer.nextLine();
            } else {
                System.out.println("Es el turno de la IA");
                mostrarOpcionesIAMovimiento();

            }
            cambiarTurno();
        } while (usuarioVive == true && iaVive == true);
        System.out.println("La partida ha terminado");
        ganoJugador();
        MenuPrincipal juego = new MenuPrincipal(usuario, ia);
        juego.setVisible(true);
    }

    private void definirPersonajeInicial() {
        int val = random.nextInt(100);
        turno = val >= 49;
    }

    public void mostrarOpcionesJugadorTurno(JButton btnMover, JButton btnAtacar, JButton btnUsarArticulo) {
        btnMover.setVisible(true);
        btnAtacar.setVisible(true);
        btnUsarArticulo.setVisible(true);
    }

    public void mostrarOpcionesIAMovimiento() {
        int opcionMovimiento = random.nextInt(1, 4);
        switch (opcionMovimiento) {
            case 1:
               // tablero.moverEnemigosY(true);
                tablero.pintarMapa();
                break;
            case 2:
              //  tablero.moverEnemigosY(false);
                tablero.pintarMapa();
                break;
            case 3:
               // tablero.moverEnemigosX(false);
                tablero.pintarMapa();
                break;
            case 4:
              //  tablero.moverEnemigosX(true);
                tablero.pintarMapa();
                break;
            default:
                break;
        }
    }

    public void cambiarTurno() {
        turno = !turno;
    }

    private boolean ganoJugador() {
        int oro;
        int recompensa = 250;
        if (jugable.estaVivo() == true && noJugable.estaVivo() == false) {
            System.out.println("Ganaste");
            oro = usuario.getOro();
            oro += recompensa;
            return true;
        } else if (jugable.estaVivo() == false && noJugable.estaVivo() == true) {
            System.out.println("Perdiste");
            return false;
        }
        return false;
    }

    public Personaje obtenerPersonajeAtacante() {
        return isTurno() ? jugable : noJugable;
    }

    public Personaje obtenerPersonajeAtacado() {
        return isTurno() ? noJugable : jugable;
    }

    public boolean isTurno() {
        return turno;
    }

}
