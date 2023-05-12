package com.mycompany.juegopeleasgui.be.jugadores;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GuardarJugador {

    private String ruta = "src\\main\\java\\archivo\\usuarios.bin";

    public void guardarArchivoBinario(Usuario usuario) {
        try {
            FileOutputStream archivoSalida = new FileOutputStream(ruta);
            ObjectOutputStream objetoSalida = new ObjectOutputStream(archivoSalida);

            objetoSalida.writeObject(usuario);

            objetoSalida.close();
            archivoSalida.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Usuario leerArchivoBinario() {
        try {
            FileInputStream archivoEntrada = new FileInputStream(ruta);
            ObjectInputStream objetoEntrada = new ObjectInputStream(archivoEntrada);

            Usuario usuarioLeido = (Usuario) objetoEntrada.readObject();

            objetoEntrada.close();
            archivoEntrada.close();
            return usuarioLeido;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }
}
