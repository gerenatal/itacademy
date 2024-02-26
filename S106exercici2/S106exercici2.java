package s106exercici2;

//Geremias Bristot

public class S106exercici2 {

    public static void main(String[] args) {
        GenericMethods<Persona, String, Integer> firstExample = new GenericMethods<>(new Persona("Jose","Hernandez", 30), "Madmax Furry Road", 25);
        GenericMethods<String, Persona, Integer> secondExample = new GenericMethods<>("Dune", new Persona("Maria", "Silva", 40), 77);
        GenericMethods<String, Integer, Persona> thirdExample = new GenericMethods<>("The Hobbit", 45, new Persona("Chavez", "Wandenberg", 57));
        
        System.out.println(firstExample);
        System.out.println(secondExample);
        System.out.println(thirdExample);
    }
    
}
