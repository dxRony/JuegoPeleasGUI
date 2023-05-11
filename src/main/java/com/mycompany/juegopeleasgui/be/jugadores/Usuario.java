package com.mycompany.juegopeleasgui.be.jugadores;

import com.mycompany.juegopeleasgui.be.articulos.Articulo;
import com.mycompany.juegopeleasgui.be.articulos.ArticuloVacio;
import com.mycompany.juegopeleasgui.be.articulos.mejoras.Dano;
import com.mycompany.juegopeleasgui.be.articulos.mejoras.Movilidad;
import com.mycompany.juegopeleasgui.be.articulos.mejoras.Vida;
import com.mycompany.juegopeleasgui.be.articulos.objetos.CapaDeMovilidad;
import com.mycompany.juegopeleasgui.be.articulos.objetos.ElixirVerde;
import com.mycompany.juegopeleasgui.be.articulos.objetos.SemillaDeLaVida;
import com.mycompany.juegopeleasgui.be.inventarios.ListaGenerica;
import com.mycompany.juegopeleasgui.be.personajes.Jugable;
import com.mycompany.juegopeleasgui.be.personajes.personajeJugable.Arquero;
import com.mycompany.juegopeleasgui.be.personajes.personajeJugable.Caballero;
import com.mycompany.juegopeleasgui.be.personajes.personajeJugable.Dragon;
import com.mycompany.juegopeleasgui.be.personajes.personajeJugable.Gigante;
import com.mycompany.juegopeleasgui.be.personajes.personajeJugable.JugableVacio;
import com.mycompany.juegopeleasgui.be.personajes.personajeJugable.Mago;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Usuario extends Jugador implements Serializable {

    private int oro;
    private Jugable[] listaJugables;
    private Articulo[] listaArticulos;
    private Jugable personajePrincipalUsuario;
    private ListaGenerica<Jugable> inventarioUsuario;
    private ListaGenerica<Articulo> inventarioArticulos;

    public Usuario() {
        oro = 500;
        listaArticulos = new Articulo[7];
        listaJugables = new Jugable[6];
        personajePrincipalUsuario = new Jugable(80);
        listaJugables[0] = new Caballero(70);
        listaJugables[1] = new Arquero(80);
        listaJugables[2] = new Dragon(80);
        listaJugables[3] = new Gigante(80);
        listaJugables[4] = new Mago(80);
        listaJugables[5] = new JugableVacio(1);
        listaArticulos[0] = new CapaDeMovilidad();
        listaArticulos[1] = new Dano();
        listaArticulos[2] = new ElixirVerde();
        listaArticulos[3] = new Movilidad();
        listaArticulos[4] = new SemillaDeLaVida();
        listaArticulos[5] = new Vida();
        listaArticulos[6] = new ArticuloVacio();
        inventarioUsuario = new ListaGenerica<Jugable>();
        inventarioArticulos = new ListaGenerica<Articulo>();
    }

    public void comprarJugables(Jugable personaje, int oro) {

        if (this.oro >= personaje.getCoste()) {
            this.oro -= personaje.getCoste();
            inventarioUsuario.agregar(personaje);
            System.out.println("Compraste al: " + personaje.getNombre());
            System.out.println("Tienes: " + this.oro + " de oro");
            return;
        }
        System.out.println("No tienes el oro suficiente");
        JOptionPane.showMessageDialog(null, "No tienes el oro suficiente");
        inventarioUsuario.pintarLista();
    }

    public void comprarArticulos(Articulo articulo, int oro) {

        if (this.oro >= articulo.getCoste()) {
            this.oro -= articulo.getCoste();
            inventarioArticulos.agregar(articulo);
            System.out.println("Compraste: " + articulo.getNombre());
            System.out.println("Tienes: " + this.oro + " de oro");
            return;
        }
        System.out.println("No tienes el oro suficiente");
        JOptionPane.showMessageDialog(null, "No tienes el oro suficiente");
    }

    public void almacenarPrincipalUsuario(int personaje) {

        this.personajePrincipalUsuario = inventarioUsuario.seleccionar(personaje);
        System.out.println("Tu personaje principal es: " + personajePrincipalUsuario.getNombre());
    }

    public int getOro() {
        return oro;
    }

    public Jugable[] getListaJugables() {
        return listaJugables;
    }

    public Articulo[] getListaArticulos() {
        return listaArticulos;
    }

    public Jugable getPersonajePrincipalUsuario() {
        return personajePrincipalUsuario;
    }

    public ListaGenerica<Jugable> getInventarioUsuario() {
        return inventarioUsuario;
    }

    public ListaGenerica<Articulo> getInventarioArticulos() {
        return inventarioArticulos;
    }

    public void activarBotonesMovimiento(JLabel lblDireccion, JButton btnArriba, JButton btnAbajo, JButton btnDerecha, JButton btnIzuierda) {
        lblDireccion.setVisible(true);
        btnArriba.setVisible(true);
        btnArriba.setEnabled(true);
        btnAbajo.setVisible(true);
        btnAbajo.setEnabled(true);
        btnDerecha.setVisible(true);
        btnDerecha.setEnabled(true);
        btnIzuierda.setVisible(true);
        btnIzuierda.setEnabled(true);
    }

    public void desactivarBotonesMovimiento(JLabel lblDireccion, JButton btnArriba, JButton btnAbajo, JButton btnDerecha, JButton btnIzuierda) {
        lblDireccion.setVisible(false);
        btnArriba.setVisible(false);
        btnArriba.setEnabled(false);
        btnAbajo.setVisible(false);
        btnAbajo.setEnabled(false);
        btnDerecha.setVisible(false);
        btnDerecha.setEnabled(false);
        btnIzuierda.setVisible(false);
        btnIzuierda.setEnabled(false);
    }

    public void activarBotonesAtaque(JLabel lblAtaque, JButton btnArriba, JButton btnAbajo, JButton btnDerecha, JButton btnIzuierda) {
        lblAtaque.setVisible(true);
        btnArriba.setVisible(true);
        btnArriba.setEnabled(true);
        btnAbajo.setVisible(true);
        btnAbajo.setEnabled(true);
        btnDerecha.setVisible(true);
        btnDerecha.setEnabled(true);
        btnIzuierda.setVisible(true);
        btnIzuierda.setEnabled(true);
    }

    public void desactivarBotonesAtaque(JLabel lblAtaque, JButton btnArriba, JButton btnAbajo, JButton btnDerecha, JButton btnIzuierda) {
        lblAtaque.setVisible(false);
        btnArriba.setVisible(false);
        btnArriba.setEnabled(false);
        btnAbajo.setVisible(false);
        btnAbajo.setEnabled(false);
        btnDerecha.setVisible(false);
        btnDerecha.setEnabled(false);
        btnIzuierda.setVisible(false);
        btnIzuierda.setEnabled(false);
    }

    public void guardarJugador(Usuario usuario) {
        try {
            ObjectOutputStream escribirUsuario = new ObjectOutputStream(new FileOutputStream("src\\main\\java\\archivo\\usuarios.bin"));
            escribirUsuario.writeObject(usuario);
            escribirUsuario.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void cargarJugador() {
        try {
            ObjectInputStream leerUsuario = new ObjectInputStream(new FileInputStream("src\\main\\java\\archivo\\usuarios.bin"));
            Usuario miObjetoLeido = (Usuario) leerUsuario.readObject();
            leerUsuario.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
