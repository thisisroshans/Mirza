package com.lilliemountain.mirza.others;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.lilliemountain.mirza.R;

public class MovieDetailActivity extends AppCompatActivity {
    TextView name1,name2,year,rating1,director;
    ImageView imageView;
    RatingBar ratingBar;
    @android.support.annotation.RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        getWindow().setExitTransition(new AutoTransition());
        setContentView(R.layout.activity_movie_detail);
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        Movies movies=bundle.getParcelable("movie");
        name1=findViewById(R.id.movieTitle1);
        name2=findViewById(R.id.movieTitle2);
        year=findViewById(R.id.movieYear);
        rating1=findViewById(R.id.rating1);
        director=findViewById(R.id.director);
        imageView=findViewById(R.id.poster);
        ratingBar=findViewById(R.id.rating2);

        name1.setText(movies.getMovieName());
        name2.setText(movies.getMovieName());
        rating1.setText(String.valueOf(movies.getRating1()));
        year.setText(movies.getYear());
        director.setText(movies.getDirectorName());
        imageView.setBackgroundResource(movies.getPhoto());
        ratingBar.setRating((float)movies.getRating2());


        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
    @Override
    public void onBackPressed() {
        supportFinishAfterTransition();
    }
}
