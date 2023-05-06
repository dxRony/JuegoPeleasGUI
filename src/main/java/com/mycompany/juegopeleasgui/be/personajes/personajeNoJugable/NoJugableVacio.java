package com.mycompany.juegopeleasgui.be.personajes.personajeNoJugable;

import com.mycompany.juegopeleasgui.be.personajes.NoJugable;

public class NoJugableVacio extends NoJugable {

    public NoJugableVacio(int tamaño) {
        super(tamaño);
        nombre = "e";
        puntosDeVida = 0;
    }
}
