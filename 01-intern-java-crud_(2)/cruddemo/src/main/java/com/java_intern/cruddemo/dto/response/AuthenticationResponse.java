package com.java_intern.cruddemo.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = false)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponse {
    boolean authenticate;
}
