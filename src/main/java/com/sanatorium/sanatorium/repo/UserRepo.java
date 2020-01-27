package com.sanatorium.sanatorium.repo;

import com.sanatorium.sanatorium.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserRepo extends JpaRepository<User,Integer> {

    User findUserByLogin(String login);

}
