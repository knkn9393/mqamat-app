// App.java
package com.example.maqamat;

import android.app.Application;
import android.content.Context;
import android.media.AudioManager;

public class App extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getAppContext() {
        return context;
    }

    // Example function for handling audio settings, such as volume control
    public static void setVolume(int level) {
        AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        if (audioManager != null) {
            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, level, 0);
        }
    }
}
