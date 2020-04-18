/*
* Authored by @BalkanBasileus
*
* Program description here..
*
* */
package CalculatorPackage;

import java.net.URL;
import java.text.Format;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import java.text.NumberFormat;
import java.text.DecimalFormat;

public class CalculatorController {

    //Calculator Variables.
    private double firstNum = 0, secondNum = 0;
    private char operator;              //Type of arithmetic for equal button
    private boolean percentHit = false; //If a % has been calculated.
    private String percent = "";        //Displays % in historyPrompt.

    boolean equalButtonHit = false;     
    private String precisionOne = "#0.0";
    private String precisionTwo = "#0.00";
    private String precisionThree = "#0.000";

    /*
    boolean addButtonHit = false;
    boolean subButtonHit = false;
    boolean multButtonHit = false;
    boolean divButtonHit = false;
    */
    private NumberFormat formatter = new DecimalFormat(precisionTwo); //Format decimal display.

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea calcDisplay;

    @FXML
    private Label historyPrompt;

    //Number Buttons
    ////////////////////////////////////////////////////////////////////////////////
    /*
     * Number buttons check if a computation has already been made. If there has not,
     * it will append the button onto display. If equal button has been pressed AND
     * the screen doesn't contain a decimal, it will set the button pressed onto the
     * display. Otherwise if decimal button has been pressed it will append the number
     * pressed onto the display. This prevents a bug where the screen resets the
     * display when the user has already pressed the decimal button.
     */

    @FXML
    void buttonZero(ActionEvent event) {

        //If user already pressed equal button and want to use decimal button after, it won't
        //reset display when they press number after decimal button.
        if(equalButtonHit && !calcDisplay.getText().contains(".") ){
            calcDisplay.setText("0");
            equalButtonHit = false;     //reset
        }
        else{
            calcDisplay.appendText("0");
        }

    }

    @FXML
    void buttonOne(ActionEvent event) {

        //If user already pressed equal button and want to use decimal button after, it won't
        //reset display when they press number after decimal button.
        if(equalButtonHit && !calcDisplay.getText().contains(".") ){
            calcDisplay.setText("1");
            equalButtonHit = false;     //reset
        }
        else{
            calcDisplay.appendText("1");
        }
    }

    @FXML
    void buttonTwo(ActionEvent event) {

        //If user already pressed equal button and want to use decimal button after, it won't
        //reset display when they press number after decimal button.
        if(equalButtonHit && !calcDisplay.getText().contains(".") ){
            calcDisplay.setText("2");
            equalButtonHit = false;     //reset
        }
        else{
            calcDisplay.appendText("2");
        }
    }

    @FXML
    void buttonThree(ActionEvent event) {

        //If user already pressed equal button and want to use decimal button after, it won't
        //reset display when they press number after decimal button.
        if(equalButtonHit && !calcDisplay.getText().contains(".") ){
            calcDisplay.setText("3");
            equalButtonHit = false;     //reset
        }
        else{
            calcDisplay.appendText("3");
        }
    }

    @FXML
    void buttonFour(ActionEvent event) {

        //If user already pressed equal button and want to use decimal button after, it won't
        //reset display when they press number after decimal button.
        if(equalButtonHit && !calcDisplay.getText().contains(".") ){
            calcDisplay.setText("4");
            equalButtonHit = false;     //reset
        }
        else{
            calcDisplay.appendText("4");
        }
    }

    @FXML
    void buttonFive(ActionEvent event) {

        //If user already pressed equal button and want to use decimal button after, it won't
        //reset display when they press number after decimal button.
        if(equalButtonHit && !calcDisplay.getText().contains(".") ){
            calcDisplay.setText("5");
            equalButtonHit = false;     //reset
        }
        else{
            calcDisplay.appendText("5");
        }
    }

    @FXML
    void buttonSix(ActionEvent event) {

        //If user already pressed equal button and want to use decimal button after, it won't
        //reset display when they press number after decimal button.
        if(equalButtonHit && !calcDisplay.getText().contains(".") ){
            calcDisplay.setText("6");
            equalButtonHit = false;     //reset
        }
        else{
            calcDisplay.appendText("6");
        }
    }

    @FXML
    void buttonSeven(ActionEvent event) {

        //If user already pressed equal button and want to use decimal button after, it won't
        //reset display when they press number after decimal button.
        if(equalButtonHit && !calcDisplay.getText().contains(".") ){
            calcDisplay.setText("7");
            equalButtonHit = false;     //reset
        }
        else{
            calcDisplay.appendText("7");
        }
    }

    @FXML
    void buttonEight(ActionEvent event) {

        //If user already pressed equal button and want to use decimal button after, it won't
        //reset display when they press number after decimal button.
        if(equalButtonHit && !calcDisplay.getText().contains(".") ){
            calcDisplay.setText("8");
            equalButtonHit = false;     //reset
        }
        else{
            calcDisplay.appendText("8");
        }
    }

    @FXML
    void buttonNine(ActionEvent event) {

        //If user already pressed equal button and want to use decimal button after, it won't
        //reset display when they press number after decimal button.
        if(equalButtonHit && !calcDisplay.getText().contains(".") ){
            calcDisplay.setText("9");
            equalButtonHit = false;     //reset
        }
        else{
            calcDisplay.appendText("9");
        }
    }


