package com.tabyq.pos.tabqypos.fragments.nav2;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tabyq.pos.tabqypos.R;
import com.tabyq.pos.tabqypos.activities.MainActivity;
import com.tabyq.pos.tabqypos.adapter.AdapterSettings;
import com.tabyq.pos.tabqypos.fragments.Sub.AddPrintersFragment;
import com.tabyq.pos.tabqypos.utils.SupportingWidgets;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends Fragment implements View.OnClickListener {

    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        init();
    }

    private RecyclerView rv;
    private TextView tv;
    private LinearLayout layout_plus;

    private void init(){
        rv = getView().findViewById(R.id.fragment_settings_recycler);
        LinearLayoutManager manager2
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(manager2);

        AdapterSettings adapter = new AdapterSettings();
        rv.setAdapter(adapter);

        tv = getView().findViewById(R.id.fragment_settings_tv_exit);
        tv.setOnClickListener(this);

        layout_plus = getView().findViewById(R.id.fragment_settings_layout_plus);
        layout_plus.setOnClickListener(this);
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
        if(id == R.id.fragment_settings_tv_exit){
            getActivity().getSupportFragmentManager().popBackStackImmediate();
        } else if(id == R.id.fragment_settings_layout_plus){

            new SupportingWidgets().callFragment(getActivity(), new AddPrintersFragment(), getFragmentManager()
                    , R.id.frame_main_bottom, AddPrintersFragment.class.getName());
        }
    }
}
