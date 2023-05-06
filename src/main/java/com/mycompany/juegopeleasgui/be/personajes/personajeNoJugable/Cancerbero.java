package com.mycompany.juegopeleasgui.be.personajes.personajeNoJugable;

import com.mycompany.juegopeleasgui.be.personajes.NoJugable;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Cancerbero extends NoJugable {

    private static final String imagenCancerbero = "src\\main\\java\\iconos\\cancerbero.png";

    public Cancerbero(int tamaño) {
        super(tamaño);
        ImageIcon cancerbero = new ImageIcon(imagenCancerbero);
        this.setIcon(new ImageIcon(cancerbero.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH)));       
        nombre = "c";
        vuela = false;
        puntosDeVida = 400;
        puntosAtaque = 45;
        movimiento = 1;
        distanciaAtaque = 1;
    }
}
