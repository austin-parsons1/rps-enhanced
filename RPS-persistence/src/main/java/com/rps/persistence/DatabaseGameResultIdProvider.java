package com.rps.persistence;

import com.rps.core.GameResultIdProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class DatabaseGameResultIdProvider implements GameResultIdProvider {

    final JdbcTemplate jdbcTemplate;

    @Autowired
    public DatabaseGameResultIdProvider(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int getId() {

        List<Integer> seq = jdbcTemplate.query( "select nextval('GameResultIdSeq') val", new SeqRowMapper());

        return seq.get(0); 
    }

    public class SeqRowMapper implements RowMapper
    {

        @Override
        public Object mapRow(ResultSet resultSet, int i) throws SQLException {
            return resultSet.getInt("val");
        }
    }
}
