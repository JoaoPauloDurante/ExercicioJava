/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mysql.jdbc.Connection;
import factory.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Fornecedor;

/**
 *
 * @author João Paulo
 */
public class FornecedorDAO {
    public void cadastrarFornecedorDAO(Fornecedor fornecedor) throws Exception {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = ConnectionFactory.getConnection();

            String sql = "INSERT INTO FORNECEDOR "
                    + "(NOME_FORNECEDOR "
                    + ", CIDADE "
                    + ", ESTADO "
                    + ", FLG_ATIVO)"
                    + " VALUES(?, ?, ? , ?)";
                 

            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, fornecedor.getNomeFornecedor());
            pstmt.setString(2, fornecedor.getCidade());
            pstmt.setString(3, fornecedor.getEstado());
            pstmt.setBoolean(4, fornecedor.getFlgAtivo());
            
           

            //executa o sql
            pstmt.execute();

            //fecha a conexão
            conn.close();

        } catch (SQLException sqlex) {

            throw new Exception("Erro da camada DAO, problema com slq: " + sqlex.getMessage());
        } catch (Exception ex) {

            throw new Exception("Erro da camada DAO" + ex.getMessage());
        } finally {
            if (pstmt != null) {

                try {

                    pstmt.close();
                } catch (SQLException sqlex) {

                    throw new Exception("Erro da camada DAO, problema ao fechar a conexão SQL " + sqlex.getMessage());
                }

            }

        }
    }
    
    public List<Fornecedor> consultarTodosFornecedoresDAO() throws Exception {

        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection conn = null;

        List<Fornecedor> listaSaida = new ArrayList<>();

        Fornecedor fornecedor = null;
        try {
            conn = ConnectionFactory.getConnection();

            String sql = "select cod_fornecedor,nome_fornecedor, cidade, estado, flg_ativo from fornecedor";

            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();

            while (rs.next()) {

                // para cada linha retornada cria uma nova instancia de fornecedor  
                fornecedor = new Fornecedor();

                fornecedor.setCodFornecedor(rs.getInt("cod_fornecedor"));
                fornecedor.setNomeFornecedor(rs.getString("nome_fornecedor"));
                fornecedor.setCidade(rs.getString("cidade"));
                fornecedor.setEstado(rs.getString("estado"));
                fornecedor.setFlgAtivo(rs.getBoolean("flg_Ativo"));
                // adiciona o cliente recem preenchido na lista 
                listaSaida.add(fornecedor);

                // limpa a referencia ao cliente 
                fornecedor = null;

            }
              

            // fecha a conexão 
            conn.close();

        } catch (SQLException sqlEx) {

            throw new Exception("Erro da camada DAO, problemas com sql " + sqlEx.getMessage());

        } catch (Exception ex) {
            throw new Exception("Erro da camada DAO: " + ex.getMessage());

        } finally {

            if (rs != null) {
                try {

                    rs.close();

                } catch (SQLException sqlEx) {

                    throw new Exception("Erro da cama DAO, problemas ao fechar a conexão com SQL: " + sqlEx.getMessage());

                }

            }
            if (pstmt != null) {
                try {

                    pstmt.close();
                } catch (SQLException sqlEx) {

                    throw new Exception("Erro da camada DAO, problema ao fechar a conexão SQL" + sqlEx.getMessage());
                }

            }
        }
        return listaSaida;
    }
}
