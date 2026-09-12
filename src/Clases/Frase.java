package Clases;

import java.util.Scanner;
import Interfaces.IngresoFrase;
import Interfaces.Contador;
import Interfaces.Menu;

public class Frase implements Menu, IngresoFrase, Contador {
    private String texto;
    private int vocales;
    private int consonantes;
    private int espacios;
    private int numeros;
    private int palabras;
    private int mayusculas;
    private int minusculas;
    private boolean esOracion;
    private String conectorEncontrado;

    public Frase(){
        texto="";
    }

    public Frase(String texto) {
        this.texto = texto;
        analizar();
    }

    @Override
    public void ingresarFrase() {

    Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa una frase:");
        texto = scanner.nextLine();
        analizar();
        if (texto.length()>=100) {
            System.out.println("Ta muy larga la frase");
        } else {
            Frase frase = new Frase(texto);
            frase.mostrarInformacion();
            frase.mostrarPalabras();
        }
        System.out.println("\nFrase guardada correctamente.");
}

@Override
public void mostrarMenu() {

    Scanner scanner = new Scanner(System.in);
    int opcion;
    do {
        System.out.println("1. Ingresar frase");
        System.out.println("2. Mostrar información");
        System.out.println("3. Mostrar palabras");
        System.out.println("4. Salir");
        System.out.print("Selecciona una opción: ");
        opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                ingresarFrase();
                break;
            case 2:
                mostrarInformacion();
                break;
            case 3:
                mostrarPalabras();
                break;
            case 4:
                System.out.println("\nPrograma finalizado.");
                break;
            default:
                System.out.println("\nOpción no válida.");
        }

    } while (opcion != 4);
}

    private void analizar() {
        vocales = 0;
        consonantes = 0;
        espacios = 0;
        numeros = 0;
        palabras = 0;
        mayusculas = 0;
        minusculas = 0;
        if (!texto.trim().isEmpty()) {
            palabras = 1;
        }
        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);
            if (esVocal(caracter)) {
                vocales++;
            } else if (Character.isDigit(caracter)) {
                numeros++;
            } else if (caracter == ' ') {
                espacios++;
                if (i < texto.length() - 1 && texto.charAt(i + 1) != ' ') {
                    palabras++;
                }
            } else if (Character.isLetter(caracter)) {
                consonantes++;
            }
            if (Character.isUpperCase(caracter)) {
                mayusculas++;
            }
            if (Character.isLowerCase(caracter)) {
                minusculas++;
            }
        }
        buscarConector();
    }

    private boolean esVocal(char caracter) {
        caracter = Character.toLowerCase(caracter);
        return caracter == 'a' || caracter == 'e' || caracter == 'i' || caracter == 'o' || caracter == 'u';
    }

    private void buscarConector() {
        esOracion = false;
        conectorEncontrado = "";
        if (texto.trim().isEmpty()) {
            return;
        }

        String[] lista = texto.trim().split("\\s+");
        for (String palabra : lista) {
            String palabraLimpia = palabra.toLowerCase().replaceAll("[.,!?;:]", "");
            if (esConector(palabraLimpia)) {
                esOracion = true;
                conectorEncontrado = palabraLimpia;
                break;
            }
        }
    }

    private boolean esConector(String palabra) {
        return palabra.equals("y") || palabra.equals("o") || palabra.equals("pero") || palabra.equals("porque") || palabra.equals("aunque")
                || palabra.equals("que") || palabra.equals("cuando") || palabra.equals("si") || palabra.equals("mientras") || palabra.equals("ni")
                || palabra.equals("sino") || palabra.equals("ademas") || palabra.equals("ya") || palabra.equals("pues");
    }

    public void mostrarInformacion() {
        System.out.println("El tamaño de la frase es de: " + texto.length());
        System.out.println("Las vocales de la frase son: " + vocales);
        System.out.println("Las consonantes de la frase son: " + consonantes);
        System.out.println("Los espacios de la frase son: " + espacios);
        System.out.println("Los números de la frase son: " + numeros);
        System.out.println("Las palabras de la frase son: " + palabras);
        System.out.println("Las mayúsculas de la frase son: " + mayusculas);
        System.out.println("Las minúsculas de la frase son: " + minusculas);

        if (esOracion) {
            System.out.println("La frase SI es una oración porque contiene el conector: " + conectorEncontrado);
        } else{
            System.out.println("La frase NO es una oración porque no contiene un conector.");
        }
    }

    public void mostrarPalabras() {
        if (texto.trim().isEmpty()) {
            return;
        }
        String[] lista = texto.trim().split("\\s+");

        for (int y = 0; y < lista.length; y++) {
            String palabra = lista[y];
            System.out.println("\nLa palabra " + (y + 1) + ": " + palabra);
            System.out.println("Tiene " + palabra.length() + " caracteres");
            for (int i = 0; i < palabra.length(); i++) {
                char caracterMomento = palabra.charAt(i);
                int contar = 0;
                for (int z = 0; z < palabra.length(); z++) {
                    if (palabra.charAt(z) == caracterMomento) {
                        contar++;
                    }
                }
                boolean yaSalio = false;
                for (int z = 0; z < i; z++) {
                    if (palabra.charAt(z) == caracterMomento) {
                        yaSalio = true;
                        break;
                    }
                }
                if (!yaSalio) {
                    System.out.println(caracterMomento + ": " + contar);
                }
            }
        }
    }
}