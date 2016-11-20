/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mysql.jdbc.Connection;
import factory.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

            String sql = "INSERT INTO CLIENTE "
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
}
