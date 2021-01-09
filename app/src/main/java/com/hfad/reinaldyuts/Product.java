package com.hfad.reinaldyuts;
import java.io.Serializable;
import java.util.ArrayList;

public class Product implements Serializable {
    private String name;
    private int price;
    private int picture;

    private int qty;


    public Product(String name, int price, int picture) {
        this.name = name;
        this.price = price;
        this.picture = picture;
    }

    public Product(String name, int price, int picture, int qty) {
        this.name = name;
        this.price = price;
        this.picture = picture;
        this.qty = qty;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}

