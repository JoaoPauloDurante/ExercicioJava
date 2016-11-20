/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ClienteDAO;
import Exceptions.ValidacaoException;
import java.util.List;
import model.Cliente;

/**
 *
 * @author Maq01
 */
public class ClienteController {
    
    
    public void cadastrarClienteController(Cliente cliente) throws Exception{
    
        //controller recebe o cliente pronto
        //instancia o DAO e passa o cliente para o DAO
    ClienteDAO dao=new ClienteDAO();
    
    dao.cadastrarClienteDAO(cliente);
    
    }
    
    public List<Cliente> consultarTodosClientesController() throws Exception
    {
     ClienteDAO dao = new ClienteDAO();
     
     return dao.consultarTodosClientesDAO();
    
    }
    public List<Cliente> consultarTodosClientesNomeController(String nomeCliente) throws Exception
    {
     ClienteDAO dao = new ClienteDAO();
     
     return dao.consultarTodosClientesNomeDAO(nomeCliente);
    
    }
 public List<Cliente> consultarTodosClientesCodigoController(int codCliente) throws Exception
    {
     ClienteDAO dao = new ClienteDAO();
     
     return dao.consultarTodosClientesCodigoDAO(codCliente);
    }
   
}
