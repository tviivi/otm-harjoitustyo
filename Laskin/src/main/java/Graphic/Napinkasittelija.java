/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphic;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

/**
 *
 * @author Viivi
 */
public class Napinkasittelija {
    TextField current;
    int buttonNumber;
    int thenumber;

    public Napinkasittelija(TextField current, int buttonNumber, int thenumber) {
        this.current = current;
        this.buttonNumber = buttonNumber;
        this.thenumber = thenumber;
    }
    
    
    void handle(ActionEvent event)  {
            thenumber = thenumber*10+buttonNumber;
            System.out.println(thenumber);
            current.setText(""+thenumber);
  }            

}
