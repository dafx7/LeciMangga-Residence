package com.lecimangga.lecimanggaresidence.api.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class HubungiKamiForm {

    @Id
    private int id;
    private String nama;
    private String email;
    @Column(columnDefinition = "TEXT")
    private String pesan;

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getEmail() {
        return email;
    }

    public String getPesan() {
        return pesan;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    @Override
    public String toString() {
        return "HubungiKamiForm{" +
                "id=" + id +
                ", nama='" + nama + '\'' +
                ", email='" + email + '\'' +
                ", pesan='" + pesan + '\'' +
                '}';
    }


}
