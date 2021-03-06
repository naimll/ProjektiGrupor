/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.View;

import BLL.Autori;
import BLL.KategoriaLibrit;
import BLL.Libri;
import DAL.AutoriRepository;

import DAL.CrudFormException;
import DAL.EntMngClass;
import DAL.KategoriaLibritRepository;
import DAL.LibraryException;
import DAL.LibriRepository;
import GUI.Model.AuthorComboBoxModel;
import GUI.Model.BookTableModel;
import GUI.Model.CategoryComboBoxModel;
import com.sun.glass.events.KeyEvent;
import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import static java.time.Clock.system;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Lenovo
 */
public class RegisterBookGUI extends javax.swing.JFrame {

    KategoriaLibritRepository klrepo = new KategoriaLibritRepository();
    CategoryComboBoxModel ccbox = new CategoryComboBoxModel();
    
   AutoriRepository arepo = new AutoriRepository();
    AuthorComboBoxModel acbox = new AuthorComboBoxModel();
    
    LibriRepository lrepo = new LibriRepository();
    BookTableModel btm = new BookTableModel();
    /**
     * Creates new form RegisterBookGUI
     */
    public RegisterBookGUI() {
         initComponents();
         loadCategoryComboBox();
         this.tableSelectedIndexChange();
         loadAuthorComboBox();
         loadBookTable();
         this.IsbnTextField.setEnabled(true);
         centreWindow(this);
         
    }
    

        public static void centreWindow(Window frame) {
    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
    frame.setLocation(x, y);
}
    
    

    
    public void tableSelectedIndexChange(){
         final ListSelectionModel rowSM = table.getSelectionModel();
         rowSM.addListSelectionListener(new ListSelectionListener(){
             
             @Override
             public void valueChanged(ListSelectionEvent e) {
                    if(e.getValueIsAdjusting()){
                    return;             }
                    ListSelectionModel rowSM = (ListSelectionModel) e.getSource();
                    int selectedIndex = rowSM.getAnchorSelectionIndex();
                    if(selectedIndex > -1){
                    Libri l = btm.getLibri(selectedIndex);
                    TitleTextField.setText(l.getLTitulli().toString());
                    PublisherTextField.setText(l.getLShtepiaBotuese().toString());
                    PublishigYearDate.setYear(l.getLVitiBotimit());                
                    CategoryComboBox.setSelectedItem(l.getLKategoriaId());
                    CategoryComboBox.repaint();
                    AuthorComboBox.setSelectedItem(l.getAutoriId());
                    AuthorComboBox.repaint();
                    QuantityTextField.setText(Integer.toString(l.getLSasia()));
                    PriceTextField.setText(Double.toString(l.getLCmimiMujor()));
                    IsbnTextField.setText(l.getIsbn());
                    IsbnTextField.setEnabled(false);
                        
                }
            }
         });

    }
    
    public void clear(){
        this.TitleTextField.setText("");
        this.PublisherTextField.setText("");
        this.PublishigYearDate.setYear(2020);
        this.QuantityTextField.setText("");
        this.CategoryComboBox.setSelectedIndex(-1);
        this.CategoryComboBox.repaint();
        this.AuthorComboBox.setSelectedIndex(-1); 
        this.AuthorComboBox.repaint();
        this.IsbnTextField.setText("");
        this.PriceTextField.setText("");
        this.IsbnTextField.setEnabled(true);
        
        
    }
    
    

    
    
        public void loadBookTable(){
        
        try{
            List<Libri> lista = lrepo.findAll();
            btm.addList(lista);
            table.setModel(btm);
            btm.fireTableDataChanged();
        }catch(LibraryException ex){
           
           java.util.logging.Logger.getLogger(RegisterBookGUI.class.getName()).log(Level.SEVERE,null,ex);

        }
            
        }
                

