package Test;

import database.Database;
import database.HistoryDao;
import database.Operation;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class DatabaseTest {

    Operation operation;
    String operation2;
    Integer id;
    Database database;
    HistoryDao historyDao;

    @Before
    public void setUp() {
        operation = new Operation(operation2);
        operation.setOperation(operation2);
        operation.setId(id);
        database = new Database("jdbc:sqlite:TestDatabase.db");
    }

    @Test
    public void operationOperationTest() {
        assertEquals(operation.getOperation(), operation2);
    }

    @Test
    public void operationIdTest() {
        assertEquals(operation.getId(), id);
    }

//    void beforeEach() throws IOException, SQLException {
//        Path path = Paths.get("jdbc:sqlite:TestDatabase.db");
//        Files.delete(path);
//
//        Connection connection = database.getConnection();
//        database.init();
//        historyDao.saveOrUpdate(operation);
//    }
//
//    @Test
//    public void testDatabaseWorks() throws SQLException {
//        assertEquals(historyDao.findAll(), operation);
//    }
}
