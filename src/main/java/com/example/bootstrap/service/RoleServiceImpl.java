package com.example.bootstrap.service;

import com.example.bootstrap.entity.Role;
import com.example.bootstrap.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository repository;

    @Override
    public List<Role> findAllRoles() {
        return repository.findAll();
    }

    @Override
    public HashSet<Role> findRolesByNames(String[] names) {
        return repository.getRolesByNames(names);
    }
}
