package s108exercici1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//Geremias Bristot

public class S108exercici1 {

    public static void main(String[] args) {
        ArrayList<String> disneyCharacters = new ArrayList<>(Arrays.asList(
                    "Mickey",
                    "Moana",
                    "Donald",
                    "Goofy",
                    "Pluto",
                    "Cinderella",
                    "Alladin",
                    "Ariel",
                    "Simba",
                    "Olaf"
                ));
        disneyCharacters.stream().filter(name-> name.toLowerCase().contains("o")).forEach(System.out::println);
        //searchByLetter(disneyCharacters);
        
    }
    
    static void searchByLetter(List<String> list){
        list.stream().filter(name-> name.contains("o")).forEach(System.out::println);
    }
    
}
