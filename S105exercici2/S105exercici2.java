package s105exercici2;

//@author Geremias Bristot

import java.io.File;
import java.text.SimpleDateFormat;

public class S105exercici2 {

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

        if (directory.isDirectory()) {
            System.out.println("D: " + directory.getName());
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        printDirectoryTree(file, ext);
                    } else if (file.getName().endsWith(ext)) {
                        System.out.println("F: " + file.getName() + " (Last Modified: " + readableDateFormat.format(file.lastModified()) + ")");
                    }
                }
            }
        }
    }
}