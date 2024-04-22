package com.aditya.meetup.service;

import com.aditya.meetup.dto.RegistrationDto;
import com.aditya.meetup.model.UserEntity;

public interface UserService {
    void saveUser(RegistrationDto registrationDto);

    UserEntity findByEmail(String email);

    UserEntity findByUsername(String username);
}
