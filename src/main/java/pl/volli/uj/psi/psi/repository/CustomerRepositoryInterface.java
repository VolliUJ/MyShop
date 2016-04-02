/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.volli.uj.psi.psi.repository;

import java.util.List;
import pl.volli.uj.psi.psi.model.Customer;

/**
 *
 * @author Volli
 */
public interface CustomerRepositoryInterface {
    public List <Customer> getAllCustomer();
    public Customer addCustomer(Customer customer);
    
}
