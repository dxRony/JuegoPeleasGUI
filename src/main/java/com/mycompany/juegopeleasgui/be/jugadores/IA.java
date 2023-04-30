package com.mycompany.juegopeleasgui.be.jugadores;

import com.mycompany.juegopeleasgui.be.personajes.NoJugable;
import com.mycompany.juegopeleasgui.be.personajes.personajeNoJugable.Bruja;
import com.mycompany.juegopeleasgui.be.personajes.personajeNoJugable.Cancerbero;
import com.mycompany.juegopeleasgui.be.personajes.personajeNoJugable.FlorCarnivora;
import com.mycompany.juegopeleasgui.be.personajes.personajeNoJugable.Gargola;
import com.mycompany.juegopeleasgui.be.personajes.personajeNoJugable.Ogro;

public class IA extends Jugador {

    private NoJugable[] listaEnemigos;//personajes existentes
    private NoJugable personajePrincipalIA;//personaje que realiza las acciones
    private int dificultad;
//    private Enemigos[] inventarioEnemigos;//personajes que posee 

    public IA() {
        listaEnemigos = new NoJugable[6];
        personajePrincipalIA = new NoJugable();
        listaEnemigos[0] = new Bruja();
        listaEnemigos[1] = new Cancerbero();
        listaEnemigos[2] = new FlorCarnivora();
        listaEnemigos[3] = new Gargola();
        listaEnemigos[4] = new Ogro();
        listaEnemigos[5] = new NoJugable();
//        inventarioEnemigos = new Enemigos[5];
//        iniciarInventarioIA();
    }

//    public void iniciarInventarioIA() {
//        for (int i = 0; i < 5; i++) {
//            inventarioEnemigos[i] = listaEnemigos[5];
//        }
//    }
//
//    public void pintarInventarioIA() {
//        System.out.println("Inventario Personajes (IA)");
//        for (int i = 0; i < 5; i++) {
//            System.out.print("[" + i + "] " + inventarioEnemigos[i].getNombre());
//
//            System.out.print("\n");
//        }
//        System.out.println("--------------------------------------");
//    }
//
//    public void llenarInventarioEnemigos(Enemigos enemigos) {
//        for (int i = 0; i < 5; i++) {
//            if (this.inventarioEnemigos[i] instanceof EnemigoVacio) {
//                this.inventarioEnemigos[i] = enemigos;
//                return;
//            }
//        }
//    }
//
    public void almacenarPrincipalIA(NoJugable personajePrincipalIA) {
        this.personajePrincipalIA = personajePrincipalIA;
    }
//
//    public Enemigos[] getInventarioEnemigos() {
//        return inventarioEnemigos;
//    }
//

    public NoJugable[] getListaEnemigos() {
        return listaEnemigos;
    }

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }

    public int getDificultad() {
        return dificultad;
    }

    public NoJugable getPersonajePrincipalIA() {
        return personajePrincipalIA;
    }
}
