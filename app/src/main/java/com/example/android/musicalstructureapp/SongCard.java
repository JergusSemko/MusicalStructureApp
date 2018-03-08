package com.example.android.musicalstructureapp;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import static android.media.AudioManager.STREAM_MUSIC;

public class SongCard extends AppCompatActivity implements View.OnClickListener {

    // Global variables parked here.
    private AudioManager audioManager = null;
    private ImageButton mButtonMain;
    private ImageButton mPlay;
    private ImageButton mStop;
    private ImageButton mPause;
    private String mCurrentSong;
    private String mCurrentArtist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_card);
        setVolumeControlStream(STREAM_MUSIC);
        mPlay = findViewById(R.id.playing_button);
        mPause = findViewById(R.id.pause_button);
        mStop = findViewById(R.id.stop_button);
        mButtonMain = findViewById((R.id.buttonMain));
        String[] intentCurrentArray;

        // Set OnClickListeners on everything that is possibly clickable.
        mPlay.setOnClickListener(this);
        mStop.setOnClickListener(this);
        mPause.setOnClickListener(this);
        mButtonMain.setOnClickListener(this);

        // Get info from MainActivity list of songs.
        Bundle group = getIntent().getExtras();

        String mIntentInfo = null;
        if (group != null) {
            mIntentInfo = group.getString(Util.INTENT_KEY_NAME);
        }

        // Separates intent info into song name and artist.
        assert mIntentInfo != null;
        intentCurrentArray = mIntentInfo.split("\\|");
        mCurrentSong = intentCurrentArray[0];
        mCurrentArtist = intentCurrentArray[1];

        // This listener activates upon clicking on Main ImageButton.
        mButtonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (SongCard.this, MainActivity.class);
                startActivity(i);
            }
        });
        playingNow();
        volumeControl();
    }

    private class Util{
        private static final String INTENT_KEY_NAME = "chosen";
        private Util(){
        }
    }

    public void playingNow() {
        // Identify song name and artist.
        TextView songName = findViewById(R.id.song_name);
        TextView artist = findViewById(R.id.artist_name);

        // Display artist name and song name.
        songName.setText(mCurrentSong);
        artist.setText(mCurrentArtist);
    }

    // This method reveals my play/pause/stop joke.
    @Override
    public void onClick(View v) {

        if (v.equals(mPlay)) {
            Toast.makeText(this, R.string.bamboozeled, Toast.LENGTH_SHORT).show();
        }
        if (v.equals(mPause)) {
            Toast.makeText(this, R.string.bamboozeled, Toast.LENGTH_SHORT).show();
        }

        if (v.equals(mStop)) {
            Toast.makeText(this, R.string.bamboozeled, Toast.LENGTH_SHORT).show();

        }
    }

    // And finally, the volume control SeekBar. The internet helped a lot.
    private void volumeControl() {
        try {
            SeekBar volume = findViewById(R.id.seekBar);
            audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
            assert audioManager != null;
            volume.setMax(audioManager.getStreamMaxVolume(STREAM_MUSIC));
            volume.setProgress(audioManager.getStreamVolume(STREAM_MUSIC));

            volume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int position, boolean detected) {
                    audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, position, 0);
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}