/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wasd.wasd.prototipo.java.model.dao;

import br.com.wasd.wasd.prototipo.java.Connection;
import br.com.wasd.wasd.prototipo.java.model.DiscoMaquina;
import com.github.britooo.looca.api.group.processos.Processo;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author byumi
 */
public class DiscoDao implements DAO{
    
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
        String sql = "insert into disco(fk_maquina, nome, volume) values (3, ?, ?)";
        DiscoMaquina disco = (DiscoMaquina)object;
        jdbcTemplate.update(sql, disco.getNome_disco(), disco.getVolume_disco());

        System.out.println("Disco inserido com sucesso!");
    }

    @Override
    public void update(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
