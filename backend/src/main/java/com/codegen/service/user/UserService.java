package com.codegen.service.user;

import com.codegen.model.User;
import lombok.NonNull;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserService extends UserDetailsService {
    List<User> getAllUsers();
    Optional<User> findById(Long id);
}
