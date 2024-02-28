package s101exercici1;

// @author Geremias Bristot

public class S101exercici1 {

    public static void main(String[] args) {
        Corda guitarra = new Corda("guitarra", 300);
        Vent flauta = new Vent("flauta", 250);
        Percussio tambor = new Percussio("tambor", 725);
        
        guitarra.tocar();
        flauta.tocar();
        tambor.tocar();
        
    } 
}
