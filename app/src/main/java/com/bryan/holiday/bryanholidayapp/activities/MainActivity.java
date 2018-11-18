package com.bryan.holiday.bryanholidayapp.activities;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bryan.holiday.bryanholidayapp.R;
import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    Button videoButton, yuleLogButton;
    ImageView titleScreenImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoButton = findViewById(R.id.videoButton);
        yuleLogButton = findViewById(R.id.yuleLogButton);
        titleScreenImage = findViewById(R.id.titleScreenImage);

        final MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.christmas_time_is_here_vocal);
        mediaPlayer.start();

        videoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Video_Activity.class);
                startActivity(intent);
            }
        });

        yuleLogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), YuleLog_Activity.class);
                startActivity(intent);
            }
        });

        Glide.with(titleScreenImage).load(R.drawable.original).into(titleScreenImage);

    }
}
