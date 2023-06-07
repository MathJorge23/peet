
package viwe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import jdbc.ConnectionFactory;
import jdbc.dao.ClienteDao;
import jdbc.model.Cliente;
import jdbc.service.ClienteService;


public class cadastros extends javax.swing.JFrame {
Connection conexao;
ClienteService cli;
Cliente c;
atualizarCliente enviaIdAt;
cadastro_pet envidaIdPet;
adicionarEndereco enviaIdEnd;

    public cadastros() {
        initComponents();
        conexao = new ConnectionFactory()
                .getConnectionUSBWebService();
        cli = new ClienteService(new ClienteDao());
        c= new Cliente ();
        
        carregaTabela();
        
        idCliente.setEditable(false);
        nomeCliente.setEditable(false);
        
    }
private void carregaTabela(){
        DefaultTableModel modelo= (DefaultTableModel) tblClientes.getModel();
        modelo.setNumRows(0);
        
        tblClientes.getColumnModel().getColumn(0).setPreferredWidth(20);//coluna de id
        tblClientes.getColumnModel().getColumn(1).setPreferredWidth(120);//coluna nome
        tblClientes.getColumnModel().getColumn(2).setPreferredWidth(120);
        
       String query = "SELECT cliente.id, cliente.nome, pet.nome AS pet_nome FROM cliente LEFT JOIN pet ON cliente.id = pet.cliente_id";

        PreparedStatement consulta = null;
        ResultSet resultado = null;
        try {
            consulta = conexao.prepareStatement(query);
            resultado = consulta.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nome = resultado.getString("nome");
                String pet = resultado.getString("pet_nome");

                
                modelo.addRow(new Object[]{id,nome, pet});
            }
           
        } catch (SQLException erro) {
            throw new RuntimeException(erro.getMessage());
        }
        
}







    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnCadastroPet = new javax.swing.JButton();
        btnCadastroCliente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        idCliente = new javax.swing.JTextField();
        nomeCliente = new javax.swing.JTextField();
        btnAtualizar = new javax.swing.JButton();
        bntDelete = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        btnAddEndereco = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCadastroPet.setText("Cadastro Pet");
        btnCadastroPet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCadastroPetMouseClicked(evt);
            }
        });
        btnCadastroPet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroPetActionPerformed(evt);
            }
        });
        jPanel1.add(btnCadastroPet, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, 30));

        btnCadastroCliente.setText("Cadastro Cliente");
        btnCadastroCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCadastroClienteMouseClicked(evt);
            }
        });
        jPanel1.add(btnCadastroCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 110, 31));

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nome", "Pet"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblClientes);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 210, 90));

        jLabel1.setText("ID:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 184, 30, -1));

        jLabel2.setText("Nome:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 176, 50, 30));

        idCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idClienteActionPerformed(evt);
            }
        });
        jPanel1.add(idCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 40, -1));
        jPanel1.add(nomeCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 170, -1));

        btnAtualizar.setText("Atualizar");
        btnAtualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAtualizarMouseClicked(evt);
            }
        });
        jPanel1.add(btnAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 80, 30));

        bntDelete.setText("Delete");
        bntDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bntDeleteMouseClicked(evt);
            }
        });
        jPanel1.add(bntDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 70, 30));

        jPanel5.setBackground(new java.awt.Color(153, 204, 0));
        jPanel5.setForeground(new java.awt.Color(153, 204, 0));
        jPanel5.setPreferredSize(new java.awt.Dimension(145, 70));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Pet Shop");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(433, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 52));

        btnCancel.setText("Sair");
        btnCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelMouseClicked(evt);
            }
        });
        jPanel1.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, 50, 30));

        btnAddEndereco.setText("Adicionar Endereço");
        btnAddEndereco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddEnderecoMouseClicked(evt);
            }
        });
        jPanel1.add(btnAddEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, -1, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 340));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastroClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCadastroClienteMouseClicked
        this.setVisible(false);
        new cadastro_cliente().setVisible(true);
    }//GEN-LAST:event_btnCadastroClienteMouseClicked

    private void btnCadastroPetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCadastroPetMouseClicked
             if ( envidaIdPet == null){
                envidaIdPet= new cadastro_pet();
                envidaIdPet.setVisible(true);
                envidaIdPet.setIdDono(Integer.parseInt(idCliente.getText()));
                this.setVisible(false);
             }else{
                envidaIdPet.setVisible(true);
                envidaIdPet.setState(cadastros.NORMAL);
                envidaIdPet.setIdDono(Integer.parseInt(idCliente.getText()));
                this.setVisible(true);         
         }
    }//GEN-LAST:event_btnCadastroPetMouseClicked

    private void btnCadastroPetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroPetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCadastroPetActionPerformed

    private void idClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idClienteActionPerformed

    private void btnAtualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtualizarMouseClicked
         if ( enviaIdAt == null){
                enviaIdAt= new atualizarCliente();
                enviaIdAt.setVisible(true);
                enviaIdAt.setInfoCliente(Integer.parseInt(idCliente.getText()));
                this.setVisible(false);
             }else{
                enviaIdAt.setVisible(true);
                enviaIdAt.setState(cadastros.NORMAL);
                enviaIdAt.setInfoCliente(Integer.parseInt(idCliente.getText()));
                this.setVisible(false);         
         }
    }//GEN-LAST:event_btnAtualizarMouseClicked

    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMouseClicked
        int selecionado = tblClientes.getSelectedRow();
        if(selecionado != -1){
            idCliente.setText(Integer.toString((Integer) tblClientes.getValueAt(selecionado, 0)));
            nomeCliente.setText((String) tblClientes.getValueAt(selecionado,1));
        }
    }//GEN-LAST:event_tblClientesMouseClicked

    private void bntDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntDeleteMouseClicked
        cli.excluirPet(Integer.parseInt(idCliente.getText()));
        cli.excluirEndereco(Integer.parseInt(idCliente.getText()));
        cli.excluir(Integer.parseInt(idCliente.getText()));
    }//GEN-LAST:event_bntDeleteMouseClicked

    private void btnCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnCancelMouseClicked

    private void btnAddEnderecoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddEnderecoMouseClicked
        if ( envidaIdPet == null){
                enviaIdEnd= new adicionarEndereco();
                enviaIdEnd.setVisible(true);
                enviaIdEnd.setInfoCliente(Integer.parseInt(idCliente.getText()));
                this.setVisible(false);
             }else{
                enviaIdEnd.setVisible(false);
                enviaIdEnd.setState(cadastros.NORMAL);
                enviaIdEnd.setInfoCliente(Integer.parseInt(idCliente.getText()));
                this.setVisible(false);  
                
         }
    }//GEN-LAST:event_btnAddEnderecoMouseClicked

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
            java.util.logging.Logger.getLogger(cadastros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cadastros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cadastros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cadastros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cadastros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntDelete;
    private javax.swing.JButton btnAddEndereco;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCadastroCliente;
    private javax.swing.JButton btnCadastroPet;
    private javax.swing.JButton btnCancel;
    private javax.swing.JTextField idCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nomeCliente;
    private javax.swing.JTable tblClientes;
    // End of variables declaration//GEN-END:variables
}
