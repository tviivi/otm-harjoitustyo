package Test;

import database.Database;
import database.Operation;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class DatabaseTest {
    Operation operation;
    String operation2;
    Integer id;
    
    @Before
    public void setUp() {
        operation = new Operation(operation2);
        operation.setOperation(operation2);
        operation.setId(id);
    }
    
    @Test
    public void operationOperationTest() {
        assertEquals(operation.getOperation(), operation2);
    }
    
    @Test
    public void operationIdTest() {
        assertEquals(operation.getId(), id);
    }
}
