package com.kodilla.hibernate.invoice;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name="ITEMS")
public class Item {
    int id;
    Product product;
    BigDecimal price;
    int quantity;
    BigDecimal value;
}
