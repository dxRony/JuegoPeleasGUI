package com.mycompany.juegopeleasgui.be;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Archivo {

    private String RUTA = "src\\main\\java\\archivo\\tableros.txt";

    public String abrirArchivo() {

        String texto = "";
        try {
            File archivo = new File(RUTA);
            System.out.println("Abriendo... " + RUTA);
            FileReader lector = new FileReader(archivo);
            BufferedReader buffer = new BufferedReader(lector);
            String linea;
            while ((linea = buffer.readLine()) != null) {
                texto += linea + "\n";
            }
            buffer.close();
            lector.close();
            System.out.println(texto);
        } catch (IOException error) {
            System.out.println(error);
        }
        return texto;
    }

    public void guardarArchivo(String texto) {
        try {
            File archivo = new File(RUTA);
            FileWriter escritor = new FileWriter(archivo, false);
            BufferedWriter buffer = new BufferedWriter(escritor);
            buffer.write(texto);

            buffer.close();
            escritor.close();
            System.out.println("El archivo ha sido guardado");

        } catch (IOException error) {

            System.out.println(error);
        }
    }
}
