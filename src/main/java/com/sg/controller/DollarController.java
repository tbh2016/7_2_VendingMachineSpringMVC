/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.controller;

import com.sg.dao.PersistenceException;
import com.sg.dto.Item;
import com.sg.servicelayer.ServiceLayer;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author yingy
 */
@Controller
@RequestMapping(value = "/Dollar")
public class DollarController {

    ServiceLayer service;

    @Inject
    public DollarController(ServiceLayer service) {
        this.service = service;
    }

    BigDecimal total = new BigDecimal("0.00");
    BigDecimal bdZero = new BigDecimal("0");

    @RequestMapping(value = "/addDollar", method = RequestMethod.GET)
    public String addDollar(HttpServletRequest request, Model model) throws PersistenceException {
        List<Item> itemList = service.getAllItemsAvailable();
        BigDecimal sum = service.addDollar();
        sum.setScale(2, RoundingMode.HALF_UP);
        total = total.add(sum);

        String itemIdParameter = request.getParameter("ItemNumbersssss");   //get itemId

        model.addAttribute("itemListsss", itemList);
        model.addAttribute("total", total);
        model.addAttribute("itemId", itemIdParameter);       //added to model
        return "index";
    }

    @RequestMapping(value = "/addQuarter", method = RequestMethod.GET)
    public String addQuarter(HttpServletRequest request, Model model) throws PersistenceException {
        List<Item> itemList = service.getAllItemsAvailable();
        BigDecimal sum = service.addQuarter();
        sum.setScale(2, RoundingMode.HALF_UP);
        total = total.add(sum);

        String itemIdParameter = request.getParameter("ItemNumbersssss");   //get itemId

        model.addAttribute("itemListsss", itemList);
        model.addAttribute("total", total);
        model.addAttribute("itemId", itemIdParameter);       //added to model
        return "index";
    }

    @RequestMapping(value = "/addDime", method = RequestMethod.GET)
    public String addDime(HttpServletRequest request, Model model) throws PersistenceException {
        List<Item> itemList = service.getAllItemsAvailable();
        BigDecimal sum = service.addDime();
        sum.setScale(2, RoundingMode.HALF_UP);
        total = total.add(sum);

        String itemIdParameter = request.getParameter("ItemNumbersssss");   //get itemId

        model.addAttribute("itemListsss", itemList);
        model.addAttribute("total", total);
        model.addAttribute("itemId", itemIdParameter);       //added to model
        return "index";
    }

    @RequestMapping(value = "/addNickel", method = RequestMethod.GET)
    public String addNickel(HttpServletRequest request, Model model) throws PersistenceException {
        List<Item> itemList = service.getAllItemsAvailable();
        BigDecimal sum = service.addNickel();
        sum.setScale(2, RoundingMode.HALF_UP);
        total = total.add(sum);

        String itemIdParameter = request.getParameter("ItemNumbersssss");   //get itemId

        model.addAttribute("itemListsss", itemList);
        model.addAttribute("total", total);
        model.addAttribute("itemId", itemIdParameter);       //added to model
        return "index";
    }

    //*********************************RETURN MONEY******************************************//
    @RequestMapping(value = "/returnChange", method = RequestMethod.GET)
    public String returnChange(HttpServletRequest request, Model model) throws PersistenceException {
        List<Item> itemList = service.getAllItemsAvailable();
        String showChange = service.showChange(total);
        BigDecimal remove = service.returnChange();
        total = bdZero;

        model.addAttribute("itemListsss", itemList);
        model.addAttribute("showChange", showChange);
        model.addAttribute("remove", remove);
        return "index";
    }

    //*********************************PURCHASE ITEM******************************************//
    @RequestMapping(value = "/makePurchase", method = RequestMethod.GET)
    public String showItem(HttpServletRequest request, Model model) throws PersistenceException {
        

        String message = null;
        String getItemId = request.getParameter("ItemNumbersssss");
        
        if (getItemId != null && !getItemId.isEmpty()) {
            long longItemId = Long.parseLong(getItemId);
            Item currentItem = service.getItem(longItemId);

            if (currentItem.getQuantity() <= 0) {
                message = "Quantity is zero";
            } else if (total.compareTo(currentItem.getItemPrice()) == -1) {
                BigDecimal needMoreMoney = (currentItem.getItemPrice()).subtract(total);
                message = "Please insert more money " + needMoreMoney;
            } else if (total.compareTo(currentItem.getItemPrice()) == 1) {
                total = total.subtract(currentItem.getItemPrice());
                
                Item item =service.dispenseItem(currentItem);
                item = service.decrementInventory(item);
                service.addItem(currentItem.getItemId(), item);
                 
                message = "Thank You!!";
            }
        } else {
            message = "Please choose an item.";
        }
        List<Item> itemList = service.getAllItemsAvailable();
        model.addAttribute("itemListsss", itemList);
        model.addAttribute("total", total);
        model.addAttribute("message", message);

        return "index";
    }
}
