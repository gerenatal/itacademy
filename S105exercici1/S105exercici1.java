package s105exercici1;

//@author Geremias Bristot

import java.io.File;
import java.util.Scanner;

public class S105exercici1 {

    public static void main(String[] args) {
        String pathName = scanString("Insert the directory: ");
        String ext = "jpg";
        
        try {
            File filePath = new File(pathName);
            File[] files;

            if (!filePath.exists()) {
                throw new IllegalArgumentException("Directory doesn't exist");
            }

            if(filePath.isDirectory()){
                files = filePath.listFiles();
                for (File file : files) {
                    if (file.getName().endsWith(ext)) {
                        System.out.println(file.getName());
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
        
    }
    
    static String scanString(String message){
        Scanner in = new Scanner(System.in);
        String inputLine;
        System.out.println(message);
        inputLine = in.nextLine();
        return inputLine;
    }
    
}
