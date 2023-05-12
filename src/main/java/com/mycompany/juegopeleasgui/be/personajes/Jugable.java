package com.mycompany.juegopeleasgui.be.personajes;

import com.mycompany.juegopeleasgui.be.articulos.Articulo;
import com.mycompany.juegopeleasgui.be.articulos.mejoras.Dano;
import com.mycompany.juegopeleasgui.be.articulos.mejoras.Movilidad;
import com.mycompany.juegopeleasgui.be.articulos.mejoras.Vida;
import com.mycompany.juegopeleasgui.be.articulos.objetos.CapaDeMovilidad;
import com.mycompany.juegopeleasgui.be.articulos.objetos.ElixirVerde;
import com.mycompany.juegopeleasgui.be.articulos.objetos.SemillaDeLaVida;
import java.io.Serializable;
import javax.swing.JOptionPane;

public class Jugable extends Personaje implements Serializable {

    private int coste;

    public Jugable(int tamaño) {
        super(tamaño);
        probabilidadAtaque = 75;
        coste = 200;
    }

    public void adquirirValoresArticulo(Articulo articulos) {
        String mensaje = "nada :(";
        if (articulos instanceof CapaDeMovilidad) {
            mensaje = "Utilizaste: " + articulos.toString() + "\n Este articulo agrega 1 casilla de movimiento a tu personaje!!!";
            this.movimiento++;
        } else if (articulos instanceof Dano) {
            mensaje = "Utilizaste: " + articulos.toString();

        } else if (articulos instanceof ElixirVerde) {
            mensaje = "Utilizaste: " + articulos.toString() + "\n Este articulo cura 50 puntos de vida!!!";
            this.puntosDeVida += 50;

        } else if (articulos instanceof Movilidad) {
            mensaje = "Utilizaste: " + articulos.toString();

        } else if (articulos instanceof SemillaDeLaVida) {
            mensaje = "Utilizaste: " + articulos.toString();

        } else if (articulos instanceof Vida) {
            mensaje = "Utilizaste: " + articulos.toString() + "\n Este articulo agrega 50 puntos de vida!!!";
            this.puntosDeVida += 50;

        }
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public void aplicarArticulo(Articulo articulo) {
        this.adquirirValoresArticulo(articulo);
    }

    public int getCoste() {
        return coste;
    }

}
