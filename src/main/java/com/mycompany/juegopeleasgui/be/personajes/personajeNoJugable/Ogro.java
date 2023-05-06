package com.mycompany.juegopeleasgui.be.personajes.personajeNoJugable;

import com.mycompany.juegopeleasgui.be.personajes.NoJugable;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Ogro extends NoJugable {

    private static final String imagenOgro = "src\\main\\java\\iconos\\ogro.png";

    public Ogro(int tamaño) {
        super(tamaño);
        ImageIcon ogro = new ImageIcon(imagenOgro);
        this.setIcon(new ImageIcon(ogro.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH)));       
        nombre = "o";
        vuela = false;
        puntosDeVida = 300;
        puntosAtaque = 50;
        movimiento = 1;
        distanciaAtaque = 1;

    }
}
