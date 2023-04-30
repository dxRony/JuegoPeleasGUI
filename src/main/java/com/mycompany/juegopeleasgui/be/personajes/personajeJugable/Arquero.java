package com.mycompany.juegopeleasgui.be.personajes.personajeJugable;

import com.mycompany.juegopeleasgui.be.personajes.Jugable;

public class Arquero extends Jugable {

    public Arquero() {
        nombre = "A";
        vuela = false;
        puntosDeVida = 150;
        puntosAtaque = 100;
        movimiento = 3;
        distanciaAtaque = 3;

    }
}
