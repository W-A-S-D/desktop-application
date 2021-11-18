/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wasd.wasd.prototipo.java.model.dao;

import br.com.wasd.wasd.prototipo.java.Connection;
import br.com.wasd.wasd.prototipo.java.model.Maquina;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author bianc
 */
public class MaquinaDao implements DAO {
    
    private Connection config = new Connection();
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(config.getDataSource());

    public void cadastrar(String nome, String so, String processador, Double ram, String gpu) {

       String sql = "insert into maquina(fk_setor, login, senha, nome, so, cpu, ram, gpu, status) "
                + "values (2, 'teste', 'teste', ?, ?, ?, ?, ?, 'Ok')";
        
       /* String sql = "UPDATE maquina SET nome=?, so=?, cpu=?, ram= ?, gpu=? WHERE email=?"; */
       
        jdbcTemplate.update(sql, nome, so, processador, ram, gpu);

        System.out.println("Inserido com sucesso!");
        System.out.println("Update feito"  + sql);
    }

    @Override
    public List findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
