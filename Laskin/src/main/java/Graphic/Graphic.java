package Graphic;

import Calculator.Calculator;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.stage.Stage;

public class Graphic extends Application {

    int thenumber;
    Calculator calculator = new Calculator();

    @Override
    public void start(Stage window) throws Exception {

        Canvas canvas = new Canvas(1000, 1000);
        TextField current = new TextField();
        TextField summary = new TextField();
        TextField calculation = new TextField();

        Button number1 = new Button("1");
        //Tässä tarkoitus vähentää copy-pastea käyttämällä ButtonListener -luokkaa seuraavaan tapaan
        //number1.setOnAction((event) -> new ButtonListener(current, 1, thenumber));
        number1.setOnAction((event) -> {
            thenumber = thenumber * 10 + 1;
            current.setText("" + thenumber);
        });
        Button number2 = new Button("2");
        number2.setOnAction((event) -> {
            thenumber = thenumber * 10 + 2;
            current.setText("" + thenumber);
        });
        Button number3 = new Button("3");
        number3.setOnAction((event) -> {
            thenumber = thenumber * 10 + 3;
            current.setText("" + thenumber);
        });
        Button number4 = new Button("4");
        number4.setOnAction((event) -> {
            thenumber = thenumber * 10 + 4;
            current.setText("" + thenumber);
        });
        Button number5 = new Button("5");
        number5.setOnAction((event) -> {
            thenumber = thenumber * 10 + 5;
            current.setText("" + thenumber);
        });
        Button number6 = new Button("6");
        number6.setOnAction((event) -> {
            thenumber = thenumber * 10 + 6;
            current.setText("" + thenumber);
        });
        Button number7 = new Button("7");
        number7.setOnAction((event) -> {
            thenumber = thenumber * 10 + 7;
            current.setText("" + thenumber);
        });
        Button number8 = new Button("8");
        number8.setOnAction((event) -> {
            thenumber = thenumber * 10 + 8;
            current.setText("" + thenumber);
        });
        Button number9 = new Button("9");
        number9.setOnAction((event) -> {
            thenumber = thenumber * 10 + 9;
            current.setText("" + thenumber);
        });
        Button number0 = new Button("0");
        number0.setOnAction((event) -> {
            thenumber = thenumber * 10;
            current.setText("" + thenumber);
        });
        Button sum = new Button("+");
        sum.setOnAction((event) -> {
            int help = calculator.getMainvalue();
            calculator.sum(thenumber);
            thenumber = 0;
            calculation.setText(help + "+" + current.getText());
            summary.setText("= " + calculator.getMainvalue());
        });
        Button difference = new Button("-");
        difference.setOnAction((event) -> {
            int help = calculator.getMainvalue();
            calculator.difference(thenumber);
            thenumber = 0;
            calculation.setText(help + "-" + current.getText());
            summary.setText("= " + calculator.getMainvalue());
        });
        Button product = new Button("*");
        product.setOnAction((event) -> {
            int help = calculator.getMainvalue();
            calculator.product(thenumber);
            thenumber = 0;
            calculation.setText(help + "*" + current.getText());
            summary.setText("= " + calculator.getMainvalue());
        });
        Button divide = new Button("/");
        divide.setOnAction((event) -> {
            int help = calculator.getMainvalue();
            calculator.divide(thenumber);
            thenumber = 0;
            calculation.setText(help + "/" + current.getText());
            summary.setText("= " + calculator.getMainvalue());
        });
        Button power = new Button("^");
        power.setOnAction((event) -> {
            int help = calculator.getMainvalue();
            calculator.power(thenumber);
            thenumber = 0;
            calculation.setText(help + "^" + current.getText());
            summary.setText("= " + calculator.getMainvalue());
        });

        HBox first = new HBox();
        HBox second = new HBox();
        HBox third = new HBox();
        HBox fourth = new HBox();
        HBox fifth = new HBox();

        first.getChildren().addAll(sum, number0, difference, summary);
        second.getChildren().addAll(number1, number2, number3, calculation);
        third.getChildren().addAll(number4, number5, number6);
        fourth.getChildren().addAll(number7, number8, number9, current);
        fifth.getChildren().addAll(product, divide, power);

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