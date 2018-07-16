package com.tabyq.pos.tabqypos.fragments.nav1;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tabyq.pos.tabqypos.R;
import com.tabyq.pos.tabqypos.adapter.AdapterOrderStatus;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderStatusFragment extends Fragment {


    public OrderStatusFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order_status, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        init();
    }

    private RecyclerView rv1, rv2, rv3;

    private void init(){
        rv1 = getView().findViewById(R.id.order_status_recycler_1);
        rv2 = getView().findViewById(R.id.order_status_recycler_2);
        rv3 = getView().findViewById(R.id.order_status_recycler_3);

        LinearLayoutManager verticalLayoutmanager1
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rv1.setLayoutManager(verticalLayoutmanager1);
        LinearLayoutManager verticalLayoutmanager2
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rv2.setLayoutManager(verticalLayoutmanager2);
        LinearLayoutManager verticalLayoutmanager3
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rv3.setLayoutManager(verticalLayoutmanager3);

        AdapterOrderStatus adapter1 = new AdapterOrderStatus(3, 1);
        rv1.setAdapter(adapter1);
        AdapterOrderStatus adapter2 = new AdapterOrderStatus(2, 2);
        rv2.setAdapter(adapter2);
        AdapterOrderStatus adapter3 = new AdapterOrderStatus(1, 3);
        rv3.setAdapter(adapter3);



    }
}
