package com.mycompany.juegopeleasgui.be;

import com.mycompany.juegopeleasgui.be.tablero.Tablero;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Archivo {

    public void leerArchivo(String nombreArchivo) { //Para crear mapas
        File f;
        BufferedReader br = null;
        String cadena;
        String[] verificarExtension = nombreArchivo.split("\\.");
        f = new File(verificarExtension[0] + ".th");
        Tablero nuevoTablero = null;

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

                        nuevoTablero = new Tablero(id, Integer.parseInt(dimensiones[0]), Integer.parseInt(dimensiones[1]));
                        nuevoTablero.crearCasillas(cadena.split(","));
                    }
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Archivo inexistente");
        }
    }
}
