/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.View;

import BLL.Autori;
import BLL.KategoriaLibrit;
import BLL.Libri;
import DAL.asdf;
import DAL.CrudFormException;
import DAL.KategoriaLibritRepository;
import DAL.LibraryException;
import DAL.LibriRepository;
import GUI.Model.AuthorComboBoxModel;
import GUI.Model.BookTableModel;
import GUI.Model.CategoryComboBoxModel;
import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import static java.time.Clock.system;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Lenovo
 */
public class RegisterBookGUI extends javax.swing.JFrame {

    KategoriaLibritRepository klrepo = new KategoriaLibritRepository();
    CategoryComboBoxModel ccbox = new CategoryComboBoxModel();
    
    asdf arepo = new asdf();
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
         NrAuthors();
    }
    
    public void NrAuthors(){
        this.AuthorComboBox2.setVisible(false);
        this.AuthorComboBox3.setVisible(false);
        this.AuthorLabel2.setVisible(false);
        this.AuthorLabel3.setVisible(false);
     /*   int nr = NrAuthorsComboBox.getSelectedIndex();
        
        if(nr == 1){
        this.AuthorComboBox2.setVisible(true);
        }
        else if(nr==2){
        this.AuthorComboBox2.setVisible(true);
        this.AuthorComboBox3.setVisible(true);
        }else
            return;
    */
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
                    
                    getNrAutorveFromSelected(l);

                    
                     
                    
                    QuantityTextField.setText(Integer.toString(l.getLSasia()));
                    PriceTextField.setText(Double.toString(l.getLCmimiMujor()));
                    //AuthorComboBox.setSelectedItem(l.getAutoriName(0));
                    //AuthorComboBox2.setSelectedItem(l.getAutoriName(1));
                    //System.out.println(l.getIsbn());
                    IsbnTextField.setText(l.getIsbn());
                    
                    
                }
            }
         });

    }
    
    public void clear(){
        this.TitleTextField.setText("");
        this.PublisherTextField.setText("");
        this.PublishigYearDate.setYear(2020);
        this.QuantityTextField.setText("");
        this.CategoryComboBox.setSelectedItem(null);
        this.AuthorComboBox.setSelectedItem(null);
        this.AuthorComboBox2.setSelectedItem(null);
        this.IsbnTextField.setText("");
        this.PriceTextField.setText("");
        this.NrAuthors();
        
    }
    
    public void getNrAutorveFromSelected(Libri l){
                    if(l.getAutoriCollection().size() == 0){
                    System.out.println(0);
                    this.AuthorComboBox2.setVisible(false);
                    this.AuthorComboBox3.setVisible(false);
                    this.AuthorLabel2.setVisible(false);
                    this.AuthorLabel3.setVisible(false);
                }                
                else if(l.getAutoriCollection().size() == 1){
                    System.out.println(1);
                    this.AuthorComboBox.setSelectedItem(l.getAutoriCollection().toArray()[0]);
                    this.AuthorComboBox2.setVisible(false);
                    this.AuthorComboBox3.setVisible(false);
                    this.AuthorLabel2.setVisible(false);
                    this.AuthorLabel3.setVisible(false);
                }
                else if(l.getAutoriCollection().size() == 2){
                    System.out.println(2);
                    this.AuthorComboBox2.setVisible(true);
                    this.AuthorComboBox2.setSelectedItem(l.getAutoriCollection().toArray()[1]);
                    this.AuthorComboBox3.setVisible(false);
                    this.AuthorLabel2.setVisible(true);
                    this.AuthorLabel3.setVisible(false);
                }
                else {
                    System.out.println("else");
                    this.AuthorComboBox2.setVisible(true);
                    this.AuthorComboBox2.setSelectedItem(l.getAutoriCollection().toArray()[2]);
                    this.AuthorComboBox3.setVisible(true);
                    this.AuthorComboBox3.setSelectedItem(l.getAutoriCollection().toArray()[2]);
                    this.AuthorLabel2.setVisible(true);
                    this.AuthorLabel3.setVisible(true);
                }
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
            AuthorComboBox2.setModel(acbox);
            AuthorComboBox2.repaint();
            AuthorComboBox3.setModel(acbox);
            AuthorComboBox3.repaint();
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
        AuthorLabel2 = new javax.swing.JLabel();
        AuthorComboBox2 = new javax.swing.JComboBox<>();
        AuthorLabel3 = new javax.swing.JLabel();
        AuthorComboBox3 = new javax.swing.JComboBox<>();
        NrAuthorsLabel = new javax.swing.JLabel();
        NrAuthors1 = new javax.swing.JButton();
        NrAuthors2 = new javax.swing.JButton();
        NrAuthors3 = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        Search = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1200, 800));
        setMinimumSize(new java.awt.Dimension(1200, 800));
        setPreferredSize(new java.awt.Dimension(1200, 800));
        setResizable(false);

        TitelPanel.setBackground(new java.awt.Color(153, 153, 153));
        TitelPanel.setMaximumSize(new java.awt.Dimension(800, 100));
        TitelPanel.setMinimumSize(new java.awt.Dimension(800, 100));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Register Book");

        javax.swing.GroupLayout TitelPanelLayout = new javax.swing.GroupLayout(TitelPanel);
        TitelPanel.setLayout(TitelPanelLayout);
        TitelPanelLayout.setHorizontalGroup(
            TitelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TitelPanelLayout.createSequentialGroup()
                .addGap(505, 505, 505)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(510, Short.MAX_VALUE))
        );
        TitelPanelLayout.setVerticalGroup(
            TitelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TitelPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
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

        IsbnLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        IsbnLabel.setText("Isbn");

        AuthorLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        AuthorLabel2.setText("Author 2");

        AuthorComboBox2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        AuthorLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        AuthorLabel3.setText("Author 3");

        AuthorComboBox3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        NrAuthorsLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        NrAuthorsLabel.setText("Nr. Authors");

        NrAuthors1.setText("1");
        NrAuthors1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NrAuthors1ActionPerformed(evt);
            }
        });

        NrAuthors2.setText("2");
        NrAuthors2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NrAuthors2ActionPerformed(evt);
            }
        });

        NrAuthors3.setText("3");
        NrAuthors3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NrAuthors3ActionPerformed(evt);
            }
        });

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AuthorLabel3)
                            .addComponent(AuthorLabel)
                            .addComponent(AuthorLabel2)
                            .addComponent(NrAuthorsLabel))
                        .addGap(80, 80, 80)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(AuthorComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(AuthorComboBox2, 0, 150, Short.MAX_VALUE)
                                .addComponent(AuthorComboBox, 0, 150, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(NrAuthors1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                                .addComponent(NrAuthors2)
                                .addGap(18, 18, 18)
                                .addComponent(NrAuthors3))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(QuantityLabel)
                            .addComponent(PublishingYearLabel)
                            .addComponent(TitleLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(QuantityTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(TitleTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(PublishigYearDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(AddClientButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(PublisherLabel)
                        .addComponent(CategoryLabel)
                        .addComponent(PriceLabel)
                        .addComponent(IsbnLabel))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(CancelButton)
                        .addGap(36, 36, 36)))
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DeleteClientButton)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(PublisherTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PriceTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CategoryComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(IsbnTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26))
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
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(IsbnLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IsbnTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NrAuthorsLabel)
                            .addComponent(NrAuthors1)
                            .addComponent(NrAuthors2)
                            .addComponent(NrAuthors3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AuthorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AuthorLabel))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AuthorComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AuthorLabel2))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(AuthorLabel3)
                            .addComponent(AuthorComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(93, 93, 93))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AddClientButton)
                            .addComponent(DeleteClientButton)
                            .addComponent(CancelButton))
                        .addContainerGap())))
        );

        table.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
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

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel2.setText("Search");

        javax.swing.GroupLayout AddClientPanelLayout = new javax.swing.GroupLayout(AddClientPanel);
        AddClientPanel.setLayout(AddClientPanelLayout);
        AddClientPanelLayout.setHorizontalGroup(
            AddClientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddClientPanelLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(AddClientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddClientPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(AddClientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                            .addComponent(Search))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddClientPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(193, 193, 193))))
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
              l.setLTitulli(TitleTextField.getText());
              
             
              Autori a1 = (Autori) AuthorComboBox.getSelectedItem();
              Autori a2 = (Autori) AuthorComboBox2.getSelectedItem();
              
              System.out.println(a1);
              System.out.println(a2);
              
             // l.getAutoriCollection().add(a1) ;
                        // l.getAutoriCollection().add((Autori) AuthorComboBox.getSelectedItem());
                        // l.getAutoriCollection().add((Autori) AuthorComboBox2.getSelectedItem()); 
             Autori a = new Autori();
             a.setAEmri("Luan");
             l.getAutoriCollection().add(a);

              
              
              
              
              l.setLShtepiaBotuese(PublisherTextField.getText());
              l.setLVitiBotimit(PublishigYearDate.getValue());            
              l.setLKategoriaId((KategoriaLibrit) CategoryComboBox.getSelectedItem());
              l.setLSasia(Integer.parseInt(QuantityTextField.getText()));
              l.setLCmimiMujor(Double.parseDouble(PriceTextField.getText()));
              l.setIsbn(IsbnTextField.getText());
              
              lrepo.create(l);
            }else{
                Libri l = btm.getLibri(row);
                getNrAutorveFromSelected(l);
              l.setLTitulli(TitleTextField.getText());
              l.setLShtepiaBotuese(PublisherTextField.getText());
              l.setLVitiBotimit(PublishigYearDate.getValue());            
              l.setLKategoriaId((KategoriaLibrit) CategoryComboBox.getSelectedItem());
              l.setLSasia(Integer.parseInt(QuantityTextField.getText()));
              l.setLCmimiMujor(Double.parseDouble(PriceTextField.getText()));
              
              lrepo.edit(l);
                
                
            }
            //E krijojm ni metode per me i clear fieldat mbasi ti shtojme
            clear();
            this.loadBookTable();
     }catch(LibraryException ex){
            JOptionPane.showMessageDialog(this, "E dhena ekziston!");
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
                        Libri l = btm.getLibri(row);
                        lrepo.delete(l);
                    
                    }
            this.clear();
            this.loadBookTable();
        }   
        catch (Exception ex){
                   
          
        }
    }//GEN-LAST:event_DeleteClientButtonActionPerformed

    private void NrAuthors1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NrAuthors1ActionPerformed
        this.AuthorComboBox2.setVisible(false);
        this.AuthorComboBox3.setVisible(false);
        this.AuthorLabel2.setVisible(false);
        this.AuthorLabel3.setVisible(false);
    }//GEN-LAST:event_NrAuthors1ActionPerformed

    private void NrAuthors2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NrAuthors2ActionPerformed
        this.AuthorLabel2.setVisible(true);
        this.AuthorComboBox2.setVisible(true);
        
        this.AuthorLabel3.setVisible(false);
        this.AuthorComboBox3.setVisible(false);
    }//GEN-LAST:event_NrAuthors2ActionPerformed

    private void NrAuthors3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NrAuthors3ActionPerformed
        this.AuthorLabel2.setVisible(true);
        this.AuthorComboBox2.setVisible(true);
        this.AuthorLabel3.setVisible(true);
        this.AuthorComboBox3.setVisible(true);
    }//GEN-LAST:event_NrAuthors3ActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        this.clear();
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchActionPerformed

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
    private javax.swing.JComboBox<Autori> AuthorComboBox2;
    private javax.swing.JComboBox<Autori> AuthorComboBox3;
    private javax.swing.JLabel AuthorLabel;
    private javax.swing.JLabel AuthorLabel2;
    private javax.swing.JLabel AuthorLabel3;
    private javax.swing.JButton CancelButton;
    private javax.swing.JComboBox<KategoriaLibrit> CategoryComboBox;
    private javax.swing.JLabel CategoryLabel;
    private javax.swing.JButton DeleteClientButton;
    private javax.swing.JLabel IsbnLabel;
    private javax.swing.JTextField IsbnTextField;
    private javax.swing.JButton NrAuthors1;
    private javax.swing.JButton NrAuthors2;
    private javax.swing.JButton NrAuthors3;
    private javax.swing.JLabel NrAuthorsLabel;
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
