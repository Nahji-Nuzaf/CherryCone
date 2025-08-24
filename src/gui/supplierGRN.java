package gui;

import static gui.SignInDep.logger;
import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import model.GRNItem;
import model.MySQL;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class supplierGRN extends javax.swing.JPanel {

    HashMap<String, GRNItem> GRNItemMap = new HashMap<>();

    public supplierGRN(String email, String fname, String lname, String mobile) {
        initComponents();
        generateGRNId();
        loadGRNItem();

        jLabel23.setText(fname + " " + lname);
        jLabel25.setText(email);
        jLabel27.setText(mobile);
    }

    private void generateGRNId() {
        long id = System.currentTimeMillis();
        jLabel17.setText(String.valueOf(id));
    }

    //name
    public JLabel getjLabel29() {
        return jLabel29;
    }

    //mobile
    public JLabel getjLabel31() {
        return jLabel31;
    }

    //email
    public JLabel getjLabel33() {
        return jLabel33;
    }

    //company name
    public JLabel getjLabel37() {
        return jLabel37;
    }

    //company hotline
    public JLabel getjLabel39() {
        return jLabel39;
    }

    //product ID
    public JLabel getjLabel41() {
        return jLabel41;
    }

    //product name
    public JLabel getjLabel46() {
        return jLabel46;
    }

    private void theader() {
        JTableHeader thead = jTable1.getTableHeader();
        thead.setForeground((new Color(255, 255, 255)));
        thead.setBackground(new Color(0, 0, 0));
        thead.setFont(new Font("Poppins", Font.BOLD, 12));
        TableColumn coll = jTable1.getColumnModel().getColumn(0);

        coll.setPreferredWidth(100);
    }

    private void loadGRNItem() {

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        double total = 0;

        for (GRNItem grnItem : GRNItemMap.values()) {

            Vector<String> vector = new Vector<>();
            vector.add(grnItem.getProductId());
            vector.add(grnItem.getStockid());
            vector.add(grnItem.getProductName());
            vector.add(String.valueOf(grnItem.getQty()));
            vector.add(String.valueOf(grnItem.getBuyingPrice()));
            vector.add(String.valueOf(grnItem.getSellingPrice()));
            vector.add(format.format(grnItem.getMfd()));
            vector.add(format.format(grnItem.getExp()));

            double itemTotal = grnItem.getQty() * grnItem.getBuyingPrice();
            total += itemTotal;
            vector.add(String.valueOf(itemTotal));

            model.addRow(vector);
        }

        jLabel54.setText(String.valueOf(total));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new gui.RoundPanel();
        roundPanel6 = new gui.RoundPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        roundPanel2 = new gui.RoundPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        halfRoundedButton5 = new gui.HalfRoundedButton();
        halfRoundedButton7 = new gui.HalfRoundedButton();
        roundPanel3 = new gui.RoundPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        halfRoundedButton8 = new gui.HalfRoundedButton();
        halfRoundedButton9 = new gui.HalfRoundedButton();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        halfRoundedButton12 = new gui.HalfRoundedButton();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel35 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        roundPanel4 = new gui.RoundPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        halfRoundedButton10 = new gui.HalfRoundedButton();
        halfRoundedButton11 = new gui.HalfRoundedButton();
        halfRoundedButton13 = new gui.HalfRoundedButton();
        halfRoundedButton14 = new gui.HalfRoundedButton();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jFormattedTextField3 = new javax.swing.JFormattedTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        halfRoundedButton16 = new gui.HalfRoundedButton();
        jLabel57 = new javax.swing.JLabel();
        jFormattedTextField5 = new javax.swing.JFormattedTextField();
        roundPanel5 = new gui.RoundPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        halfRoundedButton6 = new gui.HalfRoundedButton();
        jLabel48 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jFormattedTextField4 = new javax.swing.JFormattedTextField();
        halfRoundedButton15 = new gui.HalfRoundedButton();
        halfRoundedButton17 = new gui.HalfRoundedButton();

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel1.setPreferredSize(new java.awt.Dimension(1283, 640));
        roundPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 255));
        jLabel1.setText("GRN");

        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-supplier-50.png"))); // NOI18N

        jLabel16.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel16.setText("GRN No");

        jLabel17.setFont(new java.awt.Font("Poppins", 0, 17)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 255));
        jLabel17.setText("GRN No");

        javax.swing.GroupLayout roundPanel6Layout = new javax.swing.GroupLayout(roundPanel6);
        roundPanel6.setLayout(roundPanel6Layout);
        roundPanel6Layout.setHorizontalGroup(
            roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel6Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(752, Short.MAX_VALUE))
        );
        roundPanel6Layout.setVerticalGroup(
            roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                    .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        roundPanel1.add(roundPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 1380, -1));

        jLabel18.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 0, 0));
        jLabel18.setText("Employee Information");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-employee-30.png"))); // NOI18N

        jLabel20.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel20.setText("Employee Name");

        jLabel23.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        jLabel23.setText("...");

        jLabel24.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel24.setText("Employee Email");

        jLabel25.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        jLabel25.setText("...");

        jLabel26.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel26.setText("Employee Mobile");

        jLabel27.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        jLabel27.setText("....");

        halfRoundedButton5.setBackground(new java.awt.Color(51, 255, 0));
        halfRoundedButton5.setText("Next");
        halfRoundedButton5.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        halfRoundedButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                halfRoundedButton5MouseClicked(evt);
            }
        });

        halfRoundedButton7.setBackground(new java.awt.Color(255, 0, 0));
        halfRoundedButton7.setForeground(new java.awt.Color(255, 255, 255));
        halfRoundedButton7.setText("Cancel");
        halfRoundedButton7.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        halfRoundedButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                halfRoundedButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel18)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel11))
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(163, 163, 163)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(327, 327, 327)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(163, 163, 163)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(180, 180, 180)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(halfRoundedButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(halfRoundedButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(84, 84, 84))
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 244, Short.MAX_VALUE)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(halfRoundedButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(halfRoundedButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );

        jTabbedPane1.addTab("Employee Information", roundPanel2);

        jLabel19.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 0, 0));
        jLabel19.setText("Supplier & Company Information");

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-supplier-25.png"))); // NOI18N

        halfRoundedButton8.setBackground(new java.awt.Color(51, 255, 0));
        halfRoundedButton8.setText("Next");
        halfRoundedButton8.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        halfRoundedButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                halfRoundedButton8ActionPerformed(evt);
            }
        });

        halfRoundedButton9.setText("Previous");
        halfRoundedButton9.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        halfRoundedButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                halfRoundedButton9ActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel28.setText("Supplier Name");

        jLabel29.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        jLabel29.setText("...");

        halfRoundedButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-plus-20.png"))); // NOI18N
        halfRoundedButton12.setText("Select Supplier");
        halfRoundedButton12.setToolTipText("");
        halfRoundedButton12.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        halfRoundedButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                halfRoundedButton12ActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel30.setText("Supplier Mobile");

        jLabel31.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        jLabel31.setText("....");

        jLabel32.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel32.setText("Supplier E-mail");

        jLabel33.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        jLabel33.setText("....");

        jLabel34.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 0, 255));
        jLabel34.setText("Supplier Information");

        jSeparator1.setForeground(new java.awt.Color(0, 0, 255));

        jLabel35.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 0, 255));
        jLabel35.setText("Company Information");

        jSeparator2.setForeground(new java.awt.Color(0, 0, 255));

        jLabel36.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel36.setText("Company Name");

        jLabel37.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        jLabel37.setText("....");

        jLabel38.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel38.setText("Company Hotline");

        jLabel39.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        jLabel39.setText(".....");

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(halfRoundedButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(halfRoundedButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(halfRoundedButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(roundPanel3Layout.createSequentialGroup()
                                .addGap(189, 189, 189)
                                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(80, 80, 80)
                                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 1244, Short.MAX_VALUE)
                            .addComponent(jSeparator2)))
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(80, 80, 80)
                        .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(80, 80, 80)
                        .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(halfRoundedButton12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(30, 30, 30)
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(halfRoundedButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(halfRoundedButton9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        jTabbedPane1.addTab("Supplier Information", roundPanel3);

        jLabel21.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 0, 0));
        jLabel21.setText("Product Information");

        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-ice-cream-25.png"))); // NOI18N

        halfRoundedButton10.setBackground(new java.awt.Color(51, 255, 0));
        halfRoundedButton10.setText("Next");
        halfRoundedButton10.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        halfRoundedButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                halfRoundedButton10ActionPerformed(evt);
            }
        });

        halfRoundedButton11.setText("Previous");
        halfRoundedButton11.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        halfRoundedButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                halfRoundedButton11ActionPerformed(evt);
            }
        });

        halfRoundedButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-plus-20.png"))); // NOI18N
        halfRoundedButton13.setText("Select Product");
        halfRoundedButton13.setToolTipText("");
        halfRoundedButton13.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        halfRoundedButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                halfRoundedButton13ActionPerformed(evt);
            }
        });

        halfRoundedButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-search-15.png"))); // NOI18N
        halfRoundedButton14.setText("Search Stock");
        halfRoundedButton14.setToolTipText("");
        halfRoundedButton14.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        halfRoundedButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                halfRoundedButton14ActionPerformed(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(51, 51, 255));
        jLabel40.setText("Product Id");

        jLabel41.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(0, 0, 255));
        jLabel41.setText("...");

        jLabel43.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(51, 51, 255));
        jLabel43.setText("Product Name");

        jLabel46.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        jLabel46.setText("....");

        jLabel47.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(51, 51, 255));
        jLabel47.setText("Product Quantity");

        jLabel49.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(51, 51, 255));
        jLabel49.setText("Buying Price");

        jLabel52.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(51, 51, 255));
        jLabel52.setText("Selling Price");

        jLabel53.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(51, 51, 255));
        jLabel53.setText("MFD");

        jLabel55.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(51, 51, 255));
        jLabel55.setText("EXP");

        jFormattedTextField1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N

        jFormattedTextField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jFormattedTextField2.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N

        jFormattedTextField3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jFormattedTextField3.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N

        jDateChooser1.setDateFormatString("yyyy-MM-dd");
        jDateChooser1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N

        jDateChooser2.setDateFormatString("yyyy-MM-dd");
        jDateChooser2.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N

        halfRoundedButton16.setText("Reset All");
        halfRoundedButton16.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        halfRoundedButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                halfRoundedButton16ActionPerformed(evt);
            }
        });

        jLabel57.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(51, 51, 255));
        jLabel57.setText("Stock Id");

        jFormattedTextField5.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N

        javax.swing.GroupLayout roundPanel4Layout = new javax.swing.GroupLayout(roundPanel4);
        roundPanel4.setLayout(roundPanel4Layout);
        roundPanel4Layout.setHorizontalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(halfRoundedButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(halfRoundedButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
            .addGroup(roundPanel4Layout.createSequentialGroup()
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel4Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel4Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(roundPanel4Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(41, 41, 41)
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel4Layout.createSequentialGroup()
                        .addComponent(halfRoundedButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(halfRoundedButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel4Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(roundPanel4Layout.createSequentialGroup()
                                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel4Layout.createSequentialGroup()
                                        .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                                                .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(97, 97, 97))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel4Layout.createSequentialGroup()
                                        .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jFormattedTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(123, 123, 123)))
                                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                        .addComponent(jFormattedTextField1))
                                    .addComponent(halfRoundedButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jFormattedTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(351, Short.MAX_VALUE))
        );
        roundPanel4Layout.setVerticalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel4Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(halfRoundedButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(halfRoundedButton14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35)
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel4Layout.createSequentialGroup()
                        .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roundPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(roundPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(30, 30, 30)
                        .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(roundPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jFormattedTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(roundPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(halfRoundedButton16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(83, 83, 83)
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(halfRoundedButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(halfRoundedButton11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        jTabbedPane1.addTab("Product Information", roundPanel4);

        jLabel22.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 255));
        jLabel22.setText("Final GRN");

        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-reciept-25.png"))); // NOI18N

        jTable1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Id", "Stock Id", "Name", "Quantity", "Buying Price", "Selling Price", "MFD", "EXP", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(25);
        jScrollPane1.setViewportView(jTable1);

        halfRoundedButton6.setBackground(new java.awt.Color(0, 255, 51));
        halfRoundedButton6.setText("Submit & Print GRN");
        halfRoundedButton6.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        halfRoundedButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                halfRoundedButton6ActionPerformed(evt);
            }
        });

        jLabel48.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(51, 51, 255));
        jLabel48.setText("Total");

        jLabel50.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(51, 51, 255));
        jLabel50.setText("Payment");

        jLabel51.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(51, 51, 255));
        jLabel51.setText("Balance");

        jLabel54.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel54.setText("0.00");

        jLabel56.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel56.setText("0.00");

        jFormattedTextField4.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jFormattedTextField4.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jFormattedTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jFormattedTextField4KeyReleased(evt);
            }
        });

        halfRoundedButton15.setText("Previous");
        halfRoundedButton15.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        halfRoundedButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                halfRoundedButton15ActionPerformed(evt);
            }
        });

        halfRoundedButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bin.png"))); // NOI18N
        halfRoundedButton17.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        halfRoundedButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                halfRoundedButton17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel5Layout = new javax.swing.GroupLayout(roundPanel5);
        roundPanel5.setLayout(roundPanel5Layout);
        roundPanel5Layout.setHorizontalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel5Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(halfRoundedButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 883, Short.MAX_VALUE)
                        .addGroup(roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel5Layout.createSequentialGroup()
                                .addComponent(halfRoundedButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(halfRoundedButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(roundPanel5Layout.createSequentialGroup()
                                        .addGroup(roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(roundPanel5Layout.createSequentialGroup()
                                                .addGap(24, 24, 24)
                                                .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(roundPanel5Layout.createSequentialGroup()
                                                .addGap(26, 26, 26)
                                                .addComponent(jFormattedTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))))))))
                .addGap(25, 25, 25))
        );
        roundPanel5Layout.setVerticalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel5Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(halfRoundedButton17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(halfRoundedButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(halfRoundedButton15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        jTabbedPane1.addTab("Final GRN", roundPanel5);

        roundPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 1380, 580));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1422, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void halfRoundedButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_halfRoundedButton5MouseClicked
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_halfRoundedButton5MouseClicked

    private void halfRoundedButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_halfRoundedButton12ActionPerformed
        Entities ent = new Entities();
        ent.setVisible(true);
        ent.setGRN(this);
        ent.switchToTab(2);  // Index 1 = Tab 2
    }//GEN-LAST:event_halfRoundedButton12ActionPerformed

    private void halfRoundedButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_halfRoundedButton8ActionPerformed

        if (jLabel29.getText().equals("...")) {
            JOptionPane.showMessageDialog(this, "Please Select a Supplier", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            jTabbedPane1.setSelectedIndex(2);
        }
    }//GEN-LAST:event_halfRoundedButton8ActionPerformed

    private void halfRoundedButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_halfRoundedButton13ActionPerformed
        Assets ass = new Assets();
        ass.setVisible(true);
        ass.setGrn(this);
        ass.switchToTab(0);  // Index 1 = Tab 2
    }//GEN-LAST:event_halfRoundedButton13ActionPerformed

    private void halfRoundedButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_halfRoundedButton14ActionPerformed
        Stock stock = new Stock();
        stock.setVisible(true);
    }//GEN-LAST:event_halfRoundedButton14ActionPerformed

    private void halfRoundedButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_halfRoundedButton10ActionPerformed

        int x = jTable1.getRowCount();

        String supplierName = jLabel29.getText();
        String supplierMobile = jLabel31.getText();
        String pid = jLabel41.getText();
        String proName = jLabel46.getText();
        String qty = jFormattedTextField1.getText();
        String buying_price = jFormattedTextField2.getText();
        String selling_price = jFormattedTextField3.getText();
