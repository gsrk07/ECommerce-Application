package com.sriramcode.EcommerceShoppingApp.ShoppingCartandCheckout.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sriramcode.EcommerceShoppingApp.commons.models.BaseModel;
import com.sriramcode.EcommerceShoppingApp.user.models.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Entity
public class Cart extends BaseModel {

    private BigDecimal totalAmount = BigDecimal.ZERO;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CartItem> cartItems = new HashSet<>();

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public void addItem(CartItem cartItem) {
        cartItems.add(cartItem);
        cartItem.setCart(this);
        updateTotalAmount();
    }

    public void removeItem(CartItem cartItem) {
        cartItems.remove(cartItem);
        cartItem.setCart(null);
        updateTotalAmount();
    }

    private void updateTotalAmount() {
        this.totalAmount = cartItems.stream()
                .map(item -> {
                    BigDecimal unitPrice = item.getUnitPrice();
                    if(unitPrice == null) {
                        return BigDecimal.ZERO;
                    }
                    return unitPrice.multiply(BigDecimal.valueOf(item.getQuantity()));
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}