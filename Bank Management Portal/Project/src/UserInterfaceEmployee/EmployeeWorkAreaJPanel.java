/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterfaceEmployee;

import Business.Activity.Activity;
import Business.Business;
import Business.Customer.Customer;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Organization.HROrganization;
import Business.Organization.ITOrganization;
import Business.Organization.Organization;
import static Business.Organization.Organization.Type.Customer;
import Business.Organization.OrganizationDirectory;
import Business.Person.Person;
import Business.Person.PersonDirectory;
import Business.Role.CustomerRole;
import Business.Role.Role;
import Business.Session.SessionLog;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.TestWorkRequest;
import Business.WorkQueue.WorkRequest;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.awt.CardLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.util.regex.Pattern;

/**
 *
 * @author admin
 */
public class EmployeeWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Business business;
    private UserAccount userAccount;
    private Employee employee;
    private Organization organization;
    private Enterprise enterprise;
    private OrganizationDirectory organizationDir;
    private SessionLog session;

    /**
     * Creates new form EmployeeWorkAreaJPanel
     */
    public EmployeeWorkAreaJPanel(JPanel upc, UserAccount ua, Organization org, Enterprise ent,SessionLog s) {
        initComponents();
        this.userProcessContainer = upc;
        this.userAccount = ua;
        this.organization = org;
        this.enterprise = ent;
        this.session=s;
        
        populateOrganizationComboBox();

        populateOrganizationEmpComboBox();
        populateRequestTable(enterprise);
//        populateRoleComboBox(organization);
        popData();
        populateCustomerTable(enterprise);
      populateRequestTable1();
      populateRequestTable2();
        Activity a= session.getActivityDirectory().addActivity();
     a.setActivityTime(new Date());
     a.setjPanelName("EmployeeWorkAreaJPanel");
     
// for (SessionLog sl : ua.getSessionDirectory().getSessionList()) {
//     
//                    System.out.println(sl.getEndTime());
//                txtLastLoggedInTime.setText(String.valueOf(sl.getEndTime()));
//                }
 
        for (Employee e : organization.getEmployeeDirectory().getEmployeeList()) {
            if (ua.getEmployee().getName().equals(e.getName())) {
                employee = e;
                lblEmployeeName.setText(employee.getName());
                txtName1.setText(employee.getName());
                txtAddress1.setText(employee.getAddress());
                txtMobileNumber1.setText(Integer.toString(employee.getMobileNumber()));
                txtSSN1.setText(Integer.toString(employee.getSsnNumber()));
                txtEmailId.setText(employee.getEmailAddress());
                jDateChooser1.setDate(employee.getDateOfBirth());

                return;

            }
        }
      
              
               
        
    }

    public void populateOrganizationComboBox() {
        organizationJComboBox.removeAllItems();

        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            organizationJComboBox.addItem(organization);
        }
    }

    public void populateOrganizationEmpComboBox() {
        organizationCusJComboBox.removeAllItems();

        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (organization.getName().equals(Organization.Type.Customer.getValue())) {
                organizationCusJComboBox.addItem(organization);
            }
        }
    }

    public void popData() {

        DefaultTableModel model = (DefaultTableModel) userJTable.getModel();

        model.setRowCount(0);

        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            for (UserAccount ua : organization.getUserAccountDirectory().getUserAccountList()) {
                Object row[] = new Object[2];
                row[0] = ua;
                row[1] = ua.getRole();
                ((DefaultTableModel) userJTable.getModel()).addRow(row);
            }
        }
    }

    private void populateCustomerTable(Enterprise enterprise) {
        DefaultTableModel model = (DefaultTableModel) organizationJTable.getModel();

        model.setRowCount(0);

        for (Customer customer : enterprise.getCustomerDirectory().getCustomerList()) {
            Object[] row = new Object[2];
            row[0] = customer;
            row[1] = customer.getAccountNumber();
            model.addRow(row);
        }
    }

    private void populateCustomerTable1(Enterprise enterprise) {
        DefaultTableModel dtm = (DefaultTableModel) organizationJTable1.getModel();

        dtm.setRowCount(0);

        for (Customer customer : enterprise.getCustomerDirectory().getCustomerList()) {
            Object[] row = new Object[2];
            row[0] = customer;
            row[1] = customer.getAccountNumber();
            dtm.addRow(row);
        }
    }

    private void populateRequestTable(Enterprise enterprise) {
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();

        model.setRowCount(0);

        for (Person person : enterprise.getPersonDirectory().getPersonList()) {
            Object[] row = new Object[3];
            row[0] = person;
            row[1] = person.getSsnNumber();
            row[2] = person.getStatus();
            model.addRow(row);
        }
    }
    
 public void populateRequestTable1(){
        DefaultTableModel model = (DefaultTableModel) workRequestJTable3.getModel();
        
        model.setRowCount(0);
        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()){
            Object[] row = new Object[4];
            row[0] = request.getMessage();
            row[1] = request.getReceiver();
            row[2] = request.getStatus();
            String result = ((TestWorkRequest) request).getTestResult();
            row[3] = result == null ? "Waiting" : result;
            
            model.addRow(row);
        }
    }
 public void populateRequestTable2(){
        DefaultTableModel model = (DefaultTableModel) workRequestJTable1.getModel();
        
        model.setRowCount(0);
        for (WorkRequest r : userAccount.getWorkQueue().getWorkRequestList()){
            Object[] row = new Object[4];
            row[0] = r.getMessage();
            row[1] = r.getReceiver();
            row[2] = r.getStatus();
            String result = ((TestWorkRequest) r).getTestResult();
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

        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblEmployeeName = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        txtName1 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtAddress1 = new javax.swing.JTextField();
        txtMobileNumber1 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        txtSSN1 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txtEmailId = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtAccountNumber1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtSwiftCode1 = new javax.swing.JTextField();
        txtRoutingNumber1 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtAmounttoTransfer = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnTransfer2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        txtEmailId1 = new javax.swing.JTextField();
        txtSSN2 = new javax.swing.JTextField();
        txtMobileNumber2 = new javax.swing.JTextField();
        txtAddress2 = new javax.swing.JTextField();
        txtName2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        organizationJComboBox = new javax.swing.JComboBox();
        jScrollPane6 = new javax.swing.JScrollPane();
        organizationJTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        organizationCusJComboBox = new javax.swing.JComboBox();
        jLabel29 = new javax.swing.JLabel();
        txtRoutingNumber = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSwiftCode = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtBalance = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtBranchName = new javax.swing.JTextField();
        addJButton = new javax.swing.JButton();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        processJButton1 = new javax.swing.JButton();
        jLabel41 = new javax.swing.JLabel();
        txtName4 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        txtAddress4 = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        txtMobileNumber4 = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        txtSSN4 = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        txtEmailId3 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtBranchName1 = new javax.swing.JTextField();
        txtBalance1 = new javax.swing.JTextField();
        txtSwiftCode2 = new javax.swing.JTextField();
        txtRoutingNumber2 = new javax.swing.JTextField();
        addJButton1 = new javax.swing.JButton();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        btnReject = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        workRequestJTable1 = new javax.swing.JTable();
        requestTestJButton = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel8 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        requestTestJButton1 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        workRequestJTable3 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        createUserJButton2 = new javax.swing.JButton();
        backjButton1 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        organizationJTable1 = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        userJTable = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        passwordJtextField = new javax.swing.JPasswordField();
        jTextField1 = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setIcon(new javax.swing.ImageIcon("/siddharth/Info 5100/Project/src/UserInterface/Screen Shot 2016-03-30 at 11.20.59 AM.png")); // NOI18N

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 204));
        jLabel1.setText("is Logged in!");

        lblEmployeeName.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        lblEmployeeName.setForeground(new java.awt.Color(0, 102, 255));
        lblEmployeeName.setText("Employee Name");

        jTabbedPane1.setForeground(new java.awt.Color(0, 102, 204));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jLabel19.setForeground(new java.awt.Color(0, 102, 204));
        jLabel19.setText("Name");

        txtName1.setEditable(false);
        txtName1.setForeground(new java.awt.Color(0, 102, 204));

        jLabel20.setForeground(new java.awt.Color(0, 102, 204));
        jLabel20.setText("Date of Birth");

        jLabel21.setForeground(new java.awt.Color(0, 102, 204));
        jLabel21.setText("Address");

        txtAddress1.setForeground(new java.awt.Color(0, 102, 204));

        txtMobileNumber1.setForeground(new java.awt.Color(0, 102, 204));

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
        jLabel30.setText("SSN no.");

        txtSSN1.setForeground(new java.awt.Color(0, 102, 204));

        jLabel31.setForeground(new java.awt.Color(0, 102, 204));
        jLabel31.setText("Email Id");

        txtEmailId.setForeground(new java.awt.Color(0, 102, 204));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(btnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUpdate))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22)
                            .addComponent(jLabel30)
                            .addComponent(jLabel31))
                        .addGap(79, 79, 79)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMobileNumber1, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                            .addComponent(txtAddress1, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                            .addComponent(txtName1, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                            .addComponent(txtSSN1, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                            .addComponent(txtEmailId, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(772, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(19, 19, 19)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel20)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtAddress1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtMobileNumber1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txtSSN1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(txtEmailId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnUpdate))
                .addContainerGap(145, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("View Profile", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel15.setForeground(new java.awt.Color(0, 102, 204));
        jLabel15.setText("Account Number");

        jLabel16.setForeground(new java.awt.Color(0, 102, 204));
        jLabel16.setText("Routing Number");

        jLabel17.setForeground(new java.awt.Color(0, 102, 204));
        jLabel17.setText("Swift Code");

        jLabel18.setForeground(new java.awt.Color(0, 102, 204));
        jLabel18.setText("Amount to be transfered");

        jButton1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 102, 204));
        jButton1.setIcon(new javax.swing.ImageIcon("/siddharth/Info 5100/Project/src/UserInterfaceCustomer/Screen Shot 2016-03-31 at 9.39.06 PM.png")); // NOI18N
        jButton1.setText("Cancel");

        btnTransfer2.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        btnTransfer2.setForeground(new java.awt.Color(0, 102, 204));
        btnTransfer2.setIcon(new javax.swing.ImageIcon("/siddharth/Info 5100/Project/src/UserInterfaceCustomer/Screen Shot 2016-03-30 at 12.53.06 PM.png")); // NOI18N
        btnTransfer2.setText("Transfer");
        btnTransfer2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransfer2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSwiftCode1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTransfer2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(18, 18, 18)
                                .addComponent(txtAmounttoTransfer, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(66, 66, 66)
                                .addComponent(txtAccountNumber1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(69, 69, 69)
                                .addComponent(txtRoutingNumber1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(517, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtAccountNumber1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtRoutingNumber1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtSwiftCode1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtAmounttoTransfer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTransfer2)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(235, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Deposit Money", jPanel2);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel25.setForeground(new java.awt.Color(0, 102, 204));
        jLabel25.setText("Name");

        jLabel26.setForeground(new java.awt.Color(0, 102, 204));
        jLabel26.setText("Date of Birth");

        jLabel27.setForeground(new java.awt.Color(0, 102, 204));
        jLabel27.setText("Address");

        jLabel28.setForeground(new java.awt.Color(0, 102, 204));
        jLabel28.setText("Mobile No.");

        jLabel33.setForeground(new java.awt.Color(0, 102, 204));
        jLabel33.setText("SSN no.");

        jLabel34.setForeground(new java.awt.Color(0, 102, 204));
        jLabel34.setText("Email Id");

        txtEmailId1.setForeground(new java.awt.Color(0, 102, 204));

        txtSSN2.setForeground(new java.awt.Color(0, 102, 204));

        txtMobileNumber2.setForeground(new java.awt.Color(0, 102, 204));

        txtAddress2.setForeground(new java.awt.Color(0, 102, 204));

        txtName2.setForeground(new java.awt.Color(0, 102, 204));

        jLabel2.setForeground(new java.awt.Color(51, 102, 255));
        jLabel2.setText("Organization");

        organizationJComboBox.setForeground(new java.awt.Color(51, 102, 255));
        organizationJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        organizationJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationJComboBoxActionPerformed(evt);
            }
        });

        jScrollPane6.setForeground(new java.awt.Color(51, 102, 255));

        organizationJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(organizationJTable);

        jLabel3.setForeground(new java.awt.Color(51, 102, 255));
        jLabel3.setText("Organization");

        organizationCusJComboBox.setForeground(new java.awt.Color(51, 102, 255));
        organizationCusJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel29.setForeground(new java.awt.Color(0, 102, 204));
        jLabel29.setText("Routing Number");

        jLabel5.setForeground(new java.awt.Color(0, 102, 204));
        jLabel5.setText("Swift Code");

        jLabel6.setForeground(new java.awt.Color(0, 102, 204));
        jLabel6.setText("Balance");

        jLabel7.setForeground(new java.awt.Color(0, 102, 204));
        jLabel7.setText("Branch Name");

        addJButton.setForeground(new java.awt.Color(51, 102, 255));
        addJButton.setText("Create Customer");
        addJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3))
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel2)
                                .addGap(32, 32, 32)
                                .addComponent(organizationJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(163, 163, 163)
                                .addComponent(organizationCusJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(jLabel26)
                            .addComponent(jLabel27)
                            .addComponent(jLabel28)
                            .addComponent(jLabel33)
                            .addComponent(jLabel34))
                        .addGap(79, 79, 79)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSSN2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmailId1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMobileNumber2, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                                    .addComponent(txtAddress2, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                                    .addComponent(txtName2, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                                    .addComponent(jDateChooser3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(70, 70, 70)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(addJButton)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtSwiftCode, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                            .addComponent(jLabel29)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                                            .addComponent(txtRoutingNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtBranchName, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                .addContainerGap(302, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(organizationJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(organizationCusJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtName2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel26)
                            .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(txtAddress2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(txtRoutingNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtSwiftCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtBranchName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(txtMobileNumber2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(txtSSN2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34)
                            .addComponent(txtEmailId1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addJButton)
                        .addGap(35, 35, 35))))
        );

        jTabbedPane1.addTab("Open New Account", jPanel5);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Name", "SSN No.", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class
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
        jScrollPane1.setViewportView(workRequestJTable);

        processJButton1.setForeground(new java.awt.Color(0, 102, 204));
        processJButton1.setText("View Request");
        processJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processJButton1ActionPerformed(evt);
            }
        });

        jLabel41.setForeground(new java.awt.Color(0, 102, 204));
        jLabel41.setText("Name");

        txtName4.setForeground(new java.awt.Color(0, 102, 204));

        jLabel42.setForeground(new java.awt.Color(0, 102, 204));
        jLabel42.setText("Date of Birth");

        jLabel43.setForeground(new java.awt.Color(0, 102, 204));
        jLabel43.setText("Address");

        txtAddress4.setForeground(new java.awt.Color(0, 102, 204));

        jLabel44.setForeground(new java.awt.Color(0, 102, 204));
        jLabel44.setText("Mobile No.");

        txtMobileNumber4.setForeground(new java.awt.Color(0, 102, 204));

        jLabel45.setForeground(new java.awt.Color(0, 102, 204));
        jLabel45.setText("SSN no.");

        txtSSN4.setForeground(new java.awt.Color(0, 102, 204));

        jLabel46.setForeground(new java.awt.Color(0, 102, 204));
        jLabel46.setText("Email Id");

        txtEmailId3.setForeground(new java.awt.Color(0, 102, 204));

        jLabel35.setForeground(new java.awt.Color(0, 102, 204));
        jLabel35.setText("Routing Number");

        jLabel8.setForeground(new java.awt.Color(0, 102, 204));
        jLabel8.setText("Swift Code");

        jLabel9.setForeground(new java.awt.Color(0, 102, 204));
        jLabel9.setText("Balance");

        jLabel10.setForeground(new java.awt.Color(0, 102, 204));
        jLabel10.setText("Branch Name");

        addJButton1.setForeground(new java.awt.Color(51, 102, 255));
        addJButton1.setText("Create Customer");
        addJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJButton1ActionPerformed(evt);
            }
        });

        btnReject.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        btnReject.setForeground(new java.awt.Color(0, 102, 204));
        btnReject.setIcon(new javax.swing.ImageIcon("/siddharth/Info 5100/Project/src/UserInterfaceCustomer/Screen Shot 2016-03-31 at 9.39.06 PM.png")); // NOI18N
        btnReject.setText("Reject");
        btnReject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRejectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(processJButton1)
                            .addComponent(btnReject, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel44)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel45)
                                        .addComponent(jLabel46)))
                                .addGap(46, 46, 46)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSSN4, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                    .addComponent(txtEmailId3)
                                    .addComponent(txtMobileNumber4)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel41)
                                    .addComponent(jLabel43)
                                    .addComponent(jLabel42))
                                .addGap(35, 35, 35)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtAddress4, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                    .addComponent(txtName4)
                                    .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtSwiftCode2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel35)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                                    .addComponent(txtRoutingNumber2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtBalance1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtBranchName1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(addJButton1))))
                .addGap(0, 377, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(processJButton1)
                        .addGap(18, 18, 18)
                        .addComponent(btnReject, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel41)
                            .addComponent(txtName4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel42)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAddress4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel44)
                            .addComponent(txtMobileNumber4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(txtRoutingNumber2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtSwiftCode2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtBalance1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtBranchName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmailId3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSSN4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45)
                    .addComponent(addJButton1))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Account Requests", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

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
        jScrollPane2.setViewportView(workRequestJTable1);

        requestTestJButton.setForeground(new java.awt.Color(0, 102, 204));
        requestTestJButton.setText("Request Test");
        requestTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestTestJButtonActionPerformed(evt);
            }
        });

        jLabel23.setForeground(new java.awt.Color(0, 102, 204));
        jLabel23.setText("Message");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(requestTestJButton)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addGap(170, 170, 170)
                            .addComponent(jLabel23)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addGap(157, 157, 157)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(512, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel23))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addComponent(requestTestJButton)
                .addContainerGap(206, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Contact IT team", jPanel4);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel24.setForeground(new java.awt.Color(0, 102, 204));
        jLabel24.setText("Message");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane5.setViewportView(jTextArea2);

        requestTestJButton1.setForeground(new java.awt.Color(0, 102, 204));
        requestTestJButton1.setText("Request Test");
        requestTestJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestTestJButton1ActionPerformed(evt);
            }
        });

        workRequestJTable3.setForeground(new java.awt.Color(0, 102, 204));
        workRequestJTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(workRequestJTable3);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(241, 241, 241)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(requestTestJButton1))
                .addContainerGap(428, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel24))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(58, 58, 58)
                .addComponent(requestTestJButton1)
                .addContainerGap(163, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Contact HR team ", jPanel8);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setForeground(new java.awt.Color(51, 102, 255));
        jLabel12.setText("Password");

        createUserJButton2.setForeground(new java.awt.Color(51, 102, 255));
        createUserJButton2.setText("Create");
        createUserJButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createUserJButton2ActionPerformed(evt);
            }
        });

        backjButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        backjButton1.setForeground(new java.awt.Color(51, 102, 255));
        backjButton1.setText("<< Back");
        backjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButton1ActionPerformed(evt);
            }
        });

        jScrollPane8.setForeground(new java.awt.Color(51, 102, 255));

        organizationJTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        organizationJTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                organizationJTable1MouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(organizationJTable1);

        jScrollPane7.setForeground(new java.awt.Color(51, 102, 255));

        userJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User Name", "Role"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(userJTable);

        jButton2.setForeground(new java.awt.Color(51, 102, 255));
        jButton2.setText("Send UserId & Password");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        passwordJtextField.setForeground(new java.awt.Color(51, 102, 255));
        passwordJtextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordJtextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(backjButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(247, 247, 247)
                        .addComponent(jLabel12)
                        .addGap(74, 74, 74)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(createUserJButton2)
                            .addComponent(passwordJtextField, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(363, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(passwordJtextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(createUserJButton2)
                .addGap(36, 36, 36)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(backjButton1)
                .addGap(20, 20, 20))
        );

        jTabbedPane1.addTab("Manage Customer's UserAccount", jPanel6);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1036, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(388, 388, 388)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(252, 252, 252)
                                .addComponent(lblEmployeeName, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(119, 119, 119)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(201, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmployeeName)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void requestTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestTestJButtonActionPerformed
  String message = jTextArea1.getText();
        
        TestWorkRequest request = new TestWorkRequest();
        request.setMessage(message);
        request.setSender(userAccount);
        request.setStatus("Sent");
        
        Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
            if (organization instanceof ITOrganization){
                org = organization;
                break;
            }
        }
        if (org!=null){
            org.getWorkQueue().getWorkRequestList().add(request);
            userAccount.getWorkQueue().getWorkRequestList().add(request);
        }
        populateRequestTable2();
    }//GEN-LAST:event_requestTestJButtonActionPerformed

    private void btnTransfer2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransfer2ActionPerformed
        // TODO add your handling code here:
 if(!Pattern.matches("^\\d+", txtAccountNumber1.getText())){
             JOptionPane.showMessageDialog(null, "Please Enter Numeric Value in Account Number");
 }
 else  if(!Pattern.matches("^\\d+", txtRoutingNumber1.getText())){
             JOptionPane.showMessageDialog(null, "Please Enter Numeric Value in Routing Number");
 }
 else  if(txtSwiftCode1.getText().equals("")){
             JOptionPane.showMessageDialog(null, "Please Enter Swift Code");
         }
 else if(!Pattern.matches("^\\d+", txtAmounttoTransfer.getText())){
             JOptionPane.showMessageDialog(null, "Please Enter Numeric Value in Amount to Transfer");
 }
 else{
     
 try{
        for (Customer c : enterprise.getCustomerDirectory().getCustomerList()) {
            if (c.getAccountNumber() == Integer.parseInt(txtAccountNumber1.getText())) {
                c.setAccountNumber(Integer.parseInt(txtAccountNumber1.getText()));
                c.setRoutingNumber(Integer.parseInt(txtRoutingNumber1.getText()));
                c.setSwiftCode(txtSwiftCode1.getText());
                c.setBalance(c.getBalance() + Integer.parseInt(txtAmounttoTransfer.getText()));
//               double amount= c.getBalance() + Double.parseDouble(txtAmounttoTransfer.getText());
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                String date1  = dateFormat.format(new Date());
              c.getTransactionDirectory().addTransaction(new Date(), Integer.parseInt(txtAmounttoTransfer.getText()),0, Integer.parseInt(txtAmounttoTransfer.getText()),Integer.parseInt(txtAccountNumber1.getText()),c.getBalance() + Integer.parseInt(txtAmounttoTransfer.getText()), c, "Credit");
               JOptionPane.showMessageDialog(null, "Money Transfered");
            }
        }
 }
 catch(Exception e){
     
 }
 }
    }//GEN-LAST:event_btnTransfer2ActionPerformed

    private void processJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processJButton1ActionPerformed
        // TODO add your handling code here:
        int selectedRow = workRequestJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please Select a row from the table");
            return;
        }
        Person p = (Person) workRequestJTable.getValueAt(selectedRow, 0);
        txtName4.setText(p.getName());
        txtAddress4.setText(p.getAddress());
        txtSSN4.setText(Integer.toString(p.getSsnNumber()));
        txtMobileNumber4.setText(Integer.toString(p.getMobileNumber()));
        jDateChooser2.setDate(p.getDateOfBirth());
        txtEmailId3.setText(p.getEmailID());

    }//GEN-LAST:event_processJButton1ActionPerformed

    private void requestTestJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestTestJButton1ActionPerformed
        // TODO add your handling code here:
          String message = jTextArea1.getText();
        
        TestWorkRequest request = new TestWorkRequest();
        request.setMessage(message);
        request.setSender(userAccount);
        request.setStatus("Sent");
        
        Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
            if (organization instanceof HROrganization){
                org = organization;
                break;
            }
        }
        if (org!=null){
            org.getWorkQueue().getWorkRequestList().add(request);
            userAccount.getWorkQueue().getWorkRequestList().add(request);
        }
        populateRequestTable1();
    }//GEN-LAST:event_requestTestJButton1ActionPerformed

    private void organizationJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationJComboBoxActionPerformed
        Organization organization = (Organization) organizationJComboBox.getSelectedItem();
        if (organization != null) {
            populateCustomerTable(enterprise);
        }
    }//GEN-LAST:event_organizationJComboBoxActionPerformed

    private void addJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJButtonActionPerformed
