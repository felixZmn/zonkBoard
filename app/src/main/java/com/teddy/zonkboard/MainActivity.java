package com.teddy.zonkboard;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    static MediaPlayer mp = new MediaPlayer();
    int maxVolume;
    int volume;
    AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        mp.setOnCompletionListener(mp -> audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, volume, 0));

        Button buttonZonk = this.findViewById(R.id.buttonPlayZonk);
        Button buttonBadum = this.findViewById(R.id.buttonPlayBadum);
        Button buttonJeopardy = this.findViewById(R.id.buttonPlayJeopardy);
        Button buttonShutdown = this.findViewById(R.id.buttonPlayShutdown);

        buttonZonk.setOnClickListener(v -> {
            if (mp.isPlaying()) {
                mp.stop();
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, volume, 0);
            } else {
                playSound(R.raw.zonk);
            }
        });

        buttonBadum.setOnClickListener(v -> {
            if (mp.isPlaying()) {
                mp.stop();
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, volume, 0);
            } else {
                playSound(R.raw.badumtss);
            }
        });

        buttonJeopardy.setOnClickListener(v -> {
            if (mp.isPlaying()) {
                mp.stop();
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, volume, 0);
            } else {
                playSound(R.raw.jeopardy);
            }
        });

        buttonShutdown.setOnClickListener(v -> {
            if (mp.isPlaying()) {
                mp.stop();
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, volume, 0);
            } else {
                playSound(R.raw.shutdown);
            }
        });
    }

    private void playSound(int sound) {
        mp.reset();
        try {
            maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
            volume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, maxVolume, 0);
            mp.setDataSource(getApplicationContext(), Uri.parse("android.resource://com.teddy.zonkboard/" + sound));
            mp.prepare();
            mp.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
