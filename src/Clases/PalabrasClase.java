package Clases;

import Interfaces.Palabras;

public class PalabrasClase implements Palabras {

    @Override
    public void mostrarPalabra(String texto) {
        if (texto.trim().isEmpty()) {
            return;
        }
        String[] lista = texto.trim().split("\\s+");
        for (int y = 0; y < lista.length; y++) {
            String palabra = lista[y];
            System.out.println("\nLa palabra " + (y + 1) + ": " + palabra);
            System.out.println(
                    "Tiene " + palabra.length() + " caracteres"
            );
            for (int i = 0; i < palabra.length(); i++) {
                char caracter = palabra.charAt(i);
                int contador = 0;
                for (int j = 0; j < palabra.length(); j++) {
                    if (palabra.charAt(j) == caracter) {
                        contador++;
                    }
                }
                boolean repetido = false;
                for (int j = 0; j < i; j++) {
                    if (palabra.charAt(j) == caracter) {
                        repetido = true;
                        break;
                    }
                }
                if (!repetido) {
                    System.out.println(
                            caracter + ": " + contador
                    );
                }
            }
        }
    }
}