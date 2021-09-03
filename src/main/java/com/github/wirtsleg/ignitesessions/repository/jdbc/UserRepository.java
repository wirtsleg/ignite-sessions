package com.github.wirtsleg.ignitesessions.repository.jdbc;

import com.github.wirtsleg.ignitesessions.dto.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> {

    Optional<User> findByEmail(String email);
}
