package com.example.maqamat;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        TextView aboutText = findViewById(R.id.about_text);
        aboutText.setText(
            "إعداد و تصميم : عبد الرحمن حسان حنو\n\n" +
            "البريد الإلكتروني: abod.hanno@gmail.com\n" +
            "رقم الهاتف: +963 953 302 859\n\n" +
            "هذا التطبيق التعليمي صُمم لتعليم المقامات الموسيقية العربية بأسلوب دقيق واحترافي، ويحتوي على شروحات نظرية، أمثلة صوتية، واختبارات تفاعلية. يعمل التطبيق بشكل كامل بدون اتصال بالإنترنت."
        );
    }
}
