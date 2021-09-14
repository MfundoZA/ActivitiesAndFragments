package com.mfundoza.activitesandfragments;

import android.os.Bundle;

import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.mfundoza.activitesandfragments.R;

public class ListViewActivity extends AppCompatActivity {
    ArrayAdapter adapter;
    ListView listView;
    static String[] items = new String[]{"Apples", "Bananas", "Pears"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
    }

    @Override
    public void onStart() {
        super.onStart();

        listView = findViewById(R.id.listview);
        adapter = new ArrayAdapter(this, R.layout.fragment_listview_item, R.id.textView, items);
        listView.setAdapter(adapter);
    }
}
