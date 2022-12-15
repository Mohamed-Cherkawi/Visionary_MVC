package org.coder;

import lombok.RequiredArgsConstructor;
import org.coder.entity.Product;
import org.coder.entity.Stock;
import org.coder.repository.ProductRepository;
import org.coder.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.transaction.Transactional;
import java.util.List;

@Configuration @Transactional @RequiredArgsConstructor
public class Config {
    private final ProductRepository productRepository ;

    @Bean
    void persistingProducts(){
        System.out.println("Test");
        Stock stock1 = new Stock("Stock 1","Hay Sfa","06193373737","emailforstudy@gmail.ma","pass123");
        Stock stock2 = new Stock("Stock 2","Hay Drfa","0619333793","emailforstudy@gmail.com","pass345");

        Product product1 = new Product("MX 101 Z","Atlas Keyboard","Black Mechanical Keyboard ...",80.5f,30,stock1);
        Product product2 = new Product("AP X ","Iphone X Max","Black Iphone X Max 128 Gb storage and 4 Rom ...",55.8f,325,stock2);
        Product product3 = new Product("GB Y-3","GBL YouMusic Headphones","Brand new series of headphones comes with 4 colors ...",40f,950,stock1);

        productRepository.saveProduct(product1);
        productRepository.saveProduct(product2);
        productRepository.saveProduct(product3);



    }
}
