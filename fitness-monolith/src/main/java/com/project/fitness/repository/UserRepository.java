package com.project.fitness.repository;

import com.project.fitness.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    // Spring Data JPA will automatically implement this
    Optional<User> findByEmail(String email);

    // Useful for registration to check if email is taken
    boolean existsByEmail(String email);

    Collection<User> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailContainingIgnoreCase(
            String firstNameKeyword,
            String lastNameKeyword,
            String emailKeyword
    );
}
