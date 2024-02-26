package s107exercici1;

public class Treballador {
    private String nom;
    private String cognom;
    private double preuHora;

    public Treballador(String nom, String cognom, double preuHora) {
        this.nom = nom;
        this.cognom = cognom;
        this.preuHora = preuHora;
    }

    public double calcularNomina(int horesTreballades) {
        return horesTreballades * preuHora;
    }
    
    //Getters
    public String getNom() {
        return nom;
    }
    public String getCognom() {
        return cognom;
    }
    public double getPreuHora() {
        return preuHora;
    }
    
    //Setters
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setCognom(String cognom) {
        this.cognom = cognom;
    }
    public void setPreuHora(double preuHora) {
        this.preuHora = preuHora;
    }
    
}