        public void loadCategoryComboBox(){
            try{
            List<KategoriaLibrit> lista = klrepo.findAll();
            ccbox.add(lista);
            CategoryComboBox.setModel(ccbox);
            CategoryComboBox.repaint();
            } catch (LibraryException ex) {
            Logger.getLogger(RegisterBookGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
        public void loadAuthorComboBox(){
            try{
            List<Autori> lista = arepo.findAll();
            
            
            
            acbox.add(lista);
            AuthorComboBox.setModel(acbox);
            AuthorComboBox.repaint();
            }catch(LibraryException ex){
                Logger.getLogger(RegisterBookGUI.class.getName()).log(Level.SEVERE, null, ex);
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
        TitleLabel = new javax.swing.JLabel();
        TitleTextField = new javax.swing.JTextField();
        PublisherLabel = new javax.swing.JLabel();
        PublisherTextField = new javax.swing.JTextField();
        PublishingYearLabel = new javax.swing.JLabel();
        PriceLabel = new javax.swing.JLabel();
        QuantityTextField = new javax.swing.JTextField();
        CategoryLabel = new javax.swing.JLabel();
        QuantityLabel = new javax.swing.JLabel();
        AddClientButton = new javax.swing.JButton();
        DeleteClientButton = new javax.swing.JButton();
        PriceTextField = new javax.swing.JTextField();
        AuthorLabel = new javax.swing.JLabel();
        AuthorComboBox = new javax.swing.JComboBox<>();
        CategoryComboBox = new javax.swing.JComboBox<>();
        IsbnTextField = new javax.swing.JTextField();
        IsbnLabel = new javax.swing.JLabel();
        PublishigYearDate = new com.toedter.calendar.JYearChooser();
        CancelButton = new javax.swing.JButton();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        Search = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1200, 800));
        setMinimumSize(new java.awt.Dimension(1200, 800));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1200, 800));
        setResizable(false);

        TitelPanel.setBackground(new java.awt.Color(153, 153, 153));
        TitelPanel.setMaximumSize(new java.awt.Dimension(800, 100));
        TitelPanel.setMinimumSize(new java.awt.Dimension(800, 100));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Register Book");

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
            .addGroup(TitelPanelLayout.createSequentialGroup()
                .addGap(479, 479, 479)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(TitelPanelLayout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        TitelPanelLayout.setVerticalGroup(
            TitelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TitelPanelLayout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        AddClientPanel.setBackground(new java.awt.Color(204, 204, 204));
        AddClientPanel.setMaximumSize(new java.awt.Dimension(800, 500));
        AddClientPanel.setMinimumSize(new java.awt.Dimension(800, 500));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        TitleLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TitleLabel.setText("Title");

        TitleTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TitleTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TitleTextFieldActionPerformed(evt);
            }
        });

        PublisherLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PublisherLabel.setText("Publisher");

        PublisherTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PublisherTextField.setMaximumSize(new java.awt.Dimension(150, 28));
        PublisherTextField.setMinimumSize(new java.awt.Dimension(150, 28));
        PublisherTextField.setPreferredSize(new java.awt.Dimension(150, 28));
        PublisherTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PublisherTextFieldActionPerformed(evt);
            }
        });

        PublishingYearLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PublishingYearLabel.setText("Publishing year");

        PriceLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PriceLabel.setText("Price");

        QuantityTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        QuantityTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuantityTextFieldActionPerformed(evt);
            }
        });
        QuantityTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                QuantityTextFieldKeyPressed(evt);
            }
        });

        CategoryLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        CategoryLabel.setText("Category");

        QuantityLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        QuantityLabel.setText("Quantity");

        AddClientButton.setBackground(new java.awt.Color(51, 255, 51));
        AddClientButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        AddClientButton.setText("Save");
        AddClientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddClientButtonActionPerformed(evt);
            }
        });

        DeleteClientButton.setBackground(new java.awt.Color(255, 51, 102));
        DeleteClientButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        DeleteClientButton.setText("Delete");
        DeleteClientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteClientButtonActionPerformed(evt);
            }
        });

        PriceTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PriceTextField.setMaximumSize(new java.awt.Dimension(150, 28));
        PriceTextField.setMinimumSize(new java.awt.Dimension(150, 28));
        PriceTextField.setPreferredSize(new java.awt.Dimension(150, 28));
        PriceTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PriceTextFieldActionPerformed(evt);
            }
        });
        PriceTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PriceTextFieldKeyPressed(evt);
            }
        });

        AuthorLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        AuthorLabel.setText("Author 1");

        AuthorComboBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        CategoryComboBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        CategoryComboBox.setMaximumSize(new java.awt.Dimension(150, 28));
        CategoryComboBox.setMinimumSize(new java.awt.Dimension(150, 28));
        CategoryComboBox.setPreferredSize(new java.awt.Dimension(150, 28));
        CategoryComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategoryComboBoxActionPerformed(evt);
            }
        });

        IsbnTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        IsbnTextField.setMaximumSize(new java.awt.Dimension(150, 28));
        IsbnTextField.setMinimumSize(new java.awt.Dimension(150, 28));
        IsbnTextField.setPreferredSize(new java.awt.Dimension(150, 28));
        IsbnTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IsbnTextFieldActionPerformed(evt);
            }
        });
        IsbnTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                IsbnTextFieldKeyPressed(evt);
            }
        });

        IsbnLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        IsbnLabel.setText("Isbn");

        CancelButton.setBackground(new java.awt.Color(0, 153, 255));
        CancelButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        CancelButton.setText("Cancel");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(AuthorLabel)
                        .addGap(101, 101, 101)
                        .addComponent(AuthorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(QuantityLabel)
                            .addComponent(PublishingYearLabel)
                            .addComponent(TitleLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(QuantityTextField)
                            .addComponent(TitleTextField)
                            .addComponent(PublishigYearDate, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(CancelButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AddClientButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PublisherLabel)
                            .addComponent(CategoryLabel)
                            .addComponent(PriceLabel)
                            .addComponent(IsbnLabel))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PublisherTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PriceTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CategoryComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(IsbnTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(DeleteClientButton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TitleLabel)
                    .addComponent(TitleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PublisherLabel)
                    .addComponent(PublisherTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CategoryLabel)
                        .addComponent(CategoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PublishigYearDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PublishingYearLabel))
                .addGap(42, 42, 42)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(QuantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PriceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(QuantityLabel))
                .addGap(42, 42, 42)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(AuthorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(AuthorLabel))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(IsbnLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(IsbnTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CancelButton)
                    .addComponent(DeleteClientButton)
                    .addComponent(AddClientButton))
                .addGap(124, 124, 124))
        );

        table.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane1.setViewportView(table);

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

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel2.setText("Search");

        javax.swing.GroupLayout AddClientPanelLayout = new javax.swing.GroupLayout(AddClientPanel);
        AddClientPanel.setLayout(AddClientPanelLayout);
        AddClientPanelLayout.setHorizontalGroup(
            AddClientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddClientPanelLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(AddClientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddClientPanelLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(193, 193, 193))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddClientPanelLayout.createSequentialGroup()
                        .addGroup(AddClientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Search)
                            .addComponent(jScrollPane1))
                        .addContainerGap())))
        );
        AddClientPanelLayout.setVerticalGroup(
            AddClientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddClientPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(AddClientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(AddClientPanelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AddClientPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(TitelPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TitelPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(AddClientPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TitleTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TitleTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TitleTextFieldActionPerformed

    private void PublisherTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PublisherTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PublisherTextFieldActionPerformed

    private void QuantityTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuantityTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_QuantityTextFieldActionPerformed

    private void AddClientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddClientButtonActionPerformed
     try{
            int row = table.getSelectedRow();
            if(row == -1){
              Libri l = new Libri();
              if(TitleTextField.getText().equals("")|| TitleTextField.getText().equals(null) || TitleTextField.getText().length() < 3){
                  throw new LibraryException("Title should not be null or shorter than 3");
              }
              l.setLTitulli(TitleTextField.getText());
              
              if(PublisherTextField.getText().equals("") || PublisherTextField.getText().equals(null) || PublisherTextField.getText().length() < 3){
                  throw new LibraryException("Publisher should not be null or shorter than 3");
              }              
              l.setLShtepiaBotuese(PublisherTextField.getText());
              
              Date date = new Date();
              int thisyear = date.getYear() + 1900 ;
              int chosenyear = PublishigYearDate.getValue();
              
              
              if(thisyear < chosenyear){
                  throw new LibraryException("Please choose a correct publishing year");
              }
              l.setLVitiBotimit(PublishigYearDate.getValue());
              
              if(CategoryComboBox.getSelectedItem() == null){
                  throw new LibraryException("Please select a category");
              }
              l.setLKategoriaId((KategoriaLibrit) CategoryComboBox.getSelectedItem());
              
              if(AuthorComboBox.getSelectedItem() == null){
                  throw new LibraryException("Please select an author");
              }              
              l.setAutoriId((Autori) this.AuthorComboBox.getSelectedItem());
              
              if(QuantityTextField.getText().equals("") || QuantityTextField.getText().equals(null) || QuantityTextField.getText().length() < 1 || Integer.parseInt(QuantityTextField.getText()) < 1){
                  throw new LibraryException("Quantity should not be null or lower than 1");
              }
              l.setLSasia(Integer.parseInt(QuantityTextField.getText()));
              
              if(PriceTextField.getText().equals("") || PriceTextField.getText().equals(null) || PriceTextField.getText().length() < 0 || Double.parseDouble(PriceTextField.getText()) < 0){
                  throw new LibraryException("Price should not be null or lower than 0");                  
              }
              l.setLCmimiMujor(Double.parseDouble(PriceTextField.getText()));
              
              if(IsbnTextField.getText().equals("") || IsbnTextField.getText().equals(null) || (IsbnTextField.getText().length()== 10 || IsbnTextField.getText().length() == 13)){
                  throw new LibraryException("Isbn should not be null, and should contain 10 or 13 digits");
              }
              l.setIsbn(IsbnTextField.getText());
              //l.setLStafiId();
              KategoriaLibrit kl = l.getLKategoriaId() ;
              int sasia = Integer.parseInt(kl.getKLSasia()) + 1 ;
              kl.setKLSasia(Integer.toString(sasia));
              KategoriaLibritRepository krepo = new KategoriaLibritRepository();
              krepo.edit(kl);               
              lrepo.create(l);
            }else{
                Libri l = btm.getLibri(row);
               
              if(TitleTextField.getText().equals("") || TitleTextField.getText().equals(null) || TitleTextField.getText().length() < 3){
                  throw new LibraryException("Title should not be null or shorter than 3");
              }
              l.setLTitulli(TitleTextField.getText());
              
              if(PublisherTextField.getText().equals("") || PublisherTextField.getText().equals(null) || PublisherTextField.getText().length() < 3){
                  throw new LibraryException("Publisher should not be null or shorter than 3");
              }              
              l.setLShtepiaBotuese(PublisherTextField.getText());
              
              Date date = new Date();
              int thisyear = date.getYear() + 1900 ;
              int chosenyear = PublishigYearDate.getValue();
              
              
              if(thisyear < chosenyear){
                  throw new LibraryException("Please choose a correct publishing year");
              }
              l.setLVitiBotimit(PublishigYearDate.getValue());
              
              if(CategoryComboBox.getSelectedItem() == null){
                  throw new LibraryException("Please select a category");
              }
              l.setLKategoriaId((KategoriaLibrit) CategoryComboBox.getSelectedItem());
              
              if(AuthorComboBox.getSelectedItem() == null){
                  throw new LibraryException("Please select an author");
              }              
              l.setAutoriId((Autori) this.AuthorComboBox.getSelectedItem());
              
              if(QuantityTextField.getText().equals("") || QuantityTextField.getText().equals(null) || QuantityTextField.getText().length() < 1 || Integer.parseInt(QuantityTextField.getText()) < 1){
                  throw new LibraryException("Quantity should not be null or lower than 1");
              }
              l.setLSasia(Integer.parseInt(QuantityTextField.getText()));
              
              if(PriceTextField.getText().equals("") || PriceTextField.getText().equals(null) || PriceTextField.getText().length() < 0 || Double.parseDouble(PriceTextField.getText()) < 0){
                  throw new LibraryException("Price should not be null or lower than 0");                  
              }
              l.setLCmimiMujor(Double.parseDouble(PriceTextField.getText()));
              
              if(IsbnTextField.getText().equals("") || IsbnTextField.getText().equals(null) || (IsbnTextField.getText().length()== 10 || IsbnTextField.getText().length() == 13)){
                  throw new LibraryException("Isbn should not be null, and should contain 10 or 13 digits");
              }
              l.setIsbn(IsbnTextField.getText());
              
              lrepo.edit(l);
                
                
            }
            //E krijojm ni metode per me i clear fieldat mbasi ti shtojme
            clear();
            this.loadBookTable();
     }catch(LibraryException ex){
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
     
     
    }//GEN-LAST:event_AddClientButtonActionPerformed

    private void PriceTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PriceTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PriceTextFieldActionPerformed

    private void CategoryComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategoryComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CategoryComboBoxActionPerformed

    private void IsbnTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IsbnTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IsbnTextFieldActionPerformed

    private void DeleteClientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteClientButtonActionPerformed
                try{
                    int row = table.getSelectedRow();
                    if(row != -1){
                        Object[] ob = {"Yes","No"} ;
                        int i = JOptionPane.showOptionDialog(this,"Would you like to delete the selected object ?","Delete", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
                        if(i == 0){                    
                        Libri l = btm.getLibri(row);
                        KategoriaLibrit k = l.getLKategoriaId();
                            try{
                                lrepo.delete(l);
                                int sasia = Integer.parseInt(k.getKLSasia()) - 1;
                                k.setKLSasia(Integer.toString(sasia));
                                KategoriaLibritRepository krepo = new KategoriaLibritRepository();
                                krepo.edit(k);
                            }catch(LibraryException ex){
                                JOptionPane.showMessageDialog(this,"Book can not be deleted because it is borrowed");
                            }

                        }
                    }
                    else
                        throw new LibraryException("Please select a book from the table");
            this.clear();
            this.loadBookTable();
        }   
        catch (Exception ex){
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
        
        BookTableModel model =  (BookTableModel) this.table.getModel();
        String search = this.Search.getText();//.toLowerCase();
        TableRowSorter<BookTableModel> tr = new TableRowSorter<BookTableModel>(model);
        table.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
        
        /* try{
                
                String search = this.Search.getText();//.toLowerCase();         
                List<Libri> lista = lrepo.findLikeName(search);           
                this.btm.addList(lista);
                table.setModel(btm);
                btm.fireTableDataChanged();
            }catch(Exception e){             
                 //throw new LibraryException(e.getMessage()); 
                             Logger.getLogger(RegisterBookGUI.class.getName()).log(Level.SEVERE, null, e);

         }
       */
    }//GEN-LAST:event_SearchKeyReleased

    private void QuantityTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_QuantityTextFieldKeyPressed
         //KEY TYPE FOR QUANTITY
        try{ char c = evt.getKeyChar();
       if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACKSPACE) || c==KeyEvent.VK_DELETE || c==KeyEvent.VK_SPACE)) {
           getToolkit().beep();
          evt.consume();
          throw new LibraryException("Type quantity as integer");
       }}catch (LibraryException ex){
           
       JOptionPane.showMessageDialog(this, ex.getMessage());
       this.QuantityTextField.setText("");
       }    }//GEN-LAST:event_QuantityTextFieldKeyPressed

    private void PriceTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PriceTextFieldKeyPressed
        //KEY TYPE FOR Price
        try{ char c = evt.getKeyChar();
       if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACKSPACE) || c==KeyEvent.VK_DELETE || c==KeyEvent.VK_SPACE)) {
           getToolkit().beep();
          evt.consume();
          throw new LibraryException("Type Price as double");
       }}catch (LibraryException ex){
           
       JOptionPane.showMessageDialog(this, ex.getMessage());
       this.PriceTextField.setText("");
       }
    }//GEN-LAST:event_PriceTextFieldKeyPressed

    private void IsbnTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IsbnTextFieldKeyPressed
        //KEY TYPE FOR ISBN
        try{ char c = evt.getKeyChar();
       if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACKSPACE) || c==KeyEvent.VK_DELETE || c==KeyEvent.VK_SPACE)) {
           getToolkit().beep();
          evt.consume();
          throw new LibraryException("Type ISBN as DIGIT");
       }}catch (LibraryException ex){
           
       JOptionPane.showMessageDialog(this, ex.getMessage());
       this.IsbnTextField.setText("");
       }
    }//GEN-LAST:event_IsbnTextFieldKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(RegisterBookGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterBookGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterBookGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterBookGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterBookGUI().setVisible(true);
            }
        });
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddClientButton;
    private javax.swing.JPanel AddClientPanel;
    private javax.swing.JComboBox<Autori> AuthorComboBox;
    private javax.swing.JLabel AuthorLabel;
    private javax.swing.JButton CancelButton;
    private javax.swing.JComboBox<KategoriaLibrit> CategoryComboBox;
    private javax.swing.JLabel CategoryLabel;
    private javax.swing.JButton DeleteClientButton;
    private javax.swing.JLabel IsbnLabel;
    private javax.swing.JTextField IsbnTextField;
    private javax.swing.JLabel PriceLabel;
    private javax.swing.JTextField PriceTextField;
    private javax.swing.JLabel PublisherLabel;
    private javax.swing.JTextField PublisherTextField;
    private com.toedter.calendar.JYearChooser PublishigYearDate;
    private javax.swing.JLabel PublishingYearLabel;
    private javax.swing.JLabel QuantityLabel;
    private javax.swing.JTextField QuantityTextField;
    private javax.swing.JTextField Search;
    private javax.swing.JPanel TitelPanel;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JTextField TitleTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
