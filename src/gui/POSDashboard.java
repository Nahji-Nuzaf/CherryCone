package gui;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import static gui.SignInDep.logger;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import model.InvoiceItem;
import model.MySQL;

public class POSDashboard extends javax.swing.JFrame {

    HashMap<String, InvoiceItem> invoiceItemMap = new HashMap<>();

//    roundedTextfields3
    public JLabel proName() {
        return roundedLabel1;
    }

    public JTextField stockId() {
        return roundedTextfields2;
    }

    public JTextField sellPrice() {
        return roundedFormattedTextField1;
    }

    public JLabel stockQty() {
        return jLabel36;
    }

    public JLabel mfd() {
        return jLabel34;
    }

    public JLabel exp() {
        return jLabel35;
    }

    public JLabel getCusName() {
        return jLabel5;
    }

    public JTextField getCusMobile() {
        return roundedTextfields5;
    }

    public JLabel getRefundAmt() {
        return jLabel12;
    }

    private POSDashboard pos;

    public void openPOSDash() {
        this.pos = pos;
        jLabel12.setVisible(true);
        jLabel13.setVisible(true);
    }

    public POSDashboard() {
        initComponents();
        FullScreenFrame();
        init();
        generateInvoiceId();
        theader();
        time();
        date();

        jLabel12.setVisible(false);
        jLabel13.setVisible(false);

    }

    private void refreshMainFrame() {
        generateInvoiceId();
    }

    private void generateInvoiceId() {
        long id = System.currentTimeMillis();
        jLabel4.setText(String.valueOf(id));
    }

    public void FullScreenFrame() {
        setTitle("CherryCone POS System");
        setExtendedState(JFrame.MAXIMIZED_BOTH);  // Maximizes the window to full screen
    }

    private void init() {
        roundedTextfields1.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Search Product Name");
    }

    public void date() {

        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMMM dd, yyyy");

        String dd = sdf.format(dt);
        date.setText(dd);

    }

