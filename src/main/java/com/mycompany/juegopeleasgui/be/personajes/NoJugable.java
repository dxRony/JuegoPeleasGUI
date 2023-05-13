package com.mycompany.juegopeleasgui.be.personajes;

public class NoJugable extends Personaje {

    protected int puntaje;

    public NoJugable(int tamaño) {
        super(tamaño);
        probabilidadAtaque = 60;
    }

    public int getPuntaje() {
        return puntaje;
    }

}
