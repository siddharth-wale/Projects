package UserInterfaceCustomer;

import Business.Activity.Activity;
import Business.Business;
import Business.CommercialLoan.CommercialLoan;
import Business.Customer.Customer;
import Business.EducationLoan.EducationLoan;
import Business.Enterprise.Enterprise;
import Business.HouseLoan.HouseLoan;
import Business.Network.Network;
import Business.Organization.CustomerCareOrganization;
import Business.Organization.Organization;
import Business.Session.SessionLog;
import Business.Transaction.Transaction;
import Business.UserAccount.UserAccount;
import Business.VehicleLoan.VehicleLoan;
import Business.WorkQueue.TestWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.text.*;
import java.awt.print.*;
import java.util.regex.Pattern;
import javax.swing.JTable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class CustomerWorkAreaJPanel extends javax.swing.JPanel {
private JPanel userProcessContainer;
   private Business business;
   private UserAccount userAccount;
 private Customer customer;
 private SessionLog session;
  
   private Enterprise enterprise;
    /**
     * Creates new form CustomerWorkAreaJPanel
     */
    public CustomerWorkAreaJPanel(JPanel upc,UserAccount ua,Enterprise ent,Business b,SessionLog s) {
        initComponents();
        this.userProcessContainer= upc;
        this.userAccount=ua;
       this.business=b;
        this.enterprise=ent;
        this.session=s;
        populateTransactionHistory();
        populateRequestTable();
         Activity a= session.getActivityDirectory().addActivity();
           a.setActivityTime(new Date());
           a.setjPanelName("CustomerWorkAreaJPanel");
        
          for(Customer c: enterprise.getCustomerDirectory().getCustomerList())
        if(ua.getCustomer().getName().equals(c.getName()))
        {
            customer=c;
            lblCustomerName.setText(customer.getName());
            txtAccountNumber.setText(Integer.toString(customer.getAccountNumber()));
            txtRoutingNumber.setText(Integer.toString(customer.getRoutingNumber()));
            txtSwiftCode.setText(customer.getSwiftCode());
            txtBalance.setText(Integer.toString(customer.getBalance()));
            txtBranchName.setText(customer.getBranchName());
            txtAccountNumber3.setText(Integer.toString(customer.getAccountNumber()));
            txtName4.setText(customer.getName());
            jDateChooser1.setDate(customer.getDateOfBirth());
            txtEmailAddress.setText(customer.getEmailAddress());
            txtAddress11.setText(customer.getAddress());
            txtMobileNumber11.setText(Integer.toString(customer.getMobileNumber()));
            txtSSNNumber11.setText(Integer.toString(customer.getSsnNumber()));
            txtName.setText(customer.getName());
            jDateChooser2.setDate(customer.getDateOfBirth());
            txtAddress.setText(customer.getAddress());
            txtMobileNumber.setText(Integer.toString(customer.getMobileNumber()));
            txtSSN.setText(Integer.toString(customer.getSsnNumber()));
            txtName3.setText(customer.getName());
            jDateChooser3.setDate(customer.getDateOfBirth());
            txtAddress3.setText(customer.getAddress());
            txtMobileNumber3.setText(Integer.toString(customer.getMobileNumber()));
            txtSSN3.setText(Integer.toString(customer.getSsnNumber()));
            txtName2.setText(customer.getName());
            jDateChooser4.setDate(customer.getDateOfBirth());
            txtAddress2.setText(customer.getAddress());
            txtMobileNumber2.setText(Integer.toString(customer.getMobileNumber()));
            txtSSN2.setText(Integer.toString(customer.getSsnNumber()));     
            txtName1.setText(customer.getName());
            jDateChooser5.setDate(customer.getDateOfBirth());
            txtAddress1.setText(customer.getAddress());
            txtMobileNumber1.setText(Integer.toString(customer.getMobileNumber()));
            txtSSN1.setText(Integer.toString(customer.getSsnNumber()));  
            txtAccountno.setText(Integer.toString(customer.getAccountNumber()));
             txtAccountno1.setText(Integer.toString(customer.getAccountNumber()));
              txtAccountno2.setText(Integer.toString(customer.getAccountNumber()));
               txtAccountno3.setText(Integer.toString(customer.getAccountNumber()));
            
            return;
        
        }
         
    }
    private void populateTransactionHistory(){
        DefaultTableModel model = (DefaultTableModel) tblTransactionHistory1.getModel();

        model.setRowCount(0);
        String drCrAmount = "none";
        Customer customer = userAccount.getCustomer();
         for (Transaction t : customer.getTransactionDirectory().getTransactionList()) {
           
                Object row[] = new Object[5];
                row[0] = t;
                row[1] = t.getTransactionAmount();
                if (t.getDebitAmount() != 0) {
                    drCrAmount = "Debit";
                } else {
                    drCrAmount = "Credit";
                }
                row[2] = drCrAmount;
                row[3] = t.getRemBalance();
                row[4] = t.getTransferAccountNumber();
                model.addRow(row);
            
        }
        
    }
    public void populateRequestTable(){
        DefaultTableModel model = (DefaultTableModel) workRequestJTable1.getModel();
        
        model.setRowCount(0);
        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()){
            Object[] row = new Object[4];
            row[0] = request;
            row[1] = request.getReceiver();
            row[2] = request.getStatus();
            String result = ((TestWorkRequest) request).getTestResult();
            row[3] = result == null ? "Waiting" : result;
            
            model.addRow(row);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblCustomerName = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        txtAccountNumber = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtRoutingNumber = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSwiftCode = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtBalance = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtBranchName = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        txtAccountNumber3 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtTransferAccountNumber2 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtAmount2 = new javax.swing.JTextField();
        btnTransfer2 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        txtTransferAccountName = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTransactionHistory1 = new javax.swing.JTable();
        btnPrint = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        txtName4 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtAddress11 = new javax.swing.JTextField();
        txtMobileNumber11 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        txtSSNNumber11 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel91 = new javax.swing.JLabel();
        txtEmailAddress = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        workRequestJTable1 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel90 = new javax.swing.JLabel();
        requestTestJButton = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtLoanAmount = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtRepaymentTerm = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        txtVehicleType = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtBrand = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtModel = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        txtRateofInterest = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        txtVehicleCondition = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txtMobileNumber = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        txtSSN = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        txtCurrentEmployerAddress = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        txtOccupation = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        txtAnnulGrossIncome = new javax.swing.JTextField();
        btnProcessRequest = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel95 = new javax.swing.JLabel();
        txtAccountno3 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        txtUniversityName = new javax.swing.JTextField();
        txtRateofInterest3 = new javax.swing.JTextField();
        jComboBox4 = new javax.swing.JComboBox<>();
        txtRepaymentTerm3 = new javax.swing.JTextField();
        txtLoanAmount3 = new javax.swing.JTextField();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        txtCourseDuration = new javax.swing.JTextField();
        txtCourseName = new javax.swing.JTextField();
        txtUniversityAddress = new javax.swing.JTextField();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        txtAnnulGrossIncome3 = new javax.swing.JTextField();
        txtOccupation3 = new javax.swing.JTextField();
        txtCurrentEmployerAddress3 = new javax.swing.JTextField();
        txtSSN3 = new javax.swing.JTextField();
        txtMobileNumber3 = new javax.swing.JTextField();
        txtAddress3 = new javax.swing.JTextField();
        txtName3 = new javax.swing.JTextField();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel94 = new javax.swing.JLabel();
        txtAccountno2 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        txtName1 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        txtAddress1 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        txtMobileNumber1 = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        txtSSN1 = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        txtCurrentEmployerAddress1 = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        txtOccupation1 = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        txtAnnulGrossIncome1 = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        txtAccountno = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        txtRepaymentTerm1 = new javax.swing.JTextField();
        txtLoanAmount1 = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        txtRateofInterest1 = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        txtLoanPurpose = new javax.swing.JTextField();
        jDateChooser5 = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        txtLoanAmount2 = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        txtHouseAddress = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        txtRepaymentTerm2 = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel60 = new javax.swing.JLabel();
        txtRateofInterest2 = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        txtAnnulGrossIncome2 = new javax.swing.JTextField();
        txtOccupation2 = new javax.swing.JTextField();
        txtCurrentEmployerAddress2 = new javax.swing.JTextField();
        txtSSN2 = new javax.swing.JTextField();
        txtMobileNumber2 = new javax.swing.JTextField();
        txtAddress2 = new javax.swing.JTextField();
        txtName2 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jLabel93 = new javax.swing.JLabel();
        txtAccountno1 = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setIcon(new javax.swing.ImageIcon("/siddharth/Info 5100/Project/src/UserInterface/Screen Shot 2016-03-30 at 11.20.59 AM.png")); // NOI18N

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 255));
        jLabel1.setText("is Logged in!");

        lblCustomerName.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        lblCustomerName.setForeground(new java.awt.Color(0, 102, 255));
        lblCustomerName.setText("Customer Name");

        jTabbedPane2.setForeground(new java.awt.Color(0, 102, 204));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setForeground(new java.awt.Color(0, 102, 204));
        jLabel3.setText("Routing Number");

        jLabel5.setForeground(new java.awt.Color(0, 102, 204));
        jLabel5.setText("Swift Code");

        jLabel6.setForeground(new java.awt.Color(0, 102, 204));
        jLabel6.setText("Balance");

        jLabel7.setForeground(new java.awt.Color(0, 102, 204));
        jLabel7.setText("Branch Name");

        jLabel8.setForeground(new java.awt.Color(0, 102, 204));
        jLabel8.setText("Account Number");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(79, 79, 79)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBranchName, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(55, 55, 55)
                        .addComponent(txtAccountNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(58, 58, 58)
                        .addComponent(txtRoutingNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(94, 94, 94)
                        .addComponent(txtSwiftCode, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(599, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtAccountNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtRoutingNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtSwiftCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtBranchName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(627, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("View Account Details", jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel23.setForeground(new java.awt.Color(0, 102, 204));
        jLabel23.setText("Account Number");

        txtAccountNumber3.setEditable(false);

        jLabel24.setForeground(new java.awt.Color(0, 102, 204));
        jLabel24.setText("Transfer to Account Number");

        jLabel25.setForeground(new java.awt.Color(0, 102, 204));
        jLabel25.setText("Amount");

        btnTransfer2.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        btnTransfer2.setForeground(new java.awt.Color(0, 102, 204));
        btnTransfer2.setIcon(new javax.swing.ImageIcon("/siddharth/Info 5100/Project/src/UserInterfaceCustomer/Screen Shot 2016-03-30 at 12.53.06 PM.png")); // NOI18N
        btnTransfer2.setText("Transfer");
        btnTransfer2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransfer2ActionPerformed(evt);
            }
        });

        jLabel26.setForeground(new java.awt.Color(0, 102, 204));
        jLabel26.setText("Transfer to Account Name");

        jButton1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 102, 204));
        jButton1.setIcon(new javax.swing.ImageIcon("/siddharth/Info 5100/Project/src/UserInterfaceCustomer/Screen Shot 2016-03-31 at 9.39.06 PM.png")); // NOI18N
        jButton1.setText("Cancel");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addComponent(jLabel24)
                                    .addGap(30, 30, 30)
                                    .addComponent(txtTransferAccountNumber2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addComponent(jLabel23)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtAccountNumber3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addComponent(jLabel25)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtTransferAccountName, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnTransfer2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtAmount2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(574, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtAccountNumber3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtTransferAccountNumber2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txtTransferAccountName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txtAmount2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTransfer2))
                .addContainerGap(536, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Transfer Money", jPanel7);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        tblTransactionHistory1.setForeground(new java.awt.Color(0, 102, 204));
        tblTransactionHistory1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Date", "Amount Transfered", "Debit/Credit", "Balance", "Account Number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblTransactionHistory1);

        btnPrint.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        btnPrint.setForeground(new java.awt.Color(51, 102, 255));
        btnPrint.setIcon(new javax.swing.ImageIcon("/siddharth/Info 5100/Project/src/UserInterfaceCustomer/Print Icon.png")); // NOI18N
        btnPrint.setText("Print");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(340, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPrint)
                .addGap(374, 374, 374))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnPrint)
                .addContainerGap(530, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Transaction History", jPanel8);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jLabel19.setForeground(new java.awt.Color(0, 102, 204));
        jLabel19.setText("Name");

        txtName4.setEditable(false);
        txtName4.setForeground(new java.awt.Color(0, 102, 204));

        jLabel20.setForeground(new java.awt.Color(0, 102, 204));
        jLabel20.setText("Date of Birth");

        jLabel21.setForeground(new java.awt.Color(0, 102, 204));
        jLabel21.setText("Address");

        txtAddress11.setForeground(new java.awt.Color(0, 102, 204));

        txtMobileNumber11.setForeground(new java.awt.Color(0, 102, 204));

        jLabel22.setForeground(new java.awt.Color(0, 102, 204));
        jLabel22.setText("Mobile No.");

        btnSave.setForeground(new java.awt.Color(0, 102, 204));
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnUpdate.setForeground(new java.awt.Color(0, 102, 204));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jLabel30.setForeground(new java.awt.Color(0, 102, 204));
        jLabel30.setText("Email Address");

        txtSSNNumber11.setForeground(new java.awt.Color(0, 102, 204));

        jLabel91.setForeground(new java.awt.Color(0, 102, 204));
        jLabel91.setText("SSN no.");

        txtEmailAddress.setForeground(new java.awt.Color(0, 102, 204));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel30)
                    .addComponent(jLabel91)
                    .addComponent(btnSave))
                .addGap(79, 79, 79)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMobileNumber11, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                            .addComponent(txtAddress11, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                            .addComponent(txtName4, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(btnUpdate))
                    .addComponent(txtSSNNumber11, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmailAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(609, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(29, 29, 29)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtAddress11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtMobileNumber11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSSNNumber11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel91))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txtEmailAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnUpdate))
                .addContainerGap(504, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("View Profile", jPanel9);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        workRequestJTable1.setForeground(new java.awt.Color(0, 102, 204));
        workRequestJTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Message", "Receiver", "Status", "Result"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(workRequestJTable1);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane5.setViewportView(jTextArea1);

        jLabel90.setForeground(new java.awt.Color(0, 102, 204));
        jLabel90.setText("Message");

        requestTestJButton.setForeground(new java.awt.Color(0, 102, 204));
        requestTestJButton.setText("Request Test");
        requestTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestTestJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(322, 322, 322)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(requestTestJButton)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                            .addGap(13, 13, 13)
                            .addComponent(jLabel90)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(425, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel90))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addComponent(requestTestJButton)
                .addContainerGap(559, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Contact Customer Care", jPanel11);

        jTabbedPane1.setForeground(new java.awt.Color(0, 102, 204));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jSplitPane1.setDividerLocation(475);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setForeground(new java.awt.Color(0, 102, 204));
        jLabel11.setText("Vehicle Information:-");

        txtLoanAmount.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtLoanAmount.setForeground(new java.awt.Color(0, 102, 255));

        jLabel12.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 204));
        jLabel12.setText("Loan Amount");

        jLabel13.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 204));
        jLabel13.setText("Repayment Term (In Months)");

        txtRepaymentTerm.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtRepaymentTerm.setForeground(new java.awt.Color(0, 102, 255));

        jLabel14.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 102, 204));
        jLabel14.setText("Repayment Option");

        jComboBox1.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(0, 102, 204));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Please Select Repayment Option", "Cash", "Automatic Transfer", "Payroll Deduction" }));

        jLabel15.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 102, 255));
        jLabel15.setText("Vehicle Type");

        txtVehicleType.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtVehicleType.setForeground(new java.awt.Color(0, 102, 255));

        jLabel16.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 102, 255));
        jLabel16.setText("Brand");

        txtBrand.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtBrand.setForeground(new java.awt.Color(0, 102, 255));

        jLabel17.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 102, 255));
        jLabel17.setText("Model");

        txtModel.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtModel.setForeground(new java.awt.Color(0, 102, 255));

        jLabel37.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 102, 255));
        jLabel37.setText("Rate Of Interest");

        txtRateofInterest.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtRateofInterest.setForeground(new java.awt.Color(0, 102, 255));

        jLabel38.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 102, 204));
        jLabel38.setText("Vehicle Condition");

        txtVehicleCondition.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtVehicleCondition.setForeground(new java.awt.Color(0, 102, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel37)
                            .addComponent(jLabel38))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLoanAmount)
                            .addComponent(txtRepaymentTerm)
                            .addComponent(txtVehicleType)
                            .addComponent(txtBrand)
                            .addComponent(txtModel)
                            .addComponent(txtRateofInterest)
                            .addComponent(txtVehicleCondition)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel11)))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(txtVehicleCondition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLoanAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtRepaymentTerm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtVehicleType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(txtRateofInterest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(399, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(jPanel1);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jLabel18.setForeground(new java.awt.Color(0, 102, 204));
        jLabel18.setText("Applicant Information:-");

        jLabel27.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 102, 204));
        jLabel27.setText("Name");

        txtName.setEditable(false);
        txtName.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtName.setForeground(new java.awt.Color(0, 102, 255));

        jLabel28.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 102, 204));
        jLabel28.setText("Date of Birth");

        jLabel29.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 102, 204));
        jLabel29.setText("Address");

        txtAddress.setEditable(false);
        txtAddress.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtAddress.setForeground(new java.awt.Color(0, 102, 255));

        jLabel31.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 102, 204));
        jLabel31.setText("Mobile No.");

        txtMobileNumber.setEditable(false);
        txtMobileNumber.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtMobileNumber.setForeground(new java.awt.Color(0, 102, 255));

        jLabel32.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 102, 204));
        jLabel32.setText("SSN no.");

        txtSSN.setEditable(false);
        txtSSN.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtSSN.setForeground(new java.awt.Color(0, 102, 255));

        jLabel33.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 102, 204));
        jLabel33.setText("Current Employer & Address");

        txtCurrentEmployerAddress.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtCurrentEmployerAddress.setForeground(new java.awt.Color(0, 102, 255));

        jLabel34.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 102, 204));
        jLabel34.setText("Occupation");

        txtOccupation.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtOccupation.setForeground(new java.awt.Color(0, 102, 255));

        jLabel35.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 102, 204));
        jLabel35.setText("Annual Gross Income");

        txtAnnulGrossIncome.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtAnnulGrossIncome.setForeground(new java.awt.Color(0, 102, 255));

        btnProcessRequest.setForeground(new java.awt.Color(0, 102, 204));
        btnProcessRequest.setText("Process Request");
        btnProcessRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessRequestActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 102, 204));
        jButton3.setIcon(new javax.swing.ImageIcon("/siddharth/Info 5100/Project/src/UserInterfaceCustomer/Screen Shot 2016-03-31 at 9.39.06 PM.png")); // NOI18N
        jButton3.setText("Cancel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel95.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel95.setForeground(new java.awt.Color(0, 102, 204));
        jLabel95.setText("Account Number");

        txtAccountno3.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtAccountno3.setForeground(new java.awt.Color(0, 102, 255));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel18))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnProcessRequest))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel27)
                                            .addComponent(jLabel28)
                                            .addComponent(jLabel29)
                                            .addComponent(jLabel31)
                                            .addComponent(jLabel32)
                                            .addComponent(jLabel33)
                                            .addComponent(jLabel34)
                                            .addComponent(jLabel35))
                                        .addGap(44, 44, 44))
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel95)
                                        .addGap(113, 113, 113)))
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                    .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                    .addComponent(txtMobileNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                    .addComponent(txtSSN, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                    .addComponent(txtCurrentEmployerAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                    .addComponent(txtOccupation, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                    .addComponent(txtAnnulGrossIncome, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                    .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtAccountno3, javax.swing.GroupLayout.Alignment.TRAILING))))))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel18)
                .addGap(26, 26, 26)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27))
                        .addGap(25, 25, 25)
                        .addComponent(jLabel28))
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(txtMobileNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(txtSSN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel95)
                    .addComponent(txtAccountno3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(txtCurrentEmployerAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(txtOccupation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(txtAnnulGrossIncome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProcessRequest)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(328, Short.MAX_VALUE))
        );

        jSplitPane1.setRightComponent(jPanel10);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane1)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Vehicle Loan", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel71.setForeground(new java.awt.Color(0, 102, 204));
        jLabel71.setText("Loan Information:-");

        jLabel72.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(0, 102, 204));
        jLabel72.setText("Loan Amount");

        jLabel73.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(0, 102, 204));
        jLabel73.setText("Repayment Term (In Months)");

        jLabel74.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(0, 102, 204));
        jLabel74.setText("Repayment Option");

        jLabel75.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(0, 102, 255));
        jLabel75.setText("Rate Of Interest");

        jLabel76.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(0, 102, 255));
        jLabel76.setText("University Name");

        txtUniversityName.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtUniversityName.setForeground(new java.awt.Color(0, 102, 255));

        txtRateofInterest3.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtRateofInterest3.setForeground(new java.awt.Color(0, 102, 255));

        jComboBox4.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jComboBox4.setForeground(new java.awt.Color(0, 102, 204));
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Please Select Repayment Option", "Cash", "Automatic Transfer", "Payroll Deduction" }));

        txtRepaymentTerm3.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtRepaymentTerm3.setForeground(new java.awt.Color(0, 102, 255));

        txtLoanAmount3.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtLoanAmount3.setForeground(new java.awt.Color(0, 102, 255));

        jLabel77.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(0, 102, 255));
        jLabel77.setText("University Address");

        jLabel78.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(0, 102, 255));
        jLabel78.setText("Course Name");

        jLabel79.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(0, 102, 255));
        jLabel79.setText("Course Duration");

        txtCourseDuration.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtCourseDuration.setForeground(new java.awt.Color(0, 102, 255));

        txtCourseName.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtCourseName.setForeground(new java.awt.Color(0, 102, 255));

        txtUniversityAddress.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtUniversityAddress.setForeground(new java.awt.Color(0, 102, 255));

        jLabel80.setForeground(new java.awt.Color(0, 102, 204));
        jLabel80.setText("Applicant Information:-");

        jLabel81.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(0, 102, 204));
        jLabel81.setText("Name");

        jLabel82.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(0, 102, 204));
        jLabel82.setText("Date of Birth");

        jLabel83.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(0, 102, 204));
        jLabel83.setText("Address");

        jLabel84.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(0, 102, 204));
        jLabel84.setText("Mobile No.");

        jLabel85.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(0, 102, 204));
        jLabel85.setText("SSN no.");

        jLabel86.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(0, 102, 204));
        jLabel86.setText("Current Employer & Address");

        jLabel87.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(0, 102, 204));
        jLabel87.setText("Occupation");

        jLabel88.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(0, 102, 204));
        jLabel88.setText("Annual Gross Income");

        txtAnnulGrossIncome3.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtAnnulGrossIncome3.setForeground(new java.awt.Color(0, 102, 255));

        txtOccupation3.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtOccupation3.setForeground(new java.awt.Color(0, 102, 255));

        txtCurrentEmployerAddress3.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtCurrentEmployerAddress3.setForeground(new java.awt.Color(0, 102, 255));

        txtSSN3.setEditable(false);
        txtSSN3.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtSSN3.setForeground(new java.awt.Color(0, 102, 255));

        txtMobileNumber3.setEditable(false);
        txtMobileNumber3.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtMobileNumber3.setForeground(new java.awt.Color(0, 102, 255));

        txtAddress3.setEditable(false);
        txtAddress3.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtAddress3.setForeground(new java.awt.Color(0, 102, 255));

        txtName3.setEditable(false);
        txtName3.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtName3.setForeground(new java.awt.Color(0, 102, 255));

        jButton8.setForeground(new java.awt.Color(0, 102, 204));
        jButton8.setText("Process Request");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jButton9.setForeground(new java.awt.Color(0, 102, 204));
        jButton9.setIcon(new javax.swing.ImageIcon("/siddharth/Info 5100/Project/src/UserInterfaceCustomer/Screen Shot 2016-03-31 at 9.39.06 PM.png")); // NOI18N
        jButton9.setText("Cancel");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel94.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(0, 102, 204));
        jLabel94.setText("Account Number");

        txtAccountno2.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtAccountno2.setForeground(new java.awt.Color(0, 102, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel71)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel72)
                                .addGap(118, 118, 118)
                                .addComponent(txtLoanAmount3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel74)
                                    .addComponent(jLabel73)
                                    .addComponent(jLabel75)
                                    .addComponent(jLabel76)
                                    .addComponent(jLabel77)
                                    .addComponent(jLabel78)
                                    .addComponent(jLabel79))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtRepaymentTerm3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtRateofInterest3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtUniversityName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtUniversityAddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtCourseName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtCourseDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel80)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel81)
                            .addComponent(jLabel82)
                            .addComponent(jLabel83)
                            .addComponent(jLabel84)
                            .addComponent(jLabel85)
                            .addComponent(jLabel86)
                            .addComponent(jLabel87)
                            .addComponent(jLabel88)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel94))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtOccupation3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCurrentEmployerAddress3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtAccountno2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtSSN3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtMobileNumber3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtAddress3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jDateChooser3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                                .addComponent(txtName3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtAnnulGrossIncome3))
                            .addComponent(jButton8))))
                .addGap(407, 407, 407))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel71)
                                .addGap(169, 169, 169)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtRateofInterest3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel75))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtUniversityName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel76)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtLoanAmount3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel72))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtRepaymentTerm3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel73))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel74))
                                .addGap(92, 92, 92)))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel77)
                            .addComponent(txtUniversityAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel78)
                            .addComponent(txtCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel79)
                            .addComponent(txtCourseDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel81)
                                    .addComponent(txtName3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addComponent(jLabel82))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel80)
                                .addGap(76, 76, 76)
                                .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel83)
                                    .addComponent(txtAddress3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel84)
                                    .addComponent(txtMobileNumber3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel85)
                                    .addComponent(txtSSN3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel94)
                            .addComponent(txtAccountno2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel86)
                            .addComponent(txtCurrentEmployerAddress3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel87)
                            .addComponent(txtOccupation3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel88)
                            .addComponent(txtAnnulGrossIncome3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton8))
                .addContainerGap(343, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Education Loan", jPanel3);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel39.setForeground(new java.awt.Color(0, 102, 204));
        jLabel39.setText("Applicant Information:-");

        jLabel40.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(0, 102, 204));
        jLabel40.setText("Name");

        txtName1.setEditable(false);
        txtName1.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtName1.setForeground(new java.awt.Color(0, 102, 255));

        jLabel41.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(0, 102, 204));
        jLabel41.setText("Date of Birth");

        jLabel42.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(0, 102, 204));
        jLabel42.setText("Address");

        txtAddress1.setEditable(false);
        txtAddress1.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtAddress1.setForeground(new java.awt.Color(0, 102, 255));

        jLabel43.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(0, 102, 204));
        jLabel43.setText("Mobile No.");

        txtMobileNumber1.setEditable(false);
        txtMobileNumber1.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtMobileNumber1.setForeground(new java.awt.Color(0, 102, 255));

        jLabel44.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(0, 102, 204));
        jLabel44.setText("SSN no.");

        txtSSN1.setEditable(false);
        txtSSN1.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtSSN1.setForeground(new java.awt.Color(0, 102, 255));

        jLabel45.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(0, 102, 204));
        jLabel45.setText("Current Employer & Address");

        txtCurrentEmployerAddress1.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtCurrentEmployerAddress1.setForeground(new java.awt.Color(0, 102, 255));

        jLabel46.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(0, 102, 204));
        jLabel46.setText("Occupation");

        txtOccupation1.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtOccupation1.setForeground(new java.awt.Color(0, 102, 255));

        jLabel47.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(0, 102, 204));
        jLabel47.setText("Annual Gross Income");

        txtAnnulGrossIncome1.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtAnnulGrossIncome1.setForeground(new java.awt.Color(0, 102, 255));

        jLabel48.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(0, 102, 204));
        jLabel48.setText("Account Number");

        txtAccountno.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtAccountno.setForeground(new java.awt.Color(0, 102, 255));

        jButton4.setForeground(new java.awt.Color(0, 102, 204));
        jButton4.setText("Process Request");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 102, 204));
        jButton5.setIcon(new javax.swing.ImageIcon("/siddharth/Info 5100/Project/src/UserInterfaceCustomer/Screen Shot 2016-03-31 at 9.39.06 PM.png")); // NOI18N
        jButton5.setText("Cancel");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel49.setForeground(new java.awt.Color(0, 102, 204));
        jLabel49.setText("Loan Information:-");

        jLabel50.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(0, 102, 204));
        jLabel50.setText("Loan Amount");

        jLabel51.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(0, 102, 204));
        jLabel51.setText("Repayment Term (In Months)");

        jLabel52.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(0, 102, 204));
        jLabel52.setText("Repayment Option");

        jComboBox2.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jComboBox2.setForeground(new java.awt.Color(0, 102, 204));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Please Select Repayment Option", "Cash", "Automatic Transfer", "Payroll Deduction" }));

        txtRepaymentTerm1.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtRepaymentTerm1.setForeground(new java.awt.Color(0, 102, 255));

        txtLoanAmount1.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtLoanAmount1.setForeground(new java.awt.Color(0, 102, 255));

        jLabel53.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(0, 102, 255));
        jLabel53.setText("Rate Of Interest");

        txtRateofInterest1.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtRateofInterest1.setForeground(new java.awt.Color(0, 102, 255));

        jLabel54.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(0, 102, 255));
        jLabel54.setText("Loan's Purpose");

        txtLoanPurpose.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtLoanPurpose.setForeground(new java.awt.Color(0, 102, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jLabel49))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel52)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel51)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                .addComponent(txtRepaymentTerm1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel54)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtLoanPurpose, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel50)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtLoanAmount1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel53)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtRateofInterest1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel39)
                        .addGap(379, 379, 379))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton4))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel40)
                                            .addComponent(jLabel41)
                                            .addComponent(jLabel42)
                                            .addComponent(jLabel43)
                                            .addComponent(jLabel44)
                                            .addComponent(jLabel45)
                                            .addComponent(jLabel46)
                                            .addComponent(jLabel47))
                                        .addGap(44, 44, 44))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel48)
                                        .addGap(113, 113, 113)))
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtName1, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                    .addComponent(txtAddress1, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                    .addComponent(txtMobileNumber1, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                    .addComponent(txtSSN1, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                    .addComponent(txtCurrentEmployerAddress1, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                    .addComponent(txtOccupation1, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                    .addComponent(txtAnnulGrossIncome1, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                    .addComponent(jDateChooser5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtAccountno))))
                        .addGap(101, 101, 101))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(jLabel49))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40)
                    .addComponent(txtLoanAmount1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel50))
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel41)
                            .addComponent(txtLoanPurpose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel54))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel42)
                            .addComponent(txtAddress1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRepaymentTerm1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel51))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel43)
                            .addComponent(txtMobileNumber1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel52))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel44)
                            .addComponent(txtSSN1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel53)
                            .addComponent(txtRateofInterest1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jDateChooser5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(txtAccountno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(txtCurrentEmployerAddress1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(txtOccupation1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(txtAnnulGrossIncome1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(360, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Commercial Loan", jPanel5);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel55.setForeground(new java.awt.Color(0, 102, 204));
        jLabel55.setText("Loan Information:-");

        jLabel56.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(0, 102, 204));
        jLabel56.setText("Loan Amount");

        txtLoanAmount2.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtLoanAmount2.setForeground(new java.awt.Color(0, 102, 255));

        jLabel57.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(0, 102, 255));
        jLabel57.setText("House Address");

        txtHouseAddress.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtHouseAddress.setForeground(new java.awt.Color(0, 102, 255));

        jLabel58.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(0, 102, 204));
        jLabel58.setText("Repayment Term (In Months)");

        txtRepaymentTerm2.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtRepaymentTerm2.setForeground(new java.awt.Color(0, 102, 255));

        jLabel59.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(0, 102, 204));
        jLabel59.setText("Repayment Option");

        jComboBox3.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jComboBox3.setForeground(new java.awt.Color(0, 102, 204));
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Please Select Repayment Option", "Cash", "Automatic Transfer", "Payroll Deduction" }));

        jLabel60.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(0, 102, 255));
        jLabel60.setText("Rate Of Interest");

        txtRateofInterest2.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtRateofInterest2.setForeground(new java.awt.Color(0, 102, 255));

        jLabel61.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(0, 102, 204));
        jLabel61.setText("Name");

        jLabel62.setForeground(new java.awt.Color(0, 102, 204));
        jLabel62.setText("Applicant Information:-");

        jLabel63.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(0, 102, 204));
        jLabel63.setText("Date of Birth");

        jLabel64.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(0, 102, 204));
        jLabel64.setText("Address");

        jLabel65.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(0, 102, 204));
        jLabel65.setText("Mobile No.");

        jLabel66.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(0, 102, 204));
        jLabel66.setText("SSN no.");

        jLabel67.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(0, 102, 204));
        jLabel67.setText("Current Employer & Address");

        jLabel68.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(0, 102, 204));
        jLabel68.setText("Occupation");

        jLabel69.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(0, 102, 204));
        jLabel69.setText("Annual Gross Income");

        txtAnnulGrossIncome2.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtAnnulGrossIncome2.setForeground(new java.awt.Color(0, 102, 255));

        txtOccupation2.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtOccupation2.setForeground(new java.awt.Color(0, 102, 255));

        txtCurrentEmployerAddress2.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtCurrentEmployerAddress2.setForeground(new java.awt.Color(0, 102, 255));

        txtSSN2.setEditable(false);
        txtSSN2.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtSSN2.setForeground(new java.awt.Color(0, 102, 255));

        txtMobileNumber2.setEditable(false);
        txtMobileNumber2.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtMobileNumber2.setForeground(new java.awt.Color(0, 102, 255));

        txtAddress2.setEditable(false);
        txtAddress2.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtAddress2.setForeground(new java.awt.Color(0, 102, 255));

        txtName2.setEditable(false);
        txtName2.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtName2.setForeground(new java.awt.Color(0, 102, 255));

        jButton6.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(0, 102, 204));
        jButton6.setIcon(new javax.swing.ImageIcon("/siddharth/Info 5100/Project/src/UserInterfaceCustomer/Screen Shot 2016-03-31 at 9.39.06 PM.png")); // NOI18N
        jButton6.setText("Cancel");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setForeground(new java.awt.Color(0, 102, 204));
        jButton7.setText("Process Request");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel93.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel93.setForeground(new java.awt.Color(0, 102, 204));
        jLabel93.setText("Account Number");

        txtAccountno1.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtAccountno1.setForeground(new java.awt.Color(0, 102, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel57)
                            .addComponent(jLabel56)
                            .addComponent(jLabel58)
                            .addComponent(jLabel60)
                            .addComponent(jLabel59))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRepaymentTerm2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLoanAmount2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRateofInterest2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHouseAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel55))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel62)
                        .addGap(355, 355, 355))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel61)
                            .addComponent(jLabel63)
                            .addComponent(jLabel64)
                            .addComponent(jLabel65)
                            .addComponent(jLabel68)
                            .addComponent(jLabel69)
                            .addComponent(jLabel66)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel93)
                            .addComponent(jLabel67))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAccountno1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtSSN2)
                                .addComponent(txtName2)
                                .addComponent(txtAddress2)
                                .addComponent(txtMobileNumber2)
                                .addComponent(txtOccupation2)
                                .addComponent(txtAnnulGrossIncome2)
                                .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton7))
                            .addComponent(txtCurrentEmployerAddress2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(103, 103, 103))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(jLabel62))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel61)
                    .addComponent(txtLoanAmount2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56))
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel63)
                        .addComponent(jLabel58)
                        .addComponent(txtRepaymentTerm2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel60)
                    .addComponent(txtRateofInterest2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel64)
                    .addComponent(txtAddress2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel65)
                    .addComponent(txtMobileNumber2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel66)
                    .addComponent(txtSSN2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHouseAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel57))
                .addGap(1, 1, 1)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAccountno1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel93))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCurrentEmployerAddress2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel67))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOccupation2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel68))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAnnulGrossIncome2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel69))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7))
                .addContainerGap(335, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("House Loan", jPanel4);

        jTabbedPane2.addTab("Request for Loan", jTabbedPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(lblCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(663, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCustomerName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTransfer2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransfer2ActionPerformed
        // TODO add your handling code here:
//               for(Customer c: enterprise.getCustomerDirectory().getCustomerList()){
//                    if (c.getAccountNumber() == Integer.parseInt(txtAccountNumber.getText())) {
//                   for(Transaction t : c.getTransactionDirectory().getTransactionList()){
//                          c.setAccountNumber(Integer.parseInt(txtAccountNumber3.getText()));
//                          t.setTransferAccountNumber(Integer.parseInt(txtTransferAccountNumber2.getText()));
//                          t.setTranferPreson(c);
//                          t.setDebitAmount(Integer.parseInt(txtAmount2.getText()));
//                          t.setRemBalance(c.getBalance()-Integer.parseInt(txtAmount2.getText()));
//                          c.setBalance(c.getBalance()-Integer.parseInt(txtAmount2.getText()));
//                   }
//                   }
//               }
if(!Pattern.matches("^\\d+", txtTransferAccountNumber2.getText())){
             JOptionPane.showMessageDialog(null, "Please Enter Numeric Value in Transfer to Account Number");
         }
        else if(!Pattern.matches("\\d{9}", txtTransferAccountNumber2.getText())){
           JOptionPane.showMessageDialog(null,"Please Enter 9 digits Transfer to Account Number");
        }
 else if(txtTransferAccountName.getText().equals("")){
             JOptionPane.showMessageDialog(null, "Please Enter Tranfer to Account Name");
         }
 else if(!Pattern.matches("^\\d+", txtAmount2.getText())){
             JOptionPane.showMessageDialog(null, "Please Enter Numeric Value in Amount");
         }
 else{
     
 try{
         Customer cus = null;
               for(Network n:business.getNetworkList()){
                   for (Enterprise e: n.getEnterpriseDirectory().getEnterpriseList()){
                       for(Customer c: e.getCustomerDirectory().getCustomerList()){
                           if (c.getAccountNumber() == Integer.parseInt(txtTransferAccountNumber2.getText())) {
//                               c.setBalance(c.getBalance()+Integer.parseInt(txtAmount2.getText()));
                               SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                               String date1  = dateFormat.format(new Date()); 
                               c.getTransactionDirectory().addTransaction(new Date(), Integer.parseInt(txtAmount2.getText()), 0,
                                       Integer.parseInt(txtAmount2.getText()),Integer.parseInt(txtTransferAccountNumber2.getText()),
                                       c.getBalance()+Integer.parseInt(txtAmount2.getText()), userAccount.getCustomer(), "Credit");
                               c.setBalance(c.getBalance()+Integer.parseInt(txtAmount2.getText()));
                               cus= customer;
                           }
                       }
                   }
               }
              Customer c = userAccount.getCustomer();
              SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
              String date1  = dateFormat.format(new Date()); 
               c.getTransactionDirectory().addTransaction(new Date(), Integer.parseInt(txtAmount2.getText()),
                 Integer.parseInt(txtAmount2.getText()),0,
                Integer.parseInt(txtTransferAccountNumber2.getText()),c.getBalance()-Integer.parseInt(txtAmount2.getText()), cus, "Debit");     
                  c.setBalance(c.getBalance()-Integer.parseInt(txtAmount2.getText()));
                          JOptionPane.showMessageDialog(null, "Transfered");
                
                  populateTransactionHistory();
 }
 catch(Exception e){
     
 }
 }
    }//GEN-LAST:event_btnTransfer2ActionPerformed

    private void requestTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestTestJButtonActionPerformed
 String message = jTextArea1.getText();
        
        TestWorkRequest request = new TestWorkRequest();
        request.setMessage(message);
        request.setSender(userAccount);
        request.setStatus("Sent");
        
        Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
            if (organization instanceof CustomerCareOrganization){
                org = organization;
                break;
            }
        }
        if (org!=null){
            org.getWorkQueue().getWorkRequestList().add(request);
            userAccount.getWorkQueue().getWorkRequestList().add(request);
        }
        populateRequestTable();
    }//GEN-LAST:event_requestTestJButtonActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
         txtName4.setEditable(false);
        jDateChooser1.setEnabled(false);
        txtEmailAddress.setEditable(true);
        txtMobileNumber11.setEditable(true);
        txtSSNNumber11.setEditable(false);
        txtAddress11.setEditable(true);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
   for(Customer c: enterprise.getCustomerDirectory().getCustomerList())
        if(userAccount.getCustomer().getName().equals(c.getName()))
        {
         customer=c;
        customer.setName(txtName4.getText());
        customer.setDateOfBirth(jDateChooser1.getDate());
        customer.setEmailAddress(txtEmailAddress.getText());
        customer.setMobileNumber(Integer.parseInt(txtMobileNumber11.getText()));
        customer.setSsnNumber(Integer.parseInt(txtSSNNumber11.getText()));
        customer.setAddress(txtAddress11.getText());
        
        
        txtName4.setEditable(false);
        jDateChooser1.setEnabled(false);
        txtEmailAddress.setEditable(false);
        txtMobileNumber11.setEditable(false);
        txtSSNNumber11.setEditable(false);
        txtAddress11.setEditable(false);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnProcessRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessRequestActionPerformed
        // TODO add your handling code here:
        if(txtVehicleCondition.getText().equals("")){
             JOptionPane.showMessageDialog(null, "Please Enter Vehicle Condition");
         }
        else if(!Pattern.matches("^\\d+", txtLoanAmount.getText())){
             JOptionPane.showMessageDialog(null, "Please Enter Numeric Value in Loan Amount");
         }
        else if(!Pattern.matches("^\\d+", txtRepaymentTerm.getText())){
             JOptionPane.showMessageDialog(null, "Please Enter Numeric Value in Repayment Term");
         }
       else if(jComboBox1.getSelectedIndex()!=-1){
        JOptionPane.showMessageDialog(null, "Please Select Repayment Option from Combo box");
         }
       else if(txtVehicleType.getText().equals("")){
             JOptionPane.showMessageDialog(null, "Please Enter Vehicle Type");
         }
        else if(txtBrand.getText().equals("")){
             JOptionPane.showMessageDialog(null, "Please Enter Brand");
         }
        else if(txtModel.getText().equals("")){
             JOptionPane.showMessageDialog(null, "Please Enter Model");
         }
        else if(!Pattern.matches("^\\d+", txtRateofInterest.getText())){
             JOptionPane.showMessageDialog(null, "Please Enter Numeric Value in Rate of Interest");
         }
        else if(txtCurrentEmployerAddress.getText().equals("")){
             JOptionPane.showMessageDialog(null, "Please Enter Current Employer & Address");
         }
        else if(txtOccupation.getText().equals("")){
             JOptionPane.showMessageDialog(null, "Please Enter Occupation");
         }
        else if(!Pattern.matches("^\\d+", txtAnnulGrossIncome.getText())){
             JOptionPane.showMessageDialog(null, "Please Enter Numeric Value in Annual Gross Income");
         }
        else{
            
        try{
        
        
        
        
        
           for (Customer c : enterprise.getCustomerDirectory().getCustomerList()) {
                 if (c.getAccountNumber() == Integer.parseInt(txtAccountNumber.getText())) {
     
          
          String VehicleCondition = txtVehicleCondition.getText();
           int LoanAmount =Integer.parseInt(txtLoanAmount.getText());
          int RepaymentTerm =Integer.parseInt(txtRepaymentTerm.getText());
          String VehicleType =txtVehicleType.getText();
          String Brand= txtBrand.getText();
          String Model =txtModel.getText();
          double RateOfInterest=Double.parseDouble(txtRateofInterest.getText());
          String CurrentEmployerName=txtCurrentEmployerAddress.getText();
          String Occupation=txtOccupation.getText();
          int AnnualGrossIncome =Integer.parseInt(txtAnnulGrossIncome.getText());
          
           SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
           String date1  = dateFormat.format(new Date()); 
           String repaymentOption = jComboBox1.getSelectedItem().toString();
         c.getVehicleLoanDirectory().addVehicleLoan(VehicleCondition, LoanAmount, RepaymentTerm, VehicleType, Brand, Model, RateOfInterest, CurrentEmployerName, Occupation, AnnualGrossIncome,  "Pending",date1,repaymentOption);
    
     
    
       
         
        JOptionPane.showMessageDialog(null, "Vehicle Loan request send to Loan Department");
        
           }
           }  
        }
        catch(Exception e){
            
        }
        }
    }//GEN-LAST:event_btnProcessRequestActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
     txtVehicleCondition.setText("");
     txtLoanAmount.setText("");
     txtRepaymentTerm.setText("");
     txtVehicleType.setText("");
     txtBrand.setText("");
     txtModel.setText("");
     txtRateofInterest.setText("");
     txtCurrentEmployerAddress.setText("");
     txtOccupation.setText("");
     txtAnnulGrossIncome.setText("");
     
     
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        if(txtUniversityAddress.getText().equals("")){
             JOptionPane.showMessageDialog(null, "Please Enter University Address");
         }
        else if(txtUniversityName.getText().equals("")){
             JOptionPane.showMessageDialog(null, "Please Enter University Name");
         }
        else if(txtCourseDuration.getText().equals("")){
             JOptionPane.showMessageDialog(null, "Please Enter Course Duration");
         }
        else if(txtCourseName.getText().equals("")){
             JOptionPane.showMessageDialog(null, "Please Enter Course Name");
         }
           else if(!Pattern.matches("^\\d+", txtRepaymentTerm3.getText())){
             JOptionPane.showMessageDialog(null, "Please Enter Numeric Value in Repayment Term");
         }
       else if(jComboBox4.getSelectedIndex()!=-1){
        JOptionPane.showMessageDialog(null, "Please Select Repayment Option from Combo box");
         }
         else if(!Pattern.matches("^\\d+", txtLoanAmount3.getText())){
             JOptionPane.showMessageDialog(null, "Please Enter Numeric Value in Loan Amount");
         }
            else if(!Pattern.matches("^\\d+", txtRateofInterest3.getText())){
             JOptionPane.showMessageDialog(null, "Please Enter Numeric Value in Rate of Interest");
         }
        else if(txtCurrentEmployerAddress3.getText().equals("")){
             JOptionPane.showMessageDialog(null, "Please Enter Current Employer & Address");
         }
        else if(txtOccupation3.getText().equals("")){
             JOptionPane.showMessageDialog(null, "Please Enter Occupation");
         }
        else if(!Pattern.matches("^\\d+", txtAnnulGrossIncome3.getText())){
             JOptionPane.showMessageDialog(null, "Please Enter Numeric Value in Annual Gross Income");
         }
        else{
            
        try{
            for (Customer c : enterprise.getCustomerDirectory().getCustomerList()) {
                  if (c.getAccountNumber() == Integer.parseInt(txtAccountNumber.getText())) {
                      
          
          int LoanAmount =Integer.parseInt(txtLoanAmount3.getText());
          int RepaymentTerm =Integer.parseInt(txtRepaymentTerm3.getText());
          String UniversityName = txtUniversityName.getText();
          String UniversityAddress= txtUniversityAddress.getText();
          String CourseName = txtCourseName.getText();
          String CourseDuration =txtCourseDuration.getText();
          double RateOfInterest=Double.parseDouble(txtRateofInterest3.getText());
          String CurrentEmployerName=txtCurrentEmployerAddress3.getText();
          String Occupation=txtOccupation3.getText();
          int AnnualGrossIncome =Integer.parseInt(txtAnnulGrossIncome3.getText());
          
           SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
           String date1  = dateFormat.format(new Date()); 
           String repaymentOption = jComboBox4.getSelectedItem().toString();  
                     
        c.getEducationLoanDirectory().addEducationLoan(LoanAmount, RepaymentTerm, repaymentOption, UniversityName, UniversityAddress, CourseName, CourseDuration, RateOfInterest, CurrentEmployerName, Occupation, AnnualGrossIncome,  "Pending", date1);
      
        JOptionPane.showMessageDialog(null, "Education Loan request send to Loan Department");
            }
            }
                    }
            catch(Exception e){
                    
                    }
                    }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
  
     txtLoanAmount3.setText("");
     txtRepaymentTerm3.setText("");
     txtUniversityAddress.setText("");
     txtUniversityName.setText("");
     txtCourseDuration.setText("");
     txtCourseName.setText("");
     
     txtRateofInterest3.setText("");
     txtCurrentEmployerAddress3.setText("");
     txtOccupation3.setText("");
     txtAnnulGrossIncome3.setText("");
    
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
       // TODO add your handling code here:
       if(txtHouseAddress.getText().equals("")){
             JOptionPane.showMessageDialog(null, "Please Enter House Address");
         }
                 else if(!Pattern.matches("^\\d+", txtRepaymentTerm3.getText())){
             JOptionPane.showMessageDialog(null, "Please Enter Numeric Value in Repayment Term");
         }
       else if(jComboBox4.getSelectedIndex()!=-1){
        JOptionPane.showMessageDialog(null, "Please Select Repayment Option from Combo box");
         }
         else if(!Pattern.matches("^\\d+", txtLoanAmount3.getText())){
             JOptionPane.showMessageDialog(null, "Please Enter Numeric Value in Loan Amount");
         }
            else if(!Pattern.matches("^\\d+", txtRateofInterest3.getText())){
             JOptionPane.showMessageDialog(null, "Please Enter Numeric Value in Rate of Interest");
         }
        else if(txtCurrentEmployerAddress3.getText().equals("")){
             JOptionPane.showMessageDialog(null, "Please Enter Current Employer & Address");
         }
        else if(txtOccupation3.getText().equals("")){
             JOptionPane.showMessageDialog(null, "Please Enter Occupation");
         }
        else if(!Pattern.matches("^\\d+", txtAnnulGrossIncome3.getText())){
             JOptionPane.showMessageDialog(null, "Please Enter Numeric Value in Annual Gross Income");
         }
        else{
            
        try{
           for (Customer c : enterprise.getCustomerDirectory().getCustomerList()) {
                 if (c.getAccountNumber() == Integer.parseInt(txtAccountNumber.getText())) {
            int LoanAmount =Integer.parseInt(txtLoanAmount2.getText());
          int RepaymentTerm =Integer.parseInt(txtRepaymentTerm2.getText());
          String HouseAddress = txtHouseAddress.getText();
          double RateOfInterest=Double.parseDouble(txtRateofInterest2.getText());
          String CurrentEmployerName=txtCurrentEmployerAddress2.getText();
          String Occupation=txtOccupation2.getText();
          int AnnualGrossIncome =Integer.parseInt(txtAnnulGrossIncome2.getText());
          
           SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
           String date1  = dateFormat.format(new Date()); 
           String repaymentOption = jComboBox3.getSelectedItem().toString();             
    c.getHouseLoanDirectory().addHouseLoan(LoanAmount, RepaymentTerm, repaymentOption, HouseAddress, RateOfInterest, CurrentEmployerName, Occupation, AnnualGrossIncome, "Pending", date1);
     
        JOptionPane.showMessageDialog(null, "House Loan request send to Loan Department");
                 }
           }
                         }
                         catch(Exception e){
                         
                         }
                         }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
     txtLoanAmount2.setText("");
     txtRepaymentTerm2.setText("");
     txtHouseAddress.setText("");
     
     txtRateofInterest2.setText("");
     txtCurrentEmployerAddress2.setText("");
     txtOccupation2.setText("");
     txtAnnulGrossIncome2.setText("");
     
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if(txtLoanPurpose.getText().equals("")){
             JOptionPane.showMessageDialog(null, "Please Enter Loan's Purpose");
         }
                else if(!Pattern.matches("^\\d+", txtRepaymentTerm1.getText())){
             JOptionPane.showMessageDialog(null, "Please Enter Numeric Value in Repayment Term");
         }
       else if(jComboBox2.getSelectedIndex()!=-1){
        JOptionPane.showMessageDialog(null, "Please Select Repayment Option from Combo box");
         }
         else if(!Pattern.matches("^\\d+", txtLoanAmount1.getText())){
             JOptionPane.showMessageDialog(null, "Please Enter Numeric Value in Loan Amount");
         }
            else if(!Pattern.matches("^\\d+", txtRateofInterest1.getText())){
             JOptionPane.showMessageDialog(null, "Please Enter Numeric Value in Rate of Interest");
         }
        else if(txtCurrentEmployerAddress1.getText().equals("")){
             JOptionPane.showMessageDialog(null, "Please Enter Current Employer & Address");
         }
        else if(txtOccupation1.getText().equals("")){
             JOptionPane.showMessageDialog(null, "Please Enter Occupation");
         }
        else if(!Pattern.matches("^\\d+", txtAnnulGrossIncome1.getText())){
             JOptionPane.showMessageDialog(null, "Please Enter Numeric Value in Annual Gross Income");
         }
        else{
            
        try{
            for (Customer c : enterprise.getCustomerDirectory().getCustomerList()) {
                  if (c.getAccountNumber() == Integer.parseInt(txtAccountNumber.getText())) {
        int LoanAmount =Integer.parseInt(txtLoanAmount1.getText());
          int RepaymentTerm =Integer.parseInt(txtRepaymentTerm1.getText());
          String LoanPurpose = txtLoanPurpose.getText();
          double RateOfInterest=Double.parseDouble(txtRateofInterest1.getText());
          String CurrentEmployerName=txtCurrentEmployerAddress1.getText();
          String Occupation=txtOccupation1.getText();
          int AnnualGrossIncome =Integer.parseInt(txtAnnulGrossIncome1.getText());
          
           SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
           String date1  = dateFormat.format(new Date()); 
           String repaymentOption = jComboBox2.getSelectedItem().toString();
          c.getCommercialLoanDirectory().addCommercialLoan(LoanAmount, RepaymentTerm, repaymentOption, LoanPurpose, RateOfInterest, CurrentEmployerName, Occupation, AnnualGrossIncome, date1, date1, date1);
        
        
        
         
         JOptionPane.showMessageDialog(null, "Commercial Loan request send to Loan Department");
                  }
            }
                        }
                        catch(Exception e){
                        
                        }
                        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
         txtLoanAmount1.setText("");
     txtRepaymentTerm1.setText("");
     txtLoanPurpose.setText("");
     
     txtRateofInterest1.setText("");
     txtCurrentEmployerAddress1.setText("");
     txtOccupation1.setText("");
     txtAnnulGrossIncome1.setText("");
     txtAccountno.setText("");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        // TODO add your handling code here:
        MessageFormat header = new MessageFormat("Transaction History");
        MessageFormat footer = new MessageFormat("Page{0,number,integer}");
        
        try{
            tblTransactionHistory1.print(JTable.PrintMode.NORMAL,header,footer);
            
        }
        catch(java.awt.print.PrinterException e){
            System.err.format("Cannot Print",e.getMessage());
        }
    }//GEN-LAST:event_btnPrintActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnProcessRequest;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnTransfer2;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private com.toedter.calendar.JDateChooser jDateChooser5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblCustomerName;
    private javax.swing.JButton requestTestJButton;
    private javax.swing.JTable tblTransactionHistory1;
    private javax.swing.JTextField txtAccountNumber;
    private javax.swing.JTextField txtAccountNumber3;
    private javax.swing.JTextField txtAccountno;
    private javax.swing.JTextField txtAccountno1;
    private javax.swing.JTextField txtAccountno2;
    private javax.swing.JTextField txtAccountno3;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtAddress1;
    private javax.swing.JTextField txtAddress11;
    private javax.swing.JTextField txtAddress2;
    private javax.swing.JTextField txtAddress3;
    private javax.swing.JTextField txtAmount2;
    private javax.swing.JTextField txtAnnulGrossIncome;
    private javax.swing.JTextField txtAnnulGrossIncome1;
    private javax.swing.JTextField txtAnnulGrossIncome2;
    private javax.swing.JTextField txtAnnulGrossIncome3;
    private javax.swing.JTextField txtBalance;
    private javax.swing.JTextField txtBranchName;
    private javax.swing.JTextField txtBrand;
    private javax.swing.JTextField txtCourseDuration;
    private javax.swing.JTextField txtCourseName;
    private javax.swing.JTextField txtCurrentEmployerAddress;
    private javax.swing.JTextField txtCurrentEmployerAddress1;
    private javax.swing.JTextField txtCurrentEmployerAddress2;
    private javax.swing.JTextField txtCurrentEmployerAddress3;
    private javax.swing.JTextField txtEmailAddress;
    private javax.swing.JTextField txtHouseAddress;
    private javax.swing.JTextField txtLoanAmount;
    private javax.swing.JTextField txtLoanAmount1;
    private javax.swing.JTextField txtLoanAmount2;
    private javax.swing.JTextField txtLoanAmount3;
    private javax.swing.JTextField txtLoanPurpose;
    private javax.swing.JTextField txtMobileNumber;
    private javax.swing.JTextField txtMobileNumber1;
    private javax.swing.JTextField txtMobileNumber11;
    private javax.swing.JTextField txtMobileNumber2;
    private javax.swing.JTextField txtMobileNumber3;
    private javax.swing.JTextField txtModel;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtName1;
    private javax.swing.JTextField txtName2;
    private javax.swing.JTextField txtName3;
    private javax.swing.JTextField txtName4;
    private javax.swing.JTextField txtOccupation;
    private javax.swing.JTextField txtOccupation1;
    private javax.swing.JTextField txtOccupation2;
    private javax.swing.JTextField txtOccupation3;
    private javax.swing.JTextField txtRateofInterest;
    private javax.swing.JTextField txtRateofInterest1;
    private javax.swing.JTextField txtRateofInterest2;
    private javax.swing.JTextField txtRateofInterest3;
    private javax.swing.JTextField txtRepaymentTerm;
    private javax.swing.JTextField txtRepaymentTerm1;
    private javax.swing.JTextField txtRepaymentTerm2;
    private javax.swing.JTextField txtRepaymentTerm3;
    private javax.swing.JTextField txtRoutingNumber;
    private javax.swing.JTextField txtSSN;
    private javax.swing.JTextField txtSSN1;
    private javax.swing.JTextField txtSSN2;
    private javax.swing.JTextField txtSSN3;
    private javax.swing.JTextField txtSSNNumber11;
    private javax.swing.JTextField txtSwiftCode;
    private javax.swing.JTextField txtTransferAccountName;
    private javax.swing.JTextField txtTransferAccountNumber2;
    private javax.swing.JTextField txtUniversityAddress;
    private javax.swing.JTextField txtUniversityName;
    private javax.swing.JTextField txtVehicleCondition;
    private javax.swing.JTextField txtVehicleType;
    private javax.swing.JTable workRequestJTable1;
    // End of variables declaration//GEN-END:variables
}
