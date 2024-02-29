package s102exercici1;

public class VendaBuidaException extends Exception {
    private static String message;
    
    public VendaBuidaException(String message){
        super(message);
    }
    
}
