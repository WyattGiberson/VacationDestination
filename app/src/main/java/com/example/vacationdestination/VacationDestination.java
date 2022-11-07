package com.example.vacationdestination;

public class VacationDestination {
    private String placeName;
    private int imageId;

    public VacationDestination(String n, int id) {
        placeName = n;
        imageId = id;
    }

    public String getName(){
        return placeName;
    }

    public int getImageId(){
        return imageId;
    }
}
