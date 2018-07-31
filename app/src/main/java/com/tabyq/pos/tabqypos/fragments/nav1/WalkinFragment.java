package com.tabyq.pos.tabqypos.fragments.nav1;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Display;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.tabyq.pos.tabqypos.R;
import com.tabyq.pos.tabqypos.activities.MainActivity;
import com.tabyq.pos.tabqypos.activities.SearchActivity;
import com.tabyq.pos.tabqypos.activities.TransSucess;
import com.tabyq.pos.tabqypos.adapter.AdapterWalkinDraggedItems;
import com.tabyq.pos.tabqypos.adapter.MainItemListAdapter2;
import com.tabyq.pos.tabqypos.fragments.Sub.AddUserFragment;
import com.tabyq.pos.tabqypos.fragments.Sub.SaveFragment;
import com.tabyq.pos.tabqypos.fragments.Sub.ScanFragment;
import com.tabyq.pos.tabqypos.model.TestData;
import com.tabyq.pos.tabqypos.utils.ItemOffsetDecoration;
import com.tabyq.pos.tabqypos.utils.SupportingWidgets;
import com.tabyq.pos.tabqypos.utils.SwipeHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class WalkinFragment extends Fragment implements MainItemListAdapter2.Listener, MainItemListAdapter2.Interface_MainItemListAdapter2, View.OnDragListener, View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    public WalkinFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_walkin, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        ((MainActivity)getActivity()).cv_main_right.setVisibility(View.GONE);
//        ((MainActivity)getActivity()).layout_top_middle.setVisibility(View.VISIBLE);

        init();
        getMyIntent();
    }

    public static LinearLayout layout_right_top_walkin, layout_right_top_crm;
    public static RecyclerView rv_main, rv_drag;
    public static CardView cv_left_bottom, cv_left_bottom_pay_by_cash;
    private MainItemListAdapter2 adapter;
    private List<TestData> testDataList = new ArrayList<>();
    private AdapterWalkinDraggedItems adapterWalkinDraggedItems;
    private int arr_size = 1;
    private TextView img_search, txt_add_user, txt_add_note, txt_add_discount;
    private TextView txtChrage, txt_save;
    private TextView tv_sub_total, tv_total;
    private ImageView img_delete, iv_menu;
    public static LinearLayout layout_right_bottom_button;
    private TextView tv_scan, tv_online_order;
    private TextView tv_order_status_cancel, tv_pay_by_cash_title
            , tv_pay_by_cash_text_2, tv_pay_by_cash_text_3;
    private CheckBox onlinecheCheckBox;

    private RadioGroup radioGroup;
    private RadioButton radioButton_pay_by_cash;

    public static TextView tv_pay_by_cash_done, tv_pay_by_cash_cancel;
    private TextView tv_category;

    private void init() {
        tv_pay_by_cash_title = getView().findViewById(R.id.walkin_left_pay_by_cash_title);
        tv_pay_by_cash_text_2 = getView().findViewById(R.id.walkin_pay_by_cash_left_text_2);
        tv_pay_by_cash_text_3 = getView().findViewById(R.id.walkin_pay_by_cash_left_text_3);

        radioButton_pay_by_cash = getView().findViewById(R.id.fragment_charge_RadioCash);
        radioButton_pay_by_cash.setOnClickListener(this);

        tv_category = getView().findViewById(R.id.fragment_walkin_all_categories);
        tv_category.setOnClickListener(this);
        layout_right_bottom_button = getView().findViewById(R.id.bottom_buttons);

        tv_sub_total = getView().findViewById(R.id.walkin_sub_total);
        tv_total = getView().findViewById(R.id.walkin_total);
        txt_add_user = getView().findViewById(R.id.img_adduser);

        txtChrage = getView().findViewById(R.id.fragment_new_order_txtCharge);
        txt_save = getView().findViewById(R.id.fragment_new_order_txtSave);

        tv_online_order = getView().findViewById(R.id.fragment_walkin_online_order);
        tv_online_order.setOnClickListener(this);
        img_search = getView().findViewById(R.id.img_search);
        img_delete = getView().findViewById(R.id.fragment_new_order_delete);
        tv_scan = getView().findViewById(R.id.img_scan);
        iv_menu = getView().findViewById(R.id.imgdot_menu);
        iv_menu.setOnClickListener(this);

        tv_order_status_cancel = getView().findViewById(R.id.fragment_walkin_order_no_cancel);
        radioGroup = getView().findViewById(R.id.walkin_order_no_radio_group);
        radioGroup.setOnCheckedChangeListener(this);
        cv_left_bottom_pay_by_cash = getView().findViewById(R.id.walking_card_view_left_bottom_pay_by_cash);
        tv_pay_by_cash_done = getView().findViewById(R.id.walkin_pay_by_cash_btn_done);
        tv_pay_by_cash_cancel = getView().findViewById(R.id.walkin_pay_by_cash_btn_cancel);

        tv_pay_by_cash_done.setOnClickListener(this);
        tv_pay_by_cash_cancel.setOnClickListener(this);

        tv_order_status_cancel.setOnClickListener(this);
        tv_scan.setOnClickListener(this);
        img_search.setOnClickListener(this);
        txt_add_user.setOnClickListener(this);
        txtChrage.setOnClickListener(this);
        txt_save.setOnClickListener(this);
        img_delete.setOnClickListener(this);
        layout_right_bottom_button.setOnClickListener(this);

        layout_right_top_walkin = getView().findViewById(R.id.walkin_layout_right_top_walkin);
        layout_right_top_crm = getView().findViewById(R.id.walkin_layout_right_top_crm);

        cv_left_bottom = getView().findViewById(R.id.walking_card_view_left_bottom);
        rv_main = (RecyclerView) getView().findViewById(R.id.recycler_viewmain);
        rv_main.setLayoutManager(new GridLayoutManager(getActivity(), SupportingWidgets.calculateNoOfColumns(getActivity())));
        ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(getActivity(), R.dimen.item_offset);
        rv_main.addItemDecoration(itemDecoration);

        rv_drag = getView().findViewById(R.id.dragged_items);
        LinearLayoutManager verticalLayoutmanager
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rv_drag.setLayoutManager(verticalLayoutmanager);
//        dragged_items.setLayoutManager(new LinearLayoutManager(getActivity()));

        rv_main.setOnDragListener(this);
        rv_drag.setOnDragListener(this);

        for (int i=0;i<35;i++){
            TestData testData = new TestData();
            testData.setName("Coca Cola");
            testDataList.add(testData);
        }


        adapterWalkinDraggedItems = new AdapterWalkinDraggedItems(arr_size);
        rv_drag.setAdapter(adapterWalkinDraggedItems);

        adapter = new MainItemListAdapter2(getActivity(), testDataList,this, this);
        rv_main.setAdapter(adapter);


        SwipeHelper swipeHelper = new SwipeHelper(getContext(), rv_drag) {
            @Override
            public void instantiateUnderlayButton(RecyclerView.ViewHolder viewHolder, List<UnderlayButton> underlayButtons) {
                underlayButtons.add(new SwipeHelper.UnderlayButton(
                        "",
                        R.drawable.ic_delete_button_white,
                        Color.parseColor("#93014c"),
                        new SwipeHelper.UnderlayButtonClickListener() {
                            @Override
                            public void onClick(int pos) {
                                // TODO: onDelete
                            }
                        }
                ));

/*
                underlayButtons.add(new SwipeHelper.UnderlayButton(
                        "Transfer",
                        0,
                        Color.parseColor("#FF9502"),
                        new SwipeHelper.UnderlayButtonClickListener() {
                            @Override
                            public void onClick(int pos) {
                                // TODO: OnTransfer
                            }
                        }
                ));
                underlayButtons.add(new SwipeHelper.UnderlayButton(
                        "Unshare",
                        0,
                        Color.parseColor("#C7C7CB"),
                        new SwipeHelper.UnderlayButtonClickListener() {
                            @Override
                            public void onClick(int pos) {
                                // TODO: OnUnshare
                            }
                        }
                ));
*/
            }
        };






        createDeleteDialog();
        create_dialog_add_item();
        create_dialog_pay_by_cash();
        create_dialog_pay_by_card();
        create_dialog_pay_by_both();
        createMyDailogWalkin();
    }

    private Dialog dialog_delete;
    private void createDeleteDialog(){
        dialog_delete = new Dialog(getContext());
        dialog_delete.setContentView(R.layout.dialog_delete_item);

        dialog_delete.findViewById(R.id.dialog_del_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_delete.dismiss();
            }
        });

        dialog_delete.findViewById(R.id.dialog_del_clear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog_delete.dismiss();
            }
        });
        dialog_delete.setCancelable(false);
        dialog_delete.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog_delete.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
