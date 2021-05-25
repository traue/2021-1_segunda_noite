package br.sisacademico.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String urlDB = "jdbc:derby://localhost:1527/SisAcademico_2noite";
    private static final String user = "uninove";
    private static final String pass = "Senha123";
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(urlDB, user, pass);
    }
}
