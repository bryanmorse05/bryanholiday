package com.bryan.holiday.bryanholidayapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bryan.holiday.bryanholidayapp.R;
import com.bryan.holiday.bryanholidayapp.activities.VideoPlayer_Activity;
import com.bryan.holiday.bryanholidayapp.models.VideoModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class VideoRecyclerAdapter extends RecyclerView.Adapter<VideoRecyclerAdapter.ViewHolder> {

    Context context;
    ArrayList<VideoModel> videoModelArrayList;

    public VideoRecyclerAdapter(ArrayList<VideoModel> videoModelArrayList) {
        super();
        this.videoModelArrayList = videoModelArrayList;
    }

    @Override
    public VideoRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video, parent, false);
        VideoRecyclerAdapter.ViewHolder viewHolder = new VideoRecyclerAdapter.ViewHolder(view);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(final VideoRecyclerAdapter.ViewHolder holder, int position) {

        final VideoModel videoModel = videoModelArrayList.get(position);

        TextView nameText = holder.videoName;
        nameText.setText(videoModel.getName());

        //Set the image using Picasso
        if (videoModel.getPictureID() != null || videoModel.getPictureID() != "") {

            Picasso.with(context)
                    .load(videoModel.getPictureID())
                    .error(R.drawable.ic_launcher_background)       //Handles 404, but not null
                    .into(holder.videoImage);
        }
        else {
            Picasso.with(context).load(R.drawable.ic_launcher_background).into(holder.videoImage);
        }

        //Setting listener for when user taps on a card
        ConstraintLayout constraintLayout = holder.videoLayout;
        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, VideoPlayer_Activity.class);
                intent.putExtra("video_id", videoModel.getVideoID());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return videoModelArrayList.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView videoName;
        public ImageView videoImage;
        public ConstraintLayout videoLayout;

        public ViewHolder(View itemView) {

            super(itemView);

            videoName = itemView.findViewById(R.id.videoName);
            videoImage = itemView.findViewById(R.id.videoImage);
            videoLayout = itemView.findViewById(R.id.videoLayout);

            context = itemView.getContext();
        }
    }
}
