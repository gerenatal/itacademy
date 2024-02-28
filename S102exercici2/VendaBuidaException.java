package s102exercici1;

public class VendaBuidaException extends Exception {
    private static String message;
    
    public VendaBuidaException(){
        super("Per fer una venda primer has d afegir productes");
    }
    
}
