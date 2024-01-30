package s102exercici1;

//@author Geremias Bristot

public class S102exercici1 {

    public static void main(String[] args) throws VendaBuidaException{
        Producte azucar = new Producte("azucar",2);
        Producte chocolata = new Producte("chocolata", 2.5);
        Producte queso = new Producte("queso", 3.4);
        
        Venda client1 = new Venda();
        //client1.calcularTotal();
        
        client1.getCesta().add(azucar);
        client1.calcularTotal();
        System.out.println(String.format("%.2f", client1.getPreuTotal()));
    }
    
}
