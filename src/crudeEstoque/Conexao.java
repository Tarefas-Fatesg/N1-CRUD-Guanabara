/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudeEstoque;

/**
 *
 * @author kai
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static Connection conexao = null;
    public static Connection getConexao(){
        if (conexao != null){
            return conexao;
        }
        else{
            try{
                
                String driver = "org.postgresql.Driver";
                String url = "jdbc:postgresql://localhost:5432/ProjetoPaciente";
                String user = "postgres";
                String password = "12345";
                Class.forName(driver);
                conexao = DriverManager.getConnection(url, user, password);
            }
            catch(ClassNotFoundException e){
                e.printStackTrace();
            }
            catch(SQLException e){
                e.printStackTrace();
            }
            return conexao;
        }
    }   
}
