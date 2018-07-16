package com.example.ask.tabqypos.fragments.Sub;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ask.tabqypos.R;
import com.example.ask.tabqypos.activities.MainActivity;


/**
 * created by rakhi 07/27/2018
 */
public class AddUserFragment extends Fragment {
    private TextView txt_customer, txt_add, txt_add_note,txt_add_discount;
    private View view;

    public AddUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_add_user, container, false);

        init(view);
        return view;

    }

    private void init(View view){
        txt_customer = view.findViewById(R.id.text_customer);
        txt_add = view.findViewById(R.id.img_adduser);
//        txt_add_note = view.findViewById(R.id.add_note);
//        txt_add_discount = view.findViewById(R.id.add_discount);

//        txt_add_note.setVisibility(View.GONE);
//        txt_add_discount.setVisibility(View.GONE);
//        txt_customer.setVisibility(View.GONE);
    }

    @Override
    public void onResume() {
        super.onResume();

        ((MainActivity)getActivity()).cv_main_right.setVisibility(View.VISIBLE);
        ((MainActivity)getActivity()).layout_top_middle.setVisibility(View.GONE);

        ((MainActivity) getActivity()).cv_main_right_2.setVisibility(View.GONE);
    }
}
