/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.volli.uj.psi.psi.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Volli
 */
public class Order {
    
    public enum Status{
        OPEN, CONFIRMED, COMPLITED
    }
    private Status status;
    private String owner;
    private static int idCounter = 0;
    private int id;
    private String date;
    private String addres;
    private List<Product> listOfProduct;
    private String ownerName;
    
    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    public Order(String owner){
        id = idCounter++;
        this.owner = owner;
        listOfProduct = new ArrayList<Product>();
        status = Status.OPEN;
    }
    
    public Order(String owner, String date, String addres){
        this(owner);
        this.date = date;
        this.addres = addres;
    }

    public String getOwner() {
    return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getId() {
        return Integer.toString(id);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public List<Product> getListOfProduct() {
        return listOfProduct;
    }

    public void addProduct(Product product){
        for (Product p : listOfProduct){
            if (p.equals(product)){
                p.setUnitsInOrder(p.getUnitsInOrder()+1);
                return;
            }
        }
        listOfProduct.add(product);
        
    }
    
    
}
