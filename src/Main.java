import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingresa la frase:");
        String texto = leer.nextLine();

        if (texto.length()>=100) {
            System.out.println("Ta muy larga la frase");
        } else {
            Frase frase = new Frase(texto);
            frase.mostrarInformacion();
            frase.mostrarPalabras();
        }
        leer.close();
    }
}