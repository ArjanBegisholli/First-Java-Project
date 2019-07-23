/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BL.RegjistroPuntorin;
import DAL.Lidhja;
import DAL.RegjistroPuntorinException;
import DAL.RegjistroPuntorinInterface;
import DAL.RegjistroPuntorinRepository;
import Model.RegjistroPuntorinTableModel;
import static DAL.MyMethods.returnTxt1;
import static DAL.MyMethods.returnTxt2;
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
public class RegjistroPuntorinForm extends javax.swing.JInternalFrame {
    Lidhja l=new Lidhja();

    RegjistroPuntorinRepository regjistroPuntorinRepository = new RegjistroPuntorinRepository();
    RegjistroPuntorinTableModel regjistroPuntorinTableModel = new RegjistroPuntorinTableModel();
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
       try{
        String s = "select * from StatusiMartesor";
      l.st = l.cn.prepareStatement(s);
       l.rs = l.st.executeQuery();
        while(l.rs.next())
        {
           jComboBox2STATUSIMARTESOR.addItem(l.rs.getString("StatusiMartesor"));
        }
        l.st.close();
         l.rs.close();
       }catch(SQLException e){
        JOptionPane.showMessageDialog(null, "ERROR te culonat");
    }           
   }

    /**
     * Creates new form RegjistroPuntorinForm
     */
    public RegjistroPuntorinForm() {
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
        jTextRroga.setText("");
        txtUserName.setText("");
        jPasswordField.setText("");
        txtNRLeternjoftimit.setText("");
        txtAdresa.setText("");
        jComboBox2STATUSIMARTESOR.setSelectedItem("");
        jComboBoxGJINIA.setSelectedItem("");
        
    }
    

    private void tabelaLoad() {
        List<RegjistroPuntorin> lista = regjistroPuntorinRepository.findAll();
        regjistroPuntorinTableModel.add(lista);
        tabela.setModel(regjistroPuntorinTableModel);
        regjistroPuntorinTableModel.fireTableDataChanged();
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
                    RegjistroPuntorin regjistroPuntorin = regjistroPuntorinTableModel.getRegjistroPuntorin(selectedIndex);
                       try {
                        jComboBoxGJINIA.setSelectedItem(returnTxt1(regjistroPuntorin.getGjiniaID(), "Gjinia"));
                    } catch (SQLException ex) {
                        Logger.getLogger(RegjistroPuntorinForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                          try {
                        jComboBox2STATUSIMARTESOR.setSelectedItem(returnTxt1(regjistroPuntorin.getStatusiMartesorID(), "StatusiMartesor"));
                    } catch (SQLException ex) {
                        Logger.getLogger(RegjistroPuntorinForm.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    txtEmri1.setText(regjistroPuntorin.getEmri());
                    txtMbiemri.setText(regjistroPuntorin.getMbiemri());
                    txtDitelindja.setDate(regjistroPuntorin.getDitelindja());
                    txtKontakti.setText(regjistroPuntorin.getKontakti() + "");
                    txtUserName.setText(regjistroPuntorin.getUserName() + "");
                    jPasswordField.setText(regjistroPuntorin.getPassword() + "");
                    jTextRroga.setText(regjistroPuntorin.getRroga() + "");
                    txtNRLeternjoftimit.setText(regjistroPuntorin.getNrLeternjoftimit() + "");
                    txtAdresa.setText(regjistroPuntorin.getAdresa()+ "");
                   
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
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        jPasswordField = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jTextRroga = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEmri1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxGJINIA = new javax.swing.JComboBox<>();
        jComboBox2STATUSIMARTESOR = new javax.swing.JComboBox<>();
        txtNRLeternjoftimit = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtAdresa = new javax.swing.JTextField();
        SearchBtn = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();

        setBackground(new java.awt.Color(194, 212, 212));
        setClosable(true);
        setMaximizable(true);
        setTitle("Regjistro Puntorin");
        setToolTipText("");
        setMinimumSize(new java.awt.Dimension(2147483647, 2147483647));
        setName(""); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel1.setText("Emri");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel2.setText("Mbiemri");

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

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel6.setText("UserName");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel7.setText("Password  ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel5.setText("Rroga");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel4.setText("Kontakti");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel8.setText("Statusi Martesor");

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
                        .addComponent(SearchBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnSave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 930, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEmri1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMbiemri, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel7)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDitelindja, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jComboBoxGJINIA, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jComboBox2STATUSIMARTESOR, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextRroga, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel4)
                                    .addComponent(txtKontakti, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNRLeternjoftimit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(230, 240, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(SearchBtn)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextRroga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtKontakti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNRLeternjoftimit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox2STATUSIMARTESOR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMbiemri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmri1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDitelindja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addGap(15, 15, 15)
                        .addComponent(jComboBoxGJINIA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    RegjistroPuntorin regjistroPuntorin = new RegjistroPuntorin();
                    regjistroPuntorin.setEmri(txtEmri1.getText());
                    regjistroPuntorin.setRroga(Float.parseFloat(jTextRroga.getText()));
                    regjistroPuntorin.setMbiemri(txtMbiemri.getText());
                    regjistroPuntorin.setDitelindja(txtDitelindja.getDate());
                    regjistroPuntorin.setKontakti(txtKontakti.getText());
                    regjistroPuntorin.setUserName(txtUserName.getText());
                    regjistroPuntorin.setPassword(jPasswordField.getText());
                    regjistroPuntorin.setAdresa(txtAdresa.getText());
                    regjistroPuntorin.setNrLeternjoftimit(txtNRLeternjoftimit.getText());
                    
                    
                      try {
                        regjistroPuntorin.setGjiniaID(returnTxt2( "Gjinia",jComboBoxGJINIA.getSelectedItem().toString()));
                    } catch (SQLException ex) {
                        Logger.getLogger(RegjistroPuntorinForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                       try {
                        regjistroPuntorin.setStatusiMartesorID(returnTxt2( "StatusiMartesor",jComboBox2STATUSIMARTESOR.getSelectedItem().toString()));
                    } catch (SQLException ex) {
                        Logger.getLogger(RegjistroPuntorinForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                     
                         
                    
                    regjistroPuntorinRepository.create(regjistroPuntorin);
                    JOptionPane.showMessageDialog(this, "E dhëna u ruajt me sukses !");
                } else {
                    RegjistroPuntorin regjistroPuntorin = this.regjistroPuntorinTableModel.getRegjistroPuntorin(row);

                    regjistroPuntorin.setEmri(txtEmri1.getText());
                    regjistroPuntorin.setMbiemri(txtMbiemri.getText());
                    regjistroPuntorin.setDitelindja(txtDitelindja.getDate());
                    regjistroPuntorin.setKontakti(txtKontakti.getText());
                    regjistroPuntorin.setRroga(Float.parseFloat(jTextRroga.getText()));
                    regjistroPuntorin.setUserName(txtUserName.getText());
                    regjistroPuntorin.setPassword(jPasswordField.getText());
                    regjistroPuntorin.setAdresa(txtAdresa.getText());
                    regjistroPuntorin.setNrLeternjoftimit(txtNRLeternjoftimit.getText());
                       try {
                        regjistroPuntorin.setGjiniaID(returnTxt2( "Gjinia",jComboBoxGJINIA.getSelectedItem().toString()));
                    } catch (SQLException ex) {
                        Logger.getLogger(RegjistroPuntorinForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                       try {
                        regjistroPuntorin.setStatusiMartesorID(returnTxt2( "StatusiMartesor",jComboBox2STATUSIMARTESOR.getSelectedItem().toString()));
                    } catch (SQLException ex) {
                        Logger.getLogger(RegjistroPuntorinForm.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    regjistroPuntorinRepository.edit(regjistroPuntorin);
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
                    RegjistroPuntorin regjistroPuntorin = this.regjistroPuntorinTableModel.getRegjistroPuntorin(row);
                    regjistroPuntorinRepository.remove(regjistroPuntorin);
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
            if (tabela.getValueAt(i, 6) != null &&tabela.getValueAt(i, 6).equals(txtSearch.getText())){
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
    private javax.swing.JComboBox<String> jComboBox2STATUSIMARTESOR;
    private javax.swing.JComboBox<String> jComboBoxGJINIA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextRroga;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtAdresa;
    private com.toedter.calendar.JDateChooser txtDitelindja;
    private javax.swing.JTextField txtEmri1;
    private javax.swing.JTextField txtKontakti;
    private javax.swing.JTextField txtMbiemri;
    private javax.swing.JTextField txtNRLeternjoftimit;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
