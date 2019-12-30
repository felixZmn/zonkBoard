package com.teddy.zonkboard;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    static MediaPlayer mp = new MediaPlayer();
    int playing = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonZonk = this.findViewById(R.id.buttonPlayZonk);
        Button buttonBadum = this.findViewById(R.id.buttonPlayBadum);
        Button buttonJeopardy = this.findViewById(R.id.buttonPlayJeopardy);

        buttonZonk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp.isPlaying())
                    mp.stop();
                else
                    playSound(R.raw.zonk);
            }
        });

        buttonBadum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp.isPlaying())
                    mp.stop();
                else
                    playSound(R.raw.badumtss);
            }
        });

        buttonJeopardy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp.isPlaying())
                    mp.stop();
                else
                    playSound(R.raw.jeopardy);
            }
        });
    }

    private void playSound(int sound) {
        mp.reset();
        try {
            mp.setDataSource(getApplicationContext(), Uri.parse("android.resource://com.teddy.zonkboard/" + sound));
            mp.prepare();
            mp.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
