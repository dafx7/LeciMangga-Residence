package com.lecimangga.lecimanggaresidence.api.respository;

import com.lecimangga.lecimanggaresidence.api.model.HubungiKamiForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class HubungiKamiFormRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<HubungiKamiForm> getHubungiKamiForm() {
        List<HubungiKamiForm> result;
        result = jdbcTemplate.query("select * from hubungi_kami_form", new HubungiKamiFormRowMapper());
        return result;
    }

    public void insertHubungiKamiForm(HubungiKamiForm hubungiKamiForm) {
        jdbcTemplate.update("INSERT INTO hubungi_kami_form (nama, email, pesan) values (?, ?, ?)",
                hubungiKamiForm.getNama(),
                hubungiKamiForm.getEmail(),
                hubungiKamiForm.getPesan()
        );
    }

    public HubungiKamiForm getHubungiKamiFormById(int id) {
        return jdbcTemplate.queryForObject("select * from hubungi_kami_form where id=?", new HubungiKamiFormRowMapper(), id);
    }

    public void deleteHubungiKamiForm(HubungiKamiForm form) {
        jdbcTemplate.update("DELETE FROM hubungi_kami_form WHERE id=? and nama=? and pesan=?", form.getId(), form.getNama(), form.getPesan());
    }

    public class HubungiKamiFormRowMapper implements RowMapper<HubungiKamiForm> {
        public HubungiKamiForm mapRow(ResultSet rs, int rowNum) throws SQLException {
            HubungiKamiForm hubungiKamiForm = new HubungiKamiForm();
            hubungiKamiForm.setId(rs.getInt("id"));
            hubungiKamiForm.setNama(rs.getString("nama"));
            hubungiKamiForm.setEmail(rs.getString("email"));
            hubungiKamiForm.setPesan(rs.getString("pesan"));
            return hubungiKamiForm;
        }
    }

}
