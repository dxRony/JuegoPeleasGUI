package com.mycompany.juegopeleasgui;

import com.mycompany.juegopeleasgui.be.articulos.Articulo;
import com.mycompany.juegopeleasgui.be.inventarios.ListaGenerica;
import com.mycompany.juegopeleasgui.be.jugadores.IA;
import com.mycompany.juegopeleasgui.be.jugadores.Usuario;
import com.mycompany.juegopeleasgui.be.personajes.Jugable;
import com.mycompany.juegopeleasgui.be.personajes.NoJugable;
import com.mycompany.juegopeleasgui.fe.MenuPrincipal;
import java.util.Scanner;

public class MotorJuego {

    private Usuario usuario;
    private IA ia;
    private Jugable[] listaJugables;
    private Articulo[] listaArticulos;
    private NoJugable[] listaEnemigos;
    private ListaGenerica<NoJugable> inventarioIA;
    private ListaGenerica<Jugable> inventarioUsuario;
    private int oro;

    public MotorJuego() {//revisado
        usuario = new Usuario();
        ia = new IA();
        listaJugables = usuario.getListaJugables();
        listaArticulos = usuario.getListaArticulos();
        listaEnemigos = ia.getListaEnemigos();
        inventarioUsuario = usuario.getInventarioUsuario();
        inventarioIA = ia.getInventarioIA();
        oro = usuario.getOro();
    }

    public void iniciarPartida() {
        MenuPrincipal juego = new MenuPrincipal(usuario, ia);
        juego.setVisible(true);
        
    }

}
