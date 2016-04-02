/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.volli.uj.psi.psi.service;

import java.util.List;
import pl.volli.uj.psi.psi.model.Customer;
import pl.volli.uj.psi.psi.model.Order;

/**
 *
 * @author Volli
 */
public interface OrderServiceInterface {
    public void processOrder(String productId, int count);
    public List<Order> getCustomerOrders(String customer); 
    public Order getOpenOrder(Customer customer);
    public void addOrder(Customer customer);
    public List<Order>getComplitedOrder();
    public Order getOrderById(String id);
}
