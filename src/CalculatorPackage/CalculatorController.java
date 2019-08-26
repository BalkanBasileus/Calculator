package CalculatorPackage;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;

public class CalculatorController {

    private double firstNum=0, secondNum=0;
    private char operator; //Type of arithmetic

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea calcDisplay;

    @FXML
    private Label historyPrompt;

    @FXML
    void buttonOne(ActionEvent event) { calcDisplay.appendText("1"); }

    @FXML
    void buttonTwo(ActionEvent event) { calcDisplay.appendText("2"); }

    @FXML
    void buttonThree(ActionEvent event) { calcDisplay.appendText("3"); }

    @FXML
    void buttonFive(ActionEvent event) { calcDisplay.appendText("5"); }

    @FXML
    void buttonSix(ActionEvent event) { calcDisplay.appendText("6"); }

    @FXML
    void buttonFour(ActionEvent event) { calcDisplay.appendText("4"); }

    @FXML
    void buttonSeven(ActionEvent event) { calcDisplay.appendText("7"); }

    @FXML
    void buttonEight(ActionEvent event) { calcDisplay.appendText("8"); }

    @FXML
    void buttonNine(ActionEvent event) { calcDisplay.appendText("9"); }

    @FXML
    void buttonMultiply(ActionEvent event) {
        String value = calcDisplay.getText();
        double valueNumOne = Double.parseDouble(value);
        this.firstNum = valueNumOne;
        calcDisplay.setText("");
        historyPrompt.setText(value + "x");
        operator = 'x';
    }

    @FXML
    void buttonSubtract(ActionEvent event) {
        String value = calcDisplay.getText();
        double valueNumOne = Double.parseDouble(value);
        this.firstNum = valueNumOne;
        calcDisplay.setText("");
        historyPrompt.setText(value + "-");
        operator = '-';

    }

    @FXML
    void buttonAdd(ActionEvent event) {
        String value = calcDisplay.getText();
        double valueNumOne = Double.parseDouble(value);
        this.firstNum = valueNumOne;
        calcDisplay.setText("");
        historyPrompt.setText(value + "+");
        operator = '+';
    }

    @FXML
    void buttonClear(ActionEvent event) {
        calcDisplay.setText("");
        historyPrompt.setText("");
        firstNum = 0;
        secondNum = 0;
    }

    @FXML
    void buttonDel(ActionEvent event) {
        if(calcDisplay.getText().equals("")) { //If screen already empty.
            //Do nothing.
        }
        else{//Delete last component of string.
            calcDisplay.setText(calcDisplay.getText().substring(0, calcDisplay.getText().length() - 1));
        }
    }

    @FXML
    void buttonPercentage(ActionEvent event) {
        if(calcDisplay.getText().equals("")){
            //Do nothing.
        }
        if(calcDisplay.getText().substring(calcDisplay.getText().length() - 1).equals("%")){ //If number already has '%'
            //Do nothing.
        }
        else {
            calcDisplay.appendText("%");
            /** Must finish computing percentage and assigning it to either numOne or numTwo,
             * depending on which number has been entered. */
        }
    }

    @FXML
    void buttonDivide(ActionEvent event) {
        String value = calcDisplay.getText();
        double valueNumOne = Double.parseDouble(value);
        this.firstNum = valueNumOne;
        calcDisplay.setText("");
        historyPrompt.setText(value + '/');
        operator = '/';
    }

    @FXML
    void buttonZero(ActionEvent event) { calcDisplay.appendText("0"); }

    @FXML
    void buttonDecimal(ActionEvent event) {     /**This needs work. Arithmetic with multiple decimals resets*/
        if (secondNum != 0) {
            calcDisplay.setText("");
            historyPrompt.setText("");
            calcDisplay.setText(".");
        }
        else
        {
            calcDisplay.appendText(".");
        }
    }

    @FXML
    void buttonEquals(ActionEvent event) {

        //Calculator Engine

        switch (operator){
            case 'x' :
                String valueMult = calcDisplay.getText(); //get second num
                this.secondNum = Double.parseDouble(valueMult);
                double answerMult = (this.firstNum * this.secondNum); //arithmetic
                calcDisplay.setText(String.valueOf(answerMult));
                String prevHistMult = historyPrompt.getText();
                historyPrompt.setText(prevHistMult + valueMult);
                break;
            case '-' :
                String valueSub = calcDisplay.getText(); //get second num
                this.secondNum = Double.parseDouble(valueSub);
                double answerSub = (this.firstNum - this.secondNum); //arithmetic
                calcDisplay.setText(String.valueOf(answerSub));
                String prevHistSub = historyPrompt.getText();
                historyPrompt.setText(prevHistSub + valueSub);
                break;
            case '+' :
                String valueAdd = calcDisplay.getText(); //get second num
                this.secondNum = Double.parseDouble(valueAdd);
                double answerAdd = (this.firstNum + this.secondNum); //arithmetic
                calcDisplay.setText(String.valueOf(answerAdd));
                String prevHistAdd = historyPrompt.getText();
                historyPrompt.setText(prevHistAdd + valueAdd);
                break;
            case '/' :
                String valueDiv = calcDisplay.getText(); //get second num
                this.secondNum = Double.parseDouble(valueDiv);
                double answerDiv = (this.firstNum / this.secondNum); //arithmetic
                calcDisplay.setText(String.valueOf(answerDiv));
                String prevHistDiv = historyPrompt.getText();
                historyPrompt.setText(prevHistDiv + valueDiv);
                break;
        }

    }

    @FXML
    void initialize() {
        assert calcDisplay != null : "fx:id=\"calcDisplay\" was not injected: check your FXML file 'Calculator.fxml'.";

    }
}

