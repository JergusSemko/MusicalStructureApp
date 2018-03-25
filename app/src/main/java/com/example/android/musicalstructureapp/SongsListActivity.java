package com.example.android.musicalstructureapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongsListActivity extends AppCompatActivity implements ListView.OnItemClickListener {

    private String mInfo;
    private String mChosenMood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.songs_layout);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            mInfo = bundle.getString(SafetyPin.INTENT_KEY_NAME);
        }
        // Display list of selected songs based on mood chosen
        selectedMoodMix();
    }

    public void selectedMoodMix() {
        ArrayList<Songs> selectedSong = new ArrayList<>();

        // Probably the funniest part of the whole work on this app. But also the most time consuming.
        if (mInfo.equals(getString(R.string.hard))) {
            mChosenMood = getString(R.string.hard);
            selectedSong.add(new Songs(getString(R.string.killing_strangers), getString(R.string.marilyn), getString(R.string.manson), R.drawable.g_note));
            selectedSong.add(new Songs(getString(R.string.wake_me_up), getString(R.string.evanescence), getString(R.string.blank), R.drawable.g_note));
            selectedSong.add(new Songs(getString(R.string.numb), getString(R.string.lin_kin_park), getString(R.string.blank), R.drawable.g_note));
            selectedSong.add(new Songs(getString(R.string.twisted_transistor), getString(R.string.korn), getString(R.string.blank), R.drawable.g_note));
            selectedSong.add(new Songs(getString(R.string.chop_suy), getString(R.string.system_of_a_down), getString(R.string.blank), R.drawable.g_note));
        }

        if (mInfo.equals(getString(R.string.acoustic))) {
            mChosenMood = getString(R.string.acoustic);
            selectedSong.add(new Songs(getString(R.string.priscillas_song), getString(R.string.malukah), getString(R.string.blank), R.drawable.g_note));
            selectedSong.add(new Songs(getString(R.string.kiss), getString(R.string.korn), getString(R.string.blank), R.drawable.g_note));
            selectedSong.add(new Songs(getString(R.string.gangsta), getString(R.string.kehlani), getString(R.string.blank), R.drawable.g_note));
        }

        if (mInfo.equals(getString(R.string.mainstream))) {
            mChosenMood = getString(R.string.mainstream);
            selectedSong.add(new Songs(getString(R.string.believer), getString(R.string.imagine), getString(R.string.dragons), R.drawable.g_note));
            selectedSong.add(new Songs(getString(R.string.tuesday), getString(R.string.burak), getString(R.string.yeter), R.drawable.g_note));
            selectedSong.add(new Songs(getString(R.string.feel_it_still), getString(R.string.portugal), getString(R.string.the_man), R.drawable.g_note));
            selectedSong.add(new Songs(getString(R.string.shape_of_you), getString(R.string.ed), getString(R.string.sheeran), R.drawable.g_note));
            selectedSong.add(new Songs(getString(R.string.heathens), getString(R.string.twenty_one), getString(R.string.pilots), R.drawable.g_note));
            selectedSong.add(new Songs(getString(R.string.seven_nation_army), getString(R.string.the), getString(R.string.white_stripes), R.drawable.g_note));
            selectedSong.add(new Songs(getString(R.string.human), getString(R.string.rag_n_bone), getString(R.string.blank), R.drawable.g_note));

        }

        // Create a {@link SongsAdapter}.
        SongsAdapter songToListenTo = new SongsAdapter(this, selectedSong);
        ListView listView = findViewById(R.id.songsLayout);

        // Used assert here instead of IF condition to trim some lines of code.
        assert listView != null;
        listView.setAdapter(songToListenTo);

        // Header needs to be inflated just like list view.
        ViewGroup headerView = (ViewGroup) getLayoutInflater().inflate(R.layout.header, listView, false);
        TextView headerTextView = headerView.findViewById(R.id.header_content);

        String headerPlaylist = getString(R.string.songer) + " " + mChosenMood;

        headerTextView.setText(headerPlaylist);
        listView.addHeaderView(headerView);
        listView.setOnItemClickListener(this);
    }

    // This method wraps up the selection from the list view and sends it to the next activity.
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        final Context context = this;
        String intentExtra;

        // Artist name and song is first merged and then sent on it's way to another activity.
        TextView songSelected = view.findViewById(R.id.song);
        String songToListenTo = songSelected.getText().toString();

        TextView artistSelected = view.findViewById(R.id.artist);
        String artistToListenTo = artistSelected.getText().toString();

        intentExtra = artistToListenTo + "|" + songToListenTo;
        Intent intent = new Intent(context, NowPlayingActivity.class);
        intent.putExtra("message", intentExtra);
        startActivity(intent);
    }
}
