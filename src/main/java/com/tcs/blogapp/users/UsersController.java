package com.tcs.blogapp.users;

import com.tcs.blogapp.common.dtos.ErrorResponseDto;
import com.tcs.blogapp.users.dtos.CreateUserDto;
import com.tcs.blogapp.users.dtos.UserDetailsDto;
import com.tcs.blogapp.users.dtos.UserResponseDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserDetailsDto> getUser(@PathVariable("userId") Long userId){
        return ResponseEntity.ok(usersService.getUserById(userId));
    }

    @PostMapping("")
    public ResponseEntity<UserResponseDto> createUser(@Valid @RequestBody CreateUserDto user, BindingResult result){
        if(result.hasErrors()){
            throw new IllegalArgumentException("Invalid Body Data");
        }
        else{
            return ResponseEntity.ok(usersService.createUser(user));}
    }

    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<ErrorResponseDto> handleError(Exception e){
        return ResponseEntity.status(400).body(new ErrorResponseDto(e.getMessage()));
    }
}
