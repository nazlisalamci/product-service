package com.spring.productservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.productservice.enums.Language;
import com.spring.productservice.exception.enums.FriendlyMessageCodes;
import com.spring.productservice.exception.utils.FriendlyMessageUtils;
import com.spring.productservice.repository.entitiy.Product;
import com.spring.productservice.request.ProductCreateRequest;
import com.spring.productservice.response.FriendlyMessage;
import com.spring.productservice.response.InternalApiResponse;
import com.spring.productservice.response.ProductResponse;
import com.spring.productservice.service.IProductRepositoryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "api/1.0/product")
@RequiredArgsConstructor
class ProductController {
    private final IProductRepositoryService productRepositoryService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "{language}/created")
    public InternalApiResponse<ProductResponse> createResponse(@PathVariable("language") Language language,
    @RequestBody ProductCreateRequest productCreateRequest ){
        log.debug("[{}][createProduct] -> request: {}",this.getClass().getSimpleName(), productCreateRequest);
        Product product=productRepositoryService.createProduct(language, productCreateRequest);
        ProductResponse productResponse=convertProductResponse(product);
        log.debug("[{}][createProduct] -> request: {}", this.getClass().getSimpleName(), productResponse);
        return InternalApiResponse.<ProductResponse>builder()
        .friendlyMessage(FriendlyMessage.builder()
        .title(FriendlyMessageUtils.getFriendlyMessage(language, FriendlyMessageCodes.SUCCESS))
        .description(FriendlyMessageUtils.getFriendlyMessage(language,FriendlyMessageCodes.PRODUCT_SUCCESSFULLY_CREATED))
        .build())
        .httpStatus(HttpStatus.CREATED)
        .hasError(false)
        .payload(productResponse)
        .build();
    }
    private ProductResponse convertProductResponse(Product product){
        return ProductResponse.builder()
        .productId(product.getProductId())
        .productName(product.getProductName())
        .quantity(product.getQuatity())
        .price(product.getPrice())
        .productCreatedDate(product.getProductCreatedDate().getTime())
        .productUpdatedDate(product.getProductUpdatedDate().getTime())
        .build();
    }
        
}
