package com.mycompany.juegopeleasgui.be;

import com.mycompany.juegopeleasgui.be.tablero.Tablero;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Archivo {

    private String rutaTablero = "src\\main\\java\\archivo\\tableros.txt";

    public void leerArchivo() { //Para crear mapas
        File f;
        BufferedReader br = null;
        String cadena;
        f = new File(rutaTablero);
        Tablero nuevoTablero = null;
        int conteo = 0;
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
                        nuevoTablero.crearTableroVacio();
                        conteo = 0;
                    } else if (nuevoTablero != null) {
                        nuevoTablero.agregarLinea(cadena, conteo);
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
}
