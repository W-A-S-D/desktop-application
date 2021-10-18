package br.com.wasd.wasd.prototipo.java.model.dao;

import br.com.wasd.wasd.prototipo.java.Connection;
import br.com.wasd.wasd.prototipo.java.model.Usuario;
import org.springframework.jdbc.core.JdbcTemplate;
import br.com.wasd.wasd.prototipo.java.mapper.UsuarioMapper;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;

public class UsuarioDAO implements DAO {

    private Connection config = new Connection();
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(config.getDataSource());

    public Usuario login(String login, String senha) {

        String sql = "select * from USUARIO where login =? and senha= ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{login, senha}, new UsuarioMapper());

        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
