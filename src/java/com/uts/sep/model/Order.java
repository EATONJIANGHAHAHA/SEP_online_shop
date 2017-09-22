/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.sep.model;

import com.uts.sep.dao.BaseDAO;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author tomat
 */
public class Order extends BaseDAO{
    int orderID;
    Date dateOrderCreated;
    ArrayList<OrderDetail> orderDetails;
    double payment;

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Date getDateOrderCreated() {
        return dateOrderCreated;
    }

    public void setDateOrderCreated(Date dateOrderCreated) {
        this.dateOrderCreated = dateOrderCreated;
    }

    public ArrayList<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(ArrayList<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public Order(int orderID, Date dateOrderCreated, ArrayList<OrderDetail> orderDetails, double payment) {
        this.orderID = orderID;
        this.dateOrderCreated = dateOrderCreated;
        this.orderDetails = orderDetails;
        this.payment = payment;
    }

    public Order() {
    }
}
