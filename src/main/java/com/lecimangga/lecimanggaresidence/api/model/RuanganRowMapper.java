package com.lecimangga.lecimanggaresidence.api.model;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RuanganRowMapper implements RowMapper<Ruangan> {
    @Override
    public Ruangan mapRow(ResultSet rs, int rowNum) throws SQLException {
        Ruangan ruangan = new Ruangan();
        ruangan.setId(rs.getInt("id"));
        ruangan.setNomorKamar(rs.getString("nomor_kamar"));
        ruangan.setLantai(rs.getInt("lantai"));
        return ruangan;
    }
}