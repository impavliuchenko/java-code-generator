package com.codegen.service.user;

import com.codegen.exception.EmailAlreadyExistsException;
import com.codegen.model.User;
import com.codegen.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.NonNull;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("no user with username: " + username));
    }

    @Override
    public Optional<User> findById(@NonNull Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void saveUser(@NonNull User user) {
        userRepository.save(user);
    }

    @Override
    public void checkEmail(String email) throws EmailAlreadyExistsException {
        if (userRepository.findByUsername(email).isPresent()){
            throw new EmailAlreadyExistsException("email already exist: " + email);
        }
    }
}
