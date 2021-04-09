package com.example.nativecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView operator = findViewById(R.id.operator);
        EditText input1 = findViewById(R.id.input1);
        EditText input2 = findViewById(R.id.input2);
        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnSub = findViewById(R.id.btnSub);
        Button btnMul = findViewById(R.id.btnMul);
        Button btnDiv = findViewById(R.id.btnDiv);
        Button calculate = findViewById(R.id.btnCalculate);
        TextView result = findViewById(R.id.resultView);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator.setText("+");
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator.setText("-");
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator.setText("x");
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator.setText("/");
            }
        });
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Double.parseDouble(input2.getText().toString()) == 0) {
                    if(operator.getText().toString() == "/") {
                        Toast.makeText(
                                MainActivity.this,
                                "Divide by 0 Error",
                                Toast.LENGTH_SHORT).show();
                        result.setText("Result");
                    }
                } else {
                    double resultStr = calculateRes(
                            input1.getText().toString(),
                            input2.getText().toString(),
                            operator.getText().toString());
                    result.setText(resultStr + "");
                }
            }
        });
    }

    private double calculateRes(String input1, String input2, String operator) {
        double result=0;
        double inp1 = Double.parseDouble(input1);
        double inp2 = Double.parseDouble(input2);
        switch (operator) {
            case "+": result = inp1 + inp2; break;
            case "-": result = inp1 - inp2; break;
            case "x": result = inp1 * inp2; break;
            case "/": result = inp1 / inp2; break;

        }
        return result;
    }
}
