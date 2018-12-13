package com.bryan.holiday.bryanholidayapp.models;

import android.graphics.drawable.Drawable;

public class SoundModel {

    Integer soundFile;
    Integer soundPicture;

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

    public SoundModel(Integer soundFile, Integer soundPicture) {
        this.soundFile = soundFile;
        this.soundPicture = soundPicture;
    }

}
