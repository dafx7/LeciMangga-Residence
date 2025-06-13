package com.lecimangga.lecimanggaresidence.api.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class KamarRowMapper implements RowMapper<Kamar> {
    public Kamar mapRow(ResultSet rs, int rowNum) throws SQLException {
        Kamar kamar = new Kamar();
        kamar.setJenisKamar(rs.getString("jenis_kamar"));
        kamar.setImagePath(rs.getString("image_path"));
        kamar.setStatus(rs.getBoolean("status"));
        kamar.setDesc(rs.getString("deskripsi"));
        kamar.setMaxOrang(rs.getInt("max_orang"));
        kamar.setFasilitas(rs.getString("fasilitas"));
        kamar.setToken(rs.getBoolean("token_listrik"));
        String hargaString = rs.getString("Harga");
        if (hargaString != null && !hargaString.isEmpty()) {
            // Split by comma and convert to a List of Doubles
            List<Double> hargaList = Arrays.stream(hargaString.replace("[", "").replace("]", "").split(","))
                    .map(Double::parseDouble)
                    .collect(Collectors.toList());
            kamar.setHarga(hargaList);
        }

        return kamar;
    }
}

