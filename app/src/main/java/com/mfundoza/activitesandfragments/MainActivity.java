package com.mfundoza.activitesandfragments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
/*
*  This Activity is used to demonstrate the following:
*       - The general structure of how variables and Views are
*       declared, initialized and referenced
*
*       - How to preserve variables and restore their values in case of
*       configuration changes or system processes
* */
public class MainActivity extends AppCompatActivity {
    private TextView mTextViewCount;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewCount = findViewById(R.id.text_view_count);
        Button buttonDecrement = findViewById(R.id.button_decrement);
        Button buttonIncrement = findViewById(R.id.button_increment);
        Button buttonFragmentsActivity = findViewById(R.id.button_fragments_activity);
        Button buttonListView = findViewById(R.id.button_listview);

        buttonDecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrement();
            }
        });

        buttonIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increment();
            }
        });

        buttonFragmentsActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragmentsActivity();
            }
        });

        buttonListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListViewActivity();
            }
        });

        if (savedInstanceState != null) {
            count = savedInstanceState.getInt("count");
            mTextViewCount.setText(String.valueOf(count));
        }
    }

    private void decrement() {
        count--;
        mTextViewCount.setText(String.valueOf(count));
    }

    private void increment() {
        count++;
        mTextViewCount.setText(String.valueOf(count));
    }

    private void openFragmentsActivity() {
        Intent intent = new Intent(this, FragmentsActivity.class);
        startActivity(intent);
    }

    private void openListViewActivity() {
        Intent intent = new Intent(this, ListViewActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count", count);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            // This is were custom code goes. e.g Opening settings activity or changing theme
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);

            // Tells Android that the item click has been handled.
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}