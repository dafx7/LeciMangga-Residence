package com.lecimangga.lecimanggaresidence.api.respository;

import com.lecimangga.lecimanggaresidence.api.model.User;
import com.lecimangga.lecimanggaresidence.api.model.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
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

    public User findByUsername(String username) {
        String sql = "select * from user where username=?";
        try {
            return (User) jdbcTemplate.queryForObject(sql, new Object[]{username}, new UserRowMapper());
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    public Boolean saveUser(User user){
        String query = "insert into user (username, password) values (?, ?)";
        return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {

                ps.setString(1, user.getUsername());
                ps.setString(2, user.getPassword());

                int affectedRows = ps.executeUpdate();
                return affectedRows > 0;
            }
        });
    }

    public Integer updateUser(User user) {
        String query = "update user set username=?, password=? where id=?";
        Object[] params = {user.getUsername(), user.getPassword(), user.getId()};
        int[] types = {Types.VARCHAR, Types.VARCHAR, Types.INTEGER};

        return jdbcTemplate.update(query, params, types);
    }


    public Integer deleteUserById(Integer id) {
        int update = jdbcTemplate.update("delete from user where id=?", id);
        return update;
    }
}
