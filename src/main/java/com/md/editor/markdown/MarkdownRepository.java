package com.md.editor.markdown;

import org.apache.commons.lang3.StringUtils;
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
import java.sql.Statement;
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
     * リスト取得処理
     * @return
     */
    public List<Markdown> getList(String title, ListOrderKey sort, OrderType order, int offset, int size) throws DataAccessException {
        String sql;
        Object[] args;
        if (StringUtils.isNotBlank(title)) {
            sql = String
                    .format("SELECT * FROM markdown WHERE title LIKE ? ORDER BY %s %s LIMIT ?, ?",
                            sort.getColumnName(), order.getColumnName());
            args = new Object[]{"%" + title + "%", offset, size};
        } else {
            sql = String
                    .format("SELECT * FROM markdown ORDER BY %s %s LIMIT ?, ?",
                            sort.getColumnName(), order.getColumnName());
            args = new Object[]{offset, size};
        }



        RowMapper<Markdown> rowMapper = new BeanPropertyRowMapper<Markdown>(Markdown.class);
        return jdbcTemplate.query(sql, rowMapper, args);
    }

    /**
     * 詳細情報取得処理
     * @return
     */
    public Markdown get(long id) throws DataAccessException {
        String sql = String
                .format("SELECT * FROM markdown WHERE id = ?");
        RowMapper rowMapper = new BeanPropertyRowMapper(Markdown.class);
        return (Markdown) jdbcTemplate.queryForObject(sql, rowMapper, id);
    }
}
