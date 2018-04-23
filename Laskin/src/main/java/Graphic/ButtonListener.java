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

    void handle(ActionEvent event) {
        thenumber = thenumber * 10 + buttonNumber;
        current.setText("" + thenumber);
    }
}