package com.sriramcode.EcommerceShoppingApp.products.dto;

import com.sriramcode.EcommerceShoppingApp.products.models.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
//@AllArgsConstructor


public class ProductResponseSelf {
    private Product product;
    private String message;

    public ProductResponseSelf(Product product, String message) {
        this.product = product;
        this.message = message;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
