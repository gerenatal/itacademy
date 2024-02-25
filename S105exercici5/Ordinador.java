package s105exercici5;
import java.io.Serializable;

public class Ordinador implements Serializable {
    private String marca;
    private String model;
    private String processador;
    private int memoriaRAM;
    private int memoriaHD;
    
    public Ordinador(String marca, String model, String processador, int memoriaRAM, int memoriaHD){
        this.marca = marca;
        this.model = model;
        this.processador = processador;
        this.memoriaRAM = memoriaRAM;
        this.memoriaHD = memoriaHD;
    }
    
    public Ordinador(String marca, String model){
        this.marca = marca;
        this.model = model;
        processador = "Intel i7";
        memoriaRAM = 16;
        memoriaHD = 256;
    }
    
    public String getMarca(){
        return marca;
    }
    
    public String getModel(){
        return model;
    }
    
    public String getProcessador(){
        return processador;
    }
    
    public int getMemoriaRAM(){
        return memoriaRAM;
    }
    
    public int getMemoriaHD(){
        return memoriaHD;
    }
    
    public void setProcessador(String processador){
        this.processador = processador;
    }
    
    public void setMemoriaRAM(int memoriaRAM){
        this.memoriaRAM = memoriaRAM;
    }
    
    public void setMemoriaHD(int memoriaHD){
        this.memoriaHD = memoriaHD;
    }
    
    public String executant(String programa){
        return "En aquests moments s'està executant: " + programa;
    }
    
    @Override
    public String toString(){
        return "Dades del ordinador: \n"
                + "Marca: " + marca + "\n"
                + "Model: " + model + "\n"
                + "Processador: " + processador + "\n"
                + "Memória RAM:" + memoriaRAM + " GB\n"
                + "Disc dur: " + memoriaHD + " GB";
    }
       
}
