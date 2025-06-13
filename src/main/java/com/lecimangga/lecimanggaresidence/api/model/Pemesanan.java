package com.lecimangga.lecimanggaresidence.api.model;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
public class Pemesanan {
    @Id
    private int id;
    private String namaPemesan;
    private String kontak;
    private String tipeKamar;
    private int durasi;
    private String tipeSewa;
    private int jumlahPenghuni;
    private LocalDate tanggalMulai;
    private String status;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNamaPemesan() { return namaPemesan; }
    public void setNamaPemesan(String namaPemesan) { this.namaPemesan = namaPemesan; }
    public String getKontak() { return kontak; }
    public void setKontak(String kontak) { this.kontak = kontak; }
    public String getTipeKamar() { return tipeKamar; }
    public void setTipeKamar(String tipeKamar) { this.tipeKamar = tipeKamar; }
    public int getDurasi() { return durasi; }
    public void setDurasi(int durasi) { this.durasi = durasi; }
    public String getTipeSewa() { return tipeSewa; }
    public void setTipeSewa(String tipeSewa) { this.tipeSewa = tipeSewa; }
    public int getJumlahPenghuni() { return jumlahPenghuni; }
    public void setJumlahPenghuni(int jumlahPenghuni) { this.jumlahPenghuni = jumlahPenghuni; }
    public LocalDate getTanggalMulai() { return tanggalMulai; }
    public void setTanggalMulai(LocalDate tanggalMulai) { this.tanggalMulai = tanggalMulai; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}