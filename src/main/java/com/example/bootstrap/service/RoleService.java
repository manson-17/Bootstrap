package com.example.bootstrap.service;

import com.example.bootstrap.entity.Role;

import java.util.HashSet;
import java.util.List;

public interface RoleService {

    Role findRoleByName(String name);

    List<Role> findAllRoles();

   HashSet<Role> findRolesByNames(String[] names);
}
