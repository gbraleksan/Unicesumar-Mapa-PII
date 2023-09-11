/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.unicesumar.core.entity.dao;

import br.edu.unicesumar.conexao.Conexao;
import br.edu.unicesumar.core.entity.Login;
import br.edu.unicesumar.view.telaErroLogin;
import br.edu.unicesumar.view.telaLogin;
import br.edu.unicesumar.view.telaSucessoLogin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
/**
 *
 * @author Gabriel
 */
public class LoginDAO {
    
    
    public void login(Login login){
        
        PreparedStatement ps = null;
        ResultSet rs = null;
    
        String sql = "SELECT * FROM usuario WHERE LOGIN=? AND SENHA=?";
        
        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, login.getLogin());
            ps.setString(2, login.getSenha());
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                telaSucessoLogin sucesso = new telaSucessoLogin();
                sucesso.setVisible(true);
                sucesso.setLocationRelativeTo(null);
            }else{
                telaErroLogin erro = new telaErroLogin();
                erro.setVisible(true);
                erro.setLocationRelativeTo(null);
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
