package s106exercici1;

public class NoGenericMethods {
    private Integer int1;
    private Integer int2;
    private Integer int3;

    public NoGenericMethods(Integer... integers) {
        this.int1 = integers[0];
        this.int2 = integers[1];
        this.int3 = integers[2];
    }

    //Getters
    public Integer getInt1() {
        return int1;
    }
    public Integer getInt2() {
        return int2;
    }
    public Integer getInt3() {
        return int3;
    }
    
    //Setters
    public void setInt1(Integer int1) {
        this.int1 = int1;
    }
    public void setInt2(Integer int2) {
        this.int2 = int2;
    }
    public void setInt3(Integer int3) {
        this.int3 = int3;
    }

}
