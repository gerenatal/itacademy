package s101exercici1;

public class Corda extends Instrument {
    public Corda (){
        super(nom, preu);
        System.out.println("Calling constructor");
    }
    
    static{
        nom = "Violao";
        System.out.println("Calling static block");
    }
    
    @Override
    public void tocar(){
        System.out.println("Esta sonant un instrument de corda");
    }
}
