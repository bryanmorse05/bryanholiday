package com.bryan.holiday.bryanholidayapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bryan.holiday.bryanholidayapp.R;
import com.bumptech.glide.Glide;

public class YuleLog_Activity extends AppCompatActivity {

    ImageView yuleLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yule_log_);

        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        // Remember that you should never show the action bar if the
        // status bar is hidden, so hide that too if necessary.
        getSupportActionBar().hide();

        yuleLog = findViewById(R.id.yuleLogImage);

        Glide.with(yuleLog).load(R.drawable.yule_log).into(yuleLog);
    }
}
