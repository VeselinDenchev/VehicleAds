package com.vehicleads.implementation.services.user;

import com.vehicleads.abstraction.user.repository.UserRepository;
import com.vehicleads.exceptions.user.UserNotFoundException;
import com.vehicleads.implementation.entities.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UserNotFoundException {
        UserEntity user = userRepository.findByUsername(username)
                                        .orElseThrow(UserNotFoundException::new);

        User authUser = new User(
                user.getEmail(),
                user.getPasswordHash(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));

        return authUser;
    }
}