if(txtAddress2.getText().equals("")){
             JOptionPane.showMessageDialog(null, "Please Enter Address");
         }
 else if(txtName2.getText().equals("")){
             JOptionPane.showMessageDialog(null, "Please Enter Name");
         }
   else if(!Pattern.matches("^\\d+", txtMobileNumber2.getText())){
             JOptionPane.showMessageDialog(null, "Please Enter Numeric Value in Mobile Number");
         }
        else if(!Pattern.matches("\\d{10}", txtMobileNumber2.getText())){
           JOptionPane.showMessageDialog(null,"Please Enter 10 Digit Mobile Number");
        }
   else if(!Pattern.matches("^\\d+", txtSSN2.getText())){
             JOptionPane.showMessageDialog(null, "Please Enter Numeric Value in SSN Number");
         }
        else if(!Pattern.matches("\\d{9}", txtSSN2.getText())){
           JOptionPane.showMessageDialog(null,"Please Enter 9 Digit SSN Number");
        }
  else if(!Pattern.matches("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", txtEmailId1.getText())){
           JOptionPane.showMessageDialog(null,"Please Enter Correct Email Address");
        }
   else  if(!Pattern.matches("^\\d+", txtRoutingNumber.getText())){
             JOptionPane.showMessageDialog(null, "Please Enter Numeric Value in Routing Number");
 }
 else  if(txtSwiftCode.getText().equals("")){
             JOptionPane.showMessageDialog(null, "Please Enter Swift Code");
         }
  else if(!Pattern.matches("^\\d+", txtBalance.getText())){
             JOptionPane.showMessageDialog(null, "Please Enter Numeric Value in Balance");
         }
   else  if(txtBranchName.getText().equals("")){
             JOptionPane.showMessageDialog(null, "Please Enter Branch Name");
         }
   
  
  else{
try{
        Organization organization = (Organization) organizationCusJComboBox.getSelectedItem();
        String name = txtName2.getText();
        String address = txtAddress2.getText();
        Date dateOfBirth = jDateChooser3.getDate();
        int mobileNumber = Integer.parseInt(txtMobileNumber2.getText());
        int ssnNumber = Integer.parseInt(txtSSN2.getText());
        String emailAddress = txtEmailId1.getText();
//        int accountNumber=Integer.parseInt(txtAccountNumber.getText());
        int balance = Integer.parseInt(txtBalance.getText());
        int routingNumber = Integer.parseInt(txtRoutingNumber.getText());
        String swiftCode = txtSwiftCode.getText();
        String branchName = txtBranchName.getText();

        enterprise.getCustomerDirectory().addCustomer(name, dateOfBirth, address, mobileNumber, ssnNumber, emailAddress, routingNumber, swiftCode, branchName, balance);
        populateCustomerTable(enterprise);
        populateCustomerTable1(enterprise);
}
catch(Exception e){
    
}
   }
    }//GEN-LAST:event_addJButtonActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        txtName1.setEditable(false);
        jDateChooser1.setEnabled(false);
        txtAddress1.setEditable(true);
        txtMobileNumber1.setEditable(true);
        txtSSN1.setEditable(false);
        txtEmailId.setEditable(true);

    }//GEN-LAST:event_btnUpdateActionPerformed

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

    private void addJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJButton1ActionPerformed
        // TODO add your handling code here:
        if(!Pattern.matches("^\\d+", txtRoutingNumber.getText())){
             JOptionPane.showMessageDialog(null, "Please Enter Numeric Value in Routing Number");
 }
 else  if(txtSwiftCode.getText().equals("")){
             JOptionPane.showMessageDialog(null, "Please Enter Swift Code");
         }
  else if(!Pattern.matches("^\\d+", txtBalance.getText())){
             JOptionPane.showMessageDialog(null, "Please Enter Numeric Value in Balance");
         }
   else  if(txtBranchName.getText().equals("")){
             JOptionPane.showMessageDialog(null, "Please Enter Branch Name");
         }
   
  
  else{
try{
       int selectedRow = workRequestJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please Select a customer  from the table");
            return;
        }
        Person person= (Person)workRequestJTable.getValueAt(selectedRow, 0);
        String name = txtName4.getText();
        String address = txtAddress4.getText();
        Date dateOfBirth = jDateChooser2.getDate();
        int mobileNumber = Integer.parseInt(txtMobileNumber4.getText());
        int ssnNumber = Integer.parseInt(txtSSN4.getText());
        String emailAddress = txtEmailId3.getText();
//        int accountNumber=Integer.parseInt(txtAccountNumber2.getText());
        int balance = Integer.parseInt(txtBalance1.getText());
        int routingNumber = Integer.parseInt(txtRoutingNumber2.getText());
        String swiftCode = txtSwiftCode2.getText();
        String branchName = txtBranchName1.getText();
        
        enterprise.getCustomerDirectory().addCustomer(name, dateOfBirth, address, mobileNumber, ssnNumber, emailAddress, routingNumber, swiftCode, branchName, balance);
        populateCustomerTable1(enterprise);
         JOptionPane.showMessageDialog(null, "Customer Created");
         person.setStatus("Completed");
         populateRequestTable(enterprise);
}
catch(Exception e){
    
}
   }
    }//GEN-LAST:event_addJButton1ActionPerformed

    private void createUserJButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createUserJButton2ActionPerformed
