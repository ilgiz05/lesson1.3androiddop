package com.example.lesson13androiddop;

import android.widget.Button;
import android.widget.TextView;

public class MainActivityPresenters {

    private static final String Ac = "AC";
    private static final float zero = 0;

    private boolean isFirstNumber = true;

    Calculator calculator;

    TextView tvOutPut;

    Button btnEquals, btnPlus, btnMinus, bntDivide, btnMultiply;

    public MainActivityPresenters(TextView tvOutPut, Button btnEquals,
                                  Button btnPlus, Button btnMinus,
                                  Button bntDivide, Button btnMultiply) {
        this.isFirstNumber = isFirstNumber;
        this.calculator = calculator;
        this.tvOutPut = tvOutPut;
        this.btnEquals = btnEquals;
        this.btnPlus = btnPlus;
        this.btnMinus = btnMinus;
        this.bntDivide = bntDivide;
        this.btnMultiply = btnMultiply;
        calculator = new Calculator();

        btnEquals.setEnabled(false);
    }

    public void updateMethod(String method) {
        disableButtons();
        calculator.enteredNumberIsComplete();

        switch (method) {
            case "+":
                calculator.setMethod(Calculator.method.ADDITION);
                btnPlus.setSelected(true);
                break;
            case "-":
                calculator.setMethod(Calculator.method.SUBTRACTION);
                btnMinus.setSelected(true);
                break;
            case "x":
                calculator.setMethod(Calculator.method.MULTIPLICATION);
                btnMultiply.setSelected(true);
                break;
            case "÷":
                calculator.setMethod(Calculator.method.DIVISION);
                bntDivide.setSelected(true);
                break;
        }

        tvOutPut.setText("");
        isFirstNumber = true;
        disableButtons();
    }

    public void showOutput() {
        calculator.enteredNumberIsComplete();
        calculator.calculate();
        String output = calculator.getOutput();
        tvOutPut.setText(output);
        resetButtons();
    }

    private void resetButtons() {
        bntDivide.setEnabled(true);
        btnMultiply.setEnabled(true);
        btnMinus.setEnabled(true);
        btnPlus.setEnabled(true);

        bntDivide.setSelected(false);
        btnMultiply.setSelected(false);
        btnMinus.setSelected(false);
        btnPlus.setSelected(false);
    }

    private void disableButtons() {
        bntDivide.setEnabled(false);
        btnMultiply.setEnabled(false);
        btnMinus.setEnabled(false);
        btnPlus.setEnabled(false);
    }

    public void setText(String n) {
        if (n.equals(Ac)) {
            tvOutPut.setText("0");
            isFirstNumber = true;
            calculator.resetEquation();
            resetButtons();
            return;
        }
        if (isFirstNumber) {
            tvOutPut.setText(n);
            isFirstNumber = false;
        } else {
            tvOutPut.append(n);
        }

        calculator.updateEquation(n);

        btnEquals.setEnabled(true);
    }

}
