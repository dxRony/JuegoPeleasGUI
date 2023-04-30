package com.mycompany.juegopeleasgui.be.jugadores;

import com.mycompany.juegopeleasgui.be.articulos.Articulo;
import com.mycompany.juegopeleasgui.be.articulos.ArticuloVacio;
import com.mycompany.juegopeleasgui.be.articulos.mejoras.Dano;
import com.mycompany.juegopeleasgui.be.articulos.mejoras.Movilidad;
import com.mycompany.juegopeleasgui.be.articulos.mejoras.Vida;
import com.mycompany.juegopeleasgui.be.articulos.objetos.CapaDeMovilidad;
import com.mycompany.juegopeleasgui.be.articulos.objetos.ElixirVerde;
import com.mycompany.juegopeleasgui.be.articulos.objetos.SemillaDeLaVida;
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
//    private Jugables[] inventarioJugables;
//    private Articulos[] inventarioArticulos;

    public Usuario() {
        oro = 500;
        listaArticulos = new Articulo[7];
        listaJugables = new Jugable[6];
        personajePrincipalUsuario = new Jugable();
        listaJugables[0] = new Arquero();
        listaJugables[1] = new Caballero();
        listaJugables[2] = new Dragon();
        listaJugables[3] = new Gigante();
        listaJugables[4] = new Mago();
        listaJugables[5] = new JugableVacio();
        listaArticulos[0] = new CapaDeMovilidad();
        listaArticulos[1] = new Dano();
        listaArticulos[2] = new ElixirVerde();
        listaArticulos[3] = new Movilidad();
        listaArticulos[4] = new SemillaDeLaVida();
        listaArticulos[5] = new Vida();
        listaArticulos[6] = new ArticuloVacio();
//        inventarioJugables = new Jugables[5];
//        inventarioArticulos = new Articulos[10];
//        iniciarInventarioUsuario();
//        iniciarInventarioArticulos();
    }

//    public void iniciarInventarioUsuario() {
//        for (int i = 0; i < 5; i++) {
//            inventarioJugables[i] = listaJugables[5];
//        }
//    }
//
//    public void iniciarInventarioArticulos() {
//        for (int i = 0; i < inventarioArticulos.length; i++) {
//            inventarioArticulos[i] = listaArticulos[6];
//        }
//    }
//
//    public void pintarInventarioUsuario() {
//        System.out.println("Inventario Personajes(usuario): ");
//        for (int i = 0; i < 5; i++) {
//            System.out.print("[" + i + "] " + inventarioJugables[i].getNombre());
//            System.out.print("\n");
//        }
//        System.out.println("--------------------------------------");
//    }
//
//    public void pintarInventarioArticulos() {
//        System.out.println("Inventario Articulos(usuario):");
//        for (int i = 0; i < inventarioArticulos.length; i++) {
//            System.out.print("[" + i + "] " + inventarioArticulos[i].getNombre());
//            System.out.print("\n");
//        }
//        System.out.println("--------------------------------------");
//    }
//
//    public void comprarJugables(Jugables jugables, int oro) {
//        if (this.oro >= jugables.getCoste()) {
//            for (int i = 0; i < inventarioJugables.length; i++) {
//                if (this.inventarioJugables[i] instanceof PersonajeVacio) {
//                    this.oro -= jugables.getCoste();
//                    this.inventarioJugables[i] = jugables;
//                    System.out.println("Compraste al: " + jugables.getNombre());
//                    System.out.println("Tienes: " + this.oro + " de oro");
//                    return;
//                }
//            }
//        }
//        System.out.println("No tienes el suficiente oro");
//    }
//
//    public void comprarArticulos(Articulos articulos, int oro) {
//        if (this.oro >= articulos.getCoste()) {
//            for (int i = 0; i < inventarioArticulos.length; i++) {
//                if (this.inventarioArticulos[i] instanceof ArticuloVacio) {
//                    this.oro -= articulos.getCoste();
//                    this.inventarioArticulos[i] = articulos;
//                    System.out.println("Compraste: " + articulos.getNombre());
//                    System.out.println("Tienes: " + this.oro + " de oro");
//                    return;
//                }
//            }
//        }
//        System.out.println("No tienes el oro suficiente");
//    }
//
    public void almacenarPrincipalUsuario(Jugable personajePrincipalUsuario) {
        this.personajePrincipalUsuario = personajePrincipalUsuario;
    }

    public int getOro() {
        return oro;
    }
    
//    public Jugables[] getInventarioJugables() {
//        return inventarioJugables;
//    }
//
//    public Articulos[] getInventarioArticulos() {
//        return inventarioArticulos;
//    }

    public Jugable[] getListaJugables() {
        return listaJugables;
    }
//

    public Articulo[] getListaArticulos() {
        return listaArticulos;
    }

    public Jugable getPersonajePrincipalUsuario() {
        return personajePrincipalUsuario;
    }
}
