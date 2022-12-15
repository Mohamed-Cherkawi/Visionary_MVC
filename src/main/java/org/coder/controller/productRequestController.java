package org.coder.controller;

import org.coder.entity.ProductRequest;
import org.coder.service.implementations.ProductRequestService;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("api/request-order")
public class productRequestController {
    private final ProductRequestService productRequestService;

    public productRequestController(ProductRequestService productRequestService) {
        this.productRequestService = productRequestService;
    }

    @GetMapping("/show")
    public List<ProductRequest> getProductRequests() throws Exception {
            return productRequestService.getProductRequests();
    }
    @GetMapping("/show/{requestReference}")
    public ProductRequest getRequestByReference(@PathVariable("requestReference") String reference) throws Exception {
        return productRequestService.findByReference(reference);
    }

    @PostMapping("/add")
    public void createNewRequest(@RequestBody ProductRequest productRequest) throws Exception { productRequestService.saveRequest(productRequest); }

    @PutMapping("/update")
    public void updateRequest(@RequestBody ProductRequest productRequest) { productRequestService.update(productRequest); }
    @PatchMapping("/set-supplier")
    public void setRequestSupplier(@RequestBody ProductRequest productRequest){ productRequestService.setSupplier(productRequest); }

    @DeleteMapping(path = "/delete/{requestId}")
    public void deleteRequest(@PathVariable("requestId") Long id){
        productRequestService.delete(id);
    }

}