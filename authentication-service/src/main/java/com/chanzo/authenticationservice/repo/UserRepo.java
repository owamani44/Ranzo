package com.chanzo.authenticationservice.repo;

import com.chanzo.authenticationservice.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface UserRepo extends JpaRepository<UserInfo, UUID> {

    boolean existsByUsername(String username);

    Optional<UserInfo> findByUsername(String username);
}
