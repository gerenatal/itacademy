package s105exercici4;

//@author Geremias Bristot

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class S105exercici4 {

    public static void main(String[] args) {
        String pathName = scanString("Insert the directory: ");
        String ext = "jpg";

        try {
            File filePath = new File(pathName);

            if (!filePath.exists()) {
                throw new IllegalArgumentException("Directory doesn't exist");
            }

            printDirectoryTree(filePath, ext);
            findFileTXT(filePath);
            
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void findFileTXT(File directory) {
    if (directory.isDirectory()) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    findFileTXT(file);
                } else if (file.getName().endsWith(".txt")) {
                    System.out.println(file.getAbsolutePath());
                    printFile(file.getAbsolutePath()); // Use absolute path otherwise won't find file
                }
            }
        }
    }
}
    
    public static void printDirectoryTree(File directory, String ext) {
        SimpleDateFormat readableDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String newFileName = "List_of_files.txt";
        createFile(newFileName);

        if (directory.isDirectory()) {
            writeToFile (newFileName, "D: " + directory.getName());
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        printDirectoryTree(file, ext);
                    } else if (file.getName().endsWith(ext)) {
                        writeToFile (newFileName, "F: " + file.getName() + " (Last Modified: " + readableDateFormat.format(file.lastModified()) + ")");
                    }
                }
            }
        }
    }
    
    static void createFile(String fileName){
        try{
            File file = new File(fileName);
            if (!file.exists()) {
                if (file.createNewFile()) {
                    System.out.println("File created: " + file.getName());
                }
            }
        }catch(IOException e){
            System.out.println("An error occurred.");
            }
    }
    
    static void writeToFile (String fileName, String whatToWrite){
        try{
            FileWriter file = new FileWriter(fileName, true);
            file.write(whatToWrite + "\n");
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
    
    static String scanString(String message){
        Scanner in = new Scanner(System.in);
        String inputLine;
        System.out.println(message);
        inputLine = in.nextLine();
        return inputLine;
    }
}