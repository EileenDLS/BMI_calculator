package com.cs622.bmi_midterm;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
public class BMIController {
    // member variables bind with FXML
    @FXML
    private Text resultText;
    @FXML
    private TextField weightInput, heightInput;
    @FXML
    private ChoiceBox weightUnit, heightUnit;
    // bind with calculate button
    @FXML
    protected void onCalculateButtonClick(){
        // try-catch check validation of input
        try{
            String answer;
            double res = dealUnit();
            // check BMI result, set correct value to answer
            if (res < 18.5){
                answer = "underweight";
            } else if (res < 25.0 ){
                answer =  "normal weight";
            } else if (res <= 30){
                answer = "Overweight";
            } else {
                answer = "Obesity";
            }
            String content = String.format("Your BMI is:  %.2f\nYour state is:  %s", res, answer);
            resultText.setText(content);
        } catch (RuntimeException e){ // use alter to prompt invalid input
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText("Invalid input! Plz check your input!");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }
    // calculate the BMI result
    // Whatever units are, convert them to kilograms and meters to calculate
    private double dealUnit(){
        double weight = Double.parseDouble(weightInput.getText());
        double height = Double.parseDouble(heightInput.getText());
        if (weightUnit.getValue().equals("pounds")){
            weight *= 0.453592;
        }
        if (heightUnit.getValue().equals("inches")){
            height *= 2.54;
        }
        height /= 100;
        return weight / Math.pow(height, 2);
    }
    // bind with clear button
    @FXML
    protected void onClearButtonClick(){
        weightInput.setText("");
        weightUnit.setValue("pounds");
        heightInput.setText("");
        heightUnit.setValue("inches");
        resultText.setText("");
    }
}