/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import DAO.ClienteDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cliente;

/**
 *
 * @author Maq01
 */
public class ClienteTester {

    public static void main(String[] args) {

//        cadastrarClienteTester();
        consultarClientePorNomeTester("J");

    }

    public static void cadastrarClienteTester() {
        Cliente c = new Cliente();

        c.setNome("João Paulo");
        c.setSobrenome("Durante");
        c.setCpf("154682");
        c.setEstado("MG");
        c.setCidade("Arceburgo");
        c.setEndereco("Centro ");
        c.setFlgAtivo(true); //flgAtivo sempre true ao cadastrar um cliente

        ClienteDAO dao = new ClienteDAO();

        try {
            dao.cadastrarClienteDAO(c);
        } catch (Exception ex) {
            Logger.getLogger(ClienteTester.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void consultarClientePorNomeTester(String nome) {

        List<Cliente> lista = null;

        ClienteDAO clienteDAO = new ClienteDAO();

        try {
            lista = clienteDAO.consultarTodosClientesNomeDAO(nome);

        } catch (Exception ex) {
            Logger.getLogger(ClienteTester.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (lista != null && !lista.isEmpty()) {

            for (Cliente c : lista) {
                System.out.println(c.toString());
            }

        } else {
            System.out.println("Não há nehum cliente cadastrado");

            System.out.println("teste OK");

        }
    }

    public static void consultarClienteTester() {

        List<Cliente> lista = null;

        ClienteDAO clienteDAO = new ClienteDAO();

        try {
            lista = clienteDAO.consultarTodosClientesDAO();

        } catch (Exception ex) {
            Logger.getLogger(ClienteTester.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (lista != null && !lista.isEmpty()) {

            for (Cliente c : lista) {
                System.out.println(c.toString());
            }

        } else {
            System.out.println("Não há nehum cliente cadastrado");

            System.out.println("teste OK");

        }

    }

}
