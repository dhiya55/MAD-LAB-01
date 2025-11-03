package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private TextView display;
    private String input = "";
    private double firstOperand = 0;
    private String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.text_View1);
    }

    public void onDigitClick(View view) {
        input += ((Button) view).getText();
        updateDisplay();
    }

    public void onOperatorClick(View view) {
        if (!input.isEmpty()) {
            firstOperand = Double.parseDouble(input);
            operator = ((Button) view).getText().toString();
            input = "";
        }
    }

    public void onEqualsClick(View view) {
        if (input.isEmpty()) return;

        double secondOperand = Double.parseDouble(input);
        double result = 0;

        switch (operator) {
            case "+": result = firstOperand + secondOperand; break;
            case "-": result = firstOperand - secondOperand; break;
            case "*": result = firstOperand * secondOperand; break;
            case "/": result = (secondOperand != 0) ? firstOperand / secondOperand : Double.NaN; break;
        }

        input = String.valueOf(result);
        updateDisplay();
    }

    public void onClearClick(View view) {
        input = "";
        firstOperand = 0;
        operator = "";
        updateDisplay();
    }

    private void updateDisplay() {
        display.setText(input);
    }
}
