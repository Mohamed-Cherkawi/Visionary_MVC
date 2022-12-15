package org.coder.service.interfaces;

import org.coder.entity.ProductRequest;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductRequestServiceInterface {
    ProductRequest saveRequest(ProductRequest productRequest) throws Exception;
    ProductRequest findByReference(String reference) throws Exception;
    List<ProductRequest> getProductRequests() throws Exception;
    void update(ProductRequest data);
    void setSupplier(ProductRequest data);
    void delete(Long id);
}
