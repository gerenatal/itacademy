package s101exercici2;

// @author Geremias Bristot

public class S101exercici2 {

    public static void main(String[] args) {
        Cotxe uno = new Cotxe("2024");
        
        uno.accelerar(); //public needs an instance
        Cotxe.frenar(); // static belongs to class, doesn't need instance
        System.out.println(uno.toString());
    }
    
}
