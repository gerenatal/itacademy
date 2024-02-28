package s101exercici1;

public class Vent extends Instrument {
    
    static{
        System.out.println("Llamando a la classe Vent");
    }
    
    public Vent (String nom, double preu){
        super(nom, preu);
    }
    
    @Override
    public void tocar(){
        System.out.println("Esta sonant un instrument de vent");
    }
}