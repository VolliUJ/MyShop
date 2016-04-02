/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.volli.uj.psi.psi.model;

/**
 *
 * @author Volli
 */
public class Customer extends User{
    private String customerId;
    private String name;
    private String address;
    private int noOfOrdersMade;
    private Order currentOrder;
    
    public String getCustomerId() {
        return customerId;
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }

    public void setCurrentOrder(Order currentOrder) {
        this.currentOrder = currentOrder;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNoOfOrdersMade() {
        return noOfOrdersMade;
    }

    public void setNoOfOrdersMade(int noOfOrdersMade) {
        this.noOfOrdersMade = noOfOrdersMade;
    }
    
    public Customer(String login, String password, String customerId, String name, String address){
        super(login, password);
        this.customerId = customerId;
        this.address = address;
        this.name = name;
        noOfOrdersMade = 0;
    }
    
    public Customer(){
        noOfOrdersMade = 0;
        
    }
    
    @Override
    public String toString(){ 
        return name;
    }
}
