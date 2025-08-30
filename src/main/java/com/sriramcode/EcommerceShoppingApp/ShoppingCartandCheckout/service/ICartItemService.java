package com.sriramcode.EcommerceShoppingApp.ShoppingCartandCheckout.service;

import com.sriramcode.EcommerceShoppingApp.ShoppingCartandCheckout.models.CartItem;

public interface ICartItemService {
    void addCartItem(Long cartId, Long productId, int quantity) throws ProductNotPresentException;
    void removeCartItem(Long cartId, Long productId) throws ProductNotPresentException;
    void updateItemQuantity(Long cartId, Long productId, int quantity) throws ProductNotPresentException;

    CartItem getCartItem(Long cartId, Long productId);
}
