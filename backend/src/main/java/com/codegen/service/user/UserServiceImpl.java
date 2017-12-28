package com.codegen.service.user;

import com.codegen.model.User;
import com.codegen.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.NonNull;

import javax.annotation.PostConstruct;
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
    public User saveUser(@NonNull User user) {
        System.out.println(user);
        return userRepository.save(user);
    }
}
