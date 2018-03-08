package com.example.android.musicalstructureapp;

    /** {@link SongInfo} houses the basic info about each item on the list.
     * Down below you can find the code that is used to contain the name of the song and the name of the artist.
     */
    public class SongInfo {

        // Name of the song.
        private String mSongName;

        // Name of the artist.
        private String mArtist;

        // Drawable for the play button
        private int mPlayButton;

        /** This is a new SongInfo Object containing multiple variables listed below
         * @param songName   is name of the specified song
         * @param artist     is name of the artist
         * @param playButton is name of a button feature to make it look a little more interesting
         */

        // Now watch me as I am about to create a new SongInfo object.
        public SongInfo(String songName, String artist, int playButton) {
            mSongName = songName;
            mArtist = artist;
            mPlayButton = playButton;
        }

        // Miraculously gets the content of the SongName.
        public String getSongName() {
            return mSongName;
        }

        // Magically gets the content of the Artist.
        public String getArtist() {
            return mArtist;
        }

        // Spectacularly gets the image resource of the play button.
        public int getPlayButton(){
            return mPlayButton;
        }
    }