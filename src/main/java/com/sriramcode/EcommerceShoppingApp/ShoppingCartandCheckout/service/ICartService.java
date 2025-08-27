package com.sriramcode.EcommerceShoppingApp.ShoppingCartandCheckout.service;

import com.sriramcode.EcommerceShoppingApp.ShoppingCartandCheckout.models.Cart;
import com.sriramcode.EcommerceShoppingApp.user.models.User;

import java.math.BigDecimal;

public interface ICartService {
    Cart getCart(Long cartId);
    void clearCart(Long cartId);
    BigDecimal getTotalPrice(Long cartId);
    Cart initializeNewCart(User user);
    Cart getCartByUserId(Long userId);
}