//        int sid = Integer.parseInt();
//        String stockId = jFormattedTextField5.getText();
        String sid = jFormattedTextField5.getText();
        Date mfd = jDateChooser1.getDate();
        Date exp = jDateChooser2.getDate();

        if (x == 0) {
//            JOptionPane.showMessageDialog(this, "Please Select a Product", "Warning", JOptionPane.ERROR_MESSAGE);

            if (supplierName.equals("...")) {
                JOptionPane.showMessageDialog(this, "Please Select a Supplier First", "Warning", JOptionPane.ERROR_MESSAGE);
            } else if (supplierMobile.equals("...")) {
                JOptionPane.showMessageDialog(this, "Please Select a Supplier First", "Warning", JOptionPane.ERROR_MESSAGE);
            } else if (pid.equals("...")) {
                JOptionPane.showMessageDialog(this, "Please Select a Product to update Stock", "Warning", JOptionPane.ERROR_MESSAGE);
            } else if (sid.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter Stock Id", "Warning", JOptionPane.ERROR_MESSAGE);
            } else if (!sid.matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "Invalid Stock Id", "Warning", JOptionPane.ERROR_MESSAGE);
                jFormattedTextField5.setText("");
            } else if (buying_price.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter Buying Price", "Warning", JOptionPane.ERROR_MESSAGE);
            } else if (!buying_price.matches("-?\\d*\\.?\\d+")) {
                JOptionPane.showMessageDialog(this, "Invalid Buying price", "Warning", JOptionPane.ERROR_MESSAGE);
                jFormattedTextField2.setText("");
            } else if (selling_price.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter Selling Price", "Warning", JOptionPane.ERROR_MESSAGE);
            } else if (!selling_price.matches("-?\\d*\\.?\\d+")) {
                JOptionPane.showMessageDialog(this, "Invalid Selling price", "Warning", JOptionPane.ERROR_MESSAGE);
                jFormattedTextField3.setText("");
            } else if (qty.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter Quantity", "Warning", JOptionPane.ERROR_MESSAGE);
            } else if (!qty.matches("-?\\d*\\.?\\d+")) {
                JOptionPane.showMessageDialog(this, "Invalid Quantity", "Warning", JOptionPane.ERROR_MESSAGE);
                jFormattedTextField1.setText("");
            } else if (mfd == null) {
                JOptionPane.showMessageDialog(this, "Please Enter Manufacture Date", "Warning", JOptionPane.ERROR_MESSAGE);
            } else if (exp == null) {
                JOptionPane.showMessageDialog(this, "Please Enter Expiry Date", "Warning", JOptionPane.ERROR_MESSAGE);
            } else {

                try {

                    double quantity = Double.parseDouble(qty);

                    GRNItem grnItem = new GRNItem();
                    grnItem.setProductId(jLabel41.getText());
                    grnItem.setStockid(sid);
                    grnItem.setProductName(jLabel46.getText());
                    grnItem.setQty(quantity);
                    grnItem.setBuyingPrice(Double.parseDouble(buying_price));
                    grnItem.setSellingPrice(Double.parseDouble(selling_price));
                    grnItem.setMfd(mfd);
                    grnItem.setExp(exp);

                    if (GRNItemMap.get(jLabel41.getText()) == null) {
                        GRNItemMap.put(jLabel41.getText(), grnItem);
                        loadGRNItem();
                    } else {

                        GRNItem found = GRNItemMap.get(pid);

                        int option = JOptionPane.showConfirmDialog(this, "Do you want to Update the Quantity of Product :" + proName, "Message",
                                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

                        if (option == JOptionPane.YES_OPTION) {

                            if (found.getExp().compareTo(exp) == 0
                                    && found.getMfd().compareTo(mfd) == 0
                                    && found.getBuyingPrice() == Double.parseDouble(buying_price)
                                    && found.getSellingPrice() == Double.parseDouble(selling_price)) {

                                found.setQty(found.getQty() + Double.parseDouble(qty));
                                loadGRNItem();
                            } else {
                                JOptionPane.showMessageDialog(this, "GRN Items already exist with different dates and prices", "Warning", JOptionPane.ERROR_MESSAGE);
                            }

                        }

//            JOptionPane.showMessageDialog(this, "Please Select OR Add a Product to update Stock", "Warning", JOptionPane.WARNING_MESSAGE);
                    }

                    jTabbedPane1.setSelectedIndex(3);

                } catch (Exception e) {
                    logger.log(java.util.logging.Level.WARNING, "error in inserting data to GRN Table", e);
                }

            }

        } else {

            if (pid.equals("...")) {
                jTabbedPane1.setSelectedIndex(3);
            } else {

                if (supplierName.equals("...")) {
                    JOptionPane.showMessageDialog(this, "Please Select a Supplier First", "Warning", JOptionPane.ERROR_MESSAGE);
                } else if (supplierMobile.equals("...")) {
                    JOptionPane.showMessageDialog(this, "Please Select a Supplier First", "Warning", JOptionPane.ERROR_MESSAGE);
                } else if (pid.equals("...")) {
                    JOptionPane.showMessageDialog(this, "Please Select a Product to update Stock", "Warning", JOptionPane.ERROR_MESSAGE);
                } else if (sid.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please Enter Stock Id", "Warning", JOptionPane.ERROR_MESSAGE);
                } else if (buying_price.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please Enter Buying Price", "Warning", JOptionPane.ERROR_MESSAGE);
                } else if (selling_price.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please Enter Selling Price", "Warning", JOptionPane.ERROR_MESSAGE);
                } else if (qty.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please Enter Quantity", "Warning", JOptionPane.ERROR_MESSAGE);
                } else if (mfd == null) {
                    JOptionPane.showMessageDialog(this, "Please Enter Manufacture Date", "Warning", JOptionPane.ERROR_MESSAGE);
                } else if (exp == null) {
                    JOptionPane.showMessageDialog(this, "Please Enter Expiry Date", "Warning", JOptionPane.ERROR_MESSAGE);
                } else {

                    try {

                        double quantity = Double.parseDouble(qty);

                        GRNItem grnItem = new GRNItem();
                        grnItem.setProductId(jLabel41.getText());
                        grnItem.setStockid(sid);
                        grnItem.setProductName(jLabel46.getText());
                        grnItem.setQty(quantity);
                        grnItem.setBuyingPrice(Double.parseDouble(buying_price));
                        grnItem.setSellingPrice(Double.parseDouble(selling_price));
                        grnItem.setMfd(mfd);
                        grnItem.setExp(exp);

                        if (GRNItemMap.get(jLabel41.getText()) == null) {
                            GRNItemMap.put(jLabel41.getText(), grnItem);
                            loadGRNItem();
                        } else {

                            GRNItem found = GRNItemMap.get(pid);

                            int option = JOptionPane.showConfirmDialog(this, "Do you want to Update the Quantity of Product :" + proName, "Message",
                                    JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

                            if (option == JOptionPane.YES_OPTION) {

                                if (found.getExp().compareTo(exp) == 0
                                        && found.getMfd().compareTo(mfd) == 0
                                        && found.getBuyingPrice() == Double.parseDouble(buying_price)
                                        && found.getSellingPrice() == Double.parseDouble(selling_price)) {

                                    found.setQty(found.getQty() + Double.parseDouble(qty));
                                    loadGRNItem();
                                } else {
                                    JOptionPane.showMessageDialog(this, "GRN Items already exist with different dates and prices", "Warning", JOptionPane.ERROR_MESSAGE);
                                }

                            }

//            JOptionPane.showMessageDialog(this, "Please Select OR Add a Product to update Stock", "Warning", JOptionPane.WARNING_MESSAGE);
                        }

                        jTabbedPane1.setSelectedIndex(3);

                    } catch (Exception e) {
                        logger.log(java.util.logging.Level.WARNING, "error in inserting data to GRN Table", e);
                    }

                }

            }
        }
    }//GEN-LAST:event_halfRoundedButton10ActionPerformed

    private void halfRoundedButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_halfRoundedButton11ActionPerformed
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_halfRoundedButton11ActionPerformed

    private void halfRoundedButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_halfRoundedButton6ActionPerformed
        try {

            String supplierName = jLabel29.getText();
            String supplierMobile = jLabel31.getText();
            String pid = jLabel41.getText();
            String qty = jFormattedTextField1.getText();
            String buying_price = jFormattedTextField2.getText();
            String selling_price = jFormattedTextField3.getText();
//        int sid = Integer.parseInt();
//        String stockId = jFormattedTextField5.getText();
            String stockid = jFormattedTextField5.getText();
            Date mfd = jDateChooser1.getDate();
            Date exp = jDateChooser2.getDate();

//            String pid = jLabel41.getText();
            String GRNNumber = jLabel17.getText();
//            String supplierMobile = jLabel31.getText();
            String empEmail = jLabel25.getText();
            String dateTime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            String payment = jFormattedTextField4.getText();
            String comName = jLabel37.getText();

            if (supplierName.equals("...")) {
                JOptionPane.showMessageDialog(this, "Please Select a Supplier First", "Warning", JOptionPane.ERROR_MESSAGE);
            } else if (supplierMobile.equals("...")) {
                JOptionPane.showMessageDialog(this, "Please Select a Supplier First", "Warning", JOptionPane.ERROR_MESSAGE);
            } else if (pid.equals("...")) {
                JOptionPane.showMessageDialog(this, "Please Select a Product", "Warning", JOptionPane.ERROR_MESSAGE);
            } else if (stockid.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter Stock Id", "Warning", JOptionPane.ERROR_MESSAGE);
            } else if (buying_price.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter Buying Price", "Warning", JOptionPane.ERROR_MESSAGE);
            } else if (selling_price.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter Selling Price", "Warning", JOptionPane.ERROR_MESSAGE);
            } else if (qty.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter Quantity", "Warning", JOptionPane.ERROR_MESSAGE);
            } else if (mfd == null) {
                JOptionPane.showMessageDialog(this, "Please Enter Manufacture Date", "Warning", JOptionPane.ERROR_MESSAGE);
            } else if (exp == null) {
                JOptionPane.showMessageDialog(this, "Please Enter Expiry Date", "Warning", JOptionPane.ERROR_MESSAGE);
            } else if (payment.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter Payment Amount", "Warning", JOptionPane.ERROR_MESSAGE);
            } else if (!payment.matches("-?\\d*\\.?\\d+")) {
                JOptionPane.showMessageDialog(this, "Invalid Payment", "Warning", JOptionPane.ERROR_MESSAGE);
            } else {

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                for (GRNItem grnItem : GRNItemMap.values()) {

                    String newStockId = grnItem.getStockid();
                    String newProductId = grnItem.getProductId();
                    double newSellingPrice = grnItem.getSellingPrice();

                    ResultSet existingStockRs = MySQL.executeSearch("SELECT * FROM `stock` WHERE `id` = '" + newStockId + "'");

                    ResultSet resultSet = MySQL.executeSearch("SELECT * FROM `stock` WHERE `products_id`='" + grnItem.getProductId() + "'"
                            + " AND `price`='" + grnItem.getSellingPrice() + "' "
                            + " AND `mfd`='" + sdf.format(grnItem.getMfd()) + "' "
                            + " AND `exp`='" + sdf.format(grnItem.getExp()) + "'");

                    String sid = "";
                    String proid = "";
                    String price = "";

                    if (existingStockRs.next()) {

                        String existingProductId = existingStockRs.getString("products_id");
                        double existingSellingPrice = existingStockRs.getDouble("price");

                        if (!existingProductId.equals(newProductId) || existingSellingPrice != newSellingPrice) {

                            JOptionPane.showMessageDialog(this, "Product already exist with different values", "Warning", JOptionPane.ERROR_MESSAGE);
                            reloadGRN();

                        } else {

                            MySQL.executeIUD("INSERT INTO `grn` VALUES ('" + GRNNumber + "','" + supplierMobile + "','" + dateTime + "','" + empEmail + "','" + payment + "','" + comName + "')");

                            if (resultSet.next()) {
                                //existing Stock

                                sid = resultSet.getString("id");
                                proid = resultSet.getString("products_id");
                                price = resultSet.getString("price");

//                        if (sid.equals(grnItem.getStockid()) && !proid.equals(grnItem.getProductId()) || !price.equals(grnItem.getSellingPrice())) {
//                            JOptionPane.showMessageDialog(this, "Product already exist", "Warning", JOptionPane.ERROR_MESSAGE);
//                        } else {
                                String currentqty = resultSet.getString("quantity");
                                String updatedQty = String.valueOf(Double.parseDouble(currentqty) + grnItem.getQty());

                                //                    JOptionPane.showMessageDialog(this, "GRN can be updated", "Warning", JOptionPane.ERROR_MESSAGE);
                                MySQL.executeIUD("UPDATE `stock` SET `quantity`='" + updatedQty + "' WHERE `id`='" + resultSet.getString("id") + "'");
//                        }

                            }

                        }

                    } else {

                        MySQL.executeIUD("INSERT INTO `grn` VALUES ('" + GRNNumber + "','" + supplierMobile + "','" + dateTime + "','" + empEmail + "','" + payment + "','" + comName + "')");

                        //new Stock
                        MySQL.executeIUD("INSERT INTO `stock` (`id`,`products_id`,`quantity`,`price`,`mfd`,`exp`) VALUES ('" + grnItem.getStockid() + "','" + grnItem.getProductId() + "','" + grnItem.getQty() + "','" + grnItem.getSellingPrice() + "','" + sdf.format(grnItem.getMfd()) + "','" + sdf.format(grnItem.getExp()) + "')");

                        ResultSet resultSet2 = MySQL.executeSearch("SELECT * FROM `stock` WHERE `products_id`='" + grnItem.getProductId() + "'"
                                + " AND `price`='" + grnItem.getSellingPrice() + "' AND"
                                + " `mfd`='" + sdf.format(grnItem.getMfd()) + "' AND"
                                + " `exp`='" + sdf.format(grnItem.getExp()) + "'");

                        if (resultSet2.next()) {
                            sid = resultSet2.getString("id");
                        }

                        MySQL.executeIUD("INSERT INTO `grn_item`(`stock_id`,`qty`,`price`,`grn_id`) "
                                + "VALUES('" + sid + "','" + grnItem.getQty() + "','" + grnItem.getBuyingPrice() + "','" + GRNNumber + "')");

                    }

                }

                String path = "src\\reports\\cherry_cone_grn.jasper";

                HashMap<String, Object> params = new HashMap<>();
                params.put("Parameter1", jLabel25.getText());
                params.put("Parameter2", jLabel33.getText());
                params.put("Parameter3", jLabel29.getText());
                params.put("Parameter4", jLabel37.getText());
                params.put("Parameter5", jLabel25.getText());
                params.put("Parameter6", jLabel23.getText());
                params.put("Parameter7", jLabel54.getText());
                params.put("Parameter8", jFormattedTextField4.getText());
                params.put("Parameter9", jLabel56.getText());

                JRTableModelDataSource dataSource1 = new JRTableModelDataSource(jTable1.getModel());

                JasperPrint jasperprint = JasperFillManager.fillReport(path, params, dataSource1);

                JasperViewer.viewReport(jasperprint, false);

//                this.dispose();
                reloadGRN();

            }

        } catch (Exception e) {
            logger.log(java.util.logging.Level.WARNING, "error in inserting GRN data into Database", e);
        }
    }//GEN-LAST:event_halfRoundedButton6ActionPerformed

    private void halfRoundedButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_halfRoundedButton7ActionPerformed
