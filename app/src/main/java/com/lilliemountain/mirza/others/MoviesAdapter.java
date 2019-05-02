package com.lilliemountain.mirza.others;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.lilliemountain.mirza.R;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesHolder> {
    List<Movies> moviesList;
    public MoviesAdapter(    List<Movies> moviesList ){
        this.moviesList=moviesList;
    }
    @NonNull
    @Override
    public MoviesHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_movies,viewGroup,false);
        return new MoviesHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesHolder moviesHolder, int i) {
            moviesHolder.directorName.setText(moviesList.get(i).getDirectorName());
            moviesHolder.movieName.setText(moviesList.get(i).getMovieName());
            moviesHolder.rating2.setText(String.valueOf(moviesList.get(i).getRating2()));
            moviesHolder.year.setText(moviesList.get(i).getYear());
            moviesHolder.photo.setBackgroundResource(moviesList.get(i).getPhoto());
            moviesHolder.photo.setTag(moviesList.get(i).getPhoto());
            moviesHolder.ratingBar.setRating((float) moviesList.get(i).getRating1());
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public class MoviesHolder  extends RecyclerView.ViewHolder {
        TextView directorName,movieName,rating2,year;
        ImageView photo;
        RatingBar ratingBar;
        public MoviesHolder(@NonNull View itemView) {
            super(itemView);
            directorName=itemView.findViewById(R.id.director);
            movieName=itemView.findViewById(R.id.movieName);
            year=itemView.findViewById(R.id.year);
            rating2=itemView.findViewById(R.id.rating1);
            photo=itemView.findViewById(R.id.image);
            ratingBar=itemView.findViewById(R.id.rating2);
            itemView.setOnClickListener(new View.OnClickListener() {
                @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), MovieDetailActivity.class);

                    Bundle bundle= new Bundle();
                    Movies movies=new Movies(
                            movieName.getText().toString(),
                            directorName.getText().toString(),
                            year.getText().toString(),
                            Double.valueOf(rating2.getText().toString()),
                            ratingBar.getRating(),
                            Integer.parseInt(photo.getTag().toString()));
                    bundle.putParcelable("movie",movies);
                    intent.putExtras(bundle);
                    Activity activity=(Activity)v.getContext();
                    Pair<View, String> p1 = Pair.create((View) photo, "poster");
                    Pair<View, String> p2 = Pair.create((View) movieName, "movie");
                    Pair<View, String> p3 = Pair.create((View) directorName, "director");
                    Pair<View, String> p4 = Pair.create((View) ratingBar, "rating1");
                    Pair<View, String> p5 = Pair.create((View) rating2, "rating2");
                    Pair<View, String> p6 = Pair.create((View) year, "year");

                    ActivityOptionsCompat options = ActivityOptionsCompat.
                            makeSceneTransitionAnimation(activity, p1, p2, p3, p4, p5,p6);

                    v.getContext().startActivity(intent, options.toBundle());

                }
            });
        }
    }
}
