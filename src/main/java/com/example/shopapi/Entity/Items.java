package com.example.shopapi.Entity;




import javax.persistence.*;
import java.util.Objects;


@Entity
public class Items {

    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private int itemId;

    @Column(nullable=false)
    private String itemName;

    @Column(nullable=false)
    private int itemQuantity;

    @Column(nullable=false)
    private double itemPrice;

    public Items() {
        super();
    }
    public  Items(int ItemId, String ItemName, int ItemQuantity, double ItemPrice){
        this.itemId = ItemId;
        this.itemName = ItemName;
        this.itemPrice = ItemPrice;
        this.itemQuantity = ItemQuantity;
    }

    public  Items(String ItemName, int ItemQuantity, double ItemPrice){
        this.itemName = ItemName;
        this.itemPrice = ItemPrice;
        this.itemQuantity = ItemQuantity;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Items items = (Items) o;
        return itemId == items.itemId &&
                itemQuantity == items.itemQuantity &&
                Double.compare(items.itemPrice, itemPrice) == 0 &&
                Objects.equals(itemName, items.itemName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, itemName, itemQuantity, itemPrice);
    }

    @Override
    public String toString() {
        return "Items{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemQuantity=" + itemQuantity +
                ", itemPrice=" + itemPrice +
                '}';
    }
}
