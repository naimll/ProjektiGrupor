/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.View;

import BLL.HuazimiLibrit;
import BLL.Klienti;
import BLL.Libri;
import DAL.HuazimiRepository;
import DAL.KlientiRepository;
import DAL.LibraryException;
import DAL.LibriRepository;
import GUI.Model.HuazimiLibritTableModel;
import GUI.Model.KlientiComboBoxModel;
import GUI.Model.LibriComboBoxModel;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Lenovo
 */
public class RegisterHuazimiLibrave1GUI extends javax.swing.JFrame {

    /**
     * Creates new form RegisterHuazimiLibrave1GUI
     */
    
    HuazimiRepository huazimiRepository = new HuazimiRepository();
    HuazimiLibritTableModel huazimiLibritTableModel = new HuazimiLibritTableModel();
    KlientiRepository klientiRepository = new KlientiRepository();
    LibriRepository libriRepository = new LibriRepository();
    LibriComboBoxModel libriComboBoxModel = new LibriComboBoxModel();
    
    KlientiComboBoxModel klientiComboBoxModel = new KlientiComboBoxModel();
    
    public RegisterHuazimiLibrave1GUI() {
        initComponents();
        loadComboBoxKlientet();
        loadTableHuazimi();
	tabelaSelectedIndexChange();
        loadComboBoxLibrat();
        this.SetToFinished.setVisible(false);
        centreWindow(this);
    }
    
        public static void centreWindow(Window frame) {
    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
    frame.setLocation(x, y);
}
    
