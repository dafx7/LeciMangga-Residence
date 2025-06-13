package com.lecimangga.lecimanggaresidence.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

import java.io.Serializable;

@Entity
public class User implements Serializable {
    @Id
    private int id;
    private String username;
    private String password;
    private String role;

    private String phoneNumber;
    private boolean isPenghuni;
    private Integer ruanganId;

    @Transient
    private Ruangan ruangan;

    // Getters and Setters for ALL fields
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public boolean isPenghuni() { return isPenghuni; }
    public void setPenghuni(boolean penghuni) { isPenghuni = penghuni; }
    public Integer getRuanganId() { return ruanganId; }
    public void setRuanganId(Integer ruanganId) { this.ruanganId = ruanganId; }
    public Ruangan getRuangan() { return ruangan; }
    public void setRuangan(Ruangan ruangan) { this.ruangan = ruangan; }
}
