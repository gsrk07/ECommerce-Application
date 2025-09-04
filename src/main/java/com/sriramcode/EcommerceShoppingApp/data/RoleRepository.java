package com.sriramcode.EcommerceShoppingApp.data;

import com.sriramcode.EcommerceShoppingApp.user.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String role);
}
