package com.spring.productservice.request;

import lombok.Data;

@Data
public class ProductUpdatedRequest {
    private Long productId;
    private String productName;
    private Integer quatity;
    private Double price;    
}
