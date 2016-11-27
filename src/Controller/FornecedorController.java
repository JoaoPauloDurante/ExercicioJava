/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.FornecedorDAO;
import model.Fornecedor;

/**
 *
 * @author João Paulo
 */
public class FornecedorController {
    
    public void cadastrarFornecedorController(Fornecedor fornecedor) throws Exception{
    
    
    FornecedorDAO dao = new FornecedorDAO();
    
    dao.cadastrarFornecedorDAO(fornecedor);
    
  }
}
