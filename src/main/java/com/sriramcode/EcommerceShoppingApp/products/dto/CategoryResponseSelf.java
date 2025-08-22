package com.sriramcode.EcommerceShoppingApp.products.dto;

import com.sriramcode.EcommerceShoppingApp.products.models.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CategoryResponseSelf {
    private Category category;
    private String message;
}
