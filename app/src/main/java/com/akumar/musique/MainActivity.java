package com.akumar.musique;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.akumar.musique.fragment.MainScreenFragment;
import com.android.musique.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.detail_fragment, new MainScreenFragment(), "main_screen")
                .commit();



    }
}
