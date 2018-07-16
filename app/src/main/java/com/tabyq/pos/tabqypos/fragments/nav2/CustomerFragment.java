package com.tabyq.pos.tabqypos.fragments.nav2;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tabyq.pos.tabqypos.R;
import com.tabyq.pos.tabqypos.activities.MainActivity;
import com.tabyq.pos.tabqypos.adapter.AdapterCustomer;

/**
 * A simple {@link Fragment} subclass.
 */
public class CustomerFragment extends Fragment {

    public CustomerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_customer, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        init();
    }

    private RecyclerView rv;

    private void init(){
        rv = getView().findViewById(R.id.fragment_customer_recycler);
        LinearLayoutManager manager2
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(manager2);

        AdapterCustomer adapter = new AdapterCustomer(getContext());
        rv.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();

        ((MainActivity)getActivity()).layout_top_middle.setVisibility(View.GONE);
        ((MainActivity) getActivity()).cv_main_right_2.setVisibility(View.GONE);
        ((MainActivity) getActivity()).cv_main_right.setVisibility(View.VISIBLE);

    }
}
