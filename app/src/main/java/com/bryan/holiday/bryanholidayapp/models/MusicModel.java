package com.bryan.holiday.bryanholidayapp.models;

public class MusicModel {
    String songName;
    String songArtist;
    Integer songTime;
    String songAlbum;
    Integer songAlbumArt;
    Integer songTrack;

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongArtist() {
        return songArtist;
    }

    public void setSongArtist(String songArtist) {
        this.songArtist = songArtist;
    }

    public Integer getSongTime() {
        return songTime;
    }

    public void setSongTime(Integer songTime) {
        this.songTime = songTime;
    }

    public String getSongAlbum() {
        return songAlbum;
    }

    public void setSongAlbum(String songAlbum) {
        this.songAlbum = songAlbum;
    }

    public Integer getSongAlbumArt() {
        return songAlbumArt;
    }

    public void setSongAlbumArt(Integer songAlbumArt) {
        this.songAlbumArt = songAlbumArt;
    }

    public Integer getSongTrack() {
        return songTrack;
    }

    public void setSongTrack(Integer songTrack) {
        this.songTrack = songTrack;
    }

    public MusicModel(String name, String artist, String album, Integer art, Integer track) {
        this.songName = name;
        this.songArtist = artist;
        this.songAlbum = album;
        this.songAlbumArt = art;
        this.songTrack = track;
    }
}
