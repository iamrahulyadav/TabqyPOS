package com.tabyq.pos.tabqypos.activities;

import android.app.Dialog;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tabyq.pos.tabqypos.R;
import com.tabyq.pos.tabqypos.fragments.nav1.MainFragment;
import com.tabyq.pos.tabqypos.fragments.nav1.CharityFragment;
import com.tabyq.pos.tabqypos.fragments.nav1.OnlineFragment;
import com.tabyq.pos.tabqypos.fragments.nav1.OrderStatusFragment;
import com.tabyq.pos.tabqypos.fragments.nav1.TableFragment;
import com.tabyq.pos.tabqypos.fragments.nav1.WalkinFragment;
import com.tabyq.pos.tabqypos.fragments.nav2.CloseRegister;
import com.tabyq.pos.tabqypos.fragments.nav2.CustomerFragment;
import com.tabyq.pos.tabqypos.fragments.nav2.ItemsFragment;
import com.tabyq.pos.tabqypos.fragments.nav2.ReceiptsFragment;
import com.tabyq.pos.tabqypos.fragments.nav2.SettingsFragment;
import com.tabyq.pos.tabqypos.utils.SupportingWidgets;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        init();
    }

    private NavigationView navigationView;
    private LinearLayout layout_nav_items;
    public static RelativeLayout dashboardLayout, walkin_layoutLayout;
    private RelativeLayout crm_layout, table_layout, online_layout, charity_layout,
            order_status_layout;
    public static LinearLayout cv_main_right, cv_main_right_2;
    public static LinearLayout layout_top_middle;
    private TextView tv_add_note, tv_add_discount;

    private void init(){
        tv_add_note = findViewById(R.id.main_middle_btn_add_note);
        tv_add_discount = findViewById(R.id.main_middle_btn_add_discount);
        tv_add_note.setOnClickListener(this);
        tv_add_discount.setOnClickListener(this);

        layout_top_middle = findViewById(R.id.main_top_middle);
        cv_main_right = findViewById(R.id.main_card_view_right);
        cv_main_right_2 = findViewById(R.id.main_card_view_right_2);
        navigationView = findViewById(R.id.nav_view);
        layout_nav_items = findViewById(R.id.nav_items);

        dashboardLayout = findViewById(R.id.dashboard);
        walkin_layoutLayout = findViewById(R.id.walkin_layout);
        crm_layout = findViewById(R.id.crm_layout);
        table_layout = findViewById(R.id.table);
        online_layout = findViewById(R.id.online_layout);
        charity_layout = findViewById(R.id.charity);
        order_status_layout = findViewById(R.id.order_status);

        navigationView.setNavigationItemSelectedListener(this);
        addNoteDialog();
        addDiscoountDialog();
        createMyDailogPin();

        dashboardLayout.setBackgroundColor(getResources().getColor(R.color.colorDark));
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_main_bottom, new MainFragment()).commit();

    }


    private void setNavBacground(){
        dashboardLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        walkin_layoutLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        crm_layout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        table_layout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        online_layout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        charity_layout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        order_status_layout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.main_middle_btn_add_note){
            dialog_add_note.show();
        } else if(v.getId() == R.id.main_middle_btn_add_discount){
            dialog_add_discount.show();
        } else {

        }
    }

    private Dialog dialog_add_note, dialog_add_discount, dialog_pin;
    private void addNoteDialog(){
        dialog_add_note = new Dialog(MainActivity.this);
        dialog_add_note.setContentView(R.layout.dialog_add_note);

        dialog_add_note.findViewById(R.id.dialog_add_note_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_add_note.dismiss();
            }
        });

        dialog_add_note.findViewById(R.id.dialog_note_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog_add_note.dismiss();
            }
        });

        dialog_add_note.setCancelable(false);
        dialog_add_note.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog_add_note.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
//        dialog.show();
    }

    private void addDiscoountDialog(){
        dialog_add_discount = new Dialog(MainActivity.this);
        dialog_add_discount.setContentView(R.layout.dialog_add_discount);

        dialog_add_discount.findViewById(R.id.dialog_add_dis_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_add_discount.dismiss();
            }
        });

        dialog_add_discount.findViewById(R.id.dialog_discount_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog_add_discount.dismiss();
            }
        });
        dialog_add_discount.setCancelable(false);
        dialog_add_discount.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog_add_discount.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
