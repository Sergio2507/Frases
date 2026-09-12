package Clases;

import Interfaces.Analisis;

public class AnalisisClase implements Analisis {
    private ConteoClase contador;
    private OracionClase oracion;

    public AnalisisClase() {
        contador = new ConteoClase();
        oracion = new OracionClase();
    }

    @Override
    public void mostrarInformacion(String texto) {
        System.out.println("Tamaño: " + texto.length());
        System.out.println("Vocales: " + contador.contarVocales(texto));
        System.out.println("Consonantes: " + contador.contarConsonantes(texto));
        System.out.println("Espacios: " + contador.contarEspacios(texto));
        System.out.println("Números: " + contador.contarNumeros(texto));
        System.out.println("Palabras: " + contador.contarPalabras(texto));
        System.out.println("Mayúsculas: " + contador.contarMayusculas(texto));
        System.out.println("Minúsculas: " + contador.contarMinusculas(texto));

        if (oracion.esOracion(texto)) {
            System.out.println("Es una oración porque contiene el conector: " + oracion.obtenerContector(texto));
        } else {
            System.out.println("No es una oración porque no contiene un conector.");
        }
    }
}