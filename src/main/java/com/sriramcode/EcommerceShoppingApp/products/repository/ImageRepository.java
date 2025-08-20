package com.sriramcode.EcommerceShoppingApp.products.repository;

import com.sriramcode.EcommerceShoppingApp.products.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> findByProductId(Long id);
}
