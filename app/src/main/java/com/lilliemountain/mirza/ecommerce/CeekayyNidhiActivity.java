package com.lilliemountain.mirza.ecommerce;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.lilliemountain.mirza.R;

public class CeekayyNidhiActivity extends AppCompatActivity {
    TextView textView35;
    RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ceekayy_nidhi);
        textView35=findViewById(R.id.textView35);
        radioGroup=findViewById(R.id.radioGroup);
        findViewById(R.id.floatingActionButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"Item added to Cart",Snackbar.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.button7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"Buy now!",Snackbar.LENGTH_SHORT).show();
            }
        });
        String colorNameArray[]={"Black","Blue","Amber","Pink"};
        int colorArray[]={Color.parseColor("#000000"),
                Color.parseColor("#005ca9"),
                Color.parseColor("#FBC02D"),
                Color.parseColor("#ed23fc")
        };
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId)
                {
                    case R.id.black:
                        textView35.setText(colorNameArray[0]);
                        textView35.setTextColor(colorArray[0]);
                        break;
                    case R.id.blu:
                        textView35.setText(colorNameArray[1]);
                        textView35.setTextColor(colorArray[1]);
                        break;
                    case R.id.amb:
                        textView35.setText(colorNameArray[2]);
                        textView35.setTextColor(colorArray[2]);
                        break;
                    case R.id.pink:
                        textView35.setText(colorNameArray[3]);
                        textView35.setTextColor(colorArray[3]);
                        break;
                }
            }
        });
    }
}
