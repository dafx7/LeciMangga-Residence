package com.lecimangga.lecimanggaresidence.api.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PemesananRowMapper implements RowMapper<Pemesanan> {
    public Pemesanan mapRow(ResultSet rs, int rowNum) throws SQLException {
        Pemesanan pemesanan = new Pemesanan();
        pemesanan.setId(rs.getInt("id"));
        pemesanan.setNama(rs.getString("nama"));
        pemesanan.setJenis(rs.getString("jenis"));
        pemesanan.setJumlahDurasi(rs.getInt("jumlahDurasi"));
        pemesanan.setTipeDurasi(rs.getString("tipeDurasi"));
        pemesanan.setNoTelp(rs.getString("noTelp"));
        pemesanan.setTipeDurasi(rs.getString("tipeDurasi"));
        pemesanan.setJumlahPenghuni(rs.getInt("jumlahPenghuni"));
        return pemesanan;
    }
}
