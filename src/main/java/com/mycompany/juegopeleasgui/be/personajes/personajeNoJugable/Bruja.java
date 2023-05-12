package com.mycompany.juegopeleasgui.be.personajes.personajeNoJugable;

import com.mycompany.juegopeleasgui.be.personajes.NoJugable;

public class Bruja extends NoJugable {

    public Bruja(int tamaño) {
        super(tamaño);
        nombre = "b";
        vuela = true;
        puntosDeVida = 150;
        puntosAtaque = 45;
        movimiento = 50;
        distanciaAtaque = 50;
    }
}
