package s107exercici1;

//Geremias Bristot

public class S107exercici1 {

    public static void main(String[] args) {
        
        int horesTreballades = 40;
        
        Treballador treballador = new Treballador("Arya", "Stark", 17.5);
        TreballadorPresencial treballadorPresencial = new TreballadorPresencial("Frodo", "Baggins", 15.0);
        TreballadorOnline treballadorOnline = new TreballadorOnline("Rick", "Sanchez", 20.0);

        double nominaTreballador = treballador.calcularNomina(horesTreballades);
        double nominaTreballadorPresencial = treballadorPresencial.calcularNomina(horesTreballades);
        double nominaTreballadorOnline = treballadorOnline.calcularNomina(horesTreballades);

        //Check if Override worked:
        System.out.println(nominaTreballador);
        System.out.println(nominaTreballadorPresencial);
        System.out.println(nominaTreballadorOnline);
    }
    
}
