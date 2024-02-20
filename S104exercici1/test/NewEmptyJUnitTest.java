import com.mycompany.s104junit1.MonthList;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NewEmptyJUnitTest {
    
    MonthList monthList = new MonthList();
    ArrayList<String> months = monthList.getMonths();
    
    @Test
    public void testSize(){
    int expected = 12;
    int actual = months.size();
    assertEquals(expected, actual);
    }
    
    @Test
    public void testNull(){
        assertNotNull(months);
    }
    
    @Test
    public void posicioCheck(){
        String expected = "August";
        String actual = months.get(7);
        assertEquals(expected, actual);
    }
        
}