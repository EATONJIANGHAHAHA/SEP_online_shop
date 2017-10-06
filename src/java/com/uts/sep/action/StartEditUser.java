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
public class StartEditUser extends ActionSupport implements SessionAware {

    @Override
    public void setSession(Map<String, Object> map) {
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
