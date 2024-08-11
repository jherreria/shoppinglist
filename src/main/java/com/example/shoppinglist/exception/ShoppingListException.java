package com.example.shoppinglist.exception;

import lombok.Data;

@Data
public class ShoppingListException extends RuntimeException {
    private String errorCode;

    public ShoppingListException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
