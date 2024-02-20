package com.mycompany.s104exercici3;

//@Author Geremias Bristot
public class S104exercici3 {

    public static void main(String[] args) {
        Fibonacci lista1 = new Fibonacci(10);
        int[] lista = lista1.getLista();
        for(int i = 0; i<10; i++){
            System.out.println(lista[i]);
        }
    }
}
