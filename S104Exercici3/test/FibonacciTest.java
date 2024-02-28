import com.mycompany.s104exercici3.Fibonacci;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FibonacciTest {
    
    public FibonacciTest() {
    }
    
    @Test
    void testSinCantidad(){
        assertThrows(IllegalArgumentException.class,
        () -> new Fibonacci(-1));
    }

    @Test
    void testArrayIndexOutOfBoundsException() {
        Fibonacci fibonacci = new Fibonacci(5);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            int numero = fibonacci.getLista()[5];
        });
    }
}
