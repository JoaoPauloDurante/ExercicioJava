/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Controller.ClienteController;
import Exceptions.ValidacaoException;
import java.util.List;
import model.Cliente;

/**
 *
 * @author Maq01
 */
public class ClienteService {

    public static void cadastrarClienteService(Integer codCliente,
            String nome,
            String sobrenome,
            String cpf,
            String endereco,
            String cidade,
            String estado,
            Boolean flgAtivo)throws ValidacaoException, Exception {

        //TODO:fazer validaçoes de campos
        //nome não pode ser nulo
        //estado nao pode ter mais de duas letras
        // Flg Ativo será sempre true 
        
        int indexErro = 0;
        String MenssagensErro="";
        if ((nome==null)||(nome.isEmpty())){
        
          MenssagensErro +="\n nome nao pode ser vazio";
          indexErro++;
        }
        if (estado.length()!=2){
        
        MenssagensErro+="\n Estado só pode ter 2 letras";
        indexErro++;
        }
        if (indexErro>0){
        
            throw new ValidacaoException(MenssagensErro);
        
        }
        //instancia controller
        ClienteController controller = new ClienteController();
        
        //cria um objeto cliente passando os valores ja validados
        Cliente cliente = new Cliente();
        
        cliente.setCidade(cidade);
        cliente.setCodCliente(codCliente);
        cliente.setCpf(cpf);
        cliente.setEndereco(endereco);
        cliente.setFlgAtivo(flgAtivo);
        cliente.setNome(nome);
        cliente.setSobrenome(sobrenome);
        
        //passa o cliente já preenchido para o controller
        
        controller.cadastrarClienteController(cliente);
    }
    
    public static List<Cliente> consultarTodosClientesService() throws Exception{
        
        
    ClienteController controller = new ClienteController();
    
    return controller.consultarTodosClientesController();
    
    }
    public static List<Cliente> consultarTodosClientesNomeService(String nomeCliente) throws Exception,ValidacaoException{
        
        if(nomeCliente.length()<3){
        
        throw new ValidacaoException("Digite 3 ou mais letras");
        }
    ClienteController controller = new ClienteController();
    
    return controller.consultarTodosClientesNomeController(nomeCliente);
            
    
    }
    public static List<Cliente> consultarTodosClientesCodigoService(int codCliente) throws Exception{
        
       // if((codCliente==null) ||(codCliente.isEmpty())){
        
        
        //} 
        
    ClienteController controller = new ClienteController();
    
    return controller.consultarTodosClientesCodigoController(codCliente);
            
    
    }
}
