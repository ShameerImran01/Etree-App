package com.shameer.etree.helperClass;

public class MostViewHelperClass {
    int image;
    static String title;
    static String description;

    public MostViewHelperClass(int image, String title, String description) {
        this.image = image;
        this.title = title;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public static String getTitle() {
        return title;
    }

    public static String getDescription() {
        return description;
    }


}