package com.mycompany.s104exercici2;
import java.util.HashMap;
//@author Geremias Bristot

public class S104exercici2 {

    public static void main(String[] args) {
        CalculoDni secuencia = new CalculoDni();
        HashMap<Integer, Character> listaLetras = secuencia.getLetraDni();
        
        for(int i=1; i<= listaLetras.size(); i++){
            System.out.println(listaLetras.get(i));
        }
    }
}
