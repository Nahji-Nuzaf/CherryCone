package gui;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import static gui.SignInDep.logger;
import model.MySQL;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class ProductRegistration extends javax.swing.JDialog {

    private static HashMap<String, String> categoryMap = new HashMap<>();
    private String selectedId;

    public ProductRegistration(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        loadCategory();
        halfRoundedButton2.setEnabled(false);
    }

    public ProductRegistration(java.awt.Frame parent, boolean modal, String id, String proname, String catname, String flavour) {
        super(parent, modal);
        initComponents();
        loadCategory();
        halfRoundedButton1.setEnabled(false);
        halfRoundedButton3.setEnabled(false);
        this.selectedId = id;
        roundedTextfields1.setText(proname);
        jComboBox1.setSelectedItem(catname);
        roundedTextfields2.setText(flavour);
//        roundedTextfields1.setText(price);
    }

    private void loadCategory() {

        try {
            ResultSet resultSet = MySQL.executeSearch("SELECT * FROM `product_category`");

            Vector<String> vector = new Vector<>();
            vector.add("Select");

            while (resultSet.next()) {

                vector.add(resultSet.getString("name"));

                categoryMap.put(resultSet.getString("name"), resultSet.getString("id"));

                DefaultComboBoxModel model = new DefaultComboBoxModel(vector);
                jComboBox1.setModel(model);

            }

        } catch (Exception e) {
            logger.log(java.util.logging.Level.WARNING, "error in loading loadCategory in Product Reg", e);
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
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        halfRoundedButton1 = new gui.HalfRoundedButton();
        halfRoundedButton2 = new gui.HalfRoundedButton();
        halfRoundedButton3 = new gui.HalfRoundedButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Register Products");

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Poppins", 0, 24)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Product Registration");

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
        jLabel11.setText("Product Name");

        roundedTextfields1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel12.setText("Flavour");

        roundedTextfields2.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel13.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel13.setText("Product Category");

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
                    .addComponent(roundedTextfields1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roundedTextfields2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addComponent(halfRoundedButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(halfRoundedButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(halfRoundedButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1)
                    .addComponent(roundedTextfields1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundedTextfields2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(halfRoundedButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(halfRoundedButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(halfRoundedButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        String proname = roundedTextfields1.getText();
        String procat = String.valueOf(jComboBox1.getSelectedItem());
        String flavour = roundedTextfields2.getText();
//        String price = jTextField3.getText();

// if (price.isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Please Enter Product Price", "Warning", JOptionPane.WARNING_MESSAGE);
//        }else
        if (proname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Product Name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (procat.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please Select a Category", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (flavour.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Ice Cream Flavour", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            try {
                ResultSet resultSet = MySQL.executeSearch("SELECT * FROM `products` WHERE `name`='" + proname + "'");

                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(this, "Product Already Registered", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {

                    MySQL.executeIUD("INSERT INTO `products` (`name`,`flavour`,`product_category_id`) VALUES ('" + proname + "','" + flavour + "','" + categoryMap.get(procat) + "')");

                    reset();
                }

            } catch (Exception e) {
                logger.log(java.util.logging.Level.WARNING, "error in inserting product into DB", e);
            }

        }

    }//GEN-LAST:event_halfRoundedButton1ActionPerformed

    private void halfRoundedButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_halfRoundedButton2ActionPerformed

        try {

            String pname = roundedTextfields1.getText();
            String cname = String.valueOf(jComboBox1.getSelectedItem());
            String flavour = roundedTextfields2.getText();
//            String price = jTextField3.getText();

// if (price.isEmpty()) {
//                JOptionPane.showMessageDialog(this, "Please Enter Product Price", "Warning", JOptionPane.WARNING_MESSAGE);
//            }else
            if (pname.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter Product Name", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (cname.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Please Select a Category", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (flavour.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter Ice Cream Flavour", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {

                ResultSet resultSet = MySQL.executeSearch("SELECT * FROM `products` WHERE `name`='" + pname + "' AND `id`!='" + selectedId + "'");

                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(this, "Product Already Registered", "Warning", JOptionPane.WARNING_MESSAGE);

                } else {

                    MySQL.executeIUD("UPDATE `products` SET `name`='" + pname + "',`flavour`='" + flavour + "',`product_category_id`='" + categoryMap.get(cname) + "' WHERE `id`='" + selectedId + "'");

                    reset();
                    this.dispose();
                }

            }

        } catch (Exception e) {
            logger.log(java.util.logging.Level.WARNING, "error in Updating a product", e);
        }

    }//GEN-LAST:event_halfRoundedButton2ActionPerformed

    private void halfRoundedButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_halfRoundedButton3ActionPerformed
        reset();
    }//GEN-LAST:event_halfRoundedButton3ActionPerformed

//    public static void main(String args[]) {
//        FlatMacLightLaf.setup();
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                ProductRegistration dialog = new ProductRegistration(new javax.swing.JFrame(), true);
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
    private gui.HalfRoundedButton halfRoundedButton1;
    private gui.HalfRoundedButton halfRoundedButton2;
    private gui.HalfRoundedButton halfRoundedButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private gui.RoundPanel roundPanel1;
    private gui.RoundPanel roundPanel2;
    private gui.RoundedTextfields roundedTextfields1;
    private gui.RoundedTextfields roundedTextfields2;
    // End of variables declaration//GEN-END:variables

    private void reset() {

        roundedTextfields1.setText("");
        roundedTextfields2.setText("");
        jComboBox1.setSelectedIndex(0);

        roundedTextfields1.grabFocus();

    }
}
