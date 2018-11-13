package com.bryan.holiday.bryanholidayapp.activities;

import android.app.Activity;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.bryan.holiday.bryanholidayapp.R;

public class VideoPlayer_Activity extends Activity {

    VideoView videoPlayer;
    String videoID;
    static final String API_KEY = "AIzaSyAcgQS6g5TSZEgBf0eJHxFHapOfVr5YHm4";
//    static final String VIDEO_ID = "1kdILXNfaF7kDSgGcbDKBnlnjaxYB-psS";       //Garfield
    static final String VIDEO_ID = "1HROp9nn3JZvyP_dub23ieHoARSiirNnG";         //Peanuts

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        videoPlayer = findViewById(R.id.videoPlayer);

        videoID = getIntent().getExtras().getString("video_id");

        //This is to download and then play the video in a VideoPlayer_Activity
        String videoLink = "https://www.googleapis.com/drive/v3/files/" + videoID + "?key=" + API_KEY + "&alt=media";
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoPlayer);
        videoPlayer.setMediaController(mediaController);
        videoPlayer.setVideoURI(Uri.parse(videoLink));
        videoPlayer.start();
    }
}
