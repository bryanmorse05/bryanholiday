package com.bryan.holiday.bryanholidayapp.adapters;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bryan.holiday.bryanholidayapp.R;
import com.bryan.holiday.bryanholidayapp.models.SongModel;

import java.io.IOException;
import java.util.List;

public class MusicRecyclerAdapter extends RecyclerView.Adapter<MusicRecyclerAdapter.MyViewHolder> {

    Context context;
    private List<SongModel> songModelList;
    MediaPlayer mediaPlayer;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView songName;
        public TextView songArtist;
        public Button playButton;

        public MyViewHolder(View view) {
            super(view);
            songName = view.findViewById(R.id.songName);
            songArtist = view.findViewById(R.id.songArtist);
            context = itemView.getContext();
            playButton = view.findViewById(R.id.playButton);
            mediaPlayer = new MediaPlayer();
        }
    }

    public MusicRecyclerAdapter(List<SongModel> songModelList) {
        this.songModelList = songModelList;
    }

    @NonNull
    @Override
    public MusicRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_song, viewGroup, false);
        return new MusicRecyclerAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicRecyclerAdapter.MyViewHolder myViewHolder, int position) {

        final SongModel songModel = songModelList.get(position);

        TextView songName = myViewHolder.songName;
        songName.setText(songModel.getSongName());

        TextView songArtist = myViewHolder.songArtist;
        songArtist.setText(songModel.getSongArtist());



        myViewHolder.playButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {


                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    mediaPlayer.reset();
                }
                else {
                    try {
                        MediaPlayer.create(context, songModel.getSongTrack());
                        Uri uri = Uri.parse("android.resource://" + context.getPackageName() + "/" + songModel.getSongTrack());
                        mediaPlayer.setDataSource(context, uri);
                        mediaPlayer.prepare();
                        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                            @Override
                            public void onPrepared(MediaPlayer mediaPlayer) {

                                mediaPlayer.start();
                            }
                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Log.d("Button pressed", songModel.getSongName());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return songModelList.size();
    }
}
