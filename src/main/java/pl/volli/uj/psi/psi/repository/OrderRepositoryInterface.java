/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.volli.uj.psi.psi.repository;

import java.util.List;
import pl.volli.uj.psi.psi.model.Customer;
import pl.volli.uj.psi.psi.model.Order;

/**
 *
 * @author Volli
 */
public interface OrderRepositoryInterface {
    public List<Order> getAllOrders();
    public List<Order> getOrdersById(String customer);
    public Order getOpenOrder(Customer customer);
    public void addOrder(Order order);
    public List<Order>getComplitedOrder();
    public Order getOrderId(String id);
}
