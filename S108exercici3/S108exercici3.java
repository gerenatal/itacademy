package s108exercici3;
import java.util.ArrayList;
import java.util.Arrays;
//Geremias Bristot

public class S108exercici3 {

    public static void main(String[] args) {
        ArrayList<String> months = new ArrayList<>(Arrays.asList(
                "January",
                "February",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "December"
        ));
        
        months.forEach(name->System.out.println(name));
        
    }
        
}
