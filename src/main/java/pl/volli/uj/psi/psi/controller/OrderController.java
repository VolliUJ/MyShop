/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.volli.uj.psi.psi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.volli.uj.psi.psi.model.Customer;
import pl.volli.uj.psi.psi.model.Order;
import pl.volli.uj.psi.psi.service.CustomerServiceInterface;
import pl.volli.uj.psi.psi.service.OrderServiceInterface;
import sun.util.calendar.LocalGregorianCalendar;

/**
 *
 * @author Volli
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    public OrderServiceInterface orderService;
    
    @Autowired
    public CustomerServiceInterface customerServiceInterface;
    
    @RequestMapping(value="/basket", method = RequestMethod.GET)
    public String basket(Model model){
        Order order = orderService.getOpenOrder(customerServiceInterface.getCurrentUser());
        model.addAttribute("order", order);
        model.addAttribute("itemList", order.getListOfProduct());
        return "basket";
    }
    
    @RequestMapping("/confirmedOrders")
    public String showOrders(Model model){
        model.addAttribute("orders", orderService.getComplitedOrder());
        return "ordersList";
    }

    
    @RequestMapping("/confirmed")
    public String basketpost(Model model){
     //   System.out.print(LocalGregorianCalendar.Date.TIME_UNDEFINED);
        Customer user = customerServiceInterface.getCurrentUser();
        Order order = orderService.getOpenOrder(user);
        if (order.getListOfProduct().size() > 0){
            order.setStatus(Order.Status.CONFIRMED);
            order.setOwnerName(user.getName());
            user.setNoOfOrdersMade(user.getNoOfOrdersMade()+1);
        }
        return "redirect:/products/all.htm";
    }
    
    @RequestMapping("/orderProduct")
    public String process(@RequestParam String id, Model model){
        model.addAttribute("itemList", orderService.getOrderById(id).getListOfProduct());
        return "orderProducts";
    }
                
            
            
    @RequestMapping("/{productID}/{quantity}")
    public String process(@PathVariable String productID, @PathVariable int quantity){
        orderService.processOrder(productID, quantity);
        orderService.getOpenOrder(customerServiceInterface.getCurrentUser());
        return "redirect:/products/all.htm";
    }
    
    
}
