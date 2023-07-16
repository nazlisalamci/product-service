package com.spring.productservice.repository.entitiy;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product", schema = "stock_managment")
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "quatity")
    private int quatity;

    @Column(name = "price")
    private double price;

    @Builder.Default
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "product_updated_date")
    @JsonFormat(pattern = "yyy-MM-dd")
    private Date productUpdatedDate = new Date();

    @Builder.Default
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "product_created_date")
    @JsonFormat(pattern = "yyy-MM-dd")
    private Date productCreatedDate = new Date();

    @Column(name = "id_deleted")
    private boolean deleted;

}
