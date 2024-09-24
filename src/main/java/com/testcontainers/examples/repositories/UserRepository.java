package com.testcontainers.examples.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testcontainers.examples.models.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {

}
