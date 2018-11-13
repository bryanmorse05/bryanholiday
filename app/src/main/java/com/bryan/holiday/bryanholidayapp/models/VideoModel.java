package com.bryan.holiday.bryanholidayapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VideoModel {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("picture_id")
    @Expose
    private String pictureID;
    @SerializedName("video_id")
    @Expose
    private String videoID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPictureID() {
        return pictureID;
    }

    public void setPictureID(String pictureID) {
        this.pictureID = pictureID;
    }

    public String getVideoID() {
        return videoID;
    }

    public void setVideoID(String videoID) {
        this.videoID = videoID;
    }
}
