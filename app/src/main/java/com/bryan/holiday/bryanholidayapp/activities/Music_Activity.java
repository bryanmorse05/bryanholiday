package com.bryan.holiday.bryanholidayapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bryan.holiday.bryanholidayapp.R;
import com.bryan.holiday.bryanholidayapp.adapters.MusicRecyclerAdapter;
import com.bryan.holiday.bryanholidayapp.models.MusicModel;

import java.util.ArrayList;
import java.util.List;

public class Music_Activity extends AppCompatActivity {

    private List<MusicModel> musicModelList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MusicRecyclerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_);

        recyclerView = findViewById(R.id.musicRecyclcerView);
        recyclerView.setHasFixedSize(false);

        mAdapter = new MusicRecyclerAdapter(musicModelList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);
        populateMusicData();

        //Back button enabled
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Music");
    }

    //Let's add them songs!
    //Maybe something Richard Cheesey.
    private void populateMusicData() {
        MusicModel song = new MusicModel("Christmas Time is Here", "Vince Guaraldi Trio", "A Charlie Brown Chrismtas", R.drawable.cbc_cover, R.raw.christmas_time_is_here_vocal);
        musicModelList.add(song);

        song = new MusicModel("The Cowboy's Christmas Ball", "The Killers", "(Red) Christmas EP", R.drawable.killers_cover, R.raw.the_cowboys_christmas_ball);
        musicModelList.add(song);

        song = new MusicModel("The Snowman Soundtrack", "Bernard Cribbins", "The Snowman", R.drawable.snowman_cover, R.raw.the_snowman_soundtrack);
        musicModelList.add(song);

        song = new MusicModel("Walking in the Air", "Bernard Cribbins", "The Snowman", R.drawable.snowman_cover, R.raw.walking_in_the_air);
        musicModelList.add(song);

        song = new MusicModel("The Snowman Soundtrack Continued", "Bernard Cribbins", "The Snowman", R.drawable.snowman_cover, R.raw.the_snowman_soundtrack_pt2);
        musicModelList.add(song);

        song = new MusicModel("Do They Know it's Christmas?", "Band Aid", "Do They Know It's Christmas?", R.drawable.bandaid_cover, R.raw.do_they_know_its_christmas);
        musicModelList.add(song);

        song = new MusicModel("Last Christmas", "Jimmy Eat World", "Christmas EP", R.drawable.jew_lastchristmas, R.raw.last_christmas);
        musicModelList.add(song);

        song = new MusicModel("Thanksgiving", "George Winston", "December", R.drawable.december_cover, R.raw.thanksgiving);
        musicModelList.add(song);

        song = new MusicModel("Carol of the Bells", "George Winston", "December", R.drawable.december_cover, R.raw.carol_of_the_bells);
        musicModelList.add(song);

        song = new MusicModel("Variations on the Kanon", "George Winston", "December", R.drawable.december_cover, R.raw.variations_on_the_kanon_by_pachelbel);
        musicModelList.add(song);

        song = new MusicModel("That Christmas Feeling", "Olivia Olson", "Phineas and Ferb Holiday Favorites", R.drawable.pf_holiday, R.raw.that_christmas_feeling);
        musicModelList.add(song);

        song = new MusicModel("One More Sleep 'til Christmas", "Kermit the Frog", "The Muppets Christmas Carol", R.drawable.mcc_soundtrack, R.raw.one_more_sleep);
        musicModelList.add(song);

        song = new MusicModel("Green Chri$tma$", "Stan Freberg", "The Meaning of Christmas", R.drawable.freeberg_gc, R.raw.green_christmas);
        musicModelList.add(song);

        song = new MusicModel("Twelve Days of Christmas", "Bob & Doug McKenzie", "Twelve Days of Christmas", R.drawable.bdmc_twlevedays, R.raw.bdmc_tdofc);
        musicModelList.add(song);
    }
}
