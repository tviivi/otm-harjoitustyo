package graphic;

import calculator.Calculator;
import database.Operation;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Graphic extends Application {

    private int thenumber;
    private Calculator calculator = new Calculator();
    List historylist = new ArrayList();

    @Override
    public void start(Stage window) throws Exception {

        TextField current = new TextField();
        current.setPrefWidth(30);
        TextField summary = new TextField();
        summary.setPrefWidth(50);
        TextField calculation = new TextField();
        calculation.setPrefWidth(50);
        Label text = new Label("Tervetuloa taskulaskin-sovellukseen! \n Aloita laskeminen painamalla jotain \n numeronäppäintä ja haluamaasi \n laskutoimitusnäppäintä. \n Jatka näitä vuoronperään.");
        Label history = new Label();

        Button number1 = new Button("1");
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
            calculation.setText(help + "+" + current.getText());
            textFieldHelper(calculation, summary, history);
            databaseHelper(calculation, summary);
        });
        Button difference = new Button("-");
        difference.setOnAction((event) -> {
            int help = calculator.getMainvalue();
            calculator.difference(thenumber);
            calculation.setText(help + "-" + current.getText());
            textFieldHelper(calculation, summary, history);
            databaseHelper(calculation, summary);
        });
        Button product = new Button("*");
        product.setOnAction((event) -> {
            int help = calculator.getMainvalue();
            calculator.product(thenumber);
            calculation.setText(help + "*" + current.getText());
            textFieldHelper(calculation, summary, history);
            databaseHelper(calculation, summary);
        });
        Button divide = new Button("/");
        divide.setOnAction((event) -> {
            int help = calculator.getMainvalue();
            calculator.divide(thenumber);
            calculation.setText(help + "/" + current.getText());
            textFieldHelper(calculation, summary, history);
            databaseHelper(calculation, summary);
        });
        Button power = new Button("^");
        power.setOnAction((event) -> {
            int help = calculator.getMainvalue();
            calculator.power(thenumber);
            calculation.setText(help + "^" + current.getText());
            textFieldHelper(calculation, summary, history);
            databaseHelper(calculation, summary);
        });
        Button getZero = new Button("Nollaa kaikki");
        getZero.setOnAction((event) -> {
            thenumber = 0;
            calculator.setMainvalue(0);
            calculation.setText("" + calculator.getMainvalue());
            summary.setText("= " + thenumber);
            current.setText("" + calculator.getMainvalue());
            history.setText("Nollasit tapahtumat");
        });

        HBox historyBox = new HBox();
        HBox textBox = new HBox();
        HBox first = new HBox();
        HBox second = new HBox();
        HBox third = new HBox();
        HBox fourth = new HBox();
        HBox fifth = new HBox();
        HBox sixth = new HBox();

        textBox.getChildren().addAll(text);
        first.getChildren().addAll(sum, number0, difference, summary);
        second.getChildren().addAll(number1, number2, number3, calculation);
        third.getChildren().addAll(number4, number5, number6);
        fourth.getChildren().addAll(number7, number8, number9, current);
        fifth.getChildren().addAll(product, divide, power);
        sixth.getChildren().addAll(getZero);
        historyBox.getChildren().addAll(history);

        VBox finale = new VBox();
        finale.getChildren().addAll(textBox, fourth, third, second, first, fifth, sixth, historyBox);

        Scene buttons = new Scene(finale);

        window.setScene(buttons);
        window.show();
    }

    public void databaseHelper(TextField calculation, TextField summary) {
        Operation operation = new Operation("" + calculation.getText() + summary.getText());
        try {
            calculator.getHistory().saveOrUpdate(operation);
        } catch (SQLException ex) {
            Logger.getLogger(Graphic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void textFieldHelper(TextField calculation, TextField summary, Label history) {
        thenumber = 0;
        summary.setText("=" + calculator.getMainvalue());
        historylist.add("" + calculation.getText() + summary.getText());
        history.setText(historylist.toString());
    }

    public static void main(String[] args) {
        launch(Graphic.class);
    }
}
