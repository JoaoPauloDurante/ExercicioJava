/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Exceptions.ValidacaoException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import service.ClienteService;

/**
 *
 * @author Maq01
 */
public class ConsultarClienteView extends javax.swing.JFrame {

    /**
     * Creates new form ConsultarClienteView
     */
    public ConsultarClienteView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTabela = new javax.swing.JTable();
        jButtonConsultarClientes = new javax.swing.JButton();
        jTextFieldNome = new javax.swing.JTextField();
        jTextFieldCodCliente = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTabela);

        jButtonConsultarClientes.setText("Consultar clientes");
        jButtonConsultarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarClientesActionPerformed(evt);
            }
        });

        jTextFieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jButtonConsultarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jTextFieldCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonConsultarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setBounds(0, 0, 499, 445);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConsultarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarClientesActionPerformed
        try {
            /* criar uma variavel do tipo List<Cliente> e atribuir
            o retorno do metodo respectivo da camada service  */

            List<Cliente> listaClientes = null;
            
            if(!jTextFieldNome.getText().isEmpty()){
                try{
            
                listaClientes = ClienteService.consultarTodosClientesNomeService(jTextFieldNome.getText());
                }
                catch(ValidacaoException vex){
                    
                    JOptionPane.showMessageDialog(this,vex.getMessage(),"ERRO",JOptionPane.ERROR_MESSAGE);
                        
                        }
                
                
            
            }
            else
                if (!jTextFieldCodCliente.getText().isEmpty())
                        
                   { 
                try{
                listaClientes = ClienteService.consultarTodosClientesCodigoService(Integer.parseInt(jTextFieldCodCliente.getText()));
                }
                catch(Exception ex){JOptionPane.showMessageDialog(this,"Digite apenas numeros inteiros \n "+ex.getMessage(),"Erro",JOptionPane.INFORMATION_MESSAGE);
                
                }
                }else {
                
                listaClientes = ClienteService.consultarTodosClientesService();
                }
            
            
            
            
                    

            //se esta lista estiver nula ou vazia, exiber menssagem na tela 
            //caso contraio, preencher a tabela
            if ((listaClientes == null) || (listaClientes.isEmpty())) {
                JOptionPane.showMessageDialog(this, "Nehum cliente cadastrado", "sem resultados", JOptionPane.INFORMATION_MESSAGE);
            } else {
                //carregar dados na tabela
                //cria um default table model

                DefaultTableModel modeloTabela = new DefaultTableModel();
                //mostra os cabeçalhos das colunas da tabela
                modeloTabela.addColumn("Codigo");
                modeloTabela.addColumn("Nome");
                modeloTabela.addColumn("Sobrenome");
                modeloTabela.addColumn("Endereco");
                modeloTabela.addColumn("Cpf");
                modeloTabela.addColumn("Cidade");
                modeloTabela.addColumn("Estado");
                modeloTabela.addColumn("Flg_Ativo");
                //para cada cliente retornado na lista preencha uma linha na tabela
                for (Cliente c : listaClientes) {
                    //cria uma linha generica com a quantidade de colunas do modelo tabela
                    Object[] vetorLinhas = new Object[modeloTabela.getColumnCount()];

                    //preencha as colunas de cada linha do vetorLinhas para preencher com os dados do cliente
                    vetorLinhas[0] = c.getCodCliente();
                    vetorLinhas[1] = c.getNome();
                    vetorLinhas[2] = c.getSobrenome();
                    vetorLinhas[3] = c.getCpf();
                    vetorLinhas[4] = c.getEndereco();
                    vetorLinhas[5] = c.getEstado();
                    vetorLinhas[6] = c.getCidade();

                    vetorLinhas[7] = c.getFlgAtivo();
                    modeloTabela.addRow(vetorLinhas);

                }
                //desabilita seleçao de colunas na tabela

                jTabela.setColumnSelectionAllowed(false);
                // desabilita selecao de celulas na tabelas
                jTabela.setCellSelectionEnabled(false);
                //habilita selecao de unica linha
                jTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                //adiciona o modelo pronto a tabela
                jTabela.setModel(modeloTabela);
                //mostra a tabela
                jTabela.setVisible(true);

            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "ERRO: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonConsultarClientesActionPerformed

    private void jTextFieldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConsultarClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultarClienteView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConsultarClientes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabela;
    private javax.swing.JTextField jTextFieldCodCliente;
    private javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables
}
