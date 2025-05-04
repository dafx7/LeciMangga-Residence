package com.lecimangga.lecimanggaresidence.api.respository;

import com.lecimangga.lecimanggaresidence.api.model.User;
import com.lecimangga.lecimanggaresidence.api.model.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<User> getUser() {
        return jdbcTemplate.query("select id,username,password from user", new UserRowMapper());
    }


    public User findById(Integer id) {
        String sql = "select * from user where id=?";
        try {
            return (User) jdbcTemplate.queryForObject(sql, new Object[]{id}, new UserRowMapper());
        }
        catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }
}
