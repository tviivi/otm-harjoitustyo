package Graphic;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class ButtonListener {

    TextField current;
    int buttonNumber;
    int thenumber;

    public ButtonListener(TextField current, int buttonNumber, int thenumber) {
        this.current = current;
        this.buttonNumber = buttonNumber;
        this.thenumber = thenumber;
    }

    public int handle(ActionEvent event) {
        System.out.println("testi");
        thenumber = thenumber * 10 + buttonNumber;
        System.out.println("testi2");
        current.setText("" + thenumber);
        System.out.println("testi3");
        return (thenumber);
    }
}