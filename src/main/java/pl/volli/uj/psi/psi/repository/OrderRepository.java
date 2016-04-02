/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.volli.uj.psi.psi.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import pl.volli.uj.psi.psi.model.Customer;
import pl.volli.uj.psi.psi.model.Order;

/**
 *
 * @author Volli
 */
@Repository
public class OrderRepository implements OrderRepositoryInterface{
    
    private List<Order> listOfOrders;
    
    public OrderRepository(){
        listOfOrders = new ArrayList<Order>(); 
  
    }
    
    public List<Order>getComplitedOrder(){
        List<Order> list = new ArrayList<Order>();
            for (Order o : listOfOrders){
                if (o.getStatus() == Order.Status.CONFIRMED) list.add(o);
            }
        return list;
    }
    
    public List<Order> getOrdersById(String customer){
        List<Order> orders = new ArrayList<Order>();
        for (Order o: listOfOrders){
            if (customer.equals(o.getOwner())) orders.add(o);
        }
        return orders;
    }
    
    public Order getOpenOrder(Customer customer){
        try{
            List <Order> listOrder = getOrdersById(customer.getLogin());
            for (Order order : listOrder){
                if (order.getStatus() == Order.Status.OPEN) return order;
            }
        }catch (NullPointerException e){
            Order o = new Order(customer.getLogin());
            o.setAddres(customer.getAddress());
            listOfOrders.add(o);
            return o;
        }
        Order o = new Order(customer.getLogin());
        o.setAddres(customer.getAddress());
        listOfOrders.add(o);
        return o;
    }
    
    public void addOrder(Order order){
        listOfOrders.add(order);
    }
    
    public List<Order> getAllOrders() {
        return listOfOrders;
    }
    
    public Order getOrderId(String id){
        for (Order o : listOfOrders){
            if (o.getId().equalsIgnoreCase(id)) return o;
        }
        return null;
    }
}
