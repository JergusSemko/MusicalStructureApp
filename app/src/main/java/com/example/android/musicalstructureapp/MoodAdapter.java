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

/**
 * Created by Bobeš on 02-Mar-18.
 */

public class MoodAdapter extends ArrayAdapter<Mood> {

    public MoodAdapter(Activity context, ArrayList<Mood> category) {
        super(context, 0, category);
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.mood_list, parent, false);
        }

        // Get the {@link Mood} object located at this position in the list
        Mood currentCategory = getItem(position);

        // Find the TextView in the category_list.xml layout with the ID mood
        TextView categoryTextView = (TextView) listItemView.findViewById(R.id.mood);
        // Get the mood from the current object and
        // set this text on the name TextView
        assert currentCategory != null;
        categoryTextView.setText(currentCategory.getChosenMood());


        //Find ImageView in the category_list.xml layout with the ID version_name
        ImageView imageComposer = (ImageView) listItemView.findViewById(R.id.note);

        // Check if an image is provided for this mood or not
        if (currentCategory.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageComposer.setImageResource(currentCategory.getImg());
            // Make sure the view is visible
            imageComposer.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageComposer.setVisibility(View.GONE);
        }

        // Return the whole list item layout (containing ! TextView and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}

