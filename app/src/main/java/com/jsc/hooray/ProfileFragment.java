package com.jsc.hooray;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class ProfileFragment extends Fragment {

    BottomSheetBehavior bottomSheetBehavior;

    final int MIN_PEEK_HEIGHT = 60;
    final int MAX_PEEK_HEIGHT = 270;
    int current_peek_height;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        View view1 = view.findViewById(R.id.bottomSheet);
        bottomSheetBehavior = bottomSheetBehavior.from(view1);

        current_peek_height = MAX_PEEK_HEIGHT;
        bottomSheetBehavior.setPeekHeight(current_peek_height);
        bottomSheetBehavior.setHideable(true);

        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {


                    case BottomSheetBehavior.STATE_HIDDEN:

                        bottomSheetBehavior.setPeekHeight(MIN_PEEK_HEIGHT);
                        bottomSheetBehavior.setHideable(false);
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED|BottomSheetBehavior.STATE_DRAGGING:

                        bottomSheetBehavior.setPeekHeight(MAX_PEEK_HEIGHT);
                        bottomSheetBehavior.setHideable(true);
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

                bottomSheetBehavior.setPeekHeight(MAX_PEEK_HEIGHT);
                bottomSheetBehavior.setHideable(true);

            }
        });


    }
}