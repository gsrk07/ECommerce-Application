package com.sriramcode.EcommerceShoppingApp.ShoppingCartandCheckout.controller;

import com.sriramcode.EcommerceShoppingApp.ShoppingCartandCheckout.dto.CheckoutItemRequestDto;
import com.sriramcode.EcommerceShoppingApp.ShoppingCartandCheckout.dto.StripeResponseDto;
import com.sriramcode.EcommerceShoppingApp.commons.dto.ApiResponse;
import com.stripe.exception.StripeException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sriramcode.EcommerceShoppingApp.ShoppingCartandCheckout.service.CheckoutService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api_prefix}/checkout")
public class CheckoutController {

    private final CheckoutService checkoutService;

    @PostMapping("/create-session")
    public ResponseEntity<ApiResponse> createCheckoutSession(@RequestBody List<CheckoutItemRequestDto> checkoutItemDtoList) {
        try {

            StripeResponseDto stripeResponse = checkoutService.createSession(checkoutItemDtoList);
            return ResponseEntity.ok(new ApiResponse("Checkout session created successfully.!", stripeResponse));
        } catch (StripeException stripeException) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse("Stripe error: " + stripeException.getMessage(), null));
        } catch (Exception exception) {
            // Handle unexpected errors
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(
                            new ApiResponse("An unexpected error occurred: " +  exception.getMessage(), null)
                    );
        }
    }
}