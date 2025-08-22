package com.sriramcode.EcommerceShoppingApp.products.dto;

import com.sriramcode.EcommerceShoppingApp.products.models.Category;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductRequestDto {
    private String name;
    private String brand;
    private BigDecimal price;
    private int inventory;
    private String description;
    private Category category;
    private List<ImageDto> images;
}
