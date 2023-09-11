/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.unicesumar.core.entity.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.edu.unicesumar.conexao.Conexao;
import br.edu.unicesumar.core.entity.Cadastro;
import br.edu.unicesumar.view.telaSucessoCadastro;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel
 */
public class CadastroDAO {
    
    public void cadastrarUsuario(Cadastro cadastro){
        
        String sql = "INSERT INTO USUARIO (NOME, LOGIN, SENHA, EMAIL) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, cadastro.getNome());
            ps.setString(2, cadastro.getLogin());
            ps.setString(3, cadastro.getSenha());
            ps.setString(4, cadastro.getEmail());

            ps.execute();
            telaSucessoCadastro sucessoCadastro = new telaSucessoCadastro();
            sucessoCadastro.setVisible(true);
            sucessoCadastro.setLocationRelativeTo(null);
            ps.close();


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
}
