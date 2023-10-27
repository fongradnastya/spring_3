package com.example.demo;

public class Clothes {
    private int id;
    private String name;
    private String color;
    private String brand;
    private int size;
    private double price;
    private int quantity;

    public Clothes(){
        this.name = "Default name";
        this.brand = "";
        this.price = 0;
        this.quantity = 1;
    }

    public Clothes(String name, String color, String brand, int size, double price, int quantity) {
        this.name = name;
        this.color = color;
        this.brand = brand;
        this.size = size;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Clothes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", brand='" + brand + '\'' +
                ", size=" + size +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
