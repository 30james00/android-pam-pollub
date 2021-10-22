package com.mstolarz.myfrags;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;


public class Fragment1 extends Fragment {
    //1.
    public interface OnButtonClickListener {
        void onButtonClickShuffle();

        void onButtonClickClockwise();

        void onButtonClickHide();

        void onButtonClickRestore();
    }

    //2.
    private OnButtonClickListener callback = null;

    //3.
    public void setOnButtonClickListener(OnButtonClickListener callback) {
        this.callback = callback;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_1, container, false);

        Button buttonShuffle = view.findViewById(R.id.button_shuffle);
        Button buttonClockwise = view.findViewById(R.id.button_clockwise);
        Button buttonHide = view.findViewById(R.id.button_hide);
        Button buttonRestore = view.findViewById(R.id.button_restore);

        buttonShuffle.setOnClickListener(view1 -> {
            if (callback != null) callback.onButtonClickShuffle();
        });

        buttonClockwise.setOnClickListener(view12 -> {
            if (callback != null) callback.onButtonClickClockwise();
        });

        buttonHide.setOnClickListener(view13 -> {
            if (callback != null) callback.onButtonClickHide();
        });

        buttonRestore.setOnClickListener(view14 -> {
            if (callback != null) callback.onButtonClickRestore();
        });

        return view;
    }
}