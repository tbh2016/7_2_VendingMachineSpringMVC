/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dao;

import com.sg.dto.Item;
import java.util.List;

/**
 *
 * @author THUAN HUYNH
 */
public interface ItemDao {
    
    List<Item> getAllItemsAvailable() throws PersistenceException;
    
    List<Item> checkInventory(List<Item> itemList) throws PersistenceException; 
    
    Item dispenseItem(Item item) throws PersistenceException;
    
    Item decrementInventory(Item item) throws PersistenceException;
    
    Item addItem(Long itemId, Item item) throws PersistenceException;
            
    Item getItem(long itemNumber) throws PersistenceException;
}
