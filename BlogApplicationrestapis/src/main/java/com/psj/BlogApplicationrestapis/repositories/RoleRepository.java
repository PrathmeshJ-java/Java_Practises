package com.psj.BlogApplicationrestapis.repositories;

import com.psj.BlogApplicationrestapis.Entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
