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
        jdbcTemplate.update("INSERT INTO pemesanan_form (nama, noTelp,jenis,tipeDurasi,jumlahDurasi,tanggalMulaiSewa,jumlahPenghuni) values (?,?,?,?,?,?,?)",
            pemesanan.getNama(),
            pemesanan.getNoTelp(),
            pemesanan.getJenis(),
            pemesanan.getTipeDurasi(),
            pemesanan.getJumlahDurasi(),
            pemesanan.getTanggalMulaiSewa(),
            pemesanan.getJumlahPenghuni()
        );
    }

    public List<Pemesanan> getAllPemesanan() {
        return jdbcTemplate.query("SELECT * FROM pemesanan_form", new PemesananRowMapper());
    }

}
