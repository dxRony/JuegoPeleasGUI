package com.mycompany.juegopeleasgui.be.jugadores;

import java.io.Serializable;

public class Jugador implements Serializable{

    protected String nombre;

    public Jugador() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    

}
