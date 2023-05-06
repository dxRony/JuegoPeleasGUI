package com.mycompany.juegopeleasgui.be.terrenos;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Arbol extends Terreno {

    private static final String imagenArbol = "src\\main\\java\\iconos\\arbol.png";

    public Arbol(int tamaño) {

        super(tamaño);
        ImageIcon arbol = new ImageIcon(imagenArbol);
        this.setIcon(new ImageIcon(arbol.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH)));
        
        nombre = "T";
    }

}
