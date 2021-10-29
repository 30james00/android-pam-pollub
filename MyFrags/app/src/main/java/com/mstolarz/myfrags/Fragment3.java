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

public class Fragment3 extends Fragment {

    private TextView text;
    private Button button;
    private FragsData fragsData;
    private Observer<Integer> numberObserver;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_3, container, false);
        text = (TextView) view.findViewById(R.id.current);
        button = (Button) view.findViewById(R.id.button_decrease);
        fragsData = new ViewModelProvider(requireActivity()).get(FragsData.class);
        numberObserver = new Observer<Integer>() {
            @Override
            public void onChanged(Integer newInteger) {
                text.setText(newInteger.toString());
            }
        };
        fragsData.counter.observe(getViewLifecycleOwner(), numberObserver);
        button.setOnClickListener(view1 -> {
            Integer i = fragsData.counter.getValue();
            fragsData.counter.setValue(--i);
        }
        );
        return view;
    }
}