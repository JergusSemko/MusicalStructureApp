package com.example.android.musicalstructureapp;

public class Mood {

    // Feature to provide an image.
    private static final int NO_IMAGE_PROVIDED = -1;

    // Name of the mood.
    private String mMood;
    private int mMoodImage = NO_IMAGE_PROVIDED;

    /**
     * @param choseMood    user can choose the music according to mood.
     * @param imgResource  resource for the image.
     */
    public Mood(String choseMood, int imgResource) {
        mMood = choseMood;
        mMoodImage = imgResource;
    }

    public String getChosenMood() {
        return mMood;
    }
    public Integer getImg() {
        return mMoodImage;
    }
    public boolean hasImage() {
        return mMoodImage != NO_IMAGE_PROVIDED;
    }
}

