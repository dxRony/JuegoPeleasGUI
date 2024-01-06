package com.mycompany.juegopeleasgui.be.inventarios;

import java.io.Serializable;

public class ListaGenerica<T> implements Serializable {

    private Nodo<T> primero;
    private Nodo<T> ultimo;
    private Nodo<T> actual;
    private Nodo<T> previo;
    private String lista;
    private int tamano = 0;

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
        tamano++;
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

    public void eliminarUltimo() {
        if (tamano == 1) {
            primero = null;
            ultimo = null;
            tamano = 0;
        } else {
            int penultimoIndice = tamano - 2;
            Nodo<T> penultimo = getNodo(penultimoIndice);
            penultimo.setSiguiente(null);
            ultimo = penultimo;
            tamano--;
        }
    }

    public void vaciarLista() {
        while (!listaVacia()) {
            eliminarUltimo();
        }
    }

    public boolean listaVacia() {
        return primero == null;
    }
    
    public void eliminar(int dato) {
        Nodo actual = primero;
        Nodo previo = null;

        // Caso especial si el nodo a eliminar es la cabeza
        if (actual != null && actual.indice == dato) {
            primero = actual.siguiente;
            return;
        }

        // Buscar el nodo a eliminar y mantener un enlace al nodo anterior
        while (actual != null && actual.indice != dato) {
            previo = actual;
            actual = actual.siguiente;
        }

        // Si el nodo no está presente en la lista
        if (actual == null) {
            return;
        }

        // Desenlazar el nodo a eliminar
        previo.siguiente = actual.siguiente;
    }

    public void setLista(String lista) {
        this.lista = lista;
    }

    private Nodo<T> getNodo(int indice) {

        Nodo<T> nodoActual = primero;
        for (int i = 0; i < indice; i++) {
            Nodo siguiente = nodoActual.getSiguiente();
            nodoActual = siguiente;
        }

        return nodoActual;
    }

    public int getTamano() {
        return tamano;
    }

}
