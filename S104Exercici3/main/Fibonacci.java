package com.mycompany.s104exercici3;

public class Fibonacci {
    private int[] lista;
    private int cantidad;
    
    public Fibonacci(int cantidad){
        this.cantidad = cantidad;
        if (cantidad <= 0) {
            throw new IllegalArgumentException("Cantidad must be positive");
        }
        lista = new int[cantidad];
        listaElementos();
    }
    
    public void listaElementos(){
        
        switch(cantidad){
            case 1:
                lista[0] = 1;
                break;
            case 2:
                lista[0] = 1;
                lista[1] = 1;
                break;
            default:
                lista[0] = 1;
                lista[1] = 1;
                for(int i = 2; i < cantidad; i++){
                    lista[i] = lista[i-1]+lista[i-2];
                }
                
        }
    }
    
    public int[] getLista(){
        return lista;
    }
}
