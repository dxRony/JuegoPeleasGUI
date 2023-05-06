package com.mycompany.juegopeleasgui.be;

import com.mycompany.juegopeleasgui.be.terrenos.Agua;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Casilla extends JButton {

    private boolean casillaUsada = false;
    private Image imagen;
    private int tamaño;
    private int posicionX;
    private int posicionY;

    public Casilla(int tamaño) {
        this.tamaño = tamaño;
        this.imagen = new ImageIcon(Agua.imagenAgua).getImage();
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
   
    public void cambiarImagen(String path) {
        this.imagen = new ImageIcon(getClass().getResource(Agua.imagenAgua)).getImage();
    }

    public void revelarCasilla() {
        this.imagen = new ImageIcon(getClass().getResource(Agua.imagenAgua)).getImage();
    }

}
