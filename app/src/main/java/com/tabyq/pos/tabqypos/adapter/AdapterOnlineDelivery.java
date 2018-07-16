package com.tabyq.pos.tabqypos.adapter;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tabyq.pos.tabqypos.R;

public class AdapterOnlineDelivery extends RecyclerView.Adapter<AdapterOnlineDelivery.MyViewHolder> {


    public AdapterOnlineDelivery(){
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public MyViewHolder(View view) {
            super(view);

        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_online_delivery, parent, false);

        return new MyViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {


    }

    @Override
    public int getItemCount() {
        return 1;
    }

}