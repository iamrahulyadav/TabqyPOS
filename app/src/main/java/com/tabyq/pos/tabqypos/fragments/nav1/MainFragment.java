package com.tabyq.pos.tabqypos.fragments.nav1;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tabyq.pos.tabqypos.R;
import com.tabyq.pos.tabqypos.activities.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements View.OnClickListener {

        public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        init();
    }

    private TextView btn_new_order;
    private void init(){

        btn_new_order = getView().findViewById(R.id.main_btn_new_order);
        btn_new_order.setOnClickListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();

        ((MainActivity)getActivity()).cv_main_right.setVisibility(View.VISIBLE);
        ((MainActivity)getActivity()).layout_top_middle.setVisibility(View.GONE);
        ((MainActivity) getActivity()).cv_main_right_2.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.main_btn_new_order){
            ((MainActivity)getActivity()).dashboardLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            ((MainActivity)getActivity()).walkin_layoutLayout.setBackgroundColor(getResources().getColor(R.color.colorDark));

            WalkinFragment fragment = new WalkinFragment();
            Bundle bundle = new Bundle();
            bundle.putString("nav_name", "Walkin");
            fragment.setArguments(bundle);
            getFragmentManager().beginTransaction().replace(R.id.frame_main_bottom, fragment).commit();
        }
    }
}