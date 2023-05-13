package com.mycompany.juegopeleasgui.be.personajes.personajeNoJugable;

import com.mycompany.juegopeleasgui.be.personajes.NoJugable;

public class Gargola extends NoJugable {

    public Gargola(int tamaño) {
        super(tamaño);
        nombre = "gr";
        vuela = true;
        puntosDeVida = 150;
        puntosAtaque = 100;
        movimiento = 3;
        distanciaAtaque = 2;
        puntaje = 45;
    }
}
