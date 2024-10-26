package com.example.app_music;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import java.io.IOException;
import java.security.Provider;

public class MusicService extends Service {
    private MediaPlayer mediaPlayer;
    private static final String CHANNEL_ID = "Music channel";
    private static final int NOTIFICATION_ID = 1;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("MusicService", "Service created");
        mediaPlayer = new MediaPlayer();
    }

    @SuppressLint("ForegroundServiceType")
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String audioUrl = intent.getStringExtra("audioUrl");
        Log.d("MusicService", "Service started with audioUrl: " + audioUrl);

        if (audioUrl != null) {
            try {
                mediaPlayer.reset();
                mediaPlayer.setDataSource(audioUrl);
                mediaPlayer.prepareAsync();
                mediaPlayer.setOnPreparedListener(mp -> {
                    Log.d("MusicService", "MediaPlayer prepared, starting playback");
                    mp.start();
                    startForeground(NOTIFICATION_ID, createNotification());
                });
                mediaPlayer.setOnErrorListener((mp, what, extra) -> {
                    Log.e("MusicService", "Error occurred while playing audio: " + what + ", " + extra);
                    return true; // Xử lý lỗi
                });
            } catch (IOException e) {
                Log.e("MusicService", "IOException occurred: " + e.getMessage());
            }
        } else {
            Log.e("MusicService", "audioUrl is null");
        }
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("MusicService", "Service destroyed");
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @SuppressLint("ObsoleteSdkInt")
    private Notification createNotification() {
        // Tạo Notification Channel (cho Android 8.0 trở lên)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Music Channel";
            String description = "Channel for music playback";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
        // Tạo Notification
        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_IMMUTABLE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_button_ok) // Thay bằng icon của bạn
                .setContentTitle("Music Player")
                .setContentText("Playing music...")
                .setContentIntent(pendingIntent);
        return builder.build();
    }
}
