package com.md.editor.markdown;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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
     * @return
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

    /**
     * 全件取得処理
     * @return
     */
    public List<Markdown> getAll(ListOrderKey sort, String order, int offset, int size) throws DataAccessException {
        String sql;
        if (order.equals("desc")) {
            sql = String
                    .format("SELECT * FROM markdown ORDER BY %s DESC LIMIT ?, ?",
                            sort.getColumnName());
        } else {
            sql = String
                    .format("SELECT * FROM markdown ORDER BY %s ASC LIMIT ?, ?",
                            sort.getColumnName());
        }



        RowMapper<Markdown> rowMapper = new BeanPropertyRowMapper<Markdown>(Markdown.class);
        return jdbcTemplate.query(sql, rowMapper, offset, size);
    }
}
