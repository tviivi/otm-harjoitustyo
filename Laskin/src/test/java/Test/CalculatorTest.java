package Test;
import calculator.Calculator;
import database.Database;
import database.HistoryDao;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    Calculator calculator;
    Database database;
    HistoryDao history;
    
    @Before
    public void setUp() {
        calculator = new Calculator();
        calculator.setMainvalue(0);
        database = new Database("jdbc:sqlite:History.db");
        history = new HistoryDao(database);
    }

    @Test
    public void mainValueTest() {
        assertEquals(calculator.getMainvalue(), 0);
    }
    
    @Test
    public void anotherMainValueTest() {
        calculator.setMainvalue(2);
        assertEquals(calculator.getMainvalue(), 2);
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
    public void secondDifferenceTest() {
        calculator.setMainvalue(2);
        calculator.difference(0);
        assertEquals(calculator.getMainvalue(), 2);
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