package com.sriramcode.EcommerceShoppingApp.ShoppingCartandCheckout.service;

import com.sriramcode.EcommerceShoppingApp.ShoppingCartandCheckout.dto.CheckoutItemRequestDto;
import com.sriramcode.EcommerceShoppingApp.ShoppingCartandCheckout.dto.StripeResponseDto;
import com.stripe.exception.StripeException;

import java.util.List;

public interface ICheckoutService {
    StripeResponseDto createSession(List<CheckoutItemRequestDto> checkoutItemDtoList) throws StripeException;
}
