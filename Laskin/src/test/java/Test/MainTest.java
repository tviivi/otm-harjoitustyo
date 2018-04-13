package Test;
import Calculator.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MainTest {

    Calculator calculator;
    Reader reader;
    
    @Before
    public void setUp() {
        calculator = new Calculator();
        reader = new Reader();
        calculator.setMainvalue(0);
    }

    @Test
    public void mainValueTest() {
        assertEquals(calculator.getMainvalue(), 0);
    }

    @Test
    public void sumTest() {
        calculator.sum(5);
        assertEquals(calculator.getMainvalue(), 5);
    }
    
    @Test
    public void differenceTest() {
        calculator.difference(5);
        assertEquals(calculator.getMainvalue(), -5);
    }
    
    @Test
    public void productTest() {
        calculator.setMainvalue(2);
        calculator.product(3);
        assertEquals(calculator.getMainvalue(), 6);
    }
    
    @Test
    public void divideTest() {
        calculator.setMainvalue(8);
        calculator.divide(4);
        assertEquals(calculator.getMainvalue(), 2);
    }
    
    @Test
    public void powerTest() {
        calculator.setMainvalue(2);
        calculator.power(3);
        assertEquals(calculator.getMainvalue(), 8);
    }
}