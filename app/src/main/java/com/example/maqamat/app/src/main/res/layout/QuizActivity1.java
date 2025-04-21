package com.example.maqamat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {

    private TextView questionText;
    private RadioGroup choicesGroup;
    private RadioButton choice1, choice2, choice3;
    private Button submitButton;
    private int currentQuestion = 0;
    private int score = 0;

    private String[] questions = {
            "ما هو المقام الذي يتميز بالعاطفة الحزينة ويبدأ بدرجة ري؟",
            "أي من المقامات التالية يعتبر من المقامات الشرقية الصرفة؟",
            "ما هو المقام الذي يبدأ من نغمة دو ويعطي إحساس الفرح؟"
    };

    private String[][] choices = {
            {"مقام الصبا", "مقام البيات", "مقام العجم"},
            {"مقام السيكاه", "مقام العجم", "مقام الكرد"},
            {"مقام العجم", "مقام الحجاز", "مقام النهوند"}
    };

    private String[] correctAnswers = {
            "مقام الصبا",
            "مقام السيكاه",
            "مقام العجم"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        questionText = findViewById(R.id.questionText);
        choicesGroup = findViewById(R.id.choicesGroup);
        choice1 = findViewById(R.id.choice1);
        choice2 = findViewById(R.id.choice2);
        choice3 = findViewById(R.id.choice3);
        submitButton = findViewById(R.id.submitButton);

        loadQuestion();

        submitButton.setOnClickListener(view -> {
            int selectedId = choicesGroup.getCheckedRadioButtonId();
            if (selectedId == -1) return;

            RadioButton selectedRadioButton = findViewById(selectedId);
            String selectedAnswer = selectedRadioButton.getText().toString();

            if (selectedAnswer.equals(correctAnswers[currentQuestion])) {
                score++;
            }

            currentQuestion++;
            if (currentQuestion < questions.length) {
                loadQuestion();
            } else {
                Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                intent.putExtra("score", score);
                intent.putExtra("total", questions.length);
                startActivity(intent);
                finish();
            }
        });
    }

    private void loadQuestion() {
        questionText.setText(questions[currentQuestion]);
        choice1.setText(choices[currentQuestion][0]);
        choice2.setText(choices[currentQuestion][1]);
        choice3.setText(choices[currentQuestion][2]);
        choicesGroup.clearCheck();
    }
}
