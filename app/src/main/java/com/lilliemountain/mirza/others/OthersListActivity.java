package com.lilliemountain.mirza.others;

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
import com.lilliemountain.mirza.login.BotLoginActivity;
import com.lilliemountain.mirza.login.PinterestActivity;
import com.lilliemountain.mirza.login.SignUpActivity;

import java.util.ArrayList;
import java.util.List;

public class OthersListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setExitTransition(new Explode());
            getWindow().setEnterTransition(new Explode());
        }

        setContentView(R.layout.activity_others_list);
        ListView listView=findViewById(R.id.listy);
        List<String> names=new ArrayList<>();
        names.add("RecyclerView");
        names.add("CircleRecyclerView");
        ArrayAdapter<String> namesAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,names);
        listView.setAdapter(namesAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 0:
                        startActivity(new Intent(OthersListActivity.this,RecyclerViewActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(OthersListActivity.this,CircleRecyclerViewActivity.class));
                        break;
                }
            }
        });
    }
}
