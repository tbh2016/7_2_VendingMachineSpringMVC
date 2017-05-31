/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dto;

import java.math.BigDecimal;

/**
 *
 * @author yingy
 */
public class Item {
    
    private Long itemId;
    private String itemName;
    private BigDecimal itemPrice;
    private int quantity; 

    public Item(Long itemId) {
        this.itemId = itemId;
    }

    
    public Long getItemId() {
        return itemId;
    }


    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }
    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    @Override
    public String toString(){
        return "ID: " + itemId + " |Name: " + itemName + " |Price: " +  itemPrice 
                + " |Quantity: " + quantity;
                
    }
    
}
