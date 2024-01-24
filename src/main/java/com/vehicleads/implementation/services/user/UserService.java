package com.vehicleads.implementation.services.user;

import com.vehicleads.abstraction.user.repository.UserRepository;
import com.vehicleads.dtos.authentication.UserRegistrationDto;
import com.vehicleads.exceptions.user.EmailAlreadyInUseException;
import com.vehicleads.exceptions.user.PasswordNotMatchedException;
import com.vehicleads.implementation.entities.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Registers a new user with hashed password.
     *
     * @param userDto Data Transfer Object (DTO) representing user registration data.
     */
    public void register(UserRegistrationDto userDto)
        throws EmailAlreadyInUseException, PasswordNotMatchedException {
        if (!userDto.getPassword().equals(userDto.getConfirmPassword())) {
            throw new PasswordNotMatchedException();
        }

        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new EmailAlreadyInUseException();
        }

        UserEntity user = mapUserRegistrationDtoToUser(userDto);
        userRepository.save(user);
    }

    private UserEntity mapUserRegistrationDtoToUser(UserRegistrationDto dto) {
        UserEntity user = new UserEntity();
        user.setEmail(dto.getEmail());
        user.setUsername(dto.getEmail());
        user.setPasswordHash(passwordEncoder.encode(dto.getPassword()));
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setPopulatedPlace(dto.getPopulatedPlace());
        user.setPhoneNumber(dto.getPhoneNumber());

        return user;
    }
}
