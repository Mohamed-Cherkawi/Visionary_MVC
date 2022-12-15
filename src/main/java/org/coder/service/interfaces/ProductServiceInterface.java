package org.coder.service.interfaces;

import org.coder.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductServiceInterface {
    Product saveProduct(Product product);
    List<Product> getAllProducts();
}
