package s108exercici4;
import java.util.ArrayList;
import java.util.Arrays;
//Geremias Bristot

public class S108exercici4 {

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
        
        months.forEach(System.out::println);
        
    }
        
}
