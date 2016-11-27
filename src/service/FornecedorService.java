/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Controller.ClienteController;
import Controller.FornecedorController;
import Exceptions.ValidacaoException;
import model.Fornecedor;

/**
 *
 * @author João Paulo
 */
public class FornecedorService {
    
    public static void cadastrarFornecedorService(Integer codFornecedor,
            String nomeFornecedor,
            String cidade,
            String estado,
            Boolean flgAtivo)throws ValidacaoException, Exception {
          

        //TODO:fazer validaçoes de campos
        //nome não pode ser nulo
        //estado nao pode ter mais de duas letras
        // Flg Ativo será sempre true 
        
        int indexErro = 0;
        String MenssagensErro="";
        if ((nomeFornecedor==null)||(nomeFornecedor.isEmpty())){
        
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
        FornecedorController controller = new FornecedorController();
        
        //cria um objeto fornecedor passando os valores ja validados
        Fornecedor fornecedor = new Fornecedor();
        
        fornecedor.setCidade(cidade);
        fornecedor.setCodFornecedor(codFornecedor);
        
        fornecedor.setFlgAtivo(flgAtivo);
        fornecedor.setNomeFornecedor(nomeFornecedor);
        
        
        //passa o cliente já preenchido para o controller
        
        controller.cadastrarFornecedorController(fornecedor);
    }
}
