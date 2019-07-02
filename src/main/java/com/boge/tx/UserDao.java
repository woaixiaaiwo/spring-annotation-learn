package com.boge.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(){
        String sql = "INSERT INTO `test`.`user` (`user_name`, `email`, `tel`) VALUES (?,?,?);";
        jdbcTemplate.update(sql,"111","222","333");
    }

}
