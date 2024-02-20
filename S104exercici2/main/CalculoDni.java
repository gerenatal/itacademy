package com.mycompany.s104exercici2;
import java.util.HashMap;

public class CalculoDni {
    HashMap<Integer, Character> letraDni;
    private final char[] letras = new char[26];
    
    
    public CalculoDni(){
        letraDni = new HashMap<Integer, Character>();
        for (int i = 0; i < 26; i++) {
            letras[i] = (char) ('A' + i);
        }
        assignIndex();
    }
    
    public void assignIndex(){
        for(int i =1; i <= letras.length; i++){
            letraDni.put(i, letras[i-1]);
        }
        
    }
    
    public HashMap<Integer, Character> getLetraDni(){
        return letraDni;
    }
    
    public char[] getLetras(){
        return letras;
    }
    
}