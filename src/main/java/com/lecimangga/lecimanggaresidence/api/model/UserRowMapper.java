package com.lecimangga.lecimanggaresidence.api.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setRole(rs.getString("role"));
        user.setPhoneNumber(rs.getString("phone_number"));
        user.setPenghuni(rs.getBoolean("is_penghuni"));
        user.setRuanganId(rs.getObject("ruangan_id", Integer.class));
        return user;
    }
}

