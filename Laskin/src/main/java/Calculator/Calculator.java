package Calculator;

import Database.*;

public class Calculator {

    private int mainvalue;
    private Database database;
    private HistoryDao history;
    

    public Calculator() {
        mainvalue = 0;
        this.database = new Database("jdbc:sqlite:History.db");
        this.history = new HistoryDao(this.database);
    }

    public void sum(Integer anothervalue) {
        mainvalue += anothervalue;
    }

    public void difference(Integer anothervalue) {
        mainvalue -= anothervalue;
    }

    public void product(Integer anothervalue) {
        mainvalue = mainvalue * anothervalue;
    }

    public void divide(Integer anothervalue) {
        if (anothervalue != 0) {
            mainvalue = mainvalue / anothervalue;
        }
    }

    public void power(Integer anothervalue) {
        int help = mainvalue;
        mainvalue = (int) Math.pow(mainvalue, anothervalue);
    }

    public void setMainvalue(int mainvalue) {
        this.mainvalue = mainvalue;
    }

    public int getMainvalue() {
        return mainvalue;
    }
    
    public HistoryDao getHistory() {
        return history;
    }
}
