package br.com.wasd.wasd.prototipo.java;

import org.apache.commons.dbcp2.BasicDataSource;

public class Connection {

    private BasicDataSource dataSource;
    
    public Connection() {
        dataSource = new BasicDataSource();

        dataSource​.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource​.setUrl("jdbc:mysql://localhost:3306/wasd");
        dataSource​.setUsername("wasd");
        dataSource​.setPassword("1234");

    }

    public BasicDataSource getDataSource() {
        return dataSource;
    }
}