//        dialog.show();

    }

    private void getMyIntent(){

        String nav_name = getArguments().getString("nav_name");
        if(nav_name.equals("Walkin")){
            layout_right_top_walkin.setVisibility(View.VISIBLE);
            layout_right_top_crm.setVisibility(View.GONE);
        } else{
            layout_right_top_walkin.setVisibility(View.GONE);
            layout_right_top_crm.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        ((MainActivity)getActivity()).cv_main_right.setVisibility(View.GONE);
        ((MainActivity)getActivity()).layout_top_middle.setVisibility(View.VISIBLE);

        ((MainActivity) getActivity()).cv_main_right_2.setVisibility(View.GONE);

/*
        if(dialog_crm_status == 0){
            dialog_walkin.show();
            layout_right_top_crm.setVisibility(View.GONE);
        } else {
            dialog_walkin.dismiss();
            layout_right_top_crm.setVisibility(View.VISIBLE);
        }
*/
    }

    public PopupWindow showMyPopup() {
        final PopupWindow popupWindow = new PopupWindow(getActivity());

        // inflate your layout or dynamically add view
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.popup_walkin_menu, null);
        TextView tv_print_bill = view.findViewById(R.id.popup_walkin_menu_print_bill);
        TextView tv_edit_order = view.findViewById(R.id.popup_walkin_menu_edit_order);
        tv_print_bill.setOnClickListener(this);
        tv_edit_order.setOnClickListener(this);

        Display display = getActivity().getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;

        popupWindow.setFocusable(true);
        popupWindow.setWidth(width - 1090);
        popupWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        popupWindow.setContentView(view);
        return popupWindow;
    }

    public PopupWindow showMyPopup_cateory() {
        final PopupWindow popupWindow = new PopupWindow(getActivity());

        // inflate your layout or dynamically add view
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.popup_walkin_categories, null);

        TextView tv_all = view.findViewById(R.id.popup_walkin_categories_all);
        TextView tv_cold_beverages = view.findViewById(R.id.popup_walkin_categories_cold_beverages);
        TextView tv_pizza = view.findViewById(R.id.popup_walkin_categories_pizza);
        TextView tv_dessert = view.findViewById(R.id.popup_walkin_categories_dessert);
        TextView tv_sarvory = view.findViewById(R.id.popup_walkin_categories_sarvory);

        tv_all.setOnClickListener(this);
        tv_cold_beverages.setOnClickListener(this);
        tv_pizza.setOnClickListener(this);
        tv_dessert.setOnClickListener(this);
        tv_sarvory.setOnClickListener(this);
