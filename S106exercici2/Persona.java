package s106exercici2;

public class Persona {
    private String nom;
    private String cognom;
    private int edat;

    public Persona(String nom, String cognom, int edat) {
        this.nom = nom;
        this.cognom = cognom;
        this.edat = edat;
    }

    // Getters
    public String getNom() {
        return nom;
    }
    public String getCognom() {
        return cognom;
    }
    public int getEdat() {
        return edat;
    }

    // Setters
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setCognom(String cognom) {
        this.cognom = cognom;
    }
    public void setEdat(int edat) {
        this.edat = edat;
    }
    
    @Override
    public String toString() {
        return "(" + nom + " " + cognom + ", " + edat + ")";
    }
}