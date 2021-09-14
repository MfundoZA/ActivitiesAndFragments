package com.mfundoza.activitesandfragments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FragmentsActivity extends AppCompatActivity {
    FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments);

        Button buttonFirstFragment = findViewById(R.id.button_first_fragment);
        Button buttonSecondFragment = findViewById(R.id.button_second_fragment);

        FirstFragment firstFragment = new FirstFragment();
        SecondFragment secondFragment = new SecondFragment();

        fragmentManager.beginTransaction()
                .replace(R.id.framelayout_fragment, firstFragment, null)
                .setReorderingAllowed(true)
                .addToBackStack("first") // name can be null
                .commit();

        buttonFirstFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction()
                        .replace(R.id.framelayout_fragment, firstFragment)
                        .setReorderingAllowed(true)
                        .addToBackStack("first") // name can be null
                        .commit();

                buttonSecondFragment.setEnabled(true);
                buttonFirstFragment.setEnabled(false);
            }
        });

        buttonSecondFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction()
                        .replace(R.id.framelayout_fragment, secondFragment)
                        .setReorderingAllowed(true)
                        .addToBackStack("second") // name can be null
                        .commit();

                buttonSecondFragment.setEnabled(false);
                buttonFirstFragment.setEnabled(true);
            }
        });

        if (savedInstanceState != null) {

        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}