package com.lecimangga.lecimanggaresidence.api.model;

import java.util.List;

public class Kamar {
    private String jenisKamar;
    private String imagePath;
    private boolean status;
    private String desc;
    private String fasilitas;
    private List<Double> Harga;
    private int maxOrang;
    private boolean token;

    public void setToken(boolean token) {this.token = token;}

    public boolean getToken() {return token;}

    public String getJenisKamar() {
        return jenisKamar;
    }

    public void setJenisKamar(String jenisKamar) {
        this.jenisKamar = jenisKamar;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getFasilitas() {
        return fasilitas;
    }

    public void setFasilitas(String fasilitas) {
        this.fasilitas = fasilitas;
    }

    public List<Double> getHarga() {
        return Harga;
    }

    public void setHarga(List<Double> harga) {
        Harga = harga;
    }

    public int getMaxOrang() {
        return maxOrang;
    }

    public void setMaxOrang(int maxOrang) {
        this.maxOrang = maxOrang;
    }
}
