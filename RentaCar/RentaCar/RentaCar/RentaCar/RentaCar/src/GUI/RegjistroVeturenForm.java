/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import DAL.Lidhja;
import BL.RegjistroVeturen;
import DAL.RegjistroPuntorinException;
import DAL.RegjistroVeturenRepository;
import Model.RegjistroVeturenTableModel;
import java.util.List;
import DAL.Lidhja;
import static DAL.MyMethods.returnTxt1;
import static DAL.MyMethods.returnTxt2;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import DAL.RegjistroVeturenInterface;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arjan
 */
public class RegjistroVeturenForm extends javax.swing.JInternalFrame {
    
    Lidhja l=new Lidhja();
        
    RegjistroVeturenRepository regjistroVeturenRepository = new RegjistroVeturenRepository();
    RegjistroVeturenTableModel regjistroVeturenTableModel = new RegjistroVeturenTableModel();

   private void gjeneroCombo( ){
       
         try{
             
        String s = "select * from Furnizimi";
      l.st = l.cn.prepareStatement(s);
       l.rs = l.st.executeQuery();
        while(l.rs.next())
        {   String sos=l.rs.getString("Furnizimi");
           this.txtFurnizimi.addItem(sos);
        }
         l.st.close();
         l.rs.close();
         }catch(SQLException e){
        JOptionPane.showMessageDialog(null, "ERROR te culonat");
    }
       try{
        String s = "select * from Disponshmuria";
      l.st = l.cn.prepareStatement(s);
       l.rs = l.st.executeQuery();
        while(l.rs.next())
        {
           txtDisponshmuria.addItem(l.rs.getString("Disponshmuria"));
        }
        l.st.close();
         l.rs.close();
       }catch(SQLException e){
        JOptionPane.showMessageDialog(null, "ERROR te culonat");
    }

      
         try{
        String s = "select * from Statusi";
      l.st = l.cn.prepareStatement(s);
       l.rs = l.st.executeQuery();
        while(l.rs.next())
        {
           txtStatusi.addItem(l.rs.getString("Statusi"));
        }
          l.st.close();
         l.rs.close();
         }catch(SQLException e){
        JOptionPane.showMessageDialog(null, "ERROR te culonat");
    }
            try{
        String s = "select * from Marshi";
      l.st = l.cn.prepareStatement(s);
       l.rs = l.st.executeQuery();
        while(l.rs.next())
        {
           txtMarshi.addItem(l.rs.getString("Marshi"));
        }
             l.st.close();
         l.rs.close();
            }catch(SQLException e){
        JOptionPane.showMessageDialog(null, "ERROR te culonat");
    }
                      try{
        String s = "select * from Llojivetures";
      l.st = l.cn.prepareStatement(s);
       l.rs = l.st.executeQuery();
        while(l.rs.next())
        {
           txtLlojivetures.addItem(l.rs.getString("Llojivetures"));
        } l.st.close();
         l.rs.close();
                      }catch(SQLException e){
        JOptionPane.showMessageDialog(null, "ERROR te culonat");
    }   
           
   }
   
    /**
     * Creates new form RegjistroPuntorinForm
     */
    public RegjistroVeturenForm() {
     
        initComponents();
        tabelaLoad();
        gjeneroCombo();
    }

    public void emptyObject() {
       tabela.clearSelection();
        txtLlojivetures.setSelectedItem("");
        txtModeli.setText("");
        txtVitiProdhimit.setDate(null);
        txtKilometrazha.setText("");
         txtMarshi.setSelectedItem("");
         txtNgjyra.setText("");
         txtFurnizimi.setSelectedItem("");
         jTextCmimivetures.setText("");
         jTextRentper1dite.setText("");
         txtStatusi.setSelectedItem("");
         txtDisponshmuria.setSelectedItem("");                    
         txtStockNumber.setText("")  ;
         txtVIN.setText("");
         txtMaxWeight.setText("");
         txtPershkrimi.setText("");
        txtTargat.setText("");
    }
    

        

