package com.mycompany.juegopeleasgui.be.terrenos;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Planicie extends Terreno {

    public static final String imagenPlanicie = "src\\main\\java\\iconos\\planicie.png";

    public Planicie(int tamaño) {
        super(tamaño);
        ImageIcon planicie = new ImageIcon(imagenPlanicie);
        this.setIcon(new ImageIcon(planicie.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH)));      
        nombre = "-";
    }

    

}
