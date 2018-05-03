package Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Pelaajan Tietokanta, joka tallettaa rahaa, nimen ja id:n.
 */
public class HistoryDao implements Dao<Operation, Integer> {

    private Database database;

    public HistoryDao(Database database) {
        this.database = database;
    }
    /**
     * Deletes HighScore from database with matching PRIMARY KEY.
     * @param key
     * @throws SQLException 
     */
    public void delete(Integer key) throws SQLException {
        Connection conn = this.database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM HighScores WHERE id = ?");

        stmt.setInt(1, key);
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }
    /**
     * Saves HighScore to the database.
     * @param highscore
     * @return highscore
     * @throws SQLException 
     */
    private Operation save(Operation operation) throws SQLException {

        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO History"
                + " (operation)"
                + " VALUES (?)");
        stmt.setString(1, operation.getOperation());

        stmt.executeUpdate();
        stmt.close();

        stmt = conn.prepareStatement("SELECT * FROM History"
                + " WHERE operation = ?");
        stmt.setString(1, operation.getOperation());

        ResultSet rs = stmt.executeQuery();
        rs.next();

        Operation p = new Operation(rs.getString("operation"));

        stmt.close();
        rs.close();

        conn.close();

        return p;
    }
    /**
     * Updates HighScore in database with matching name and PRIMARY KEY.
     * @param operation
     * @return
     * @throws SQLException 
     */
    private Operation update(Operation operation) throws SQLException {
        
        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("UPDATE History SET"
                + " operation = ? WHERE id = ?");
        stmt.setString(1, operation.getOperation());
        stmt.setInt(2, operation.getId());

        stmt.executeUpdate();

        stmt.close();
        conn.close();

        return operation;
    }
    /** 
     * Uses private methods save() and update().
     * @param operation
     * @return highscore
     * @throws SQLException 
     */
    public Operation saveOrUpdate(Operation operation) throws SQLException {
        if ((Integer) operation.getId() == null) {
            return save(operation);
        } else {
            return update(operation);
        }

    }
    /**
     * Returns list of highscores in database.
     * @return List of highscores.
     * @throws SQLException 
     */
    public List<Operation> findAll() throws SQLException {
        List<Operation> operations = new ArrayList<>();
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM History");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Operation operation = new Operation(rs.getString("operation"));

            operations.add(operation);
        }

        stmt.close();
        rs.close();

        connection.close();
        return operations;
    }
    /**
     * Finds and returns highscore with spesific PRIMARY KEY.
     * @param key
     * @return highscore
     * @throws SQLException 
     */
    public Operation findOne(Integer key) throws SQLException {

        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM History WHERE id = ?");
        stmt.setInt(1, key);

        ResultSet rs = stmt.executeQuery();
        boolean hasOne = rs.next();
        if (!hasOne) {
            return null;
        }

        Operation operation = new Operation(rs.getString("operation"));

        stmt.close();
        rs.close();

        conn.close();

        return operation;

    }

}