    private void tabelaLoad() {
        List<RegjistroVeturen> lista = regjistroVeturenRepository.findAll();
        regjistroVeturenTableModel.add(lista);
        tabela.setModel(regjistroVeturenTableModel);
        regjistroVeturenTableModel.fireTableDataChanged();
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
                   RegjistroVeturen regjistroVeturen = regjistroVeturenTableModel.getRegjistroVeturen(selectedIndex);
                                            
                        txtModeli.setText(regjistroVeturen.getModeli()+"");
                        txtVitiProdhimit.setDate(regjistroVeturen.getVitiProdhimit());
                        txtKilometrazha.setText(regjistroVeturen.getKilometrazha() + "");
                        txtNgjyra.setText(regjistroVeturen.getNgjyra()+"");
                        txtTargat.setText(regjistroVeturen.getTargat()+"");                    
                        jTextRentper1dite.setText(regjistroVeturen.getCmimiVeturespernjediteRent() + "");
                        jTextCmimivetures.setText(regjistroVeturen.getCmimiVetures() + "");                   
                        txtStockNumber.setText(regjistroVeturen.getStockNumber()+"");
                        txtVIN.setText(regjistroVeturen.getVIN()+"");
                        txtMaxWeight.setText(regjistroVeturen.getMaxWeight()+"");
                        txtPershkrimi.setText(regjistroVeturen.getPershkrimi()+"");
                     try {
                        txtLlojivetures.setSelectedItem(returnTxt1(regjistroVeturen.getLlojiveturesID(), "Llojivetures").toString()+"");
                    } catch (SQLException ex) {
                        Logger.getLogger(RegjistroVeturenForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        txtMarshi.setSelectedItem(returnTxt1(regjistroVeturen.getMarshiID(),"Marshi").toString()+"");
                    } catch (SQLException ex) {
                        Logger.getLogger(RegjistroVeturenForm.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                    try {
                        txtFurnizimi.setSelectedItem(returnTxt1(regjistroVeturen.getFurnizimiID(),"Furnizimi").toString()+"");
                    } catch (SQLException ex) {
                        Logger.getLogger(RegjistroVeturenForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        txtDisponshmuria.setSelectedItem(returnTxt1(regjistroVeturen.getDisponshmuriaID(),"Disponshmuria").toString()+"");
                    } catch (SQLException ex) {
                        Logger.getLogger(RegjistroVeturenForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        txtStatusi.setSelectedItem(returnTxt1(regjistroVeturen.getStatusiID(),"Statusi").toString()+"");
                    } catch (SQLException ex) {
                        Logger.getLogger(RegjistroVeturenForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
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
        jLabel2 = new javax.swing.JLabel();
        txtModeli = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtVitiProdhimit = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        txtKilometrazha = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtTargat = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextCmimivetures = new javax.swing.JTextField();
        jTextRentper1dite = new javax.swing.JTextField();
        txtLlojivetures = new javax.swing.JComboBox<>();
        txtFurnizimi = new javax.swing.JComboBox<>();
        txtMarshi = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtStockNumber = new javax.swing.JTextField();
        txtVIN = new javax.swing.JTextField();
        txtMaxWeight = new javax.swing.JTextField();
        txtStatusi = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        txtDisponshmuria = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtPershkrimi = new javax.swing.JTextArea();
        txtNgjyra = new javax.swing.JTextField();
        SearchBtn = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();

        setBackground(new java.awt.Color(194, 212, 212));
        setClosable(true);
        setMaximizable(true);
        setTitle("Regjistro Veturen");
        setToolTipText("");
        setMinimumSize(new java.awt.Dimension(2147483647, 2147483647));
        setName(""); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel1.setText("Lloji i Vetures");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel2.setText("Modeli");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel3.setText("Viti Prodhimit");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel4.setText("Tkaluarat (KM)");

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
        jLabel6.setText("Marshi");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel7.setText("Ngjyra");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel8.setText("Furnizimi");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel9.setText("Targa");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel10.setText("CmimiVetures ");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel11.setText("Rent per 1 dite ");

        txtLlojivetures.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtLlojivetures.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                txtLlojiveturesItemStateChanged(evt);
            }
        });
        txtLlojivetures.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLlojiveturesActionPerformed(evt);
            }
        });

        txtFurnizimi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFurnizimiActionPerformed(evt);
            }
        });

        txtMarshi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMarshiActionPerformed(evt);
            }
        });

        jLabel5.setText("Stock Number");

        jLabel12.setText("VIN");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel13.setText("Max Weight");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel14.setText("Pershkrimi");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel15.setText("Statuesi");

        txtStatusi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStatusiActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel17.setText("Disponushmeria");

        txtDisponshmuria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDisponshmuriaActionPerformed(evt);
            }
        });

        txtPershkrimi.setColumns(20);
        txtPershkrimi.setRows(5);
        jScrollPane2.setViewportView(txtPershkrimi);

        SearchBtn.setText("Search By VIN: ");
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
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtMarshi, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel10))
                                        .addGap(33, 33, 33)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(txtNgjyra, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11)))
                                    .addComponent(jTextCmimivetures, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(133, 133, 133)
                                        .addComponent(jTextRentper1dite, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(txtTargat, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtStockNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtFurnizimi, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel12))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel15)
                                            .addComponent(txtDisponshmuria, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel17)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtVIN, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtStatusi, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtLlojivetures, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(33, 33, 33)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtModeli, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                    .addGap(43, 43, 43)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtVitiProdhimit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                    .addGap(31, 31, 31)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtKilometrazha, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel13))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(525, 525, 525)
                                    .addComponent(txtMaxWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(253, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SearchBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SearchBtn)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtModeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtLlojivetures, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtVitiProdhimit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtKilometrazha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtMaxWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNgjyra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFurnizimi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtTargat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtDisponshmuria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtMarshi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel15))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtStockNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextRentper1dite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextCmimivetures, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(txtVIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtStatusi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(66, 66, 66)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        txtLlojivetures.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            int row = tabela.getSelectedRow();
            if (txtVIN.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Ju lutem Shkruani Emrin :", "Error", JOptionPane.ERROR_MESSAGE);

            } else if (txtModeli.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Ju lutem Shkruani Mbiemrin :", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                if (row == -1) {
                    RegjistroVeturen regjistroVeturen = new RegjistroVeturen();
                    
                    regjistroVeturen.setModeli(txtModeli.getText());  
                    regjistroVeturen.setVitiProdhimit(txtVitiProdhimit.getDate());
                    regjistroVeturen.setKilometrazha(Integer.parseInt(txtKilometrazha.getText()));
                    regjistroVeturen.setNgjyra(txtNgjyra.getText());                    
                    regjistroVeturen.setTargat(txtTargat.getText());
                    regjistroVeturen.setCmimiVetures(Float.parseFloat(jTextCmimivetures.getText()));
                    regjistroVeturen.setCmimiVeturespernjediteRent(Float.parseFloat(jTextRentper1dite.getText()));                   
                    regjistroVeturen.setStockNumber(Integer.parseInt(txtStockNumber.getText()));
                    regjistroVeturen.setVIN(txtVIN.getText());
                    regjistroVeturen.setMaxWeight(Float.parseFloat(txtMaxWeight.getText()));
                    regjistroVeturen.setPershkrimi(txtPershkrimi.getText());
                    
                    try {
                        regjistroVeturen.setLlojiveturesID(returnTxt2( "Llojivetures",txtLlojivetures.getSelectedItem().toString()));
                    } catch (SQLException ex) {
                        Logger.getLogger(RegjistroVeturenForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        regjistroVeturen.setMarshiID(returnTxt2("Marshi", txtMarshi.getSelectedItem().toString()));
                    } catch (SQLException ex) {
                        Logger.getLogger(RegjistroVeturenForm.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                    try {               
                        regjistroVeturen.setFurnizimiID(returnTxt2("Furnizimi", txtFurnizimi.getSelectedItem().toString()));
                    } catch (SQLException ex) {
                        Logger.getLogger(RegjistroVeturenForm.class.getName()).log(Level.SEVERE, null, ex);
                    }                                       
                    try {
                        regjistroVeturen.setDisponshmuriaID(returnTxt2("Disponshmuria", txtDisponshmuria.getSelectedItem().toString()));
                    } catch (SQLException ex) {
                        Logger.getLogger(RegjistroVeturenForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        regjistroVeturen.setStatusiID(returnTxt2("Statusi", txtStatusi.getSelectedItem().toString()));
                    } catch (SQLException ex) {
                        Logger.getLogger(RegjistroVeturenForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                  
                   
                    regjistroVeturenRepository.create(regjistroVeturen);
                    JOptionPane.showMessageDialog(this, "E dhëna u ruajt me sukses !");
                } else {               
                    RegjistroVeturen regjistroVeturen = this.regjistroVeturenTableModel.getRegjistroVeturen(row);
                 
                    regjistroVeturen.setModeli(txtModeli.getText()); 
                    regjistroVeturen.setVitiProdhimit(txtVitiProdhimit.getDate());
                    regjistroVeturen.setKilometrazha(Integer.parseInt(txtKilometrazha.getText()));
                    regjistroVeturen.setNgjyra(txtNgjyra.getText());                   
                    regjistroVeturen.setTargat(txtTargat.getText());                   
                    regjistroVeturen.setCmimiVetures(Float.parseFloat(jTextCmimivetures.getText()));
                    regjistroVeturen.setCmimiVeturespernjediteRent(Float.parseFloat(jTextRentper1dite.getText()));                    
                    regjistroVeturen.setStockNumber(Integer.parseInt(txtStockNumber.getText()));
                    regjistroVeturen.setVIN(txtVIN.getText());
                    regjistroVeturen.setMaxWeight(Float.parseFloat(txtMaxWeight.getText()));
                    regjistroVeturen.setPershkrimi(txtPershkrimi.getText());
                    
                     try {
                        regjistroVeturen.setLlojiveturesID(returnTxt2("Llojivetures", txtLlojivetures.getSelectedItem().toString()));
                    } catch (SQLException ex) {
                        Logger.getLogger(RegjistroVeturenForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                     try {                        
                        regjistroVeturen.setMarshiID(returnTxt2("Marshi", txtMarshi.getSelectedItem().toString()));
                    } catch (SQLException ex) {
                        Logger.getLogger(RegjistroVeturenForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                  
                     try {
                        regjistroVeturen.setFurnizimiID(returnTxt2("Furnizimi", txtFurnizimi.getSelectedItem().toString()));
                    } catch (SQLException ex) {
                        Logger.getLogger(RegjistroVeturenForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                     try {
                        regjistroVeturen.setDisponshmuriaID(returnTxt2("Disponshmuria", txtDisponshmuria.getSelectedItem().toString()));
                    } catch (SQLException ex) {
                        Logger.getLogger(RegjistroVeturenForm.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                  
                     try {
                        regjistroVeturen.setStatusiID(returnTxt2("Statusi", txtStatusi.getSelectedItem().toString()));
                    } catch (SQLException ex) {
                        Logger.getLogger(RegjistroVeturenForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    regjistroVeturenRepository.edit(regjistroVeturen);
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
                    RegjistroVeturen regjistroVeturen = this.regjistroVeturenTableModel.getRegjistroVeturen(row);
                    regjistroVeturenRepository.remove(regjistroVeturen);
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

    private void txtDisponshmuriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDisponshmuriaActionPerformed

    }//GEN-LAST:event_txtDisponshmuriaActionPerformed

    private void txtLlojiveturesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLlojiveturesActionPerformed
  
    }//GEN-LAST:event_txtLlojiveturesActionPerformed

    private void txtMarshiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMarshiActionPerformed

    }//GEN-LAST:event_txtMarshiActionPerformed

    private void txtFurnizimiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFurnizimiActionPerformed

    }//GEN-LAST:event_txtFurnizimiActionPerformed

    private void txtStatusiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStatusiActionPerformed

    }//GEN-LAST:event_txtStatusiActionPerformed

    private void txtLlojiveturesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_txtLlojiveturesItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLlojiveturesItemStateChanged

    private void SearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBtnActionPerformed
        for (int i = 0; i <= tabela.getRowCount(); i++){
           if (tabela.getValueAt(i, 14) != null &&tabela.getValueAt(i, 14).equals(txtSearch.getText())){
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextCmimivetures;
    private javax.swing.JTextField jTextRentper1dite;
    private javax.swing.JTable tabela;
    private javax.swing.JComboBox<String> txtDisponshmuria;
    private javax.swing.JComboBox<String> txtFurnizimi;
    private javax.swing.JTextField txtKilometrazha;
    private javax.swing.JComboBox<String> txtLlojivetures;
    private javax.swing.JComboBox<String> txtMarshi;
    private javax.swing.JTextField txtMaxWeight;
    private javax.swing.JTextField txtModeli;
    private javax.swing.JTextField txtNgjyra;
    private javax.swing.JTextArea txtPershkrimi;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JComboBox<String> txtStatusi;
    private javax.swing.JTextField txtStockNumber;
    private javax.swing.JTextField txtTargat;
    private javax.swing.JTextField txtVIN;
    private com.toedter.calendar.JDateChooser txtVitiProdhimit;
    // End of variables declaration//GEN-END:variables
}
