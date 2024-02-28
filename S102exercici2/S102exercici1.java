package s102exercici1;

//@author Geremias Bristot

public class S102exercici1 {

    public static void main(String[] args){
        
        Venda client1 = new Venda();
        
        /* Crear y anadir produtos
        Producte azucar = new Producte("azucar",2);
        Producte chocolata = new Producte("chocolata", 2.5);
        Producte queso = new Producte("queso", 3.4);
        
        client1.addProducte(azucar);
        client1.addProducte(chocolata);
        client1.addProducte(queso);
        */
        
        try{
            //Si la cesta esta vacia:
            client1.calcularTotal();
            
            //Testear el indexOutOfBoundsException
            System.out.println(client1.getCesta().get(4).toString());
            
            //No se puede testear los dos exceptions juntos, se testa uno y después el otro 
        }catch(VendaBuidaException e){
            System.out.println(e.getMessage());
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Array index out of bounds exception occurred: " + e.getMessage());
        }
        
    }
    
}
