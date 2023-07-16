package com.spring.productservice.service;

import java.util.List;

import com.spring.productservice.enums.Language;
import com.spring.productservice.repository.entitiy.Product;
import com.spring.productservice.request.ProductCreateRequest;
import com.spring.productservice.request.ProductUpdatedRequest;

public interface IProductRepositoryService {

    Product createProduct(Language language,ProductCreateRequest productCreateRequest);

    Product getProduct (Language language , Long productId);

    List<Product> getProduct(Language language);

    Product updateProduct(Language language,Long productId , ProductUpdatedRequest productUpdatedRequest);

    Product deleteProduct(Language language,Long productId);
}
