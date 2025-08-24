package com.sriramcode.EcommerceShoppingApp.products.controlleradvice;

import com.sriramcode.EcommerceShoppingApp.products.dto.ProductResponseSelf;
import com.sriramcode.EcommerceShoppingApp.products.exception.ProductNotPresentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductControllerAdvice {
    @ExceptionHandler(ProductNotPresentException.class)
    public ResponseEntity<ProductResponseSelf> handleInvalidProduct(){
        ProductResponseSelf productResponseSelf = new ProductResponseSelf(null,
                "Product Doesn't exist from contorller advice ");
        return new ResponseEntity<>(
                productResponseSelf, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ProductResponseSelf> handleArithmaticException(){
        ProductResponseSelf productResponseSelf = new ProductResponseSelf(null,
                "Something went wrong from contorller advice ");
        return new ResponseEntity<>(
                productResponseSelf, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
