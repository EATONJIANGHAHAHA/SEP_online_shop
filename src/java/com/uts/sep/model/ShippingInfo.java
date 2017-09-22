/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.sep.model;

import com.uts.sep.dao.BaseDAO;
import java.sql.Date;

/**
 *
 * @author tomat
 */
public class ShippingInfo extends BaseDAO{
    int shippingID;
    String shippingType;
    int shippingCost;
    String shippingRegion;
    String shippingAddress;
    Date shippingDate;
    int status;

    public int getShippingID() {
        return shippingID;
    }

    public void setShippingID(int shippingID) {
        this.shippingID = shippingID;
    }

    public String getShippingType() {
        return shippingType;
    }

    public void setShippingType(String shippingType) {
        this.shippingType = shippingType;
    }

    public int getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(int shippingCost) {
        this.shippingCost = shippingCost;
    }

    public String getShippingRegion() {
        return shippingRegion;
    }

    public void setShippingRegion(String shippingRegion) {
        this.shippingRegion = shippingRegion;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Date getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(Date shippingDate) {
        this.shippingDate = shippingDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ShippingInfo(int shippingID, String shippingType, int shippingCost, String shippingRegion, String shippingAddress, Date shippingDate, int status) {
        this.shippingID = shippingID;
        this.shippingType = shippingType;
        this.shippingCost = shippingCost;
        this.shippingRegion = shippingRegion;
        this.shippingAddress = shippingAddress;
        this.shippingDate = shippingDate;
        this.status = status;
    }

    public ShippingInfo() {
    }
}
