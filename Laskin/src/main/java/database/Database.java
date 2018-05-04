package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private String database;
    
    public Database(String database) {
        this.database = database;
        this.init();
    }
    
    // Gets connection to database
    public Connection getConnection() throws SQLException {
        String dbUrl = System.getenv("JDBC_DATABASE_URL");
        if (dbUrl != null && dbUrl.length() > 0) {
            return DriverManager.getConnection(dbUrl);
        }
        return DriverManager.getConnection(database);
    }
    
    // Makes a new database if there isn't any
    public void init() {
        List<String> commands = this.sqliteCommands();

        // "try with resources" close the resources in the end
        try (Connection conn = getConnection()) {
            Statement st = conn.createStatement();

            for (String com : commands) {
                System.out.println("Running command >> " + com);
                st.executeUpdate(com);
            }

        } catch (Throwable t) {
            // if db is initialized -> failed to run commands and stop
            System.out.println("Error >> " + t.getMessage());
        }
    }
    
    // Creates a table and adds some data to it
    private List<String> sqliteCommands() {
        ArrayList<String> list = new ArrayList<>();

        list.add("CREATE TABLE History ("
                + "id integer PRIMARY KEY, "
                + "operation varchar(50));"); 
        list.add("INSERT INTO History (operation) VALUES ('2+3=5');");
        list.add("INSERT INTO History (operation) VALUES ('2^2=4');");

        return list;
    }
}