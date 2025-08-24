package com.sriramcode.EcommerceShoppingApp.products.exception;

public class ProductNotPresentException extends  RuntimeException{
    public ProductNotPresentException(String message) {
        super(message);
    }
}
