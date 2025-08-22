package com.sriramcode.EcommerceShoppingApp.products.dto;

import com.sriramcode.EcommerceShoppingApp.products.models.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductResponseSelf {
    private Product product;
    private String message;
}
