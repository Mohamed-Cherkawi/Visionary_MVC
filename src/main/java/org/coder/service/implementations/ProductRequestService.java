package org.coder.service.implementations;

import org.coder.entity.ProductRequest;
import org.coder.repository.ProductRequestRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductRequestService {

    private final ProductRequestRepository productRequestRepository;

    public ProductRequestService(ProductRequestRepository productRequestRepository) {
        this.productRequestRepository = productRequestRepository;
    }

    public ProductRequest saveRequest(ProductRequest productRequest) throws Exception {
        productRequestRepository.save(productRequest);
        System.out.println("product request was recorded successfully into db");
        return productRequest;
    }
    public ProductRequest findByReference(String reference) throws Exception { return productRequestRepository.findByReference(reference); }

    public List<ProductRequest> getProductRequests() throws Exception {
        List<ProductRequest> productRequests = productRequestRepository.getProductRequests();
        return productRequests;
    }

    @Transactional
    public void update(ProductRequest data) {
        System.out.println(data.getQuantity());
        Long id = data.getId();
       ProductRequest productRequest = productRequestRepository.findById(id);
       if(productRequest != null) {
           // Setting the new data given from the json object to the product request object
           productRequest.setProductReference(data.getProductReference());
           productRequest.setQuantity(data.getQuantity());
           productRequest.setStock(data.getStock());
           productRequest.setStatus(data.getStatus());
           productRequest.setSupplier(data.getSupplier());
           System.out.println("Updated successfuly");
       }
    }

    @Transactional
    public void setSupplier(ProductRequest data) {
        ProductRequest productRequest = productRequestRepository.findById(data.getId());

        productRequest.setSupplier(data.getSupplier());

        System.out.println("Supplier was changed successfully");
    }

    public void delete(Long id) {
        ProductRequest productRequest = productRequestRepository.findById(id);
        if( productRequest == null) {
            throw new IllegalStateException("The id : " + id + " does not exists in database");
        }
        productRequestRepository.delete(id);
        System.out.println("***************** deleted Successfully ******************");
    }
}

