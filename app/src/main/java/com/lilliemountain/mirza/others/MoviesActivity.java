package com.lilliemountain.mirza.others;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.AutoTransition;
import android.transition.Explode;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.lilliemountain.mirza.R;

import java.util.ArrayList;
import java.util.List;

public class MoviesActivity extends AppCompatActivity {

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        getWindow().setExitTransition(new AutoTransition());
        setContentView(R.layout.activity_movies);
        List<Movies> movies=new ArrayList<>();
        movies.add(new Movies("Thugs of Hindostan",
                "Director |  Vijay Krishna Acharya",
                "2018", 4.7,
                5.2,
                R.drawable.toh
        ));
        movies.add(new Movies("Venom",
                "Director |  Ruben Fleischer",
                "2018", 3.5,
                9.5,
                R.drawable.venom
        ));
        movies.add(new Movies("Titanic",
                "Director |  James Cameron",
                "1997", 4.5,
                7.8,
                R.drawable.titanic
        ));
        movies.add(new Movies("Avatar",
                "Director |  James Cameron",
                "2009", 4.4,
                7.8,
                R.drawable.av
        ));
        movies.add(new Movies("A Star is Born",
                "Director |  Bradley Cooper",
                "2018", 4.9,
                8.3,
                R.drawable.asib
        ));
        movies.add(new Movies("First Man",
                "Director |  Damien Chazelle",
                "2018", 4.4,
                7.7,
                R.drawable.fm
        ));
         recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MoviesAdapter(movies));
    }
    RecyclerView recyclerView;

}
