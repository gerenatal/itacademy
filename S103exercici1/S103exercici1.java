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
        
        for(int i = 0; i < 11; i++){
            year.add(new Month(months[i]));
        }
        
        for(int i = 0; i < year.size(); i++){
            System.out.print(year.get(i).getName() + ", ");
        }
        System.out.println();
        
        year.add(7, new Month("august"));
        
        for(int i = 0; i < year.size(); i++){
            System.out.print(year.get(i).getName() + ", ");
        }
        System.out.println();
        
        Iterator<Month> iterator = year.iterator();
        while(iterator.hasNext()){
            Month month = iterator.next();
            System.out.print(month.getName() + ", ");
        }
        System.out.println();
        
        year.add(year.get(6));
        
        for(int i = 0; i < year.size(); i++){
            System.out.print(year.get(i).getName() + ", ");
        }
        System.out.println();
        
        HashSet<Month> yearHash = new HashSet<>(year);
        
        Iterator<Month> iterator2 = yearHash.iterator();
        while(iterator2.hasNext()){
            Month month = iterator2.next();
            System.out.print(month.getName() + ", ");
        }
    }
    
}
