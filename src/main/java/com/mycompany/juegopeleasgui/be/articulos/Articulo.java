package com.mycompany.juegopeleasgui.be.articulos;

import java.io.Serializable;

public class Articulo implements Serializable{

    protected String nombre;
    protected int coste;
    protected int vida;
    protected int movilidad;
    protected int dano;
    protected int movimiento;

    public String getNombre() {
        return nombre;
    }

    public int getCoste() {
        return coste;
    }

    public int getVida() {
        return vida;
    }

    public int getMovilidad() {
        return movilidad;
    }

    public int getDano() {
        return dano;
    }

    public int getMovimiento() {
        return movimiento;
    }

    public String toString() {
        return nombre;
    }
}
