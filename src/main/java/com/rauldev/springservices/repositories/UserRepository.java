package com.rauldev.springservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rauldev.springservices.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
