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

public class MoodList extends AppCompatActivity implements ListView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mood_layout);

        // Create an array of categories
        final ArrayList<Mood> category = new ArrayList<>();

        category.add(new Mood(getString(R.string.hard), R.drawable.g_note));
        category.add(new Mood(getString(R.string.acoustic), R.drawable.g_note));
        category.add(new Mood(getString(R.string.mainstream), R.drawable.g_note));

        // Create an {@link MoodAdapter}, whose data source is a list of {@link mood}s.
        MoodAdapter moodAdapter = new MoodAdapter(this, category);

        ListView listView = findViewById(R.id.moodList);

        // {@link ListView} displays list of items in the list.
        assert listView != null;
        listView.setAdapter(moodAdapter);

        // Inflate header and add it to the list view.
        ViewGroup headerView = (ViewGroup) getLayoutInflater().inflate(R.layout.header, listView, false);
        TextView textHeader = headerView.findViewById(R.id.header_content);
        textHeader.setText(getString(R.string.mooder));

        listView.addHeaderView(headerView);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        final Context context = this;

        // Item clicked in the list view will be launched.

        TextView textView = view.findViewById(R.id.mood);
        String selectedMood = textView.getText().toString();

        Intent intent = new Intent(context, SongsList.class);
        intent.putExtra("message", selectedMood);
        startActivity(intent);
    }
}



