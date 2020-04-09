package com.ak.custom_check_box;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.CompoundButton;

import androidx.core.content.ContextCompat;

public class CustomCheckBox extends androidx.appcompat.widget.AppCompatCheckBox {
    CustomCheckBox customCheckbox = (CustomCheckBox) findViewById(R.id.custom_CB2);
    Drawable tempDrawable = getResources().getDrawable(R.drawable.checked_custom).mutate();
    LayerDrawable bubble = (LayerDrawable) tempDrawable.mutate();
    GradientDrawable solidColor = (GradientDrawable) bubble.findDrawableByLayerId(R.id.shapeChecked).mutate();
    //GradientDrawable solidColor2 = (GradientDrawable) bubble.findDrawableByLayerId(R.id.shapeCheckedItem2).mutate();
    GradientDrawable solidColor2 = (GradientDrawable) bubble.findDrawableByLayerId(R.id.shapeChecked2).mutate();

    int SIZE_XML_ITEM = 24;
    int STROKE_DEFAULT_WIDTH = 4;
    int STROKE2_DEFAULT_WIDTH = 2;
    int unCheckedColor = 0;
    int unCheckedColor2 = 0;


    public CustomCheckBox(Context context) {
        super(context);
        init();
    }


    public CustomCheckBox(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomCheckBox(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        this.setButtonDrawable(tempDrawable);


        //mySetColor(0xffFFFF00);
        this.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mySetColor(0xFF4285f5);

            }
        });


    }

    public void mySetLayoutDirectionLeft() {
        this.setLayoutDirection(LAYOUT_DIRECTION_RTL);
    }


    public void mySetCheckBoxSize(int size) {

        //color
        solidColor.setSize(size, size);

        int factor = size / SIZE_XML_ITEM;
        // get color stroke item 1 and item2
        unCheckedColor = ContextCompat.getColor(getContext(), R.color.unCheckedStrokeOne);
        unCheckedColor2 = ContextCompat.getColor(getContext(), R.color.unCheckedStrokeTwo);

        // set width and color item 1 and item2
        solidColor.setStroke(STROKE_DEFAULT_WIDTH * factor, unCheckedColor);
        solidColor2.setStroke(STROKE2_DEFAULT_WIDTH * factor, unCheckedColor2);
        this.setButtonDrawable(tempDrawable);
    }

    public void mySetColor(int intNewColorPos) {


        if (this.isChecked()) {
            solidColor.setColor(intNewColorPos);
            this.setButtonDrawable(tempDrawable);


        } else {
            solidColor.setColor(0xFFffffff);
            this.setButtonDrawable(tempDrawable);
        }


    }

    //Utils
    public static int dpToPx(float dp, Context context) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }

    public static int spToPx(float sp, Context context) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, context.getResources().getDisplayMetrics());
    }

    public static int dpToSp(float dp, Context context) {
        return (int) (dpToPx(dp, context) / context.getResources().getDisplayMetrics().scaledDensity);
    }

    public static float pxToSp(float px, Context context) {
        return (float) px / context.getResources().getDisplayMetrics().scaledDensity;
    }

}


