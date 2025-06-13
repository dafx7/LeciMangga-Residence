package com.lecimangga.lecimanggaresidence.api.model;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserWithRoomRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setUsername(rs.getString("username"));
        user.setPhoneNumber(rs.getString("phone_number"));
        user.setPenghuni(rs.getBoolean("is_penghuni"));
        user.setRole(rs.getString("role"));

        if (rs.getObject("ruanganId") != null) {
            Ruangan ruangan = new Ruangan();
            ruangan.setId(rs.getInt("ruanganId"));
            ruangan.setNomorKamar(rs.getString("nomor_kamar"));
            ruangan.setLantai(rs.getInt("lantai"));
            user.setRuangan(ruangan);
        }
        return user;
    }
}