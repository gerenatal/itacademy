package s107exercici2;

//Geremias Bristot

@SuppressWarnings("deprecation")
public class S107exercici2 {

    public static void main(String[] args) {
        int horesTreballades = 40;

        Treballador treballador = new Treballador("Arya", "Stark", 17.5);
        TreballadorPresencial treballadorPresencial = new TreballadorPresencial("Frodo", "Baggins", 15.0);
        TreballadorOnline treballadorOnline = new TreballadorOnline("Rick", "Sanchez", 20.0);

        //Check if Override worked:
        System.out.println((double)treballador.calcularNomina(horesTreballades));
        System.out.println((double)treballadorPresencial.calcularNomina(horesTreballades));
        System.out.println((double)treballadorOnline.calcularNomina(horesTreballades));

        //Check deprecated methods:
        System.out.println((double)treballadorPresencial.calcularPlusFills(horesTreballades));
        System.out.println((double)treballadorOnline.calcularPlusFills(horesTreballades));
    }
    
}
