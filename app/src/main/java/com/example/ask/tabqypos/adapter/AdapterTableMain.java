package com.example.ask.tabqypos.adapter;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.ask.tabqypos.R;

import java.util.ArrayList;

public class AdapterTableMain extends RecyclerView.Adapter<AdapterTableMain.MyViewHolder> {

    private Interface_TableMain click;
    private ArrayList<String> arr = new ArrayList<>();

    public AdapterTableMain(ArrayList<String> arr, Interface_TableMain click){

        this.arr = arr;
        this.click = click;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView tv;
        public ImageView iv;
        public LinearLayout layout;

        public MyViewHolder(View view) {
            super(view);

            layout = view.findViewById(R.id.item_table_main_layout);
            iv = view.findViewById(R.id.item_table_main_image);
            tv = view.findViewById(R.id.item_table_main_text);

            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    click.method_Table_Main(getAdapterPosition());
                }
            });
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_table__row, parent, false);

        return new MyViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.tv.setText((position + 1) + "");
        if (arr.get(position).equals("0")) {
            holder.iv.setImageResource(R.drawable.ic_table_main);
        } else {
            holder.iv.setImageResource(R.drawable.ic_tray);
        }
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    public interface Interface_TableMain{
        public void method_Table_Main(int position);
    }
}