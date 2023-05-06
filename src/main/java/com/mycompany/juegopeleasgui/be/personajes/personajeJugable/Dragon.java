package com.mycompany.juegopeleasgui.be.personajes.personajeJugable;

import com.mycompany.juegopeleasgui.be.personajes.Jugable;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Dragon extends Jugable {

    private static final String imagenDragon = "src\\main\\java\\iconos\\dragon.png";

    public Dragon(int tamaño) {
        super(tamaño);
        ImageIcon dragon = new ImageIcon(imagenDragon);
        this.setIcon(new ImageIcon(dragon.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH)));  
        nombre = "D";
        vuela = true;
        puntosDeVida = 250;
        puntosAtaque = 75;
        movimiento = 3;
        distanciaAtaque = 2;

    }
}
