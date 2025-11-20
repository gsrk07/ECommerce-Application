package com.sriramcode.EcommerceShoppingApp.commons.dto;

import lombok.Data;

@Data
public class ApiResponse {
    private String message;
    private Object data;
    
    // Default constructor
    public ApiResponse() {
    }
    
    // Constructor with message and data
    public ApiResponse(String message, Object data) {
        this.message = message;
        this.data = data;
    }
}
