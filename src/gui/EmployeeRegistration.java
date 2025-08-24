package gui;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import static gui.SignInDep.logger;
import java.util.Vector;
import model.MySQL;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.swing.ButtonModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class EmployeeRegistration extends javax.swing.JDialog {

    private static HashMap<String, String> employeeTypeMap = new HashMap<>();

    public EmployeeRegistration(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        halfRoundedButton2.setEnabled(false);
        halfRoundedButton3.setEnabled(true);
        loadempType();

    }

    public EmployeeRegistration(java.awt.Frame parent, boolean modal, String fname, String lname, String mobile, String email, String gender, String nic, String password, String type) {
        super(parent, modal);
        initComponents();
        halfRoundedButton3.setEnabled(false);
        halfRoundedButton1.setEnabled(false);
        loadempType();

        roundedTextfields3.setText(email);
        jPasswordField1.setText(password);
        roundedTextfields1.setText(fname);
        roundedTextfields2.setText(lname);
        roundedTextfields4.setText(nic);
        roundedTextfields5.setText(mobile);

        if (gender.equals("Male")) {
            jCheckBox1.setSelected(true);
        }

        if (gender.equals("Female")) {
            jCheckBox2.setSelected(true);
        }

        jComboBox1.setSelectedItem(type);

    }

    private void loadempType() {

        try {

            ResultSet resultSet = MySQL.executeSearch("SELECT * FROM `employee_type`");

            Vector<String> vector = new Vector<>();
            vector.add("Select");

            while (resultSet.next()) {
                vector.add(resultSet.getString("name"));

                employeeTypeMap.put(resultSet.getString("name"), resultSet.getString("id"));
            }

            DefaultComboBoxModel model = new DefaultComboBoxModel(vector);
            jComboBox1.setModel(model);

        } catch (Exception e) {
            logger.log(java.util.logging.Level.WARNING, "error in loading loadEmployeeType", e);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        roundPanel2 = new gui.RoundPanel();
        jLabel10 = new javax.swing.JLabel();
        roundPanel1 = new gui.RoundPanel();
        jLabel7 = new javax.swing.JLabel();
        roundedTextfields1 = new gui.RoundedTextfields();
        jLabel8 = new javax.swing.JLabel();
        roundedTextfields2 = new gui.RoundedTextfields();
        jLabel9 = new javax.swing.JLabel();
        roundedTextfields3 = new gui.RoundedTextfields();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        roundedTextfields4 = new gui.RoundedTextfields();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jComboBox1 = new javax.swing.JComboBox<>();
        halfRoundedButton1 = new gui.HalfRoundedButton();
        halfRoundedButton2 = new gui.HalfRoundedButton();
        halfRoundedButton3 = new gui.HalfRoundedButton();
        jLabel15 = new javax.swing.JLabel();
        roundedTextfields5 = new gui.RoundedTextfields();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Employee Registration");
        setResizable(false);

        roundPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Poppins", 0, 24)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Employee Registration");

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel10)
                .addGap(15, 15, 15))
        );

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel7.setText("First Name");

        roundedTextfields1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel8.setText("Last Name");

        roundedTextfields2.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel9.setText("Email");

        roundedTextfields3.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N

        jPasswordField1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel11.setText("Password");

        jLabel12.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel12.setText("NIC");

        roundedTextfields4.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel13.setText("Gender");

        jLabel14.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel14.setText("Emloyee Type");

        buttonGroup1.add(jCheckBox1);
        jCheckBox1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jCheckBox1.setText("Male");
        jCheckBox1.setActionCommand("1");

        buttonGroup1.add(jCheckBox2);
        jCheckBox2.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jCheckBox2.setText("Female");
        jCheckBox2.setActionCommand("2");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        halfRoundedButton1.setBackground(new java.awt.Color(102, 255, 102));
        halfRoundedButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Register.png"))); // NOI18N
        halfRoundedButton1.setText("Register");
        halfRoundedButton1.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        halfRoundedButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                halfRoundedButton1ActionPerformed(evt);
            }
        });

        halfRoundedButton2.setBackground(new java.awt.Color(51, 102, 255));
        halfRoundedButton2.setForeground(new java.awt.Color(255, 255, 255));
        halfRoundedButton2.setText("Update");
        halfRoundedButton2.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        halfRoundedButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                halfRoundedButton2ActionPerformed(evt);
            }
        });

        halfRoundedButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reset11.png"))); // NOI18N
        halfRoundedButton3.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        halfRoundedButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                halfRoundedButton3ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel15.setText("Mobile");

        roundedTextfields5.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, roundPanel1Layout.createSequentialGroup()
                                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(roundPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(170, 170, 170))
                                    .addGroup(roundPanel1Layout.createSequentialGroup()
                                        .addComponent(roundedTextfields1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(25, 25, 25)))
                                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(roundedTextfields2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(roundPanel1Layout.createSequentialGroup()
                                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(roundedTextfields3, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(roundedTextfields5, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, roundPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, roundPanel1Layout.createSequentialGroup()
                                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(roundPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, Short.MAX_VALUE))
                                    .addGroup(roundPanel1Layout.createSequentialGroup()
                                        .addComponent(jPasswordField1)
                                        .addGap(25, 25, 25)))
                                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(roundedTextfields4, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(halfRoundedButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(halfRoundedButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(halfRoundedButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(roundedTextfields2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(roundedTextfields1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(roundedTextfields3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(roundedTextfields5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(roundedTextfields4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCheckBox1)
                        .addComponent(jCheckBox2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(halfRoundedButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(halfRoundedButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(halfRoundedButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void halfRoundedButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_halfRoundedButton1ActionPerformed

        String fname = roundedTextfields1.getText();
        String lname = roundedTextfields2.getText();
        String email = roundedTextfields3.getText();
        String mobile = roundedTextfields5.getText();
        String pass = String.valueOf(jPasswordField1.getPassword());
        String nic = roundedTextfields4.getText();
        ButtonModel gender = buttonGroup1.getSelection();
        String type = String.valueOf(jComboBox1.getSelectedItem());

        try {

            if (fname.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter First Name", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (lname.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter Last Name", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (email.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter E-mail Address", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (!email.matches("^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@[^-][A-Za-z0-9\\+-]+(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$")) {
                JOptionPane.showMessageDialog(this, "Invalid E-mail", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (mobile.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter mobile number", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (!mobile.matches("^07[01245678]{1}[0-9]{7}$")) {
                JOptionPane.showMessageDialog(this, "Invalid Mobile Number", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (pass.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter your password", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (!pass.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")) {
                JOptionPane.showMessageDialog(this, "Please enter minimum 8 characters with atleast one letter and one number", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (nic.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter your NIC", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (!nic.matches("-?\\d*\\.?\\d+")) {
                JOptionPane.showMessageDialog(this, "Invalid NIC", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (gender == null) {
                JOptionPane.showMessageDialog(this, "Please Select your Gender", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (type.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Please Select Employment Type", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {

                ResultSet rs = MySQL.executeSearch("SELECT * FROM `employee` WHERE `email` = '" + email + "' OR `nic` = '" + nic + "'  OR `mobile` = '" + mobile + "'");

                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Employee Already Registered", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {

                    String gender2 = gender.getActionCommand();

                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                    MySQL.executeIUD("INSERT INTO `employee`(`email`,`password`,`first_name`,`last_name`,`nic`,`mobile`,`date_registered`,`employee_type_id`,`gender_id`)"
                            + "VALUES('" + email + "','" + pass + "','" + fname + "','" + lname + "','" + nic + "','" + mobile + "',"
                            + "'" + sdf.format(date) + "','" + employeeTypeMap.get(type) + "','" + gender2 + "')");

                    reset();
                    this.dispose();

                }

            }

        } catch (Exception e) {
            logger.log(java.util.logging.Level.WARNING, "error in Inserting employee details", e);
        }

    }//GEN-LAST:event_halfRoundedButton1ActionPerformed

    private void halfRoundedButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_halfRoundedButton2ActionPerformed

        String fname = roundedTextfields1.getText();
        String lname = roundedTextfields2.getText();
        String email = roundedTextfields3.getText();
        String mobile = roundedTextfields5.getText();
        String pass = String.valueOf(jPasswordField1.getPassword());
        String nic = roundedTextfields4.getText();
        ButtonModel gender = buttonGroup1.getSelection();
        String type = String.valueOf(jComboBox1.getSelectedItem());

        try {

            if (fname.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter First Name", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (lname.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter Last Name", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (email.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter E-mail Address", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (!email.matches("^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@[^-][A-Za-z0-9\\+-]+(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$")) {
                JOptionPane.showMessageDialog(this, "Invalid E-mail", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (mobile.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter mobile number", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (!mobile.matches("^07[01245678]{1}[0-9]{7}$")) {
                JOptionPane.showMessageDialog(this, "Invalid Mobile Number", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (pass.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter your password", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (!pass.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{5,}$")) {
                JOptionPane.showMessageDialog(this, "Please enter minimum 8 characters with atleast one letter and one number", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (nic.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter your NIC", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (!nic.matches("-?\\d*\\.?\\d+")) {
                JOptionPane.showMessageDialog(this, "Invalid NIC", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (gender == null) {
                JOptionPane.showMessageDialog(this, "Please Select your Gender", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (type.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Please Select Employment Type", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {

                ResultSet rs = MySQL.executeSearch("SELECT * FROM `employee` WHERE `email` = '" + email + "' OR `nic` = '" + nic + "'");

                boolean canUpdate = false;

                if (rs.next()) {

                    if (rs.getString("nic").equals(nic)) {
                        canUpdate = true;
                    } else {
                        JOptionPane.showMessageDialog(this, "There is another employee with the same details", "Warning", JOptionPane.WARNING_MESSAGE);
                    }

                } else {
                    canUpdate = true;
                }

                if (canUpdate) {
                    String gender2 = gender.getActionCommand();

                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                    MySQL.executeIUD("UPDATE `employee` SET `password`='" + pass + "', `first_name`='" + fname + "', `last_name`='" + lname + "', `mobile`='" + mobile + "', `employee_type_id`='" + employeeTypeMap.get(type) + "', `gender_id`='" + gender2 + "'"
                            + "WHERE `email`='" + email + "' OR `nic`='" + nic + "'");

                    reset();
                    this.dispose();

                    reset();
                    setVisible(false);
                }

//                }
            }

        } catch (Exception e) {
            logger.log(java.util.logging.Level.WARNING, "error in updating employee details", e);
        }
    }//GEN-LAST:event_halfRoundedButton2ActionPerformed

    private void halfRoundedButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_halfRoundedButton3ActionPerformed
        reset();
    }//GEN-LAST:event_halfRoundedButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//
////        FlatMacDarkLaf.setup();
//        FlatMacLightLaf.setup();
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
////                new EmployeeRegistration().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private gui.HalfRoundedButton halfRoundedButton1;
    private gui.HalfRoundedButton halfRoundedButton2;
    private gui.HalfRoundedButton halfRoundedButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField jPasswordField1;
    private gui.RoundPanel roundPanel1;
    private gui.RoundPanel roundPanel2;
    private gui.RoundedTextfields roundedTextfields1;
    private gui.RoundedTextfields roundedTextfields2;
    private gui.RoundedTextfields roundedTextfields3;
    private gui.RoundedTextfields roundedTextfields4;
    private gui.RoundedTextfields roundedTextfields5;
    // End of variables declaration//GEN-END:variables

    private void reset() {

        roundedTextfields1.setText("");
        roundedTextfields2.setText("");
        roundedTextfields3.setText("");
        roundedTextfields4.setText("");
        roundedTextfields5.setText("");
        jPasswordField1.setText("");
        buttonGroup1.clearSelection();
        jComboBox1.setSelectedIndex(0);
        roundedTextfields1.requestFocus();

    }
}
