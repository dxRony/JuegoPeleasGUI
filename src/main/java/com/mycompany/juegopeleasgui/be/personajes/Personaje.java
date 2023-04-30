package com.mycompany.juegopeleasgui.be.personajes;

import java.util.Random;

public class Personaje {

    protected String nombre;
    protected int puntosDeVida;
    protected int probabilidadAtaque;
    protected int puntosAtaque;
    protected int movimiento;
    protected int danoRecibido;
    protected boolean vuela;
    protected int distanciaAtaque;

    public int calcularDano() {
        int danoHecho = 0;
        Random ran = new Random();
        int probabilidad = ran.nextInt(100);
        if (probabilidad <= probabilidadAtaque) {
            System.out.println("La probabildad de ataque fue: " + probabilidad + " (si la probabilidad es menor o igual a " + probabilidadAtaque + ", se acierta el ataque) ");
            danoHecho = puntosAtaque;
        } else {
            System.out.println("La probabildad de ataque fue: " + probabilidad + " (si la probabilidad es mayor a " + probabilidadAtaque + ", se anula el ataque) ");
        }
        System.out.println("El dano realizado es: " + danoHecho);
        return danoHecho;
    }

    public void recibirDano(Personaje personajeAtacante) {
        int danoHecho = personajeAtacante.calcularDano();
        if (danoHecho > 0) {
            danoRecibido = danoHecho;
        }
        puntosDeVida = this.getPuntosDeVida();
        puntosDeVida = puntosDeVida - danoRecibido;
        if (puntosDeVida < 0) {
            puntosDeVida = 0;
        }
    }

    public void ataque(Personaje personajeAtacado) {
        personajeAtacado.recibirDano(this);
    }

    public boolean estaVivo() {
        return puntosDeVida > 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntosDeVida() {
        return puntosDeVida;
    }

    public int getProbabilidadAtaque() {
        return probabilidadAtaque;
    }

    public int getPuntosAtaque() {
        return puntosAtaque;
    }

    public int getMovimiento() {
        return movimiento;
    }

    public int getDanoRecibido() {
        return danoRecibido;
    }

    public boolean isVuela() {
        return vuela;
    }

    public int getDistanciaAtaque() {
        return distanciaAtaque;
    }

    public String toString() {
        return nombre;
    }
}
