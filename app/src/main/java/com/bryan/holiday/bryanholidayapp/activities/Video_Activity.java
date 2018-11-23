package com.bryan.holiday.bryanholidayapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.Toast;

import com.bryan.holiday.bryanholidayapp.R;
import com.bryan.holiday.bryanholidayapp.adapters.VideoRecyclerAdapter;
import com.bryan.holiday.bryanholidayapp.models.VideoModel;
import com.bryan.holiday.bryanholidayapp.retrofit.RetrofitInstance;
import com.bryan.holiday.bryanholidayapp.retrofit.RetrofitVideosAPI;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Video_Activity extends AppCompatActivity {

    RecyclerView videoRecyclerView;
    VideoRecyclerAdapter adapter;
    GridLayoutManager gridLayoutManager;    //2x2
    ImageView backgroundImage;

    ArrayList<VideoModel> videoModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_);

        //Setting up and enabling the back button in the support bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Movies");

        videoModelArrayList = new ArrayList<>();

        backgroundImage = findViewById(R.id.backgroundImage);
        Glide.with(backgroundImage).load(R.drawable.christmas_tree_background).into(backgroundImage);

        videoRecyclerView = findViewById(R.id.videoRecyclerView);
        videoRecyclerView.setHasFixedSize(false);

        adapter = new VideoRecyclerAdapter(videoModelArrayList);
        videoRecyclerView.setAdapter(adapter);

        gridLayoutManager = new GridLayoutManager(this, 2);
        videoRecyclerView.setLayoutManager(gridLayoutManager);

        RetrofitVideosAPI retrofitVideosAPI = RetrofitInstance.getRetrofitInstance().create(RetrofitVideosAPI.class);

        Call<List<VideoModel>> call = retrofitVideosAPI.getEvents();

        call.enqueue(new Callback<List<VideoModel>>() {
            @Override
            public void onResponse(Call<List<VideoModel>> call, Response<List<VideoModel>> response) {

                List<VideoModel> eventsList = response.body();

                for (int i=0; i < eventsList.size(); i++) {

                    VideoModel videoModel = new VideoModel();

                    videoModel.setName(eventsList.get(i).getName());
                    //videoModel.setPicture_url(eventsList.get(i).getPicture_url());
                    videoModel.setVideoID(eventsList.get(i).getVideoID());

                    //Check to see if the URL is empty.  If it is, Picasso will cause the app to crash
                    //because it does not like a null/empty field.  For whatever reason, I can't just
                    //pass eventsList.get(i).getImageURL into the if statement, it must be stored in
                    //a different variable.  By passing "none" at least it's not empty and Picasso
                    //will use the default value in the RecyclerAdapter.
                    String storedImageURL;
                    storedImageURL = eventsList.get(i).getPictureID();
                    if (storedImageURL == null || storedImageURL == "") {
                        videoModel.setPictureID("none");
                    } else {
                        videoModel.setPictureID(eventsList.get(i).getPictureID());
                    }

                    videoModelArrayList.add(videoModel);

                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<VideoModel>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
