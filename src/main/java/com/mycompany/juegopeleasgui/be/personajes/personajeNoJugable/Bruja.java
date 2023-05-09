package com.mycompany.juegopeleasgui.be.personajes.personajeNoJugable;

import com.mycompany.juegopeleasgui.be.personajes.NoJugable;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Bruja extends NoJugable {

    public static final String imagenBruja = "src\\main\\java\\iconos\\bruja.png";

    public Bruja(int tamaño) {
        super(tamaño);
        ImageIcon bruja = new ImageIcon(imagenBruja);
        this.setIcon(new ImageIcon(bruja.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH)));       
        nombre = "b";
        vuela = true;
        puntosDeVida = 150;
        puntosAtaque = 45;
        movimiento = 48;
        distanciaAtaque = 15;
    }
}
