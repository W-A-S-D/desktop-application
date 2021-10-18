/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wasd.wasd.prototipo.java.model.dao;

import br.com.wasd.wasd.prototipo.java.Connection;
import com.github.britooo.looca.api.group.processos.Processo;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author bianc
 */
public class MaquinaDao implements DAO {
    
    private Connection config = new Connection();
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(config.getDataSource());

    public void cadastrar(String nome, String so, String processador, Double ram, Double disco, String gpu) {

        String sql = "insert into maquina values (null, ?, ?, ?, ?, ?, ?, 'Funcionando')";

        jdbcTemplate.update(sql, nome, so, processador, ram, disco, gpu);

        System.out.println("Inserido com sucesso!");
    }

    @Override
    public List findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
