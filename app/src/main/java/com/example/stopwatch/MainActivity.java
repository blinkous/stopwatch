package com.example.stopwatch;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.os.SystemClock;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private boolean isTimerRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**Animates the background colors of the main screen background_animation in res/animator**/
        RelativeLayout myCon = findViewById(R.id.mainlayout);
        AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(this,
                R.animator.background_animation);
        set.setTarget(myCon);
        set.start();
    }

    /**Starts or stops Stopwatch*/
    public void startStopwatch(View view){
        if (isTimerRunning == false) {
            Chronometer chronometer = findViewById(R.id.myChronometer);
            chronometer.start();
            Button startButton = findViewById(R.id.startStopwatch);
            startButton.setText(getResources().getString(R.string.stop_stopwatch));
            isTimerRunning = true;
        }
        else{
            Chronometer chronometer = findViewById(R.id.myChronometer);
            chronometer.stop();
            Button startButton = findViewById(R.id.startStopwatch);
            startButton.setText(getResources().getString(R.string.start_stopwatch));
            isTimerRunning = false;
        }
    }

    /**Resets Stopwatch*/
    public void restartStopwatch(View view){
        Chronometer chronometer = findViewById(R.id.myChronometer);
        //Resets the timer to 0
        chronometer.setBase(SystemClock.elapsedRealtime());
        chronometer.stop();
        isTimerRunning = false;
    }
}
