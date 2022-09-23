package com.md.editor.markdown;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class MarkdownRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    /**
     * 登録処理
     * @param entity
     * @return id
     */
    public long insert(Markdown entity) throws DataAccessException {
        String sql = ""
                + "INSERT INTO markdown("
                + "title, body) "
                + "VALUES(?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, entity.getTitle());
            ps.setString(2, entity.getBody());
            return ps;
        }, keyHolder);

        return keyHolder.getKey().longValue();
    }
}
