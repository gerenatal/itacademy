package s101exercici1;

public class Percussio extends Instrument {
    
    static{
        System.out.println("Llamando a la classe Percussio");
    }
    
    public Percussio (String nom, double preu){
        super(nom, preu);
    }
    
    @Override
    public void tocar(){
        System.out.println("Esta sonant un instrument de percussio");
    }
}