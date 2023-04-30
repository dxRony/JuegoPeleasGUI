package com.mycompany.juegopeleasgui.be.personajes.personajeJugable;

import com.mycompany.juegopeleasgui.be.personajes.Jugable;

public class Gigante extends Jugable {

    public Gigante() {
        nombre = "G";
        vuela = false;
        puntosDeVida = 350;
        puntosAtaque = 56;
        movimiento = 1;
        distanciaAtaque = 3;

    }
}
