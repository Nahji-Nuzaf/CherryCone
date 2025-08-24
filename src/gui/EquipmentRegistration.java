package gui;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import static gui.SignInDep.logger;
import javax.swing.ButtonModel;
import javax.swing.JOptionPane;
import model.MySQL;
import java.sql.ResultSet;

public class EquipmentRegistration extends javax.swing.JDialog {

    private String selectedId;

    public EquipmentRegistration(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        halfRoundedButton2.setEnabled(false);
    }

    public EquipmentRegistration(java.awt.Frame parent, boolean modal, String id, String name, String quantity, String catname, String price) {
        super(parent, modal);
        initComponents();
        halfRoundedButton1.setEnabled(false);
        halfRoundedButton3.setEnabled(false);

        this.selectedId = id;

        roundedTextfields1.setText(name);
        roundedTextfields2.setText(quantity);

        if (catname.equals("Storage")) {
            jCheckBox1.setSelected(true);
        }
        if (catname.equals("Serving")) {
            jCheckBox2.setSelected(true);
        }
        if (catname.equals("Preparation")) {
            jCheckBox3.setSelected(true);
        }

        roundedTextfields3.setText(price);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        roundPanel1 = new gui.RoundPanel();
        jLabel10 = new javax.swing.JLabel();
        roundPanel2 = new gui.RoundPanel();
        jLabel11 = new javax.swing.JLabel();
        roundedTextfields1 = new gui.RoundedTextfields();
        jLabel12 = new javax.swing.JLabel();
        roundedTextfields2 = new gui.RoundedTextfields();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        roundedTextfields3 = new gui.RoundedTextfields();
        halfRoundedButton1 = new gui.HalfRoundedButton();
        halfRoundedButton2 = new gui.HalfRoundedButton();
        halfRoundedButton3 = new gui.HalfRoundedButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Poppins", 0, 24)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Shop Equipment Registration");

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        jLabel12.setText("Quantity");

        roundedTextfields2.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N

        buttonGroup1.add(jCheckBox1);
        jCheckBox1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jCheckBox1.setText("Storage");
        jCheckBox1.setActionCommand("1");

        buttonGroup1.add(jCheckBox2);
        jCheckBox2.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jCheckBox2.setText("Serving");
        jCheckBox2.setActionCommand("2");

        buttonGroup1.add(jCheckBox3);
        jCheckBox3.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jCheckBox3.setText("Preparation");
        jCheckBox3.setActionCommand("3");

        jLabel13.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel13.setText("Category");

        jLabel14.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel14.setText("Price / Unit");

        roundedTextfields3.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N

        halfRoundedButton1.setBackground(new java.awt.Color(102, 255, 102));
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
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(roundedTextfields1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(roundedTextfields2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(roundedTextfields3, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jCheckBox3))
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(halfRoundedButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(halfRoundedButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(halfRoundedButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(roundedTextfields2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundedTextfields1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox2)
                    .addComponent(jCheckBox3))
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundedTextfields3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(35, 35, 35)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(halfRoundedButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(halfRoundedButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(halfRoundedButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        String name = roundedTextfields1.getText();
        String qty = roundedTextfields2.getText();
        String price = roundedTextfields3.getText();

        ButtonModel category = buttonGroup1.getSelection();

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Equipment Name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (qty.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Quantity", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!qty.matches("-?\\d*\\.?\\d+")) {
            JOptionPane.showMessageDialog(this, "Invalid Quantity", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (category == null) {
            JOptionPane.showMessageDialog(this, "Please Select a Category", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (price.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter the price per Unit", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!price.matches("-?\\d*\\.?\\d+")) {
            JOptionPane.showMessageDialog(this, "Invalid Price", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            try {

                ResultSet resultSet = MySQL.executeSearch("SELECT * FROM `equipment` WHERE `name`='" + name + "'");

                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(this, "Equipment Already Registered", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {

                    String catId = category.getActionCommand();

                    MySQL.executeIUD("INSERT INTO `equipment` (`name`,`quantity`,`price_per_unit`,`equipment_category_id`) VALUES ('" + name + "','" + qty + "','" + price + "','" + catId + "')");

                    reset();

                }

            } catch (Exception e) {
                logger.log(java.util.logging.Level.WARNING, "error in inserting equipment into db", e);
            }

        }

    }//GEN-LAST:event_halfRoundedButton1ActionPerformed

    private void halfRoundedButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_halfRoundedButton2ActionPerformed

        String name = roundedTextfields1.getText();
        String qty = roundedTextfields2.getText();
        String price = roundedTextfields3.getText();

        ButtonModel category = buttonGroup1.getSelection();

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Equipment Name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (qty.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Quantity", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!qty.matches("-?\\d*\\.?\\d+")) {
            JOptionPane.showMessageDialog(this, "Invalid Quantity", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (category == null) {
            JOptionPane.showMessageDialog(this, "Please Select a Category", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (price.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter the price per Unit", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!price.matches("-?\\d*\\.?\\d+")) {
            JOptionPane.showMessageDialog(this, "Invalid Price", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            try {

                ResultSet resultSet = MySQL.executeSearch("SELECT * FROM `equipment` WHERE `name`='" + name + "' AND `id`!='" + selectedId + "'");

                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(this, "Equipment Already Registered", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {

                    String catId = category.getActionCommand();

                    MySQL.executeIUD("UPDATE `equipment` SET `name`='" + name + "',`quantity`='" + qty + "',`price_per_unit`='" + price + "',`equipment_category_id`='" + catId + "' WHERE `id`='" + selectedId + "'");

                    reset();
                    this.dispose();

                }

            } catch (Exception e) {
                logger.log(java.util.logging.Level.WARNING, "error in updating equipment", e);
            }

        }

    }//GEN-LAST:event_halfRoundedButton2ActionPerformed

    private void halfRoundedButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_halfRoundedButton3ActionPerformed
        reset();
    }//GEN-LAST:event_halfRoundedButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        FlatMacLightLaf.setup();
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                EquipmentRegistration dialog = new EquipmentRegistration(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private gui.HalfRoundedButton halfRoundedButton1;
    private gui.HalfRoundedButton halfRoundedButton2;
    private gui.HalfRoundedButton halfRoundedButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private gui.RoundPanel roundPanel1;
    private gui.RoundPanel roundPanel2;
    private gui.RoundedTextfields roundedTextfields1;
    private gui.RoundedTextfields roundedTextfields2;
    private gui.RoundedTextfields roundedTextfields3;
    // End of variables declaration//GEN-END:variables

    private void reset() {

        roundedTextfields1.setText("");
        roundedTextfields2.setText("");
        roundedTextfields3.setText("");
        roundedTextfields1.grabFocus();

        buttonGroup1.clearSelection();

    }
}
