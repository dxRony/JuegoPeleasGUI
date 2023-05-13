package com.mycompany.juegopeleasgui.be.personajes.personajeNoJugable;

import com.mycompany.juegopeleasgui.be.personajes.NoJugable;

public class FlorCarnivora extends NoJugable {

    public FlorCarnivora(int tamaño) {
        super(tamaño);
        nombre = "f";
        vuela = false;
        puntosDeVida = 250;
        puntosAtaque = 30;
        movimiento = 0;
        distanciaAtaque = 3;
        puntaje = 75;
    }
}
