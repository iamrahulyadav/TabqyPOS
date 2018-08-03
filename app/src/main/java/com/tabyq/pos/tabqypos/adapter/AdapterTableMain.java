package com.tabyq.pos.tabqypos.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;


import com.tabyq.pos.tabqypos.R;

import java.util.ArrayList;

public class AdapterTableMain extends RecyclerView.Adapter<AdapterTableMain.MyViewHolder> {

    private Context context;
    private Activity activity;
    private Interface_TableMain click;
    private ArrayList<String> arr = new ArrayList<>();

    public AdapterTableMain(Context context, Activity activity, ArrayList<String> arr, Interface_TableMain click){

        this.context = context;
        this.activity = activity;
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
//            holder.iv.setImageResource(R.drawable.ic_table_main);
        } else {
            PopupWindow popupwindow_obj;
            popupwindow_obj = showMyPopup();
            popupwindow_obj.showAsDropDown(holder.itemView, 30, -30); // where u want show on view click event popupwindow.showAsDropDown(view, x, y);
//            holder.iv.setImageResource(R.drawable.ic_tray);
        }

    }

    @Override
    public int getItemCount() {
        return 30;
    }

    public PopupWindow showMyPopup() {
        final PopupWindow popupWindow = new PopupWindow();

        // inflate your layout or dynamically add view
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.popup_table_main_code, null);

        Display display = activity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;

        popupWindow.setFocusable(true);
        popupWindow.setWidth(200);
        popupWindow.setHeight(200);
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        popupWindow.setContentView(view);
        TextView tv_cross = view.findViewById(R.id.popup_table_main_code_title);
        TextView tv_ok = view.findViewById(R.id.popup_table_main_code_bottom);
        tv_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        return popupWindow;
    }

    public interface Interface_TableMain{
        public void method_Table_Main(int position);
    }
}