/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterfaceEmployee;

import Business.Activity.Activity;
import Business.Business;
import Business.CommercialLoan.CommercialLoan;
import Business.Customer.Customer;
import Business.EducationLoan.EducationLoan;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.HouseLoan.HouseLoan;
import Business.Organization.Organization;
import Business.Session.SessionLog;
import Business.Transaction.Transaction;
import Business.UserAccount.UserAccount;
import Business.VehicleLoan.VehicleLoan;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class LoanDepartmentJPanel extends javax.swing.JPanel {
private JPanel userProcessContainer;
   private Business business;
   private UserAccount userAccount;
   private Organization organization;
   private Enterprise enterprise;
   private Employee employee;
   private SessionLog session;
    /**
     * Creates new form LoanDepartmentJPanel
     */
    public LoanDepartmentJPanel(JPanel upc,UserAccount ua,Organization o,Enterprise e,SessionLog s) {
        initComponents();
        this.userProcessContainer= upc;
        this.userAccount=ua;
        this.organization=o;
        this.enterprise=e;
        this.session = s;
        populateCommercialTable();
        populateEducationTable();
        populateHouseTable();
        populateVehicleTable();
         Activity a= session.getActivityDirectory().addActivity();
     a.setActivityTime(new Date());
     a.setjPanelName("LoanDepartmentJPanel");
           for(Employee em: enterprise.getEmployeeDirectory().getEmployeeList())
        if(ua.getEmployee().getName().equals(em.getName()))
        {
            employee=em;
            lblEmployeeName.setText(employee.getName());
            txtName1.setText(em.getName());
            txtAddress1.setText(em.getAddress());
            jDateChooser5.setDate(em.getDateOfBirth());
            txtSSN1.setText(Integer.toString(em.getSsnNumber()));
            txtMobileNumber1.setText(Integer.toString(em.getMobileNumber()));
            txtEmailId.setText(em.getEmailAddress());
            return;
        
        }
           
    }
    private void populateVehicleTable(){
        DefaultTableModel model = (DefaultTableModel) tblVehicleLoanRequest.getModel();
        model.setRowCount(0);
           for (Customer c : enterprise.getCustomerDirectory().getCustomerList()) {
        for(VehicleLoan vl: c.getVehicleLoanDirectory().getVehicleLoanList()){
            Object[] row = new Object[5];
            row[0] = c;
            row[1] = vl.getDate();
            row[2] = c.getSsnNumber();
            row[3] = vl.getLoanAmount();
            row[4] = vl.getStatus();
            
            model.addRow(row);
        }
    }
    }
    private void populateEducationTable(){
        DefaultTableModel model = (DefaultTableModel) tblEducationLoan.getModel();
        model.setRowCount(0);
           for (Customer c : enterprise.getCustomerDirectory().getCustomerList()) {
        for(EducationLoan el: c.getEducationLoanDirectory().getEductaionLoanList()){
            Object[] row = new Object[5];
            row[0] = c;
            row[1] = el.getDate();
            row[2] = c.getSsnNumber();
            row[3] = el.getLoanAmount();
            row[4] = el.getStatus();
            model.addRow(row);
        }
           }
    }
       private void populateHouseTable(){
        DefaultTableModel model = (DefaultTableModel) tblHouseLoan.getModel();
        model.setRowCount(0);
           for (Customer c : enterprise.getCustomerDirectory().getCustomerList()) {
        for(HouseLoan hl: c.getHouseLoanDirectory().getHouseLoanList()){
            Object[] row = new Object[5];
            row[0] = c;
            row[1] = hl.getDate();
            row[2] = c.getSsnNumber();
            row[3] = hl.getLoanAmount();
            row[4] = hl.getStatus();
            model.addRow(row);
        }
    }
       }
        private void populateCommercialTable(){
        DefaultTableModel model = (DefaultTableModel) tblCommercialLoan.getModel();
        model.setRowCount(0);
           for (Customer c : enterprise.getCustomerDirectory().getCustomerList()) {
        for(CommercialLoan cl: c.getCommercialLoanDirectory().getCommercialLoanList()){
            Object[] row = new Object[5];
            row[0] = c;
            row[1] = cl.getDate();
            row[2] = c.getSsnNumber();
            row[3] = cl.getLoanAmount();
            row[4] = cl.getStatus();
            model.addRow(row);
        }
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

        jLabel4 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblVehicleLoanRequest = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        txtRateofInterest = new javax.swing.JTextField();
        txtModel = new javax.swing.JTextField();
        txtBrand = new javax.swing.JTextField();
        txtVehicleType = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        txtRepaymentTerm = new javax.swing.JTextField();
        txtLoanAmount = new javax.swing.JTextField();
        txtVehicleCondition = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        btnReject = new javax.swing.JButton();
        btnProcessLoan = new javax.swing.JButton();
        txtAnnulGrossIncome = new javax.swing.JTextField();
        txtOccupation = new javax.swing.JTextField();
        txtCurrentEmployerAddress = new javax.swing.JTextField();
        txtSSN = new javax.swing.JTextField();
        txtMobileNumber = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        btnViewRequest = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel36 = new javax.swing.JLabel();
        txtAccountno = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblEducationLoan = new javax.swing.JTable();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        txtLoanAmount3 = new javax.swing.JTextField();
        txtRepaymentTerm3 = new javax.swing.JTextField();
        jComboBox4 = new javax.swing.JComboBox<>();
        txtRateofInterest3 = new javax.swing.JTextField();
        txtUniversityName = new javax.swing.JTextField();
        txtUniversityAddress = new javax.swing.JTextField();
        txtCourseDuration = new javax.swing.JTextField();
        jLabel79 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        txtCourseName = new javax.swing.JTextField();
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
        btnViewRequest2 = new javax.swing.JButton();
        btnProcessLoan1 = new javax.swing.JButton();
        btnRejectRequest = new javax.swing.JButton();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel40 = new javax.swing.JLabel();
        txtAccountno1 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblHouseLoan = new javax.swing.JTable();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        txtName4 = new javax.swing.JTextField();
        txtAddress4 = new javax.swing.JTextField();
        txtMobileNumber4 = new javax.swing.JTextField();
        txtSSN4 = new javax.swing.JTextField();
        txtCurrentEmployerAddress4 = new javax.swing.JTextField();
        txtOccupation4 = new javax.swing.JTextField();
        txtAnnulGrossIncome4 = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        txtHouseAddress = new javax.swing.JTextField();
        txtRateofInterest2 = new javax.swing.JTextField();
        jComboBox3 = new javax.swing.JComboBox<>();
        txtRepaymentTerm2 = new javax.swing.JTextField();
        txtLoanAmount2 = new javax.swing.JTextField();
        btnViewHouseLoanRequest = new javax.swing.JButton();
        btnProcessLoan2 = new javax.swing.JButton();
        btnRejectHL = new javax.swing.JButton();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jLabel41 = new javax.swing.JLabel();
        txtAccountno2 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblCommercialLoan = new javax.swing.JTable();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        txtAnnulGrossIncome5 = new javax.swing.JTextField();
        txtOccupation5 = new javax.swing.JTextField();
        txtCurrentEmployerAddress5 = new javax.swing.JTextField();
        txtSSN5 = new javax.swing.JTextField();
        txtMobileNumber5 = new javax.swing.JTextField();
        txtAddress5 = new javax.swing.JTextField();
        txtName5 = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        txtLoanAmount1 = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        txtLoanPurpose = new javax.swing.JTextField();
        txtRepaymentTerm1 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        txtRateofInterest1 = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        btnViewRequestCL = new javax.swing.JButton();
        btnProcessLoan3 = new javax.swing.JButton();
        btnRejectCL = new javax.swing.JButton();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jLabel42 = new javax.swing.JLabel();
        txtAccountno3 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        workRequestJTable6 = new javax.swing.JTable();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        requestTestJButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        txtEmailId = new javax.swing.JTextField();
        txtSSN1 = new javax.swing.JTextField();
        txtMobileNumber1 = new javax.swing.JTextField();
        txtAddress1 = new javax.swing.JTextField();
        jDateChooser5 = new com.toedter.calendar.JDateChooser();
        txtName1 = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        lblEmployeeName = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setIcon(new javax.swing.ImageIcon("/siddharth/Info 5100/Project/src/UserInterface/Screen Shot 2016-03-30 at 11.20.59 AM.png")); // NOI18N

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setForeground(new java.awt.Color(0, 102, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tblVehicleLoanRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Customer Name", "Date", "SSN No.", "Loan Amount", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(tblVehicleLoanRequest);

        jLabel11.setForeground(new java.awt.Color(0, 102, 204));
        jLabel11.setText("Vehicle Information:-");

        jLabel38.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 102, 204));
        jLabel38.setText("Vehicle Condition");

        jLabel12.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 204));
        jLabel12.setText("Loan Amount");

        jLabel13.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 204));
        jLabel13.setText("Repayment Term (In Months)");

        jLabel14.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 102, 204));
        jLabel14.setText("Repayment Option");

        jLabel15.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 102, 255));
        jLabel15.setText("Vehicle Type");

        jLabel16.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 102, 255));
        jLabel16.setText("Brand");

        jLabel17.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 102, 255));
        jLabel17.setText("Model");

        jLabel37.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 102, 255));
        jLabel37.setText("Rate Of Interest");

        txtRateofInterest.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtRateofInterest.setForeground(new java.awt.Color(0, 102, 255));

        txtModel.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtModel.setForeground(new java.awt.Color(0, 102, 255));

        txtBrand.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtBrand.setForeground(new java.awt.Color(0, 102, 255));

        txtVehicleType.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtVehicleType.setForeground(new java.awt.Color(0, 102, 255));

        jComboBox1.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(0, 102, 204));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Please Select Repayment Option", "Cash", "Automatic Transfer", "Payroll Deduction" }));

        txtRepaymentTerm.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtRepaymentTerm.setForeground(new java.awt.Color(0, 102, 255));

        txtLoanAmount.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtLoanAmount.setForeground(new java.awt.Color(0, 102, 255));

        txtVehicleCondition.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtVehicleCondition.setForeground(new java.awt.Color(0, 102, 255));

        jLabel18.setForeground(new java.awt.Color(0, 102, 204));
        jLabel18.setText("Applicant Information:-");

        jLabel27.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 102, 204));
        jLabel27.setText("Name");

        jLabel28.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 102, 204));
        jLabel28.setText("Date of Birth");

        jLabel29.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 102, 204));
        jLabel29.setText("Address");

        jLabel31.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 102, 204));
        jLabel31.setText("Mobile No.");

        jLabel32.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 102, 204));
        jLabel32.setText("SSN no.");

        jLabel33.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 102, 204));
        jLabel33.setText("Current Employer & Address");

        jLabel34.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 102, 204));
        jLabel34.setText("Occupation");

        jLabel35.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 102, 204));
        jLabel35.setText("Annual Gross Income");

        btnReject.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        btnReject.setForeground(new java.awt.Color(0, 102, 204));
        btnReject.setIcon(new javax.swing.ImageIcon("/siddharth/Info 5100/Project/src/UserInterfaceCustomer/Screen Shot 2016-03-31 at 9.39.06 PM.png")); // NOI18N
        btnReject.setText("Reject");
        btnReject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRejectActionPerformed(evt);
            }
        });

        btnProcessLoan.setForeground(new java.awt.Color(0, 102, 204));
        btnProcessLoan.setText("Process Request");
        btnProcessLoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessLoanActionPerformed(evt);
            }
        });

        txtAnnulGrossIncome.setEditable(false);
        txtAnnulGrossIncome.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtAnnulGrossIncome.setForeground(new java.awt.Color(0, 102, 255));

        txtOccupation.setEditable(false);
        txtOccupation.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtOccupation.setForeground(new java.awt.Color(0, 102, 255));

        txtCurrentEmployerAddress.setEditable(false);
        txtCurrentEmployerAddress.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtCurrentEmployerAddress.setForeground(new java.awt.Color(0, 102, 255));

        txtSSN.setEditable(false);
        txtSSN.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtSSN.setForeground(new java.awt.Color(0, 102, 255));

        txtMobileNumber.setEditable(false);
        txtMobileNumber.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtMobileNumber.setForeground(new java.awt.Color(0, 102, 255));

        txtAddress.setEditable(false);
        txtAddress.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtAddress.setForeground(new java.awt.Color(0, 102, 255));

        txtName.setEditable(false);
        txtName.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtName.setForeground(new java.awt.Color(0, 102, 255));

        btnViewRequest.setForeground(new java.awt.Color(0, 102, 204));
        btnViewRequest.setText("View Request");
        btnViewRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewRequestActionPerformed(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 102, 204));
        jLabel36.setText("Account Number");

        txtAccountno.setEditable(false);
        txtAccountno.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtAccountno.setForeground(new java.awt.Color(0, 102, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel13)
                        .addComponent(jLabel12)
                        .addComponent(jLabel14)
                        .addComponent(jLabel15)
                        .addComponent(jLabel16)
                        .addComponent(jLabel17)
                        .addComponent(jLabel37)
                        .addComponent(jLabel38))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(68, 68, 68)))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLoanAmount)
                    .addComponent(txtRepaymentTerm)
                    .addComponent(txtVehicleType)
                    .addComponent(txtBrand)
                    .addComponent(txtModel)
                    .addComponent(txtRateofInterest)
                    .addComponent(txtVehicleCondition, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel33)
                                    .addComponent(jLabel34)
                                    .addComponent(jLabel35))
                                .addGap(44, 44, 44)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCurrentEmployerAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                    .addComponent(txtOccupation, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                    .addComponent(txtAnnulGrossIncome, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel28)
                                    .addComponent(jLabel29)
                                    .addComponent(jLabel31)
                                    .addComponent(jLabel32)
                                    .addComponent(jLabel36))
                                .addGap(113, 113, 113)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtAccountno)
                                    .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                    .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                    .addComponent(txtMobileNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                    .addComponent(txtSSN, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(150, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 697, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnViewRequest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnProcessLoan, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnReject, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(219, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnViewRequest)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnProcessLoan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReject, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(txtVehicleCondition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtLoanAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel28))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtRepaymentTerm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtVehicleType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jLabel11))
                        .addGap(76, 76, 76)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(txtMobileNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(txtSSN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(txtBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtAccountno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel36)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txtModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel37)
                            .addComponent(txtRateofInterest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(184, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(txtCurrentEmployerAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34)
                            .addComponent(txtOccupation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(txtAnnulGrossIncome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(125, 125, 125))))
        );

        jTabbedPane1.addTab("Vehicle Loan Requests", jPanel2);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        tblEducationLoan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Date", "Customer Name", "SSN No.", "Loan Amount", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblEducationLoan);

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

        jLabel77.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(0, 102, 255));
        jLabel77.setText("University Address");

        txtLoanAmount3.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtLoanAmount3.setForeground(new java.awt.Color(0, 102, 255));

        txtRepaymentTerm3.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtRepaymentTerm3.setForeground(new java.awt.Color(0, 102, 255));

        jComboBox4.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jComboBox4.setForeground(new java.awt.Color(0, 102, 204));
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Please Select Repayment Option", "Cash", "Automatic Transfer", "Payroll Deduction" }));

        txtRateofInterest3.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtRateofInterest3.setForeground(new java.awt.Color(0, 102, 255));

        txtUniversityName.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtUniversityName.setForeground(new java.awt.Color(0, 102, 255));

        txtUniversityAddress.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtUniversityAddress.setForeground(new java.awt.Color(0, 102, 255));

        txtCourseDuration.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtCourseDuration.setForeground(new java.awt.Color(0, 102, 255));

        jLabel79.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(0, 102, 255));
        jLabel79.setText("Course Duration");

        jLabel78.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(0, 102, 255));
        jLabel78.setText("Course Name");

        txtCourseName.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtCourseName.setForeground(new java.awt.Color(0, 102, 255));

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

        txtAnnulGrossIncome3.setEditable(false);
        txtAnnulGrossIncome3.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtAnnulGrossIncome3.setForeground(new java.awt.Color(0, 102, 255));

        txtOccupation3.setEditable(false);
        txtOccupation3.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtOccupation3.setForeground(new java.awt.Color(0, 102, 255));

        txtCurrentEmployerAddress3.setEditable(false);
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

        btnViewRequest2.setForeground(new java.awt.Color(0, 102, 204));
        btnViewRequest2.setText("View Request");
        btnViewRequest2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewRequest2ActionPerformed(evt);
            }
        });

        btnProcessLoan1.setForeground(new java.awt.Color(0, 102, 204));
        btnProcessLoan1.setText("Process Request");
        btnProcessLoan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessLoan1ActionPerformed(evt);
            }
        });

        btnRejectRequest.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        btnRejectRequest.setForeground(new java.awt.Color(0, 102, 204));
        btnRejectRequest.setIcon(new javax.swing.ImageIcon("/siddharth/Info 5100/Project/src/UserInterfaceCustomer/Screen Shot 2016-03-31 at 9.39.06 PM.png")); // NOI18N
        btnRejectRequest.setText("Reject");
        btnRejectRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRejectRequestActionPerformed(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(0, 102, 204));
        jLabel40.setText("Account Number");

        txtAccountno1.setEditable(false);
        txtAccountno1.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtAccountno1.setForeground(new java.awt.Color(0, 102, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(205, 205, 205)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnViewRequest2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnProcessLoan1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnRejectRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(225, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel71)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel72)
                                .addGap(118, 118, 118)
                                .addComponent(txtLoanAmount3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel74)
                                    .addComponent(jLabel73)
                                    .addComponent(jLabel75)
                                    .addComponent(jLabel76)
                                    .addComponent(jLabel77)
                                    .addComponent(jLabel78)
                                    .addComponent(jLabel79))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtRepaymentTerm3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtRateofInterest3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtUniversityName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtUniversityAddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtCourseName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtCourseDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 212, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel80)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel81)
                            .addComponent(jLabel82)
                            .addComponent(jLabel83)
                            .addComponent(jLabel84)
                            .addComponent(jLabel85)
                            .addComponent(jLabel86)
                            .addComponent(jLabel87)
                            .addComponent(jLabel88)
                            .addComponent(jLabel40))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtName3, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(txtAddress3, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(txtMobileNumber3, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(txtSSN3, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(txtCurrentEmployerAddress3, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(txtOccupation3, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(txtAnnulGrossIncome3, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtAccountno1, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(86, 86, 86))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnViewRequest2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnProcessLoan1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRejectRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel71)
                                .addGap(169, 169, 169)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtRateofInterest3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel75))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtUniversityName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel76)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtLoanAmount3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel72))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtRepaymentTerm3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel73))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel74))
                                .addGap(92, 92, 92)))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel77)
                            .addComponent(txtUniversityAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel78)
                            .addComponent(txtCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel79)
                            .addComponent(txtCourseDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(155, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel81)
                                    .addComponent(txtName3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addComponent(jLabel82))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel80)
                                .addGap(76, 76, 76)
                                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel83)
                                    .addComponent(txtAddress3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel84)
                                    .addComponent(txtMobileNumber3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel85)
                                    .addComponent(txtSSN3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtAccountno1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel40)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel86)
                                    .addComponent(txtCurrentEmployerAddress3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel87)
                            .addComponent(txtOccupation3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel88)
                            .addComponent(txtAnnulGrossIncome3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(136, 136, 136))))
        );

        jTabbedPane1.addTab("Education Loan Requests", jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        tblHouseLoan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Date", "Customer Name", "SSN No.", "Loan Amount", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblHouseLoan);

        jLabel90.setForeground(new java.awt.Color(0, 102, 204));
        jLabel90.setText("Applicant Information:-");

        jLabel91.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel91.setForeground(new java.awt.Color(0, 102, 204));
        jLabel91.setText("Name");

        jLabel92.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(0, 102, 204));
        jLabel92.setText("Date of Birth");

        jLabel93.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel93.setForeground(new java.awt.Color(0, 102, 204));
        jLabel93.setText("Address");

        jLabel94.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(0, 102, 204));
        jLabel94.setText("Mobile No.");

        jLabel95.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel95.setForeground(new java.awt.Color(0, 102, 204));
        jLabel95.setText("SSN no.");

        jLabel96.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(0, 102, 204));
        jLabel96.setText("Current Employer & Address");

        jLabel97.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel97.setForeground(new java.awt.Color(0, 102, 204));
        jLabel97.setText("Occupation");

        jLabel98.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(0, 102, 204));
        jLabel98.setText("Annual Gross Income");

        txtName4.setEditable(false);
        txtName4.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtName4.setForeground(new java.awt.Color(0, 102, 255));

        txtAddress4.setEditable(false);
        txtAddress4.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtAddress4.setForeground(new java.awt.Color(0, 102, 255));

        txtMobileNumber4.setEditable(false);
        txtMobileNumber4.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtMobileNumber4.setForeground(new java.awt.Color(0, 102, 255));

        txtSSN4.setEditable(false);
        txtSSN4.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtSSN4.setForeground(new java.awt.Color(0, 102, 255));

        txtCurrentEmployerAddress4.setEditable(false);
        txtCurrentEmployerAddress4.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtCurrentEmployerAddress4.setForeground(new java.awt.Color(0, 102, 255));

        txtOccupation4.setEditable(false);
        txtOccupation4.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtOccupation4.setForeground(new java.awt.Color(0, 102, 255));

        txtAnnulGrossIncome4.setEditable(false);
        txtAnnulGrossIncome4.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtAnnulGrossIncome4.setForeground(new java.awt.Color(0, 102, 255));

        jLabel55.setForeground(new java.awt.Color(0, 102, 204));
        jLabel55.setText("Loan Information:-");

        jLabel56.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(0, 102, 204));
        jLabel56.setText("Loan Amount");

        jLabel58.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(0, 102, 204));
        jLabel58.setText("Repayment Term (In Months)");

        jLabel59.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(0, 102, 204));
        jLabel59.setText("Repayment Option");

        jLabel60.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(0, 102, 255));
        jLabel60.setText("Rate Of Interest");

        jLabel57.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(0, 102, 255));
        jLabel57.setText("House Address");

        txtHouseAddress.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtHouseAddress.setForeground(new java.awt.Color(0, 102, 255));

        txtRateofInterest2.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtRateofInterest2.setForeground(new java.awt.Color(0, 102, 255));

        jComboBox3.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jComboBox3.setForeground(new java.awt.Color(0, 102, 204));
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Please Select Repayment Option", "Cash", "Automatic Transfer", "Payroll Deduction" }));

        txtRepaymentTerm2.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtRepaymentTerm2.setForeground(new java.awt.Color(0, 102, 255));

        txtLoanAmount2.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtLoanAmount2.setForeground(new java.awt.Color(0, 102, 255));

        btnViewHouseLoanRequest.setForeground(new java.awt.Color(0, 102, 204));
        btnViewHouseLoanRequest.setText("View Request");
        btnViewHouseLoanRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewHouseLoanRequestActionPerformed(evt);
            }
        });

        btnProcessLoan2.setForeground(new java.awt.Color(0, 102, 204));
        btnProcessLoan2.setText("Process Request");
        btnProcessLoan2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessLoan2ActionPerformed(evt);
            }
        });

        btnRejectHL.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        btnRejectHL.setForeground(new java.awt.Color(0, 102, 204));
        btnRejectHL.setIcon(new javax.swing.ImageIcon("/siddharth/Info 5100/Project/src/UserInterfaceCustomer/Screen Shot 2016-03-31 at 9.39.06 PM.png")); // NOI18N
        btnRejectHL.setText("Cancel");
        btnRejectHL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRejectHLActionPerformed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(0, 102, 204));
        jLabel41.setText("Account Number");

        txtAccountno2.setEditable(false);
        txtAccountno2.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtAccountno2.setForeground(new java.awt.Color(0, 102, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel59)
                            .addComponent(jLabel58)
                            .addComponent(jLabel60)
                            .addComponent(jLabel57)
                            .addComponent(jLabel56))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRepaymentTerm2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRateofInterest2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHouseAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLoanAmount2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel55)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel90)
                        .addGap(279, 279, 279))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel91)
                            .addComponent(jLabel92)
                            .addComponent(jLabel93)
                            .addComponent(jLabel94)
                            .addComponent(jLabel95)
                            .addComponent(jLabel96)
                            .addComponent(jLabel97)
                            .addComponent(jLabel98)
                            .addComponent(jLabel41))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtAccountno2)
                            .addComponent(txtName4, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(txtAddress4, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(txtMobileNumber4, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(txtSSN4, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(txtCurrentEmployerAddress4, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(txtOccupation4, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(txtAnnulGrossIncome4, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(jDateChooser3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(46, 46, 46))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnViewHouseLoanRequest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnProcessLoan2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnRejectHL, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(262, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnViewHouseLoanRequest)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnProcessLoan2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addComponent(btnRejectHL, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel90)
                    .addComponent(jLabel55))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel91)
                            .addComponent(txtName4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLoanAmount2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel56))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel92)
                            .addComponent(txtRepaymentTerm2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel58)))
                    .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel93)
                    .addComponent(txtAddress4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel59))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel94)
                    .addComponent(txtMobileNumber4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRateofInterest2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel60))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel95)
                    .addComponent(txtSSN4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHouseAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel57))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAccountno2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41))
                .addGap(28, 28, 28)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel96)
                    .addComponent(txtCurrentEmployerAddress4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel97)
                    .addComponent(txtOccupation4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel98)
                    .addComponent(txtAnnulGrossIncome4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(145, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("House Loan Requests", jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        tblCommercialLoan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Date", "Customer Name", "SSN No.", "Loan Amount", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tblCommercialLoan);

        jLabel100.setForeground(new java.awt.Color(0, 102, 204));
        jLabel100.setText("Applicant Information:-");

        jLabel101.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel101.setForeground(new java.awt.Color(0, 102, 204));
        jLabel101.setText("Name");

        jLabel102.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel102.setForeground(new java.awt.Color(0, 102, 204));
        jLabel102.setText("Date of Birth");

        jLabel103.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel103.setForeground(new java.awt.Color(0, 102, 204));
        jLabel103.setText("Address");

        jLabel104.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel104.setForeground(new java.awt.Color(0, 102, 204));
        jLabel104.setText("Mobile No.");

        jLabel105.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel105.setForeground(new java.awt.Color(0, 102, 204));
        jLabel105.setText("SSN no.");

        jLabel106.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel106.setForeground(new java.awt.Color(0, 102, 204));
        jLabel106.setText("Current Employer & Address");

        jLabel107.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel107.setForeground(new java.awt.Color(0, 102, 204));
        jLabel107.setText("Occupation");

        jLabel108.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel108.setForeground(new java.awt.Color(0, 102, 204));
        jLabel108.setText("Annual Gross Income");

        txtAnnulGrossIncome5.setEditable(false);
        txtAnnulGrossIncome5.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtAnnulGrossIncome5.setForeground(new java.awt.Color(0, 102, 255));

        txtOccupation5.setEditable(false);
        txtOccupation5.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtOccupation5.setForeground(new java.awt.Color(0, 102, 255));

        txtCurrentEmployerAddress5.setEditable(false);
        txtCurrentEmployerAddress5.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtCurrentEmployerAddress5.setForeground(new java.awt.Color(0, 102, 255));

        txtSSN5.setEditable(false);
        txtSSN5.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtSSN5.setForeground(new java.awt.Color(0, 102, 255));

        txtMobileNumber5.setEditable(false);
        txtMobileNumber5.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtMobileNumber5.setForeground(new java.awt.Color(0, 102, 255));

        txtAddress5.setEditable(false);
        txtAddress5.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtAddress5.setForeground(new java.awt.Color(0, 102, 255));

        txtName5.setEditable(false);
        txtName5.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtName5.setForeground(new java.awt.Color(0, 102, 255));

        jLabel49.setForeground(new java.awt.Color(0, 102, 204));
        jLabel49.setText("Loan Information:-");

        jLabel50.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(0, 102, 204));
        jLabel50.setText("Loan Amount");

        txtLoanAmount1.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtLoanAmount1.setForeground(new java.awt.Color(0, 102, 255));

        jLabel54.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(0, 102, 255));
        jLabel54.setText("Loan's Purpose");

        txtLoanPurpose.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtLoanPurpose.setForeground(new java.awt.Color(0, 102, 255));

        txtRepaymentTerm1.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtRepaymentTerm1.setForeground(new java.awt.Color(0, 102, 255));

        jComboBox2.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jComboBox2.setForeground(new java.awt.Color(0, 102, 204));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Please Select Repayment Option", "Cash", "Automatic Transfer", "Payroll Deduction" }));

        txtRateofInterest1.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtRateofInterest1.setForeground(new java.awt.Color(0, 102, 255));

        jLabel53.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(0, 102, 255));
        jLabel53.setText("Rate Of Interest");

        jLabel52.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(0, 102, 204));
        jLabel52.setText("Repayment Option");

        jLabel51.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(0, 102, 204));
        jLabel51.setText("Repayment Term (In Months)");

        btnViewRequestCL.setForeground(new java.awt.Color(0, 102, 204));
        btnViewRequestCL.setText("View Request");
        btnViewRequestCL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewRequestCLActionPerformed(evt);
            }
        });

        btnProcessLoan3.setForeground(new java.awt.Color(0, 102, 204));
        btnProcessLoan3.setText("Process Request");
        btnProcessLoan3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessLoan3ActionPerformed(evt);
            }
        });

        btnRejectCL.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        btnRejectCL.setForeground(new java.awt.Color(0, 102, 204));
        btnRejectCL.setIcon(new javax.swing.ImageIcon("/siddharth/Info 5100/Project/src/UserInterfaceCustomer/Screen Shot 2016-03-31 at 9.39.06 PM.png")); // NOI18N
        btnRejectCL.setText("Cancel");
        btnRejectCL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRejectCLActionPerformed(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(0, 102, 204));
        jLabel42.setText("Account Number");

        txtAccountno3.setEditable(false);
        txtAccountno3.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtAccountno3.setForeground(new java.awt.Color(0, 102, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnViewRequestCL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnProcessLoan3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnRejectCL, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(250, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel49)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel52)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel51)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                .addComponent(txtRepaymentTerm1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel54)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtLoanPurpose, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel50)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtLoanAmount1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel53)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtRateofInterest1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 225, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel100)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel101)
                                    .addComponent(jLabel102)
                                    .addComponent(jLabel103)
                                    .addComponent(jLabel104)
                                    .addComponent(jLabel105))
                                .addGap(137, 137, 137)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtName5, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                    .addComponent(txtAddress5, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                    .addComponent(txtMobileNumber5, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                    .addComponent(txtSSN5, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                    .addComponent(jDateChooser4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel106)
                                    .addComponent(jLabel107)
                                    .addComponent(jLabel108))
                                .addGap(44, 44, 44)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCurrentEmployerAddress5, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                    .addComponent(txtOccupation5, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                    .addComponent(txtAnnulGrossIncome5, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel42)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtAccountno3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(42, 42, 42))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnViewRequestCL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnProcessLoan3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRejectCL, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel100)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel49)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtLoanAmount1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel50)
                            .addComponent(jLabel101)
                            .addComponent(txtName5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtLoanPurpose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel54)
                                .addComponent(jLabel102))
                            .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRepaymentTerm1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel51)
                            .addComponent(jLabel103)
                            .addComponent(txtAddress5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel52)
                            .addComponent(jLabel104)
                            .addComponent(txtMobileNumber5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel53)
                            .addComponent(txtRateofInterest1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel105)
                            .addComponent(txtSSN5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAccountno3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel108)
                            .addComponent(txtAnnulGrossIncome5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCurrentEmployerAddress5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel106))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel107)
                            .addComponent(txtOccupation5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(116, 116, 116))
        );

        jTabbedPane1.addTab("Commercial Loan Requests", jPanel6);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        workRequestJTable6.setForeground(new java.awt.Color(0, 102, 204));
        workRequestJTable6.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane7.setViewportView(workRequestJTable6);

        jLabel24.setForeground(new java.awt.Color(0, 102, 204));
        jLabel24.setText("Message");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane8.setViewportView(jTextArea2);

        requestTestJButton1.setForeground(new java.awt.Color(0, 102, 204));
        requestTestJButton1.setText("Request Test");
        requestTestJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestTestJButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(281, 281, 281)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(requestTestJButton1)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addGap(13, 13, 13)
                            .addComponent(jLabel24)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(502, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel24))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addComponent(requestTestJButton1)
                .addContainerGap(370, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Contact HR team", jPanel3);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel19.setForeground(new java.awt.Color(0, 102, 204));
        jLabel19.setText("Name");

        jLabel20.setForeground(new java.awt.Color(0, 102, 204));
        jLabel20.setText("Date of Birth");

        jLabel21.setForeground(new java.awt.Color(0, 102, 204));
        jLabel21.setText("Address");

        jLabel22.setForeground(new java.awt.Color(0, 102, 204));
        jLabel22.setText("Mobile No.");

        jLabel30.setForeground(new java.awt.Color(0, 102, 204));
        jLabel30.setText("SSN no.");

        jLabel39.setForeground(new java.awt.Color(0, 102, 204));
        jLabel39.setText("Email Id");

        txtEmailId.setForeground(new java.awt.Color(0, 102, 204));

        txtSSN1.setForeground(new java.awt.Color(0, 102, 204));

        txtMobileNumber1.setForeground(new java.awt.Color(0, 102, 204));

        txtAddress1.setForeground(new java.awt.Color(0, 102, 204));

        txtName1.setEditable(false);
        txtName1.setForeground(new java.awt.Color(0, 102, 204));

        btnUpdate.setForeground(new java.awt.Color(0, 102, 204));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnSave.setForeground(new java.awt.Color(0, 102, 204));
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(292, 292, 292)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUpdate))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22)
                            .addComponent(jLabel30)
                            .addComponent(jLabel39))
                        .addGap(79, 79, 79)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMobileNumber1)
                            .addComponent(txtAddress1)
                            .addComponent(txtName1)
                            .addComponent(txtSSN1)
                            .addComponent(txtEmailId)
                            .addComponent(jDateChooser5, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(536, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel20)
                    .addComponent(jDateChooser5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtAddress1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtMobileNumber1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txtSSN1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(txtEmailId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnUpdate))
                .addContainerGap(262, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("View Profile", jPanel1);

        lblEmployeeName.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        lblEmployeeName.setText("Employee Name");

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 204));
        jLabel1.setText("is Logged in!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(160, 160, 160)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(lblEmployeeName, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmployeeName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        employee.setName(txtName1.getText());
        employee.setAddress(txtAddress1.getText());
        employee.setDateOfBirth(jDateChooser1.getDate());
        employee.setMobileNumber(Integer.parseInt(txtMobileNumber1.getText()));
        employee.setSsnNumber(Integer.parseInt(txtSSN1.getText()));
        employee.setEmailAddress(txtEmailId.getText());

        txtName1.setEditable(false);
        jDateChooser1.setEnabled(false);
        txtAddress1.setEditable(false);
        txtMobileNumber1.setEditable(false);
        txtSSN1.setEditable(false);
        txtEmailId.setEditable(false);
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        txtName1.setEditable(false);
        jDateChooser1.setEnabled(false);
        txtAddress1.setEditable(true);
        txtMobileNumber1.setEditable(true);
        txtSSN1.setEditable(false);
        txtEmailId.setEditable(true);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void requestTestJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestTestJButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_requestTestJButton1ActionPerformed

    private void btnRejectCLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRejectCLActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblCommercialLoan.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null,"Please select Loan Request from the table to reject.");
            return;
        }
         Customer c = (Customer) tblCommercialLoan.getValueAt(selectedRow,0);
        for (CommercialLoan cl: c.getCommercialLoanDirectory().getCommercialLoanList()) {
            c.getCommercialLoanDirectory().removeCommercialLoan(cl);
            txtLoanAmount1.setText("");
            txtRepaymentTerm1.setText("");
            jComboBox2.setSelectedItem("");
            txtLoanPurpose.setText("");
            txtRateofInterest1.setText("");
            txtCurrentEmployerAddress5.setText("");
            txtOccupation5.setText("");
            txtAnnulGrossIncome5.setText("");
            txtAccountno3.setText("");
            txtName5.setText("");
            jDateChooser4.setDate(new Date());
            txtAddress5.setText("");
            txtMobileNumber5.setText("");
            txtSSN5.setText("");
            
        }
       
        populateCommercialTable();
            JOptionPane.showMessageDialog(null, "Commercial Loan Request deleted successfully");
    }//GEN-LAST:event_btnRejectCLActionPerformed

    private void btnViewRequestCLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewRequestCLActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblCommercialLoan.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please Select request from the table");
            return;
        }
         Customer c = (Customer) tblCommercialLoan.getValueAt(selectedRow,0);
        for (CommercialLoan cl: c.getCommercialLoanDirectory().getCommercialLoanList()) {
        txtLoanAmount1.setText(Integer.toString(cl.getLoanAmount()));
        txtRepaymentTerm1.setText(Integer.toString(cl.getRepaymentTerm()));
        jComboBox2.setSelectedItem(cl.getRepaymentOption());
        txtLoanPurpose.setText(cl.getLoanPurpose());
        txtRateofInterest1.setText(Double.toString(cl.getRateOfInterest()));
        txtCurrentEmployerAddress5.setText(cl.getCurrentEmployerName());
        txtOccupation5.setText(cl.getOccupation());
        txtAnnulGrossIncome5.setText(Integer.toString(cl.getAnnualGrossIncome()));
        txtAccountno3.setText(Integer.toString(c.getAccountNumber()));
        txtName5.setText(c.getName());
        jDateChooser4.setDate(c.getDateOfBirth());
        txtAddress5.setText(c.getAddress());
        txtMobileNumber5.setText(Integer.toString(c.getMobileNumber()));
        txtSSN5.setText(Integer.toString(c.getSsnNumber()));
        }
    }//GEN-LAST:event_btnViewRequestCLActionPerformed

    private void btnRejectHLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRejectHLActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblHouseLoan.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null,"Please select Loan Request from the table to reject.");
            return;
        }
         Customer c = (Customer) tblHouseLoan.getValueAt(selectedRow,0);
        for (HouseLoan hl: c.getHouseLoanDirectory().getHouseLoanList()) {
            c.getHouseLoanDirectory().removeHouseLoan(hl);
            txtLoanAmount2.setText("");
            txtRepaymentTerm2.setText("");

            txtHouseAddress.setText("");
            txtRateofInterest2.setText("");
            txtCurrentEmployerAddress4.setText("");
            txtOccupation4.setText("");
            txtAnnulGrossIncome4.setText("");
            txtAccountno2.setText("");
            txtName4.setText("");
            jDateChooser3.setDate(new Date());
            txtAddress4.setText("");
            txtMobileNumber4.setText("");
            txtSSN4.setText("");
            
        }
        
        populateHouseTable();
            JOptionPane.showMessageDialog(null, "House Loan Request deleted successfully");
    }//GEN-LAST:event_btnRejectHLActionPerformed

    private void btnViewHouseLoanRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewHouseLoanRequestActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblHouseLoan.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please Select request from the table");
            return;
        }
      Customer c = (Customer) tblHouseLoan.getValueAt(selectedRow,0);
        for (HouseLoan hl: c.getHouseLoanDirectory().getHouseLoanList()) {
        txtLoanAmount2.setText(Integer.toString(hl.getLoanAmount()));
        txtRepaymentTerm2.setText(Integer.toString(hl.getRepaymentTerm()));
        jComboBox3.setSelectedItem(hl.getRepaymentOption());
        txtHouseAddress.setText(hl.getHouseAddress());
        txtRateofInterest2.setText(Double.toString(hl.getRateOfInterest()));
        txtCurrentEmployerAddress4.setText(hl.getCurrentEmployerName());
        txtOccupation4.setText(hl.getOccupation());
        txtAnnulGrossIncome4.setText(Integer.toString(hl.getAnnualGrossIncome()));
        txtAccountno2.setText(Integer.toString(c.getAccountNumber()));
        txtName4.setText(c.getName());
        jDateChooser3.setDate(c.getDateOfBirth());
        txtAddress4.setText(c.getAddress());
        txtMobileNumber4.setText(Integer.toString(c.getMobileNumber()));
        txtSSN4.setText(Integer.toString(c.getSsnNumber()));
          }
    }//GEN-LAST:event_btnViewHouseLoanRequestActionPerformed

    private void btnRejectRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRejectRequestActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblEducationLoan.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null,"Please select Loan Request from the table to reject.");
            return;
        }
         Customer c = (Customer) tblEducationLoan.getValueAt(selectedRow,0);
        for (EducationLoan el :c.getEducationLoanDirectory().getEductaionLoanList()) {
            c.getEducationLoanDirectory().removeEducationLoan(el);
            txtLoanAmount3.setText("");
            txtRateofInterest3.setText("");
            txtRepaymentTerm3.setText("");
            txtUniversityAddress.setText("");
            txtUniversityName.setText("");
            txtCourseDuration.setText("");
            txtCourseName.setText("");
            txtCurrentEmployerAddress3.setText("");
            txtOccupation3.setText("");
            txtAnnulGrossIncome3.setText("");
            txtAccountno1.setText("");
            txtName3.setText("");
            jDateChooser2.setDate(new Date());
            txtAddress3.setText("");
            txtMobileNumber3.setText("");
            txtSSN3.setText("");
            
        }
        
        populateEducationTable();
            JOptionPane.showMessageDialog(null, "Education Loan Request deleted successfully");
    }//GEN-LAST:event_btnRejectRequestActionPerformed

    private void btnViewRequest2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewRequest2ActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblEducationLoan.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please Select request from the table");
            return;
        }
       Customer c = (Customer) tblEducationLoan.getValueAt(selectedRow,0);
        for (EducationLoan el :c.getEducationLoanDirectory().getEductaionLoanList()) {
        txtLoanAmount3.setText(Integer.toString(el.getLoanAmount()));
        txtRepaymentTerm3.setText(Integer.toString(el.getRepaymentTerm()));
        jComboBox4.setSelectedItem(el.getRepaymentOption());
        txtUniversityAddress.setText(el.getUniversityAddress());
        txtUniversityName.setText(el.getUniversityName());
        txtCourseDuration.setText(el.getCourseDuration());
        txtCourseName.setText(el.getCourseName());
        txtRateofInterest3.setText(Double.toString(el.getRateOfInterest()));
        txtCurrentEmployerAddress3.setText(el.getCurrentEmployerName());
        txtOccupation3.setText(el.getOccupation());
        txtAnnulGrossIncome3.setText(Integer.toString(el.getAnnualGrossIncome()));
        txtAccountno1.setText(Integer.toString(c.getAccountNumber()));
        txtName3.setText(c.getName());
        jDateChooser2.setDate(c.getDateOfBirth());
        txtAddress3.setText(c.getAddress());
        txtMobileNumber3.setText(Integer.toString(c.getMobileNumber()));
        txtSSN3.setText(Integer.toString(c.getSsnNumber()));
          }
    }//GEN-LAST:event_btnViewRequest2ActionPerformed

    private void btnViewRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewRequestActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblVehicleLoanRequest.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please Select request from the table");
            return;
        }
        Customer c = (Customer) tblVehicleLoanRequest.getValueAt(selectedRow,0);
        for (VehicleLoan vl : c.getVehicleLoanDirectory().getVehicleLoanList()) {
             

            txtVehicleCondition.setText(vl.getVehiccleCondition());
            txtLoanAmount.setText(Integer.toString(vl.getLoanAmount()));
            txtRepaymentTerm.setText(Integer.toString(vl.getRepaymentTerm()));
            jComboBox1.setSelectedItem(vl.getRepaymentOption());
            txtVehicleType.setText(vl.getVehicleType());
            txtBrand.setText(vl.getBrand());
            txtModel.setText(vl.getModel());
            txtRateofInterest.setText(Double.toString(vl.getRateOfInterest()));
            txtCurrentEmployerAddress.setText(vl.getCurrentEmployerName());
            txtOccupation.setText(vl.getOccupation());
            txtAnnulGrossIncome.setText(Integer.toString(vl.getAnnualGrossIncome()));
            txtAccountno.setText(Integer.toString(c.getAccountNumber()));
            txtName.setText(c.getName());
            jDateChooser1.setDate(c.getDateOfBirth());
            txtAddress.setText(c.getAddress());
            txtMobileNumber.setText(Integer.toString(c.getMobileNumber()));
            txtSSN.setText(Integer.toString(c.getSsnNumber()));
             
        }
    }//GEN-LAST:event_btnViewRequestActionPerformed

    private void btnProcessLoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessLoanActionPerformed
        // TODO add your handling code here:
               int selectedRow = tblVehicleLoanRequest.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null,"Please select Loan Request from the table to process");
            return;
        }
       Customer c = (Customer) tblVehicleLoanRequest.getValueAt(selectedRow,0);
        for (VehicleLoan vl :c.getVehicleLoanDirectory().getVehicleLoanList()) {
            if (c.getAccountNumber() == Integer.parseInt(txtAccountno.getText())) {
               
                c.setBalance(c.getBalance() + Integer.parseInt(txtLoanAmount.getText()));
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                String date1  = dateFormat.format(new Date());
               c.getTransactionDirectory().addTransaction(new Date(), Integer.parseInt(txtLoanAmount.getText()),0,  Integer.parseInt(txtLoanAmount.getText()), Integer.parseInt(txtAccountno.getText()),c.getBalance() + Integer.parseInt(txtLoanAmount.getText()), c, "Vehicle Loan Credit");
                    vl.setStatus("Completed");
               
            }
        }
       
        populateVehicleTable();
        JOptionPane.showMessageDialog(null, "Loan has been approved");
    }//GEN-LAST:event_btnProcessLoanActionPerformed

    private void btnRejectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRejectActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblVehicleLoanRequest.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null,"Please select Loan Request from the table to reject.");
            return;
        }
       Customer c = (Customer) tblVehicleLoanRequest.getValueAt(selectedRow,0);
        for (VehicleLoan vl :c.getVehicleLoanDirectory().getVehicleLoanList()) {
            c.getVehicleLoanDirectory().removeVehicleLoan(vl);
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
            txtAccountno.setText("");
            txtName.setText("");
            jDateChooser1.setDate(new Date());
            txtAddress.setText("");
            txtMobileNumber.setText("");
            txtSSN.setText("");
            
            
        }
        
        populateVehicleTable();
            JOptionPane.showMessageDialog(null, "Vehicle Loan Request deleted successfully");
    }//GEN-LAST:event_btnRejectActionPerformed

    private void btnProcessLoan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessLoan1ActionPerformed
        // TODO add your handling code here:
             int selectedRow = tblEducationLoan.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null,"Please select Loan Request from the table to process");
            return;
        }  
          Customer c = (Customer) tblEducationLoan.getValueAt(selectedRow,0);
        for (EducationLoan el :c.getEducationLoanDirectory().getEductaionLoanList()) {
            if (c.getAccountNumber() == Integer.parseInt(txtAccountno1.getText())) {
               
                c.setBalance(c.getBalance() + Integer.parseInt(txtLoanAmount3.getText()));
                 SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                String date1  = dateFormat.format(new Date());
               c.getTransactionDirectory().addTransaction(new Date(), Integer.parseInt(txtLoanAmount3.getText()),0,  Integer.parseInt(txtLoanAmount3.getText()), Integer.parseInt(txtAccountno1.getText()),c.getBalance() + Integer.parseInt(txtLoanAmount3.getText()), c, "Credit");
                el.setStatus("Completed");
            }
        }
        
         populateEducationTable();
          JOptionPane.showMessageDialog(null, "Loan has been approved");
    }//GEN-LAST:event_btnProcessLoan1ActionPerformed

    private void btnProcessLoan2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessLoan2ActionPerformed
        // TODO add your handling code here:
             int selectedRow = tblHouseLoan.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null,"Please select Loan Request from the table to process");
            return;
        }  
       Customer c = (Customer) tblHouseLoan.getValueAt(selectedRow,0);
        for (HouseLoan hl: c.getHouseLoanDirectory().getHouseLoanList()) {
            if (c.getAccountNumber() == Integer.parseInt(txtAccountno2.getText())) {
               
                c.setBalance(c.getBalance() + Integer.parseInt(txtLoanAmount2.getText()));
                 SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                String date1  = dateFormat.format(new Date());
               c.getTransactionDirectory().addTransaction(new Date(), Integer.parseInt(txtLoanAmount2.getText()),0,  Integer.parseInt(txtLoanAmount2.getText()), Integer.parseInt(txtAccountno2.getText()),c.getBalance() + Integer.parseInt(txtLoanAmount2.getText()), c, "Credit");
                hl.setStatus("Completed");
            }
        }
    
        populateHouseTable();
         JOptionPane.showMessageDialog(null, "Loan has been approved");
    }//GEN-LAST:event_btnProcessLoan2ActionPerformed

    private void btnProcessLoan3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessLoan3ActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblCommercialLoan.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null,"Please select Loan Request from the table to process");
            return;
        }  
         Customer c = (Customer) tblCommercialLoan.getValueAt(selectedRow,0);
        for (CommercialLoan cl: c.getCommercialLoanDirectory().getCommercialLoanList()) {
            if (c.getAccountNumber() == Integer.parseInt(txtAccountno3.getText())) {
               
                c.setBalance(c.getBalance() + Integer.parseInt(txtLoanAmount3.getText()));
                 SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                String date1  = dateFormat.format(new Date());
               c.getTransactionDirectory().addTransaction(new Date(), Integer.parseInt(txtLoanAmount3.getText()),0,  Integer.parseInt(txtLoanAmount3.getText()), Integer.parseInt(txtAccountno3.getText()),c.getBalance() + Integer.parseInt(txtLoanAmount3.getText()), c, "Credit");
               cl.setStatus("Completed");
            }
        }
         
         populateCommercialTable();
         JOptionPane.showMessageDialog(null, "Loan has been approved");
    }//GEN-LAST:event_btnProcessLoan3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProcessLoan;
    private javax.swing.JButton btnProcessLoan1;
    private javax.swing.JButton btnProcessLoan2;
    private javax.swing.JButton btnProcessLoan3;
    private javax.swing.JButton btnReject;
    private javax.swing.JButton btnRejectCL;
    private javax.swing.JButton btnRejectHL;
    private javax.swing.JButton btnRejectRequest;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnViewHouseLoanRequest;
    private javax.swing.JButton btnViewRequest;
    private javax.swing.JButton btnViewRequest2;
    private javax.swing.JButton btnViewRequestCL;
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
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
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
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel49;
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
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
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
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JLabel lblEmployeeName;
    private javax.swing.JButton requestTestJButton1;
    private javax.swing.JTable tblCommercialLoan;
    private javax.swing.JTable tblEducationLoan;
    private javax.swing.JTable tblHouseLoan;
    private javax.swing.JTable tblVehicleLoanRequest;
    private javax.swing.JTextField txtAccountno;
    private javax.swing.JTextField txtAccountno1;
    private javax.swing.JTextField txtAccountno2;
    private javax.swing.JTextField txtAccountno3;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtAddress1;
    private javax.swing.JTextField txtAddress3;
    private javax.swing.JTextField txtAddress4;
    private javax.swing.JTextField txtAddress5;
    private javax.swing.JTextField txtAnnulGrossIncome;
    private javax.swing.JTextField txtAnnulGrossIncome3;
    private javax.swing.JTextField txtAnnulGrossIncome4;
    private javax.swing.JTextField txtAnnulGrossIncome5;
    private javax.swing.JTextField txtBrand;
    private javax.swing.JTextField txtCourseDuration;
    private javax.swing.JTextField txtCourseName;
    private javax.swing.JTextField txtCurrentEmployerAddress;
    private javax.swing.JTextField txtCurrentEmployerAddress3;
    private javax.swing.JTextField txtCurrentEmployerAddress4;
    private javax.swing.JTextField txtCurrentEmployerAddress5;
    private javax.swing.JTextField txtEmailId;
    private javax.swing.JTextField txtHouseAddress;
    private javax.swing.JTextField txtLoanAmount;
    private javax.swing.JTextField txtLoanAmount1;
    private javax.swing.JTextField txtLoanAmount2;
    private javax.swing.JTextField txtLoanAmount3;
    private javax.swing.JTextField txtLoanPurpose;
    private javax.swing.JTextField txtMobileNumber;
    private javax.swing.JTextField txtMobileNumber1;
    private javax.swing.JTextField txtMobileNumber3;
    private javax.swing.JTextField txtMobileNumber4;
    private javax.swing.JTextField txtMobileNumber5;
    private javax.swing.JTextField txtModel;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtName1;
    private javax.swing.JTextField txtName3;
    private javax.swing.JTextField txtName4;
    private javax.swing.JTextField txtName5;
    private javax.swing.JTextField txtOccupation;
    private javax.swing.JTextField txtOccupation3;
    private javax.swing.JTextField txtOccupation4;
    private javax.swing.JTextField txtOccupation5;
    private javax.swing.JTextField txtRateofInterest;
    private javax.swing.JTextField txtRateofInterest1;
    private javax.swing.JTextField txtRateofInterest2;
    private javax.swing.JTextField txtRateofInterest3;
    private javax.swing.JTextField txtRepaymentTerm;
    private javax.swing.JTextField txtRepaymentTerm1;
    private javax.swing.JTextField txtRepaymentTerm2;
    private javax.swing.JTextField txtRepaymentTerm3;
    private javax.swing.JTextField txtSSN;
    private javax.swing.JTextField txtSSN1;
    private javax.swing.JTextField txtSSN3;
    private javax.swing.JTextField txtSSN4;
    private javax.swing.JTextField txtSSN5;
    private javax.swing.JTextField txtUniversityAddress;
    private javax.swing.JTextField txtUniversityName;
    private javax.swing.JTextField txtVehicleCondition;
    private javax.swing.JTextField txtVehicleType;
    private javax.swing.JTable workRequestJTable6;
    // End of variables declaration//GEN-END:variables
}
