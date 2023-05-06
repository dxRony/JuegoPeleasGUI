package com.mycompany.juegopeleasgui.be.personajes.personajeJugable;

import com.mycompany.juegopeleasgui.be.personajes.Jugable;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Gigante extends Jugable {

    private static final String imagenGigante = "src\\main\\java\\iconos\\gigante.png";
    public Gigante(int tamaño) {
        super(tamaño);
        ImageIcon gigante = new ImageIcon(imagenGigante);
        this.setIcon(new ImageIcon(gigante.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH)));       
        nombre = "G";
        vuela = false;
        puntosDeVida = 350;
        puntosAtaque = 56;
        movimiento = 1;
        distanciaAtaque = 3;

    }
}
