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

    @Override
    public List findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object findOne(String param) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Object object) {
       String sql = "insert into maquina(fk_setor, nome, so, cpu, ram, gpu, status) "
                + "values (2, ?, ?, ?, ?, ?, 'Ok')";
       Maquina maquina = (Maquina)object;

       jdbcTemplate.update(sql, maquina.getNome(), maquina.getSo(), maquina.getCpu(), maquina.getRam(), maquina.getGpu());
       /* String sql = "UPDATE maquina SET nome=?, so=?, cpu=?, ram= ?, gpu=? WHERE email=?"; */
       System.out.println("Inserido com sucesso!");
    }

    @Override
    public void update(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
