/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.sep.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author eaton
 */
public class AddToCartAction extends ActionSupport implements SessionAware{
    
    private Map session;

    @Override
    public void setSession(Map session) {
        
        this.session = session;
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
//    @Override
//    public void ex
    
}
