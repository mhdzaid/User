package com.api.user.repository;

import com.api.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID>
{
    boolean existsByEmail(String email);

}
