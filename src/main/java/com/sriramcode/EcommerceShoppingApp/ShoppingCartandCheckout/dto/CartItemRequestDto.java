package com.sriramcode.EcommerceShoppingApp.ShoppingCartandCheckout.dto;

import java.math.BigDecimal;

public class CartItemRequestDto {
    private Long itemId;
    private Integer quantity;
    private BigDecimal unitPrice;
    private ProductDto product;
}