    public void time() {

        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Date tm = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");

                String tim = sdf.format(tm);
                tim = tim.toUpperCase();
                time.setText(tim);
            }
        }).start();
    }

    private void theader() {
        JTableHeader thead = jTable1.getTableHeader();
        thead.setForeground((new Color(255, 255, 255)));
        thead.setBackground(new Color(0, 0, 0));
        thead.setFont(new Font("Poppins", Font.BOLD, 12));
        TableColumn coll = jTable1.getColumnModel().getColumn(0);

        coll.setPreferredWidth(100);
    }

    private void loadInvoiceItem() {

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        double total = 0;

        for (InvoiceItem invoiceItem : invoiceItemMap.values()) {

            Vector<String> vector = new Vector<>();
            vector.add(invoiceItem.getStockId());
            vector.add(invoiceItem.getProName());
            vector.add(String.valueOf(invoiceItem.getSellingPrice()));
            vector.add(String.valueOf(invoiceItem.getQty()));
            vector.add(invoiceItem.getMfd());
            vector.add(invoiceItem.getExp());

//            JOptionPane.showMessageDialog(this,invoiceItem.getQty() , "Warning", JOptionPane.WARNING_MESSAGE);
            double itemTotal = Double.parseDouble(invoiceItem.getQty()) * Double.parseDouble(invoiceItem.getSellingPrice());
            total += itemTotal;

            vector.add(String.valueOf(itemTotal));

            model.addRow(vector);
        }

        jLabel38.setText(String.valueOf(total));
//        jLabel20.setText("( " + String.valueOf(total) + " )");
//        calculate();
    }

    private void loadCustomer(String mobile) {
        try {

            ResultSet rs = MySQL.executeSearch("SELECT * FROM `customer` WHERE `mobile` = '" + mobile + "' ");

            if (rs.next()) {
                jLabel5.setText(rs.getString("first_name"));
            } else {
                jLabel5.setText("Add Customer");
            }

        } catch (Exception e) {
            logger.log(java.util.logging.Level.WARNING, "error in loading loadCustomer", e);
        }
    }

    private void invoiceItems() {

//        String stockId = roundedTextfields2.getText();
//        String proName = roundedLabel1.getText();
//        String qty = roundedTextfields4.getText();
//        String mfd = jLabel34.getText();
//        String exp = jLabel35.getText();
//        String sellingPrice = roundedTextfields3.getText();
//        String totalqty = jLabel36.getText();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new gui.RoundPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        roundPanel2 = new gui.RoundPanel();
        jLabel11 = new javax.swing.JLabel();
        roundedLabel1 = new javax.swing.JLabel();
        roundedTextfields1 = new gui.RoundedTextfields();
        roundPanel3 = new gui.RoundPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        roundedTextfields2 = new gui.RoundedTextfields();
        jLabel31 = new javax.swing.JLabel();
        roundedTextfields4 = new gui.RoundedTextfields();
        jLabel36 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        roundedButton1 = new gui.RoundedButton();
        roundedButton2 = new gui.RoundedButton();
        jLabel10 = new javax.swing.JLabel();
        roundedFormattedTextField1 = new components.RoundedFormattedTextField();
        roundPanel4 = new gui.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        roundPanel5 = new gui.RoundPanel();
        date = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        roundPanel6 = new gui.RoundPanel();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        roundedTextfields5 = new gui.RoundedTextfields();
        jButton15 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        roundPanel7 = new gui.RoundPanel();
        jButton13 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        roundPanel1.setBackground(new java.awt.Color(255, 240, 245));

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("Employee Email :");

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel2.setText("nahji@gmail.com");

        jLabel3.setFont(new java.awt.Font("Poppins", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Invoice No :");

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel4.setText("Invoice Number Here");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-settings-30.png"))); // NOI18N
        jLabel9.setToolTipText("Settings");
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/history.png"))); // NOI18N
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/help.png"))); // NOI18N
        jLabel7.setToolTipText("Call Admin");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancel.png"))); // NOI18N
        jLabel6.setToolTipText("Close");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Poppins", 1, 15)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setText("Refund Amt :");

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(83, 83, 83)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(9, 9, 9)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        roundPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        jLabel11.setText("Product Name");

        roundedLabel1.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        roundedLabel1.setForeground(new java.awt.Color(0, 0, 255));
        roundedLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        roundedLabel1.setText("Product Name Here");
        roundedLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        roundedTextfields1.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        roundedTextfields1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                roundedTextfields1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                roundedTextfields1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(roundedLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(roundedTextfields1, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roundedLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roundedTextfields1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        roundPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel29.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel29.setText("Stock Id");

        jLabel30.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel30.setText("Selling Price");
        jLabel30.setToolTipText("");

        roundedTextfields2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        roundedTextfields2.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        roundedTextfields2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roundedTextfields2ActionPerformed(evt);
            }
        });
        roundedTextfields2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                roundedTextfields2KeyReleased(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel31.setText("Quantity");
        jLabel31.setToolTipText("");

        roundedTextfields4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        roundedTextfields4.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        roundedTextfields4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roundedTextfields4ActionPerformed(evt);
            }
        });
        roundedTextfields4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                roundedTextfields4KeyPressed(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("0");
        jLabel36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel36.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel32.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel32.setText("MFD");

        jLabel33.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel33.setText("EXP");

        jLabel34.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N

        jLabel35.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N

        roundedButton1.setBackground(new java.awt.Color(255, 51, 51));
        roundedButton1.setText("Reset");
        roundedButton1.setFont(new java.awt.Font("Yu Gothic UI", 1, 16)); // NOI18N
        roundedButton1.setOpaque(true);
        roundedButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roundedButton1ActionPerformed(evt);
            }
        });

        roundedButton2.setBackground(new java.awt.Color(255, 153, 255));
        roundedButton2.setText("Add to Invoice");
        roundedButton2.setFont(new java.awt.Font("Yu Gothic UI", 1, 16)); // NOI18N
        roundedButton2.setOpaque(true);
        roundedButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roundedButton2ActionPerformed(evt);
            }
        });

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancel.png"))); // NOI18N
        jLabel10.setToolTipText("Remove Product");
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        roundedFormattedTextField1.setEditable(false);
        roundedFormattedTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        roundedFormattedTextField1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        roundedFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("0.00"))));

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roundedTextfields2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(roundedFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(roundedTextfields4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(155, 155, 155))
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(roundedButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(roundedButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))))
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel3Layout.createSequentialGroup()
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(roundedTextfields2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(roundedTextfields4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(roundedFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(roundPanel3Layout.createSequentialGroup()
                                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 3, Short.MAX_VALUE)))
                        .addGap(17, 17, 17))
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(roundedButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(roundedButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );

        roundPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stock Id", "Product Name", "Price", "Qty", "MFD", "EXP", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(30);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout roundPanel4Layout = new javax.swing.GroupLayout(roundPanel4);
        roundPanel4.setLayout(roundPanel4Layout);
        roundPanel4Layout.setHorizontalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1028, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel4Layout.setVerticalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel4Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        roundPanel5.setBackground(new java.awt.Color(255, 248, 220));

        date.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        date.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        date.setText("Date");

        time.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        time.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        time.setText("Time");

        javax.swing.GroupLayout roundPanel5Layout = new javax.swing.GroupLayout(roundPanel5);
        roundPanel5.setLayout(roundPanel5Layout);
        roundPanel5Layout.setHorizontalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );
        roundPanel5Layout.setVerticalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        roundPanel6.setBackground(new java.awt.Color(255, 248, 220));

        jButton2.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-plus-20.png"))); // NOI18N
        jButton2.setText("Add Product");
        jButton2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-yoga-mat-35.png"))); // NOI18N
        jButton5.setText("Ice Rolls");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setPreferredSize(new java.awt.Dimension(114, 51));
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-ice-cream-scoop-35.png"))); // NOI18N
        jButton6.setText("Scoops");
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-milkshake-35.png"))); // NOI18N
        jButton7.setText("Milkshake");
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-ice-cream-sundae-35.png"))); // NOI18N
        jButton8.setText("Sundae");
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-whipped-cream-35.png"))); // NOI18N
        jButton10.setText("Float");
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton10.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-cup-with-straw-35.png"))); // NOI18N
        jButton11.setText("Beverages");
        jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton11.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-fruit-ice-cream-cone-35.png"))); // NOI18N
        jButton12.setText("Ice Cones");
        jButton12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton12.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-toppings-35.png"))); // NOI18N
        jButton9.setText("Toppings");
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton16.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-lock-20.png"))); // NOI18N
        jButton16.setText("Lock Screen");
        jButton16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Add Customer");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        roundedTextfields5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        roundedTextfields5.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        roundedTextfields5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                roundedTextfields5KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                roundedTextfields5KeyReleased(evt);
            }
        });

        jButton15.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jButton15.setText("Re-Print Receipt");
        jButton15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton17.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-sales-20.png"))); // NOI18N
        jButton17.setText("Sales");
        jButton17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton14.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        jButton14.setText("Close Day");
        jButton14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton21.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        jButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/drawer.png"))); // NOI18N
        jButton21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel6Layout = new javax.swing.GroupLayout(roundPanel6);
        roundPanel6.setLayout(roundPanel6Layout);
        roundPanel6Layout.setHorizontalGroup(
            roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel6Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(roundPanel6Layout.createSequentialGroup()
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(roundPanel6Layout.createSequentialGroup()
                            .addGroup(roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(roundPanel6Layout.createSequentialGroup()
                                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(roundPanel6Layout.createSequentialGroup()
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel6Layout.createSequentialGroup()
                            .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(roundPanel6Layout.createSequentialGroup()
                        .addGroup(roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                            .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addGroup(roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(roundedTextfields5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton17, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))))
                .addGap(30, 30, 30))
        );
        roundPanel6Layout.setVerticalGroup(
            roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel6Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton17, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                    .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundedTextfields5, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        roundPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jButton13.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        jButton13.setText("New Sale");
        jButton13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(102, 255, 0));
        jButton1.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-pay-20.png"))); // NOI18N
        jButton1.setText("Pay");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Poppins", 0, 30)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(51, 51, 255));
        jLabel37.setText("LKR");

        jLabel38.setFont(new java.awt.Font("Poppins", 0, 36)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(51, 51, 255));
        jLabel38.setText("SubTotal");

        jButton18.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        jButton18.setText("Credit");
        jButton18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton19.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        jButton19.setText("Return");
        jButton19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton20.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        jButton20.setText("Cash In/Out");
        jButton20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel7Layout = new javax.swing.GroupLayout(roundPanel7);
        roundPanel7.setLayout(roundPanel7Layout);
        roundPanel7Layout.setHorizontalGroup(
            roundPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel7Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel38)
                .addGap(55, 55, 55)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        roundPanel7Layout.setVerticalGroup(
            roundPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel7Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(roundPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37)
                    .addComponent(jLabel38)
                    .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(roundPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(roundPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(roundPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(roundPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(roundPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(roundPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(roundPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(roundPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(roundPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void roundedTextfields4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roundedTextfields4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roundedTextfields4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        Stock stock = new Stock();
        stock.setVisible(true);
        stock.disableButtons();
        stock.setPOSDash(this);
//       roundedTextfields4.grabFocus();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Stock stock = new Stock();
        stock.setVisible(true);
        stock.loadIceRolls(2);
        stock.disableButtons();
        stock.setPOSDash(this);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        Stock stock = new Stock();
        stock.setVisible(true);
        stock.loadScoops(3);
        stock.disableButtons();
        stock.setPOSDash(this);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        Stock stock = new Stock();
        stock.setVisible(true);
        stock.loadMilkShake(4);
        stock.disableButtons();
        stock.setPOSDash(this);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

        Stock stock = new Stock();
        stock.setVisible(true);
        stock.loadSundea(5);
        stock.disableButtons();
        stock.setPOSDash(this);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        Stock stock = new Stock();
        stock.setVisible(true);
        stock.loadToppings(6);
        stock.disableButtons();
        stock.setPOSDash(this);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        Stock stock = new Stock();
        stock.setVisible(true);
        stock.loadFloat(7);
        stock.disableButtons();
        stock.setPOSDash(this);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        Stock stock = new Stock();
        stock.setVisible(true);
        stock.loadBeverages(8);
        stock.disableButtons();
        stock.setPOSDash(this);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        Stock stock = new Stock();
        stock.setVisible(true);
        stock.loadIceCones(1);
        stock.disableButtons();
        stock.setPOSDash(this);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed

        SignInCashier cashierlogin = new SignInCashier();
        cashierlogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {

            String invoiceId = jLabel4.getText();
            String cusMobile = roundedTextfields5.getText();
            int totalProducts = jTable1.getRowCount();
            String totalAmount = jLabel38.getText();
            String empmail = jLabel2.getText();

            String refundAmt = jLabel12.getText();

            String setRefundAmt;

            if (refundAmt.isEmpty()) {
                setRefundAmt = String.valueOf("0");
            } else {
                setRefundAmt = refundAmt;
            }

            ResultSet rs = MySQL.executeSearch("SELECT * FROM `customer` WHERE `mobile` = '" + cusMobile + "' ");
            String mobiledb = null;
            String points = null;
            while (rs.next()) {
                mobiledb = String.valueOf(rs.getString("mobile"));
                points = String.valueOf(rs.getString("points"));
            }

            if (cusMobile.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Select a Customer", "Warning", JOptionPane.WARNING_MESSAGE);
                roundedTextfields5.grabFocus();
            } else if (!cusMobile.equals(mobiledb)) {
                JOptionPane.showMessageDialog(this, "Not a Resgistered Customer", "Warning", JOptionPane.WARNING_MESSAGE);
                roundedTextfields1.grabFocus();
            } else if (totalProducts == 0) {
                JOptionPane.showMessageDialog(this, "No Products Has been Added", "Warning", JOptionPane.WARNING_MESSAGE);
                roundedTextfields1.grabFocus();
            } else if (totalAmount.equals("SubTotal")) {
                JOptionPane.showMessageDialog(this, "No Products Has been Added", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {

                CheckOut checkout = new CheckOut(this, true, invoiceItemMap, invoiceId, cusMobile, totalProducts, totalAmount, empmail, points, setRefundAmt);
                checkout.setVisible(true);

//                if (!refundAmt.isEmpty()) {
//                    checkout.getRefundAmt().setText(String.valueOf(refundAmt));
//                }
//                refreshPOS();
            }

        } catch (Exception e) {
            logger.log(java.util.logging.Level.WARNING, "error in loading Customer", e);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked

        Entities ent = new Entities();
        ent.setVisible(true);
        ent.switchToCus(1);
        ent.setPOSDash(this);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed

        String email = jLabel2.getText();

        Sales sales = new Sales(email);
        sales.setVisible(true);

    }//GEN-LAST:event_jButton17ActionPerformed

    private void roundedTextfields1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_roundedTextfields1KeyPressed

        String searchBar = roundedTextfields1.getText();

        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {

            if (searchBar.isEmpty()) {

                JOptionPane.showMessageDialog(this, "Enter Product Name", "Warning", JOptionPane.WARNING_MESSAGE);

            } else {

                if (jTable1.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(this, "No Product with this name", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {
                    jTable1.grabFocus();
                    jTable1.setRowSelectionInterval(0, 0);
                }
            }
        }

        if (evt.getKeyCode() == KeyEvent.VK_SHIFT) {

            roundedTextfields2.grabFocus();
        }

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String invoiceId = jLabel4.getText();
            String cusMobile = roundedTextfields5.getText();
            int totalProducts = jTable1.getRowCount();
            String totalAmount = jLabel38.getText();
            String empmail = jLabel2.getText();

            String refundAmt = jLabel12.getText();

            String setRefundAmt;

            if (refundAmt.isEmpty()) {
                setRefundAmt = String.valueOf("0");
            } else {
                setRefundAmt = refundAmt;
            }

            try {
                ResultSet rs = MySQL.executeSearch("SELECT * FROM `customer` WHERE `mobile` = '" + cusMobile + "' ");
                String mobiledb = null;
                String points = null;
                while (rs.next()) {
                    mobiledb = String.valueOf(rs.getString("mobile"));
                    points = String.valueOf(rs.getString("points"));
                }

                if (cusMobile.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please Select a Customer", "Warning", JOptionPane.WARNING_MESSAGE);
                } else if (totalProducts == 0) {
                    JOptionPane.showMessageDialog(this, "No Products Has been Added", "Warning", JOptionPane.WARNING_MESSAGE);
                } else if (totalAmount.equals("SubTotal")) {
                    JOptionPane.showMessageDialog(this, "No Products Has been Added", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {
                    CheckOut checkout = new CheckOut(this, true, invoiceItemMap, invoiceId, cusMobile, totalProducts, totalAmount, empmail, points, setRefundAmt);
                    checkout.setVisible(true);

//                refreshPOS();
                }
            } catch (Exception e) {
                logger.log(java.util.logging.Level.WARNING, "error in loading Customer", e);
            }

        }


    }//GEN-LAST:event_roundedTextfields1KeyPressed

    private void roundedTextfields1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_roundedTextfields1KeyReleased

        String name = roundedTextfields1.getText();

        try {

            if (name != null && name.trim().isEmpty()) {

                //                JOptionPane.showMessageDialog(this, "Not Empty", "Warning", JOptionPane.WARNING_MESSAGE);
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);

                loadInvoiceItem();

            } else {

                String query = "SELECT `products`.`id`, `products`.`name`, `stock`.`id` AS stock_id, "
                        + "`stock`.`mfd`, `stock`.`exp`, `stock`.`price`, `stock`.`quantity`, "
                        + "`offer`.`offer_price` AS offer_price "
                        + "FROM `products` "
                        + "INNER JOIN `stock` ON `stock`.`products_id` = `products`.`id` "
                        + "LEFT JOIN `offer` ON `offer`.`stock_id` = `stock`.`id` ";

                if (name != null) {
                    query += " WHERE `products`.`name` LIKE '%" + name + "%'";
                }

                ResultSet resultSet = MySQL.executeSearch(query);

                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);
                //jTable1.grabFocus();
                while (resultSet.next()) {

                    Vector<String> vector = new Vector<>();
                    vector.add(resultSet.getString("stock_id"));
                    vector.add(resultSet.getString("products.name"));
                    //                vector.add(resultSet.getString("name"));
                    String offerPrice = resultSet.getString("offer_price");
                    if (offerPrice != null) {
                        vector.add(offerPrice);
                    } else {
                        vector.add(resultSet.getString("stock.price"));
                    }
                    vector.add(resultSet.getString("quantity"));
                    vector.add(resultSet.getString("mfd"));
                    vector.add(resultSet.getString("exp"));
                    if (offerPrice != null) {
                        vector.add("Offer");
                    } else {
                        vector.add("Normal");
                    }

                    model.addRow(vector);
                }
            }

        } catch (Exception e) {
            logger.log(java.util.logging.Level.WARNING, "error in loading Products", e);
        }

    }//GEN-LAST:event_roundedTextfields1KeyReleased

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            int row = jTable1.getSelectedRow();

            String stockId = String.valueOf(jTable1.getValueAt(row, 0));

            this.roundedLabel1.setText(String.valueOf(jTable1.getValueAt(row, 1)));
            this.roundedTextfields2.setText(String.valueOf(jTable1.getValueAt(row, 0)));
            this.roundedFormattedTextField1.setText(String.valueOf(jTable1.getValueAt(row, 2)));
            this.jLabel34.setText(String.valueOf(jTable1.getValueAt(row, 4)));
            this.jLabel35.setText(String.valueOf(jTable1.getValueAt(row, 5)));

            roundedTextfields1.setText("");
            roundedTextfields4.grabFocus();

            InvoiceItem found = invoiceItemMap.get(stockId);

            if (found != null) {

                try {

                    String query = "SELECT * FROM `stock` WHERE `stock`.`id`='" + stockId + "'";

                    ResultSet rs = MySQL.executeSearch(query);

                    if (rs.next()) {
                        this.jLabel36.setText(rs.getString("quantity"));
                    }

                } catch (Exception e) {
                    logger.log(java.util.logging.Level.WARNING, "error in choosing Products", e);
                }

            } else {
                this.jLabel36.setText(String.valueOf(jTable1.getValueAt(row, 3)));

            }

        }
    }//GEN-LAST:event_jTable1KeyPressed

    private void roundedTextfields4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_roundedTextfields4KeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            String stockId = roundedTextfields2.getText();
            String proName = roundedLabel1.getText();
            String qty = roundedTextfields4.getText();
            String mfd = jLabel34.getText();
            String exp = jLabel35.getText();
            String sellingPrice = roundedFormattedTextField1.getText();
            String totalqty = jLabel36.getText();

            if (stockId.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Select a Product", "Warning", JOptionPane.WARNING_MESSAGE);

            } else if (qty.isEmpty()) {

                JOptionPane.showMessageDialog(this, "Please Enter Quantity", "Warning", JOptionPane.WARNING_MESSAGE);

            } else if (!qty.matches("\\d+")) {

                JOptionPane.showMessageDialog(this, "Invalid Qty Amount", "Warning", JOptionPane.WARNING_MESSAGE);
                roundedTextfields4.setText("");
            } else if (Double.parseDouble(qty) < 0) {

                JOptionPane.showMessageDialog(this, "Quantity can't be Minus", "Warning", JOptionPane.WARNING_MESSAGE);

            } else if (qty.equals("0")) {

                JOptionPane.showMessageDialog(this, "Quantity can't be 0", "Warning", JOptionPane.WARNING_MESSAGE);

            } else if (Double.parseDouble(qty) > Double.parseDouble(totalqty)) {
                JOptionPane.showMessageDialog(this, "Quantity Exceeds the Stock Quantity", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {

                InvoiceItem invoiceItem = new InvoiceItem();
                invoiceItem.setExp(exp);
                invoiceItem.setMfd(mfd);
                invoiceItem.setProName(proName);
                invoiceItem.setQty(qty);
                invoiceItem.setSellingPrice(sellingPrice);
                invoiceItem.setStockId(stockId);

                if (invoiceItemMap.get(stockId) == null) {
                    invoiceItemMap.put(stockId, invoiceItem);
//                                loadInvoiceItem();

                } else {

                    InvoiceItem found = invoiceItemMap.get(stockId);

                    Double newqty = Double.parseDouble(found.getQty()) + Double.parseDouble(qty);

                    if (newqty > Double.parseDouble(totalqty)) {

                        JOptionPane.showMessageDialog(this, "Quantity exceeds Stock Quantity", "Warning", JOptionPane.WARNING_MESSAGE);

                    } else {
                        int option = JOptionPane.showConfirmDialog(this, "Do you want to Update the Quantity of Product :" + proName, "Message",
                                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

//                    JOptionPane.showMessageDialog(this, qty, "Warning", JOptionPane.WARNING_MESSAGE);
//
                        if (option == JOptionPane.YES_OPTION) {

//                        JOptionPane.showMessageDialog(this, found.getQty(), "Warning", JOptionPane.WARNING_MESSAGE);
                            found.setQty(String.valueOf(Double.parseDouble(found.getQty()) + Double.parseDouble(qty)));

//                        JOptionPane.showMessageDialog(this, found.setQty(qty), "Warning", JOptionPane.WARNING_MESSAGE);
                        }
                    }

                }
                loadInvoiceItem();
//                invoiceItemMap.put(stockId, invoiceItem);
                roundedTextfields1.setText("");
                reset();
                int rowcount = jTable1.getRowCount();

            }

        }

        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {

            String stockId = roundedTextfields2.getText();
            String proName = roundedLabel1.getText();
            String qty = roundedTextfields4.getText();
            String mfd = jLabel34.getText();
            String exp = jLabel35.getText();
            String sellingPrice = roundedFormattedTextField1.getText();
            String totalqty = jLabel36.getText();

            InvoiceItem invoiceItem = new InvoiceItem();
            invoiceItem.setExp(exp);
            invoiceItem.setMfd(mfd);
            invoiceItem.setProName(proName);
            invoiceItem.setQty(qty);
            invoiceItem.setSellingPrice(sellingPrice);
            invoiceItem.setStockId(stockId);

            if (invoiceItemMap == null) {

                JOptionPane.showMessageDialog(this, "There is no product in the list", "Warning", JOptionPane.WARNING_MESSAGE);

            } else if (invoiceItemMap.containsKey(stockId)) {
//                JOptionPane.showMessageDialog(this, "Can be deleted", "Warning", JOptionPane.WARNING_MESSAGE);
                if (qty.isEmpty()) {
//                    JOptionPane.showMessageDialog(this, "all the Quantity will be deleted", "Warning", JOptionPane.WARNING_MESSAGE);
                    if (invoiceItemMap.get(stockId) != null) {

                        int option = JOptionPane.showConfirmDialog(this, "Do you want to Delete this Product :" + proName, "Message",
                                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

                        if (option == JOptionPane.YES_OPTION) {

                            invoiceItemMap.remove(stockId);

                        }
                    }
                    loadInvoiceItem();
                    reset();

                } else if (qty != null) {

                    int option = JOptionPane.showConfirmDialog(this, "Do you want to Update this Product :" + proName, "Message",
                            JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

                    if (option == JOptionPane.YES_OPTION) {

                        invoiceItems();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "this product is not in the list", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }

    }//GEN-LAST:event_roundedTextfields4KeyPressed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
//        refreshPOS();

        POSDashboard pos = new POSDashboard();
        pos.setVisible(true);

//        pos.dispose();

    }//GEN-LAST:event_jButton13ActionPerformed

    private void roundedTextfields5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_roundedTextfields5KeyReleased

        loadCustomer(roundedTextfields5.getText());


    }//GEN-LAST:event_roundedTextfields5KeyReleased

    private void roundedButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roundedButton1ActionPerformed

        loadInvoiceItem();
        reset();
    }//GEN-LAST:event_roundedButton1ActionPerformed

    private void roundedButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roundedButton2ActionPerformed

        String stockId = roundedTextfields2.getText();
        String proName = roundedLabel1.getText();
        String qty = roundedTextfields4.getText();
        String mfd = jLabel34.getText();
        String exp = jLabel35.getText();
        String sellingPrice = roundedFormattedTextField1.getText();
        String totalqty = jLabel36.getText();

        if (stockId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Select a Product", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (qty.isEmpty()) {

            JOptionPane.showMessageDialog(this, "Please Enter Quantity", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (!qty.matches("\\d+")) {

            JOptionPane.showMessageDialog(this, "Invalid Qty Amount", "Warning", JOptionPane.WARNING_MESSAGE);
            roundedTextfields4.setText("");
        } else if (Double.parseDouble(qty) < 0) {

            JOptionPane.showMessageDialog(this, "Quantity can't be Minus", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (qty.equals("0")) {

            JOptionPane.showMessageDialog(this, "Quantity can't be 0", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (Double.parseDouble(qty) > Double.parseDouble(totalqty)) {
            JOptionPane.showMessageDialog(this, "Quantity Exceeds the Stock Quantity", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            try {

                InvoiceItem invoiceItem = new InvoiceItem();
                invoiceItem.setExp(exp);
                invoiceItem.setMfd(mfd);
                invoiceItem.setProName(proName);
                invoiceItem.setQty(qty);
                invoiceItem.setSellingPrice(sellingPrice);
                invoiceItem.setStockId(stockId);

                if (invoiceItemMap.get(stockId) == null) {
                    invoiceItemMap.put(stockId, invoiceItem);
//                                loadInvoiceItem();

                } else {

                    InvoiceItem found = invoiceItemMap.get(stockId);

                    Double newqty = Double.parseDouble(found.getQty()) + Double.parseDouble(qty);

                    if (newqty > Double.parseDouble(totalqty)) {

                        JOptionPane.showMessageDialog(this, "Quantity exceeds Stock Quantity", "Warning", JOptionPane.WARNING_MESSAGE);

                    } else {

                        int option = JOptionPane.showConfirmDialog(this, "Do you want to Update the Quantity of Product :" + proName, "Message",
                                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

//                    JOptionPane.showMessageDialog(this, qty, "Warning", JOptionPane.WARNING_MESSAGE);
//
                        if (option == JOptionPane.YES_OPTION) {

//                        JOptionPane.showMessageDialog(this, found.getQty(), "Warning", JOptionPane.WARNING_MESSAGE);
                            found.setQty(String.valueOf(Double.parseDouble(found.getQty()) + Double.parseDouble(qty)));

//                        JOptionPane.showMessageDialog(this, found.setQty(qty), "Warning", JOptionPane.WARNING_MESSAGE);
                        }
                    }

                }
                loadInvoiceItem();
//                invoiceItemMap.put(stockId, invoiceItem);
                roundedTextfields1.setText("");
                reset();
                int rowcount = jTable1.getRowCount();

            } catch (Exception e) {
                logger.log(java.util.logging.Level.WARNING, "error in adding product to invoice list", e);
            }

        }


    }//GEN-LAST:event_roundedButton2ActionPerformed

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked

        int row = jTable1.getSelectedRow();

        if (row == -1) {

            JOptionPane.showMessageDialog(this, "Please Select a Product to Delete", "Warning", JOptionPane.WARNING_MESSAGE);

        } else {

            String stockId = String.valueOf(jTable1.getValueAt(row, 0));
//            String brand = String.valueOf(jTable1.getValueAt(row, 1));
            String proName = String.valueOf(jTable1.getValueAt(row, 1));
            String price = String.valueOf(jTable1.getValueAt(row, 2));
            String qty = String.valueOf(jTable1.getValueAt(row, 3));
            String mfd = String.valueOf(jTable1.getValueAt(row, 4));
            String exp = String.valueOf(jTable1.getValueAt(row, 5));
//            String dis = String.valueOf(jTable1.getValueAt(row, 7));

            try {

                InvoiceItem invoiceItem = new InvoiceItem();
                invoiceItem.setExp(exp);
                invoiceItem.setMfd(mfd);
                invoiceItem.setProName(proName);
                invoiceItem.setQty(qty);
                invoiceItem.setSellingPrice(price);
                invoiceItem.setStockId(stockId);

                if (invoiceItemMap.isEmpty()) {

                    JOptionPane.showMessageDialog(this, "There is no product in the list", "Warning", JOptionPane.WARNING_MESSAGE);

                } else if (invoiceItemMap.containsKey(stockId)) {
//                JOptionPane.showMessageDialog(this, "Can be deleted", "Warning", JOptionPane.WARNING_MESSAGE);
//                if (qty.isEmpty()) {
//                    JOptionPane.showMessageDialog(this, "all the Quantity will be deleted", "Warning", JOptionPane.WARNING_MESSAGE);
                    if (invoiceItemMap.get(stockId) != null) {

                        int option = JOptionPane.showConfirmDialog(this, "Do you want to Delete this Product :" + proName, "Message",
                                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

                        if (option == JOptionPane.YES_OPTION) {

                            invoiceItemMap.remove(stockId);

                        }
                    }
                    loadInvoiceItem();
                    reset();

//                } else if (qty != null) {
//                    int option = JOptionPane.showConfirmDialog(this, "Do you want to Update this Product :" + proName, "Message",
//                            JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
//
//                    if (option == JOptionPane.YES_OPTION) {
//
//                        invoiceItems();
//                    }
//                }
                } else {
                    JOptionPane.showMessageDialog(this, "this product is not in the list", "Warning", JOptionPane.WARNING_MESSAGE);
                }

            } catch (Exception e) {
                logger.log(java.util.logging.Level.WARNING, "error in removing product from invoice list", e);
            }

        }


    }//GEN-LAST:event_jLabel10MouseClicked

    private void roundedTextfields2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roundedTextfields2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roundedTextfields2ActionPerformed

    private void roundedTextfields2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_roundedTextfields2KeyReleased

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            String barcode = roundedTextfields2.getText();
            String qty = "1";

            try {

                ResultSet rs = MySQL.executeSearch("SELECT * FROM `stock` INNER JOIN `products` ON `products`.`id`=`stock`.`products_id` WHERE `stock`.`id`='" + barcode + "'");

                if (rs.next()) {

                    String proName = rs.getString("products.name");
                    String totalqty = rs.getString("stock.quantity");
                    String mfd = rs.getString("stock.mfd");
                    String exp = rs.getString("stock.exp");
                    String sellingPrice = rs.getString("stock.price");
//                    String totalqty = rs.getString("products.name");

                    roundedLabel1.setText(proName);
                    jLabel36.setText(totalqty);
                    jLabel34.setText(mfd);
                    jLabel35.setText(exp);
                    roundedFormattedTextField1.setText(sellingPrice);

                    InvoiceItem invoiceItem = new InvoiceItem();
                    invoiceItem.setExp(exp);
                    invoiceItem.setMfd(mfd);
                    invoiceItem.setProName(proName);
                    invoiceItem.setQty(qty);
                    invoiceItem.setSellingPrice(sellingPrice);
                    invoiceItem.setStockId(barcode);

                    if (invoiceItemMap.get(barcode) == null) {
                        invoiceItemMap.put(barcode, invoiceItem);
//                                loadInvoiceItem();

                    } else {

                        InvoiceItem found = invoiceItemMap.get(barcode);

                        Double newqty = Double.parseDouble(found.getQty()) + Double.parseDouble(qty);

                        if (newqty > Double.parseDouble(totalqty)) {
                            JOptionPane.showMessageDialog(this, "Quantity exceeds Stock Quantity", "Warning", JOptionPane.WARNING_MESSAGE);
                        } else {

                            if (Double.parseDouble(found.getQty()) < Double.parseDouble(totalqty)) {

//                        JOptionPane.showMessageDialog(this, found.getQty(), "Warning", JOptionPane.WARNING_MESSAGE);
                                found.setQty(String.valueOf(Double.parseDouble(found.getQty()) + Double.parseDouble(qty)));

//                        JOptionPane.showMessageDialog(this, found.setQty(qty), "Warning", JOptionPane.WARNING_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(this, "Quantity exceeds Stock Quantity", "Warning", JOptionPane.WARNING_MESSAGE);
                            }

                        }
//                        int option = JOptionPane.showConfirmDialog(this, "Do you want to Update the Quantity of Product :" + proName, "Message",
//                                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

//                    JOptionPane.showMessageDialog(this, qty, "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                    loadInvoiceItem();
//                invoiceItemMap.put(stockId, invoiceItem);
                    roundedTextfields1.setText("");
                    reset();
                    roundedTextfields2.grabFocus();
                    int rowcount = jTable1.getRowCount();

                } else {
                    JOptionPane.showMessageDialog(this, "No Product Available", "Warning", JOptionPane.WARNING_MESSAGE);
                    roundedTextfields1.setText("");
                    reset();
                    roundedTextfields2.grabFocus();
                }

            } catch (Exception e) {
                logger.log(java.util.logging.Level.WARNING, "Something went wrong", e);
            }

        }

    }//GEN-LAST:event_roundedTextfields2KeyReleased

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked

        this.dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void roundedTextfields5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_roundedTextfields5KeyPressed

        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            loadCustomer(roundedTextfields5.getText());
        }
    }//GEN-LAST:event_roundedTextfields5KeyPressed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed

        try {

            String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

            String dayOrders;

            //load Orders and Transactions
            ResultSet rs = MySQL.executeSearch("SELECT SUM(paid_amount) AS orderTotal, COUNT(id) AS orderCount FROM `invoice` WHERE `date`='" + date + "'");
            if (rs.next()) {

                dayOrders = rs.getString("orderCount");

                if (Integer.parseInt(dayOrders) == 0) {
                    JOptionPane.showMessageDialog(this, "No Orders have been processed today", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {
                    CloseDay cd = new CloseDay(this, true);
                    cd.setVisible(true);
                }
//                jLabel4.setText(rs.getString("orderCount"));
//                jLabel5.setText(rs.getString("orderTotal"));
            }

        } catch (Exception e) {
            logger.log(java.util.logging.Level.WARNING, "Something went wrong", e);
        }


    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed

        String cashEmail = jLabel2.getText();

        CreditSales cs = new CreditSales(cashEmail);
        cs.setVisible(true);

    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed

        String cashEmail = jLabel2.getText();

        Returns returns = new Returns(cashEmail);
        returns.setVisible(true);

    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed

        String cashEmail = jLabel2.getText();

        CashInOut cashinout = new CashInOut(this, true, cashEmail);
        cashinout.setVisible(true);

    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed

        int option = JOptionPane.showConfirmDialog(this, "Opening the Drawer ?", "Message",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (option == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, "Drawer Opened", "Warning", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Drawer cannot be opened", "Warning", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed

        int option = JOptionPane.showConfirmDialog(this, "Do you want to re-print last transaction receipt ?", "Message",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (option == JOptionPane.YES_OPTION) {

        }

    }//GEN-LAST:event_jButton15ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        FlatMacLightLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new POSDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel date;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private gui.RoundPanel roundPanel1;
    private gui.RoundPanel roundPanel2;
    private gui.RoundPanel roundPanel3;
    private gui.RoundPanel roundPanel4;
    private gui.RoundPanel roundPanel5;
    private gui.RoundPanel roundPanel6;
    private gui.RoundPanel roundPanel7;
    private gui.RoundedButton roundedButton1;
    private gui.RoundedButton roundedButton2;
    private components.RoundedFormattedTextField roundedFormattedTextField1;
    private javax.swing.JLabel roundedLabel1;
    private gui.RoundedTextfields roundedTextfields1;
    private gui.RoundedTextfields roundedTextfields2;
    private gui.RoundedTextfields roundedTextfields4;
    private gui.RoundedTextfields roundedTextfields5;
    private javax.swing.JLabel time;
    // End of variables declaration//GEN-END:variables

    public void reset() {
        roundedLabel1.setText("Product Name Here");
        roundedTextfields1.setText("");
        roundedTextfields2.setText("");
        roundedTextfields4.setText("");
        jLabel36.setText("0");
        jLabel34.setText("");
        jLabel35.setText("");
        roundedFormattedTextField1.setText("");
        roundedTextfields1.grabFocus();
    }

    public void refreshPOS() {

        generateInvoiceId();
        roundedLabel1.setText("Product Name Here");
        invoiceItemMap.clear();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        jLabel38.setText("SubTotal");
        roundedTextfields5.setText("");
        jLabel5.setText("Add Customer");
        roundedTextfields1.grabFocus();

    }

}
