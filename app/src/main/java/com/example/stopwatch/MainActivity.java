package com.example.stopwatch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

//    private Chronometer chronometer = findViewById(R.id.myChronometer);
//    private Button startButton = findViewById(R.id.startStopwatch);
    private boolean isTimerRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startStopwatch(View view){
        Chronometer chronometer = findViewById(R.id.myChronometer);
        chronometer.start();
        isTimerRunning = true;

        Button startButton = findViewById(R.id.startStopwatch);
        startButton.setText("Stop Stopwatch");
    }
}
