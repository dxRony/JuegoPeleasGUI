package com.mycompany.juegopeleasgui.be.personajes.personajeJugable;

import com.mycompany.juegopeleasgui.be.personajes.Jugable;

public class Dragon extends Jugable {

    public Dragon(int tamaño) {
        super(tamaño);
        nombre = "D";
        vuela = true;
        puntosDeVida = 250;
        puntosAtaque = 75;
        movimiento = 3;
        distanciaAtaque = 2;
    }
}
