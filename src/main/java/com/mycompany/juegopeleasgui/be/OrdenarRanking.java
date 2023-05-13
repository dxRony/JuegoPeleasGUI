package com.mycompany.juegopeleasgui.be;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class OrdenarRanking {

    private String rutaRanking = "src\\main\\java\\archivo\\ranking.txt";

    public OrdenarRanking() {

    }

    public String abrirArchivo() {
        String texto = "";
        try {
            File archivo = new File(rutaRanking);
            System.out.println("Abriendo... " + rutaRanking);
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

    public String[] ordenarJugadores(String txt, boolean asc) {
        String[] jugadores = extractJugadores(txt);
        for (int i = 0; i < jugadores.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < jugadores.length; j++) {

                int puntuacionActual = Integer.parseInt(jugadores[j].replaceAll("\\D+", ""));
                int puntuacionMinima = Integer.parseInt(jugadores[minIndex].replaceAll("\\D+", ""));
                boolean condicion = asc ? puntuacionActual > puntuacionMinima
                        : puntuacionActual < puntuacionMinima;
                if (condicion) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                String temp = jugadores[i];
                jugadores[i] = jugadores[minIndex];
                jugadores[minIndex] = temp;
            }
        }
        return jugadores;
    }

    private String[] extractJugadores(String txt) {
        return txt.split("(?=" + "Jugador" + ")");
    }

}
