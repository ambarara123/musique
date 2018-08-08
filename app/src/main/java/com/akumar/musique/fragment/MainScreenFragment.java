package com.akumar.musique.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.DragEvent;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.musique.R;
import com.github.pwittchen.swipe.library.rx2.Swipe;
import com.github.pwittchen.swipe.library.rx2.SwipeListener;
import com.gjiazhe.multichoicescirclebutton.MultiChoicesCircleButton;

import java.util.ArrayList;
import java.util.List;

import co.mobiwise.library.MusicPlayerView;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainScreenFragment extends Fragment implements SwipeListener{
    MultiChoicesCircleButton multiChoicesCircleButton;
    MusicPlayerView musicPlayerView;
    String DEBUG_TAG = MainScreenFragment.class.getSimpleName();
    Swipe swipe;
    Disposable disposable;


    public MainScreenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main_screen, container, false);
        // Set the gesture detector as the double tap
        // listener.
        multiChoicesCircleButton =  view.findViewById(R.id.multiChoicesCircleButton);
        musicPlayerView = view.findViewById(R.id.mpv);
        swipe = new Swipe();
        swipe.setListener(this);

        multiChoiseButton();
        MusicPlayerViewSetup();


        return view;
    }

    public void multiChoiseButton(){

        final MultiChoicesCircleButton.Item item1 = new MultiChoicesCircleButton.Item("Like", getResources().getDrawable(R.drawable.ic_launcher_background), 30);

        MultiChoicesCircleButton.Item item2 = new MultiChoicesCircleButton.Item("Message", getResources().getDrawable(R.drawable.ic_launcher_background), 90);

        MultiChoicesCircleButton.Item item3 = new MultiChoicesCircleButton.Item("Tag", getResources().getDrawable(R.drawable.ic_launcher_background), 150);

        List<MultiChoicesCircleButton.Item> buttonItems = new ArrayList<>();
        buttonItems.add(item1);
        buttonItems.add(item2);
        buttonItems.add(item3);

        multiChoicesCircleButton.setButtonItems(buttonItems);
        multiChoicesCircleButton.setOnSelectedItemListener(new MultiChoicesCircleButton.OnSelectedItemListener() {
            @Override
            public void onSelected(MultiChoicesCircleButton.Item item, int index) {
                switch (index){
                    case 0:
                        Toast.makeText(getContext(), item1.getText(), Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });


    }
    //setting up music playerview button
    public void MusicPlayerViewSetup(){
        musicPlayerView.setButtonColor(Color.TRANSPARENT);
        musicPlayerView.setCoverDrawable(R.color.colorPrimary);
        musicPlayerView.setProgressEmptyColor(Color.GRAY);
        musicPlayerView.setProgressLoadedColor(Color.BLUE);
        musicPlayerView.setTimeColor(Color.WHITE);
        musicPlayerView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getContext(), "Long click", Toast.LENGTH_SHORT).show();

                return false;
            }
        });


        musicPlayerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (musicPlayerView.isRotating()) {
                    musicPlayerView.stop();

                }else {
                    musicPlayerView.start();

                }
            }
        });
    }

    @Override
    public void onSwipingLeft(MotionEvent event) {
        Toast.makeText(getContext(), "Left swipe", Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onSwipedLeft(MotionEvent event) {
        return true;
    }

    @Override
    public void onSwipingRight(MotionEvent event) {
        Toast.makeText(getContext(), "Right swipe", Toast.LENGTH_SHORT).show();


    }

    @Override
    public boolean onSwipedRight(MotionEvent event) {
        return true;
    }

    @Override
    public void onSwipingUp(MotionEvent event) {

    }

    @Override
    public boolean onSwipedUp(MotionEvent event) {
        return false;
    }

    @Override
    public void onSwipingDown(MotionEvent event) {

    }

    @Override
    public boolean onSwipedDown(MotionEvent event) {
        return false;
    }


}