//        int userId = Integer.parseInt(nameJTextField.getText());
if(!Pattern.matches("[a-z]{4,}\\d{2,}", passwordJtextField.getText())){
             JOptionPane.showMessageDialog(null, "Please Enter AlphaNumeric Password");
            
         }
else{
    try{


        int selectedRow = organizationJTable1.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please Select a customer  from the table");
            return;
        }
        Customer customer = (Customer) organizationJTable1.getValueAt(selectedRow, 0);

        String password = passwordJtextField.getText();

//        Enterprise enterprise = (Enterprise) organizationJComboBox.getSelectedItem();
//        Role role = (Role) roleJComboBox.getSelectedItem();
        organization.getUserAccountDirectory().createUserAccount(password, null, new CustomerRole(), customer);

        popData();
        JOptionPane.showMessageDialog(null, "Customer UserAccount Creadted");
    }
    catch(Exception e){
        
    }
}
    }//GEN-LAST:event_createUserJButton2ActionPerformed

    private void backjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backjButton1ActionPerformed

    private void btnRejectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRejectActionPerformed
        // TODO add your handling code here:
        int selectedRow = workRequestJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a person from the table to reject.");
            return;
        }
        Person person = (Person) workRequestJTable.getValueAt(selectedRow, 0);
        enterprise.getPersonDirectory().deletePerson(person);
        txtName4.setText("");
        txtAddress4.setText("");
        txtSSN4.setText("");
        txtMobileNumber4.setText("");
        jDateChooser2.setDate(new Date());
        txtEmailId3.setText("");

        populateRequestTable(enterprise);
        JOptionPane.showMessageDialog(null, "Person Request deleted successfully");
    }//GEN-LAST:event_btnRejectActionPerformed

    private void organizationJTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_organizationJTable1MouseClicked
        // TODO add your handling code here:
        
