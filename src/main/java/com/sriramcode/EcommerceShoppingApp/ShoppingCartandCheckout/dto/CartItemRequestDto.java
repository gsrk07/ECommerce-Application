package com.sriramcode.EcommerceShoppingApp.ShoppingCartandCheckout.dto;

import com.sriramcode.EcommerceShoppingApp.products.dto.ProductDto;

import java.math.BigDecimal;

public class CartItemRequestDto {
    private Long itemId;
    private Integer quantity;
    private BigDecimal unitPrice;
    private ProductDto product;
}
