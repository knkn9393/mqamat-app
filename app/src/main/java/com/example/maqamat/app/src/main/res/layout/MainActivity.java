package com.example.maqamat;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnAjam, btnNahawand, btnRast, btnSikah, btnHijaz, btnKurd, btnBayat, btnSaba;
    Button btnIntro, btnTransitions, btnTest, btnRate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIntro = findViewById(R.id.btnIntro);
        btnTransitions = findViewById(R.id.btnTransitions);
        btnTest = findViewById(R.id.btnTest);
        btnRate = findViewById(R.id.btnRate);

        btnAjam = findViewById(R.id.btnAjam);
        btnNahawand = findViewById(R.id.btnNahawand);
        btnRast = findViewById(R.id.btnRast);
        btnSikah = findViewById(R.id.btnSikah);
        btnHijaz = findViewById(R.id.btnHijaz);
        btnKurd = findViewById(R.id.btnKurd);
        btnBayat = findViewById(R.id.btnBayat);
        btnSaba = findViewById(R.id.btnSaba);

        btnIntro.setOnClickListener(view -> startActivity(new Intent(this, IntroActivity.class)));
        btnTransitions.setOnClickListener(view -> startActivity(new Intent(this, TransitionRulesActivity.class)));
        btnTest.setOnClickListener(view -> startActivity(new Intent(this, TestActivity.class)));
        btnRate.setOnClickListener(view -> startActivity(new Intent(this, RateActivity.class)));

        btnAjam.setOnClickListener(view -> openMaqamActivity("ajam"));
        btnNahawand.setOnClickListener(view -> openMaqamActivity("nahawand"));
        btnRast.setOnClickListener(view -> openMaqamActivity("rast"));
        btnSikah.setOnClickListener(view -> openMaqamActivity("sikah"));
        btnHijaz.setOnClickListener(view -> openMaqamActivity("hijaz"));
        btnKurd.setOnClickListener(view -> openMaqamActivity("kurd"));
        btnBayat.setOnClickListener(view -> openMaqamActivity("bayat"));
        btnSaba.setOnClickListener(view -> openMaqamActivity("saba"));
    }

    private void openMaqamActivity(String maqamName) {
        Intent intent = new Intent(this, MaqamActivity.class);
        intent.putExtra("maqam", maqamName);
        startActivity(intent);
    }
}
