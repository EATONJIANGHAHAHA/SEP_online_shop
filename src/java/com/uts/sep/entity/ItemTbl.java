package com.uts.sep.entity;
// Generated Oct 14, 2017 5:40:16 PM by Hibernate Tools 4.3.1



/**
 * ItemTbl generated by hbm2java
 */
public class ItemTbl  implements java.io.Serializable {


     private Integer itemId;
     private String itemName;
     private String itemDescription;
     private int stock;
     private int itemStatus;
     private double price;
     private String image;
     private int ownerId;

    public ItemTbl() {
    }
    
    public ItemTbl(String itemName, int stock, int itemStatus, double price, int ownerId) {
        this.itemName = itemName;
        this.stock = stock;
        this.itemStatus = itemStatus;
        this.price = price;
        this.ownerId = ownerId;
    }
    public ItemTbl(String itemName, String itemDescription, int stock, int itemStatus, double price, String image, int ownerId) {
       this.itemName = itemName;
       this.itemDescription = itemDescription;
       this.stock = stock;
       this.itemStatus = itemStatus;
       this.price = price;
       this.image = image;
       this.ownerId = ownerId;
    }
   
    public Integer getItemId() {
        return this.itemId;
    }
    
    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }
    public String getItemName() {
        return this.itemName;
    }
    
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public String getItemDescription() {
        return this.itemDescription;
    }
    
    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }
    public int getStock() {
        return this.stock;
    }
    
    public void setStock(int stock) {
        this.stock = stock;
    }
    public int getItemStatus() {
        return this.itemStatus;
    }
    
    public void setItemStatus(int itemStatus) {
        this.itemStatus = itemStatus;
    }
    public double getPrice() {
        return this.price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    public String getImage() {
        return this.image;
    }
    
    public void setImage(String image) {
        this.image = image;
    }
    public int getOwnerId() {
        return this.ownerId;
    }
    
    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
}


