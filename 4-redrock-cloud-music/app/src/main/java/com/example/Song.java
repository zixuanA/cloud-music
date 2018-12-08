package com.example;

public class Song {
    private String name;
    private int imageId;
    private String number;

    public Song(String name,String number,int imageId){
        this.name = name;
        this.imageId = imageId;
        this.number = "共"+number+"首";
    }

    public String getName(){
        return name;
    }

    public int getImageId(){
        return imageId;
    }
    public String getNumber(){
        return number;
    }
}
