package com.tabyq.pos.tabqypos.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.tabyq.pos.tabqypos.R;
import com.tabyq.pos.tabqypos.utils.AppBaseActivity;

public class TransSucess extends AppBaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trans_sucess);
    }

    public void trans_success_back(View view){
        finish();
    }


}
