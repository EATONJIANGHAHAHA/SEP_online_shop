/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.sep.model;

import com.uts.sep.dao.BaseDAO;

/**
 *
 * @author tomat
 */
public class OrderDetail extends BaseDAO{
    double orderPrice;
    int orderedQuantity;
    String orderedItemDescription;
    int orderedID;
    int orderedItemID;
    String orderedItemName;

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public int getOrderedQuantity() {
        return orderedQuantity;
    }

    public void setOrderedQuantity(int orderedQuantity) {
        this.orderedQuantity = orderedQuantity;
    }

    public String getOrderedItemDescription() {
        return orderedItemDescription;
    }

    public void setOrderedItemDescription(String orderedItemDescription) {
        this.orderedItemDescription = orderedItemDescription;
    }

    public int getOrderedID() {
        return orderedID;
    }

    public void setOrderedID(int orderedID) {
        this.orderedID = orderedID;
    }

    public int getOrderedItemID() {
        return orderedItemID;
    }

    public void setOrderedItemID(int orderedItemID) {
        this.orderedItemID = orderedItemID;
    }

    public String getOrderedItemName() {
        return orderedItemName;
    }

    public void setOrderedItemName(String orderedItemName) {
        this.orderedItemName = orderedItemName;
    }

    public OrderDetail(double orderPrice, int orderedQuantity, String orderedItemDescription, int orderedID, int orderedItemID, String orderedItemName) {
        this.orderPrice = orderPrice;
        this.orderedQuantity = orderedQuantity;
        this.orderedItemDescription = orderedItemDescription;
        this.orderedID = orderedID;
        this.orderedItemID = orderedItemID;
        this.orderedItemName = orderedItemName;
    }

    public OrderDetail() {
    }
}