    public void loadComboBoxKlientet(){
        try{
            List<Klienti> lista = klientiRepository.findAll();
            klientiComboBoxModel.add(lista);
            klientetCmb.setModel(klientiComboBoxModel);
            klientetCmb.repaint();
            
        } catch (LibraryException ex) {
            Logger.getLogger(RegisterHuazimiLibrave1GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void loadComboBoxLibrat(){
        try{
            List<Libri> lista = libriRepository.findAll();
            libriComboBoxModel.add(lista);            
            libricmb.setModel(libriComboBoxModel);
            libricmb.repaint();
            
        } catch (LibraryException ex) {
            Logger.getLogger(RegisterHuazimiLibrave1GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void loadTableHuazimi(){
        try {
            List<HuazimiLibrit> lista = huazimiRepository.findAll();
            huazimiLibritTableModel.addList(lista);
            table.setModel(huazimiLibritTableModel);
            huazimiLibritTableModel.fireTableDataChanged();
        } catch (LibraryException ex) {
            Logger.getLogger(RegisterHuazimiLibrave1GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TitelPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        AddClientPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        PublishingYearLabel = new javax.swing.JLabel();
        QuantityLabel = new javax.swing.JLabel();
        AddClientButton = new javax.swing.JButton();
        DeleteClientButton = new javax.swing.JButton();
        AuthorLabel = new javax.swing.JLabel();
        NrAuthorsLabel = new javax.swing.JLabel();
        CancelButton = new javax.swing.JButton();
        klientetCmb = new javax.swing.JComboBox();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        libricmb = new javax.swing.JComboBox();
        SetToFinished = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        Search = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1328, 770));

        TitelPanel.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Register the book borrowing");

        jButton1.setBackground(new java.awt.Color(255, 51, 51));
        jButton1.setText("Exit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TitelPanelLayout = new javax.swing.GroupLayout(TitelPanel);
        TitelPanel.setLayout(TitelPanelLayout);
        TitelPanelLayout.setHorizontalGroup(
            TitelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TitelPanelLayout.createSequentialGroup()
                .addContainerGap(557, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(430, 430, 430))
            .addGroup(TitelPanelLayout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        TitelPanelLayout.setVerticalGroup(
            TitelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TitelPanelLayout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(40, 40, 40))
        );

        AddClientPanel.setBackground(new java.awt.Color(204, 204, 204));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        PublishingYearLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PublishingYearLabel.setText("Client");

        QuantityLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        QuantityLabel.setText("Book");

        AddClientButton.setBackground(new java.awt.Color(51, 255, 51));
        AddClientButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        AddClientButton.setText("Save");
        AddClientButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddClientButtonMouseClicked(evt);
            }
        });
        AddClientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddClientButtonActionPerformed(evt);
            }
        });

        DeleteClientButton.setBackground(new java.awt.Color(255, 51, 102));
        DeleteClientButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        DeleteClientButton.setText("Delete");
        DeleteClientButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteClientButtonMouseClicked(evt);
            }
        });
        DeleteClientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteClientButtonActionPerformed(evt);
            }
        });

        AuthorLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        AuthorLabel.setText("Receipt Date");

        NrAuthorsLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        NrAuthorsLabel.setText("Borrowing Date");

        CancelButton.setBackground(new java.awt.Color(0, 153, 255));
        CancelButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        CancelButton.setText("Cancel");
        CancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CancelButtonMouseClicked(evt);
            }
        });
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        klientetCmb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        libricmb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        SetToFinished.setBackground(new java.awt.Color(0, 255, 204));
        SetToFinished.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        SetToFinished.setText("Set to Finished");
        SetToFinished.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SetToFinishedMouseClicked(evt);
            }
        });
        SetToFinished.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SetToFinishedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AuthorLabel)
                            .addComponent(PublishingYearLabel)
                            .addComponent(QuantityLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(klientetCmb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(libricmb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(NrAuthorsLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(AddClientButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(CancelButton)
                        .addGap(52, 52, 52)
                        .addComponent(DeleteClientButton)
                        .addGap(0, 61, Short.MAX_VALUE))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(SetToFinished)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(klientetCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PublishingYearLabel))
                .addGap(64, 64, 64)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(libricmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(QuantityLabel))
                .addGap(75, 75, 75)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(NrAuthorsLabel)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AuthorLabel)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddClientButton)
                    .addComponent(CancelButton)
                    .addComponent(DeleteClientButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(SetToFinished)
                .addGap(33, 33, 33))
        );

        table.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout AddClientPanelLayout = new javax.swing.GroupLayout(AddClientPanel);
        AddClientPanel.setLayout(AddClientPanelLayout);
        AddClientPanelLayout.setHorizontalGroup(
            AddClientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddClientPanelLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 795, Short.MAX_VALUE))
        );
        AddClientPanelLayout.setVerticalGroup(
            AddClientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddClientPanelLayout.createSequentialGroup()
                .addGap(0, 29, Short.MAX_VALUE)
                .addGroup(AddClientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });
        Search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel2.setText("Search");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TitelPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Search, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(414, 414, 414))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(17, Short.MAX_VALUE)
                    .addComponent(AddClientPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(17, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TitelPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(519, 519, 519))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 118, Short.MAX_VALUE)
                    .addComponent(AddClientPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddClientButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddClientButtonMouseClicked
  
    }//GEN-LAST:event_AddClientButtonMouseClicked

    private void AddClientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddClientButtonActionPerformed
        
            try{
                int row = table.getSelectedRow();
                if(row == -1){
                    HuazimiLibrit p = new HuazimiLibrit();
                    p.setHLKlientiId((Klienti)klientetCmb.getSelectedItem());
                    p.setHlIsbn((Libri)libricmb.getSelectedItem());
                    p.setHLDataLeshimit(jDateChooser1.getDate());
                    p.setHLDataKthimit(jDateChooser2.getDate());
                    
                    Libri l = p.getHlIsbn();
                    
                    int sasia = l.getLSasia() ;
                    if(sasia == 0){
                        JOptionPane.showMessageDialog(this, "Nuk ka me libra ne stock");
                        return ;
                    }
                     sasia -= 1;
                    LibriRepository lrepo = new LibriRepository();
                    l.setLSasia(sasia);
               
                    huazimiRepository.create(p);
                    lrepo.edit(l);

                }else{
                     HuazimiLibrit p = this.huazimiLibritTableModel.getHuazimiLibrit(row);
                    p.setHLKlientiId((Klienti)klientetCmb.getSelectedItem());
                    p.setHlIsbn((Libri)libricmb.getSelectedItem());
                    p.setHLDataLeshimit(jDateChooser1.getDate());
                    p.setHLDataKthimit(jDateChooser2.getDate());

                    huazimiRepository.edit(p);
                }
                this.clear();
                this.loadTableHuazimi();
                
            } catch (LibraryException ex) {
            JOptionPane.showMessageDialog(this, "Plotsoni fushat!");
        }

                clear();
                loadTableHuazimi();
           
        
            
            
            
      
    }//GEN-LAST:event_AddClientButtonActionPerformed

    private void DeleteClientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteClientButtonActionPerformed
        try{
            int row = table.getSelectedRow();
            if(row != -1){
                Object[] ob = {"Yes","No"} ;
                int i = JOptionPane.showOptionDialog(this,"Would you like to delete the selected object ?","Delete", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
                if(i == 0){
                HuazimiLibrit hl = huazimiLibritTableModel.getHuazimiLibrit(row);
                
                    if(hl.getIsActive() == 0){       
                        huazimiRepository.delete(hl);
                    }
                
                else{
                   throw new LibraryException("Please first set it to finished,(Active= 'No')"); 
                }
                    }

            }
            else{
                throw new LibraryException("Please select one from the table");
            
            }
            this.clear();
            this.loadTableHuazimi();
        }
        catch (LibraryException ex){
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_DeleteClientButtonActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        this.table.clearSelection();
        this.clear();
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchActionPerformed

    private void SearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchKeyReleased
        HuazimiLibritTableModel model = (HuazimiLibritTableModel) this.table.getModel();
        String search = this.Search.getText();//.toLowerCase();
        TableRowSorter<HuazimiLibritTableModel> tr = new TableRowSorter<HuazimiLibritTableModel>(model);
        table.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_SearchKeyReleased

            private void tabelaSelectedIndexChange(){
        final ListSelectionModel rowSM = table.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener(){

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(e.getValueIsAdjusting()){
                    return;
                }
                
                ListSelectionModel rowSM = (ListSelectionModel) e.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();
                if(selectedIndex > -1){
                    HuazimiLibrit p = huazimiLibritTableModel.getHuazimiLibrit(selectedIndex);
                    
                    if(p.getIsActive() == 1){
                        SetToFinished.setVisible(true);
                    }else{
                        SetToFinished.setVisible(false);
                    }
                    
                   klientetCmb.getModel().setSelectedItem(p.getHLKlientiId());
                   klientetCmb.repaint();
                   libricmb.getModel().setSelectedItem(p.getHlIsbn());
                   libricmb.repaint();
                   
                   jDateChooser1.setDate(p.getHLDataLeshimit());
                   
                    jDateChooser2.setDate(p.getHLDataKthimit());
                }
            }
        });
        }
    private void DeleteClientButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteClientButtonMouseClicked

    }//GEN-LAST:event_DeleteClientButtonMouseClicked

    private void CancelButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelButtonMouseClicked

    }//GEN-LAST:event_CancelButtonMouseClicked

    private void SetToFinishedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SetToFinishedMouseClicked

    }//GEN-LAST:event_SetToFinishedMouseClicked

    private void SetToFinishedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SetToFinishedActionPerformed
            try{
                int row = table.getSelectedRow();
                    if(row == -1){
                        throw new LibraryException ("Please select one from the table");
                }else{
                    HuazimiLibrit p = this.huazimiLibritTableModel.getHuazimiLibrit(row);
                    p.setIsActive(0);
                    
                    Libri l = p.getHlIsbn() ;
                    int sasialibrit = l.getLSasia() + 1 ;
                    l.setLSasia(sasialibrit);
                    
                    this.huazimiRepository.edit(p);
                    this.libriRepository.edit(l);
                    this.clear();
                    this.loadTableHuazimi();
                    }
                  
                }catch(LibraryException ex){
                JOptionPane.showMessageDialog(this, ex.getMessage());
                }
    }//GEN-LAST:event_SetToFinishedActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

        public void clear(){
            
            libricmb.setSelectedIndex(-1);
            libricmb.repaint();
            klientetCmb.setSelectedIndex(-1);
            klientetCmb.repaint();
            jDateChooser1.setDate(null);
            jDateChooser2.setDate(null);
            SetToFinished.setVisible(false);
        }    
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
            java.util.logging.Logger.getLogger(RegisterHuazimiLibrave1GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterHuazimiLibrave1GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterHuazimiLibrave1GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterHuazimiLibrave1GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterHuazimiLibrave1GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddClientButton;
    private javax.swing.JPanel AddClientPanel;
    private javax.swing.JLabel AuthorLabel;
    private javax.swing.JButton CancelButton;
    private javax.swing.JButton DeleteClientButton;
    private javax.swing.JLabel NrAuthorsLabel;
    private javax.swing.JLabel PublishingYearLabel;
    private javax.swing.JLabel QuantityLabel;
    private javax.swing.JTextField Search;
    private javax.swing.JButton SetToFinished;
    private javax.swing.JPanel TitelPanel;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox klientetCmb;
    private javax.swing.JComboBox libricmb;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
