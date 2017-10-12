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
import java.io.File;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import java.util.ArrayList;
import java.util.List;

//image file stuff
import org.apache.commons.io.FileUtils;
import java.io.File;
import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import javax.servlet.http.Part;
import java.io.IOException;

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
    private String ownerid;
    //add image
    //private File itemimage; //dont need this anymore
    private File myFile; 
    private String myFileContentType;
    private String myFileFileName;
    private String destPath;

    public String getMyFileContentType() {
        return myFileContentType;
    }

    public void setMyFileContentType(String myFileContentType) {
        this.myFileContentType = myFileContentType;
    }

    public String getMyFileFileName() {
        return myFileFileName;
    }

    public void setMyFileFileName(String myFileFileName) {
        this.myFileFileName = myFileFileName;
    }
    
    public File getMyFile() {
        return myFile;
    }
    
    public void setMyFile(File myFile){
        this.myFile = myFile;
    }
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

    public String getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(String ownerid) {
        this.ownerid = ownerid;
    }
    
    
    //private HttpServletRequest servletRequest;
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
//        destPath = "/img/"; https://www.tutorialspoint.com/struts_2/struts_file_uploads.htm
//        try{
//     	 File destFile  = new File(destPath, myFileFileName);
//    	 FileUtils.copyFile(myFile, destFile);
//  
//      }catch(IOException e){
//         e.printStackTrace();
//         return ERROR;
//      }
        //store image on the server at path at web/img/<filename> //filename format should be username_itemname_rand()?
        //https://www.w3schools.com/php/php_file_upload.asp
        //http://www.websparrow.org/struts/how-to-upload-image-in-database-using-struts2
        
        //File newfile = new File("/web/img", "newimage.jpg");
        //servletRequest.getContextPath()
        //FileUtils.copyFile(itemimage, newfile);
        //Part filePart = servletRequest.getPart("itemimage");
        //InputStream inputStream = null;
        //inputStream = filePart.getInputStream();
        
        itemDao.addItem(itemname, itemdescription, itemprice, "shouldBeImgPath", Integer.valueOf(ownerid));
        itemlist = itemDao.getAll(BaseDAO.ITEM_TBL);
        
        this.session.put("itemlist", itemlist);
        
        return SUCCESS;
    }
}

