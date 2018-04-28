package Calculator;

public class Calculator {
    private int mainvalue;

    public Calculator() {
        mainvalue = 0;
    }

    public void sum(Integer anothervalue) {
        int help = mainvalue;
        mainvalue += anothervalue;
    }

    public void difference(Integer anothervalue) {
        int help = mainvalue;
        mainvalue -= anothervalue;
    }

    public void product(Integer anothervalue) {
        int help = mainvalue;
        mainvalue = mainvalue * anothervalue;
    }

    public void divide(Integer anothervalue) {
        int help = mainvalue;
        mainvalue = mainvalue / anothervalue;
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
}