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

    //Let's add them songs!
    private void populateMusicData() {
        SongModel song = new SongModel("Christmas Time is Here", "Vince Guaraldi Trio", R.raw.christmas_time_is_here_vocal);
        songModelList.add(song);

        song = new SongModel("The Cowboy's Christmas Ball", "The Killers", R.raw.the_cowboys_christmas_ball);
        songModelList.add(song);

        song = new SongModel("The Snowman Soundtrack", "Bernard Cribbins", R.raw.the_snowman_soundtrack);
        songModelList.add(song);

        song = new SongModel("Walking in the Air", "Bernard Cribbins", R.raw.walking_in_the_air);
        songModelList.add(song);

        song = new SongModel("The Snowman Soundtrack Continued", "Bernard Cribbins", R.raw.the_snowman_soundtrack_pt2);
        songModelList.add(song);

        song = new SongModel("Do They Know it's Christmas?", "Band Aid", R.raw.do_they_know_its_christmas);
        songModelList.add(song);

        song = new SongModel("Do They Know it's Christmas? Ext", "Band Aid", R.raw.do_they_know_its_christmas_ext);
        songModelList.add(song);

        song = new SongModel("Thanksgiving", "George Winston", R.raw.thanksgiving);
        songModelList.add(song);

        song = new SongModel("Carol of the Bells", "George Winston", R.raw.carol_of_the_bells);
        songModelList.add(song);

        song = new SongModel("Variations on the Kanon", "George Winston", R.raw.variations_on_the_kanon_by_pachelbel);
        songModelList.add(song);
    }
}
