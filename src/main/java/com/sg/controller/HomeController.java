
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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author yingy
 */

@Controller
public class HomeController {
    
    ServiceLayer service;
    
    @Inject
    public HomeController(ServiceLayer service) {
        this.service = service;
    }
    
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String getItems(Model model) throws PersistenceException{
        List<Item> itemList = service.getAllItemsAvailable();
        
        model.addAttribute("itemListsss", itemList );
        return "index";
    }
}
