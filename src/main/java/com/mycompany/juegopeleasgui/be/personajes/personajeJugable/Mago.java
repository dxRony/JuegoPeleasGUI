package com.mycompany.juegopeleasgui.be.personajes.personajeJugable;

import com.mycompany.juegopeleasgui.be.personajes.Jugable;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Mago extends Jugable {

    private static final String imagenMago = "src\\main\\java\\iconos\\mago.png";

    public Mago(int tamaño) {
        super(tamaño);
        ImageIcon mago = new ImageIcon(imagenMago);
        this.setIcon(new ImageIcon(mago.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH)));    
        nombre = "b";
        vuela = true;
        puntosDeVida = 150;
        puntosAtaque = 45;
        movimiento = 48;
        distanciaAtaque = 15;

    }
}
