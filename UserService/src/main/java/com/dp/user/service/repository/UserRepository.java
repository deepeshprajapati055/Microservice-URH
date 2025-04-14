package com.dp.user.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dp.user.service.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

}