//        populateCustomerTable1(enterprise);
    }//GEN-LAST:event_organizationJTable1MouseClicked
public static void sendmail(String mailTo, String mailCC, String subject, String content) {

        Properties props = System.getProperties();

        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.host", "smtp.mail.yahoo.com");
        props.put("mail.smtp.socketFactory.port", "465");

        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.quitwait", "false");
        props.put("mail.smtp.port", "465");

        try {
            Session session = Session.getDefaultInstance(props,
                    new Authenticator() {

                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(
                            "testbank54@yahoo.com", "santoshwale");
                }
            });
            Message message = new MimeMessage(session);
            Address bankEmailId = new InternetAddress("testbank54@yahoo.com");
            Address toAddress = new InternetAddress(mailTo);
            Address ccAddress = new InternetAddress(mailCC);

            message.setFrom(bankEmailId);
            message.setRecipient(Message.RecipientType.TO, toAddress);
            message.setRecipient(Message.RecipientType.CC, ccAddress);
            message.setSubject(subject);

            MimeBodyPart mbp = new MimeBodyPart();
            MimeMultipart multipart = new MimeMultipart();

            multipart.addBodyPart(mbp);

            mbp.setText(content, "utf-8");
            mbp.setHeader("Content-Type", "text/html; charset=\"utf-8\"");
            mbp.setHeader("Content-Transfer-Encoding", "quoted-printable");

            message.setContent(multipart);
            message.setSentDate(new Date());

            Transport.send(message);

        } catch (Exception e) {
            e.printStackTrace();
        }
}
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
           int selectedRow = userJTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please Select request from the table");
            return;
        }
        UserAccount ua = (UserAccount) userJTable.getValueAt(selectedRow,0);
        
        sendmail(ua.getCustomer().getEmailAddress(), "siddharth.wale@gmail.com","Account Login Information" , "UserId "+ua.getUserId()+" "+"Password "+ua.getPassword());
        JOptionPane.showMessageDialog(null,"Mail Sent");

    }//GEN-LAST:event_jButton2ActionPerformed

    private void passwordJtextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordJtextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordJtextFieldActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addJButton;
    private javax.swing.JButton addJButton1;
    private javax.swing.JButton backjButton1;
    private javax.swing.JButton btnReject;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnTransfer2;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton createUserJButton2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblEmployeeName;
    private javax.swing.JComboBox organizationCusJComboBox;
    private javax.swing.JComboBox organizationJComboBox;
    private javax.swing.JTable organizationJTable;
    private javax.swing.JTable organizationJTable1;
    private javax.swing.JPasswordField passwordJtextField;
    private javax.swing.JButton processJButton1;
    private javax.swing.JButton requestTestJButton;
    private javax.swing.JButton requestTestJButton1;
    private javax.swing.JTextField txtAccountNumber1;
    private javax.swing.JTextField txtAddress1;
    private javax.swing.JTextField txtAddress2;
    private javax.swing.JTextField txtAddress4;
    private javax.swing.JTextField txtAmounttoTransfer;
    private javax.swing.JTextField txtBalance;
    private javax.swing.JTextField txtBalance1;
    private javax.swing.JTextField txtBranchName;
    private javax.swing.JTextField txtBranchName1;
    private javax.swing.JTextField txtEmailId;
    private javax.swing.JTextField txtEmailId1;
    private javax.swing.JTextField txtEmailId3;
    private javax.swing.JTextField txtMobileNumber1;
    private javax.swing.JTextField txtMobileNumber2;
    private javax.swing.JTextField txtMobileNumber4;
    private javax.swing.JTextField txtName1;
    private javax.swing.JTextField txtName2;
    private javax.swing.JTextField txtName4;
    private javax.swing.JTextField txtRoutingNumber;
    private javax.swing.JTextField txtRoutingNumber1;
    private javax.swing.JTextField txtRoutingNumber2;
    private javax.swing.JTextField txtSSN1;
    private javax.swing.JTextField txtSSN2;
    private javax.swing.JTextField txtSSN4;
    private javax.swing.JTextField txtSwiftCode;
    private javax.swing.JTextField txtSwiftCode1;
    private javax.swing.JTextField txtSwiftCode2;
    private javax.swing.JTable userJTable;
    private javax.swing.JTable workRequestJTable;
    private javax.swing.JTable workRequestJTable1;
    private javax.swing.JTable workRequestJTable3;
    // End of variables declaration//GEN-END:variables
}
