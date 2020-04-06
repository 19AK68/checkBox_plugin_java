package com.ak.custom_check_box;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final CustomCheckbox checkBox = (CustomCheckbox) findViewById(R.id.custom_CB2);


        Button button = (Button) findViewById(R.id.button1);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkBox.setTextColor(Color.RED);
//                checkBox.mySetColor(0xffFFFF00);
                checkBox.mySetCheckBoxSize(100, 100);
                checkBox.mySetLayoutDirectionLeft();


            }
        });
    }
}

// custom checkBox
class CustomCheckbox extends androidx.appcompat.widget.AppCompatCheckBox {
    CustomCheckbox customCheckbox = (CustomCheckbox) findViewById(R.id.custom_CB2);
    Drawable tempDrawable = getResources().getDrawable(R.drawable.checked_custom).mutate();
    LayerDrawable bubble = (LayerDrawable) tempDrawable.mutate();
    GradientDrawable solidColor = (GradientDrawable) bubble.findDrawableByLayerId(R.id.shapeChecked).mutate();

    public CustomCheckbox(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
    }


    public CustomCheckbox(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CustomCheckbox(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {


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
        customCheckbox.setButtonDrawable(tempDrawable);
    }

    public void mySetColor(int intNewColorPos) {


        // text

        //#a2c435  A4C639
        // box
//        CustomCheckbox customCheckbox = (CustomCheckbox) findViewById(R.id.custom_CB2);
//        Drawable tempDrawable = getResources().getDrawable(R.drawable.checked_custom).mutate();
//        LayerDrawable bubble = (LayerDrawable) tempDrawable.mutate();
//
//
//        GradientDrawable solidColor = (GradientDrawable) bubble.findDrawableByLayerId(R.id.shapeChecked).mutate();


        //0xFF4c1bb5
        if (customCheckbox.isChecked()) {
            solidColor.setColor(intNewColorPos);
            customCheckbox.setButtonDrawable(tempDrawable);

        } else {
            solidColor.setColor(0xFFffffff);
            customCheckbox.setButtonDrawable(tempDrawable);
        }


    }
}
