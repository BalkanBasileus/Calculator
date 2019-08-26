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
    private boolean percentHit = false; //If a % has been calculated.
    private String percent = ""; //Displays % in historyPrompt.

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

    @FXML//MULTIPLY
    void buttonMultiply(ActionEvent event) {
        if(calcDisplay.getText().equals("")){
            //Do noting.
        }
        else {

            String value = calcDisplay.getText();
            double valueNumOne = Double.parseDouble(value);
            this.firstNum = valueNumOne;
            calcDisplay.setText("");
            historyPrompt.setText(value + "x");
            operator = 'x';
        }
    }

    @FXML//SUBTRACT
    void buttonSubtract(ActionEvent event) {
        if(calcDisplay.getText().equals("")){
            //Do noting.
        }
        else {

            String value = calcDisplay.getText();
            double valueNumOne = Double.parseDouble(value);
            this.firstNum = valueNumOne;
            calcDisplay.setText("");
            historyPrompt.setText(value + "-");
            operator = '-';
        }

    }

    @FXML//ADD
    void buttonAdd(ActionEvent event) {
        if(calcDisplay.getText().equals("")){
            //Do noting.
        }
        else {

            String value = calcDisplay.getText();
            double valueNumOne = Double.parseDouble(value);
            this.firstNum = valueNumOne;
            calcDisplay.setText("");
            historyPrompt.setText(value + "+");
            operator = '+';
        }
    }

    @FXML
    void buttonClear(ActionEvent event) { //Clear everything.
        calcDisplay.setText("");
        historyPrompt.setText("");
        firstNum = 0;
        secondNum = 0;
    }

    @FXML
    void buttonDel(ActionEvent event) {

        //If screen already empty.
        if(calcDisplay.getText().equals("")) {
            //Do nothing.
        }
        //Else, Delete last component of string.
        else{
            calcDisplay.setText(calcDisplay.getText().substring(0, calcDisplay.getText().length() - 1));
        }
    }

    @FXML//PERCENT
    void buttonPercentage(ActionEvent event) {
        if(calcDisplay.getText().equals("")){
            //Do nothing.
        }
        if(calcDisplay.getText().substring(calcDisplay.getText().length() - 1).equals("%")){ //If number already has '%'
            //Do nothing.
        }
        else {
            calcDisplay.appendText("%");
            percent = calcDisplay.getText(); //Used in '=' button to display percent in historyPrompt.
            String tmpNumTwo = (calcDisplay.getText().substring(0,calcDisplay.getText().length() - 1)); //Get num w/o: % sign.
            double tmpSecondNum = Double.parseDouble(tmpNumTwo); //convert to double.
            this.secondNum = ((tmpSecondNum / 100) * this.firstNum); //Calculate percentage.
            tmpSecondNum = this.secondNum;
            calcDisplay.setText(String.valueOf(tmpSecondNum));
            percentHit = true; //Used to decide whether to display percentage in historyPrompt within Calculator Engine.
        }
    }

    @FXML//DIVIDE
    void buttonDivide(ActionEvent event) {
        if(calcDisplay.getText().equals("")){
            //Do noting.
        }
        else {

            String value = calcDisplay.getText();
            double valueNumOne = Double.parseDouble(value);
            this.firstNum = valueNumOne;
            calcDisplay.setText("");
            historyPrompt.setText(value + '/');
            operator = '/';
        }
    }

    @FXML
    void buttonZero(ActionEvent event) { calcDisplay.appendText("0"); }

    @FXML//DECIMAL
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
                calcDisplay.setText(String.valueOf(answerMult)); //display answer
                String prevHistMult = historyPrompt.getText();
                if(percentHit){
                    historyPrompt.setText(prevHistMult + percent + "=");
                    percentHit = false; //Reset
                }
                else{
                    historyPrompt.setText(prevHistMult + valueMult + "=");
                }
                break;
            case '-' :
                String valueSub = calcDisplay.getText(); //get second num
                this.secondNum = Double.parseDouble(valueSub);
                double answerSub = (this.firstNum - this.secondNum); //arithmetic
                calcDisplay.setText(String.valueOf(answerSub)); //display answer
                String prevHistSub = historyPrompt.getText();
                if(percentHit){
                    historyPrompt.setText(prevHistSub + percent + "=");
                    percentHit = false; //Reset
                }
                else{
                    historyPrompt.setText(prevHistSub + valueSub + "=");
                }
                break;
            case '+' :
                String valueAdd = calcDisplay.getText(); //get second num
                this.secondNum = Double.parseDouble(valueAdd);
                double answerAdd = (this.firstNum + this.secondNum); //arithmetic
                calcDisplay.setText(String.valueOf(answerAdd)); //display answer
                String prevHistAdd = historyPrompt.getText();
                if(percentHit){
                    historyPrompt.setText(prevHistAdd + percent + "=");
                    percentHit = false; //Reset
                }
                else{
                    historyPrompt.setText(prevHistAdd + valueAdd + "=");
                }
                break;
            case '/' :
                String valueDiv = calcDisplay.getText(); //get second num
                this.secondNum = Double.parseDouble(valueDiv);
                double answerDiv = (this.firstNum / this.secondNum); //arithmetic
                calcDisplay.setText(String.valueOf(answerDiv)); //display answer
                String prevHistDiv = historyPrompt.getText();
                if(percentHit){
                    historyPrompt.setText(prevHistDiv + percent + "=");
                    percentHit = false; //Reset
                }
                else{
                    historyPrompt.setText(prevHistDiv + valueDiv + "=");
                }
                break;
        }

    }

    @FXML
    void initialize() {
        assert calcDisplay != null : "fx:id=\"calcDisplay\" was not injected: check your FXML file 'Calculator.fxml'.";

    }
}

