package com.lilliemountain.mirza.profile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.ScrollView;

import com.lilliemountain.mirza.R;

import java.util.ArrayList;
import java.util.List;

public class BlueCrayonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blue_crayon);
        RecyclerView bListView=findViewById(R.id.rec);
        List<Integer> list=new ArrayList<>();
        list.add(R.drawable.courtnietosana);
        list.add(R.drawable.johnwestrock);
        list.add(R.drawable.photo15);
        list.add(R.drawable.photo154);
        bListView.setLayoutManager(new LinearLayoutManager(this));
        bListView.setAdapter(new BlueCrayonAdapter(list));
        ScrollView scrollView=findViewById(R.id.sccs);
        scrollView.smoothScrollTo(0,0);
    };
}
