/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.volli.uj.psi.psi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import pl.volli.uj.psi.psi.model.Customer;
import pl.volli.uj.psi.psi.model.User;
import pl.volli.uj.psi.psi.service.CustomerServiceInterface;

/**
 *
 * @author Volli
 */
@Controller
public class LoginController {
    
    @Autowired
    private CustomerServiceInterface customerService;
    
    
    @RequestMapping(value="/register", method=RequestMethod.GET)
    public String getAddNewCustomerForm(Model model) {
        Customer newCustomer = new Customer();
        model.addAttribute("newCustomer", newCustomer);
        return "addCustomer";
    }
  
    @RequestMapping(value="/register", method=RequestMethod.POST)
    public String processAddNewCustomerForm(@ModelAttribute("newCustomer") Customer newCustomer) {
        customerService.addCustomer(newCustomer) ;
       return "redirect:/login.htm"; 
    }
    
    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login(Model model){
        User user = new User();
        model.addAttribute("loginUser", user);
        return "login";
    }

    @RequestMapping(value ="/login", method = RequestMethod.POST)
    public String verifyLogin(@ModelAttribute ("loginUser") User user, Model model){
    
        String errorMessage = "Bledna nazwa uzytkownika lub haslo";
        try{
            Customer customer = customerService.login(user.getLogin(), user.getPassword());
            return "redirect:/products/all.htm"; 
        } catch (IllegalArgumentException e){
            model.addAttribute("errorMessage", errorMessage);
            return "login";
        }
    }
    
    @RequestMapping(value="/loginfailed", method = RequestMethod.GET)
    public String loginerror(Model model){
        model.addAttribute("error", "true");
        return "login";
    }
    
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout(Model model){
        customerService.logOut();
        return "redirect:/";
    }
    
}
