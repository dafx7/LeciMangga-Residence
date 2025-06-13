package com.lecimangga.lecimanggaresidence.api.model;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransaksiRowMapper implements RowMapper<Transaksi> {
    @Override
    public Transaksi mapRow(ResultSet rs, int rowNum) throws SQLException {
        Transaksi t = new Transaksi();
        t.setId(rs.getInt("id"));
        t.setUserId(rs.getInt("user_id"));
        t.setNamaPenghuni(rs.getString("username"));
        t.setTipeKamarNama(rs.getString("tipe_kamar_nama"));
        t.setTanggalPembayaran(rs.getDate("tanggal_pembayaran").toLocalDate());
        t.setDurasiBayar(rs.getInt("durasi_bayar"));
        t.setJenisDurasi(rs.getString("jenis_durasi"));
        t.setNominal(rs.getBigDecimal("nominal"));
        t.setBuktiTransferUrl(rs.getString("bukti_transfer_url"));
        t.setStatusValidasi(rs.getString("status_validasi"));
        return t;
    }
}