//        tv_deactivate.setText(chefProfileData1.getChef_data().);

//        tv_edit_profile.setOnClickListener(this);
//        tv_change_password.setOnClickListener(this);
//      tv_deactivate.setOnClickListener(this);
//        tv_logout.setOnClickListener(this);

        Display display = getActivity().getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;

        popupWindow.setFocusable(true);
        popupWindow.setWidth(width - 1000);
        popupWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        popupWindow.setContentView(view);
        return popupWindow;
    }

    private Dialog dialog_add_item;

    private void create_dialog_add_item(){
        dialog_add_item = new Dialog(getContext());
        dialog_add_item.setContentView(R.layout.dialog_add_item);

        dialog_add_item.setCancelable(true);
        dialog_add_item.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog_add_item.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;

        TextView tv_yes = dialog_add_item.findViewById(R.id.dialog_add_item_yes);
        TextView tv_no = dialog_add_item.findViewById(R.id.dialog_add_item_no);
        tv_yes.setOnClickListener(this);
        tv_no.setOnClickListener(this);

    }

    private Dialog dialog_pay_by_cash, dialog_pay_by_card, dialog_pay_by_both;

    private void create_dialog_pay_by_cash(){

        dialog_pay_by_cash = new Dialog(getContext());
        dialog_pay_by_cash.setContentView(R.layout.dialog_walkin_pay_by_cash);

        dialog_pay_by_cash.setCancelable(false);
        dialog_pay_by_cash.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog_pay_by_cash.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;

        TextView tv_done = dialog_pay_by_cash.findViewById(R.id.dialog_walkin_pay_by_cash_done);
        tv_done.setOnClickListener(this);

    }
    private void create_dialog_pay_by_card(){

        dialog_pay_by_card = new Dialog(getContext());
        dialog_pay_by_card.setContentView(R.layout.dialog_walkin_pay_by_card);

        dialog_pay_by_card.setCancelable(true);
        dialog_pay_by_card.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog_pay_by_card.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;

        TextView tv_done = dialog_pay_by_card.findViewById(R.id.dialog_walkin_pay_by_card_done);
        tv_done.setOnClickListener(this);

    }
    private void create_dialog_pay_by_both(){

        dialog_pay_by_both = new Dialog(getContext());
        dialog_pay_by_both.setContentView(R.layout.dialog_walkin_pay_by_both);

        dialog_pay_by_both.setCancelable(true);
        dialog_pay_by_both.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog_pay_by_both.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;

        TextView tv_done = dialog_pay_by_both.findViewById(R.id.dialog_walkin_pay_by_both_done);
        tv_done.setOnClickListener(this);

    }

    private Dialog dialog_walkin;
    private void createMyDailogWalkin(){
        dialog_walkin = new Dialog(getContext());
        dialog_walkin.setContentView(R.layout.dialog_walkin_home);

        dialog_walkin.setCancelable(true);
        dialog_walkin.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog_walkin.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;

        TextView tv = dialog_walkin.findViewById(R.id.dialog_walkin_home_submit);
        tv.setOnClickListener(this);

    }

    @Override
    public boolean onDrag(View v, DragEvent event) {
        int action = event.getAction();
        boolean isDropped = false;
        switch (action) {
            case DragEvent.ACTION_DRAG_STARTED:

                break;

            case DragEvent.ACTION_DRAG_ENTERED:

                break;

            case DragEvent.ACTION_DRAG_EXITED:

                break;

            case DragEvent.ACTION_DROP:

                View view = (View) event.getLocalState();
                Log.d("MyId", view.getId() + "");

                if(v.getId() == R.id.recycler_viewmain){
                } else if(v.getId() == R.id.dragged_items){

                    dialog_add_item.show();
/*
                    arr_size = arr_size + 1;
                    tv_sub_total.setText("$" + (arr_size * 12) + ".00");
                    tv_total.setText("SAR " + ((arr_size * 12) + 40) + ".00");
                    adapterWalkinDraggedItems = new AdapterWalkinDraggedItems(arr_size);
                    rv_drag.setAdapter(adapterWalkinDraggedItems);
                    adapterWalkinDraggedItems.notifyDataSetChanged();
*/



                } else {
                    Toast.makeText(getContext(), "out", Toast.LENGTH_SHORT).show();
                }
                isDropped = true;
                break;

            case DragEvent.ACTION_DRAG_ENDED:

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

    @Override
    public void setEmptyList(boolean visibility) {
        rv_drag.setVisibility(visibility ? View.GONE : View.VISIBLE);
    }

    @Override
    public void method(int position) {
//        dragged_item_position = position;
//        Toast.makeText(getContext(), position + "", Toast.LENGTH_SHORT).show();
    }

    private PopupWindow popupwindow_obj;
    private PopupWindow popupwindow_cateory;


    public static int back_status = 0;
    private int dialog_crm_status = 0;

    @Override
    public void onClick(View v) {
        int id_ = v.getId();
        if(id_ == R.id.img_search){
            startActivity(new Intent(getActivity(), SearchActivity.class));
        } else if(id_ == R.id.img_adduser){
            new SupportingWidgets().callFragment(getActivity(), new AddUserFragment(), getFragmentManager(),
                    R.id.frame_main_bottom, WalkinFragment.class.getName());
        } else if(id_ == R.id.fragment_new_order_txtCharge){
            layout_right_top_walkin.setVisibility(View.GONE);
            layout_right_top_crm.setVisibility(View.VISIBLE);
            layout_right_bottom_button.setVisibility(View.GONE);
            rv_main.setVisibility(View.GONE);
            cv_left_bottom.setVisibility(View.VISIBLE);
            back_status = 1;

        } else if(id_ == R.id.fragment_walkin_order_no_cancel){
            layout_right_top_walkin.setVisibility(View.VISIBLE);
            layout_right_top_crm.setVisibility(View.GONE);
            layout_right_bottom_button.setVisibility(View.VISIBLE);
            rv_main.setVisibility(View.VISIBLE);
            cv_left_bottom.setVisibility(View.GONE);
            back_status = 0;


        } else if(id_ == R.id.fragment_charge_RadioCash){

            cv_left_bottom.setVisibility(View.GONE);
            cv_left_bottom_pay_by_cash.setVisibility(View.VISIBLE);
            back_status = 2;
            dialog_pay_by_cash.show();
            tv_pay_by_cash_title.setText("Pay by Cash");
            tv_pay_by_cash_text_2.setText("Cash Received");
            tv_pay_by_cash_text_3.setText("Change Return");

        } else if(id_ == R.id.walkin_pay_by_cash_btn_done){
            startActivity(new Intent(getActivity(), TransSucess.class));
        } else if(id_ == R.id.walkin_pay_by_cash_btn_cancel){
            cv_left_bottom.setVisibility(View.VISIBLE);
            cv_left_bottom_pay_by_cash.setVisibility(View.GONE);
            back_status = 1;

        } else if(id_ == R.id.fragment_new_order_txtSave){
            new SupportingWidgets().callFragment(getActivity(), new SaveFragment(), getFragmentManager(),
                    R.id.frame_main_bottom, SaveFragment.class.getName());

        } else if(id_ == R.id.fragment_new_order_delete){

            dialog_delete.show();
        } else if(id_ == R.id.img_scan){
            new SupportingWidgets().callFragment(getActivity(), new ScanFragment(), getFragmentManager(),
                    R.id.frame_main_bottom, ScanFragment.class.getName());
        } else if(id_ == R.id.fragment_walkin_online_order){
            dialog_walkin.show();

        } else if(id_ == R.id.imgdot_menu){
            popupwindow_obj = showMyPopup();
            popupwindow_obj.showAsDropDown(iv_menu, 10, 20); // where u want show on view click event popupwindow.showAsDropDown(view, x, y);

        } else if(id_ == R.id.fragment_walkin_all_categories){
            popupwindow_cateory = showMyPopup_cateory();
            popupwindow_cateory.showAsDropDown(tv_category, -12, 05); // where u want show on view click event popupwindow.showAsDropDown(view, x, y);

        } else if(id_ == R.id.popup_walkin_menu_print_bill){
            Toast.makeText(getContext(), "Print Bill", Toast.LENGTH_SHORT).show();
        } else if(id_ == R.id.popup_walkin_menu_edit_order){
            Toast.makeText(getContext(), "Edit Order", Toast.LENGTH_SHORT).show();
        } else if(id_ == R.id.popup_walkin_categories_all){
            Toast.makeText(getContext(), "All Categories", Toast.LENGTH_SHORT).show();
        } else if(id_ == R.id.popup_walkin_categories_cold_beverages){
            Toast.makeText(getContext(), "Cold Beverages", Toast.LENGTH_SHORT).show();
        } else if(id_ == R.id.popup_walkin_categories_pizza){
            Toast.makeText(getContext(), "Pizza", Toast.LENGTH_SHORT).show();
        } else if(id_ == R.id.popup_walkin_categories_dessert){
            Toast.makeText(getContext(), "Dessert", Toast.LENGTH_SHORT).show();
        } else if(id_ == R.id.popup_walkin_categories_sarvory){
            Toast.makeText(getContext(), "Sarvory", Toast.LENGTH_SHORT).show();
        } else if(id_ == R.id.dialog_add_item_yes){
            arr_size = arr_size + 1;
            tv_sub_total.setText("$" + (arr_size * 12) + ".00");
            tv_total.setText("SAR " + ((arr_size * 12) + 40) + ".00");
            adapterWalkinDraggedItems = new AdapterWalkinDraggedItems(arr_size);
            rv_drag.setAdapter(adapterWalkinDraggedItems);
            adapterWalkinDraggedItems.notifyDataSetChanged();
            dialog_add_item.dismiss();
        } else if(id_ == R.id.dialog_add_item_no){
            dialog_add_item.dismiss();
        } else if(id_ == R.id.dialog_walkin_pay_by_cash_done){
            dialog_pay_by_cash.dismiss();
        } else if(id_ == R.id.dialog_walkin_pay_by_card_done){
            dialog_pay_by_card.dismiss();
        } else if(id_ == R.id.dialog_walkin_pay_by_both_done){
            dialog_pay_by_both.dismiss();
        } else if(id_ == R.id.dialog_walkin_home_submit){
            dialog_walkin.dismiss();
//            dialog_crm_status = 1;
        } else {

        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        if(group.getId() == R.id.walkin_order_no_radio_group){
            int id = group.getCheckedRadioButtonId();
            RadioButton radioButton = radioGroup.findViewById(id);
            if (radioButton.getText().toString().trim().equals("Pay by Cash")){
              /*  cv_left_bottom.setVisibility(View.GONE);
                cv_left_bottom_pay_by_cash.setVisibility(View.VISIBLE);
                back_status = 2;*/
            } else if (radioButton.getText().toString().trim().equals("Pay by Card")){
                cv_left_bottom.setVisibility(View.GONE);
                cv_left_bottom_pay_by_cash.setVisibility(View.VISIBLE);
                back_status = 2;
                dialog_pay_by_card.show();
                tv_pay_by_cash_title.setText("Pay by Card");
                tv_pay_by_cash_text_2.setText("Cash Amount");
                tv_pay_by_cash_text_3.setText("Card Amount");
            } else if(radioButton.getText().toString().trim().equals("Pay by Both")){
                cv_left_bottom.setVisibility(View.GONE);
                cv_left_bottom_pay_by_cash.setVisibility(View.VISIBLE);
                back_status = 2;
                dialog_pay_by_both.show();
                tv_pay_by_cash_title.setText("Pay by Both");
                tv_pay_by_cash_text_2.setText("Cash Amount");
                tv_pay_by_cash_text_3.setText("Card Amount");
                tv_pay_by_cash_done.setText("Process");
            } else {

            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if(popupwindow_obj != null) {
            popupwindow_obj.dismiss();
            popupwindow_obj = null;
        }
        if(popupwindow_cateory != null) {
            popupwindow_cateory.dismiss();
            popupwindow_cateory = null;
        }
    }

    @Override
    public void onStop() {
        super.onStop();

        if(popupwindow_obj != null) {
            popupwindow_obj.dismiss();
            popupwindow_obj = null;
        }
        if(popupwindow_cateory != null) {
            popupwindow_cateory.dismiss();
            popupwindow_cateory = null;
        }
    }
}