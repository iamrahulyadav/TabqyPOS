package com.tabyq.pos.tabqypos.fragments.nav1;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tabyq.pos.tabqypos.R;
import com.tabyq.pos.tabqypos.activities.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class CharityFragment extends Fragment {
    private TextView txt_waste, txt_give, txt_skip;

    public CharityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_charity, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        init();
    }

    private void init(){
        txt_waste = getView().findViewById(R.id.fragment_charity_waste);
        txt_give = getView().findViewById(R.id.fragment_charity_give);
        txt_skip = getView().findViewById(R.id.fragment_charity_skip);

        String text2 = getString(R.string.fragment_charity_watse);

        Spannable spannable = new SpannableString(text2);

        spannable.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorPurple)), 5,
               text2.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        txt_waste.setText(spannable, TextView.BufferType.SPANNABLE);
       // txt_waste.setShadowLayer(3, 0, 5, getResources().getColor(R.color.colorLightGrey));
        String text3 = getString(R.string.fragment_charity_give);

        Spannable spannable1 = new SpannableString(text3);

        spannable1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorRed)), 9,
                16, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        txt_give.setText(spannable1, TextView.BufferType.SPANNABLE);
        //txt_give.setShadowLayer(3, 0, 5, Color.BLACK);

    }

    private void setListener(){
        txt_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();

        ((MainActivity)getActivity()).layout_top_middle.setVisibility(View.GONE);
        ((MainActivity) getActivity()).cv_main_right_2.setVisibility(View.GONE);
        ((MainActivity) getActivity()).cv_main_right.setVisibility(View.VISIBLE);

    }
}
