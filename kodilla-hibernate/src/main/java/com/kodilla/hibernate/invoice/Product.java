package com.kodilla.hibernate.invoice;

import org.springframework.lang.NonNull;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="PRODUCTS")
public class Product {
    private int id;
    private String name;
    private List<Item> itemLists;

    public Product(String name) {
        this.name = name;
    }

    public Product(){
    }

    public void setItemLists(List<Item> itemLists) {
        this.itemLists = itemLists;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="ITEM_LISTS")
    @OneToMany(
        targetEntity = Item.class,
        mappedBy = "product",
        cascade = CascadeType.ALL,
        fetch = FetchType.EAGER
    )
    public List<Item> getItemLists() {
        return itemLists;
    }

    @Id
    @NonNull
    @GeneratedValue
    @Column(name="PRODUCT_ID", unique = true)
    public int getId() {
        return id;
    }

    @NonNull
    @Column(name="PRODUCT_NAME")
    public String getName() {
        return name;
    }
}
