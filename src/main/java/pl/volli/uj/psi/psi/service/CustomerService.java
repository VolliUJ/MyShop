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
import pl.volli.uj.psi.psi.repository.CustomerRepositoryInterface;

/**
 *
 * @author Volli
 */
@Service
public class CustomerService implements CustomerServiceInterface{
    @Autowired    
    CustomerRepositoryInterface customers;
    @Autowired
    OrderServiceInterface orderService;
    private Customer current;
    
    public List<Customer> getAllCustomer() {
        return customers.getAllCustomer();
        
    }
    
    private Customer findCustomer(String name){
        List<Customer> list = getAllCustomer();
        for (Customer c : list){
            if (name.equals(c.getLogin())) return c;
        }
        throw new IllegalArgumentException("Niepoprawny login lub haslo.");
    }
    
    public Customer login(String name, String password){
        Customer c = findCustomer(name);
        
        if (password.equals(c.getPassword())) {
            current = c;
            return c;
        }
        throw new IllegalArgumentException("Niepoprawny login lub haslo.");
    }
    
    public Customer getCurrentUser(){
        
        return current;
    }
    public void logOut(){
        current = null;
    }
    public Customer addCustomer(Customer customer){
        orderService.addOrder(customer);
        return customers.addCustomer(customer);
    }
}
