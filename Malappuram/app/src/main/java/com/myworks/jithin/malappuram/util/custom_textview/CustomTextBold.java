package com.myworks.jithin.malappuram.util.custom_textview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by jithin on 23/4/17.
 */

public class CustomTextBold extends android.support.v7.widget.AppCompatTextView {

    public CustomTextBold(Context context) {
        super(context);

        applyCustomFont(context);
    }

    public CustomTextBold(Context context, AttributeSet attrs) {
        super(context, attrs);

        applyCustomFont(context);
    }

    public CustomTextBold(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        applyCustomFont(context);
    }

    private void applyCustomFont(Context context) {
        Typeface customFont = FontCache.getTypeface("aller_bold.ttf", context);
        setTypeface(customFont);
    }
}
