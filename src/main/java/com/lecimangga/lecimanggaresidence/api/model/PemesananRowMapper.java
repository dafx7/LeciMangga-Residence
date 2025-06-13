package com.lecimangga.lecimanggaresidence.api.model;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PemesananRowMapper implements RowMapper<Pemesanan> {
    @Override
    public Pemesanan mapRow(ResultSet rs, int rowNum) throws SQLException {
        Pemesanan p = new Pemesanan();
        p.setId(rs.getInt("id"));
        p.setNamaPemesan(rs.getString("nama_pemesan"));
        p.setKontak(rs.getString("kontak"));
        p.setTipeKamar(rs.getString("tipe_kamar"));
        p.setDurasi(rs.getInt("durasi"));
        p.setTipeSewa(rs.getString("tipe_sewa"));
        p.setJumlahPenghuni(rs.getInt("jumlah_penghuni"));
        p.setTanggalMulai(rs.getDate("tanggal_mulai").toLocalDate());
        p.setStatus(rs.getString("status"));
        return p;
    }
}