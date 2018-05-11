package Test;

import database.Database;
import database.HistoryDao;
import database.Operation;
import java.sql.SQLException;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class DatabaseTest {

    Operation operation;
    Integer id;
    Database database;
    HistoryDao historyDao;

    @Before
    public void setUp() throws SQLException {
        id = 5;
        operation = new Operation("test");
        operation.setId(id);
        database = new Database("jdbc:sqlite:TestDatabase.db");
        historyDao = new HistoryDao(database);
        historyDao.saveOrUpdate(operation);
    }

    @Test
    public void operationOperationTest() {
        assertEquals(operation.getOperation(), "test");
    }

    @Test
    public void operationIdTest() {
        assertEquals(operation.getId(), (Integer) 5);
    }

    @Test
    public void historyDaoSaveOrUpdateTest() throws SQLException {
        Operation anotherOperation = this.historyDao.saveOrUpdate(operation);
        assertEquals(operation.getOperation(), anotherOperation.getOperation());
    }
    
    @Test
    public void testDropTable() throws SQLException {
        Operation anotherOperation = this.historyDao.dropTable();
        assertEquals(anotherOperation.getOperation(), "testi");   
    }
}