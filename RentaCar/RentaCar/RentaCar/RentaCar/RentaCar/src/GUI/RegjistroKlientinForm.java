/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BL.RegjistroKlientin;
import DAL.Lidhja;
import DAL.RegjistroPuntorinException;
import DAL.RegjistroKlientinInterface;
import static DAL.MyMethods.returnTxt1;
import static DAL.MyMethods.returnTxt2;
import DAL.RegjistroKlientinRepository;
import Model.RegjistroKlientinTableModel;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author BlerimZ
 */
public class RegjistroKlientinForm extends javax.swing.JInternalFrame {
    Lidhja l=new Lidhja();

    RegjistroKlientinRepository regjistroKlientinRepository = new RegjistroKlientinRepository();
    RegjistroKlientinTableModel regjistroKlientinTableModel = new RegjistroKlientinTableModel();
    private void gjeneroCombo( ){
       
         try{
             
        String s = "select * from Gjinia";
      l.st = l.cn.prepareStatement(s);
       l.rs = l.st.executeQuery();
        while(l.rs.next())
        {   String sos=l.rs.getString("Gjinia");
           this.jComboBoxGJINIA.addItem(sos);
        }
         l.st.close();
         l.rs.close();
         }catch(SQLException e){
        JOptionPane.showMessageDialog(null, "ERROR te culonat");
    }
//       try{
//        String s = "select * from StatusiMartesor";
//      l.st = l.cn.prepareStatement(s);
//       l.rs = l.st.executeQuery();
//        while(l.rs.next())
//        {
//           jComboBox2STATUSIMARTESOR.addItem(l.rs.getString("StatusiMartesor"));
//        }
//        l.st.close();
//         l.rs.close();
//       }catch(SQLException e){
//        JOptionPane.showMessageDialog(null, "ERROR te culonat");
//    }           
   }

    /**
     * Creates new form RegjistroPuntorinForm
     */
    public RegjistroKlientinForm() {
        initComponents();
        tabelaLoad();
        gjeneroCombo();
    }

    public void emptyObject() {
       tabela.clearSelection();
        txtEmri1.setText("");
        txtMbiemri.setText("");
        txtDitelindja.setDate(null);
        txtKontakti.setText("");
        txtNRLeternjoftimit.setText("");
        txtAdresa.setText("");
        jComboBoxGJINIA.setSelectedItem("");
        
    }
     

    private void tabelaLoad() {
        List<RegjistroKlientin> lista = regjistroKlientinRepository.findAll();
        regjistroKlientinTableModel.add(lista);
        tabela.setModel(regjistroKlientinTableModel);
        regjistroKlientinTableModel.fireTableDataChanged();
        tabelaSelectedIndexChange();

    }

