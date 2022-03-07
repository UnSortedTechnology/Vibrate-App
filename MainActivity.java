package com.example.vibrate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView TxtView;
    private Button BtnOn;
    private Button BtnRepeat;
    private Button BtnOff;
    private Vibrator v;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        TxtView = (TextView) findViewById(R.id.tv);
        BtnOn = (Button) findViewById(R.id.btn_on);
        BtnRepeat = (Button) findViewById(R.id.btn_repeat);
        BtnOff = (Button) findViewById(R.id.btn_off);
        // Initialize a new instance of system Vibrator
        v = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);


        if(v.hasVibrator()){
            TxtView.setText("Yes !!!!!!! Your Device has a Vibrator.");
        }
        // Set a click listener for Vibrate button
        BtnOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Vibrate the device for a specified time
                v.vibrate(5000); // 5 seconds
            }
        });

        // Set a click listener for repeat button
        BtnRepeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Vibrate the device repeatedly.
                // Set a pattern for vibration
                long pattern[] = {0,400,800,600,800,800,800,1000};

                // Vibrate the device using a pattern and repeat 3 times
                v.vibrate(pattern,0);
            }
        });

        // Set a click listener for vibration off button
        BtnOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Cancel the vibration
                v.cancel();
            }
        });
    }
}