//        dialog_add_discount.show();
    }

    private void createMyDailogPin(){
        dialog_pin = new Dialog(MainActivity.this);
        dialog_pin.setContentView(R.layout.dialog_pin);

        dialog_pin.setCancelable(true);
        dialog_pin.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog_pin.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
    }

    int flag = 1;
    public void menu_click(View view){
        if(flag == 1){
            navigationView.setVisibility(View.VISIBLE);
            layout_nav_items.setVisibility(View.GONE);
            flag = 0;
        } else{
            navigationView.setVisibility(View.GONE);
            layout_nav_items.setVisibility(View.VISIBLE);
            flag = 1;
        }
    }

    public void nav_click(View view){
        setNavBacground();
        switch (view.getId()){
            case R.id.dashboard:
                dashboardLayout.setBackgroundColor(getResources().getColor(R.color.colorDark));
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_main_bottom, new MainFragment()).commit();
//                cv_main_right.setVisibility(View.VISIBLE);
                break;

            case R.id.walkin_layout:
//                cv_main_right.setVisibility(View.GONE);
                walkin_layoutLayout.setBackgroundColor(getResources().getColor(R.color.colorDark));
                WalkinFragment fragment = new WalkinFragment();
                Bundle bundle = new Bundle();
                bundle.putString("nav_name", "Walkin");
                fragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_main_bottom, fragment).commit();
                break;

            case R.id.crm_layout:
                crm_layout.setBackgroundColor(getResources().getColor(R.color.colorDark));
                WalkinFragment fragment1 = new WalkinFragment();
                Bundle bundle1 = new Bundle();
                bundle1.putString("nav_name", "CRM");
                fragment1.setArguments(bundle1);
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_main_bottom, fragment1).commit();
                break;
            case R.id.table:
                table_layout.setBackgroundColor(getResources().getColor(R.color.colorDark));
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_main_bottom, new TableFragment()).commit();
                break;
            case R.id.online_layout:
                online_layout.setBackgroundColor(getResources().getColor(R.color.colorDark));
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_main_bottom, new OnlineFragment()).commit();
                break;
            case R.id.charity:
                charity_layout.setBackgroundColor(getResources().getColor(R.color.colorDark));
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_main_bottom, new CharityFragment()).commit();
                break;
            case R.id.order_status:
                order_status_layout.setBackgroundColor(getResources().getColor(R.color.colorDark));
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_main_bottom, new OrderStatusFragment()).commit();
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        switch (id){
            case R.id.nav_sales:
                break;
            case R.id.nav_receipts:
                new SupportingWidgets().callFragment(MainActivity.this, new ReceiptsFragment(),
                        getSupportFragmentManager(), R.id.frame_main_bottom, ReceiptsFragment.class.getName());
                break;
            case R.id.nav_item:
                new SupportingWidgets().callFragment(MainActivity.this, new ItemsFragment(),
                        getSupportFragmentManager(), R.id.frame_main_bottom, ItemsFragment.class.getName());
                break;
            case R.id.nav_edit:
                break;
            case R.id.nav_customer:
                new SupportingWidgets().callFragment(MainActivity.this, new CustomerFragment(),
                        getSupportFragmentManager(), R.id.frame_main_bottom, CustomerFragment.class.getName());
                break;
            case R.id.nav_close_register:
                new SupportingWidgets().callFragment(MainActivity.this, new CloseRegister(),
                        getSupportFragmentManager(), R.id.frame_main_bottom, CloseRegister.class.getName());
                break;
            case R.id.nav_feedback:
                dialog_pin.show();
                break;
            case R.id.nav_settings:
                new SupportingWidgets().callFragment(MainActivity.this, new SettingsFragment(),
                        getSupportFragmentManager(), R.id.frame_main_bottom, SettingsFragment.class.getName());
                break;
            case R.id.nav_support:
                break;
            default:
                break;
        }

        navigationView.setVisibility(View.GONE);
        layout_nav_items.setVisibility(View.VISIBLE);
        flag = 1;

        return true;
    }
}