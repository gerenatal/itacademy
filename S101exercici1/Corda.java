package s101exercici1;

public class Corda extends Instrument {
    
    static{
        System.out.println("Llamando a la classe Corda");
    }
    
    public Corda (String nom, double preu){
        super(nom, preu);
    }
    
    @Override
    public void tocar(){
        System.out.println("Esta sonant un instrument de corda");
    }
}
