package s101exercici1;

public abstract class Instrument {
    
    protected String nom;
    protected double preu;
    
    static{
        System.out.println("Llamando a la classe Instrument");
    }
    
    public Instrument (String nom, double preu){
        this.nom = nom;
        this.preu = preu;
    }
    
    public abstract void tocar ();
    
    //Getters
    public String getNom(){
        return nom;
    }
    public double getPreu(){
        return preu;
    }
    
    //Setters
    public void setNom(String nom){
        this.nom = nom;
    }
    public void setPreu (double preu){
        this.preu = preu;
    }
    
    @Override
    public String toString(){
        return "El instrument es de " + nom + " i te el preu " + String.format("%.2f", preu);
    }
}
