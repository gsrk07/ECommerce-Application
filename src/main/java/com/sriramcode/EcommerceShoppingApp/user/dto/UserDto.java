package com.sriramcode.EcommerceShoppingApp.user.dto;

import com.sriramcode.EcommerceShoppingApp.ShoppingCartandCheckout.dto.CartRequestDto;
import lombok.Data;
import org.springframework.data.domain.jaxb.SpringDataJaxb;

import java.util.List;

@Data
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private List<SpringDataJaxb.OrderDto> orders;
    private CartRequestDto cart;
}
