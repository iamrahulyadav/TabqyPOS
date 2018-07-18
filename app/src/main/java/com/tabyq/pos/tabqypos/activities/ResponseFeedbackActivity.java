package com.tabyq.pos.tabqypos.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.tabyq.pos.tabqypos.R;

public class ResponseFeedbackActivity extends AppCompatActivity {
    private RecyclerView converRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response_feedback);

        init();

    }

    private void init(){
        converRecyclerView = findViewById(R.id.activity_response_conversation_recycler);
    }

    public void feedback_response_back(View view) {
        finish();
    }

}
