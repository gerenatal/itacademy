package s108exercici8;

//Geremias Bristot

public class S108exercici8 {

    public static void main(String[] args) {
        InterReverse interReverse = (name) -> {
            return new StringBuilder(name).reverse().toString();
        };
        
        System.out.println(interReverse.reverse("oditrevni ed olpmexe"));

    }
    
}
