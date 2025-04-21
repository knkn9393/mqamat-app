package com.maqamat.app;

import android.content.Context;
import android.media.MediaPlayer;

public class MaqamPlayer {

    private MediaPlayer mediaPlayer;
    private Context context;

    public MaqamPlayer(Context context) {
        this.context = context;
    }

    public void play(int resId) {
        stop(); // لإيقاف أي تشغيل سابق
        mediaPlayer = MediaPlayer.create(context, resId);
        if (mediaPlayer != null) {
            mediaPlayer.setOnCompletionListener(mp -> stop());
            mediaPlayer.start();
        }
    }

    public void stop() {
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    public boolean isPlaying() {
        return mediaPlayer != null && mediaPlayer.isPlaying();
    }
}
