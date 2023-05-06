package com.mycompany.juegopeleasgui.be.jugadores;

import com.mycompany.juegopeleasgui.be.articulos.Articulo;
import com.mycompany.juegopeleasgui.be.articulos.ArticuloVacio;
import com.mycompany.juegopeleasgui.be.articulos.mejoras.Dano;
import com.mycompany.juegopeleasgui.be.articulos.mejoras.Movilidad;
import com.mycompany.juegopeleasgui.be.articulos.mejoras.Vida;
import com.mycompany.juegopeleasgui.be.articulos.objetos.CapaDeMovilidad;
import com.mycompany.juegopeleasgui.be.articulos.objetos.ElixirVerde;
import com.mycompany.juegopeleasgui.be.articulos.objetos.SemillaDeLaVida;
import com.mycompany.juegopeleasgui.be.inventarios.ListaGenerica;
import com.mycompany.juegopeleasgui.be.personajes.Jugable;
import com.mycompany.juegopeleasgui.be.personajes.personajeJugable.Arquero;
import com.mycompany.juegopeleasgui.be.personajes.personajeJugable.Caballero;
import com.mycompany.juegopeleasgui.be.personajes.personajeJugable.Dragon;
import com.mycompany.juegopeleasgui.be.personajes.personajeJugable.Gigante;
import com.mycompany.juegopeleasgui.be.personajes.personajeJugable.JugableVacio;
import com.mycompany.juegopeleasgui.be.personajes.personajeJugable.Mago;

public class Usuario extends Jugador {

    private int oro;
    private Jugable[] listaJugables;
    private Articulo[] listaArticulos;
    private Jugable personajePrincipalUsuario;
    private ListaGenerica<Jugable> inventarioUsuario;
    private ListaGenerica<Articulo> inventarioArticulos;

    public Usuario() {
        oro = 500;
        listaArticulos = new Articulo[7];
        listaJugables = new Jugable[6];
        personajePrincipalUsuario = new Jugable(1);
        listaJugables[0] = new Caballero(1);
        listaJugables[1] = new Arquero(1);
        listaJugables[2] = new Dragon(1);
        listaJugables[3] = new Gigante(1);
        listaJugables[4] = new Mago(1);
        listaJugables[5] = new JugableVacio(1);
        listaArticulos[0] = new CapaDeMovilidad();
        listaArticulos[1] = new Dano();
        listaArticulos[2] = new ElixirVerde();
        listaArticulos[3] = new Movilidad();
        listaArticulos[4] = new SemillaDeLaVida();
        listaArticulos[5] = new Vida();
        listaArticulos[6] = new ArticuloVacio();
        inventarioUsuario = new ListaGenerica<Jugable>();
        inventarioArticulos = new ListaGenerica<Articulo>();
    }

    public void comprarJugables(Jugable personaje, int oro) {

        if (this.oro >= personaje.getCoste()) {
            this.oro -= personaje.getCoste();
            inventarioUsuario.agregar(personaje);
            System.out.println("Compraste al: " + personaje.getNombre());
            System.out.println("Tienes: " + this.oro + " de oro");
            return;
        }
        System.out.println("No tienes el oro suficiente");
        inventarioUsuario.pintarLista();
    }

    public void comprarArticulos(Articulo articulo, int oro) {

        if (this.oro >= articulo.getCoste()) {
            this.oro -= articulo.getCoste();
            inventarioArticulos.agregar(articulo);
            System.out.println("Compraste: " + articulo.getNombre());
            System.out.println("Tienes: " + this.oro + " de oro");
            return;
        }
        System.out.println("No tienes el oro suficiente");
    }

    public void almacenarPrincipalUsuario(Jugable personajePrincipalUsuario) {
        this.personajePrincipalUsuario = personajePrincipalUsuario;
    }

    public int getOro() {
        return oro;
    }

    public Jugable[] getListaJugables() {
        return listaJugables;
    }

    public Articulo[] getListaArticulos() {
        return listaArticulos;
    }

    public Jugable getPersonajePrincipalUsuario() {
        return personajePrincipalUsuario;
    }

    public ListaGenerica<Jugable> getInventarioUsuario() {
        return inventarioUsuario;
    }

    public ListaGenerica<Articulo> getInventarioArticulos() {
        return inventarioArticulos;
    }

}
