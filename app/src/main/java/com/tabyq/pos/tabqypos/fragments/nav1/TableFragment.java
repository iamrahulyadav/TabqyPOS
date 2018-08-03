package com.tabyq.pos.tabqypos.fragments.nav1;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
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
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

import com.tabyq.pos.tabqypos.R;
import com.tabyq.pos.tabqypos.activities.MainActivity;
import com.tabyq.pos.tabqypos.adapter.AdapterTableMain;
import com.tabyq.pos.tabqypos.utils.ItemOffsetDecoration;
import com.tabyq.pos.tabqypos.utils.SupportingWidgets;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

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
        createDialogReservation();
        createMyDateDatePicker();
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

    private Dialog dialog_table, dialog_reservation, dialog_code;

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
    private void createDialogReservation() {
        dialog_reservation = new Dialog(getContext());
        dialog_reservation.setContentView(R.layout.dialog_table_reservation);
        dialog_reservation.setCancelable(true);
        dialog_reservation.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog_reservation.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;

        TextView tv_approved = dialog_reservation.findViewById(R.id.dialog_table_reservation_approved);
        TextView tv_decline = dialog_reservation.findViewById(R.id.dialog_table_reservation_decline);
        tv_approved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_reservation.dismiss();
            }
        });
        tv_decline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_reservation.dismiss();
            }
        });

        ImageView iv_date = dialog_reservation.findViewById(R.id.dialog_table_reservation_calender_image);
        ImageView iv_time = dialog_reservation.findViewById(R.id.dialog_table_reservation_clock_image);
        iv_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createDateDialog();

            }
        });
        iv_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createTimeDialog();

            }
        });

        dialog_reservation_tv_date = dialog_reservation.findViewById(R.id.dialog_table_reservation_date);
        dialog_reservation_tv_time = dialog_reservation.findViewById(R.id.dialog_table_reservation_time);
    }

    private Calendar myCalendar = Calendar.getInstance();
    private DatePickerDialog.OnDateSetListener date;
    private TextView dialog_reservation_tv_date, dialog_reservation_tv_time;

    private void createMyDateDatePicker(){
        date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
//                updateLabel();
                String myFormat = "dd/MM/yy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                dialog_reservation_tv_date.setText(sdf.format(myCalendar.getTime()));
            }
        };
    }
    private void createDateDialog(){
        new DatePickerDialog(getContext(), date, myCalendar
                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    private void createTimeDialog(){
        Calendar mcurrentTime = Calendar.getInstance();
        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        int minute = mcurrentTime.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker;
        mTimePicker = new TimePickerDialog(getContext(),
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
//                    eReminderTime.setText( selectedHour + ":" + selectedMinute);
                        dialog_reservation_tv_time.setText(selectedHour + " : " + selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
        mTimePicker.setTitle("Select Time");
        mTimePicker.show();
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
            for(int i=0; i<arr.size(); i++) {
                arr.set(i, "0");
            }
            if (arr.get(position).equals("0")) {

                clicked_position = position;
                dialog_table.show();
//                arr.set(position, "1");
            } else {
                arr.set(position, "0");
                adapter.notifyDataSetChanged();
            }
//          adapter.notifyDataSetChanged();

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
                dialog_reservation.show();
//                SupportingWidgets.showToast(getContext(), "Reservation");
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