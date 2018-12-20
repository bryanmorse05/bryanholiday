package com.bryan.holiday.bryanholidayapp.adapters;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bryan.holiday.bryanholidayapp.R;
import com.bryan.holiday.bryanholidayapp.models.SoundModel;

import java.util.List;

public class SoundBoardRecyclerAdapter extends RecyclerView.Adapter<SoundBoardRecyclerAdapter.MyViewHolder> {

    Context context;
    private List<SoundModel> soundModelList;
    MediaPlayer mediaPlayer;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public Button soundBoardButton;
        public TextView soundBoardTitle;

        public MyViewHolder(View view) {
            super(view);
            context = itemView.getContext();
            soundBoardButton = itemView.findViewById(R.id.soundBoardButton);
            soundBoardTitle = itemView.findViewById(R.id.soundBoardTitle);
            mediaPlayer = new MediaPlayer();
        }
    }

    public SoundBoardRecyclerAdapter(List<SoundModel> soundModelList) {
        this.soundModelList = soundModelList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_sound, viewGroup, false);
        return new SoundBoardRecyclerAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {

        final SoundModel soundModel = soundModelList.get(position);

        TextView soundBoardTitle = myViewHolder.soundBoardTitle;
        soundBoardTitle.setText(soundModel.getSoundTitle());

        Button soundBoardButton = myViewHolder.soundBoardButton;
        soundBoardButton.setBackgroundResource(soundModel.getSoundPicture());

        myViewHolder.soundBoardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    mediaPlayer.release();
                }
                mediaPlayer = MediaPlayer.create(context, soundModel.getSoundFile());
                mediaPlayer.start();
            }
        });
    }

    @Override
    public int getItemCount() {
        return soundModelList.size();
    }
}
