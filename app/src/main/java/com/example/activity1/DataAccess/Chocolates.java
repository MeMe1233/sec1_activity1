package com.example.activity1.DataAccess;

import androidx.annotation.NonNull;

public class Chocolates {

    private String name;
    private double price;

    public Chocolates(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //the listView or spinner call the toString to show in the app
    @NonNull
    @Override
    public String toString() {
        return name + " , price : " + price;
    }
}