//        this.dispose();
    }//GEN-LAST:event_halfRoundedButton7ActionPerformed

    private void halfRoundedButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_halfRoundedButton9ActionPerformed
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_halfRoundedButton9ActionPerformed

    private void halfRoundedButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_halfRoundedButton16ActionPerformed
        resetGrn();
    }//GEN-LAST:event_halfRoundedButton16ActionPerformed

    private void jFormattedTextField4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextField4KeyReleased
        String total = jLabel54.getText();
        String payment = jFormattedTextField4.getText();

        if (payment.isEmpty()) {
            payment = "0";
        } else if (!payment.matches("^(0|[1-9]\\d*)?(\\.\\d+)?(?<=\\d)$")) {

            jLabel56.setText("INVALID");
            jLabel56.setForeground(Color.RED);
        } else {

            double balance = Double.parseDouble(payment) - Double.parseDouble(total);
            jLabel56.setText(String.valueOf(balance));
            jLabel56.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_jFormattedTextField4KeyReleased

    private void halfRoundedButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_halfRoundedButton15ActionPerformed
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_halfRoundedButton15ActionPerformed

    private void halfRoundedButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_halfRoundedButton17ActionPerformed

        int row = jTable1.getSelectedRow();

        try {

            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Please Select a Row", "Warning", JOptionPane.ERROR_MESSAGE);
            } else {
                String pid = String.valueOf(jTable1.getValueAt(row, 0));
                String sid = String.valueOf(jTable1.getValueAt(row, 1));
                String name = String.valueOf(jTable1.getValueAt(row, 2));
                String qty = String.valueOf(jTable1.getValueAt(row, 3));
                String buyingPrice = String.valueOf(jTable1.getValueAt(row, 4));
                String sellingPrice = String.valueOf(jTable1.getValueAt(row, 5));
//                Date mfd = (Date) jTable1.getValueAt(row, 6);
//                Date exp = (Date) jTable1.getValueAt(row, 7);
//                String total = String.valueOf(jTable1.getValueAt(row, 8));

//                double quantity = Double.parseDouble(qty);
//
//                GRNItem grnItem = new GRNItem();
//                grnItem.setProductId(pid);
//                grnItem.setStockid(sid);
//                grnItem.setProductName(name);
//                grnItem.setQty(quantity);
//                grnItem.setBuyingPrice(Double.parseDouble(buyingPrice));
//                grnItem.setSellingPrice(Double.parseDouble(sellingPrice));
////                grnItem.setMfd(mfd);
////                grnItem.setExp(exp);
                if (GRNItemMap.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "There is no products in the list", "Warning", JOptionPane.ERROR_MESSAGE);
                } else if (GRNItemMap.containsKey(pid)) {

                    int option = JOptionPane.showConfirmDialog(this, "Do you want to Delete this Product :" + name, "Message",
                            JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

                    if (option == JOptionPane.YES_OPTION) {

                        GRNItemMap.remove(pid);

                    }
                    loadGRNItem();
                }

            }

        } catch (Exception e) {
            logger.log(java.util.logging.Level.WARNING, "error in removinf GRN Item from the table", e);
        }


    }//GEN-LAST:event_halfRoundedButton17ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.HalfRoundedButton halfRoundedButton10;
    private gui.HalfRoundedButton halfRoundedButton11;
    private gui.HalfRoundedButton halfRoundedButton12;
    private gui.HalfRoundedButton halfRoundedButton13;
    private gui.HalfRoundedButton halfRoundedButton14;
    private gui.HalfRoundedButton halfRoundedButton15;
    private gui.HalfRoundedButton halfRoundedButton16;
    private gui.HalfRoundedButton halfRoundedButton17;
    private gui.HalfRoundedButton halfRoundedButton5;
    private gui.HalfRoundedButton halfRoundedButton6;
    private gui.HalfRoundedButton halfRoundedButton7;
    private gui.HalfRoundedButton halfRoundedButton8;
    private gui.HalfRoundedButton halfRoundedButton9;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JFormattedTextField jFormattedTextField3;
    private javax.swing.JFormattedTextField jFormattedTextField4;
    private javax.swing.JFormattedTextField jFormattedTextField5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private gui.RoundPanel roundPanel1;
    private gui.RoundPanel roundPanel2;
    private gui.RoundPanel roundPanel3;
    private gui.RoundPanel roundPanel4;
    private gui.RoundPanel roundPanel5;
    private gui.RoundPanel roundPanel6;
    // End of variables declaration//GEN-END:variables

    private void resetGrn() {
        jLabel41.setText("...");
        jLabel46.setText("...");
        jFormattedTextField1.setText("");
        jFormattedTextField2.setText("");
        jFormattedTextField3.setText("");
        jFormattedTextField5.setText("");
        jDateChooser1.setDate(null);
        jDateChooser2.setDate(null);
        halfRoundedButton13.grabFocus();
    }

    private void reloadGRN() {

        generateGRNId();
        jTabbedPane1.setSelectedIndex(0);
        //Clear Supplier Information
        jLabel29.setText("...");
        jLabel31.setText("....");
        jLabel33.setText("....");
        jLabel37.setText("....");
        jLabel39.setText(".....");

        //Clear GRN Input
        resetGrn();

        //Clear the GRN Table
        GRNItemMap.clear();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        jFormattedTextField4.setText("");
    }

}
