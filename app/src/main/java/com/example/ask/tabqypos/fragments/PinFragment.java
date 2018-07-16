package com.example.ask.tabqypos.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.ask.tabqypos.R;
import com.example.ask.tabqypos.activities.MainActivity;

public class PinFragment extends Fragment {
    private View view;
    private Button btn_okay;
    // TODO: Rename parameter arguments, choose names that match

    // TODO: Rename and change types of parameters


    public PinFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static PinFragment newInstance(String param1, String param2) {
        PinFragment fragment = new PinFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_pin, container, false);
        init(view);
        setListeners();
        return view;
    }

    private void setListeners() {
        btn_okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MainActivity.class));
            }
        });
    }

    private void init(View view) {
        btn_okay = view.findViewById(R.id.btn_okay);
    }


}
