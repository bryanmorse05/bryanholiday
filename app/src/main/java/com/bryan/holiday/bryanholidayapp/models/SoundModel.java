package com.bryan.holiday.bryanholidayapp.models;

import android.graphics.drawable.Drawable;

public class SoundModel {

    Integer soundFile;
    Integer soundPicture;
    String soundTitle;

    public Integer getSoundFile() {
        return soundFile;
    }

    public void setSoundFile(Integer soundFile) {
        this.soundFile = soundFile;
    }

    public Integer getSoundPicture() {
        return soundPicture;
    }

    public void setSoundPicture(Integer soundPicture) {
        this.soundPicture = soundPicture;
    }

    public String getSoundTitle() {
        return soundTitle;
    }

    public void setSoundTitle(String soundTitle) {
        this.soundTitle = soundTitle;
    }

    public SoundModel(Integer soundFile, Integer soundPicture, String soundTitle) {
        this.soundFile = soundFile;
        this.soundPicture = soundPicture;
        this.soundTitle = soundTitle;
    }

}
