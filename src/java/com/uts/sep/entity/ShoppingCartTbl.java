package com.uts.sep.entity;
// Generated Sep 25, 2017 5:06:28 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * ShoppingCartTbl generated by hbm2java
 */
public class ShoppingCartTbl  implements java.io.Serializable {


     private int shoppingCartId;
     private CustomerTbl customerTbl;
     private Set<ItemTbl> itemTbls = new HashSet<ItemTbl>(0);

    public ShoppingCartTbl() {
    }

	
    public ShoppingCartTbl(int shoppingCartId, CustomerTbl customerTbl) {
        this.shoppingCartId = shoppingCartId;
        this.customerTbl = customerTbl;
    }
    public ShoppingCartTbl(int shoppingCartId, CustomerTbl customerTbl, Set<ItemTbl> itemTbls) {
       this.shoppingCartId = shoppingCartId;
       this.customerTbl = customerTbl;
       this.itemTbls = itemTbls;
    }
   
    public int getShoppingCartId() {
        return this.shoppingCartId;
    }
    
    public void setShoppingCartId(int shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }
    public CustomerTbl getCustomerTbl() {
        return this.customerTbl;
    }
    
    public void setCustomerTbl(CustomerTbl customerTbl) {
        this.customerTbl = customerTbl;
    }
    public Set<ItemTbl> getItemTbls() {
        return this.itemTbls;
    }
    
    public void setItemTbls(Set<ItemTbl> itemTbls) {
        this.itemTbls = itemTbls;
    }




}


