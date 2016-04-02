/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.volli.uj.psi.psi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.volli.uj.psi.psi.service.CustomerServiceInterface;

/**
 *
 * @author Volli
 */
@Controller
public class CustomerController {
    
    @Autowired
    private CustomerServiceInterface customers;
    
    @RequestMapping("/customers")
    public ModelAndView load(){
        ModelAndView model = new ModelAndView("customers");
        model.addObject("customers", customers.getAllCustomer());
        return model;
    }
    
}
