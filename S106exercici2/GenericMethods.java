package s106exercici2;

public class GenericMethods<T, U, K> {
    private T object1;
    private U object2;
    private K object3;

    public GenericMethods(Object... objects) {
        this.object1 = (T) objects[0];
        this.object2 = (U) objects[1];
        this.object3 = (K) objects[2];
    }

    // Getters
    public T getObject1() {
        return object1;
    }
    public U getObject2() {
        return object2;
    }
    public K getObject3() {
        return object3;
    }

    // Setters
    public void setObject1(T object1) {
        this.object1 = object1;
    }
    public void setObject2(U object2) {
        this.object2 = object2;
    }
    public void setObject3(K object3) {
        this.object3 = object3;
    }
    
    @Override
    public String toString() {
        return object1.toString() + ", " +
               object2.toString() + ", " +
               object3.toString();
    }
}