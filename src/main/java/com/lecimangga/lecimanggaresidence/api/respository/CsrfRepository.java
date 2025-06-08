package com.lecimangga.lecimanggaresidence.api.respository;

import com.lecimangga.lecimanggaresidence.api.model.Csrf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

@Repository
public class CsrfRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public Csrf createCsrfToken() {
        UUID uuid = UUID.randomUUID();
        Csrf csrf = new Csrf();
        csrf.setToken(Base64.getEncoder().encodeToString(uuid.toString().getBytes()));
        Instant now = Instant.now();
        csrf.setCreatedAt(new Timestamp(now.toEpochMilli()));
        csrf.setExpiresAt(new Timestamp(now.plus(30, ChronoUnit.MINUTES).toEpochMilli()));

        return csrf;
    }

    public List<Csrf> getAllCsrfTokens() {
        List<Csrf> result;
        result = jdbcTemplate.query("SELECT * FROM csrf", new CsrfRowMapper());
        return result;
    }

    public void insertCsrfToken(Csrf csrf) {
        jdbcTemplate.update("INSERT INTO csrf (token, created_at, expires_at) values (?, ?, ?)", csrf.getToken(), csrf.getCreatedAt(), csrf.getExpiresAt());
    }

    public Csrf getCsrfToken(String token) {
        try {
            return  jdbcTemplate.queryForObject("SELECT * FROM csrf WHERE token = ?", new CsrfRowMapper(), token);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public void deleteCsrfToken(Csrf csrf) {
        jdbcTemplate.update("DELETE FROM csrf WHERE token = ?", csrf.getToken());
    }

    public void deleteExpiredCsrfTokens() {
        Timestamp now = Timestamp.from(Instant.now());
        jdbcTemplate.update("DELETE FROM csrf WHERE expires_at <= ?", now);
    }

    public static class CsrfRowMapper implements RowMapper<Csrf> {
        @Override
        public Csrf mapRow(ResultSet rs, int rowNum) throws SQLException {
            Csrf csrf = new Csrf();
            csrf.setToken(rs.getString("token"));
            csrf.setCreatedAt(rs.getTimestamp("created_at"));
            csrf.setExpiresAt(rs.getTimestamp("expires_at"));
            return csrf;
        }
    }

}
