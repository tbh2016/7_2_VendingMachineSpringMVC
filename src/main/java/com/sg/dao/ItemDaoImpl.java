/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dao;

import com.sg.dto.Item;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author yingy
 */
public class ItemDaoImpl implements ItemDao {
    
    
    private Map<Long, Item> items = new HashMap<>();
    
    public static final String MENU_FILE = "C:\\Users\\Thuan\\Documents\\GitHub\\7_2_VendingMachineSpringMVC\\menu.txt";
    public static final String DELIMITER = "::";
    
    
    @Override
    public List<Item> getAllItemsAvailable() throws PersistenceException{
        loadVMTextItem();

        return new ArrayList<Item>(items.values());
    }
    
    
    @Override
    public List<Item> checkInventory(List<Item> itemList) throws PersistenceException {                 
        return itemList
                .stream()
                .filter(item -> item.getQuantity()> 0)
                .collect(Collectors.toList());
    }
    
   @Override
    public Item dispenseItem(Item item) throws PersistenceException {
        loadVMTextItem();
        
        Item dispensedItem = items.remove(item.getItemId());
        
        writeVMTextItem();
        return dispensedItem;
    }
    
    @Override
    public Item decrementInventory(Item item) throws PersistenceException{
        item.setQuantity(item.getQuantity()-1);
        return item;
    }
    
    @Override
    public  Item addItem(Long itemId, Item item) throws PersistenceException{
        Item newItem = items.put(itemId, item);
        loadVMTextItem(); 
        writeVMTextItem();  
        return newItem;
    }
    
    @Override
    public Item getItem(long itemNumber) throws PersistenceException {
        loadVMTextItem();
        return items.get(itemNumber);
    }
    
    private void loadVMTextItem() throws PersistenceException{
        Scanner scanner;
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(MENU_FILE)));
        } catch (FileNotFoundException e) {
            throw new PersistenceException(
                    "-_- Could not load vm data into memory.",e);
        }       
        String currentLine;
        String[] currentTokens; 
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            
            Item currentItem = new Item(Long.parseLong(currentTokens[0]));
            
            currentItem.setItemName(currentTokens[1]);
            currentItem.setItemPrice(new BigDecimal(currentTokens[2]));
            currentItem.setQuantity(Integer.parseInt((currentTokens[3])));
            
            items.put(currentItem.getItemId(), currentItem);
        }
         scanner.close();
    }

    
    private void writeVMTextItem() throws PersistenceException{
        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(MENU_FILE));
        } catch (IOException e) {
            throw new PersistenceException(
                    "Could not save student data.", e);
        }  
        List<Item> items = this.getAllItemsAvailable();
        for (Item i : items) {
            out.println(i.getItemId() + DELIMITER
                    + i.getItemName() + DELIMITER
                    + i.getItemPrice() + DELIMITER
                    + i.getQuantity());    
            out.flush();
        }
        out.close();
    }

}
    


    
    


