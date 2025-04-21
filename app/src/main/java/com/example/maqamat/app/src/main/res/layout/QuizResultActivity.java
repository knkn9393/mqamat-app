// QuizResultActivity.java

package com.example.maqamat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizResultActivity extends Activity {

    TextView resultTextView;
    Button tryAgainButton, homeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);

        resultTextView = findViewById(R.id.result_text);
        tryAgainButton = findViewById(R.id.try_again_button);
        homeButton = findViewById(R.id.home_button);

        int score = getIntent().getIntExtra("SCORE", 0);
        int total = getIntent().getIntExtra("TOTAL", 1);
        resultTextView.setText("نتيجتك: " + score + " من " + total);

        tryAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retryIntent = new Intent(QuizResultActivity.this, QuizActivity.class);
                startActivity(retryIntent);
                finish();
            }
        });

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent(QuizResultActivity.this, MainActivity.class);
                startActivity(homeIntent);
                finish();
            }
        });
    }
}
