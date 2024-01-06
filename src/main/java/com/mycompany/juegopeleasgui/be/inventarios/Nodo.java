package com.mycompany.juegopeleasgui.be.inventarios;

import java.io.Serializable;

public class Nodo<T> implements Serializable {

    protected T contenido;
    protected Nodo<T> siguiente;
    protected int indice;

    public Nodo(T contenido) {
        this.contenido = contenido;
        this.siguiente = null;
    }

    public T getContenido() {
        return contenido;
    }

    public void setContenido(T contenido) {
        this.contenido = contenido;
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }
}
