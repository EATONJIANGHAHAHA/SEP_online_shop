package com.uts.sep.entity;
// Generated Sep 25, 2017 5:06:28 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * ItemTbl generated by hbm2java
 */
public class ItemTbl  implements java.io.Serializable {


     private int itemId;
     private String itemName;
     private String itemDescription;
     private int stock;
     private int itemStatus;
     private double price;
     private String itemPicUrl;
     private String category;
     private Set<OrderDetailTbl> orderDetailTbls = new HashSet<OrderDetailTbl>(0);
     private Set<ShoppingCartTbl> shoppingCartTbls = new HashSet<ShoppingCartTbl>(0);

    public ItemTbl() {
    }

	
    public ItemTbl(int itemId, String itemName, int stock, int itemStatus, double price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.stock = stock;
        this.itemStatus = itemStatus;
        this.price = price;
    }
    public ItemTbl(int itemId, String itemName, String itemDescription, int stock, int itemStatus, double price, String itemPicUrl, String category, Set<OrderDetailTbl> orderDetailTbls, Set<ShoppingCartTbl> shoppingCartTbls) {
       this.itemId = itemId;
       this.itemName = itemName;
       this.itemDescription = itemDescription;
       this.stock = stock;
       this.itemStatus = itemStatus;
       this.price = price;
       this.itemPicUrl = itemPicUrl;
       this.category = category;
       this.orderDetailTbls = orderDetailTbls;
       this.shoppingCartTbls = shoppingCartTbls;
    }
   
    public int getItemId() {
        return this.itemId;
    }
    
    public void setItemId(int itemId) {
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
    public Set<OrderDetailTbl> getOrderDetailTbls() {
        return this.orderDetailTbls;
    }
    
    public void setOrderDetailTbls(Set<OrderDetailTbl> orderDetailTbls) {
        this.orderDetailTbls = orderDetailTbls;
    }
    public Set<ShoppingCartTbl> getShoppingCartTbls() {
        return this.shoppingCartTbls;
    }
    
    public void setShoppingCartTbls(Set<ShoppingCartTbl> shoppingCartTbls) {
        this.shoppingCartTbls = shoppingCartTbls;
    }




}


