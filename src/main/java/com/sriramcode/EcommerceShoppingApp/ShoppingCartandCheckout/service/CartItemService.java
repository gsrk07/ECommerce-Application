package com.sriramcode.EcommerceShoppingApp.ShoppingCartandCheckout.service;

import com.sriramcode.EcommerceShoppingApp.ShoppingCartandCheckout.models.Cart;
import com.sriramcode.EcommerceShoppingApp.ShoppingCartandCheckout.models.CartItem;
import com.sriramcode.EcommerceShoppingApp.ShoppingCartandCheckout.repository.CartItemRepository;
import com.sriramcode.EcommerceShoppingApp.ShoppingCartandCheckout.repository.CartRepository;
import com.sriramcode.EcommerceShoppingApp.commons.exception.ResourceNotFoundException;
import com.sriramcode.EcommerceShoppingApp.products.exception.ProductNotPresentException;
import com.sriramcode.EcommerceShoppingApp.products.models.Product;
import com.sriramcode.EcommerceShoppingApp.products.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CartItemService implements ICartItemService {
    private final CartItemRepository cartItemRepository;
    private final CartRepository cartRepository;
    private final IProductService productService;
    private final ICartService cartService;

    @Override
    public void addCartItem(Long cartId, Long productId, int quantity) throws ProductNotPresentException {
        System.out.println("Adding item to cart " + productId + quantity);
        Cart cart = cartService.getCart(cartId);
        Product product = productService.getProductById(productId);
        CartItem cartItem = cart.getCartItems()
                .stream()
                .filter(item -> item.getProduct().getId().equals(productId))
                .findFirst().orElse(new CartItem());
        if (cartItem.getId() == null) {
            cartItem.setCart(cart);
            cartItem.setProduct(product);
            cartItem.setQuantity(quantity);
            cartItem.setUnitPrice(product.getPrice());
        }
        else {
            cartItem.setQuantity(cartItem.getQuantity() + quantity);
        }
        cartItem.setTotalPrice();
        cart.addItem(cartItem);

        cartItemRepository.save(cartItem);
        cartRepository.save(cart);
    }

    @Override
    public void removeCartItem(Long cartId, Long productId) throws ProductNotPresentException {

        Cart cart = cartService.getCart(cartId);
        Product product = productService.getProductById(productId);
        CartItem cartItem = getCartItem(cartId, productId);
        cart.removeItem(cartItem);
        cartItemRepository.delete(cartItem);
        cartRepository.save(cart);
    }

    @Override
    public void updateItemQuantity(Long cartId, Long productId, int quantity) throws ProductNotPresentException {

        Cart cart = cartService.getCart(cartId);
        Product product = productService.getProductById(productId);
        cart.getCartItems()
                .stream()
                .filter(item -> item.getProduct().getId().equals(productId))
                .findFirst()
                .ifPresent(item -> {
                    item.setQuantity(quantity);
                    item.setUnitPrice(item.getProduct().getPrice());
                    item.setTotalPrice();
                });
        BigDecimal totalAmount = cart.getTotalAmount();
        cart.setTotalAmount(totalAmount);
        cartRepository.save(cart);
    }

    @Override
    public CartItem getCartItem(Long cartId, Long productId) {
        Cart cart = cartService.getCart(cartId);
        return cart.getCartItems()
                .stream()
                .filter(item -> item.getProduct().getId().equals(productId))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Item not found"));
    }
}
