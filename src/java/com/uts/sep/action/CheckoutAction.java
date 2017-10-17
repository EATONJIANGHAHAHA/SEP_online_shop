/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.sep.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.uts.sep.dao.ItemDAO;
import com.uts.sep.dao.UserDAO;
import com.uts.sep.dao.ShoppingCartDAO;
import com.uts.sep.entity.UserTbl;
import com.uts.sep.entity.ItemTbl;
import com.uts.sep.entity.ShoppingCartTbl;
import java.util.List;
import com.uts.sep.action.checkoutEmailAction;
import java.util.ArrayList;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author Edric
 */
public class CheckoutAction extends ActionSupport implements SessionAware{
    private Map session;
    private int selectedUserId;
    //email variables
    //private List<UserTbl> checkoutowner = new ArrayList<UserTbl>();
    
    //establish session info
    @Override
    public void setSession(Map session) {
        this.session = session;
        
    }

    public int getSelectedUserId() {
        return selectedUserId;
    }

    public void setSelectedUserId(int selectedUserId) {
        this.selectedUserId = selectedUserId;
    }
    
    //actions and methods
    @Override
    public String execute() throws Exception {
        ShoppingCartDAO cartDAO = new ShoppingCartDAO();
        ItemDAO itemDAO = new ItemDAO();
        ItemTbl item;
        List<ShoppingCartTbl> cartlist = cartDAO.getAll("ShoppingCartTbl");
        //List<ShoppingCartTbl> emaillist = cartDAO.getAll("ShoppingCartTbl");
        //emaillist.clear();
        String emailText = "\n";
        UserDAO userDao = new UserDAO();
        UserTbl checkoutowner;
        checkoutowner = (UserTbl)userDao.findById(selectedUserId);
        
        emailText += "Hi " + checkoutowner.getUserName() + "\n\n";
        
        //delete items from cart with user id
        for(ShoppingCartTbl c : cartlist) {
            if(c.getUserId() == selectedUserId) {
                //emaillist.add(c);
                //emailText = emailText + 
                
                //begin to construct email
                //emailText += Integer.toString(c.getItemId());
                item = (ItemTbl)itemDAO.findById(c.getItemId());
                emailText += item.getItemName() + "\n";
                emailText += item.getItemDescription() + "\n";
                emailText += "You bought this item for $" + Double.toString(item.getPrice()) + "\n\n";
                
                //remove item from cart table
                cartDAO.checkoutCartItems(selectedUserId);
            }
        }
        
        //construct email
        final String username = "sepbayemail@gmail.com";
		final String password = "sepbaylogin1";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session1 = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session1);
			message.setFrom(new InternetAddress("sepbayemail@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(checkoutowner.getEmail()));
			message.setSubject("Your Checkout Items");
			message.setText(emailText);

			Transport.send(message);

			//System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
       
        
        
        //----OLD CODE
        //call checkout EmailAction.java
        //checkoutEmailAction.SendEmail(selectedUserId, emaillist);
        
    
        return SUCCESS;
    }
    
}
