package com.example.android.musicalstructureapp;

public class Songs {

    // The same feature just as the one in Mood class.
    private static final int NO_IMAGE_PROVIDED = -1;
    private int mImageComposer = NO_IMAGE_PROVIDED;

    private String mSongName;
    private String mArtistFirstName;
    private String mArtistSecondName;

    // And thus the new song object was created.
    public Songs(String songName, String firstName, String secondName, int imgResource) {
        mSongName = songName;
        mArtistFirstName = firstName;
        mArtistSecondName = secondName;
        mImageComposer = imgResource;
    }

    // Getting everything together.
    public String getSecondName() {
        return mArtistSecondName;
    }
    public String getFirstName() {
        return mArtistFirstName;
    }
    public String getSongName() {
        return mSongName;
    }
    public Integer getImageResourceId() {
        return mImageComposer;
    }

    // Checks if there is an image.
    public boolean hasImage() {
        return mImageComposer != NO_IMAGE_PROVIDED;
    }
}