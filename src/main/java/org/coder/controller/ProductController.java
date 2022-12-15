package org.coder.controller;

import org.coder.entity.Product;
import org.coder.service.implementations.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api")
public class ProductController {
    private final ModelAndView modelAndView = new ModelAndView();
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ModelAndView getAllProducts(){
        List<Product> products = productService.getAllProducts();
        modelAndView.setViewName("products");
        modelAndView.addObject("products",products);
        return modelAndView;
    }
    @GetMapping("/show/{productId}")
    public ModelAndView getProductById(@PathVariable("productId") Long id){
        Product product = productService.getProductById(id);
        if( product != null ){
            modelAndView.setViewName("product");
            modelAndView.addObject("product",product);
        }else {
            modelAndView.setViewName("error404");
        }
        return modelAndView;
    }
}
