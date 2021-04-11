package com.example.alarmclock;

import android.annotation.SuppressLint;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Calendar calendar;
    TimePickerDialog timePickerDialog;
    int currentHr, currentMin;
    @SuppressLint({"DefaultLocale", "QueryPermissionsNeeded"})
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView hrsText = findViewById(R.id.hrs_text);
        TextView minsText = findViewById(R.id.mins_text);
        Button timeBtn = findViewById(R.id.time_btn);
        Button alarmBtn = findViewById(R.id.alarm_btn);

        timeBtn.setOnClickListener(v -> {
            calendar = Calendar.getInstance();
            currentHr = calendar.get(Calendar.HOUR_OF_DAY);
            currentMin = calendar.get(Calendar.MINUTE);
            timePickerDialog = new TimePickerDialog(
                    MainActivity.this,
                    (timePicker, hourOfDay, minute) -> {
                hrsText.setText(String.format("%02d", hourOfDay));
                minsText.setText(String.format("%02d", minute));
            }, currentHr, currentMin, false);
            timePickerDialog.show();
        });

        alarmBtn.setOnClickListener(v -> {
            if(!hrsText.getText().toString().isEmpty() && !minsText.getText().toString().isEmpty()) {
                Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
                intent.putExtra(
                        AlarmClock.EXTRA_HOUR,
                        Integer.parseInt(
                                hrsText.getText().toString()
                        )
                );
                intent.putExtra(
                        AlarmClock.EXTRA_MINUTES,
                        Integer.parseInt(
                                minsText.getText().toString()
                        )
                );
                intent.putExtra(
                        AlarmClock.EXTRA_MESSAGE,
                        "Alarm Set!"
                );
                if(intent.resolveActivity(getPackageManager()) != null) {
                    Toast.makeText(this, "Alarm has been set!", Toast.LENGTH_LONG).show();
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "No alarm app exists", Toast.LENGTH_SHORT).show();
                }

            } else {
                Toast.makeText(this, "Enter the time!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
