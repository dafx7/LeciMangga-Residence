package com.lecimangga.lecimanggaresidence.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Transaksi {
    @Id
    private int id;
    private Integer userId;
    private String namaPenghuni;
    private String tipeKamarNama;
    private LocalDate tanggalPembayaran;
    private int durasiBayar;
    private String jenisDurasi;
    private BigDecimal nominal;
    private String buktiTransferUrl;
    private String statusValidasi;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }
    public String getNamaPenghuni() { return namaPenghuni; }
    public void setNamaPenghuni(String namaPenghuni) { this.namaPenghuni = namaPenghuni; }
    public String getTipeKamarNama() { return tipeKamarNama; }
    public void setTipeKamarNama(String tipeKamarNama) { this.tipeKamarNama = tipeKamarNama; }
    public LocalDate getTanggalPembayaran() { return tanggalPembayaran; }
    public void setTanggalPembayaran(LocalDate tanggalPembayaran) { this.tanggalPembayaran = tanggalPembayaran; }
    public int getDurasiBayar() { return durasiBayar; }
    public void setDurasiBayar(int durasiBayar) { this.durasiBayar = durasiBayar; }
    public String getJenisDurasi() { return jenisDurasi; }
    public void setJenisDurasi(String jenisDurasi) { this.jenisDurasi = jenisDurasi; }
    public BigDecimal getNominal() { return nominal; }
    public void setNominal(BigDecimal nominal) { this.nominal = nominal; }
    public String getBuktiTransferUrl() { return buktiTransferUrl; }
    public void setBuktiTransferUrl(String buktiTransferUrl) { this.buktiTransferUrl = buktiTransferUrl; }
    public String getStatusValidasi() { return statusValidasi; }
    public void setStatusValidasi(String statusValidasi) { this.statusValidasi = statusValidasi; }
}
