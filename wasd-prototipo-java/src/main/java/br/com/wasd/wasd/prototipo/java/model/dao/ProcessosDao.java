/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wasd.wasd.prototipo.java.model.dao;

import br.com.wasd.wasd.prototipo.java.Connection;
import br.com.wasd.wasd.prototipo.java.mapper.ProcessosMapper;
//import br.com.wasd.wasd.prototipo.java.model.Processos;
import com.github.britooo.looca.api.group.processos.Processo;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author bianc
 */
public class ProcessosDao implements DAO {

    private Connection config = new Connection();
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(config.getDataSource());

    @Override
    public List findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object findOne(String param) {
        String sql = "select * from processso where nome = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{param}, new ProcessosMapper());
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void insert(Object object) {
        String sql = "insert into processo(fk_maquina, nome) values (3, ?)";
        Processo processo = (Processo) object;
        jdbcTemplate.update(sql, processo.getNome());

        System.out.println("Processos inserido com sucesso!");
    }

    @Override
    public void update(Object object) {
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        df.setTimeZone(tz);
        String timeString = df.format(System.currentTimeMillis());
        Date date = null;
        try {
            date = df.parse(timeString);
        } catch (ParseException ex) {
            Logger.getLogger(ProcessosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.sql.Timestamp sqlDate = new java.sql.Timestamp(date.getTime());
        String sql = "UPDATE processo SET atualizado = ? WHERE nome= ?;";
        Processo processo = (Processo) object;
        jdbcTemplate.update(sql, sqlDate, processo.getNome());

        System.out.println("Processos atualizado com sucesso!");
    }

}
