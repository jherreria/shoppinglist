package com.example.shoppinglist.util;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponse {
    @NonNull
    private String errorCode;
    @NonNull
    private String errorMessage;
}
