/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.servicelayer;

import com.sg.dao.PersistenceException;
import com.sg.dto.Item;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author yingy
 */
public interface ServiceLayer {

    List<Item> getAllItemsAvailable() throws PersistenceException;

    List<Item> checkInventory(List<Item> itemList) throws PersistenceException;

    Item dispenseItem(Item item) throws PersistenceException;

    Item decrementInventory(Item item) throws PersistenceException;
    
    Item addItem(Long itemId, Item item) throws PersistenceException;
    
    BigDecimal addDollar() throws PersistenceException;
    BigDecimal addQuarter() throws PersistenceException;
    BigDecimal addDime() throws PersistenceException;
    BigDecimal addNickel() throws PersistenceException;
       
    String showChange(BigDecimal total) throws PersistenceException;
    BigDecimal returnChange() throws PersistenceException;
    
    Item getItem(long itemNumber) throws PersistenceException;
}

