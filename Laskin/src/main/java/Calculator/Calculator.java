package Calculator;

import java.util.ArrayList;

public class Calculator {
    private Reader reader;
    private ArrayList list;
    
    public Calculator() {
        reader = new Reader();
        list = new ArrayList();
    }

    public void start() {
        while (true) {
            System.out.println("summa/erotus/tulo/lopeta:");
            String command = reader.readString();
            if (command.equals("lopeta")) {
                break;
            }
            if (command.equals("summa")) {
                sum();
            } else if (command.equals("erotus")) {
                difference();
            } else if (command.equals("tulo")) {
                product();
            }
        }
        statistics();
    }
    
    private void sum() {
        System.out.print("Luku1: ");
        int value1 = reader.readInteger();
        System.out.print("Luku2: ");
        int value2 = reader.readInteger();
        int sum = value1 + value2;
        System.out.println("Lukujen summa on " + sum);
        list.add(value1 + "+" + value2 + "=" + sum);
    }
    
    private void difference() {
        System.out.print("Luku1: ");
        int value1 = reader.readInteger();
        System.out.print("Luku2: ");
        int value2 = reader.readInteger();
        int difference = value1 - value2;
        System.out.println("Lukujen erotus on " + difference);
        list.add(value1 + "-" + value2 + "=" + difference);
    }
    
    private void product() {
        System.out.print("Luku1: ");
        int value1 = reader.readInteger();
        System.out.print("Luku2: ");
        int value2 = reader.readInteger();
        int product = value1 * value2;
        System.out.println("Lukujen tulo on " + product);
        list.add(value1 + "*" + value2 + "=" + product);
    }
    
    private void statistics() {
        System.out.println("Historia:");
        System.out.println(list);
    }
}