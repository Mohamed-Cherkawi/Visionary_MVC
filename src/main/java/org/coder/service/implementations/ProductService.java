package org.coder.service.implementations;

import org.coder.entity.Product;
import org.coder.repository.ProductRepository;
import org.coder.service.interfaces.ProductServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product saveProduct(Product product) {
        return productRepository.saveProduct(product);
    }
    public List<Product> getAllProducts() {
        List<Product> products = productRepository.getProducts();
        if( products.size() == 0  ){
            return null;
        }
         return products;
    }
    public Product getProductById(Long id){
        return productRepository.getProductById(id);
    }
}
