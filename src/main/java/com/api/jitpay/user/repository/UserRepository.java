package com.api.jitpay.user.repository;

import com.api.jitpay.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID>
{
    boolean existsByEmail(String email);

}
