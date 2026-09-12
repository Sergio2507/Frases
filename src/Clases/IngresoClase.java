package Clases;
import java.util.Scanner;

public class IngresoClase {
    private Scanner scanner;

    public IngresoClase() {
        scanner = new Scanner(System.in);
    }

    public String ingresarFrase() {
        System.out.print("Ingresa una frase: ");
        return scanner.nextLine();
    }
}
