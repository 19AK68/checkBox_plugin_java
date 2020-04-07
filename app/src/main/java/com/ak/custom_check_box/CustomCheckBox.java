package com.ak.custom_check_box;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;

public class CustomCheckBox extends androidx.appcompat.widget.AppCompatCheckBox {
    //CustomCheckBox customCheckbox = (CustomCheckBox) findViewById(R.id.custom_CB2);
    Drawable tempDrawable = getResources().getDrawable(R.drawable.checked_custom).mutate();
    LayerDrawable bubble = (LayerDrawable) tempDrawable.mutate();
    GradientDrawable solidColor = (GradientDrawable) bubble.findDrawableByLayerId(R.id.shapeChecked).mutate();

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


        //mySetColor(0xffFFFF00);
        this.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mySetColor(0xFF1c1bb5);

            }
        });


    }

    public void mySetLayoutDirectionLeft() {
        this.setLayoutDirection(LAYOUT_DIRECTION_RTL);
    }

    public void mySetCheckBoxSize(int w, int h) {


        solidColor.setSize(w, h);
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
}


