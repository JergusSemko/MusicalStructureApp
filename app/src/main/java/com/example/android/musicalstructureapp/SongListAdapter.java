package com.example.android.musicalstructureapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongListAdapter extends ArrayAdapter<SongInfo> {

    private Context mContext;

    /**
     * Custom created constructor. The context is used to inflate the layout file,
     * and the list is the data used to populate the list.
     * @param context The current context. Used to inflate the layout file.
     * @param info A List of the contents like artist and song name.
     */

    public SongListAdapter(Activity context, ArrayList<SongInfo> info){
        super(context, 0, info);
        mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the object at current position in the list.
        SongInfo currentSong = getItem(position);
        // Used assert instead of adding an IF condition everywhere to make the code a bit thinner
        assert currentSong != null;

        // Find the specified TextView.
        TextView songTextView = listItemView.findViewById(R.id.song_name);
        // Get the specified song name from the current object and
        // set this text on the name TextView
        songTextView.setText(currentSong.getSongName());

        // Find the specified TextView.
        TextView artistTextView = listItemView.findViewById(R.id.artist);
        // Get the specified artist from the current object and
        // set this text on the name TextView
        artistTextView.setText(currentSong.getArtist());

        // Find the ImageView, get and set the image.
        ImageView playButton = listItemView.findViewById(R.id.list_play_button);
        playButton.setImageResource(currentSong.getPlayButton());

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, MainActivity.class));
            }
        });

        return listItemView;
    }
}