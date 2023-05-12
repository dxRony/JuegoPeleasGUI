package com.mycompany.juegopeleasgui.be.personajes.personajeJugable;

import com.mycompany.juegopeleasgui.be.personajes.Jugable;

public class Mago extends Jugable {

    public Mago(int tamaño) {
        super(tamaño);
        nombre = "M";
        vuela = true;
        puntosDeVida = 100;
        puntosAtaque = 60;
        movimiento = 2;
        distanciaAtaque = 50;

    }
}
