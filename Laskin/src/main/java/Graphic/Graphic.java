package Graphic;

import Calculator.Calculator;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.stage.Stage;

public class Graphic extends Application {
    int thenumber;
    Calculator calculator = new Calculator();
    
    @Override
    public void start(Stage window) throws Exception {
        
        Canvas canvas = new Canvas(400, 400);
        BorderPane setup = new BorderPane();
        TextField current = new TextField();
        TextField summary = new TextField();
        TextField calculation = new TextField();
        
        Button number1 = new Button("1");
        number1.setOnAction((event) -> {
            thenumber = thenumber*10+1;
            current.setText("" + thenumber);
        });
        Button number2 = new Button("2");
        number2.setOnAction((event) -> {
            thenumber = thenumber*10+2;
            current.setText("" + thenumber);
        });
        Button number3 = new Button("3");
       /// number3.setOnAction(new Napinkasittelija(current, 3, thenumber));
        
        Button number4 = new Button("4");
        Button number5 = new Button("5");
        Button number6 = new Button("6");
        Button number7 = new Button("7");
        Button number8 = new Button("8");
        Button number9 = new Button("9");
        Button number0 = new Button("0");
        Button empty1 = new Button("  ");
        Button empty2 = new Button("  ");
        Button sum = new Button("+");
        sum.setOnAction((event) -> {
            int help = calculator.getMainvalue();
            calculator.sum(thenumber);
            thenumber = 0;
            calculation.setText(help + "+" + current.getText());
            summary.setText("= " + calculator.getMainvalue());
        });
        Button difference = new Button("-");
        Button product = new Button("*");
        Button divide = new Button("/");
        Button power = new Button("^");
        
        HBox first = new HBox();
        HBox second = new HBox();
        HBox third = new HBox();
        HBox fourth = new HBox();
        HBox fifth = new HBox();
        
        first.getChildren().addAll(empty1, number0, empty2, summary);
        second.getChildren().addAll(number1, number2, number3, calculation);
        third.getChildren().addAll(number4, number5, number6);
        fourth.getChildren().addAll(number7, number8, number9, current);
        fifth.getChildren().addAll(sum);
        
        VBox finale = new VBox();
        finale.getChildren().addAll(fourth, third, second, first, fifth);
        
        Scene buttons = new Scene(finale);
        
        window.setScene(buttons);
        window.show();
    }
    
    public static void main(String[] args) {
        launch(Graphic.class);
    }
}
