package com.uts.sep.entity;
// Generated Oct 3, 2017 10:49:09 PM by Hibernate Tools 4.3.1



/**
 * AdminTbl generated by hbm2java
 */
public class AdminTbl  implements java.io.Serializable {


     private Integer userId;
     private int authorityLevel;

    public AdminTbl() {
    }

    public AdminTbl(int authorityLevel) {
       this.authorityLevel = authorityLevel;
    }
   
    public Integer getUserId() {
        return this.userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public int getAuthorityLevel() {
        return this.authorityLevel;
    }
    
    public void setAuthorityLevel(int authorityLevel) {
        this.authorityLevel = authorityLevel;
    }




}


