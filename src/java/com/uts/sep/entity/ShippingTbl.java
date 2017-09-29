package com.uts.sep.entity;
// Generated Sep 25, 2017 10:57:32 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ShippingTbl generated by hbm2java
 */
public class ShippingTbl  implements java.io.Serializable {


     private int shippingId;
     private String shippingType;
     private String shippingRegion;
     private String shippingAddress;
     private int shippingStatus;
     private double shippingCost;
     private Date deliveryDate;
     private Set orderTbls = new HashSet(0);

    public ShippingTbl() {
    }

	
    public ShippingTbl(int shippingId, String shippingType, String shippingRegion, String shippingAddress, int shippingStatus, double shippingCost, Date deliveryDate) {
        this.shippingId = shippingId;
        this.shippingType = shippingType;
        this.shippingRegion = shippingRegion;
        this.shippingAddress = shippingAddress;
        this.shippingStatus = shippingStatus;
        this.shippingCost = shippingCost;
        this.deliveryDate = deliveryDate;
    }
    public ShippingTbl(int shippingId, String shippingType, String shippingRegion, String shippingAddress, int shippingStatus, double shippingCost, Date deliveryDate, Set orderTbls) {
       this.shippingId = shippingId;
       this.shippingType = shippingType;
       this.shippingRegion = shippingRegion;
       this.shippingAddress = shippingAddress;
       this.shippingStatus = shippingStatus;
       this.shippingCost = shippingCost;
       this.deliveryDate = deliveryDate;
       this.orderTbls = orderTbls;
    }
   
    public int getShippingId() {
        return this.shippingId;
    }
    
    public void setShippingId(int shippingId) {
        this.shippingId = shippingId;
    }
    public String getShippingType() {
        return this.shippingType;
    }
    
    public void setShippingType(String shippingType) {
        this.shippingType = shippingType;
    }
    public String getShippingRegion() {
        return this.shippingRegion;
    }
    
    public void setShippingRegion(String shippingRegion) {
        this.shippingRegion = shippingRegion;
    }
    public String getShippingAddress() {
        return this.shippingAddress;
    }
    
    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
    public int getShippingStatus() {
        return this.shippingStatus;
    }
    
    public void setShippingStatus(int shippingStatus) {
        this.shippingStatus = shippingStatus;
    }
    public double getShippingCost() {
        return this.shippingCost;
    }
    
    public void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }
    public Date getDeliveryDate() {
        return this.deliveryDate;
    }
    
    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
    public Set getOrderTbls() {
        return this.orderTbls;
    }
    
    public void setOrderTbls(Set orderTbls) {
        this.orderTbls = orderTbls;
    }




}


