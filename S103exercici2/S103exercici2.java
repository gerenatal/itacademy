package s103exercici2;
import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;

//@author Geremias Bristot

public class S103exercici2 {

    public static void main(String[] args) {
        List<Integer> lista1 = new ArrayList<>();
        List<Integer> lista2 = new ArrayList<>();
        
        for(int i = 0; i < 20 ; i++){
            lista1.add(i+1);
        }
                
        /*for(int i = 19; i >= 0; i--){
            lista2.add(lista.get(i));
        }*/
        
        ListIterator<Integer> ite = lista1.listIterator(lista1.size());
        while(ite.hasPrevious()){
            lista2.add(ite.previous());
        }
        
        System.out.println(lista1);
        System.out.println(lista2);
    }
    
}
