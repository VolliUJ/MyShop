/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.volli.uj.psi.psi.service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import pl.volli.uj.psi.psi.model.Product;

/**
 *
 * @author Volli
 */
public interface ProductServiceInterface {
    public List<Product> getAllProduct();
    public List<Product> getProductsByCategory(String category);
    public Set<Product> getProductsByFilter (Map<String, List<String>> filterParams) ; 
    public Product getProductById(String id);
    public void addProduct(Product p);
}
