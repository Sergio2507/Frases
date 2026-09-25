package Clases;

import Interfaces.Historial;
import java.util.ArrayList;

public class HistorialClase implements Historial {

    private ArrayList<String> frases;
    public HistorialClase(){
        frases=new ArrayList<>();
    }

    @Override
    public void agregarFrase(String frase){
        if (!frase.trim().isEmpty()){
            frases.add(frase);
        }
    }

    @Override
    public void mostrarHistorial(){
        System.out.println("Historial");
        if(frases.isEmpty()){
            System.out.println("No hay frases previas");
            return;
        }
        for(int i=0;i<frases.size();i++){
            System.out.println((i+1)+". "+frases.get(i));
        }
    }
}
