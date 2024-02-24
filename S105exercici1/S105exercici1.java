package s105exercici1;

//@author Geremias Bristot

import java.io.File;

public class S105exercici1 {

    public static void main(String[] args) {
        String pathName = "C:\\Users\\gbris\\OneDrive\\Imagens\\2019";
        String ext = "jpg";
        /*File filePath = new File(pathName);
        File[] files;
        if(filePath.exists()){
            if(filePath.isDirectory()){
                files = filePath.listFiles();
                for (File file : files) {
                    if (file.getName().endsWith(ext)) {
                        System.out.println(file.getName());
                    }
                }
            }
        }*/
        
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
    
}
