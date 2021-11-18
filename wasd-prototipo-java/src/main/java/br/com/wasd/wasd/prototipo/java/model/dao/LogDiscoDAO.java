package br.com.wasd.wasd.prototipo.java.model.dao;

import br.com.wasd.wasd.prototipo.java.Connection;
import br.com.wasd.wasd.prototipo.java.model.Log_disco;
import com.github.britooo.looca.api.core.Looca;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

public class LogDiscoDAO implements DAO {

    private Connection config = new Connection();
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(config.getDataSource());
    Looca looca = new Looca();
    DiscoDao disco = new DiscoDao();

    public void inserirDado(Log_disco log){
        String sql = "insert into log(fk_log, fk_disco, uso_disco) values (?, ?, ?)";
        
        jdbcTemplate.update(sql, log.getFk_log(), log.getFk_disco(), log.getUso_disco());
    }

    @Override
    public List findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
