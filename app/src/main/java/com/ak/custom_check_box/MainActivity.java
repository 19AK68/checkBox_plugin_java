package com.ak.custom_check_box;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final CustomCheckBox checkBox = (CustomCheckBox) findViewById(R.id.custom_CB2);


        Button button = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkBox.setTextColor(Color.BLACK);
                checkBox.mySetCheckBoxSize(50);
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkBox.setTextColor(Color.RED);
                checkBox.mySetCheckBoxSize(200);
//                checkBox.mySetColor(0xffFFFF00);
                //checkBox.mySetCheckBoxSize(150);
               // checkBox.mySetLayoutDirectionLeft();


            }
        });
    }
}

// custom checkBox
