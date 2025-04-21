package com.example.maqamat;

import android.content.Context;
import android.media.MediaPlayer;

public class MaqamPlayer {
    private MediaPlayer mediaPlayer;
    private Context context;

    public MaqamPlayer(Context context) {
        this.context = context;
    }

    public void play(int resourceId) {
        stop();
        mediaPlayer = MediaPlayer.create(context, resourceId);
        mediaPlayer.start();
    }

    public void stop() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    public boolean isPlaying() {
        return mediaPlayer != null && mediaPlayer.isPlaying();
    }
}
