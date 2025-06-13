package com.lecimangga.lecimanggaresidence.api.respository;

import com.lecimangga.lecimanggaresidence.api.model.User;
import com.lecimangga.lecimanggaresidence.api.model.UserRowMapper;
import com.lecimangga.lecimanggaresidence.api.model.UserWithRoomRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<User> getUser() {
        String sql = "SELECT u.id, u.username, u.password, u.role, u.phone_number, u.is_penghuni, r.id as ruanganId, r.nomor_kamar, r.lantai " +
                "FROM user u LEFT JOIN ruangan r ON u.ruanganId = r.id";
        return jdbcTemplate.query(sql, new UserWithRoomRowMapper());
    }


    public List<User> findAllWithSearch(String query) {
        String sql = "SELECT u.id, u.username, u.password, u.role, u.phone_number, u.is_penghuni, r.id as ruanganId, r.nomor_kamar, r.lantai " +
                "FROM user u LEFT JOIN ruangan r ON u.ruanganId = r.id ";
        List<Object> params = new ArrayList<>();
        if (query != null && !query.trim().isEmpty()) {
            sql += "WHERE u.username LIKE ?";
            params.add("%" + query.trim() + "%");
        }
        return jdbcTemplate.query(sql, params.toArray(), new UserWithRoomRowMapper());
    }


    public User findById(Integer id) {
        String sql = "SELECT * FROM user WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new UserRowMapper(), id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }


    public User findByUsername(String username) {
        String sql = "select * from user where username=?";
        try {
            return jdbcTemplate.queryForObject(sql, new UserRowMapper(), username);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }


    public Boolean saveUser(User user) {
        // The SQL query is updated to include all the fields for a new user.
        String query = "INSERT INTO user (username, password, role, phone_number, is_penghuni) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {
                ps.setString(1, user.getUsername());
                ps.setString(2, user.getPassword());
                ps.setString(3, user.getRole());
                ps.setString(4, user.getPhoneNumber());
                ps.setBoolean(5, user.isPenghuni());
                int affectedRows = ps.executeUpdate();
                return affectedRows > 0;
            }
        });
    }

    public void updateUser(User user) {
        String sql = "UPDATE user SET username = ?, phone_number = ?, is_penghuni = ?, ruanganId = ?, role = ? WHERE id = ?";

        jdbcTemplate.update(sql,
                user.getUsername(),
                user.getPhoneNumber(),
                user.isPenghuni(),
                user.getRuanganId(),
                user.getRole(),
                user.getId()
        );    }

    public void deleteUserById(Integer id) {
        jdbcTemplate.update("DELETE FROM user WHERE id=?", id);
    }

    public int countAktif() {
        String sql = "SELECT COUNT(*) FROM user WHERE is_penghuni = TRUE";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count != null ? count : 0;
    }
}