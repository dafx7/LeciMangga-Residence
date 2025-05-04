package com.lecimangga.lecimanggaresidence.api.respository;

import com.lecimangga.lecimanggaresidence.api.model.Kamar;
import com.lecimangga.lecimanggaresidence.api.model.KamarRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

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

}
