package javaapplication65;
import java.util.concurrent.TimeUnit;

 //@author Geremias Bristot

public class JavaApplication65 {

    public static void main(String[] args) {
        cuentaAtras(10, 2);
        
    }
    
    public static void cuentaAtras(int primerNum, int segundos){
        for(int i = primerNum; i >= 0; i--){
            System.out.println(i);
            try{
                TimeUnit.SECONDS.sleep(segundos);
            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
                }
        }
        
    }
    
}
