package com.example.vibrate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button vibrate;
    Vibrator vibrator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        vibrate = (Button) findViewById(R.id.btn_vibrate);
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);


        vibrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(Build.VERSION.SDK_INT >= 26){
                    vibrator.vibrate(VibrationEffect.createOneShot((long) 3.6e+6, VibrationEffect.DEFAULT_AMPLITUDE));

                }else{
                    vibrator.vibrate((long) 3.6e+6);
                }
            }
        });
    }
}