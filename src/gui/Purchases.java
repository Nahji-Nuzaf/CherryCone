package gui;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.icons.FlatSearchIcon;
import static gui.SignInDep.logger;
import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import model.MySQL;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class Purchases extends javax.swing.JPanel {

    public Purchases() {
        initComponents();
        theader();
        loadGRN();
        init();
    }

    private void theader() {
        JTableHeader thead = jTable1.getTableHeader();
        thead.setForeground((new Color(255, 255, 255)));
        thead.setBackground(new Color(0, 0, 0));
        thead.setFont(new Font("Poppins", Font.BOLD, 12));
        TableColumn coll = jTable1.getColumnModel().getColumn(0);

        coll.setPreferredWidth(100);

        JTableHeader thead2 = jTable2.getTableHeader();
        thead2.setForeground((new Color(255, 255, 255)));
        thead2.setBackground(new Color(0, 0, 0));
        thead2.setFont(new Font("Poppins", Font.BOLD, 12));
        TableColumn coll2 = jTable2.getColumnModel().getColumn(0);

        coll2.setPreferredWidth(100);
    }

    private void init() {
        roundedTextfields1.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Search using GRN Id");
//        jTextField1.putClientProperty("JComponent.roundRect", true);
        roundedTextfields1.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new FlatSearchIcon());
    }

    String supName;

    private void loadGRN() {

        try {

            String query = "SELECT * FROM `grn` INNER JOIN `supplier` ON `grn`.`supplier_mobile`=`supplier`.`mobile`";

            String name = roundedTextfields1.getText();

            if (name != null) {
                query += "WHERE `grn`.`id` LIKE '%" + name + "%' ";
            }

            if (query.contains("WHERE")) {
                query += "AND ";
            } else {
                query += "WHERE ";
            }

            Date start = null;
            Date end = null;

            boolean isDateSelected = jDateChooser1.getDate() != null || jDateChooser2.getDate() != null;

            if (isDateSelected) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

                if (jDateChooser1.getDate() != null) {
                    start = jDateChooser1.getDate();
                    query += "`grn`.`date` >= '" + format.format(start) + "' ";
                }

                if (jDateChooser2.getDate() != null) {
                    if (jDateChooser1.getDate() != null) {
                        query += " AND ";
                    }
                    end = jDateChooser2.getDate();
                    query += "`grn`.`date` <= '" + format.format(end) + "' ";
                }

            }

            String sort = String.valueOf(jComboBox2.getSelectedItem());

            query += "ORDER BY ";
            query = query.replace("WHERE ORDER BY ", "ORDER BY ");
            query = query.replace("AND ORDER BY ", "ORDER BY ");

            if (sort.equals("Supply Date ASC")) {
                query += "`grn`.`date` ASC";
            } else if (sort.equals("Supply Date DESC")) {
                query += "`grn`.`date` DESC";
            } else if (sort.equals("GRN No ASC")) {
                query += "`grn`.`id` ASC";
            } else if (sort.equals("GRN No DESC")) {
                query += "`grn`.`id` DESC";
            } else if (sort.equals("Paid Amount ASC")) {
                query += "`grn`.`paid_amount` ASC";
            } else if (sort.equals("Paid Amount DESC")) {
                query += "`grn`.`paid_amount` DESC";
            }

            ResultSet rs = MySQL.executeSearch(query);

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (rs.next()) {

                Vector<String> vector = new Vector<>();
                vector.add(rs.getString("grn.id"));
                vector.add(rs.getString("supplier.name"));
                vector.add(rs.getString("grn.supplier_mobile"));
                vector.add(rs.getString("grn.company_name"));
                vector.add(rs.getString("grn.date"));
                vector.add(rs.getString("grn.paid_amount"));
                vector.add("Total");

                supName = rs.getString("supplier.name");

                model.addRow(vector);
            }

        } catch (Exception e) {
            logger.log(java.util.logging.Level.WARNING, "error in loading loadGRN in purchases", e);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new gui.RoundPanel();
        jLabel1 = new javax.swing.JLabel();
        roundPanel2 = new gui.RoundPanel();
        roundedTextfields1 = new gui.RoundedTextfields();
        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        halfRoundedButton1 = new gui.HalfRoundedButton();
        halfRoundedButton2 = new gui.HalfRoundedButton();
        halfRoundedButton3 = new gui.HalfRoundedButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        roundPanel3 = new gui.RoundPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        halfRoundedButton4 = new gui.HalfRoundedButton();
        roundedTextfields2 = new gui.RoundedTextfields();

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel1.setPreferredSize(new java.awt.Dimension(1382, 464));

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 34)); // NOI18N
        jLabel1.setText("Purchases");

        roundedTextfields1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                roundedTextfields1KeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        jLabel3.setText("Sort By");

        jComboBox2.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Supply Date ASC", "Supply Date DESC", "GRN No ASC", "GRN No DESC", "Paid Amount ASC", "Paid Amount DESC" }));
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        jLabel5.setText("Search");

        halfRoundedButton1.setBackground(new java.awt.Color(51, 102, 255));
        halfRoundedButton1.setForeground(new java.awt.Color(255, 255, 255));
        halfRoundedButton1.setText("Filter");
        halfRoundedButton1.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        halfRoundedButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                halfRoundedButton1ActionPerformed(evt);
            }
        });

        halfRoundedButton2.setForeground(new java.awt.Color(255, 255, 255));
        halfRoundedButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reset11.png"))); // NOI18N
        halfRoundedButton2.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        halfRoundedButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                halfRoundedButton2ActionPerformed(evt);
            }
        });

        halfRoundedButton3.setForeground(new java.awt.Color(255, 255, 255));
        halfRoundedButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-printer-20.png"))); // NOI18N
        halfRoundedButton3.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        halfRoundedButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                halfRoundedButton3ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        jLabel12.setText("Date");

        jLabel13.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        jLabel13.setText("From");

        jDateChooser1.setDateFormatString("yyyy-MM-dd");
        jDateChooser1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        jLabel14.setText("To");

        jDateChooser2.setDateFormatString("yyyy-MM-dd");
        jDateChooser2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(30, 30, 30)))
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(roundPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(roundedTextfields1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(100, 100, 100)
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel14))
                        .addGap(56, 56, 56)
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox2, 0, 210, Short.MAX_VALUE)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                        .addComponent(halfRoundedButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(halfRoundedButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)))
                .addComponent(halfRoundedButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(roundedTextfields1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(halfRoundedButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(halfRoundedButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(halfRoundedButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        jTable1.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "GRN Id", "Supplier Name", "Supplier Mobile", "Supplier Company", "Supply Date", "Paid Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setMinimumSize(new java.awt.Dimension(90, 100));
        jTable1.setRowHeight(25);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTable2.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stock Id", "Products", "Qty", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setRowHeight(25);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable2);

        jLabel6.setFont(new java.awt.Font("Poppins", 1, 15)); // NOI18N
        jLabel6.setText("Supplier Name");

        jLabel7.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel7.setText("Supplier Name");

        jLabel8.setFont(new java.awt.Font("Poppins", 1, 15)); // NOI18N
        jLabel8.setText("GRN Id");

        jLabel9.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 255));
        jLabel9.setText("GRN Number");

        jLabel10.setFont(new java.awt.Font("Poppins", 1, 15)); // NOI18N
        jLabel10.setText("Balance");

        jLabel11.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 51));
        jLabel11.setText("Balance");

        halfRoundedButton4.setBackground(new java.awt.Color(153, 255, 255));
        halfRoundedButton4.setText("Pay");
        halfRoundedButton4.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        halfRoundedButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                halfRoundedButton4ActionPerformed(evt);
            }
        });

        roundedTextfields2.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addComponent(roundedTextfields2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(halfRoundedButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, roundPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addGap(26, 26, 26)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(roundPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(halfRoundedButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(roundedTextfields2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30))))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1394, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void halfRoundedButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_halfRoundedButton3ActionPerformed

        try {

            String rowcount = String.valueOf(jTable1.getRowCount());
//            jLabel11.setText(rowcount);

            String path = "src\\reports\\Cherry_cone_purchases.jasper";

            HashMap<String, Object> para = new HashMap<>();
            para.put("Parameter1", rowcount);

            JRTableModelDataSource dataSource = new JRTableModelDataSource(jTable1.getModel());

            JasperPrint jasperPrint = JasperFillManager.fillReport(path, para, dataSource);

            JasperViewer.viewReport(jasperPrint, false);

        } catch (Exception e) {
            logger.log(java.util.logging.Level.WARNING, "error in generating puchases report", e);

        }

    }//GEN-LAST:event_halfRoundedButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

