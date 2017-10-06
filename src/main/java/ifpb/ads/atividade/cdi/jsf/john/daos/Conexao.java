/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.atividade.cdi.jsf.john.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author recursive
 */
public class Conexao {
    
    private static String user = "john";
    private static String senha = "posgres";
    private static String url = "postgres";
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection cone = DriverManager.getConnection(url,user, senha);
        return cone;
    }
}
