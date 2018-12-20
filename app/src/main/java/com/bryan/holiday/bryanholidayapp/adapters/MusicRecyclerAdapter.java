package com.bryan.holiday.bryanholidayapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bryan.holiday.bryanholidayapp.R;
import com.bryan.holiday.bryanholidayapp.activities.MusicPlayer_Activity;
import com.bryan.holiday.bryanholidayapp.models.MusicModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MusicRecyclerAdapter extends RecyclerView.Adapter<MusicRecyclerAdapter.MyViewHolder> {

    Context context;
    private List<MusicModel> musicModelList;
//    MediaPlayer mediaPlayer;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView songName;
        public TextView songArtist;
        public TextView songAlbum;
        public ImageView albumArt;
        public ConstraintLayout musicCellLayout;

        public MyViewHolder(View view) {
            super(view);
            songName = view.findViewById(R.id.songName);
            songArtist = view.findViewById(R.id.songArtist);
            songAlbum = view.findViewById(R.id.songAlbum);
            context = itemView.getContext();
            albumArt = view.findViewById(R.id.albumArt);
            musicCellLayout = view.findViewById(R.id.musicCellLayout);
//            mediaPlayer = new MediaPlayer();
        }
    }

    public MusicRecyclerAdapter(List<MusicModel> musicModelList) {
        this.musicModelList = musicModelList;
    }

    @NonNull
    @Override
    public MusicRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_music, viewGroup, false);
        return new MusicRecyclerAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicRecyclerAdapter.MyViewHolder myViewHolder, int position) {

        final MusicModel musicModel = musicModelList.get(position);

        TextView songName = myViewHolder.songName;
        songName.setText(musicModel.getSongName());

        TextView songArtist = myViewHolder.songArtist;
        songArtist.setText(musicModel.getSongArtist());

        TextView songAlbum = myViewHolder.songAlbum;
        songAlbum.setText(musicModel.getSongAlbum());

        Picasso.with(context).load(musicModel.getSongAlbumArt()).into(myViewHolder.albumArt);

        myViewHolder.musicCellLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MusicPlayer_Activity.class);
                intent.putExtra("Song", musicModel.getSongTrack());
                intent.putExtra("AlbumArt", musicModel.getSongAlbumArt());
                context.startActivity(intent);
            }
        });

        /*myViewHolder.playButton.setOnClickListener(new View.OnClickListener() {


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
        */
    }

    @Override
    public int getItemCount() {
        return musicModelList.size();
    }

}