    private void tabelaSelectedIndexChange() {
        final ListSelectionModel rowSM = tabela.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent Ise) {
                if (Ise.getValueIsAdjusting()) {
                    return;
                }
                ListSelectionModel rowSM = (ListSelectionModel) Ise.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();
                if (selectedIndex > -1) {
                    RegjistroKlientin regjistroKlientin = regjistroKlientinTableModel.getRegjistroPuntorin(selectedIndex);
                       try {
                        jComboBoxGJINIA.setSelectedItem(returnTxt1(regjistroKlientin.getGjiniaID(), "Gjinia"));
                    } catch (SQLException ex) {
                        Logger.getLogger(RegjistroKlientinForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    

                    txtEmri1.setText(regjistroKlientin.getEmri());
                    txtMbiemri.setText(regjistroKlientin.getMbiemri());
                    txtDitelindja.setDate(regjistroKlientin.getDitelindja());
                    txtKontakti.setText(regjistroKlientin.getKontakti() + "");
                    txtNRLeternjoftimit.setText(regjistroKlientin.getNrLeternjoftimit() + "");
                    txtAdresa.setText(regjistroKlientin.getAdresa()+ "");
                   
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtKontakti = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtMbiemri = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDitelindja = new com.toedter.calendar.JDateChooser();
        btnSave = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtEmri1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxGJINIA = new javax.swing.JComboBox<>();
        txtNRLeternjoftimit = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtAdresa = new javax.swing.JTextField();
        SearchBtn = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();

        setBackground(new java.awt.Color(194, 212, 212));
        setClosable(true);
        setMaximizable(true);
        setTitle("Regjistro Klientin");
        setToolTipText("");
        setMinimumSize(new java.awt.Dimension(2147483647, 2147483647));
        setName(""); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel1.setText("Emri Klientit");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel2.setText("Mbiemri Klientit");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel3.setText("Ditëlindja");

        btnSave.setBackground(new java.awt.Color(204, 204, 204));
        btnSave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSave.setText("Ruaje");
        btnSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        tabela.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabela);

        btnDelete.setBackground(new java.awt.Color(204, 204, 204));
        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDelete.setText("Fshije");
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Anulo");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel4.setText("Kontakti");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel9.setText("Gjinia");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel10.setText("Nr Leternjoftimit");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel11.setText("Adresa");

        SearchBtn.setText("Kerko  permes NrPersonal");
        SearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmri1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel9)
                            .addComponent(jComboBoxGJINIA, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNRLeternjoftimit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMbiemri, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDitelindja, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(txtKontakti, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel11)
                            .addComponent(txtAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SearchBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(SearchBtn)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtMbiemri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEmri1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtDitelindja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtKontakti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxGJINIA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNRLeternjoftimit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            int row = tabela.getSelectedRow();
            if (txtEmri1.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Ju lutem Shkruani Emrin :", "Error", JOptionPane.ERROR_MESSAGE);

            } else if (txtMbiemri.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Ju lutem Shkruani Mbiemrin :", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                if (row == -1) {
                    RegjistroKlientin regjistroKlientin = new RegjistroKlientin();
                    regjistroKlientin.setEmri(txtEmri1.getText());
                    regjistroKlientin.setMbiemri(txtMbiemri.getText());
                    regjistroKlientin.setDitelindja(txtDitelindja.getDate());
                    regjistroKlientin.setKontakti(txtKontakti.getText());
                    regjistroKlientin.setAdresa(txtAdresa.getText());
                    regjistroKlientin.setNrLeternjoftimit(txtNRLeternjoftimit.getText());
                    
                    
                      try {
                        regjistroKlientin.setGjiniaID(returnTxt2( "Gjinia",jComboBoxGJINIA.getSelectedItem().toString()));
                    } catch (SQLException ex) {
                        Logger.getLogger(RegjistroKlientinForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                     
                         
                    
                    regjistroKlientinRepository.create(regjistroKlientin);
                    JOptionPane.showMessageDialog(this, "E dhëna u ruajt me sukses !");
                } else {
                    RegjistroKlientin regjistroKlientin = this.regjistroKlientinTableModel.getRegjistroPuntorin(row);

                    regjistroKlientin.setEmri(txtEmri1.getText());
                    regjistroKlientin.setMbiemri(txtMbiemri.getText());
                    regjistroKlientin.setDitelindja(txtDitelindja.getDate());
                    regjistroKlientin.setKontakti(txtKontakti.getText());
                    regjistroKlientin.setAdresa(txtAdresa.getText());
                    regjistroKlientin.setNrLeternjoftimit(txtNRLeternjoftimit.getText());
                       try {
                        regjistroKlientin.setGjiniaID(returnTxt2( "Gjinia",jComboBoxGJINIA.getSelectedItem().toString()));
                    } catch (SQLException ex) {
                        Logger.getLogger(RegjistroKlientinForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                     

                    regjistroKlientinRepository.edit(regjistroKlientin);
                    JOptionPane.showMessageDialog(this, "E dhëna u editua me sukses");
                }
                emptyObject();
                tabelaLoad();
            }

        } catch (RegjistroPuntorinException pe) {
            JOptionPane.showMessageDialog(this, pe.getMessage());
        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
      try{
            int row = tabela.getSelectedRow();
            if(row > -1){
                Object [] ob = {"Po","Jo"};
                int i = javax.swing.JOptionPane.showOptionDialog(this, "A dëshironi ta fshini ?", "Fshirja", JOptionPane.OK_OPTION,JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
                if(i==0){
                    RegjistroKlientin regjistroKlientin = this.regjistroKlientinTableModel.getRegjistroPuntorin(row);
                    regjistroKlientinRepository.remove(regjistroKlientin);
                    tabelaLoad();
                    emptyObject();
                    JOptionPane.showMessageDialog(this, "E dhëna është fshir me sukses !");
                }
            }
            else{
                JOptionPane.showMessageDialog(this,"Nuk keni selektuar asgjë për të fshir !");
            }
        }catch(RegjistroPuntorinException pe){
            JOptionPane.showMessageDialog(this, pe.getMessage());
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       emptyObject();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void SearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBtnActionPerformed
         for (int i = 0; i <= tabela.getRowCount(); i++){
            if (tabela.getValueAt(i, 3) != null &&tabela.getValueAt(i, 3).equals(txtSearch.getText())){
                tabela.setRowSelectionInterval(i,i);
            }
        }
        txtSearch.setText("");
    }//GEN-LAST:event_SearchBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SearchBtn;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBoxGJINIA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtAdresa;
    private com.toedter.calendar.JDateChooser txtDitelindja;
    private javax.swing.JTextField txtEmri1;
    private javax.swing.JTextField txtKontakti;
    private javax.swing.JTextField txtMbiemri;
    private javax.swing.JTextField txtNRLeternjoftimit;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}