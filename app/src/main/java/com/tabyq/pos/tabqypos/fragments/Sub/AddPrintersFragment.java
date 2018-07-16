package com.tabyq.pos.tabqypos.fragments.Sub;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.tabyq.pos.tabqypos.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddPrintersFragment extends Fragment implements View.OnClickListener {

    public AddPrintersFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_printers, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        init();
    }

    private LinearLayout btn_save;

    private void init(){
        btn_save = getView().findViewById(R.id.fragment_add_printers_btn_save);
        btn_save.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        int id = v.getId();
        if(id == R.id.fragment_add_printers_btn_save){
            getActivity().getSupportFragmentManager().popBackStackImmediate();
        } else {

        }
    }
}
