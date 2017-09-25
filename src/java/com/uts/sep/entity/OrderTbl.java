package com.uts.sep.entity;
// Generated Sep 25, 2017 10:57:32 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * OrderTbl generated by hbm2java
 */
public class OrderTbl  implements java.io.Serializable {


     private Integer orderId;
     private ShippingTbl shippingTbl;
     private Integer orderStatus;
     private Date dateCreated;
     private int customerId;
     private Double payment;
     private Set orderDetailTbls = new HashSet(0);
     private Set customerTbls = new HashSet(0);

    public OrderTbl() {
    }

	
    public OrderTbl(ShippingTbl shippingTbl, Date dateCreated, int customerId) {
        this.shippingTbl = shippingTbl;
        this.dateCreated = dateCreated;
        this.customerId = customerId;
    }
    public OrderTbl(ShippingTbl shippingTbl, Integer orderStatus, Date dateCreated, int customerId, Double payment, Set orderDetailTbls, Set customerTbls) {
       this.shippingTbl = shippingTbl;
       this.orderStatus = orderStatus;
       this.dateCreated = dateCreated;
       this.customerId = customerId;
       this.payment = payment;
       this.orderDetailTbls = orderDetailTbls;
       this.customerTbls = customerTbls;
    }
   
    public Integer getOrderId() {
        return this.orderId;
    }
    
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
    public ShippingTbl getShippingTbl() {
        return this.shippingTbl;
    }
    
    public void setShippingTbl(ShippingTbl shippingTbl) {
        this.shippingTbl = shippingTbl;
    }
    public Integer getOrderStatus() {
        return this.orderStatus;
    }
    
    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }
    public Date getDateCreated() {
        return this.dateCreated;
    }
    
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
    public int getCustomerId() {
        return this.customerId;
    }
    
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public Double getPayment() {
        return this.payment;
    }
    
    public void setPayment(Double payment) {
        this.payment = payment;
    }
    public Set getOrderDetailTbls() {
        return this.orderDetailTbls;
    }
    
    public void setOrderDetailTbls(Set orderDetailTbls) {
        this.orderDetailTbls = orderDetailTbls;
    }
    public Set getCustomerTbls() {
        return this.customerTbls;
    }
    
    public void setCustomerTbls(Set customerTbls) {
        this.customerTbls = customerTbls;
    }




}


