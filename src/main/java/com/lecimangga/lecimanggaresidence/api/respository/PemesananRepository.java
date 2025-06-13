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

//    public void insertFormPemesanan(Pemesanan pemesanan) {
//        jdbcTemplate.update("INSERT INTO pemesanan_form (nama, no_telp,jenis,tipe_durasi,jumlah_durasi,tanggal_mulai_sewa,jumlah_penghuni) values (?,?,?,?,?,?,?)",
//            pemesanan.getNama(),
//            pemesanan.getNoTelp(),
//            pemesanan.getJenis(),
//            pemesanan.getTipeDurasi(),
//            pemesanan.getJumlahDurasi(),
//            pemesanan.getTanggalMulaiSewa(),
//            pemesanan.getJumlahPenghuni()
//        );
//    }

    public List<Pemesanan> findAll() {
        String sql = "SELECT * FROM pemesanan ORDER BY status = 'menunggu' DESC, tanggal_mulai ASC";
        return jdbcTemplate.query(sql, new PemesananRowMapper());
    }

    public void updateStatus(int id, String status) {
        String sql = "UPDATE pemesanan SET status = ? WHERE id = ?";
        jdbcTemplate.update(sql, status, id);
    }

}
