package com.lilliemountain.mirza.login;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.lilliemountain.mirza.R;
import com.lilliemountain.mirza.profile.BlueCrayonActivity;
import com.lilliemountain.mirza.profile.R2D2Activity;
import com.lilliemountain.mirza.profile.SubjectActivity;

import java.util.ArrayList;
import java.util.List;

public class LoginListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setExitTransition(new Explode());
            getWindow().setEnterTransition(new Explode());
        }

        setContentView(R.layout.activity_login_list);
        ListView listView=findViewById(R.id.listy);
        List<String> names=new ArrayList<>();
        names.add("Pinterest");
        ArrayAdapter<String> namesAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,names);
        listView.setAdapter(namesAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 0:
                        startActivity(new Intent(LoginListActivity.this,PinterestActivity.class));
                        break;

                }
            }
        });
    }
}
