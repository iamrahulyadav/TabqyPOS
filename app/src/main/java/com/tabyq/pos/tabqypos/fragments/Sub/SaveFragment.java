package com.tabyq.pos.tabqypos.fragments.Sub;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tabyq.pos.tabqypos.R;
import com.tabyq.pos.tabqypos.activities.MainActivity;
import com.tabyq.pos.tabqypos.adapter.SavePastOrderAdapter;
import com.tabyq.pos.tabqypos.utils.SupportingWidgets;


public class SaveFragment extends Fragment implements SavePastOrderAdapter.SearchItemClick, View.OnClickListener{

    private View view;
    private TextView txt_add_note, txt_add_discount, txt_not, txt_add_user, txt_add_address, txt_del_add;
//    private RelativeLayout nav_menu;
    private RecyclerView recyclerView;
    private TextView tv_place_new_order;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_save, container, false);

        init(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private void init(View view){
//        txt_add_discount = view.findViewById(R.id.add_discount);
//        txt_add_note = view.findViewById(R.id.add_note);
//        txt_add_discount.setVisibility(View.GONE);
//        txt_add_note.setVisibility(View.GONE);
        txt_not = view.findViewById(R.id.fragment_save_not_name);
        recyclerView = view.findViewById(R.id.fragment_save_recycler);
//        nav_menu = (RelativeLayout) view.findViewById(R.id.nav_menu);
        txt_add_user = view.findViewById(R.id.img_adduser);
        txt_add_address = view.findViewById(R.id.fragment_save_txt_add_address);
        txt_del_add = view.findViewById(R.id.fragment_save_txt_delete_address);
//        txt_del_add = view.findViewById(R.id.fragment_save_txt_delete_address);

        tv_place_new_order = view.findViewById(R.id.fragment_save_place_new_order);
        tv_place_new_order.setOnClickListener(this);

/*
        nav_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ((MainDashBoardActivity) getActivity()).showHideNavView();
            }
        });
*/

        String s = "Not John? Create new Customer";
        Spannable wordtoSpan = new SpannableString(s);

        wordtoSpan.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorappPink)), 8, s.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        txt_not.setText(wordtoSpan);

        LinearLayoutManager horizontalLayoutManagaer
                = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManagaer);

        setListener();
        setAdapter();
        addAddressDialog();
        createDeleteDialog();

    }

    private void setListener(){
//        txt_add_user.setOnClickListener(this);
        txt_del_add.setOnClickListener(this);
        txt_add_address.setOnClickListener(this);
/*
        txt_add_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SupportingWidgets().callFragment(getActivity(), new AddUserFragment(), getFragmentManager(),
                        R.id.frame_main_bottom, SaveFragment.class.getName());
            }
        });
*/
    }

    @Override
    public void onResume() {
        super.onResume();

        ((MainActivity) getActivity()).cv_main_right_2.setVisibility(View.VISIBLE);
    }

    private void setAdapter(){
        SavePastOrderAdapter savePastOrderAdapter = new
                SavePastOrderAdapter(getContext(),this);
        recyclerView.setAdapter(savePastOrderAdapter);
    }

    @Override
    public void getSelected(int position) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fragment_save_txt_add_address:
                dialog_add_address.show();
                break;
            case R.id.fragment_save_txt_delete_address:
                dialog_delete_item.show();
                break;
            case R.id.fragment_save_place_new_order:
                getFragmentManager().popBackStackImmediate();
                break;
                default:
                    break;
        }
    }

    private Dialog dialog_add_address;
    private void addAddressDialog(){
        dialog_add_address= new Dialog(getContext());
        dialog_add_address.setContentView(R.layout.dialog_address);

        dialog_add_address.findViewById(R.id.dialog_address_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_add_address.dismiss();
            }
        });

        dialog_add_address.findViewById(R.id.dialog_address_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog_add_address.dismiss();
            }
        });
        dialog_add_address.setCancelable(false);
        dialog_add_address.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog_add_address.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
//        dialog_add_address.show();
    }

    private Dialog dialog_delete_item;
    private void createDeleteDialog(){
        dialog_delete_item = new Dialog(getContext());
        TextView txt_title, txt_content;
        dialog_delete_item.setContentView(R.layout.dialog_delete_item);

        dialog_delete_item.findViewById(R.id.dialog_del_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_delete_item.dismiss();
            }
        });

        dialog_delete_item.findViewById(R.id.dialog_del_clear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog_delete_item.dismiss();
            }
        });

        txt_content = dialog_delete_item.findViewById(R.id.dialog_del_txt_content);
        txt_title = dialog_delete_item.findViewById(R.id.dialog_del_txt_title);

        txt_content.setText(getResources().getString(R.string.dialog_add_address_content));
        txt_title.setText(getResources().getString(R.string.dialog_add_address_delete));
        dialog_delete_item.setCancelable(false);
        dialog_delete_item.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog_delete_item.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
//        dialog.show();

    }
}