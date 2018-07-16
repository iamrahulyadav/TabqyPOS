package com.example.ask.tabqypos.adapter;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ask.tabqypos.R;

public class AdapterSettings extends RecyclerView.Adapter<AdapterSettings.MyViewHolder> {


    public AdapterSettings(){
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public MyViewHolder(View view) {
            super(view);

        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_settings, parent, false);

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