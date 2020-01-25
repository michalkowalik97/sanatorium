package com.sanatorium.sanatorium.repo;

import com.sanatorium.sanatorium.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UserRepo extends JpaRepository<User,Integer> {
    @Query("from User where login = :login")
    User findUserByTheBestParameter(@Param("login") String login);
}
