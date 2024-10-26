package com.example.app_music;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button btnPlay, btnStop;
    private TextView txtSongTitle;
    private static final String AUDIO_URL =  "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnPlay = findViewById(R.id.btnplay);
        btnStop = findViewById(R.id.btnstop);
        txtSongTitle = findViewById(R.id.txtname);
        btnPlay.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MusicService.class);
            intent.putExtra("audioUrl", AUDIO_URL);
            startService(intent);
            txtSongTitle.setText("Đang phát: SoundHelix-Song-1.mp3");
        });
        btnStop.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MusicService.class);
            stopService(intent);
            txtSongTitle.setText("Dừng phát nhạc");
        });
    }
}