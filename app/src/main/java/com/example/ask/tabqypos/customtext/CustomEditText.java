package com.example.ask.tabqypos.customtext;



import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;

import com.example.ask.tabqypos.R;


/**
 * Created by lenovo on 05/03/2018.
 */

public class CustomEditText extends android.support.v7.widget.AppCompatEditText {

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public CustomEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public CustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public CustomEditText(Context context) {
        super(context);
        init();
    }

    @SuppressLint("NewApi")
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Montserrat-Light.ttf");
        setTypeface(tf ,1);
        setTextColor(getContext().getResources().getColor(R.color.colorBlack));
        setTextSize(getContext().getResources().getDimension(R.dimen.extra_small_size));
        setBackground(getContext().getDrawable(R.drawable.edittext_bg));

    }
}
