package com.kodilla.hibernate.invoice;

import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Table(name="PRODUCTS")
public class Product {
    int id;
    String name;

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Product(){

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="ID", unique = true)
    @Id
    @NonNull
    @GeneratedValue
    public int getId() {
        return id;
    }
    @Column(name="NAME")
    public String getName() {
        return name;
    }
}
