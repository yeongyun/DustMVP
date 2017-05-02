package com.y.md.dustmvp.data;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by prompt32 on 2017-05-01.
 */

public class Dust {
    private String measureDate;
    private String location;
    private String measureLocation;
    private int microDust = 0;
    private int ultraMicroDust = 0;
    private float O3 = 0;
    private float NO2 = 0;
    private float CO = 0;
    private float SO2 = 0;
    private String envRating;
    private int envIndex = 0;
    private String material;

    private String id = "";


    public String getId() {
        return id;
    }

    private ArrayList<String> images = null;

    private String[] imageUrls = {
            "http://cdn.wonderfulengineering.com/wp-content/uploads/2014/03/high-resolution-wallpapers-25.jpg",
            "http://cdn.wallpapersafari.com/30/74/1LpNJ6.jpg",
            "http://cdn.wallpapersafari.com/71/66/IUVN5F.jpg",
            "https://www.w3schools.com/css/trolltunga.jpg",
            "https://s3-us-west-1.amazonaws.com/powr/defaults/image-slider2.jpg",
            "https://www.smashingmagazine.com/wp-content/uploads/2015/06/10-dithering-opt.jpg",
            "http://beebom.com/wp-content/uploads/2016/01/Reverse-Image-Search-Engines-Apps-And-Its-Uses-2016.jpg",
            "https://www.w3schools.com/css/img_forest.jpg",
            "http://www.menucool.com/slider/jsImgSlider/images/image-slider-2.jpg"};

    public Dust() {
        images = new ArrayList<>();
        Random random = new Random();
        int length = random.nextInt(10) + 1;
        for (int i=0; i<length; i++) {
            int randoms = random.nextInt(imageUrls.length);
            images.add(imageUrls[randoms]);
        }
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public String getMeasureDate() {
        return measureDate;
    }

    public void setMeasureDate(String measureDate) {
        this.measureDate = measureDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMeasureLocation() {
        return measureLocation;
    }

    public void setMeasureLocation(String measureLocation) {
        this.measureLocation = measureLocation;
    }

    public int getMicroDust() {
        return microDust;
    }

    public void setMicroDust(int microDust) {
        this.microDust = microDust;
    }

    public int getUltraMicroDust() {
        return ultraMicroDust;
    }

    public void setUltraMicroDust(int ultraMicroDust) {
        this.ultraMicroDust = ultraMicroDust;
    }

    public float getO3() {
        return O3;
    }

    public void setO3(float o3) {
        O3 = o3;
    }

    public float getNO2() {
        return NO2;
    }

    public void setNO2(float NO2) {
        this.NO2 = NO2;
    }

    public float getCO() {
        return CO;
    }

    public void setCO(float CO) {
        this.CO = CO;
    }

    public float getSO2() {
        return SO2;
    }

    public void setSO2(float SO2) {
        this.SO2 = SO2;
    }

    public String getEnvRating() {
        return envRating;
    }

    public void setEnvRating(String envRating) {
        this.envRating = envRating;
    }

    public int getEnvIndex() {
        return envIndex;
    }

    public void setEnvIndex(int envIndex) {
        this.envIndex = envIndex;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
