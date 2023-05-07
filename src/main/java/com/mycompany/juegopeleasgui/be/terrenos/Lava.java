package com.mycompany.juegopeleasgui.be.terrenos;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Lava extends Terreno {

    private static final String imagenLava = "src\\main\\java\\iconos\\lava.jpg";

    public Lava(int tamaño) {
        super(tamaño);
        ImageIcon lava = new ImageIcon(imagenLava);
        this.setIcon(new ImageIcon(lava.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH)));       
        nombre = "#";
    }

}
