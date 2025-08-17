package com.sriramcode.EcommerceShoppingApp.user.service;

import com.sriramcode.EcommerceShoppingApp.user.models.User;

public interface IUserService {
    User getUserById(Long userId);
    User createUser(CreateUserRequest request);
    User updateUser(UserUpdateRequest request, Long userId);
    void deleteUser(Long userId);

    UserDto convertUserToDto(User user);

    User getAuthenticatedUser();

    void resetPassword(ResetPasswordRequestDto resetPasswordRequestDto);
}
