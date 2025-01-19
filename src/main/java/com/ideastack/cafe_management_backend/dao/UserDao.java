package com.ideastack.cafe_management_backend.dao;

import com.ideastack.cafe_management_backend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserDao extends JpaRepository<User, Integer> {

    User findbyEmailId(@Param("email") String email);

}
