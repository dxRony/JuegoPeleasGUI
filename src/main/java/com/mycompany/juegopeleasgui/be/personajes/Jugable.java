package com.mycompany.juegopeleasgui.be.personajes;

import com.mycompany.juegopeleasgui.be.articulos.Articulo;

public class Jugable extends Personaje {

    private int coste;
    private Articulo articulos = new Articulo();

    public Jugable(int tamaño) {
        super(tamaño);
        probabilidadAtaque = 75;
        coste = 200;
    }

    public void adquirirValoresArticulo(Articulo articulos) {
        int vidaArticulo = articulos.getVida();
        int danoArticulo = articulos.getDano();
        int movilidadArticulo = articulos.getMovilidad();
        int movimientoArticulo = articulos.getMovimiento();
        if (vidaArticulo != 0) {
            puntosDeVida += vidaArticulo;
            System.out.println("Le has agregado 50 pts de vida a tu personaje!!!");
        } else if (danoArticulo != 0) {
            puntosAtaque += danoArticulo;
            System.out.println("Le has agregado 50 pts de ataque a tu personaje!!!");

        } else if (movilidadArticulo != 0) {
            movimiento += movilidadArticulo;
            System.out.println("Le has agregado 50 pts de movilidad a tu personaje!!!");

        } else if (movimientoArticulo != 0) {
            movimiento += movilidadArticulo;
            System.out.println("Le has agregado 50 pts de movimiento a tu personaje!!!");
        }
    }

    public void aplicarArticulo(Articulo articulo) {
        this.adquirirValoresArticulo(articulo);
    }

    public int getCoste() {
        return coste;
    }
}
