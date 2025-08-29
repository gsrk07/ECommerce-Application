package com.sriramcode.EcommerceShoppingApp.ShoppingCartandCheckout.repository;

import com.sriramcode.EcommerceShoppingApp.ShoppingCartandCheckout.models.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    void deleteAllByCartId(Long cartId);
}
