package s101exercici2;

public class Cotxe {
    private static final String marca = "Volkswagen"; // static belongs to the class not inherited
    private static String model;
    private final double potencia; // can be inherited so can be started at the constructor
    
    public Cotxe(String model){
        this.model = model;
        potencia = 1.6;
    }
    
    static void frenar(){
        System.out.println("El vehicle esta frenant");
    }
    
    public void accelerar(){
        System.out.println("El vehicle esta accelerant");
    }
    
    @Override
    public String toString(){
        return  "Marca: " + marca + "\n" +
                "Model: " + model + "\n" +
                "Potencia: " + String.format("%.2f", potencia);
    }
}