//        if (evt.getClickCount() == 2) {
//            
//        }
        try {

            int row = jTable1.getSelectedRow();
            String grnId = String.valueOf(jTable1.getValueAt(row, 0));
            String supname = String.valueOf(jTable1.getValueAt(row, 1));
//            String grnId = String.valueOf(jTable1.getValueAt(row, 0));

            String query = "SELECT * FROM `grn` INNER JOIN `grn_item` ON `grn`.`id` = `grn_item`.`grn_id` "
                    + "INNER JOIN `stock` ON `stock`.`id` = `grn_item`.`stock_id` "
                    + "INNER JOIN `products` ON `products`.`id` = `stock`.`products_id` "
                    + "WHERE `grn_item`.`grn_id` = '" + grnId + "'";

            ResultSet rs = MySQL.executeSearch(query);

            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.setRowCount(0);

            double total = 0;
            String paidAmount = null;
//                HashMap<Long, Double> grns = new HashMap<>();

//            if (!rs.next()) {
//                JOptionPane.showMessageDialog(this, "No Products for this GRN", "Warning", JOptionPane.WARNING_MESSAGE);
//            } else {
                while (rs.next()) {

                    Vector<String> vector = new Vector<>();
                    vector.add(rs.getString("stock.id"));
                    vector.add(rs.getString("products.name"));
                    vector.add(rs.getString("grn_item.qty"));
                    vector.add(rs.getString("grn_item.price"));

                    double qty = rs.getDouble("grn_item.qty");

                    double buyingPrice = rs.getDouble("grn_item.price");
                    paidAmount = rs.getString("grn.paid_amount");
                    double itemTotal = qty * buyingPrice;

                    //total = total + itemTotal;
                    total += itemTotal;

                    model.addRow(vector);

                    double pAmount = Double.parseDouble(String.valueOf(paidAmount));
                    jLabel11.setText(String.valueOf(total - pAmount));
                    jLabel7.setText(supname);
                    jLabel9.setText(grnId);

                }
//            }

        } catch (Exception e) {
            logger.log(java.util.logging.Level.WARNING, "error in loading purchased products", e);
        }


    }//GEN-LAST:event_jTable1MouseClicked

    private void halfRoundedButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_halfRoundedButton2ActionPerformed
        reset();
    }//GEN-LAST:event_halfRoundedButton2ActionPerformed

    private void halfRoundedButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_halfRoundedButton4ActionPerformed

        try {

            String balance = jLabel11.getText();
            String grnId = jLabel9.getText();
            String amtPaying = roundedTextfields2.getText();

            if (grnId.equals("GRN Number")) {
                JOptionPane.showMessageDialog(this, "Please Select a GRN to Pay", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (balance.equals("Balance")) {
                JOptionPane.showMessageDialog(this, "Please Select a GRN to Pay", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (balance.equals("0.0")) {
                JOptionPane.showMessageDialog(this, "Payment Already Done", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (amtPaying.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter The payment Amount", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {

                double amt = Double.parseDouble(amtPaying);

                MySQL.executeIUD("UPDATE `grn` SET `paid_amount` = `paid_amount` + '" + amt + "' WHERE `grn`.`id` = '" + grnId + "'");

                JOptionPane.showMessageDialog(this, "Success", "Warning", JOptionPane.WARNING_MESSAGE);
            }

            reset();
        } catch (Exception e) {
            logger.log(java.util.logging.Level.WARNING, "error in paying GRN Due amount", e);
        }

    }//GEN-LAST:event_halfRoundedButton4ActionPerformed

    private void roundedTextfields1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_roundedTextfields1KeyReleased
        loadGRN();
    }//GEN-LAST:event_roundedTextfields1KeyReleased

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        loadGRN();

    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void halfRoundedButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_halfRoundedButton1ActionPerformed
        loadGRN();
    }//GEN-LAST:event_halfRoundedButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.HalfRoundedButton halfRoundedButton1;
    private gui.HalfRoundedButton halfRoundedButton2;
    private gui.HalfRoundedButton halfRoundedButton3;
    private gui.HalfRoundedButton halfRoundedButton4;
    private javax.swing.JComboBox<String> jComboBox2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private gui.RoundPanel roundPanel1;
    private gui.RoundPanel roundPanel2;
    private gui.RoundPanel roundPanel3;
    private gui.RoundedTextfields roundedTextfields1;
    private gui.RoundedTextfields roundedTextfields2;
    // End of variables declaration//GEN-END:variables

    private void reset() {
        jTable1.clearSelection();
        jTable2.clearSelection();
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
        loadGRN();
        jLabel7.setText("Supplier Name");
        jLabel9.setText("GRN Number");
        jLabel11.setText("Balance");
        roundedTextfields2.setText("");

        roundedTextfields1.setText("");
        jDateChooser1.setDate(null);
        jDateChooser2.setDate(null);
        jComboBox2.setSelectedIndex(0);
        loadGRN();
    }
}
