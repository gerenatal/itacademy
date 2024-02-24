package s105exercici3;

//@author Geremias Bristot

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class S105exercici3 {

    public static void main(String[] args) {
        String pathName = "C:\\Users\\gbris\\OneDrive\\Imagens\\2019";
        String ext = "jpg";

        try {
            File filePath = new File(pathName);

            if (!filePath.exists()) {
                throw new IllegalArgumentException("Directory doesn't exist");
            }

            printDirectoryTree(filePath, ext);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
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
}