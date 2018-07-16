package com.example.ask.tabqypos.adapter;

import android.app.Activity;
import android.content.ClipData;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.ask.tabqypos.R;
import com.example.ask.tabqypos.model.TestData;

import java.util.List;

public class MainItemListAdapter2 extends RecyclerView.Adapter<MainItemListAdapter2.ProductViewHolder> {
    Activity mContext;
    private List<TestData>testDataList ;
    Listener mListener;


    private Interface_MainItemListAdapter2 click;

    public MainItemListAdapter2(Activity mContext, List<TestData> testDataList, Listener mListener,
                                Interface_MainItemListAdapter2 click) {
        this.mContext = mContext;
        this.testDataList = testDataList;
        this.mListener = mListener;
        this.click = click;
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        CardView cardview_expandable;
        ConstraintLayout constraintLayout ;
        TextView txtPrice;
        public ProductViewHolder(View itemView) {
            super(itemView);
            cardview_expandable=itemView.findViewById(R.id.cardview_expandable);
            txtPrice = itemView.findViewById(R.id.item_price);
            constraintLayout = itemView.findViewById(R.id.cardview_expandable_view);

            constraintLayout.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    ClipData data = ClipData.newPlainText("", "");
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                    view.startDrag(data, shadowBuilder, view, 0);
                    view.setVisibility(View.INVISIBLE);

                    click.method(getAdapterPosition());

                    return true;
                }
            });

        }
    }




    public interface Listener{
        void setEmptyList(boolean visibility);
    }

    @NonNull
    @Override
    public MainItemListAdapter2.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.row_itemlistmain, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainItemListAdapter2.ProductViewHolder holder, int position) {

        holder.constraintLayout.setTag(position);
        holder.txtPrice.setText("$ "+position);
       /* holder.constraintLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(data, shadowBuilder, view, 0);
                view.setVisibility(View.INVISIBLE);
                return true;
            }
        });
        holder.constraintLayout.setOnDragListener(new DragListener(mListener));*/
    }

    public List<TestData> getCustomList() {
        return testDataList;
    }

    public void updateCustomList(List<TestData> customList) {
        this.testDataList = customList;
    }

    @Override
    public int getItemCount() {
        return testDataList.size();
    }

    public interface Interface_MainItemListAdapter2 {
        public void method(int position);
    }



}
