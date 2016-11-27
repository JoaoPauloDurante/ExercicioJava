/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author fernando-pucci
 * 
 * F?brica de conex?es JAVA com o Banco de Dados MySql
 * 
 * N?o esquecer de apontar para a base de dados correta
 * 
 */
public class ConnectionFactory {
 
 private static Connection conn;
 
 public static Connection getConnection() throws SQLException {
 
  // Connection Factory de exemplo para Banco MySQL
 
  try {
 
   // Configura??es para acesso ao Banco de dados
 
      //"jdbc:mysql://localhost:3306/karthicraj","mysql","mysql"
      
   String driverName = "com.mysql.jdbc.Driver";
   String url = "jdbc:mysql://localhost:3306/EXEC_PC_II";
   String username = "root";
   String password = "";
 
 
 
   // Carrega o driver JDBC
   Class.forName(driverName);
    
   // Cria uma conex?o com a base de dados
   conn = (Connection) DriverManager.getConnection(url, username, password);
 
  } catch (ClassNotFoundException e) {
 
   // Erro na conex?o com o driver
   System.out.println("N?o foi localizado o driver.");
    
  } catch (SQLException f) {
    
   // Erro na conex?o com o Banco de Dados
   System.out.println("N?o foi poss?vel conectar ao banco.");
   f.printStackTrace();
    
  }
  return conn;
 }
 
 // Fecha as conex?es
 
 public static void closeConnection(Connection conn, PreparedStatement pstm,
   ResultSet rs) throws Exception {
  close(conn, pstm, rs);
 }
 
 public static void closeConnection(Connection conn, PreparedStatement pstm)
   throws Exception {
  close(conn, pstm, null);
 }
 
 public static void closeConnection(Connection conn) throws Exception {
  close(conn, null, null);
 }
 
 private static void close(Connection conn, PreparedStatement pstm,
   ResultSet rs) throws Exception {
  try {
   if (rs != null)
    rs.close();
   if (pstm != null)
    pstm.close();
   if (conn != null)
    conn.close();
  } catch (Exception e) {
   throw new Exception(e.getMessage());
  }
 }
 
}
    

