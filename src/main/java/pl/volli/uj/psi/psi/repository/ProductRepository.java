/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.volli.uj.psi.psi.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.stereotype.Repository;
import pl.volli.uj.psi.psi.model.Product;

/**
 *
 * @author Volli
 */
@Repository
public class ProductRepository implements ProductRepositoryInterface{
    
    private List<Product> listOfProducts = new ArrayList<Product>();
    
    public ProductRepository(){
        Product iphone = new Product("P1234", "iPhone5s", 500.0);
        iphone.setDescription("Apple iphone 5s, super telefon");
        iphone.setCategory("Smartphone");
        iphone.setManufacturer("Apple");
        iphone.setUnitsInStock(1000);

        Product laptop = new Product("P1235", "Dell Inspirion", 700.0);
        laptop.setDescription("Super laptop Dell");
        laptop.setCategory("Laptop");
        laptop.setManufacturer("Dell");
        laptop.setUnitsInStock(100);
        
        Product tablet = new Product("P1236", "Nexus", 500.0);
        tablet.setDescription("Super tablet mega");
        tablet.setCategory("tablet");
        tablet.setManufacturer("Google");
        tablet.setUnitsInStock(200);
        
        listOfProducts.add(iphone);
        listOfProducts.add(laptop);
        listOfProducts.add(tablet);
    
    }
    
    public List<Product> getAllProduct() {
        return listOfProducts;
    }

    public Product getProductById(String id) {
        for (Product p : listOfProducts){
            if (p!= null)
                if (p.getProductID().equals(id)) return p;
        }
        throw new IllegalArgumentException("Brak towaru o id: " + id);
    }

    public List<Product> getProductsByCategory(String category) {
        List<Product> list = new ArrayList<Product>();
        
        for(Product p : listOfProducts){
            if(category.equalsIgnoreCase(p.getCategory())) list.add(p);
        }
        return list;
    }
    
    public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams){
        Set<Product> productByBrand = new HashSet<Product>();
        Set<Product> productsByCategory = new HashSet<Product>();
        Set<String> criterias = filterParams.keySet();
        if (criterias.contains("brand")){
            for(String brandName: filterParams.get("brand")){
                for(Product product: listOfProducts){
                    if(brandName.equalsIgnoreCase(product.getManufacturer())) productByBrand.add(product);
                }
            }
        }
        if(criterias.contains("category")){
            for(String category: filterParams.get("category")){
                productsByCategory.addAll(this.getProductsByCategory(category));
            }
        }
        productsByCategory.retainAll(productByBrand);
        return productsByCategory;
    }
    
    public void addProduct(Product p){
        listOfProducts.add(p);
    }
    
}