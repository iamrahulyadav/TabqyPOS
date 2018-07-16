package com.tabyq.pos.tabqypos.adapter;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tabyq.pos.tabqypos.R;

public class AdapterOnlineNewOrders extends RecyclerView.Adapter<AdapterOnlineNewOrders.MyViewHolder> {

    private String status_rv_new_orders;
    public AdapterOnlineNewOrders(String status_rv_neworder){
        this.status_rv_new_orders = status_rv_neworder;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView tv_order_taken_at, tv_driver;
        public LinearLayout layout_delivery_to, layout_status;
        public MyViewHolder(View view) {
            super(view);

            tv_order_taken_at = view.findViewById(R.id.item_online_new_order_order_taken_at);
            tv_driver = view.findViewById(R.id.item_online_new_order_driver);
            layout_delivery_to = view.findViewById(R.id.item_online_new_order_layout_deliver_to);
            layout_status = view.findViewById(R.id.item_online_new_order_layout_status);

        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_online_new_order, parent, false);

        return new MyViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        Log.d("MyAdapter", status_rv_new_orders);

        if(status_rv_new_orders.equals("new_orders")){
            holder.tv_order_taken_at.setVisibility(View.VISIBLE);
            holder.tv_driver.setVisibility(View.GONE);
            holder.layout_delivery_to.setVisibility(View.VISIBLE);
            holder.layout_status.setVisibility(View.GONE);

        } else if(status_rv_new_orders.equals("delivery_in_progress")){
            holder.tv_order_taken_at.setVisibility(View.GONE);
            holder.tv_driver.setVisibility(View.VISIBLE);
            holder.layout_delivery_to.setVisibility(View.GONE);
            holder.layout_status.setVisibility(View.VISIBLE);

        } else {

        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

}