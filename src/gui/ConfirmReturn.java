package gui;

import static gui.SignInDep.logger;
import model.MySQL;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.ButtonModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class ConfirmReturn extends javax.swing.JDialog {

    HashMap<String, String> ReturnReasonMap = new HashMap<>();

    private String proName;
    private String stockId;
    private String unitPrice;
    private String qty;
    private String cashierEmail;
    private String invoiceId;
    private String cusMobile;
    private String cusName;
    
    private boolean withdrawPoints = false;
    
    private Returns returns;

    public ConfirmReturn(java.awt.Frame parent, boolean modal, String pName, String stockId, String unitPrice, String qty, String cashierEmail, String invoiceId, String cusMobile, String cusName) {
        super(parent, modal);
        initComponents();

        this.proName = pName;
        this.stockId = stockId;
        this.unitPrice = unitPrice;
        this.qty = qty;
        this.cashierEmail = cashierEmail;
        this.invoiceId = invoiceId;
        this.cusMobile = cusMobile;
        this.cusName = cusName;
        this.returns = (Returns) parent;
        
        generateReturnId();
        loadDetails();
        loadReturnReason();

    }

    private void loadDetails() {
        jLabel25.setText(proName);
        jLabel26.setText(stockId);
        jLabel27.setText(unitPrice);
        jLabel30.setText(qty);
    }

    private void generateReturnId() {
        long id = System.currentTimeMillis();
        jLabel24.setText(String.valueOf(id));
    }

    private void loadReturnReason() {

        try {

            ResultSet resultSet = MySQL.executeSearch("SELECT * FROM `return_conditions`");

            Vector<String> vector = new Vector<>();
            vector.add("Select");

            while (resultSet.next()) {

                ReturnReasonMap.put(resultSet.getString("type"), resultSet.getString("id"));

                vector.add(resultSet.getString("type"));
            }

            DefaultComboBoxModel model = new DefaultComboBoxModel(vector);
            jComboBox1.setModel(model);

        } catch (Exception e) {
            logger.log(java.util.logging.Level.WARNING, "error in loading loadReturnReason", e);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        roundPanel1 = new gui.RoundPanel();
        jLabel21 = new javax.swing.JLabel();
        roundPanel2 = new gui.RoundPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        roundedTextfields1 = new gui.RoundedTextfields();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel32 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        roundedButton1 = new gui.RoundedButton();
        roundedButton2 = new gui.RoundedButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Confirm Return");

        roundPanel1.setBackground(new java.awt.Color(255, 204, 255));

        jLabel21.setFont(new java.awt.Font("Poppins", 0, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 0, 0));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Confirm Return");

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                .addContainerGap())
        );

        roundPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel5.setText("Return ID                     :");

        jLabel24.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel24.setText("Return ID Here");
        jLabel24.setToolTipText("");

        jLabel22.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel22.setText("Product Name         :");

        jLabel25.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel25.setText("Pro... Name Here");

        jLabel23.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel23.setText("Stock ID                      :");

        jLabel26.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel26.setText("Stock ID Here");

        jLabel27.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel27.setText("Unit Price Here");

        jLabel28.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel28.setText("Unit Price                   :");

        jLabel29.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel29.setText("Returning Quantity");

        roundedTextfields1.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        roundedTextfields1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                roundedTextfields1KeyReleased(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel30.setText("(.........)");

        jLabel31.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel31.setText("Return Reason");

        jComboBox1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel32.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel32.setText("Refund Amount");

        jFormattedTextField1.setEditable(false);
        jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jFormattedTextField1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N

        buttonGroup1.add(jCheckBox1);
        jCheckBox1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jCheckBox1.setText("Add to Points");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jCheckBox1.setActionCommand("1");

        buttonGroup1.add(jCheckBox2);
        jCheckBox2.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jCheckBox2.setText("Exchange a Product");
        jCheckBox2.setActionCommand("2");

        roundedButton1.setBackground(new java.awt.Color(153, 255, 153));
        roundedButton1.setText("Accept Return");
        roundedButton1.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        roundedButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roundedButton1ActionPerformed(evt);
            }
        });

        roundedButton2.setBackground(new java.awt.Color(255, 51, 51));
        roundedButton2.setForeground(new java.awt.Color(255, 255, 255));
        roundedButton2.setText("Cancel");
        roundedButton2.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                                .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(roundPanel2Layout.createSequentialGroup()
                                    .addComponent(roundedTextfields1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel30))
                                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(roundedButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(roundedButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jCheckBox1)
                .addGap(38, 38, 38)
                .addComponent(jCheckBox2)
                .addContainerGap(84, Short.MAX_VALUE))
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roundedTextfields1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox2))
                .addGap(30, 30, 30)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roundedButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roundedButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void roundedTextfields1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_roundedTextfields1KeyReleased

        String qty = String.valueOf(roundedTextfields1.getText());
        String unitPrice = String.valueOf(jLabel27.getText());

        if (!qty.matches("-?\\d*\\.?\\d+")) {
            JOptionPane.showMessageDialog(this, "Cannot use letter or symbols", "Warning", JOptionPane.WARNING_MESSAGE);
            roundedTextfields1.setText("");
        } else {
            Double refundAmt = Double.parseDouble(qty) * Double.parseDouble(unitPrice);
            jFormattedTextField1.setText(String.valueOf(refundAmt));
        }

    }//GEN-LAST:event_roundedTextfields1KeyReleased

    private void roundedButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roundedButton1ActionPerformed

        try {

            String qty = roundedTextfields1.getText();
            String soldQty = jLabel30.getText();
            String stockId = jLabel26.getText();
            String returnId = jLabel24.getText();
            String dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

            String returnReasonId = ReturnReasonMap.get(String.valueOf(jComboBox1.getSelectedItem()));
            String refundAmt = jFormattedTextField1.getText();
            String returnReason = String.valueOf(jComboBox1.getSelectedItem());

            ButtonModel returnType = buttonGroup1.getSelection();

            if (!qty.matches("-?\\d*\\.?\\d+")) {
                JOptionPane.showMessageDialog(this, "Cannot use letter or symbols", "Warning", JOptionPane.WARNING_MESSAGE);
                roundedTextfields1.setText("");
            } else if (qty.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter Returning Quantity", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (Double.parseDouble(qty) > Double.parseDouble(soldQty)) {
                JOptionPane.showMessageDialog(this, "Please enter the correct Quantity", "Warning", JOptionPane.WARNING_MESSAGE);
            } else  if (Double.parseDouble(qty) == 0) {
                JOptionPane.showMessageDialog(this, "Quantity cannot be 0", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (returnReason.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Please Select a Returning Reason", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (returnType == null) {
                JOptionPane.showMessageDialog(this, "Please Select a Method", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {

                int rtId = Integer.parseInt(returnType.getActionCommand());

                MySQL.executeIUD("INSERT INTO `cashier_returns` (`id`,`date`,`refund_amount`,`return_conditions_id`,`employee_email`,`invoice_id`,`return_type_id`) "
                        + "VALUES ('" + returnId + "','" + dateTime + "','" + refundAmt + "','" + returnReasonId + "','" + cashierEmail + "','" + invoiceId + "','" + rtId + "') ");

//                MySQL.executeIUD("INSERT INTO `cashier_returns` (`id`,`date`,`return_amount`,`cashier_return_condition_id`,`employee_id`,`invoice_id`,`return_value_id`) "
//                        + "VALUES ('" + returnId + "','" + dateTime + "','" + refundAmt + "','" + returnReasonId + "','" + empId + "','" + invoiceId + "','" + rvId + "')");
                MySQL.executeIUD("INSERT INTO `cashier_return_items` (`qty`,`cashier_returns_id`,`stock_id`) "
                        + " VALUES ('" + qty + "','" + returnId + "','" + stockId + "')");

                ResultSet rs1 = MySQL.executeSearch("SELECT * FROM `invoice_item` WHERE `invoice_id` = '" + invoiceId + "' AND `stock_id`='" + stockId + "'");

                Double soldqty = null;
                if (rs1.next()) {
                    soldqty = Double.parseDouble(rs1.getString("qty"));
                }

                if (soldqty.equals(qty)) {
                    MySQL.executeIUD("DELETE FROM `invoice_item` WHERE `invoice_id` = '" + invoiceId + "' AND `stock_id`='" + stockId + "'");
                } else {
                    MySQL.executeIUD("UPDATE `invoice_item` SET `qty` = `qty` - '" + qty + "' WHERE  `invoice_id` = '" + invoiceId + "' AND `stock_id`='" + stockId + "'");
                }

                if (rtId == 1) {

                    double updatePoints = Double.parseDouble(jFormattedTextField1.getText()) / 5;

                    ResultSet resultset = MySQL.executeSearch("SELECT * FROM `customer`");
                    Double points = null;
                    while (resultset.next()) {
                        points = Double.parseDouble(resultset.getString("points"));
                    }

                    //update points
                    if (withdrawPoints) {
                        points += updatePoints;
                        MySQL.executeIUD("UPDATE `customer` SET `points` = '" + updatePoints + "' WHERE `mobile` = '" + cusMobile + "'");
                    } else {
                        MySQL.executeIUD("UPDATE `customer` SET `points` = `points` + '" + updatePoints + "' WHERE `mobile` = '" + cusMobile + "'");
                    }

                    JOptionPane.showMessageDialog(this, "Success", "Warning", JOptionPane.INFORMATION_MESSAGE);

                } else if (rtId == 2) {

                    POSDashboard pos = new POSDashboard();
                    pos.setVisible(true);

                    if (pos != null) {

                        pos.getRefundAmt().setText(String.valueOf(refundAmt));
                        pos.getCusMobile().setText(cusMobile);
                        pos.getCusName().setText(cusName);
                        pos.openPOSDash();

//                        JOptionPane.showMessageDialog(this, "Success", "Warning", JOptionPane.INFORMATION_MESSAGE);
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "No Options have been Selected", "Warning", JOptionPane.INFORMATION_MESSAGE);
                }

//                this.enableEvents(EXIT_ON_CLOSE);

                returns.dispose();

                this.dispose();

            }

        } catch (Exception e) {
            logger.log(java.util.logging.Level.WARNING, "error in Exchange products", e);
        }

    }//GEN-LAST:event_roundedButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    //    public static void main(String args[]) {
    //        /* Set the Nimbus look and feel */
    //        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    //        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
    //         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
    //         */
    //        try {
    //            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
    //                if ("Nimbus".equals(info.getName())) {
    //                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
    //                    break;
    //                }
    //            }
    //        } catch (ClassNotFoundException ex) {
    //            java.util.logging.Logger.getLogger(ConfirmReturn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //        } catch (InstantiationException ex) {
    //            java.util.logging.Logger.getLogger(ConfirmReturn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //        } catch (IllegalAccessException ex) {
    //            java.util.logging.Logger.getLogger(ConfirmReturn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
    //            java.util.logging.Logger.getLogger(ConfirmReturn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //        }
    //        //</editor-fold>
    //
    //        /* Create and display the dialog */
    //        java.awt.EventQueue.invokeLater(new Runnable() {
    //            public void run() {
    //                ConfirmReturn dialog = new ConfirmReturn(new javax.swing.JFrame(), true);
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
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel5;
    private gui.RoundPanel roundPanel1;
    private gui.RoundPanel roundPanel2;
    private gui.RoundedButton roundedButton1;
    private gui.RoundedButton roundedButton2;
    private gui.RoundedTextfields roundedTextfields1;
    // End of variables declaration//GEN-END:variables
}
