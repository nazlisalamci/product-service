package com.spring.productservice.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.productservice.enums.Language;
import com.spring.productservice.exception.enums.FriendlyMessageCodes;
import com.spring.productservice.exception.exceptions.ProductNotCreatedException;
import com.spring.productservice.repository.ProductRepository;
import com.spring.productservice.repository.entitiy.Product;
import com.spring.productservice.request.ProductCreateRequest;
import com.spring.productservice.request.ProductUpdatedRequest;
import com.spring.productservice.service.IProductRepositoryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductRepositoryImpl implements IProductRepositoryService {

    private final ProductRepository productRepository;

    @Override
    public Product createProduct(Language language, ProductCreateRequest productCreateRequest) {

        log.debug("[{}][createProduct] -> request: {}",this.getClass().getSimpleName(),productCreateRequest);
        try{
            Product product=Product.builder()
            .productName(productCreateRequest.getProductName())
            .quatity(productCreateRequest.getQuatity())
            .price(productCreateRequest.getPrice())
            .deleted(false)
            .build();
            Product productResponse=productRepository.save(product);
            log.debug("[{}][createProduct] -> response: {}",this.getClass().getSimpleName() , productResponse);
            return productResponse;
        }
        catch(Exception exception){
            throw new ProductNotCreatedException(language, FriendlyMessageCodes.PRODUCT_NOT_CREATED_EXCEPTION, "product request: "+productCreateRequest.toString());
        }
    }

    @Override
    public Product deleteProduct(Language language, Long productId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Product getProduct(Language language, Long productId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Product> getProduct(Language language) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Product updateProduct(Language language, Long productId, ProductUpdatedRequest productUpdatedRequest) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
