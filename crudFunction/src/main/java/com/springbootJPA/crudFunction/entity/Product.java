package com.springbootJPA.crudFunction.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;
    private int quantity;
    private double price;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }



//    @Override
//    public String toString() {
//        return "Product{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", quantity=" + quantity +
//                ", price=" + price +
//                '}';
//    }

}
