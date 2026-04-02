package com.example.activity1.DataAccess;

import java.util.ArrayList;
import java.util.List;

public class ChocolatesDA {
    private List<Chocolates> CH = new ArrayList<Chocolates>();

    public ChocolatesDA(){
        CH.add(new Chocolates("Dark Chocolate", 2.5));
        CH.add(new Chocolates("White Chocolate", 3));
        CH.add(new Chocolates("Milk Chocolate", 8));
        CH.add(new Chocolates("Milk With nuts Chocolate", 10.5));
        CH.add(new Chocolates("White and Dark Mix Chocolate", 4));
        CH.add(new Chocolates("Dark 80% Chocolate", 8));
        CH.add(new Chocolates("Mix With Honey Chocolate", 15));
    }

    public List<Chocolates> getCH() {
        return CH;
    }
}
