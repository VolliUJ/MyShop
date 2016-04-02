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

/**
 *
 * @author Volli
 */
@Repository
public class CustomerRepository implements CustomerRepositoryInterface{

    private List<Customer> list = new ArrayList<Customer>();
    
    public CustomerRepository(){
        list.add(new Customer("admin", "admin", "su", "Admin", "Szkolna 77"));
        list.add(new Customer("a", "a", "c001", "Adman", "Szkolna 77"));
        list.add(new Customer("b", "b", "c002", "Roman", "Glowna 7"));
        list.add(new Customer("c", "c", "c003", "Kasia", "Wawozowa 11"));
        list.add(new Customer("d", "d", "c004", "Asia", "Jagiellonska 4"));
    }
    public List<Customer> getAllCustomer() {
        return list;
    }
    
    public Customer addCustomer(Customer customer){
        list.add(customer);
        return customer;
    }
    


    
    
}
