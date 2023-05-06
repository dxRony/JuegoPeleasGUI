package com.mycompany.juegopeleasgui.be.personajes.personajeJugable;

import com.mycompany.juegopeleasgui.be.personajes.Jugable;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Arquero extends Jugable {

    private static final String imagenArquero = "src\\main\\java\\iconos\\arquero.png";

    public Arquero(int tamaño) {
        super(tamaño);
        ImageIcon arquero = new ImageIcon(imagenArquero);
        this.setIcon(new ImageIcon(arquero.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH)));    
        nombre = "A";
        vuela = false;
        puntosDeVida = 150;
        puntosAtaque = 100;
        movimiento = 3;
        distanciaAtaque = 3;

    }
}
