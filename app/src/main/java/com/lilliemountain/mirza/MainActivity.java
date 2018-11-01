package com.lilliemountain.mirza;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.view.View;

import com.lilliemountain.mirza.ecommerce.ECommerceListActivity;
import com.lilliemountain.mirza.login.LoginListActivity;
import com.lilliemountain.mirza.profile.ProfileListActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setExitTransition(new Explode());
        }
        setContentView(R.layout.activity_main);
        findViewById(R.id.login).setOnClickListener(this);
        findViewById(R.id.profile).setOnClickListener(this);
        findViewById(R.id.others).setOnClickListener(this);
        findViewById(R.id.ecommerce).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.profile:
                startActivity(new Intent(MainActivity.this,ProfileListActivity.class));
                break;
            case R.id.login:
                startActivity(new Intent(MainActivity.this,LoginListActivity.class));
                break;
            case R.id.ecommerce:
                startActivity(new Intent(MainActivity.this,ECommerceListActivity.class));
                break;
        }
    }
}
