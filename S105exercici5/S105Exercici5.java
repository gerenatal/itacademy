package s105exercici5;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class S105Exercici5 {

    public static void main(String[] args) {
        //Exercicio antiguo
        ArrayList<Ordinador> llistaDeOrdinadors = new ArrayList<>();
        llistaDeOrdinadors.add(new Ordinador("HP", "2020"));
        llistaDeOrdinadors.add(new Ordinador("Acer", "2023", "Intel i5", 8, 512));
        llistaDeOrdinadors.get(0).setMemoriaRAM(32);
        llistaDeOrdinadors.get(1).executant("Eclipse");
        
        // Serialisando
        serializeArrayList(llistaDeOrdinadors, "ordinadores.ser");
        
        // Deserialisando
        ArrayList<Ordinador> deserializeArrayList = deserializeArrayList("ordinadores.ser");
        
        for (Ordinador ordinador : deserializeArrayList) {
            System.out.println(ordinador.toString());
        }
    }
    
    // Metodo para serialisar
    public static void serializeArrayList(ArrayList<Ordinador> lista, String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(lista);
            System.out.println("ArrayList serialisado en: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // Metodo para desserialisar
    public static ArrayList<Ordinador> deserializeArrayList(String fileName) {
        ArrayList<Ordinador> lista = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            lista = (ArrayList<Ordinador>) inputStream.readObject();
            System.out.println("ArrayList desserialisado de :" + fileName);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return lista;
    }
}