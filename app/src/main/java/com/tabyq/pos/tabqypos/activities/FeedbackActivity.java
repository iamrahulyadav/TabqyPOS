package com.tabyq.pos.tabqypos.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.tabyq.pos.tabqypos.R;
import com.tabyq.pos.tabqypos.adapter.AdapterItemFeedback;
import com.tabyq.pos.tabqypos.adapter.AdapterOnlineNewOrders;
import com.tabyq.pos.tabqypos.utils.CustomLayoutManager;

public class FeedbackActivity extends AppCompatActivity implements View.OnClickListener, AdapterItemFeedback.AdapterFeedbackInterface{
    private RecyclerView feedbackListRecyclerView;
    private LinearLayout layout_all, layout_happy, layout_surprised, layout_sad;
    private AdapterItemFeedback adapterItemFeedback;
    private int size=4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        init();
        setListener();

    }

    private void init(){
        feedbackListRecyclerView = findViewById(R.id.activity_feedback_recycler);
        layout_all = findViewById(R.id.activity_feedback_all_layout);
        layout_happy = findViewById(R.id.activity_feedback_happy_layout);
        layout_surprised = findViewById(R.id.activity_feedback_surprised_layout);
        layout_sad = findViewById(R.id.activity_feedback_sad_layout);


        CustomLayoutManager manager = new CustomLayoutManager(getApplicationContext()){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };

        feedbackListRecyclerView.setLayoutManager(manager);
        setAdapter();
    }

    private void setAdapter(){
        adapterItemFeedback = new AdapterItemFeedback(size,this);
        feedbackListRecyclerView.setAdapter(adapterItemFeedback);

    }

    private void setListener(){
        layout_surprised.setOnClickListener(this);
        layout_happy.setOnClickListener(this);
        layout_sad.setOnClickListener(this);
        layout_all.setOnClickListener(this);

    }
    public void feedback_back(View view){

        finish();
    }

    @Override
    public void onClick(View v) {
        setTopBackground();
        switch (v.getId()){
            case R.id.activity_feedback_all_layout:
                layout_all.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                size=4;
                setAdapter();
                break;
            case R.id.activity_feedback_happy_layout:
                layout_happy.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                size=1;
                setAdapter();
                break;
            case R.id.activity_feedback_sad_layout:
                layout_sad.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                size=2;
                setAdapter();
                break;
            case R.id.activity_feedback_surprised_layout:
                size=5;
                setAdapter();
                layout_surprised.setBackgroundColor(getResources().getColor(R.color.colorWhite));

                break;
        }
    }

    private void setTopBackground(){
        layout_all.setBackgroundColor(getResources().getColor(R.color.background));
        layout_sad.setBackgroundColor(getResources().getColor(R.color.background));
        layout_surprised.setBackgroundColor(getResources().getColor(R.color.background));
        layout_happy.setBackgroundColor(getResources().getColor(R.color.background));
    }

    @Override
    public void viewComment(int pos) {
        startActivity(new Intent(FeedbackActivity.this, ResponseFeedbackActivity.class));
    }
}
