package com.mstolarz.myfrags;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Fragment2 extends Fragment {

    private FragsData fragsData;
    private Observer<Integer> numberObserver;

    private TextView text;
    private Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_2, container, false);

        //1.
        text = view.findViewById(R.id.current);
        button = view.findViewById(R.id.button_increase);

        //2.
        fragsData = new ViewModelProvider(requireActivity()).get(FragsData.class);

        //3.
        numberObserver = newInteger -> text.setText(String.valueOf(newInteger));

        //4.
        fragsData.counter.observe(getViewLifecycleOwner(), numberObserver);

        //5.
        button.setOnClickListener(view1 -> {

                    Integer i = fragsData.counter.getValue();
                    fragsData.counter.setValue(++i);
                }
        );

        return view;
    }
}