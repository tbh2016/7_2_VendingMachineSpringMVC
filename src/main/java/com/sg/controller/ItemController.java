/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.controller;

import com.sg.dao.PersistenceException;
import com.sg.dto.Item;
import com.sg.servicelayer.ServiceLayer;
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
public class ItemController {

    ServiceLayer service;

    @Inject
    public ItemController(ServiceLayer service) {
        this.service = service;
    }

    @RequestMapping(value = "/Items", method = RequestMethod.GET)
    public String showItem(HttpServletRequest request, Model model) throws PersistenceException {

        List<Item> itemList = service.getAllItemsAvailable();   //load all items

        String itemIdParameter = request.getParameter("ItemNumbersssss");   //get itemId
        int itemId = Integer.parseInt(itemIdParameter);     //parsed to integer
        
        String totalParameter = request.getParameter("total");
        
        model.addAttribute("itemId", itemId);       //added to model
        model.addAttribute("itemListsss", itemList);    //added to model
        model.addAttribute("total", totalParameter);

        return "index";     
    }
    
}
