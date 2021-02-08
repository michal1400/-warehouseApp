package com.company.model;


public class Product {

    private int id;
    private String name;
    private double price;
    private int quantity;
    private  String producer;
    private String parametr1;
    private String parametr2;
    private String parametr3;

    public Product(int id, String name, double price, int quantity, String producer, String parametr1, String parametr2, String parametr3) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.producer = producer;
        this.parametr1 = parametr1;
        this.parametr2 = parametr2;
        this.parametr3 = parametr3;
    }

    public Product() {
    }

    public Product(int id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public void in(int value){
        this.quantity += value;
    }

    public boolean out(int value){
        if (quantity - value > 0){
            quantity -= value;
            return true;
        }
        return false;
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

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getParametr1() {
        return parametr1;
    }

    public void setParametr1(String parameter1) {
        this.parametr1 = parameter1;
    }

    public String getParametr2() {
        return parametr2;
    }

    public void setParametr2(String parameter2) {
        this.parametr2 = parameter2;
    }

    public String getParametr3() {
        return parametr3;
    }

    public void setParametr3(String parameter3) {
        this.parametr3 = parameter3;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", producer='" + producer + '\'' +
                ", parametr1='" + parametr1 + '\'' +
                ", parametr2='" + parametr2 + '\'' +
                ", parametr3='" + parametr3 + '\'' +
                '}';
    }
}