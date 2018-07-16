package com.example.ask.tabqypos.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.ask.tabqypos.R;

public class TransSucess extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trans_sucess);


    }

    public void trans_success_back(View view){

        finish();
    }
}
