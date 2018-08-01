package com.tabyq.pos.tabqypos.fragments.nav1;


import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.tabyq.pos.tabqypos.R;
import com.tabyq.pos.tabqypos.activities.MainActivity;
import com.tabyq.pos.tabqypos.adapter.AdapterTableMain;
import com.tabyq.pos.tabqypos.utils.ItemOffsetDecoration;
import com.tabyq.pos.tabqypos.utils.SupportingWidgets;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TableFragment extends Fragment implements AdapterTableMain.Interface_TableMain, View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    public TableFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_table, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        init();
        createDialogTable();
//        createDialogCode();
    }

    private RecyclerView rv_table;
    private AdapterTableMain adapter;
    private ArrayList<String> arr = new ArrayList<>();

    private void init() {

        rv_table = getView().findViewById(R.id.table_rv);
        rv_table.setLayoutManager(new GridLayoutManager(getActivity(),
                SupportingWidgets.calculateNoOfColumns(getActivity())));
        ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(getActivity(), R.dimen.item_offset);
        rv_table.addItemDecoration(itemDecoration);
        arr.clear();
        for (int i = 0; i < 35; i++) {
            arr.add("0");
        }

        adapter = new AdapterTableMain(getContext(), getActivity(), arr, this);
        rv_table.setAdapter(adapter);

    }

    private Dialog dialog_table, dialog_code;
    private void createDialogTable() {
        dialog_table = new Dialog(getContext());
        dialog_table.setContentView(R.layout.dialog_table);
        dialog_table.setCancelable(true);
        dialog_table.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog_table.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;

        TextView tv = dialog_table.findViewById(R.id.dialog_table_btn);
        tv.setOnClickListener(this);
        RadioGroup radioGroup = dialog_table.findViewById(R.id.dialog_table_radio_group);
        radioGroup.setOnCheckedChangeListener(this);
    }
/*
    private void createDialogCode() {
        dialog_code = new Dialog(getContext());
        dialog_code.setContentView(R.layout.dialog_code);
        dialog_code.setCancelable(true);
        dialog_code.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog_code.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;

    }
*/

    @Override
    public void onResume() {
        super.onResume();

        MainActivity.cv_main_right.setVisibility(View.GONE);
        MainActivity.layout_top_middle.setVisibility(View.VISIBLE);
        MainActivity.cv_main_right_2.setVisibility(View.GONE);
    }

    int clicked_position;
    @Override
    public void method_Table_Main(int position) {

        if (position >= 0) {
            if (arr.get(position).equals("0")) {

                clicked_position = position;
                dialog_table.show();


//                arr.set(position, "1");
            } else {
                arr.set(position, "0");
                adapter.notifyDataSetChanged();
            }
//            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onClick(View v) {

        int id = v.getId();

        if(id == R.id.dialog_table_btn){
            if(selected_option == null){
                SupportingWidgets.showToast(getContext(), "Please select an option.");
            } else if(selected_option.equals("Code")){
                dialog_table.dismiss();
                arr.set(clicked_position, "1");
                adapter.notifyDataSetChanged();
//                dialog_code.show();
//                SupportingWidgets.showToast(getContext(), "Code");
            } else if (selected_option.equals("Reservation")){
                dialog_table.dismiss();
                SupportingWidgets.showToast(getContext(), "Reservation");
            } else {}
        } else {}
    }

    private String selected_option;

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if(group.getId() == R.id.dialog_table_radio_group){
            int id = group.getCheckedRadioButtonId();
            RadioButton radioButton = group.findViewById(id);
            if(radioButton.getText().toString().equals("Code")){
                selected_option = "Code";
            } else if (radioButton.getText().toString().equals("Reservation")){
                selected_option = "Reservation";
            } else{

            }
        }
    }
}