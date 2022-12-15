package org.coder.repository;

import lombok.RequiredArgsConstructor;
import org.coder.entity.ProductRequest;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository @RequiredArgsConstructor
public class ProductRequestRepository  {
    private final HibernateTemplate hibernateTemplate;

    @Transactional
    public void save(ProductRequest productRequest) throws Exception {
        hibernateTemplate.save(productRequest);
    }
    public ProductRequest findById(Long id) {
        return hibernateTemplate.get(ProductRequest.class,id);
    }
    public ProductRequest findByReference(String reference) throws Exception {
        return null;
    }
    public List<ProductRequest> getProductRequests() throws Exception {
        return hibernateTemplate.loadAll(ProductRequest.class);
    }
    @Transactional
    public void update(ProductRequest data) {

    }
    @Transactional
    public void setSupplier(ProductRequest data) {

    }
    @Transactional
    public void delete(Long id) {
        ProductRequest productRequest = findById(id);
        if(productRequest != null)
        hibernateTemplate.delete(productRequest);
    }
}
