package com.lecimangga.lecimanggaresidence.api.respository;

import com.lecimangga.lecimanggaresidence.api.model.Ruangan;
import com.lecimangga.lecimanggaresidence.api.model.RuanganRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class RuanganRepository {
    @Autowired private JdbcTemplate jdbcTemplate;

    public List<Ruangan> findAll() {
        String sql = "SELECT id, nomor_kamar, lantai FROM ruangan ORDER BY nomor_kamar ASC";
        return jdbcTemplate.query(sql, new RuanganRowMapper());
    }
}