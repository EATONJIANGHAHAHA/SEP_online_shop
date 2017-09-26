/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.sep.dao;

import static com.uts.sep.dao.BaseDAO.ITEM_TBL;
import com.uts.sep.entity.ItemTbl;
import java.util.Iterator;
import java.util.List;

/**
 * This class will help updating database and getting data from the database for
 * ItemTbl type.
 *
 * @author eaton
 */
public class ItemDAO extends BaseDAO<ItemTbl> {

    public static final String CATEGORY_BOOK = "book";
    public static final String CATEGORY_COMPUTER = "computer";
    public static final String CATEGORY_PHONE = "phone";
    public static final String CATEGORY_GAME_CONSOLES = "game consoles";
    private List<ItemTbl> items = getAll(ITEM_TBL);
    private List<ItemTbl> tempList = null;

    interface Updater {

        void onUpdate(ItemTbl item);
    }

    private class UpdateHelper {

        private void beginUpdate(Integer itemId, Updater updater) {

            ItemTbl usingItem = findById(itemId);
            updater.onUpdate(usingItem);
            update(usingItem);
        }
    }

    public List<ItemTbl> getItemsFiltedByCategory(String Category) {
        tempList = null;
        for (ItemTbl item : items) 
            if (item.getCategory().equals(Category)) tempList.add(item);
        return tempList;
    }
    
    public List<ItemTbl> getItemsFiltedByName(String Name){
        tempList = null;
        for (ItemTbl item : items)
            if(item.getItemName().equals(Name)) tempList.add(item);
        return tempList;
    }
    
    /**
     * to get the item for certain price, you need a range of it. 
     * for example, to get items' price at: 100, 
     * put price[0] = 100 && price[1] = 100
     * to get items' price between 100 and 500, 
     * pub price[0] = 100 $$ price[1] = 500
     * @param price
     * @return 
     */
    public List<ItemTbl> getItemsFiltedByPrice(double[] price){
        tempList = null;
        for(ItemTbl item : items)
            if(item.getPrice() >= price[0] 
                    && item.getPrice() <= price[1]) tempList.add(item);
        return tempList;
    }

    public void updateItemName(Integer id, String itemName) {
        new UpdateHelper().beginUpdate(id, (ItemTbl item) -> {
            item.setItemName(itemName);
        });
    }

    public void updateItemDescription(Integer itemId, String itemDescription) {
        new UpdateHelper().beginUpdate(itemId, (ItemTbl item) -> {
            item.setItemDescription(itemDescription);
        });
    }

    public void updateItemStock(Integer itemId, Integer stock) {
        new UpdateHelper().beginUpdate(itemId, (ItemTbl item) -> {
            item.setStock(stock);
        });
    }

    public void updateItemStatus(Integer itemId, Integer itemStatus) {
        new UpdateHelper().beginUpdate(itemId, (ItemTbl item) -> {
            item.setItemStatus(itemStatus);
        });
    }

    public void updatePrice(Integer itemId, Double price) {
        new UpdateHelper().beginUpdate(itemId, (ItemTbl item) -> {
            item.setPrice(price);
        });
    }
    
    /**
     * This method will update the category of an item. Please do notice that I
     * statically put four existing category string inside this class, use those
     * as for now. Please DO NOT use any other Strings.
     *
     * @param itemId
     * @param category
     */
    public void updateCategory(Integer itemId, String category) {
        new UpdateHelper().beginUpdate(itemId, (ItemTbl item) -> {
            item.setCategory(category);
        });
    }

    public void updateItemPicUrl(Integer itemId, String Url) {

        new UpdateHelper().beginUpdate(itemId, new Updater() {

            @Override
            public void onUpdate(ItemTbl item) {
                //ItemTbl usingItem = findById(itemId);
                List<ItemTbl> items = getAll(ITEM_TBL);
                boolean UrlIsUsed = false;
                for (Iterator<ItemTbl> it = items.iterator(); it.hasNext();) {
                    item = it.next();
                    if (item.getItemPicUrl().equals(Url)) {
                        UrlIsUsed = true;
                        break;
                    }
                }
                if (!UrlIsUsed) {
                    item.setItemPicUrl(Url);
                }
            }

        });
    }
}
