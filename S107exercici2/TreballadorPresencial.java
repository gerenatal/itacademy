package s107exercici2;

public class TreballadorPresencial extends Treballador {
    private static double benzina = 50;

    public TreballadorPresencial(String nom, String cognom, double preuHora) {
        super(nom, cognom, preuHora);
    }

    @Override
    public double calcularNomina(int horesTreballades) {
        return super.calcularNomina(horesTreballades) + benzina;
    }
    
    @Deprecated
    public double calcularPlusFills(int horesTreballades) {
        return calcularNomina(horesTreballades)*0.15;
    }
}
