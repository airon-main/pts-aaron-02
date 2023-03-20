package com.example.aironnews;

public class News {
    private String Name ;
    private String Description ;
    private String Time ;
    private int Images;

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public int getImages() {
        return Images;
    }

    public void setImages(int images) {
        Images = images;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
