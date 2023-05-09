package com.mycompany.juegopeleasgui.be;

import com.mycompany.juegopeleasgui.be.jugadores.IA;
import com.mycompany.juegopeleasgui.be.jugadores.Usuario;
import com.mycompany.juegopeleasgui.be.tablero.Tablero;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class CrearTablero {

    private String rutaTablero = "src\\main\\java\\archivo\\tableros.txt";
    private Tablero nuevoTablero;
    private Usuario usuario;
    private IA ia;
    private int dificultad;

    public CrearTablero(Usuario usuario, IA ia) {
        this.usuario = usuario;
        this.ia = ia;
        nuevoTablero = null;
        dificultad = ia.getDificultad();

    }

    public void leerArchivo() { //Para crear mapas
        File f;
        BufferedReader br = null;
        String cadena;
        f = new File(rutaTablero);
        int conteo = 0;
        dificultad = ia.getDificultad();
        if (f.exists()) {
            try {
                br = new BufferedReader(new FileReader(f));
                while ((cadena = br.readLine()) != null) {
                    String id = " ";
                    if (cadena.contains("tablero")) {
                        String[] identificador = cadena.split("<<");
                        String[] nombreId = identificador[1].split(">>");
                        id = nombreId[0];
                    } else if (cadena.contains("dimension")) {
                        String[] dimension1 = cadena.split(" ");
                        String[] dimensiones = dimension1[1].split("X");

                        nuevoTablero = new Tablero(usuario, ia, id, Integer.parseInt(dimensiones[0]), Integer.parseInt(dimensiones[1]));
                        nuevoTablero.crearTableroVacio();
                        conteo = 0;
                    } else if (nuevoTablero != null) {
                        nuevoTablero.agregarLineas(cadena, conteo, dificultad);
                        conteo++;
                    }
                }
                nuevoTablero.pintarMapa();

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Archivo inexistente");
        }
    }

    public Tablero getNuevoTablero() {
        return nuevoTablero;
    }

}
