package com.mycompany.juegopeleasgui.be;

public class OrdenarTableros {

    private String rutaTablero = "src\\main\\java\\archivo\\tableros.txt";

    private String[] extractTableros(String txt) {//separa los tableros del archivo
        return txt.split("(?=" + "tablero" + ")");
    }

    public String[] ordenarTableros(String txt, boolean asc) {//los ordena dependiendo del booleano que se le manda como parametro
        String[] tableros = extractTableros(txt);//ordenamiento por seleccion
        for (int i = 0; i < tableros.length - 1; i++) {
            int minIndex = i;//posicion minima
            for (int j = i + 1; j < tableros.length; j++) {
                boolean condicion = asc ? tableros[j].length() > tableros[minIndex].length()
                        : tableros[j].length() < tableros[minIndex].length();
                if (condicion) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                String temp = tableros[i];
                tableros[i] = tableros[minIndex];
                tableros[minIndex] = temp;
            }
        }
        return tableros;
    }
}
