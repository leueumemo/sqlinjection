/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mycompany.mavenproject1.Views.Cadastro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Usuario;

/**
 *
 * @author leonardo
 */
public class UsuarioCo {
    private final Connection connection;

    public UsuarioCo(Connection connection) {
        this.connection = connection;
    }
    public void insert (Usuario usuario) throws SQLException{
       
            String sql = "insert into usuario(Usuario , Senha) values ('"+usuario.usuario + "' , '"+usuario.senha+"');";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.execute();
          
        
    }

    public boolean authCO(Usuario auth) throws SQLException {
       //String sql = "select * from usuario where usuario ='"+ auth.usuario + "'and senha = '"+ auth.senha+"'";
       String sql = "select * from usuario where usuario = ? and senha = ?";
       PreparedStatement prepareStatement = connection.prepareStatement(sql);
       prepareStatement.setString(1, auth.usuario);
       prepareStatement.setString(2,auth.senha);
       prepareStatement.execute();
       ResultSet resultset = prepareStatement.getResultSet();      
       return resultset.next();
    }

    
}
