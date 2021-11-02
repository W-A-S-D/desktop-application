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

    public void cadastrarDisco(DiscoMaquina disco) {

        String sql = "insert into disco(fk_maquina, nome_disco, volume_disco) values (3, ?, ?)";

        jdbcTemplate.update(sql, disco.getNome_disco(), disco.getVolume_disco());

        System.out.println("Inserido com sucesso!");
    }

    @Override
    public List findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}