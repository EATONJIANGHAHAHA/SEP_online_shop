package com.uts.sep.entity;
// Generated Oct 3, 2017 10:49:09 PM by Hibernate Tools 4.3.1



/**
 * ShoppingCartItemTbl generated by hbm2java
 */
public class ShoppingCartItemTbl  implements java.io.Serializable {


     private ShoppingCartItemTblId id;
     private ShoppingCartTbl shoppingCartTbl;

    public ShoppingCartItemTbl() {
    }

    public ShoppingCartItemTbl(ShoppingCartItemTblId id, ShoppingCartTbl shoppingCartTbl) {
       this.id = id;
       this.shoppingCartTbl = shoppingCartTbl;
    }
   
    public ShoppingCartItemTblId getId() {
        return this.id;
    }
    
    public void setId(ShoppingCartItemTblId id) {
        this.id = id;
    }
    public ShoppingCartTbl getShoppingCartTbl() {
        return this.shoppingCartTbl;
    }
    
    public void setShoppingCartTbl(ShoppingCartTbl shoppingCartTbl) {
        this.shoppingCartTbl = shoppingCartTbl;
    }




}


