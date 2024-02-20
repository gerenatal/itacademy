package s103exercici3;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class S103exercici3{
    
    static int contador = 0;
    static int points = 0;
    
    public static void main(String[] args){
        HashMap<String, String> countryMap = new HashMap<>();
        countryMap = readFile("countries.txt");
        
        String fileName = "classificacio.txt";
        menu(countryMap);
        createFile(fileName);
        writeToFile(fileName);
        printFile(fileName);
      
    }
    static HashMap<String, String> readFile(String filePath){
        HashMap<String, String> myMap = new HashMap<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line = reader.readLine()) != null){
                String[] parts = line.split(" ");
                if(parts.length >= 2){
                    String key = parts[0];
                    String value = parts[1];
                    myMap.put(key, value);
                }else{
                    System.err.println("Invalid line: " + line);
                }
            }
            reader.close();
        }catch(IOException e){
            System.err.println("Error reading file: " + e.getMessage());
        }
        
        return myMap;
        }
    
    static void menu(HashMap<String, String> countryMap){
        
        System.out.println("Welcome to Guess The Capital!");
        String capitalInput;
        String key;
        String answer;

        do{
            key = returnRandom(countryMap);
            answer = countryMap.get(key);
            capitalInput = lineInput("What is the capital of " + key + "? (or type exit)");
            switch(capitalInput){
                case "exit":
                    break;
                default:
                    if(capitalInput.equals(answer)){
                        System.out.println("Correct!");
                        points++;
                    }else{
                        System.out.println("Nope!");
                    }
                    contador++;
            }
        }while(!capitalInput.equals("exit") && contador < 10);
    }
    
    static String lineInput(String mensaje){
        Scanner in = new Scanner(System.in);
        System.out.println(mensaje);
        String entradaLine = in.nextLine();
        return entradaLine;
    }
    
    static String returnRandom(HashMap<String, String> countryMap){
        Set<String> keySet = countryMap.keySet();
        String[] keyArray = keySet.toArray(String[]::new);
        Random random = new Random();
        int randomIndex = random.nextInt(keyArray.length);
        return keyArray[randomIndex];
    }
    
    static void createFile(String fileName){
        try{
            File file = new File(fileName);
            if(file.createNewFile()){
                System.out.println("File created: " + file.getName());
            }
        }catch(IOException e){
            System.out.println("An error occurred.");
            }
    }
    
    static void writeToFile (String fileName){
        String name = lineInput("Type your name:");
        try{
            FileWriter file = new FileWriter(fileName, true);
            file.write(name + " " + points + "\n");
            file.close();
        }catch(IOException e){
            System.out.println("An error occurred.");
        }
    }
    
    static void printFile(String fileName){
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}