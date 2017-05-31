/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.servicelayer;

import com.sg.dao.PersistenceException;
import com.sg.dao.ItemDao;
import com.sg.dto.Item;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author yingy
 */
public class ServiceLayerImpl implements ServiceLayer {

    private ItemDao itemDao;

    public ServiceLayerImpl(ItemDao itemDao) {
        this.itemDao = itemDao;
    }


    @Override
    public List<Item> getAllItemsAvailable() throws PersistenceException {
        return itemDao.getAllItemsAvailable();
    }

    @Override
    public List<Item> checkInventory(List<Item> itemList) throws PersistenceException {
        return itemDao.checkInventory(itemList);
    }

    @Override
    public Item dispenseItem(Item item) throws PersistenceException {
        return itemDao.dispenseItem(item);
    }

    @Override
    public Item decrementInventory(Item item) throws PersistenceException {
        return itemDao.decrementInventory(item);
    }

    public  Item addItem(Long itemId, Item item) throws PersistenceException{
        return itemDao.addItem(itemId, item);
    }

    //***************************Add Money Coins****************************//
    @Override
    public BigDecimal addDollar() {
        BigDecimal dollar = new BigDecimal("1.00");
        return dollar;
    }
    @Override
    public BigDecimal addQuarter() {
        BigDecimal quarter = new BigDecimal("0.25");
        return quarter;
    }
    @Override
    public BigDecimal addDime() {
        BigDecimal dime = new BigDecimal(".10");
        return dime;
    }
    @Override
    public BigDecimal addNickel() {
        BigDecimal nickel = new BigDecimal(".05");
        return nickel;
    }

    //*************************Remove Money***********************************//

    @Override
    public BigDecimal returnChange() throws PersistenceException {
        BigDecimal zero = new BigDecimal("0");
        return zero;
    }

    @Override
    public String showChange(BigDecimal total) throws PersistenceException {

        double quarters = 0;
        double dimes = 0;
        double nickels = 0;
        double pennies = 0;
        double totalNew = total.doubleValue();

        while (totalNew > 0) {
            if (totalNew >= .25) {
                totalNew = totalNew - .25;
                quarters++;
            } else if (totalNew >= .1) {
                totalNew = totalNew - .1;
                dimes++;
            } else if (totalNew >= .05) {
                totalNew = totalNew - .05;
                nickels++;
            } else if (totalNew >= .01) {
                totalNew = totalNew - .01;
                pennies++;
            } else {
                break;
            }
        }

        String sum = quarters + " quarters " + dimes + " dimes " + nickels + " nickels " + pennies + " pennies ";
        return sum;
    }
    

    //*****************************Get Item*************************************************//
    
    @Override
    public Item getItem(long itemNumber) throws PersistenceException {
        return itemDao.getItem(itemNumber);
    }
    
    //*****************************Get Item*************************************************//

}
