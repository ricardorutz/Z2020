package ar.com.rys.z2020.ui.gallery;

import androidx.annotation.DrawableRes;

public class Image {
    private String name;
    private int imageUrl;

    public Image(String name, int imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public int getImageUrl() {
        return imageUrl;
    }
}