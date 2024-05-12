package com.jpa.mapping.jpamapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.mapping.jpamapping.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
