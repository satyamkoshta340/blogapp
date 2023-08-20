package com.tcs.blogapp.users.dtos;

import lombok.Data;

@Data
public class UserDetailsDto {
    String username;
    String email;
    String bio;
    String image;
    String authToken;
}
