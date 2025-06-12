package com.lecimangga.lecimanggaresidence.api.respository;

import com.lecimangga.lecimanggaresidence.api.model.Kamar;
import com.lecimangga.lecimanggaresidence.api.model.KamarRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class KamarRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Kamar> getKamar() {
        return jdbcTemplate.query(
                "select * from kamar",
                new KamarRowMapper()
        );
    }


    public Kamar findById(Integer id) {
        String sql = "select * from kamar where id=?";
        try {
            return (Kamar) jdbcTemplate.queryForObject(sql, new Object[]{id}, new KamarRowMapper());
        }
        catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    public List<Kamar> getFilteredKamar(String harga, String token, String orang) {
        String sql = "select * from kamar where 1=1";
        if (Objects.equals(harga, "1")){
            sql += "and Harga >= "+0+" and harga <= " + 1000000;
        } else if (Objects.equals(harga, "2")){
            sql += "and Harga >= "+1000000+" and harga <= " + 2000000;
        } else if (Objects.equals(harga, "3")){
            sql += "and Harga >= "+2000000;
        }
        if (Objects.equals(token, "token")){
            sql += "and token = 1";
        }
        if (orang != null){
            sql += "and maxOrang = " + orang;
        }
        return jdbcTemplate.query(sql, new KamarRowMapper());
    }

}
