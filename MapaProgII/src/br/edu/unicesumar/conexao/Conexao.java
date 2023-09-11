/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.unicesumar.conexao;

/**
 *
 * @author Gabriel
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao{

    private static final String url = "jdbc:mysql://localhost:3306/mapa";

    private static final String user = "root";

    private static final String password = "123456789";

    private static Connection conn;

    public static Connection getConexao(){
        try {
            if(conn == null){
                conn = DriverManager.getConnection(url, user, password);
                return conn;
            }else{
                return conn;
            }
        } catch (SQLException e) {
          e.printStackTrace();
            return null;
        }
    }
       
}