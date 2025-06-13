package com.lecimangga.lecimanggaresidence.api.respository;

import com.lecimangga.lecimanggaresidence.api.model.Pemesanan;
import com.lecimangga.lecimanggaresidence.api.model.PemesananRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PemesananRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void insertFormPemesanan(Pemesanan pemesanan) {
        jdbcTemplate.update("INSERT INTO pemesanan (nama_pemesan, kontak,tipe_kamar,durasi,tipe_sewa,jumlah_penghuni,tanggal_mulai, status) values (?,?,?,?,?,?,?,?)",
            pemesanan.getNamaPemesan(),
            pemesanan.getKontak(),
            pemesanan.getTipeKamar(),
            pemesanan.getDurasi(),
            pemesanan.getTipeSewa(),
            pemesanan.getJumlahPenghuni(),
            pemesanan.getTanggalMulai(),
            pemesanan.getStatus()
        );
    }

    public List<Pemesanan> findAll() {
        String sql = "SELECT * FROM pemesanan ORDER BY status = 'menunggu' DESC, tanggal_mulai ASC";
        return jdbcTemplate.query(sql, new PemesananRowMapper());
    }

    public void updateStatus(int id, String status) {
        String sql = "UPDATE pemesanan SET status = ? WHERE id = ?";
        jdbcTemplate.update(sql, status, id);
    }

}
