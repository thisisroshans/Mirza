package com.lilliemountain.mirza.ecommerce;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.lilliemountain.mirza.R;

import java.util.ArrayList;
import java.util.List;

public class ECommerceListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setExitTransition(new Explode());
            getWindow().setEnterTransition(new Explode());
        }
        setContentView(R.layout.activity_ecommerce_list);
        ListView listView=findViewById(R.id.listy);
        List<String> names=new ArrayList<>();
        names.add("wonderwheelstore");
        names.add("theceekayy");
        names.add("Ojasmé");
        ArrayAdapter<String> namesAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,names);
        listView.setAdapter(namesAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 0:
                        startActivity(new Intent(ECommerceListActivity.this,WonderWheelStoreActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(ECommerceListActivity.this,CeekayyNidhiActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(ECommerceListActivity.this,OjasmeActivity.class));
                        break;

                }
            }
        });
    }
}
