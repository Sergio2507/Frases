package Clases;

import Clases.AnalisisClase;
import Clases.IngresoClase;
import Clases.MenuClase;
import Clases.PalabrasClase;

import java.util.Scanner;

public class Frase {

    private String texto;
    private MenuClase menu;
    private IngresoClase ingreso;
    private AnalisisClase analisis;
    private PalabrasClase palabras;

    public Frase() {
        texto = "";
        menu = new MenuClase();
        ingreso = new IngresoClase();
        analisis = new AnalisisClase();
        palabras = new PalabrasClase();
    }

    public void ejecutar() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            menu.mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    texto = ingreso.ingresarFrase();
                    System.out.println(
                            "\nFrase guardada correctamente."
                    );
                    break;
                case 2:
                    if (texto.trim().isEmpty()) {
                        System.out.println(
                                "\nPrimero debes ingresar una frase."
                        );
                    } else {
                        analisis.mostrarInformacion(texto);
                    }
                    break;
                case 3:
                    if (texto.trim().isEmpty()) {
                        System.out.println(
                                "\nPrimero debes ingresar una frase."
                        );
                    } else {
                        palabras.mostrarPalabra(texto);
                    }
                    break;
                case 4:
                    System.out.println(
                            "\nPrograma finalizado."
                    );
                    break;
                default:
                    System.out.println(
                            "\nOpción no válida."
                    );
            }
        } while (opcion != 4);
    }
}