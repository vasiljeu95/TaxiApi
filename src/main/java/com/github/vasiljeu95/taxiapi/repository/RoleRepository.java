package com.github.vasiljeu95.taxiapi.repository;

import com.github.vasiljeu95.taxiapi.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * RoleRepository
 *
 * @author Stepan Vasilyeu
 * @since 07.07.2022
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName (String name);
}
