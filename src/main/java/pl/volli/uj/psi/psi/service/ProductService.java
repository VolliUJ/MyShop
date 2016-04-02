/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.volli.uj.psi.psi.service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.volli.uj.psi.psi.model.Product;
import pl.volli.uj.psi.psi.repository.ProductRepositoryInterface;

/**
 *
 * @author Volli
 */
@Service
public class ProductService implements ProductServiceInterface{

    @Autowired
    ProductRepositoryInterface in;

    
    public List<Product> getAllProduct() {
        return in.getAllProduct();
    }
    public List<Product> getProductsByCategory(String category){
        return in.getProductsByCategory(category);
    }
    
    public Set<Product> getProductsByFilter (Map<String, List<String>> filterParams){
        return in.getProductsByFilter(filterParams);
    }
    public Product getProductById(String id){
        return in.getProductById(id);
    }
    public void addProduct(Product p){
        in.addProduct(p);
    }
}
