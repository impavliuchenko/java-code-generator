package com.codegen.repository;

import com.codegen.model.User;
import lombok.NonNull;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(@NonNull String username);
    Optional<User> findById(@NonNull Long id);
}
