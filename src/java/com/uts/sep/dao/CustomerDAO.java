/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.sep.dao;

import com.uts.sep.entity.CustomerTbl;
import java.util.Date;

/**
 *
 * @author eaton
 */
public class CustomerDAO extends BaseDAO<CustomerTbl>{
    
    public void updateCustomerAddress(Integer userId, String customerAddress){
        CustomerTbl usingCustomer = findById(userId);
        usingCustomer.setCustomerAddress(customerAddress);
        update(usingCustomer);
    }
    
    public void updateEmail(Integer userId, String email){
        CustomerTbl usingCustomer = findById(userId);
        usingCustomer.setEmail(email);
        update(usingCustomer);
    }
    
    public void updateCreditCardno(Integer userId, int creditCardno){
        CustomerTbl usingCustomer = findById(userId);
        usingCustomer.setCreditCardno(creditCardno);
        update(usingCustomer);
    }
    
    public void updateDateOfBirth(Integer userId, Date dob){
        CustomerTbl usingCustomer = findById(userId);
        usingCustomer.setDob(dob);
        update(usingCustomer);
    }
}
