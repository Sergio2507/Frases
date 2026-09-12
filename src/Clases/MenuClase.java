package Clases;

import java.util.Scanner;
import Interfaces.Menu;

public class MenuClase implements Menu {

    private Scanner scanner;
    public MenuClase() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void mostrarMenu() {
        System.out.println("1. Ingresar frase");
        System.out.println("2. Mostrar información");
        System.out.println("3. Mostrar palabras");
        System.out.println("4. Salir");
        System.out.print("Selecciona una opción: ");
    }
}