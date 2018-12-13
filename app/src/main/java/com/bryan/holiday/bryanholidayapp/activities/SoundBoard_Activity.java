package com.bryan.holiday.bryanholidayapp.activities;

import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.bryan.holiday.bryanholidayapp.R;
import com.bryan.holiday.bryanholidayapp.adapters.MusicRecyclerAdapter;
import com.bryan.holiday.bryanholidayapp.adapters.SoundBoardRecyclerAdapter;
import com.bryan.holiday.bryanholidayapp.models.SongModel;
import com.bryan.holiday.bryanholidayapp.models.SoundModel;

import java.util.ArrayList;
import java.util.List;

public class SoundBoard_Activity extends AppCompatActivity {

    private List<SoundModel> soundModelList = new ArrayList<>();
    private RecyclerView recyclerView;
    private SoundBoardRecyclerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_board_);

        //Back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("A Christmas Story Sound Board");

        recyclerView = findViewById(R.id.soundBoardRecyclerView);
        recyclerView.setHasFixedSize(false);

        mAdapter = new SoundBoardRecyclerAdapter(soundModelList);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 5);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);
        populateSoundData();


        /*
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    mediaPlayer.release();
                }
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.bumpuses);
                mediaPlayer.start();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.commercial);
                mediaPlayer.start();
            }
        });
*/
    }

    public void populateSoundData() {

        SoundModel sound = new SoundModel(R.raw.bumpuses, R.drawable.snowflake);
        soundModelList.add(sound);

        sound = new SoundModel(R.raw.commercial, R.drawable.xmasbox);
        soundModelList.add(sound);
    }
}
