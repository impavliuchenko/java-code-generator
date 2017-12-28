package com.codegen.service.user;

import com.codegen.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import java.util.Optional;

public interface UserService extends UserDetailsService {
    Optional<User> findById(Long id);
    User saveUser (User user);
}
