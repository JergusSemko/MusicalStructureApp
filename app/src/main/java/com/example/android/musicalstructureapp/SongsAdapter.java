package com.example.android.musicalstructureapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class SongsAdapter extends ArrayAdapter<Songs> {

    // Custom constructor used to inflate the layout file.
    public SongsAdapter(Activity context, ArrayList<Songs> songs) {
        super(context, 0, songs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.songs_list, parent, false);
        }

        Songs chosenSong = getItem(position);
        TextView songPlaceHolder = listItemView.findViewById(R.id.song);
        // Used assert instead of IF to trim the code a bit.
        assert chosenSong != null;
        songPlaceHolder.setText(chosenSong.getSongName());

        // Merge both artists names together.
        TextView chosenArtist = listItemView.findViewById(R.id.artist);
        String firstName = chosenSong.getFirstName();
        String secondName = chosenSong.getSecondName();

        String ArtistsName = firstName + " " + secondName;
        chosenArtist.setText(ArtistsName);

        //Find ImageView in the songs_list.xml layout with the ID version_name
        ImageView artistPic = listItemView.findViewById(R.id.note);

        // The goal of this fragment of code is to check if there is an image provided.
        if (chosenSong.hasImage()) {
            artistPic.setImageResource(chosenSong.getImageResourceId());
            artistPic.setVisibility(View.VISIBLE);
        } else {
            artistPic.setVisibility(View.GONE);
        }
        return listItemView;
    }
}
