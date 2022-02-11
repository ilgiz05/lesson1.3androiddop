package com.example.lesson13androiddop;

import static com.example.lesson13androiddop.Calculator.method.ADDITION;
import static com.example.lesson13androiddop.Calculator.method.DIVISION;
import static com.example.lesson13androiddop.Calculator.method.MULTIPLICATION;
import static com.example.lesson13androiddop.Calculator.method.SUBTRACTION;
import static com.example.lesson13androiddop.Calculator.method.NULL;

import java.lang.reflect.Method;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private float output = 0;

    private boolean hasAnswer = false;

    List<Object> equation;

    String number = "0";

    public enum method {
        ADDITION, SUBTRACTION, DIVISION, MULTIPLICATION, NULL
    }

    public Calculator() {
        equation = new ArrayList<>();
    }

    public void setMethod(method method) {
        if (equation.size() >= 3) {
            calculate();
        }
        equation.add(method);
    }

    public void calculate() {
        if (equation.size() >= 3) {
            float n1 = 0, n2 = 0, answer = 0;

            if (equation.get(0) instanceof String) {
                n1 = Float.parseFloat((String) equation.get(0));
            }

            if (equation.get(2) instanceof String) {
                n2 = Float.parseFloat((String) equation.get(2));
            }

            if (equation.get(1) instanceof Method) {
                Method currentmethod = (Method) equation.get(1);
                if (ADDITION.equals(currentmethod)) {
                    answer = n1 + n2;
                } else if (DIVISION.equals(currentmethod)) {
                    answer = n1 / n2;
                } else if (SUBTRACTION.equals(currentmethod)) {
                    answer = n1 - n2;
                } else if (MULTIPLICATION.equals(currentmethod)) {
                    answer = n1 * n2;
                } else if (NULL.equals(currentmethod)) {
                    answer = 0;
                }
            }

            output = answer;
            equation.clear();
            equation.add(String.valueOf(answer));

        }
    }

    public void enteredNumberIsComplete() {
        if (equation.size() == 1) return;

        equation.add(number);
        number = "0";
    }

    public void updateEquation(String n) {
        number += n;
    }

    public String getOutput() {
        return NumberFormat.getInstance().format(output);
    }

    /* resets the equation */
    public void resetEquation() {
        equation.clear();
    }
}
