/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.sep.action;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.uts.sep.dao.BaseDAO;
import com.uts.sep.dao.ItemDAO;
import com.uts.sep.model.Item;
import com.uts.sep.entity.ItemTbl;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lzy
 */
public class SearchAction extends ActionSupport implements SessionAware {

    //variables used for session variables used in search.jsp
    private String keyword = "";
    private List<ItemTbl> itemlist = new ArrayList<ItemTbl>();
    
    //variables used for session variables used in addItem.jsp
    private String itemname = "";
    private String itemdescription = "";
    private double itemprice = 0;
    
    //session variable used to communicate with the view
    private Map session;

    @Override
    public void setSession(Map session) {
        this.session = session;
    }
    
    //keyword functions needed to link to view keyword
    public String getKeyword() {
        return keyword; 
    }
    
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    
    //itemname functions needed to link to veiw itemname
    //function names must be the same as the variable name. consistant on all files.
    public String getItemname() {
        return itemname; 
    }
    
    public void setItemname(String itemname) {
        this.itemname = itemname;
    }
    
    public String getItemdescription() {
        return itemdescription; 
    }
    
    public void setItemdescription(String itemdescription) {
        this.itemdescription = itemdescription;
    }
    
    public double getItemprice() {
        return itemprice; 
    }
    
    public void setItemprice(double itemprice) {
        this.itemprice = itemprice;
    }
    
    /*
    public List<ItemTbl> getItems(){
        return itemlist; 
    }
    */
    //@Override
    public String searchItems() throws Exception {

        //this.session.put("keyword", keyword);
        //itemname = (String)this.session.get("keyword");
        
        ItemDAO itemDao = new ItemDAO();
        itemlist = itemDao.searchItems(keyword);
        
        this.session.put("itemlist", itemlist);
        
        return SUCCESS;

    }
    
    public String addItem() throws Exception {
        
        ItemDAO itemDao = new ItemDAO();
        itemDao.addItem(itemname, itemdescription, itemprice);
        itemlist = itemDao.getAll(BaseDAO.ITEM_TBL);
        
        this.session.put("itemlist", itemlist);
        
        return SUCCESS;
    }
}

