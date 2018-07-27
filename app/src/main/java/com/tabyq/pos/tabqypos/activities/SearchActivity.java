package com.tabyq.pos.tabqypos.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.EditText;

import com.tabyq.pos.tabqypos.R;
import com.tabyq.pos.tabqypos.adapter.CustomerSearchAdapter;
import com.tabyq.pos.tabqypos.utils.AppBaseActivity;


public class SearchActivity extends AppBaseActivity implements CustomerSearchAdapter.SearchItemClick{

    private EditText edt_search;
    private RecyclerView searchRecycler;
    private String keyword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getSupportActionBar().hide();
        setContentView(R.layout.activity_search);

        init();

    }


    @SuppressLint("ClickableViewAccessibility")
    private void init(){
        searchRecycler = findViewById(R.id.activity_search_recycler);
        edt_search = findViewById(R.id.activity_search_edt);

        edt_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                keyword = s.toString().trim();
                if (keyword.length()>2){
                    edt_search.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_cross, 0);

                    edt_search.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View v, MotionEvent event) {
                            final int DRAWABLE_LEFT = 0;
                            final int DRAWABLE_TOP = 1;
                            final int DRAWABLE_RIGHT = 2;
                            final int DRAWABLE_BOTTOM = 3;

                            if(event.getAction() == MotionEvent.ACTION_UP) {
                                if(event.getRawX() >= (edt_search.getRight() - edt_search.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                                    // your action here
                                    edt_search.setText("");
                                    return true;
                                }
                            }
                            return false;
                        }
                    });


                    setAdapter();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        LinearLayoutManager horizontalLayoutManagaer
                = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        searchRecycler.setLayoutManager(horizontalLayoutManagaer);

    }

    private void setAdapter(){
        CustomerSearchAdapter customerSearchAdapter = new
                CustomerSearchAdapter(getApplicationContext(),this);
        searchRecycler.setAdapter(customerSearchAdapter);
    }

    public void crm_search(View view){
        finish();
    }

    @Override
    public void getSelected(int position) {
        finish();
    }
}
