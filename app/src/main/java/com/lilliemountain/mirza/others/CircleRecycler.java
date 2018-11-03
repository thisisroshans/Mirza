package com.lilliemountain.mirza.others;



public class CircleRecycler {
    String title,subtitle;
    int color,photo;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public CircleRecycler(String title, String subtitle, int color, int photo) {

        this.title = title;
        this.subtitle = subtitle;
        this.color = color;
        this.photo = photo;
    }
}
