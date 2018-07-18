package com.tabyq.pos.tabqypos.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tabyq.pos.tabqypos.R;

import java.util.ArrayList;

public class AdapterOnlineTop extends RecyclerView.Adapter<AdapterOnlineTop.MyViewHolder> {

    private Context context;
    private ArrayList<String> arr_names = new ArrayList<>();
    private ArrayList<String> arr_status = new ArrayList<>();
    private ArrayList<Integer> arr_top_img;
    private Interface_AdapterOnlineTop click;

    public AdapterOnlineTop(Context context, ArrayList<String> arr_names, ArrayList<String> arr_status,
                            ArrayList<Integer> arr_top_img, Interface_AdapterOnlineTop click){

        this.context = context;
        this.arr_names = arr_names;
        this.arr_status = arr_status;
        this.arr_top_img = arr_top_img;
        this.click = click;
     }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public LinearLayout layout;
        public TextView tv;
        public ImageView iv;

        public MyViewHolder(View view) {
            super(view);

            layout = view.findViewById(R.id.item_fragment_online_top_layout);
            tv = view.findViewById(R.id.item_fragment_online_top_text);
            iv = view.findViewById(R.id.item_fragment_online_top_image);

            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    click.method_AdapterOnlineTop(getAdapterPosition());
                }
            });
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_fragment_online_top_recycler, parent, false);

        return new MyViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.tv.setText(arr_names.get(position));
        holder.iv.setImageResource(arr_top_img.get(position));
        if(arr_status.get(position).equals("1")){
            holder.layout.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.shape_background_white));
        } else {
            holder.layout.setBackgroundDrawable(null);
        }
    }

    @Override
    public int getItemCount() {
        return arr_names.size();
    }

    public interface Interface_AdapterOnlineTop {
        public void method_AdapterOnlineTop(int position);
    }
}