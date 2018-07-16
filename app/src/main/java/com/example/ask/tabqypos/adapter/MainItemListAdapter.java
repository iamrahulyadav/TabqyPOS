package com.example.ask.tabqypos.adapter;

import android.app.Activity;
import android.net.sip.SipAudioCall;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ask.tabqypos.R;


public class MainItemListAdapter extends RecyclerView.Adapter<MainItemListAdapter.ProductViewHolder> {
    Activity mContext;
    SipAudioCall.Listener mListener;
    public MainItemListAdapter(Activity mCtx) {
        this.mContext = mCtx;

    }

    @NonNull
    @Override
    public MainItemListAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.row_itemlistmain, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainItemListAdapter.ProductViewHolder holder, int position) {
        holder.cardview_expandable.setOnDragListener(new DragListener(mListener));
        holder.txtPrice.setText("$ "+position);
    }
    public DragListener getDragInstance() {
        if (mListener != null) {
            return new DragListener(mListener);
        } else {
            Log.e("Route Adapter: ", "Initialize listener first!");
            return null;
        }
    }
    @Override
    public int getItemCount() {
        return 15;
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        CardView cardview_expandable;
        TextView txtPrice;
        public ProductViewHolder(View itemView) {
            super(itemView);
            cardview_expandable=itemView.findViewById(R.id.cardview_expandable);
            txtPrice = itemView.findViewById(R.id.item_price);
        }
    }


    public class DragListener implements View.OnDragListener {

        boolean isDropped = false;
        SipAudioCall.Listener mListener;

        public DragListener(SipAudioCall.Listener listener) {
            this.mListener = listener;
        }

        @Override
        public boolean onDrag(View v, DragEvent event) {
            int action = event.getAction();
            switch (action) {
                case DragEvent.ACTION_DRAG_STARTED:
                    break;

                case DragEvent.ACTION_DRAG_ENTERED:
                    //v.setBackgroundColor(Color.LTGRAY);
                    break;

                case DragEvent.ACTION_DRAG_EXITED:
                    //v.setBackgroundColor(Color.YELLOW);
                    break;

                case DragEvent.ACTION_DROP:

                    isDropped = true;
                    int positionSource = -1;
                    int positionTarget = -1;

                    View viewSource = (View) event.getLocalState();

//                    if (v.getId() == R.id.cardView || v.getId() == R.id.textEmptyList) {
//                        //RecyclerView target = (RecyclerView) v.getParent();
//                        RecyclerView target;
//                        if (v.getId() == R.id.textEmptyList) {
//                            target = (RecyclerView)
//                                    v.getRootView().findViewById(R.id.recyclerPendingList);
//                        } else {
//                            target = (RecyclerView) v.getParent();
//                            positionTarget = (int) v.getTag();
//                        }
//
//                        RecyclerView source = (RecyclerView) viewSource.getParent();
//
//                        CustomListAdapter adapterSource = (CustomListAdapter) source.getAdapter();
//                        positionSource = (int) viewSource.getTag();
//
//                        CustomList customList = (CustomList) adapterSource.getCustomList().get(positionSource);
//                        List<CustomList> customListSource = adapterSource.getCustomList();
//
//                        customListSource.remove(positionSource);
//                        adapterSource.updateCustomList(customListSource);
//                        adapterSource.notifyDataSetChanged();
//
//                        CustomListAdapter adapterTarget = (CustomListAdapter) target.getAdapter();
//                        List<CustomList> customListTarget = adapterTarget.getCustomList();
//                        if (positionTarget >= 0) {
//                            customListTarget.add(positionTarget, customList);
//                        } else {
//                            customListTarget.add(customList);
//                        }
//                        adapterTarget.updateCustomList(customListTarget);
//                        adapterTarget.notifyDataSetChanged();
//                        v.setVisibility(View.VISIBLE);
//
//                        if (source.getId() == R.id.recyclerPendingList
//                                && adapterSource.getItemCount() < 1) {
//                            mListener.setEmptyList(true);
//                        }
//
//                        if (v.getId() == R.id.textEmptyList) {
//                            mListener.setEmptyList(false);
//                        }
//                    }

                    break;

                case DragEvent.ACTION_DRAG_ENDED:
                    //v.setBackgroundColor(0);
                    break;

                default:
                    break;
            }

            if (!isDropped) {
                View vw = (View) event.getLocalState();
                vw.setVisibility(View.VISIBLE);
            }

            return true;
        }

    }
}
