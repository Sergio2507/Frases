package Clases;
import Interfaces.Conteo;

public class ConteoClase implements Conteo {

    @Override
    public int contarVocales(String texto) {
        int contador = 0;
        for (int i = 0; i < texto.length(); i++) {
            char caracter = Character.toLowerCase(texto.charAt(i));
            if (caracter == 'a' || caracter == 'e' || caracter == 'i' || caracter == 'o' || caracter == 'u') {
                contador++;
            }
        }
        return contador;
    }

    @Override
    public int contarConsonantes(String texto) {
        int contador = 0;
        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);
            if (Character.isLetter(caracter) &&
                    !esVocal(caracter)) {
                contador++;
            }
        }
        return contador;
    }

    private boolean esVocal(char caracter) {
        caracter = Character.toLowerCase(caracter);
        return caracter == 'a' || caracter == 'e' || caracter == 'i' || caracter == 'o' || caracter == 'u';
    }

    @Override
    public int contarEspacios(String texto) {
        int contador = 0;
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == ' ') {
                contador++;
            }
        }
        return contador;
    }

    @Override
    public int contarNumeros(String texto) {
        int contador = 0;
        for (int i = 0; i < texto.length(); i++) {
            if (Character.isDigit(texto.charAt(i))) {
                contador++;
            }
        }
        return contador;
    }

    @Override
    public int contarPalabras(String texto) {
        if (texto.trim().isEmpty()) {
            return 0;
        }
        return texto.trim().split("\\s+").length;
    }
    @Override
    public int contarMayusculas(String texto) {
        int contador = 0;
        for (int i = 0; i < texto.length(); i++) {
            if (Character.isUpperCase(texto.charAt(i))) {
                contador++;
            }
        }
        return contador;
    }

    @Override
    public int contarMinusculas(String texto) {
        int contador = 0;
        for (int i = 0; i < texto.length(); i++) {
            if (Character.isLowerCase(texto.charAt(i))) {
                contador++;
            }
        }
        return contador;
    }
}