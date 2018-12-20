package com.bryan.holiday.bryanholidayapp.activities;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bryan.holiday.bryanholidayapp.R;
import com.bryan.holiday.bryanholidayapp.adapters.SoundBoardRecyclerAdapter;
import com.bryan.holiday.bryanholidayapp.models.SoundModel;

import java.util.ArrayList;
import java.util.List;

public class SoundBoard_Activity extends AppCompatActivity {

    private List<SoundModel> soundModelList = new ArrayList<>();
    private RecyclerView recyclerView;
    private SoundBoardRecyclerAdapter mAdapter;
    MediaPlayer mediaPlayer;

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
        mediaPlayer = new MediaPlayer();
        populateSoundData();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
    }

    public void populateSoundData() {

        SoundModel sound = new SoundModel(R.raw.bumpuses, R.drawable.bumpuses, "Bumpuses!");
        soundModelList.add(sound);

        sound = new SoundModel(R.raw.commercial, R.drawable.commercial, "Commercial");
        soundModelList.add(sound);

        sound = new SoundModel(R.raw.deckthehalls, R.drawable.deck_the_halls, "Deck the Halls");
        soundModelList.add(sound);

        sound = new SoundModel(R.raw.fourthofjuly, R.drawable.fourthofjuly, "Indescribably beautiful!");
        soundModelList.add(sound);

        sound = new SoundModel(R.raw.fragile, R.drawable.fragile, "Fragile");
        soundModelList.add(sound);

        sound = new SoundModel(R.raw.hasticklefifer, R.drawable.hasticklefifer, "Hasticklefifer!");
        soundModelList.add(sound);

        sound = new SoundModel(R.raw.hohoho, R.drawable.hohoho, "Ho...Ho...Ho");
        soundModelList.add(sound);

        sound = new SoundModel(R.raw.holdit, R.drawable.holdit, "A fuse is out");
        soundModelList.add(sound);

        sound = new SoundModel(R.raw.holygrail, R.drawable.holygrail, "Red Ryder");
        soundModelList.add(sound);

        sound = new SoundModel(R.raw.amaster, R.drawable.amaster, "His true medium");
        soundModelList.add(sound);

        sound = new SoundModel(R.raw.justsaid, R.drawable.justsaid, "He heard it from your son");
        soundModelList.add(sound);

        sound = new SoundModel(R.raw.likeaslug, R.drawable.likeaslug, "Like a slug");
        soundModelList.add(sound);

        sound = new SoundModel(R.raw.lobsters, R.drawable.lobsters, "Lobsters");
        soundModelList.add(sound);

        sound = new SoundModel(R.raw.meatloaf, R.drawable.meatloaf, "Meatloaf");
        soundModelList.add(sound);

        sound = new SoundModel(R.raw.newfurnace, R.drawable.oldsmobile, "A new furnace");
        soundModelList.add(sound);

        sound = new SoundModel(R.raw.noturkey, R.drawable.noturkey, "Gone, all gone!");
        soundModelList.add(sound);

        sound = new SoundModel(R.raw.notafinger, R.drawable.notafinger, "Not a finger!");
        soundModelList.add(sound);

        sound = new SoundModel(R.raw.ohfudge, R.drawable.ohfudge, "Oh fudge");
        soundModelList.add(sound);

        sound = new SoundModel(R.raw.oldsmobile, R.drawable.oldmanoldsmobile, "Oldsmobileman");
        soundModelList.add(sound);

        sound = new SoundModel(R.raw.atheme, R.drawable.atheme, "A theme");
        soundModelList.add(sound);

        sound = new SoundModel(R.raw.shotmyeyeout, R.drawable.shotmyeyeout, "Shot my eye out!");
        soundModelList.add(sound);

        sound = new SoundModel(R.raw.soap, R.drawable.soap, "Connoisseur");
        soundModelList.add(sound);

        sound = new SoundModel(R.raw.thatsmine, R.drawable.thatsmine, "That's mine!");
        soundModelList.add(sound);

        sound = new SoundModel(R.raw.tripledogdare, R.drawable.tripledogdare, "Triple dog dare!");
        soundModelList.add(sound);

        sound = new SoundModel(R.raw.wantforchristmas, R.drawable.wantforchristmas, "Santa");
        soundModelList.add(sound);
    }
}
