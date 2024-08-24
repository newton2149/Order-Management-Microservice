package com.navneeth.ProductService.services;

import com.navneeth.ProductService.model.ProductRequest;
import com.navneeth.ProductService.model.ProductResponse;

public interface ProductService {
    long addProduct(ProductRequest productRequest);

    ProductResponse getProductById(long productId);

    void reduceQuantity(long productId, long quantity);
}
