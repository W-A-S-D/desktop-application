/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wasd.wasd.prototipo.java.model.dao;

import br.com.wasd.wasd.prototipo.java.Connection;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

public class LogDao implements DAO {

    private Connection config = new Connection();
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(config.getDataSource());

    public void cadastrar(Double usoCpu, Double usoRam, Double usoDisco, Double temp) {

        String sql = "insert into log(fk_maquina, freq_cpu, uso_ram, uso_disco, temperatura, criado) values (3, ?, ?, ?, ?, '2021-10-18 12:10:02')";

        jdbcTemplate.update(sql, usoCpu, usoRam, usoDisco, temp);

        System.out.println("Inserido com sucesso!");
    }

    @Override
    public List findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
