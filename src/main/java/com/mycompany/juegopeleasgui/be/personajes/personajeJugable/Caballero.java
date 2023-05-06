package com.mycompany.juegopeleasgui.be.personajes.personajeJugable;

import com.mycompany.juegopeleasgui.be.personajes.Jugable;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Caballero extends Jugable {

    private static final String imagenCaballero = "src\\main\\java\\iconos\\caballero.png";

    public Caballero(int tamaño) {
        super(tamaño);
        ImageIcon caballero = new ImageIcon(imagenCaballero);
        this.setIcon(new ImageIcon(caballero.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH)));       
        nombre = "C";
        vuela = false;
        puntosDeVida = 300;
        puntosAtaque = 45;
        movimiento = 1;
        distanciaAtaque = 1;

    }
}
