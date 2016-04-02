/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.volli.uj.psi.psi.controller;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.volli.uj.psi.psi.model.Product;
import pl.volli.uj.psi.psi.model.User;

import pl.volli.uj.psi.psi.repository.ProductRepository;
import pl.volli.uj.psi.psi.repository.ProductRepositoryInterface;
import pl.volli.uj.psi.psi.service.CustomerServiceInterface;
import pl.volli.uj.psi.psi.service.ProductServiceInterface;



/**
 *
 * @author Volli
 */
@RequestMapping("/products")
@Controller
public class ProductController {
    
    @Autowired
    ProductServiceInterface in;
    
    @Autowired
    CustomerServiceInterface customerService;
    
    @Autowired
    ProductRepositoryInterface repo;

    @RequestMapping("/all")
    public ModelAndView all(){
        ModelAndView model = new ModelAndView("products");
        model.addObject("products", in.getAllProduct() );
        model.addObject("currentUser", customerService.getCurrentUser());
        return model;
    }

    @RequestMapping("/{category}")
    public String getProductsByCategory(Model model, @PathVariable String category){
        model.addAttribute("products", in.getProductsByCategory(category));
        return "products";
    }

    @RequestMapping("/filter/{byCriteria}")
    public String getProductsByFilter(@MatrixVariable(pathVar="byCriteria") Map<String,List<String>> byCriteria, Model model){
        model.addAttribute("products", in.getProductsByFilter(byCriteria));
        return "products";
    }
    
    @RequestMapping("/product")
    public String getProductById(@RequestParam String id, Model model){
        model.addAttribute("product", repo.getProductById(id));
        return "product";
    }
  
    @RequestMapping(value="/add", method=RequestMethod.GET)
    public String getAddNewProductForm(Model model) {
        Product newProduct = new Product() ;
        model.addAttribute("newProduct", newProduct);
        return "addProduct";
    }
  
    @RequestMapping(value="/add", method=RequestMethod.POST)
    public String processAddNewProductForm(@ModelAttribute("newProduct") Product newProduct) {
        in.addProduct(newProduct) ;
        return "redirect:/products/all.htm"; 
    }
    /*

    
    @RequestMapping(value="/add", method=RequestMethod.POST)
    public String processAddNewProductForm(@ModelAttribute("newProduct") Product newProduct) {
        in.addProduct(newProduct) ;
        return "redirect:/products/all.htm"; 
    }
*/
 
}