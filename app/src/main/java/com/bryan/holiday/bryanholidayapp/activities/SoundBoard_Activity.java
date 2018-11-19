package com.bryan.holiday.bryanholidayapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bryan.holiday.bryanholidayapp.R;

public class SoundBoard_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_board_);

        //Back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Sound Board");
    }
}
