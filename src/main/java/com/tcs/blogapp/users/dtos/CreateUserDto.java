package com.tcs.blogapp.users.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class CreateUserDto {

    @NotNull
    String username;

    @NotNull
    @Email(message = "Invalid Email field.")
    String email;

    @NotNull
    @Size(min = 6)
    String password;

    String image;

    String bio;

}
