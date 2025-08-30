package com.sriramcode.EcommerceShoppingApp.ShoppingCartandCheckout.service;

import com.stripe.exception.StripeException;

import java.util.List;

public interface ICheckoutService {
    StripeResponseDto createSession(List<CheckoutItemRequestDto> checkoutItemDtoList) throws StripeException;
}
