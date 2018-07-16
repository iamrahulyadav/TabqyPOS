package com.tabyq.pos.tabqypos.fragments.nav2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tabyq.pos.tabqypos.R;
import com.tabyq.pos.tabqypos.activities.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class CloseRegister extends Fragment {


    public CloseRegister() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_close_register, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();

        ((MainActivity)getActivity()).layout_top_middle.setVisibility(View.GONE);
        ((MainActivity) getActivity()).cv_main_right_2.setVisibility(View.GONE);
        ((MainActivity) getActivity()).cv_main_right.setVisibility(View.VISIBLE);

    }
}
