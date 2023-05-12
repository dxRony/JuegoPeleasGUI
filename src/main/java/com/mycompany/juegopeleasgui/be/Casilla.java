package com.mycompany.juegopeleasgui.be;

import java.io.Serializable;
import javax.swing.JLabel;

public class Casilla extends JLabel implements Serializable {

    private int tamaño;
    private int posicionX;
    private int posicionY;
    

    public Casilla(int tamaño) {
        this.tamaño = tamaño;
        this.setSize(tamaño, tamaño);
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public int getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }
}
