package com.mycompany.juegopeleasgui.be.personajes.personajeNoJugable;

import com.mycompany.juegopeleasgui.be.personajes.NoJugable;

public class Ogro extends NoJugable {

    public Ogro(int tamaño) {
        super(tamaño);
        nombre = "o";
        vuela = false;
        puntosDeVida = 300;
        puntosAtaque = 50;
        movimiento = 1;
        distanciaAtaque = 1;
        puntaje = 25;
    }
}
