package com.example.maqamat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.*;

public class QuizActivity extends AppCompatActivity {

    private TextView questionText;
    private RadioGroup answersGroup;
    private RadioButton answer1, answer2, answer3;
    private Button nextButton;

    private List<Question> questions;
    private int currentQuestionIndex = 0;
    private int score = 0;

    private static class Question {
        String question;
        String[] options;
        int correctAnswer;

        Question(String q, String[] opts, int correct) {
            question = q;
            options = opts;
            correctAnswer = correct;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        questionText = findViewById(R.id.questionText);
        answersGroup = findViewById(R.id.answersGroup);
        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        nextButton = findViewById(R.id.nextButton);

        loadQuestions();
        showQuestion();

        nextButton.setOnClickListener(v -> {
            int selectedId = answersGroup.getCheckedRadioButtonId();
            if (selectedId == -1) return;

            int selectedAnswer = answersGroup.indexOfChild(findViewById(selectedId));
            if (selectedAnswer == questions.get(currentQuestionIndex).correctAnswer) {
                score++;
            }

            currentQuestionIndex++;
            if (currentQuestionIndex < questions.size()) {
                showQuestion();
            } else {
                showResult();
            }
        });
    }

    private void loadQuestions() {
        questions = new ArrayList<>();
        questions.add(new Question("ما هو المقام الذي يعادل السلم الكبير الغربي؟", new String[]{"نهوند", "عجم", "كرد"}, 1));
        questions.add(new Question("أي مقام يستخدم درجة سيكاه كبداية؟", new String[]{"صبا", "سيكاه", "بيات"}, 1));
        questions.add(new Question("أي مقام يبعث على الحزن والتأمل؟", new String[]{"كرد", "عجم", "راست"}, 0));
        // أضف المزيد من الأسئلة حسب الحاجة
    }

    private void showQuestion() {
        Question q = questions.get(currentQuestionIndex);
        questionText.setText(q.question);
        answer1.setText(q.options[0]);
        answer2.setText(q.options[1]);
        answer3.setText(q.options[2]);
        answersGroup.clearCheck();
    }

    private void showResult() {
        String resultText = "لقد حصلت على " + score + " من " + questions.size();
        Toast.makeText(this, resultText, Toast.LENGTH_LONG).show();
        finish();
    }
}
