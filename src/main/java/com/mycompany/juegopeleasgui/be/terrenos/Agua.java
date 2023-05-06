package com.mycompany.juegopeleasgui.be.terrenos;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Agua extends Terreno {
    
    public static final String imagenAgua = "src\\main\\java\\iconos\\agua.png";
    
    public Agua(int tamaño) {
        super(tamaño);
        ImageIcon agua = new ImageIcon(imagenAgua);
        this.setIcon(new ImageIcon(agua.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH)));
        nombre = "~";
    }   
}
