/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.volli.uj.psi.psi.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.volli.uj.psi.psi.model.Customer;
import pl.volli.uj.psi.psi.model.Order;
import pl.volli.uj.psi.psi.model.Product;
import pl.volli.uj.psi.psi.repository.OrderRepositoryInterface;
import pl.volli.uj.psi.psi.repository.ProductRepositoryInterface;

/**
 *
 * @author Volli
 */
@Service
public class OrderService implements OrderServiceInterface{
    @Autowired
    public ProductRepositoryInterface productRepository;
    @Autowired
    public CustomerServiceInterface customerService;
    @Autowired
    public OrderRepositoryInterface orderRepository;
    
    public void processOrder(String productId, int count) {
        Product productById = productRepository.getProductById(productId);
        if(productById.getUnitsInStock() < count){
            throw new IllegalArgumentException("Zbyt malo towaru. Obecna liczba sztuk w magazynie:" + productById.getUnitsInStock());
        }
        productById.setUnitsInStock(productById.getUnitsInStock()-count);
        Order order = getOpenOrder(customerService.getCurrentUser());
        order.addProduct(productById);
    }
    
    public Order getOpenOrder(Customer customer){
        return orderRepository.getOpenOrder(customer);
    }
    
    public List<Order>getComplitedOrder(){
        return orderRepository.getComplitedOrder();
    }
    
    public List<Order> getCustomerOrders(String customer){
        return orderRepository.getOrdersById(customer);  
    }
    
    public void addOrder(Customer customer){
        Order order = new Order(customer.getLogin(), "01-02-2016", customer.getAddress());
        orderRepository.addOrder(order);
    }
    public Order getOrderById(String id){
        return orderRepository.getOrderId(id);
    }
    
}
