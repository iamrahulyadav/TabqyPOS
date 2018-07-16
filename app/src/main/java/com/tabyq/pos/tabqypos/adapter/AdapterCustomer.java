package com.tabyq.pos.tabqypos.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.tabyq.pos.tabqypos.R;

public class AdapterCustomer extends RecyclerView.Adapter<AdapterCustomer.MyViewHolder> {

    private Context context;
    public AdapterCustomer(Context context){

        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public RelativeLayout layout;

        public MyViewHolder(View view) {
            super(view);

            layout = view.findViewById(R.id.item_customer_layout);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_customer, parent, false);

        return new MyViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        int pos = position%2;
        if(pos == 0){
            holder.layout.setBackgroundColor(context.getResources().getColor(R.color.background));
        } else{
            holder.layout.setBackgroundColor(context.getResources().getColor(R.color.colorWhite));
        }

    }

    @Override
    public int getItemCount() {
        return 6;
    }
}