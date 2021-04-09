package com.example.layouts;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView text1 = findViewById(R.id.text_1);
        TextView text2 = findViewById(R.id.text_2);
        TextView text3 = findViewById(R.id.text3);
        TextView text4 = findViewById(R.id.text4);
        TextView text5 = findViewById(R.id.text5);
        TextView text6 = findViewById(R.id.text6);

        text1.setOnClickListener(v -> Toast.makeText(
                MainActivity.this,
                text1.getText().toString()+" tapped.",
                Toast.LENGTH_SHORT
        ).show());

        text2.setOnClickListener(v -> Toast.makeText(
                MainActivity.this,
                text2.getText().toString()+" tapped.",
                Toast.LENGTH_SHORT
        ).show());

        text3.setOnClickListener(v -> Toast.makeText(
                MainActivity.this,
                text3.getText().toString()+" tapped.",
                Toast.LENGTH_SHORT
        ).show());

        text4.setOnClickListener(v -> Toast.makeText(
                MainActivity.this,
                text4.getText().toString()+" tapped.",
                Toast.LENGTH_SHORT
        ).show());

        text5.setOnClickListener(v -> Toast.makeText(
                MainActivity.this,
                text5.getText().toString()+" tapped.",
                Toast.LENGTH_SHORT
        ).show());

        text6.setOnClickListener(v -> Toast.makeText(
                MainActivity.this,
                text6.getText().toString()+" tapped.",
                Toast.LENGTH_SHORT
        ).show());


    }
}
