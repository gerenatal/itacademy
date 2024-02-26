package s107exercici1;

public class TreballadorOnline extends Treballador {
    private static double costeInternet = 30;

    public TreballadorOnline(String nom, String cognom, double preuHora) {
        super(nom, cognom, preuHora);
    }

    @Override
    public double calcularNomina(int horesTreballades) {
        return super.calcularNomina(horesTreballades) + costeInternet;
    }
}
