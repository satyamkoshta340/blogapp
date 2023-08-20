package com.tcs.blogapp.users;

import com.tcs.blogapp.users.dtos.CreateUserDto;
import com.tcs.blogapp.users.dtos.UserDetailsDto;
import com.tcs.blogapp.users.dtos.UserResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsersService {

    @Autowired
    public UsersRepository usersRepository;
    @Autowired
    public ModelMapper modelMapper;

    public UserResponseDto createUser(CreateUserDto user){
        UserEntity newUser = modelMapper.map(user, UserEntity.class);
        UserEntity savedUser = usersRepository.save(newUser);
        return modelMapper.map(savedUser, UserResponseDto.class);
    }

    public UserDetailsDto getUserById(Long userId){
        UserEntity user = usersRepository.findById(userId).orElseThrow(()-> new IllegalArgumentException("Invalid User Id"));
        return modelMapper.map(user, UserDetailsDto.class);
    }
}
