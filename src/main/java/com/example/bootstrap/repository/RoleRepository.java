package com.example.bootstrap.repository;

import com.example.bootstrap.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
