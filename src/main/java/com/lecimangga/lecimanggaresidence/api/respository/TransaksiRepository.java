package com.lecimangga.lecimanggaresidence.api.respository;

import com.lecimangga.lecimanggaresidence.api.model.Transaksi;
import com.lecimangga.lecimanggaresidence.api.model.TransaksiRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TransaksiRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Transaksi> findAll(String searchQuery) {
        String sql = "SELECT t.*, u.username FROM transaksi t " +
                "LEFT JOIN user u ON t.user_id = u.id ";
        List<Object> params = new ArrayList<>();

        if (searchQuery != null && !searchQuery.trim().isEmpty()) {
            sql += "WHERE u.username LIKE ?";
            params.add("%" + searchQuery.trim() + "%");
        }

        sql += " ORDER BY t.status_validasi = 'menunggu' DESC, t.tanggal_pembayaran DESC";

        return jdbcTemplate.query(sql, params.toArray(), new TransaksiRowMapper());
    }

    public void updateStatus(int transaksiId, String status) {
        String sql = "UPDATE transaksi SET status_validasi = ? WHERE id = ?";
        jdbcTemplate.update(sql, status, transaksiId);
    }
}