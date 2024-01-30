package s102exercici1;
import java.util.ArrayList;

public class Venda {
    private static ArrayList<Producte> cesta = new ArrayList<>();
    private static double preuTotal;
    
    public Venda(){
        preuTotal = 0;
    }
    
    public void calcularTotal() throws VendaBuidaException{
        if(cesta.isEmpty()){
            throw new VendaBuidaException();
        }else{
            for(int i = 0; i < cesta.size(); i++){
                preuTotal += cesta.get(i).getPreu();
            }
        }
        
    }
    
    public ArrayList<Producte> getCesta(){
        return cesta;
    }
    
    public double getPreuTotal(){
        return preuTotal;
    }
}
