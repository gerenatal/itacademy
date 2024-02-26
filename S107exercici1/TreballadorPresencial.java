package s107exercici1;

public class TreballadorPresencial extends Treballador {
    private static double benzina = 50;

    public TreballadorPresencial(String nom, String cognom, double preuHora) {
        super(nom, cognom, preuHora);
    }

    @Override
    public double calcularNomina(int horesTreballades) {
        return super.calcularNomina(horesTreballades) + benzina;
    }
}
