package com.example.maqamat;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MaqamActivity extends AppCompatActivity {

    TextView maqamTitle, maqamDescription;
    Button playScale, playExample1, playExample2;
    MediaPlayer mediaPlayer;
    int maqamId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maqam);

        maqamTitle = findViewById(R.id.maqamTitle);
        maqamDescription = findViewById(R.id.maqamDescription);
        playScale = findViewById(R.id.playScale);
        playExample1 = findViewById(R.id.playExample1);
        playExample2 = findViewById(R.id.playExample2);

        maqamId = getIntent().getIntExtra("MAQAM_ID", 0);

        switch (maqamId) {
            case 0:
                maqamTitle.setText("مقام كرد");
                maqamDescription.setText("تعريف: مقام كرد هو مقام شرقي يستخدم كثيراً في الموسيقى العربية... \n\nسلم المقام: دو - ري بيمول - مي بيمول - فا - صول - لا بيمول - سي بيمول - دو\n\nالصفات: يوحي بالحزن والحنين.");
                setupAudio(R.raw.kurd_scale, R.raw.kurd_example1, R.raw.kurd_example2);
                break;
            case 1:
                maqamTitle.setText("مقام نهوند");
                maqamDescription.setText("تعريف: مقام نهوند هو مقام قريب من المينور في الموسيقى الغربية...\n\nسلم المقام: دو - ري - مي بيمول - فا - صول - لا بيمول - سي - دو\n\nالصفات: يعبر عن العاطفة والدفء.");
                setupAudio(R.raw.nahawand_scale, R.raw.nahawand_example1, R.raw.nahawand_example2);
                break;
            case 2:
                maqamTitle.setText("مقام عجم");
                maqamDescription.setText("تعريف: مقام عجم يشبه السلم الكبير في الموسيقى الغربية...\n\nسلم المقام: دو - ري - مي - فا - صول - لا - سي - دو\n\nالصفات: يوحي بالفخامة والقوة.");
                setupAudio(R.raw.ajam_scale, R.raw.ajam_example1, R.raw.ajam_example2);
                break;
            // أضف باقي المقامات بنفس الطريقة...
        }

        playScale.setOnClickListener(v -> playSound("scale"));
        playExample1.setOnClickListener(v -> playSound("example1"));
        playExample2.setOnClickListener(v -> playSound("example2"));
    }

    private void setupAudio(int scaleRes, int ex1Res, int ex2Res) {
        playScale.setTag(scaleRes);
        playExample1.setTag(ex1Res);
        playExample2.setTag(ex2Res);
    }

    private void playSound(String which) {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }

        int resId = 0;
        if (which.equals("scale")) resId = (int) playScale.getTag();
        else if (which.equals("example1")) resId = (int) playExample1.getTag();
        else if (which.equals("example2")) resId = (int) playExample2.getTag();

        mediaPlayer = MediaPlayer.create(this, resId);
        mediaPlayer.start();
    }

    @Override
    protected void onDestroy() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        super.onDestroy();
    }
}
