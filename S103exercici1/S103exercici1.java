package s103exercici1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashSet;

//@author Geremias Bristot

public class S103exercici1 {

    public static void main(String[] args) {
        
        String[] months = {"january", "february", "march", "april", "may", "june",
            "july", "september", "october", "november", "december"};
        ArrayList <Month> year = new ArrayList<>();
        
        //adding the months with its corresponding names in the arraylist
        for(int i = 0; i < 11; i++){
            year.add(new Month(months[i]));
        }
        
        //printing to check if it did it right
        for(int i = 0; i < year.size(); i++){
            System.out.print(year.get(i).getName() + ", ");
        }
        //space, it´s important
        System.out.println();
        
        //adding the august month
        year.add(7, new Month("august"));
        
        //checking its order
        for(int i = 0; i < year.size(); i++){
            System.out.print(year.get(i).getName() + ", ");
        }
        
        //space, the final frontier
        System.out.println();
        
        //traversing through the list with iterator
        Iterator<Month> iterator = year.iterator();
        while(iterator.hasNext()){
            Month month = iterator.next();
            System.out.print(month.getName() + ", ");
        }
        System.out.println();
        
        //adding one more duplicate month to check the HashSet later
        year.add(year.get(6));
        
        //printing
        for(int i = 0; i < year.size(); i++){
            System.out.print(year.get(i).getName() + ", ");
        }
        System.out.println();
        
        //converting the ArrayList into a HashSet
        HashSet<Month> yearHash = new HashSet<>(year);
        
        //printing
        Iterator<Month> iterator2 = yearHash.iterator();
        while(iterator2.hasNext()){
            Month month = iterator2.next();
            System.out.print(month.getName() + ", ");
        }
    }
    
}
