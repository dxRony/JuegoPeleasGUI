package com.mycompany.juegopeleasgui.be.personajes.personajeJugable;

import com.mycompany.juegopeleasgui.be.personajes.Jugable;

public class Caballero extends Jugable {

    public Caballero(int tamaño) {
        super(tamaño);
        nombre = "C";
        vuela = false;
        puntosDeVida = 300;
        puntosAtaque = 45;
        movimiento = 1;
        distanciaAtaque = 1;
    }

}
