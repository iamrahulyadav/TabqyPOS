package com.tabyq.pos.tabqypos.adapter;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tabyq.pos.tabqypos.R;

public class AdapterOrderStatus extends RecyclerView.Adapter<AdapterOrderStatus.MyViewHolder> {

    private int size, type;
    public AdapterOrderStatus(int size, int type){
        this.size = size;
        this.type = type;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView tv1, tv2, tv3;
        public MyViewHolder(View view) {
            super(view);

            tv1 = view.findViewById(R.id.item_order_status_text_1);
            tv2 = view.findViewById(R.id.item_order_status_text_2);
            tv3 = view.findViewById(R.id.item_order_status_text_3);

        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_order_status, parent, false);

        return new MyViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        if(type == 1){
            holder.tv1.setText("table 05");
            holder.tv2.setText("00:02");
            holder.tv3.setText("Start");
        } else if(type == 2){
            holder.tv1.setText("Order#75");
            holder.tv2.setText("00:30");
            holder.tv3.setText("Start");
        } else if(type == 3){
            holder.tv1.setText("Order#63");
            holder.tv2.setText("00:02");
            holder.tv3.setText("Start");
        } else {}

    }

    @Override
    public int getItemCount() {
        return size;
    }

}