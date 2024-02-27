package s108exercici7;

//Geremias Bristot

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class S108exercici7 {

    public static void main(String[] args) {
        
        ArrayList<Object> list = new ArrayList<>(Arrays.asList(
                273,
                "amalgamo",
                11,
                "oficina",
                5576,
                "clave",
                "bolsillo",
                "casteldefells"
        ));
        
        list.stream()
                .map(Object::toString)
                .sorted(Comparator.comparing(String::length)
                .reversed())
                .forEach(System.out::println);
    }
    
}
