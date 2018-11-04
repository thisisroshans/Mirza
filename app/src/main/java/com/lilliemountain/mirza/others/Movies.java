package com.lilliemountain.mirza.others;

import android.graphics.Movie;
import android.os.Parcel;
import android.os.Parcelable;

public class Movies implements Parcelable {
    String movieName,directorName,year;
    double rating1,rating2;
    int photo;

    public Movies(String movieName, String directorName, String year, double rating1, double rating2, int photo) {
        this.movieName = movieName;
        this.directorName = directorName;
        this.year = year;
        this.rating1 = rating1;
        this.rating2 = rating2;
        this.photo = photo;
    }

    protected Movies(Parcel in) {
        movieName = in.readString();
        directorName = in.readString();
        year = in.readString();
        rating1 = in.readDouble();
        rating2 = in.readDouble();
        photo = in.readInt();
    }

    public static final Creator<Movies> CREATOR = new Creator<Movies>() {
        @Override
        public Movies createFromParcel(Parcel in) {
            return new Movies(in);
        }

        @Override
        public Movies[] newArray(int size) {
            return new Movies[size];
        }
    };

    public int getPhoto() {

        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public double getRating1() {
        return rating1;
    }

    public void setRating1(double rating1) {
        this.rating1 = rating1;
    }

    public double getRating2() {
        return rating2;
    }

    public void setRating2(double rating2) {
        this.rating2 = rating2;
    }

    public Movies(String movieName, String directorName, String year, double rating1, double rating2) {

        this.movieName = movieName;
        this.directorName = directorName;
        this.year = year;
        this.rating1 = rating1;
        this.rating2 = rating2;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(movieName);
        dest.writeString(directorName);
        dest.writeString(year);
        dest.writeDouble(rating1);
        dest.writeDouble(rating2);
        dest.writeInt(photo);
    }

}
