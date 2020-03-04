package com.springboot.myproject.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RegisteredUserRepository extends JpaRepository<RegisteredUser,Long> {
    Optional<RegisteredUser> findById(String id);

    @Query("SELECT user FROM RegisteredUser user WHERE user.id = ?1")
    RegisteredUser login(String id);

    @Query("SELECT count(user.id) From RegisteredUser user WHERE user.id = :id")
    Long countById(@Param("id") String id);
}
