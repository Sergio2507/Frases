package Clases;
import java.util.Scanner;

public class IngresoClase {
    private Scanner scanner;

    public IngresoClase() {
        scanner = new Scanner(System.in);
    }

    public String ingresarFrase() {
        try {
            System.out.print("Ingresa una frase: ");
            String frase= scanner.nextLine();
            if(frase.trim().isEmpty()){
                throw new IllegalArgumentException("No puede estar vacio");
            }
            return frase;
        }catch (IllegalArgumentException e){
            System.out.println("Error "+e.getMessage());
            return "";
        }
    }
}
