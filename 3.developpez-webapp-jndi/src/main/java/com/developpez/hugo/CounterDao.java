package com.developpez.hugo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

@Repository
@Transactional
public class CounterDao {

    private static final String INCREMENT_CPTR = "UPDATE COUNTERS SET CPTR = 1+CPTR";
    private static final String RETRIEVE_CPTR = "SELECT CPTR FROM COUNTERS";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CounterDao(DataSource datasource) {
        jdbcTemplate = new JdbcTemplate(datasource);
    }

    public void incrementCptr() {
        jdbcTemplate.update(INCREMENT_CPTR);
    }

    public int getValue() {
        return jdbcTemplate.queryForInt(RETRIEVE_CPTR);
    }
}
