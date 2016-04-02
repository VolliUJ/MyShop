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
public class Product {
    
    private String productID;
    private String name;
    private Double unitPrice;
    private String description;

    @Override
    public boolean equals(Object obj) {
        Product p = (Product) obj;
        if (p.getProductID().equals(this.productID)) return true;
        return false;
    }
    private String manufacturer;
    private String category;
    private long unitsInStock;
    private long unitsInOrder;
    private String condition;
    private boolean discontinued;
    
    public Product(){
        super();
    }
    
    public Product(String productId, String name, Double unitPrice){
        this.name = name;
        this.productID = productId;
        this.unitPrice=unitPrice;
        this.unitsInOrder=1;
    }

    
    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(long unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public long getUnitsInOrder() {
        return unitsInOrder;
    }

    public void setUnitsInOrder(long unitsInOrder) {
        this.unitsInOrder = unitsInOrder;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public boolean isDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(boolean discontinued) {
        this.discontinued = discontinued;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString(){
        return "ProduktID: " + productID + " name: " + name;
    }
}
