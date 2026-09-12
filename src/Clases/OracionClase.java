package Clases;

import Interfaces.Oracion;

public class OracionClase implements Oracion {

    @Override
    public boolean esOracion(String texto) {
        return !obtenerContector(texto).isEmpty();
    }

    @Override
    public String obtenerContector(String texto) {
        if (texto.trim().isEmpty()) {
            return "";
        }
        String[] lista = texto.trim().split("\\s+");
        for (String palabra : lista) {
            String palabraLimpia =
                    palabra.toLowerCase()
                            .replaceAll("[.,!?;:]", "");
            if (esConector(palabraLimpia)) {
                return palabraLimpia;
            }
        }
        return "";
    }

    private boolean esConector(String palabra) {
        return palabra.equals("y") || palabra.equals("o") || palabra.equals("pero") || palabra.equals("porque") ||
                palabra.equals("aunque") || palabra.equals("que") || palabra.equals("cuando") || palabra.equals("si") ||
                palabra.equals("mientras") || palabra.equals("ni") || palabra.equals("sino") || palabra.equals("ademas") ||
                palabra.equals("ya") || palabra.equals("pues");
    }
}