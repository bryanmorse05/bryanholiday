package com.bryan.holiday.bryanholidayapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bryan.holiday.bryanholidayapp.R;
import com.bryan.holiday.bryanholidayapp.adapters.MusicRecyclerAdapter;
import com.bryan.holiday.bryanholidayapp.models.SongModel;

import java.util.ArrayList;
import java.util.List;

public class Music_Activity extends AppCompatActivity {

    private List<SongModel> songModelList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MusicRecyclerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_);

        recyclerView = findViewById(R.id.musicRecyclcerView);
        recyclerView.setHasFixedSize(false);

        mAdapter = new MusicRecyclerAdapter(songModelList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);
        populateMusicData();

        //Back button enabled
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Music");
    }

    private void populateMusicData() {
        SongModel song = new SongModel("Christmas Time is Here", "Vince Guaraldi Trio", R.raw.christmas_time_is_here_vocal);
        songModelList.add(song);

        song = new SongModel("The Cowboy's Christmas Ball", "The Killers", R.raw.the_cowboys_christmas_ball);
        songModelList.add(song);
    }
}
