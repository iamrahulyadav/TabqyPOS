package com.tabyq.pos.tabqypos.adapter;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tabyq.pos.tabqypos.R;

public class AdapterItemFeedback extends RecyclerView.Adapter<AdapterItemFeedback.MyViewHolder> {

    private int size;
    private AdapterFeedbackInterface adapterFeedbackInterface;

    public AdapterItemFeedback(int size, AdapterFeedbackInterface adapterFeedbackInterface) {
        this.size = size;
        this.adapterFeedbackInterface = adapterFeedbackInterface;
    }

    public interface AdapterFeedbackInterface{
        void viewComment(int pos);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv_view_comment;

        public MyViewHolder(View view) {
            super(view);
            tv_view_comment = view.findViewById(R.id.item_feedback_view_comment);

            tv_view_comment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adapterFeedbackInterface.viewComment(getAdapterPosition());
                }
            });
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_feedback_list_view, parent, false);

        return new MyViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

    }

    @Override
    public int getItemCount() {
        return size;
    }

}