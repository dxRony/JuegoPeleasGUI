package com.mycompany.juegopeleasgui.be.terrenos;

import com.mycompany.juegopeleasgui.be.Casilla;

public class Terreno extends Casilla {

    protected String nombre;


    public Terreno(int tamaño) {
        super(tamaño);

    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {

        return nombre;
    }
}
