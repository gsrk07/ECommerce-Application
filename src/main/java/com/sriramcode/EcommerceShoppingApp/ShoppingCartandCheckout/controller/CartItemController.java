package com.sriramcode.EcommerceShoppingApp.ShoppingCartandCheckout.controller;

import com.sriramcode.EcommerceShoppingApp.ShoppingCartandCheckout.models.Cart;
import com.sriramcode.EcommerceShoppingApp.ShoppingCartandCheckout.service.ICartItemService;
import com.sriramcode.EcommerceShoppingApp.ShoppingCartandCheckout.service.ICartService;
import com.sriramcode.EcommerceShoppingApp.commons.dto.ApiResponse;
import com.sriramcode.EcommerceShoppingApp.commons.exception.ResourceNotFoundException;
import com.sriramcode.EcommerceShoppingApp.products.exception.ProductNotPresentException;
import com.sriramcode.EcommerceShoppingApp.products.service.IProductService;
import com.sriramcode.EcommerceShoppingApp.user.models.User;
import com.sriramcode.EcommerceShoppingApp.user.service.IUserService;
import io.jsonwebtoken.JwtException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api_prefix}/cartItems")
public class CartItemController {
    private final ICartItemService cartItemService;
    private final ICartService cartService;
    private final IProductService productService;
    private final IUserService userService;

    @PostMapping("/item/add")
    public ResponseEntity<ApiResponse> addItemToCart(
            @RequestParam Long productId,
            @RequestParam Integer quantity) {
        try {
            User user = userService.getAuthenticatedUser();
            Cart cart = cartService.initializeNewCart(user);
            cartItemService.addCartItem(cart.getId(), productId, quantity);
            return ResponseEntity.ok().body(new ApiResponse("Item added to cart", null));
        } catch (ProductNotPresentException e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        } catch(JwtException e) {
            return ResponseEntity.status(UNAUTHORIZED).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @DeleteMapping("/cart/{cartId}/item/{itemId}/remove")
    public ResponseEntity<ApiResponse> removeItem(@PathVariable Long cartId, @PathVariable Long itemId) {
        try {
            cartItemService.removeCartItem(cartId, itemId);
            return ResponseEntity.ok().body(new ApiResponse("Item removed from cart", null));
        } catch (ResourceNotFoundException | ProductNotPresentException e) {
            return ResponseEntity.status(404).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @PutMapping("/cart/{cartId}/item/{itemId}/update")
    public ResponseEntity<ApiResponse> updateItemQuantity(@PathVariable Long cartId,
                                                          @PathVariable Long itemId,
                                                          @RequestParam Integer quantity) {
        try {
            cartItemService.updateItemQuantity(cartId, itemId, quantity);
            return ResponseEntity.ok().body(new ApiResponse("Item updated", null));
        } catch (ResourceNotFoundException | ProductNotPresentException e) {
            return ResponseEntity.status(404).body(new ApiResponse(e.getMessage(), null));
        }
    }
}