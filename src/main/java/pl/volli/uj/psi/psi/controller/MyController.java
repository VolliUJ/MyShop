/*
 * Copyright 2011-08-31 the original author or authors.
 */
package pl.volli.uj.psi.psi.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import pl.volli.uj.psi.psi.model.Customer;
import pl.volli.uj.psi.psi.model.User;
import pl.volli.uj.psi.psi.service.CustomerService;
import pl.volli.uj.psi.psi.service.CustomerServiceInterface;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */

@Controller
public class MyController {
    
    @Autowired
    private CustomerServiceInterface customerService;
    
    @RequestMapping("/home")
    public String home(Model model) {
        
        Customer current = customerService.getCurrentUser();
        if (current == null)  return "redirect:/login.htm"; 
        return "redirect:/products/all.htm"; 
    }
    
}
