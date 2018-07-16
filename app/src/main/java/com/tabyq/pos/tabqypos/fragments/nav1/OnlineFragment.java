package com.tabyq.pos.tabqypos.fragments.nav1;


import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tabyq.pos.tabqypos.R;
import com.tabyq.pos.tabqypos.activities.MainActivity;
import com.tabyq.pos.tabqypos.adapter.AdapterOnlineDelivery;
import com.tabyq.pos.tabqypos.adapter.AdapterOnlineNewOrders;
import com.tabyq.pos.tabqypos.adapter.AdapterOnlineTop;
import com.tabyq.pos.tabqypos.utils.CustomLayoutManager;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class OnlineFragment extends Fragment implements View.OnClickListener, AdapterOnlineTop.Interface_AdapterOnlineTop,
AdapterOnlineNewOrders.AdapterOnlineNewOrderInterface{


    public OnlineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_online, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();

        ((MainActivity)getActivity()).cv_main_right.setVisibility(View.VISIBLE);
        ((MainActivity)getActivity()).layout_top_middle.setVisibility(View.GONE);

        ((MainActivity) getActivity()).cv_main_right_2.setVisibility(View.GONE);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        init();
    }

    private LinearLayout status_layout_first, status_layout_two, status_layout_three, status_layout_four,
    layout_select_driver, layout_delivery;
    private RecyclerView rv_top, rv_new_order, rv_delivery;
    private String status_rv_new_orders;
    private AdapterOnlineNewOrders adapterOnlineNewOrders;

    private CardView cv_list_title;
    private TextView tv_deliver_to, tv_driver, tv_order_taken_at;
    private SwitchCompat switchCompat;

    private AdapterOnlineTop adapterOnlineTop;
    private ArrayList<String> arr_top_names = new ArrayList<>();
    private ArrayList<String> arr_top_click_status = new ArrayList<>();
    private LinearLayout layout_top_left;

    private void init(){
        layout_top_left = getView().findViewById(R.id.fragment_online_top_layout_left);
        layout_top_left.setOnClickListener(this);

        layout_delivery = getView().findViewById(R.id.fragment_online_layout_delivery);

        cv_list_title = getView().findViewById(R.id.fragment_online_cv_list_title);
        tv_deliver_to = getView().findViewById(R.id.fragment_online_cv_list_title_deliver_to);
        tv_order_taken_at = getView().findViewById(R.id.fragment_online_cv_list_title_order_taken_at);
        tv_driver = getView().findViewById(R.id.fragment_online_cv_list_title_driver);
        switchCompat = getView().findViewById(R.id.fragment_online_cv_list_title_switch);

        layout_select_driver = getView().findViewById(R.id.fragment_online_layout_select_driver);
        status_layout_first = getView().findViewById(R.id.fragment_online_online_status_one);
        status_layout_two = getView().findViewById(R.id.fragment_online_online_status_two);
        status_layout_three = getView().findViewById(R.id.fragment_online_online_status_three);
        status_layout_four = getView().findViewById(R.id.fragment_online_online_status_four);
//        nav_menu = (RelativeLayout) getView().findViewById(R.id.nav_menu);

        status_layout_first.setOnClickListener(this);
        status_layout_two.setOnClickListener(this);
        status_layout_three.setOnClickListener(this);
//        nav_menu.setOnClickListener(this);
        status_layout_four.setOnClickListener(this);
        layout_select_driver.setOnClickListener(this);
        status_rv_new_orders = "new_orders";

        rv_new_order = getView().findViewById(R.id.fragment_online_recycler_new_order);

        CustomLayoutManager manager = new CustomLayoutManager(getContext()){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };

        rv_new_order.setLayoutManager(manager);

        adapterOnlineNewOrders = new AdapterOnlineNewOrders(status_rv_new_orders, this);
        rv_new_order.setAdapter(adapterOnlineNewOrders);

        rv_delivery = getView().findViewById(R.id.fragment_online_delivery_recycler);

        CustomLayoutManager manager1 = new CustomLayoutManager(getContext()){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };

        rv_delivery.setLayoutManager(manager1);

        AdapterOnlineDelivery adapterOnlineDelivery = new AdapterOnlineDelivery();
        rv_delivery.setAdapter(adapterOnlineDelivery);


        arr_top_names.clear();
        arr_top_names.add("Tabqy");
        arr_top_names.add("Talabat");
        arr_top_names.add("HungerStation");
        arr_top_names.add("Zomato");
        arr_top_names.add("Foodpanda");
        arr_top_names.add("Hellofood");

        arr_top_click_status.clear();
        arr_top_click_status.add("0");
        arr_top_click_status.add("0");
        arr_top_click_status.add("0");
        arr_top_click_status.add("0");
        arr_top_click_status.add("0");
        arr_top_click_status.add("0");

        rv_top = getView().findViewById(R.id.fragment_online_top_recycler);

        LinearLayoutManager manager2
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);

        rv_top.setLayoutManager(manager2);

        adapterOnlineTop = new AdapterOnlineTop(getContext(), arr_top_names, arr_top_click_status, this);
        rv_top.setAdapter(adapterOnlineTop);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if(id == R.id.fragment_online_top_layout_left){
            for(int i=0; i<arr_top_names.size(); i++){
                arr_top_click_status.set(i, "0");
                adapterOnlineTop.notifyDataSetChanged();
            }
            layout_top_left.setBackgroundDrawable(getResources().getDrawable(R.drawable.shape_background_white));
        } else if(id == R.id.fragment_online_online_status_one || id == R.id.fragment_online_online_status_two ||
                id == R.id.fragment_online_online_status_three || id == R.id.fragment_online_online_status_four){
            click_on_status(id);

            if(id == R.id.fragment_online_online_status_one){
                status_rv_new_orders = "new_orders";
                layout_select_driver.setVisibility(View.GONE);
                tv_deliver_to.setText(getResources().getString(R.string.deliver_to));
                cv_list_title.setVisibility(View.VISIBLE);
                rv_new_order.setVisibility(View.VISIBLE);
                layout_delivery.setVisibility(View.GONE);

                tv_order_taken_at.setVisibility(View.VISIBLE);
                tv_driver.setVisibility(View.GONE);
                tv_deliver_to.setText(getResources().getString(R.string.deliver_to));
//                textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon, 0, 0, 0);
                switchCompat.setVisibility(View.VISIBLE);
//                adapterOnlineNewOrders.notifyDataSetChanged();
                adapterOnlineNewOrders = new AdapterOnlineNewOrders(status_rv_new_orders, this);
                rv_new_order.setAdapter(adapterOnlineNewOrders);
            } else if(id == R.id.fragment_online_online_status_two){
                status_rv_new_orders = "new_orders";
                layout_select_driver.setVisibility(View.VISIBLE);
                tv_deliver_to.setText("Action");
                cv_list_title.setVisibility(View.VISIBLE);
                rv_new_order.setVisibility(View.VISIBLE);
                layout_delivery.setVisibility(View.GONE);

                tv_order_taken_at.setVisibility(View.VISIBLE);
                tv_driver.setVisibility(View.GONE);
                tv_deliver_to.setText(getResources().getString(R.string.deliver_to));

                //                tv_deliver_to.setCompoundDrawablesWithIntrinsicBounds(R.drawable.a, 0, 0, 0);
                switchCompat.setVisibility(View.VISIBLE);
//                adapterOnlineNewOrders.notifyDataSetChanged();
                adapterOnlineNewOrders = new AdapterOnlineNewOrders(status_rv_new_orders, this);
                rv_new_order.setAdapter(adapterOnlineNewOrders);
            } else if(id == R.id.fragment_online_online_status_three){
                status_rv_new_orders = "delivery_in_progress";
                layout_select_driver.setVisibility(View.GONE);
                tv_deliver_to.setText(getResources().getString(R.string.deliver_to));
                cv_list_title.setVisibility(View.VISIBLE);
                rv_new_order.setVisibility(View.VISIBLE);
                layout_delivery.setVisibility(View.GONE);

                tv_order_taken_at.setVisibility(View.GONE);
                tv_driver.setVisibility(View.VISIBLE);
                tv_deliver_to.setText("Status");
//                tv_deliver_to.setCompoundDrawablesWithIntrinsicBounds(R.drawable.a, 0, 0, 0);
                switchCompat.setVisibility(View.GONE);
//                adapterOnlineNewOrders.notifyDataSetChanged();
                adapterOnlineNewOrders = new AdapterOnlineNewOrders(status_rv_new_orders,this);
                rv_new_order.setAdapter(adapterOnlineNewOrders);
            } else if(id == R.id.fragment_online_online_status_four){
                status_rv_new_orders = "new_orders";
                layout_select_driver.setVisibility(View.GONE);
                tv_deliver_to.setText(getResources().getString(R.string.deliver_to));
                cv_list_title.setVisibility(View.GONE);
                rv_new_order.setVisibility(View.GONE);
                layout_delivery.setVisibility(View.VISIBLE);

                tv_order_taken_at.setVisibility(View.VISIBLE);
                tv_driver.setVisibility(View.GONE);
                tv_deliver_to.setText(getResources().getString(R.string.deliver_to));
                //                tv_deliver_to.setCompoundDrawablesWithIntrinsicBounds(R.drawable.a, 0, 0, 0);
                switchCompat.setVisibility(View.VISIBLE);
//                adapterOnlineNewOrders.notifyDataSetChanged();
                adapterOnlineNewOrders = new AdapterOnlineNewOrders(status_rv_new_orders, this);
                rv_new_order.setAdapter(adapterOnlineNewOrders);
            } else{
//                layout_select_driver.setVisibility(View.GONE);
//                tv_deliver_to.setText(getResources().getString(R.string.deliver_to));
//                textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon, 0, 0, 0);
            }
        }

    }

    private void click_on_status(int id){
        status_layout_first.setBackgroundDrawable(null);
        status_layout_two.setBackgroundDrawable(null);
        status_layout_three.setBackgroundDrawable(null);
        status_layout_four.setBackgroundDrawable(null);

        LinearLayout layout = getView().findViewById(id);
        layout.setBackgroundDrawable(getActivity().getResources().getDrawable(R.drawable.shape_border_pink));
    }

    @Override
    public void method_AdapterOnlineTop(int position) {
        for(int i=0; i<arr_top_names.size(); i++){
            if(position != i)
                arr_top_click_status.set(i, "0");
        }
        arr_top_click_status.set(position, "1");
        layout_top_left.setBackgroundDrawable(null);
        adapterOnlineTop.notifyDataSetChanged();
    }

    @Override
    public void showdeatils(int pos) {
        showDetailDailog();
    }

    private Dialog dialog_details;
    private void showDetailDailog(){
        dialog_details = new Dialog(getContext());
        dialog_details.setContentView(R.layout.dialog_online_details);

        dialog_details.findViewById(R.id.dialog_online_cross).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_details.dismiss();
            }
        });


        dialog_details.setCancelable(false);
        dialog_details.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog_details.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog_details.show();

    }
}