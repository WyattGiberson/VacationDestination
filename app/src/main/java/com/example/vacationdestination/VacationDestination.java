package com.example.vacationdestination;

public class VacationDestination {
    private String placeName;
    private int imageId;
    private boolean favorite;

    public VacationDestination(String n, int id, boolean f) {
        placeName = n;
        imageId = id;
        favorite = f;
    }

    public String getName(){
        return placeName;
    }

    public int getImageId(){
        return imageId;
    }

    public boolean isFavorite() {return favorite;}

    public void setFavorite(boolean f){favorite = f;}
}
