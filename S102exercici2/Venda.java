package s102exercici1;
import java.util.ArrayList;

public class Venda {
    private static ArrayList<Producte> cesta;
    private static double preuTotal;
    
    public Venda(){
        cesta = new ArrayList<>();
        preuTotal = 0;
    }
    
    public void addProducte(Producte producte) {
        cesta.add(producte);
    }
    
    public void calcularTotal() throws VendaBuidaException{
        if(cesta.isEmpty()){
            throw new VendaBuidaException();
        }
        
        preuTotal = 0.0;
        for(Producte cest : cesta){
            preuTotal += cest.getPreu();
        }
        
    }
    
    //Getters
    public ArrayList<Producte> getCesta(){
        return cesta;
    }
    public double getPreuTotal(){
        return preuTotal;
    }
}
