package com.mycompany.juegopeleasgui.be.personajes.personajeNoJugable;

import com.mycompany.juegopeleasgui.be.personajes.NoJugable;

public class Cancerbero extends NoJugable {

    public Cancerbero(int tamaño) {
        super(tamaño);
        nombre = "cn";
        vuela = false;
        puntosDeVida = 400;
        puntosAtaque = 45;
        movimiento = 1;
        distanciaAtaque = 1;
        puntaje = 30;
    }
}