    //Arithmetic Buttons
    ////////////////////////////////////////////////////////////////////////////////

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
            historyPrompt.setText(value + " x");
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
            historyPrompt.setText(value + " -");
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
            historyPrompt.setText(value + " +");
            operator = '+';
        }
    }

    @FXML //CLEAR
    void buttonClear(ActionEvent event) { //Clear everything.
        calcDisplay.setText("");
        historyPrompt.setText("");
        firstNum = 0;
        secondNum = 0;
    }

    @FXML //DELETE
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
            historyPrompt.setText(value + " /");
            operator = '/';
        }
    }


    @FXML//DECIMAL
    void buttonDecimal(ActionEvent event) {

      //If display already contains a dot (if decimal button already pressed)
      if( calcDisplay.getText().contains(".") ){
        //Do nothing.
      }

      else{
          calcDisplay.appendText(".");
          equalButtonHit = false;     //reset
      }

    }

    @FXML
    void buttonEquals(ActionEvent event) {

        //Calculator Engine

        switch (operator){

            case 'x' :

                //If user hits equal again, do nothing. Skip switch.
                if(equalButtonHit){
                    break;
                }

                String valueMult = calcDisplay.getText();                 //get second num from screen
                this.secondNum = Double.parseDouble(valueMult);
                double answerMult = (this.firstNum * this.secondNum);     //arithmetic
                calcDisplay.setText( String.valueOf(formatter.format(answerMult) ) );     //display answer
                String prevHistMult = historyPrompt.getText();

                if(percentHit){
                    historyPrompt.setText(prevHistMult + " " + percent + " = " + formatter.format(answerMult) );
                    percentHit = false; //Reset
                }
                else{
                    historyPrompt.setText(prevHistMult + " " + valueMult + " = " + formatter.format(answerMult) );
                }
                break;

            case '-' :

                //If user hits equal again, do nothing. Skip switch.
                if(equalButtonHit){
                    break;
                }

                String valueSub = calcDisplay.getText();                 //get second num from screen
                this.secondNum = Double.parseDouble(valueSub);
                double answerSub = (this.firstNum - this.secondNum);     //arithmetic
                calcDisplay.setText( String.valueOf(formatter.format(answerSub)) );     //display answer
                String prevHistSub = historyPrompt.getText();

                if(percentHit){
                    historyPrompt.setText(prevHistSub + " " + percent + " = " + formatter.format(answerSub) );
                    percentHit = false; //Reset
                }
                else{
                    historyPrompt.setText(prevHistSub + " " + valueSub + " = " + formatter.format(answerSub) );
                }
                break;

            case '+' :

                //If user hits equal again, do nothing. Skip switch.
                if(equalButtonHit){
                    break;
                }

                String valueAdd = calcDisplay.getText();                  //get second num from screen
                this.secondNum = Double.parseDouble(valueAdd);
                double answerAdd = (this.firstNum + this.secondNum);      //arithmetic
                calcDisplay.setText( String.valueOf(formatter.format(answerAdd)) );     //display answer
                String prevHistAdd = historyPrompt.getText();

                if(percentHit){
                    historyPrompt.setText(prevHistAdd + " " + percent + " = " + formatter.format(answerAdd) );
                    percentHit = false; //Reset
                }
                else{
                    historyPrompt.setText(prevHistAdd + " " + valueAdd + " = " + formatter.format(answerAdd) );
                }
                break;

            case '/' :

                //If user hits equal again, do nothing. Skip switch.
                if(equalButtonHit){
                    break;
                }

                String valueDiv = calcDisplay.getText();                   //get second num from screen
                this.secondNum = Double.parseDouble(valueDiv);
                double answerDiv = (this.firstNum / this.secondNum);       //arithmetic
                calcDisplay.setText( String.valueOf(formatter.format(answerDiv)) );     //display answer
                String prevHistDiv = historyPrompt.getText();

                if(percentHit){
                    historyPrompt.setText(prevHistDiv + " " + percent + " = " + formatter.format(answerDiv) );
                    percentHit = false; //Reset
                }
                else{
                    historyPrompt.setText(prevHistDiv + " " + valueDiv + " = " + formatter.format(answerDiv) );
                }
                break;
        }


        //After answer if user hits another number, discard previous entry.
        //Or if user hits equal again, do nothing.
        equalButtonHit = true;

    }

    //Menu Buttons
    ////////////////////////////////////////////////////////////////////////////////
    @FXML
    void setPrecisionOne(ActionEvent event) {
    //Set decimal place
        formatter = new DecimalFormat(precisionOne);
    }

    @FXML
    void setPrecisionTwo(ActionEvent event) {
    //Set decimal place
        formatter = new DecimalFormat(precisionTwo);
    }

    @FXML
    void setPrecisionThree(ActionEvent event) {
    //Set decimal place
        formatter = new DecimalFormat(precisionThree);
    }

    @FXML
    void menuClose(ActionEvent event) {
    //Exit
        System.exit(-1);
    }

    @FXML
    void initialize() {
        assert calcDisplay != null : "fx:id=\"calcDisplay\" was not injected: check your FXML file 'Calculator.fxml'.";

    }
}

