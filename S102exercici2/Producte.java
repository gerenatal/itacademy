package s102exercici1;

public class Producte {
    private String nom;
    private double preu;
    
    public Producte(String nom, double preu){
        this.nom = nom;
        this.preu = preu;
    }
    
    //Setters
    public void setNom(String nom){
        this.nom = nom;
    }
    public void setPreu(double preu){
        this.preu = preu;
    }
    
    //Getters
    public String getNom(){
        return nom;
    }
    public double getPreu(){
        return preu;
    }
    
    @Override
    public String toString() {
        return "(" + nom + ", " + preu + ")";
    }
}
