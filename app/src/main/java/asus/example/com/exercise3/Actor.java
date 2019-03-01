package asus.example.com.exercise3;

import android.net.Uri;


class Actor {

    private String name;
    private Uri smallImage;
    private Uri largeImage;
    private String description;

    Actor(String name, Uri smallImage, Uri largeImage, String description){
        this.name = name;
        this.smallImage = smallImage;
        this.largeImage = largeImage;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    Uri getSmallImage() {
        return smallImage;
    }

    Uri getLargeImage() {
        return largeImage;
    }

    public String getDescription() {
        return description;
    }
}
