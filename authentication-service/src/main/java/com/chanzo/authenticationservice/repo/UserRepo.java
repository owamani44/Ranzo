package com.chanzo.authenticationservice.repo;

import com.chanzo.authenticationservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepo extends JpaRepository<User, UUID> {

}
