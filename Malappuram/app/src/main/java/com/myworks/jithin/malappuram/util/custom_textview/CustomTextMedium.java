package com.myworks.jithin.malappuram.util.custom_textview;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

/**
 * Created by jithin on 23/4/17.
 */
public class CustomTextMedium extends android.support.v7.widget.AppCompatTextView {

    public CustomTextMedium(Context context) {
        super(context);

        applyCustomFont(context);
    }

    public CustomTextMedium(Context context, AttributeSet attrs) {
        super(context, attrs);

        applyCustomFont(context);
    }

    public CustomTextMedium(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        applyCustomFont(context);
    }

    private void applyCustomFont(Context context) {
        Typeface customFont = FontCache.getTypeface("aller_medium.ttf", context);
        setTypeface(customFont);
    }
}
