package com.lilliemountain.mirza.ecommerce;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.gaurav.gesto.OnGestureListener;
import com.lilliemountain.mirza.R;

import java.util.ArrayList;
import java.util.List;

public class OjasmeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    String[] strings = {"XS", "S", "M", "L"};
    ArrayAdapter<String> stringArrayAdapter;
    ImageView top, bottom,imageView;
    LinearLayout ges;
    DrawerLayout drawer;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        getWindow().setExitTransition(new Explode());
        setContentView(R.layout.activity_ojasme);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawableList.add(R.drawable.ojs1);
        drawableList.add(R.drawable.ojs2);
        drawableList.add(R.drawable.ojs3);
        stringArrayAdapter = new ArrayAdapter<>(this, R.layout.ojasme_spinner, strings);
        Spinner spinner = findViewById(R.id.spinner2);
        stringArrayAdapter.setDropDownViewResource(R.layout.ojasme_spinner);
        spinner.setAdapter(stringArrayAdapter);

        top = findViewById(R.id.top);
        bottom = findViewById(R.id.bottom);
        ges = findViewById(R.id.ges);

        top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(OjasmeActivity.this, (View)top, "top");
                startActivity(new Intent(OjasmeActivity.this,OjasmeSliderActivity.class), options.toBundle());

            }
        });
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        toggle.setDrawerIndicatorEnabled(false);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        bottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNextImage();
            }
        });
        Glide.with(this).load(R.drawable.ojs2).transition(DrawableTransitionOptions.withCrossFade()).into(bottom);
        Glide.with(this).load(R.drawable.ojs1).transition(DrawableTransitionOptions.withCrossFade()).into(top);

        ges.setOnTouchListener(new OnGestureListener(this) {
                                   @Override
                                   public void onSwipeRight() {
                                       super.onSwipeRight();
                                       Log.e("onSwipeRight: ", "right");
                                       drawer.openDrawer(Gravity.END);
                                   }

                                   @Override
                                   public void onSwipeLeft() {
                                       super.onSwipeLeft();
                                       //todo
                                   }

                                   @Override
                                   public void onSwipeTop() {
                                       super.onSwipeTop();
                                       //todo
                                   }

                                   @Override
                                   public void onSwipeBottom() {
                                       super.onSwipeBottom();
                                       //todo
                                   }

                                   @Override
                                   public void onClick() {
                                       super.onClick();
                                       //todo
                                   }

                                   @Override
                                   public void onDoubleClick() {
                                       super.onDoubleClick();
                                       //todo
                                   }

                                   @Override
                                   public void onLongClick() {
                                       super.onLongClick();
                                       //todo
                                   }
                               }
        );
        findViewById(R.id.button8).setOnTouchListener(new OnGestureListener(this) {
          @Override
          public void onSwipeRight() {
              super.onSwipeRight();
          }

          @Override
          public void onSwipeLeft() {
              super.onSwipeLeft();
              drawer.closeDrawer(Gravity.END);
          }

          @Override
          public void onSwipeTop() {
              super.onSwipeTop();
              //todo
          }

          @Override
          public void onSwipeBottom() {
              super.onSwipeBottom();
              //todo
          }

          @Override
          public void onClick() {
              super.onClick();
              //todo
          }

          @Override
          public void onDoubleClick() {
              super.onDoubleClick();
              drawer.closeDrawer(Gravity.END);
          }

          @Override
          public void onLongClick() {
              super.onLongClick();
              //todo
          }
      }
        );
        imageView=findViewById(R.id.imageView14);
        findViewById(R.id.imageView14).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(OjasmeActivity.this, (View)imageView, "imageview");
                startActivity(new Intent(OjasmeActivity.this,OjasmeFavouriteActivity.class), options.toBundle());
            }
        });
    }

    List<Integer> drawableList = new ArrayList<>();
    private int count = 0;

    public void showNextImage() {
        count++;
        if (count % 2 == 0) {

            Glide.with(this).load(R.drawable.ojs1).transition(DrawableTransitionOptions.withCrossFade()).into(top);
            Glide.with(this).load(R.drawable.ojs2).transition(DrawableTransitionOptions.withCrossFade()).into(bottom);
        } else {
            Glide.with(this).load(R.drawable.ojs1).transition(DrawableTransitionOptions.withCrossFade()).into(bottom);
            Glide.with(this).load(R.drawable.ojs2).transition(DrawableTransitionOptions.withCrossFade()).into(top);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.ojasme, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}