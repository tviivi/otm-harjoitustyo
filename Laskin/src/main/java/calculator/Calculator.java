package calculator;

import database.Database;
import database.HistoryDao;

/**
 * A calculator class containing the needed calculator operations for the calculator application
 */
public class Calculator {

    private int mainvalue;
    private Database database;
    private HistoryDao history;
    

    public Calculator() {
        mainvalue = 0;
        this.database = new Database("jdbc:sqlite:History.db");
        this.history = new HistoryDao(this.database);
    }

    /**
     * Sums param to the mainvalue
     * @param anothervalue 
     */
    public void sum(Integer anothervalue) {
        mainvalue += anothervalue;
    }

    /**
     * Subtracts param from the mainvalue
     * @param anothervalue 
     */
    public void difference(Integer anothervalue) {
        mainvalue -= anothervalue;
    }

    /**
     * Multiplys param to the mainvalue
     * @param anothervalue 
     */
    public void product(Integer anothervalue) {
        mainvalue = mainvalue * anothervalue;
    }

    /**
     * Divides the mainvalue with the param
     * @param anothervalue 
     */
    public void divide(Integer anothervalue) {
        if (anothervalue != 0) {
            mainvalue = mainvalue / anothervalue;
        }
    }

    /**
     * Powers the mainvalue with the param
     * @param anothervalue 
     */
    public void power(Integer anothervalue) {
        int help = mainvalue;
        mainvalue = (int) Math.pow(mainvalue, anothervalue);
    }

    /**
     * Sets the mainvalue
     * @param mainvalue 
     */
    public void setMainvalue(int mainvalue) {
        this.mainvalue = mainvalue;
    }

    /**
     * Gets the mainvalue
     * @return mainvalue
     */
    public int getMainvalue() {
        return mainvalue;
    }
    
    /**
     * Gets the history
     * @return history database
     */
    public HistoryDao getHistory() {
        return history;
    }
}
