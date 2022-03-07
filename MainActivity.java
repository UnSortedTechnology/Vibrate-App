package com.example.vibrate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;


public class MainActivity extends AppCompatActivity {

    private AdView mAdView;
    private TextView TxtView;
    private Button BtnOn;
    private Button BtnRepeat;
    private Button BtnOff;
    private Vibrator v;


    @Deprecated
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        AdView adView = new AdView(this);

        adView.setAdSize(AdSize.BANNER);

        adView.setAdUnitId("ca-app-pub-3081812248414183/1296999131");

        TxtView = (TextView) findViewById(R.id.tv);
        BtnOn = (Button) findViewById(R.id.btn_on);
        BtnRepeat = (Button) findViewById(R.id.btn_repeat);
        BtnOff = (Button) findViewById(R.id.btn_off);
        // Initialize a new instance of system Vibrator
        v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);


        if (v.hasVibrator()) {
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
                long pattern[] = {0, 400, 800, 600, 800, 800, 800, 1000};

                // Vibrate the device using a pattern and repeat 3 times
                v.vibrate(pattern, 0);
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


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                Log.d("ads", "Banner ad Loaded");
            }

            @Override
            public void onAdFailedToLoad(LoadAdError adError) {
                // Code to be executed when an ad request fails.
                Log.d("ads", "Banner ad Failed to Load");
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
                Log.d("ads", "Banner ad Opened");
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
                Log.d("ads", "Banner ad Clicked");
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
                Log.d("ads", "Banner ad Closed");
            }
        });
    }


}
