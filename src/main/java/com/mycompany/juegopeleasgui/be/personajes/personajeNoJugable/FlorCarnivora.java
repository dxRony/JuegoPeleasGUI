package com.mycompany.juegopeleasgui.be.personajes.personajeNoJugable;

import com.mycompany.juegopeleasgui.be.personajes.NoJugable;
import java.awt.Image;
import javax.swing.ImageIcon;

public class FlorCarnivora extends NoJugable {

    private static final String imagenFlorCarnivora = "src\\main\\java\\iconos\\florCarnivora.png";

    public FlorCarnivora(int tamaño) {
        super(tamaño);
        ImageIcon flor = new ImageIcon(imagenFlorCarnivora);
        this.setIcon(new ImageIcon(flor.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH)));        
        nombre = "f";
        vuela = false;
        puntosDeVida = 250;
        puntosAtaque = 100;
        movimiento = 0;
        distanciaAtaque = 3;
    }
}
