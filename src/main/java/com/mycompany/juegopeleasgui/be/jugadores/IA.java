package com.mycompany.juegopeleasgui.be.jugadores;

import com.mycompany.juegopeleasgui.be.inventarios.ListaGenerica;
import com.mycompany.juegopeleasgui.be.personajes.NoJugable;
import com.mycompany.juegopeleasgui.be.personajes.personajeNoJugable.Bruja;
import com.mycompany.juegopeleasgui.be.personajes.personajeNoJugable.Cancerbero;
import com.mycompany.juegopeleasgui.be.personajes.personajeNoJugable.FlorCarnivora;
import com.mycompany.juegopeleasgui.be.personajes.personajeNoJugable.Gargola;
import com.mycompany.juegopeleasgui.be.personajes.personajeNoJugable.Ogro;

public class IA extends Jugador {

    private NoJugable[] listaEnemigos;
    private NoJugable personajePrincipalIA;
    private int dificultad;
    private ListaGenerica<NoJugable> inventarioIA;

    public IA() {
        listaEnemigos = new NoJugable[6];
        personajePrincipalIA = new NoJugable(95);
        listaEnemigos[0] = new Bruja(95);
        listaEnemigos[1] = new Cancerbero(95);
        listaEnemigos[2] = new FlorCarnivora(50);
        listaEnemigos[3] = new Gargola(60);
        listaEnemigos[4] = new Ogro(60);
        listaEnemigos[5] = new NoJugable(95);
        inventarioIA = new ListaGenerica<NoJugable>();
    }

    public void llenarInventarioEnemigos(NoJugable personaje) {
        inventarioIA.agregar(personaje);
    }

    public void almacenarPrincipalIA(NoJugable personajePrincipalIA) {
        this.personajePrincipalIA = personajePrincipalIA;
    }

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

    public ListaGenerica<NoJugable> getInventarioIA() {
        return inventarioIA;
    }

}
