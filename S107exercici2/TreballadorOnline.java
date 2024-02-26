package s107exercici2;

public class TreballadorOnline extends Treballador{
    private static double costeInternet = 30;

    public TreballadorOnline(String nom, String cognom, double preuHora) {
        super(nom, cognom, preuHora);
    }

    @Override
    public double calcularNomina(int horesTreballades) {
        return super.calcularNomina(horesTreballades) + costeInternet;
    }
    
    @Deprecated
    public double calcularPlusFills(int horesTreballades) {
        return calcularNomina(horesTreballades)*0.10;
    }
}
