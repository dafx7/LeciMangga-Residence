package com.lecimangga.lecimanggaresidence.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.sql.Date;

@Entity
public class Pemesanan {
    @Id
    private int id;
    private String nama;
    private String noTelp;
    private String jenis;
    private int jumlahPenghuni;
    private String tipeDurasi;
    private int jumlahDurasi;
    private Date tanggalMulaiSewa;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getNoTelp() {
        return noTelp;
    }
    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }
    public String getJenis() {
        return jenis;
    }
    public void setJenis(String jenis) {
        this.jenis = jenis;
    }
    public int getJumlahPenghuni() {
        return jumlahPenghuni;
    }
    public void setJumlahPenghuni(int jumlahPenghuni) {
        this.jumlahPenghuni = jumlahPenghuni;
    }
    public String getTipeDurasi() {
        return tipeDurasi;
    }
    public void setTipeDurasi(String tipeDurasi) {
        this.tipeDurasi = tipeDurasi;
    }
    public int getJumlahDurasi() {
        return jumlahDurasi;
    }
    public void setJumlahDurasi(int jumlahDurasi) {
        this.jumlahDurasi = jumlahDurasi;
    }
    public Date getTanggalMulaiSewa() {
        return tanggalMulaiSewa;
    }
    public void setTanggalMulaiSewa(Date tanggalMulaiSewa) {
        this.tanggalMulaiSewa = tanggalMulaiSewa;
    }
}
