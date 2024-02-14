package javaapplication65;

 //@author Geremias Bristot

public class JavaApplication65 {

    public static void main(String[] args) {
        cuentaAtras(30, 5);
        
    }
    
    public static void cuentaAtras(int primerNum, int segundos){
        int zero = 0;
        for(int i = primerNum; i >= 0; i -= segundos){
            System.out.println(i);
            zero = i;
            }
        if(zero != 0){
                zero = 0;
                System.out.println(zero);
        }
        
    }
    
}
