package gui;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import static gui.SignInDep.logger;
import javax.swing.JOptionPane;
import model.MySQL;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

public class SupplierComRegistration extends javax.swing.JDialog {

    private static HashMap<String, String> companyType = new HashMap<>();
    private String email;

    public SupplierComRegistration(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        loadCompany();

        halfRoundedButton2.setEnabled(false);
    }

    public SupplierComRegistration(java.awt.Frame parent, boolean modal, String name, String surname, String mobile, String email, String companyName) {
        super(parent, modal);
        initComponents();
        loadCompany();

        halfRoundedButton1.setEnabled(false);

        jComboBox1.setSelectedItem(companyName);
        roundedTextfields1.setText(name);
        roundedTextfields2.setText(surname);
        roundedTextfields3.setText(email);
        roundedTextfields4.setText(mobile);

        email = this.email;
    }

    private void loadCompany() {

        try {

            ResultSet resultSet = MySQL.executeSearch("SELECT * FROM `company`");

            Vector<String> vector = new Vector<>();
            vector.add("Select");

            while (resultSet.next()) {

                vector.add(resultSet.getString("name"));
                companyType.put(resultSet.getString("name"), resultSet.getString("id"));
            }

            DefaultComboBoxModel model = new DefaultComboBoxModel(vector);
            jComboBox1.setModel(model);

        } catch (Exception e) {
            logger.log(java.util.logging.Level.WARNING, "error in loading loadCompany", e);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new gui.RoundPanel();
        jLabel10 = new javax.swing.JLabel();
        roundPanel2 = new gui.RoundPanel();
        jLabel11 = new javax.swing.JLabel();
        roundedTextfields1 = new gui.RoundedTextfields();
        jLabel12 = new javax.swing.JLabel();
        roundedTextfields2 = new gui.RoundedTextfields();
        jLabel13 = new javax.swing.JLabel();
        roundedTextfields3 = new gui.RoundedTextfields();
        jLabel14 = new javax.swing.JLabel();
        roundedTextfields4 = new gui.RoundedTextfields();
        jLabel15 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        halfRoundedButton1 = new gui.HalfRoundedButton();
        halfRoundedButton2 = new gui.HalfRoundedButton();
        halfRoundedButton3 = new gui.HalfRoundedButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Company & Supplier Registration");
        setResizable(false);

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Poppins", 0, 24)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Supplier Registration");

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel10)
                .addGap(15, 15, 15))
        );

        roundPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel11.setText("Name");

        roundedTextfields1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel12.setText("Surname");

        roundedTextfields2.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel13.setText("E-mail");

        roundedTextfields3.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel14.setText("Mobile");

        roundedTextfields4.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel15.setText("Select a Company");

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
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

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(roundedTextfields1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(roundedTextfields3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(roundedTextfields2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(roundedTextfields4, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))))
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(halfRoundedButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(halfRoundedButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(halfRoundedButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 35, Short.MAX_VALUE))
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(roundedTextfields2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundedTextfields1, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(roundedTextfields3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(roundedTextfields4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(halfRoundedButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(halfRoundedButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(halfRoundedButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void halfRoundedButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_halfRoundedButton1ActionPerformed

        String company = String.valueOf(jComboBox1.getSelectedItem());
        String name = roundedTextfields1.getText();
        String surname = roundedTextfields2.getText();
        String email = roundedTextfields3.getText();
        String mobile = roundedTextfields4.getText();

        if (company.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please Select a Company", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Your Name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (surname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter your Surname", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Supplier Email", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!email.matches("^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@[^-][A-Za-z0-9\\+-]+(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$")) {
            JOptionPane.showMessageDialog(this, "Invalid Email", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (mobile.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Supplier Mobile", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!mobile.matches("^07[01245678]{1}[0-9]{7}$")) {
            JOptionPane.showMessageDialog(this, "Invalid Mobile Number", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            try {

                ResultSet resultSet = MySQL.executeSearch("SELECT * FROM `supplier` WHERE `mobile`='" + mobile + "'");

                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(this, "Supplier Already Registered", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {

                    MySQL.executeIUD("INSERT INTO `supplier` (`mobile`,`name`,`surname`,`email`,`company_id`) VALUES ('" + mobile + "','" + name + "','" + surname + "','" + email + "','" + companyType.get(company) + "')");

                    reset2();

                    this.dispose();

                }

            } catch (Exception e) {
                logger.log(java.util.logging.Level.WARNING, "error in inserting supplier details", e);
            }

        }

    }//GEN-LAST:event_halfRoundedButton1ActionPerformed

    private void halfRoundedButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_halfRoundedButton2ActionPerformed

        String fname = roundedTextfields1.getText();
        String lname = roundedTextfields2.getText();
        String email = roundedTextfields3.getText();
        String mobile = roundedTextfields4.getText();
        String cname = String.valueOf(jComboBox1.getSelectedItem());

        if (cname.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please Select a Company", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (fname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Your Name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (lname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter your Surname", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Supplier Email", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!email.matches("^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@[^-][A-Za-z0-9\\+-]+(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$")) {
            JOptionPane.showMessageDialog(this, "Invalid Email", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (mobile.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Supplier Mobile", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!mobile.matches("^07[01245678]{1}[0-9]{7}$")) {
            JOptionPane.showMessageDialog(this, "Invalid Mobile Number", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            try {

                ResultSet resultSet = MySQL.executeSearch("SELECT * FROM `supplier` WHERE `email`='" + email + "' AND `mobile`!='" + mobile + "'");

                if (resultSet.next()) {

                    JOptionPane.showMessageDialog(this, "Supplier Already Registered", "Warning", JOptionPane.WARNING_MESSAGE);

                } else {

                    MySQL.executeIUD("UPDATE `supplier` SET `name`='" + fname + "',  `surname`='" + lname + "', `email`='" + email + "', `company_id`='" + companyType.get(cname) + "' WHERE `mobile`='" + mobile + "'");

                    reset2();
                    this.dispose();
                }

            } catch (Exception e) {
                logger.log(java.util.logging.Level.WARNING, "error in updating supplier details", e);
            }

        }

    }//GEN-LAST:event_halfRoundedButton2ActionPerformed

    private void halfRoundedButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_halfRoundedButton3ActionPerformed
        reset2();
    }//GEN-LAST:event_halfRoundedButton3ActionPerformed

//    public static void main(String args[]) {
//        FlatMacLightLaf.setup();
//
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
////                new SupplierComRegistration().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.HalfRoundedButton halfRoundedButton1;
    private gui.HalfRoundedButton halfRoundedButton2;
    private gui.HalfRoundedButton halfRoundedButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private gui.RoundPanel roundPanel1;
    private gui.RoundPanel roundPanel2;
    private gui.RoundedTextfields roundedTextfields1;
    private gui.RoundedTextfields roundedTextfields2;
    private gui.RoundedTextfields roundedTextfields3;
    private gui.RoundedTextfields roundedTextfields4;
    // End of variables declaration//GEN-END:variables

    private void reset2() {

        roundedTextfields1.setText("");
        roundedTextfields2.setText("");
        roundedTextfields3.setText("");
        roundedTextfields4.setText("");
        jComboBox1.setSelectedIndex(0);

        jComboBox1.grabFocus();

    }
}
