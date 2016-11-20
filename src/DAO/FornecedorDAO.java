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
                    + "(NOME "
                    + ", SOBRENOME "
                    + ", CPF "
                    + ", ENDERECO"
                    + ", CIDADE"
                    + ", ESTADO"
                    + ", FLG_ATIVO)"
                    + " VALUES(?, ?, ? , ?, ?, ?, ?)";

            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getSobrenome());
            pstmt.setString(3, cliente.getCpf());
            pstmt.setString(4, cliente.getEndereco());
            pstmt.setString(5, cliente.getCidade());
            pstmt.setString(6, cliente.getEstado());
            pstmt.setBoolean(7, cliente.getFlgAtivo());

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
    public List<Cliente> consultarTodosFornecedoresDAO() throws Exception {

        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection conn = null;

        List<Cliente> listaSaida = new ArrayList<>();

        Cliente cliente = null;
        try {
            conn = ConnectionFactory.getConnection();

            String sql = "select cod_cliente, nome, sobrenome, cpf, endereco, cidade, estado, flg_Ativo from cliente;";

            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();

            while (rs.next()) {

                // para cada linha retornada cria uma nova instancia de cliente  
                cliente = new Cliente();

                cliente.setCodCliente(rs.getInt("cod_cliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setSobrenome(rs.getString("sobrenome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setEstado(rs.getString("estado"));
                cliente.setFlgAtivo(rs.getBoolean("flg_Ativo"));
                // adiciona o cliente recem preenchido na lista 
                listaSaida.add(cliente);

                // limpa a referencia ao cliente 
                cliente = null;

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
