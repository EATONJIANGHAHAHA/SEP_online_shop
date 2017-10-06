package com.uts.sep.entity;
// Generated Oct 3, 2017 10:49:09 PM by Hibernate Tools 4.3.1



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
     private String itemPicUrl;
     private String category;
     
     public static final int IS_ADDED = 1; 
     /**
      * 1 for added
      * 0 for removed
      */
     private int isAdded;

    public ItemTbl() {
    }

	
    public ItemTbl(String itemName, int stock, int itemStatus, double price, int isAdded) {
        this.itemName = itemName;
        this.stock = stock;
        this.itemStatus = itemStatus;
        this.price = price;
        this.isAdded = isAdded;
    }
    public ItemTbl(String itemName, String itemDescription, int stock, int itemStatus, double price, String itemPicUrl, String category, int isAdded) {
       this.itemName = itemName;
       this.itemDescription = itemDescription;
       this.stock = stock;
       this.itemStatus = itemStatus;
       this.price = price;
       this.itemPicUrl = itemPicUrl;
       this.category = category;
       this.isAdded = isAdded;
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
    public String getItemPicUrl() {
        return this.itemPicUrl;
    }
    
    public void setItemPicUrl(String itemPicUrl) {
        this.itemPicUrl = itemPicUrl;
    }
    public String getCategory() {
        return this.category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    public int getIsAdded() {
        return this.isAdded;
    }
    
    public void setIsAdded(int isAdded) {
        this.isAdded = isAdded;
    }
}


