package com.tabyq.pos.tabqypos.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tabyq.pos.tabqypos.R;


public class CustomerSearchAdapter extends RecyclerView.Adapter<CustomerSearchAdapter.SearchViewHolder>{
    private Context mContext;
    private SearchItemClick searchItemClick;


    public CustomerSearchAdapter(Context mContext, SearchItemClick searchItemClick) {
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
        View view = inflater.inflate(R.layout.item_search_view, parent, false);


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

        TextView txt_name;
        public SearchViewHolder(View itemView) {
            super(itemView);
            txt_name = itemView.findViewById(R.id.item_search_view_txt);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    searchItemClick.getSelected(getAdapterPosition());
                }
            });
        }
    }


}
