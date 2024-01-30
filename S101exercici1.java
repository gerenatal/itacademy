package s101exercici1;

// @author Geremias Bristot

public class S101exercici1 {

    public static void main(String[] args) {
        Instrument instrument = new Corda();
        Instrument instrument2 = new Corda();
        instrument.tocar();
        instrument2.tocar();
        System.out.println(instrument.nom);
        System.out.println(instrument2.nom);
        
    } 
}
