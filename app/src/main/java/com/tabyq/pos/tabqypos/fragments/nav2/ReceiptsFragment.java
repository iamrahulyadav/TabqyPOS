package com.tabyq.pos.tabqypos.fragments.nav2;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.tabyq.pos.tabqypos.R;
import com.tabyq.pos.tabqypos.activities.MainActivity;
import com.tabyq.pos.tabqypos.fragments.Sub.SingleReceiptFragment;
import com.tabyq.pos.tabqypos.utils.SupportingWidgets;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReceiptsFragment extends Fragment implements View.OnClickListener {

    public ReceiptsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_receipts, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        init();
    }

    private RelativeLayout layout_search_1, layout_search_2;
    private RelativeLayout layout_receipt;

    private void init(){
        layout_search_1 = getView().findViewById(R.id.fragment_receipts_search_icon_1);
        layout_search_2 = getView().findViewById(R.id.fragment_receipts_search_icon_2);
        layout_search_1.setOnClickListener(this);

        layout_receipt = getView().findViewById(R.id.fragment_receipts_layout_receipt);
        layout_receipt.setOnClickListener(this);
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

        int id = v.getId();

        if(id == R.id.fragment_receipts_search_icon_1){
            layout_search_1.setVisibility(View.GONE);
            layout_search_2.setVisibility(View.VISIBLE);
        } else if(id == R.id.fragment_receipts_layout_receipt){
            new SupportingWidgets().callFragment(getActivity(), new SingleReceiptFragment(),
                            getFragmentManager(),
                    R.id.frame_main_bottom, SingleReceiptFragment.class.getName());
        }
    }
}
