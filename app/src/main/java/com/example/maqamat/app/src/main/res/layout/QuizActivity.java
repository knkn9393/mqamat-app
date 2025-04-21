package com.example.maqamat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {

    private TextView questionTextView;
    private RadioGroup optionsRadioGroup;
    private RadioButton option1, option2, option3, option4;
    private Button nextButton;
    private int currentQuestionIndex = 0;
    private int score = 0;

    private String[] questions = {
        "ما هو المقام الذي يتميز بالعاطفة الحزينة وينتهي على درجة صول؟",
        "أي المقامات التالية يحتوي على درجة سيكاه في بدايته؟",
        "أي مقام يعبر عن القوة والثبات ويبدأ بدرجة دو؟"
    };

    private String[][] options = {
        {"كرد", "صبا", "نهوند", "عجم"},
        {"بيات", "راست", "سيكاه", "كرد"},
        {"عجم", "صبا", "حجاز", "راست"}
    };

    private String[] correctAnswers = {"صبا", "سيكاه", "راست"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        questionTextView = findViewById(R.id.question_text);
        optionsRadioGroup = findViewById(R.id.options_group);
        option1 = findViewById(R.id.option_1);
        option2 = findViewById(R.id.option_2);
        option3 = findViewById(R.id.option_3);
        option4 = findViewById(R.id.option_4);
        nextButton = findViewById(R.id.next_button);

        loadQuestion();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = optionsRadioGroup.getCheckedRadioButtonId();
                if (selectedId == -1) {
                    Toast.makeText(QuizActivity.this, "الرجاء اختيار إجابة", Toast.LENGTH_SHORT).show();
                    return;
                }

                RadioButton selectedRadioButton = findViewById(selectedId);
                String answer = selectedRadioButton.getText().toString();

                if (answer.equals(correctAnswers[currentQuestionIndex])) {
                    score++;
                }

                currentQuestionIndex++;
                if (currentQuestionIndex < questions.length) {
                    loadQuestion();
                } else {
                    Intent intent = new Intent(QuizActivity.this, QuizResultActivity.class);
                    intent.putExtra("score", score);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void loadQuestion() {
        questionTextView.setText(questions[currentQuestionIndex]);
        option1.setText(options[currentQuestionIndex][0]);
        option2.setText(options[currentQuestionIndex][1]);
        option3.setText(options[currentQuestionIndex][2]);
        option4.setText(options[currentQuestionIndex][3]);
        optionsRadioGroup.clearCheck();
    }
}
