import com.mycompany.s104exercici2.CalculoDni;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NewEmptyJUnitTest {
    
    CalculoDni secuencia = new CalculoDni();
    HashMap<Integer, Character> listaLetras = secuencia.getLetraDni();
        
    @ParameterizedTest
    @ValueSource(ints = {1,2, 3, 4, 5, 6, 7, 8, 9, 10})
    void assertLetras(int i){
        char expected = (char)('A' + i);
        char actual = listaLetras.get(i-1);
        assertEquals(expected, actual);
        }
    }
    
    /*@Test
    public void testListaDni(){
        CalculoDni calculoDni = new CalculoDni();
        char letraActual = calculoDni.getLetraDni().get(idNumber % 10);
        assertEquals(letra, letraActual);
    }

    public void testDni(){
        char[] letras = secuencia.getLetras();
        //int i = 1;
        for(int i = 1; i <= 10; i++){
            char expected = letras[i-1];
            char actual = listaLetras.get(i);
            assertEquals(expected, actual);
        }
    }*/
