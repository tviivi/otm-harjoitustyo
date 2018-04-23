package Calculator;

import java.util.ArrayList;

public class Calculator {

    private ArrayList list;
    private int mainvalue;

    public Calculator() {
        list = new ArrayList();
        mainvalue = 0;
    }

//    public void start() {
//        System.out.println("Syötä vuoronperään lukuja ja laskukomentoja, lopeta komennolla 'stop'");
//        System.out.println("Syötä ensimmäinen luku");
//        int readersvalue = reader.readInteger();
//        System.out.println("Syötä ensimmäinen komento");
//        System.out.println("Käytettävissä olevat komennot: +, -, *, /, ^");
//        mainvalue += readersvalue;
//        while (true) {
//            String command = reader.readString();
//
//            if (command.equals("+")) {
//                sum(reader.readInteger());
//            } else if (command.equals("-")) {
//                difference(reader.readInteger());
//            } else if (command.equals("*")) {
//                product(reader.readInteger());
//            } else if (command.equals("/")) {
//                divide(reader.readInteger());
//            } else if (command.equals("^")) {
//                power(reader.readInteger());
//            } else if (command.equals("stop")) {
//                System.out.println("Ohjelman suoritus lopetettu");
//                break;
//            } else {
//                System.out.println("Virheellinen komento, yritä uudelleen");
//            }
//        }
//        statistics();
//    }

    public void sum(Integer anothervalue) {
        int help = mainvalue;
        mainvalue += anothervalue;
        list.add(help + "+" + anothervalue + "=" + mainvalue);
    }

    public void difference(Integer anothervalue) {
        int help = mainvalue;
        mainvalue -= anothervalue;
        list.add(help + "-" + anothervalue + "=" + mainvalue);
    }

    public void product(Integer anothervalue) {
        int help = mainvalue;
        mainvalue = mainvalue * anothervalue;
        list.add(help + "*" + anothervalue + "=" + mainvalue);
    }

    public void divide(Integer anothervalue) {
        int help = mainvalue;
        mainvalue = mainvalue / anothervalue;
        list.add(help + "/" + anothervalue + "=" + mainvalue);
    }

    public void power(Integer anothervalue) {
        int help = mainvalue;
        mainvalue = (int) Math.pow(mainvalue, anothervalue);
        list.add(help + "^" + anothervalue + "=" + mainvalue);
    }

//    public void statistics() {
//        System.out.print("Lopullinen tulos: " + mainvalue + "\n");
//        if (list.size() > 0) {
//            System.out.print("Laskuhistoria: ");
//            for (int i = 0; i < list.size(); i++) {
//                System.out.print(list.get(i) + " ");
//            }
//        } else {
//            System.out.println("Ei laskuhistoriaa");
//        }  
//    }

    public void setMainvalue(int mainvalue) {
        this.mainvalue = mainvalue;
    }

    public int getMainvalue() {
        return mainvalue;
    }
}