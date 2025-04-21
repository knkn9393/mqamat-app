package com.abdulrahman.maqamat;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MaqamTestActivity extends AppCompatActivity {

    private String[] questions = {
            "ما هو المقام الذي يتميز بعاطفة الحزن؟",
            "أي مقام يبدأ بدرجة الراست؟",
            "ما المقام الذي يعطي إحساس الفرح والثقة؟"
    };

    private String[][] choices = {
            {"مقام صبا", "مقام عجم", "مقام حجاز"},
            {"مقام راست", "مقام سيكاه", "مقام كرد"},
            {"مقام عجم", "مقام بيات", "مقام صبا"}
    };

    private String[] correctAnswers = {
            "مقام صبا",
            "مقام راست
