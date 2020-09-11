package com.example.shopapi.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Shopingcart {

    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(nullable=false)
    private String username;

    @Column(nullable=false)
    private String itemName;

    @Column(nullable=false)
    private int quantity;

    public Shopingcart() {
        super();
    }
    public Shopingcart(int id, String username, String itemName, int quantity) {
        this.id = id;
        this.username = username;
        this.itemName = itemName;
        this.quantity = quantity;
    }

    public Shopingcart(String username, String itemName, int quantity) {
        this.username = username;
        this.itemName = itemName;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shopingcart that = (Shopingcart) o;
        return id == that.id &&
                quantity == that.quantity &&
                Objects.equals(username, that.username) &&
                Objects.equals(itemName, that.itemName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, itemName, quantity);
    }

    @Override
    public String toString() {
        return "Shopingcart{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", itemName='" + itemName + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
