/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.volli.uj.psi.psi.service;

import java.util.List;
import pl.volli.uj.psi.psi.model.Customer;


/**
 *
 * @author Volli
 */
public interface CustomerServiceInterface {
    public List <Customer> getAllCustomer();
    public Customer login(String name, String password);
    public Customer getCurrentUser();
    public void logOut();
    public Customer addCustomer(Customer customer);
}
