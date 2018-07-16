package com.tabyq.pos.tabqypos.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tabyq.pos.tabqypos.R;


public class SavePastOrderAdapter extends RecyclerView.Adapter<SavePastOrderAdapter.SearchViewHolder>{
    private Context mContext;
    private SearchItemClick searchItemClick;


    public SavePastOrderAdapter(Context mContext, SearchItemClick searchItemClick) {
        this.mContext = mContext;
        this.searchItemClick = searchItemClick;
    }


    public interface SearchItemClick{
        void getSelected(int position);
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.item_save_past_order, parent, false);


        return new SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class SearchViewHolder extends RecyclerView.ViewHolder {

        public SearchViewHolder(View itemView) {
            super(itemView);

        }
    }


}
