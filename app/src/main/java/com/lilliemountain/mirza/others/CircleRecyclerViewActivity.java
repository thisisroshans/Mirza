package com.lilliemountain.mirza.others;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lilliemountain.mirza.R;

import java.util.ArrayList;
import java.util.List;

public class CircleRecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        RecyclerView recyclerView=findViewById(R.id.rec);
        List<CircleRecycler> list=new ArrayList<>();
        for(int i=0;i>3;i++)
        {
            list.add(new CircleRecycler("Mother's Day Special -MAA ",
                    "By Sanish Nair - Harsh Entertainment",
                    android.R.color.holo_blue_bright,
                    R.drawable.ma));
            list.add(new CircleRecycler("Hierath - The Short Film",
                    "Harsh Entertainment",
                    android.R.color.holo_orange_light,
                    R.drawable.heirath));
            list.add(new CircleRecycler("The Curse",
                    "A Short Film with a Social Message",
                    android.R.color.holo_purple,
                    R.drawable.curse));
        }

        recyclerView.setLayoutManager(new CircleLayoutManager(this));
        recyclerView.setAdapter(new CircleRecyclerViewAdapter(this,list));

    }

}
