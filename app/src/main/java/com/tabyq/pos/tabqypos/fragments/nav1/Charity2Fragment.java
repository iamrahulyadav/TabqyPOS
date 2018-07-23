package com.tabyq.pos.tabqypos.fragments.nav1;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.tabyq.pos.tabqypos.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Charity2Fragment extends Fragment {
    private SwitchCompat switchCompat;
    private  View includeView;

    public Charity2Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_charity2, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }

    private void init(){
        switchCompat = getView().findViewById(R.id.fragment_online_cv_list_title_switch);
        includeView = getView().findViewById(R.id.fragment_charity_2_time);

        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (switchCompat.isChecked())
                    includeView.setVisibility(View.VISIBLE);
                else includeView.setVisibility(View.GONE);
            }
        });

    }
}
