package com.example.android.musicalstructureapp;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import static android.media.AudioManager.STREAM_MUSIC;

public class NowPlaying extends AppCompatActivity implements View.OnClickListener {

    // Initializing global variables.
    private AudioManager audioManager = null;
    private ImageButton mPlay;
    private ImageButton mStop;
    private ImageButton mPause;
    private String currentArtist;
    private String currentSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.now_playing);
        setVolumeControlStream(STREAM_MUSIC);
        mPlay = findViewById(R.id.play);
        mPause = findViewById(R.id.pause);
        mStop = findViewById(R.id.stop);
        ImageButton backToMenu = findViewById((R.id.menuButton));

        // Set OnClickListeners on clickable items
        mPlay.setOnClickListener(this);
        mStop.setOnClickListener(this);
        mPause.setOnClickListener(this);

        // Gets info from the Song List.
        Bundle bundle = getIntent().getExtras();
        String mFinalIntent = null;
        if (bundle != null) {
            mFinalIntent = bundle.getString(SafetyPin.INTENT_KEY_NAME);
        }

        // Splits the message into artist name and song.
        String[] finalMessage;
        assert mFinalIntent != null;
        finalMessage = mFinalIntent.split("\\|");
        currentArtist = finalMessage[0];
        currentSong = finalMessage[1];

        // Button to get us where it all started.
        backToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backToCategory = new Intent(NowPlaying.this, MoodList.class);
                NowPlaying.this.startActivity(backToCategory);
            }
        });
        playingNow();
        volumeControl();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Navigates back to the previous activity.
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void playingNow() {
        // Fetch the whole content of the chosen song.
        TextView selectedSong = findViewById(R.id.song);
        TextView selectedArtist = findViewById(R.id.artist);
        //display artist name and song
        selectedSong.setText(currentSong);
        selectedArtist.setText(currentArtist);
    }

    // Added a small joke to this method.
    @Override
    public void onClick(View v) {
        if (v.equals(mPlay)) {
            Toast.makeText(this, getString(R.string.bamboozled), Toast.LENGTH_SHORT).show();
        }
        if (v.equals(mPause)) {
            Toast.makeText(this, getString(R.string.bamboozled), Toast.LENGTH_SHORT).show();
        }
        if (v.equals(mStop)) {
            Toast.makeText(this, getString(R.string.bamboozled), Toast.LENGTH_SHORT).show();
        }
    }

    // Seemed like a useful thing to add volume control bar to the now playing activity.
    private void volumeControl() {
        try {
            SeekBar volumeMusicSeekBar = findViewById(R.id.seekBar);
            audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
            assert audioManager != null;
            volumeMusicSeekBar.setMax(audioManager.getStreamMaxVolume(STREAM_MUSIC));
            volumeMusicSeekBar.setProgress(audioManager.getStreamVolume(STREAM_MUSIC));

            volumeMusicSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
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