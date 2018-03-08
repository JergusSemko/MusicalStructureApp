package com.example.android.musicalstructureapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<SongInfo> info = new ArrayList<>();

        info.add(new SongInfo(getString(R.string.killing_strangers), getString(R.string.marilyn_manson), R.drawable.play_button));
        info.add(new SongInfo(getString(R.string.feel_it_still), getString(R.string.portugal_the_man), R.drawable.play_button));
        info.add(new SongInfo(getString(R.string.shape_of_you), getString(R.string.ed_sheeran), R.drawable.play_button));
        info.add(new SongInfo(getString(R.string.human), getString(R.string.rag_n_bone), R.drawable.play_button));
        info.add(new SongInfo(getString(R.string.black_betty), getString(R.string.caravan_palace), R.drawable.play_button));
        info.add(new SongInfo(getString(R.string.omen_reprise), getString(R.string.the_prodigy), R.drawable.play_button));
        info.add(new SongInfo(getString(R.string.prime_time_of_your_life), getString(R.string.daft_punk), R.drawable.play_button));
        info.add(new SongInfo(getString(R.string.levitate), getString(R.string.hadouken), R.drawable.play_button));
        info.add(new SongInfo(getString(R.string.broken_vows), getString(R.string.michael_stearns), R.drawable.play_button));
        info.add(new SongInfo(getString(R.string.send_me_on_my_way), getString(R.string.not_too_sharp), R.drawable.play_button));
        info.add(new SongInfo(getString(R.string.take_it_all), getString(R.string.ruelle), R.drawable.play_button));
        info.add(new SongInfo(getString(R.string.believer), getString(R.string.imagine_dragons), R.drawable.play_button));

        // Create an {@link SongListAdapter}, with data source of {@link info}s.
        SongListAdapter songListAdapter = new SongListAdapter(this, info);

        // Find the {@link ListView} object in the activity_main.xml.
        ListView listView = findViewById(R.id.list);

        // Make the {@link ListView} will display list items for each {@link Category} in the list.
        // Used assert to save space and trim some lines.
        assert listView != null;
        listView.setAdapter(songListAdapter);

        // ListView setOnItemClickListener function is applied.
        listView.setOnItemClickListener(this);
    }

    // This method identifies ListView item clicked.
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        final Context context = this;
        String currentIntent;

        // Send the chosen song with all the info to activity_song_card.
        TextView chosenArtist = view.findViewById(R.id.artist_name);
        String currentArtist = chosenArtist.getText().toString();

        TextView chosenSong = view.findViewById(R.id.song_name);
        String currentSong = chosenSong.getText().toString();

        currentIntent = currentSong + currentArtist;
        Intent intent = new Intent(context, SongCard.class);
        intent.putExtra("chosen", currentIntent);
        startActivity(intent);
    }
}