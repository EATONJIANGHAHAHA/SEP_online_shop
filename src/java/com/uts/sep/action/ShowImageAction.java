///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.uts.sep.action;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.sql.SQLException;
//
//import javax.servlet.http.HttpServletResponse;
//import org.apache.struts2.ServletActionContext;
////import com.raysep.maxlist.domain.post.image.Image;
//
//public class ShowImageAction extends AbsDBObject<Object>{
//
//  private static byte[] itemImage;
//
//  public static void execute() {
//
//      try {
//
//          Image slika = Image.fetchOne();
//
//          HttpServletResponse response = ServletActionContext.getResponse();
//          response.reset();
//          response.setContentType("multipart/form-data"); 
//
//          itemImage = slika.getImage().getBytes(1,(int) slika.getImage().length());
//
//          OutputStream out = response.getOutputStream();
//          out.write(itemImage);
//          out.flush();
//          out.close();
//
//      } catch (SQLException e) {
//          e.printStackTrace();
//      } catch (IOException e) {
//          e.printStackTrace();
//      }
//
//
//  }
//
//  public byte[] getItemImage() {
//      return itemImage;
//  }
//
//  public void setItemImage(byte[] itemImage) {
//      this.itemImage = itemImage;
//  }
//
//
//}
//
