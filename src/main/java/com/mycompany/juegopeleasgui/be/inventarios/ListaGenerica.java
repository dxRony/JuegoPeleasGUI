package com.mycompany.juegopeleasgui.be.inventarios;

import java.io.Serializable;

public class ListaGenerica<T> implements Serializable {

    private Nodo<T> primero;
    private String lista;

    public ListaGenerica() {
        this.primero = null;
        lista = "";
    }

    public void agregar(T contenido) {
        Nodo<T> nuevo = new Nodo<T>(contenido);
        if (this.primero == null) {
            this.primero = nuevo;
        } else {
            Nodo<T> actual = this.primero;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }
    }

    public T seleccionar(int indice) {
        Nodo<T> actual = this.primero;
        int contador = 0;
        while (actual != null) {
            if (contador == indice) {
                return actual.getContenido();
            }
            contador++;
            actual = actual.getSiguiente();
        }
        return null;
    }

    public void pintarLista() {
        Nodo<T> actual = this.primero;
        while (actual != null) {
            System.out.println(actual.getContenido());
            actual = actual.getSiguiente();
        }
    }

    public String mostrarLista() {
        Nodo<T> recorrido = primero;
        int indice = 0;

        while (recorrido != null) {
            indice++;
            lista += "" + indice + ".- " + recorrido.contenido + "\n";
            recorrido = recorrido.siguiente;
        }
        return lista;
    }

    public int getTamaño() {
        Nodo<T> recorrido = primero;
        int tamano = 0;
        while (recorrido != null) {
            tamano++;
        }
        return tamano;
    }

    public void setLista(String lista) {
        this.lista = lista;
    }

}
