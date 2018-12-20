package com.bryan.holiday.bryanholidayapp.activities;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.bryan.holiday.bryanholidayapp.R;
import com.squareup.picasso.Picasso;

//CREDITS:
//codingwithSara https://www.youtube.com/watch?v=zCYQBIcePaw

public class MusicPlayer_Activity extends AppCompatActivity {

    ImageView albumArt;
    Button musicPlayerPlayButton;
    SeekBar positionBar, volumeBar;
    TextView timeElapsed, timeRemaining;
    MediaPlayer mediaPlayer;
    int totalTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player_);

        albumArt = findViewById(R.id.musicPlayerAlbumArt);
        musicPlayerPlayButton = findViewById(R.id.musicPlayerPlayButton);
        positionBar = findViewById(R.id.musicPlayerSeekBar);
        volumeBar = findViewById(R.id.musicPlayerVolumeBar);
        timeElapsed = findViewById(R.id.timeElapsed);
        timeRemaining = findViewById(R.id.timeRemaining);

        //Getting the size of the window
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * .95), (int) (height * .7));

        //Album Art
        Picasso.with(this).load(getIntent().getExtras().getInt("AlbumArt", R.drawable.default_music)).into(albumArt);

        //The Music yo
        mediaPlayer = MediaPlayer.create(this, getIntent().getExtras().getInt("Song", 0));
        mediaPlayer.setLooping(false);
        mediaPlayer.seekTo(0);
        mediaPlayer.setVolume(0.5f, 0.5f);
        totalTime = mediaPlayer.getDuration();

        //Play Button
        musicPlayerPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mediaPlayer.isPlaying()) {
                    mediaPlayer.start();
                    musicPlayerPlayButton.setBackgroundResource(R.drawable.greenpausebutton);
                } else {
                    mediaPlayer.pause();
                    musicPlayerPlayButton.setBackgroundResource(R.drawable.greenplaybutton);
                }
            }
        });

        //Volume Button
        volumeBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float volumeNum = progress / 100f;
                mediaPlayer.setVolume(volumeNum, volumeNum);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //Position Bar
        positionBar.setMax(totalTime);
        positionBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mediaPlayer.seekTo(progress);
                    positionBar.setProgress(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //NEW THREAD: Update positionBar and time label
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mediaPlayer != null) {
                    try {
                        Message message = new Message();
                        message.what = mediaPlayer.getCurrentPosition();
                        handler.sendMessage(message);

                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }).start();
    }
        @SuppressLint("HandlerLeak")
        private Handler handler = new Handler() {

            @Override
            public void handleMessage(Message message) {
                int currentPosition = message.what;

                //Update position bar
                positionBar.setProgress(currentPosition);

                //Update Labels
                String elapsedTime = createTimeLabel(currentPosition);
                timeElapsed.setText(elapsedTime);

                String remainingTime = createTimeLabel(totalTime - currentPosition);
                timeRemaining.setText("- " + remainingTime);
            }
        };

    public static String createTimeLabel(int time) {
        String timeLabel;
        int min = time / 1000 / 60;
        int sec = time / 1000 % 60;

        timeLabel = min + " : ";
        if (sec < 10) {
            timeLabel += "0";
        }
        timeLabel += sec;

        return timeLabel;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {  //check for null instead of playing because the additional thread is checking for a null state.
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;     //set to null so the app stops crashing.
        }
    }

}