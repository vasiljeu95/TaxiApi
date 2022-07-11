package com.github.vasiljeu95.taxiapi.repository;

import com.github.vasiljeu95.taxiapi.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepository
 *
 * @author Stepan Vasilyeu
 * @since 07.07.2022
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername (String name);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
