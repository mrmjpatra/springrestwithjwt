package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.model.User;

public interface UserRepository extends JpaRepository<User, String> {
}
