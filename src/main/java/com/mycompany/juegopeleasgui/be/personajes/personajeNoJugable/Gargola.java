package com.mycompany.juegopeleasgui.be.personajes.personajeNoJugable;

import com.mycompany.juegopeleasgui.be.personajes.NoJugable;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Gargola extends NoJugable {

    private static final String imagenGargola = "src\\main\\java\\iconos\\gargola.png";

    public Gargola(int tamaño) {
        super(tamaño);
        ImageIcon gargola = new ImageIcon(imagenGargola);
        this.setIcon(new ImageIcon(gargola.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH)));       
        nombre = "g";
        vuela = true;
        puntosDeVida = 150;
        puntosAtaque = 100;
        movimiento = 3;
        distanciaAtaque = 2;

    }
}
