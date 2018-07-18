package com.tabyq.pos.tabqypos.fragments.Sub;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tabyq.pos.tabqypos.R;
import com.tabyq.pos.tabqypos.activities.MainActivity;
import com.tabyq.pos.tabqypos.utils.SupportingWidgets;

/**
 * A simple {@link Fragment} subclass.
 */
public class SingleReceiptFragment extends Fragment implements View.OnClickListener{
    private TextView txt_refund;

    public SingleReceiptFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_single_receipt, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
        setListener();
    }

    private void init(){
        txt_refund = getView().findViewById(R.id.fragment_single_refund);
    }

    private void setListener(){
        txt_refund.setOnClickListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();

        ((MainActivity)getActivity()).layout_top_middle.setVisibility(View.GONE);
        ((MainActivity) getActivity()).cv_main_right_2.setVisibility(View.GONE);
        ((MainActivity) getActivity()).cv_main_right.setVisibility(View.VISIBLE);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fragment_single_refund:
                new SupportingWidgets().callFragment(getActivity(), new RefundFragment(),
                        getFragmentManager(),
                        R.id.frame_main_bottom, RefundFragment.class.getName());
                break;
        }
    }
}
