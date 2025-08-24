package gui;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import static gui.SignInDep.logger;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import model.MySQL;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class Stock extends javax.swing.JFrame {

//    private Invoice invoice;
//
//    public void setInvoice(Invoice invoice) {
//        this.invoice = invoice;
//    }
//    private Cashier cashier;
//    public void setCashier(Cashier cashier) {
//        this.cashier = cashier;
//    }
//    setCashier(Cashier cashier)
    private POSDashboard posdashboard;

    public void setPOSDash(POSDashboard posdashboard) {
        this.posdashboard = posdashboard;
    }

    public Stock() {
        initComponents();
//        load(jTextField1.getText());
        loadStock();
//        jPanel2.setVisible(false);
        init();
        theader();
    }

    private void init() {
        jTextField1.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Search using Product Name");
    }

    private void theader() {
        JTableHeader thead = jTable2.getTableHeader();
        thead.setForeground((new Color(255, 255, 255)));
        thead.setBackground(new Color(0, 0, 0));
        thead.setFont(new Font("Poppins", Font.BOLD, 12));
        TableColumn coll = jTable2.getColumnModel().getColumn(0);

        coll.setPreferredWidth(100);

    }

    private String buildQuery(String name, String query) {

//        if (query.contains("WHERE")) {
//            query += "AND ";
//        } else {
//            query += "WHERE ";
//        }
        try {

            if (query.contains("WHERE") && name != null) {
                query += " AND `products`.`name` LIKE '%" + name + "%'";
            } else {
                query += " WHERE `products`.`name` LIKE '%" + name + "%'";
            }

            if (jFormattedTextField1.getText().isEmpty() && jFormattedTextField2.getText().isEmpty()) {
                System.out.println("Price Empty");
                query += "";
            } else {
                System.out.println("Price NOT Empty");
                if (query.contains("WHERE")) {
                    query += " AND ";
                } else {
                    query += "WHERE ";
                }

                double min_price = 0;
                double max_price = 0;

                if (!jFormattedTextField1.getText().isEmpty()) {
                    min_price = Double.parseDouble(jFormattedTextField1.getText());
                }

                if (!jFormattedTextField2.getText().isEmpty()) {
                    max_price = Double.parseDouble(jFormattedTextField2.getText());
                }

                if (min_price > 0 && max_price == 0) {
                    query += "`stock`.`price` >= '" + min_price + "' ";
                } else if (min_price == 0 && max_price > 0) {
                    query += "`stock`.`price` <= '" + max_price + "' ";
                } else if (min_price > 0 && max_price > 0) {
                    query += "`stock`.`price` >= '" + min_price + "' AND `stock`.`price` <=  '" + max_price + "'";
                }
            }

            Date startdate = null;
            Date enddate = null;

            boolean isDateSelected = jDateChooser1.getDate() != null || jDateChooser2.getDate() != null;

            if (isDateSelected) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

//            if (query.contains("WHERE")) {
                if (jDateChooser1.getDate() != null) {
                    startdate = jDateChooser1.getDate();
                    query += " AND `stock`.`exp` >= '" + format.format(startdate) + "' ";
                }

                if (jDateChooser2.getDate() != null) {
                    if (jDateChooser1.getDate() != null) {
                        query += " AND ";
                    }
                    enddate = jDateChooser2.getDate();
                    query += "`stock`.`exp` <= '" + format.format(enddate) + "' ";
                }
//            }

            }
            String sort = String.valueOf(jComboBox1.getSelectedItem());

            query += "ORDER BY ";
            query = query.replace("WHERE ORDER BY ", "ORDER BY ");
            query = query.replace("AND ORDER BY ", "ORDER BY ");

            if (sort.equals("Stock Id ASC")) {
                query += "`stock`.`id` ASC";
            } else if (sort.equals("Stock Id DESC")) {
                query += "`stock`.`id` DESC";
            } else if (sort.equals("Oldest Product")) {
                query += "`products`.`id` ASC";
            } else if (sort.equals("Newest Product")) {
                query += "`products`.`id` DESC";
            } else if (sort.equals("Selling Price ASC")) {
                query += "`stock`.`price` ASC";
            } else if (sort.equals("Selling Price DESC")) {
                query += "`stock`.`price` DESC";
            } else if (sort.equals("Quantity ASC")) {
                query += "`stock`.`quantity` ASC";
            } else if (sort.equals("Quantity DESC")) {
                query += "`stock`.`quantity` DESC";
            }

            System.out.println(query);
            

        } catch (Exception e) {
            logger.log(java.util.logging.Level.WARNING, "error in loading query for loadStock in stock", e);
        }
        
        return query;

    }

    public void loadStock() {
        try {
            String qquery = "SELECT `products`.`id`, `products`.`name`, `stock`.`id` AS stock_id, "
                    + "`stock`.`mfd`, `stock`.`exp`, `stock`.`price`, `stock`.`quantity`, "
                    + "`offer`.`offer_price` AS offer_price "
                    + "FROM `products` "
                    + "INNER JOIN `stock` ON `stock`.`products_id` = `products`.`id` "
                    + "LEFT JOIN `offer` ON `offer`.`stock_id` = `stock`.`id` ";
            String name = jTextField1.getText();
            String query = buildQuery(name, qquery);
            ResultSet resultSet = MySQL.executeSearch(query);
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.setRowCount(0);
            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("stock_id"));
                vector.add(resultSet.getString("products.id"));
                vector.add(resultSet.getString("name"));

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
        } catch (Exception e) {
            logger.log(java.util.logging.Level.WARNING, "error in loading stock in stock", e);
        }
    }

    public void loadMilkShake(int x) {
        try {
            String qquery = "SELECT * FROM `stock` INNER JOIN `products` ON `products`.`id`=`stock`.`products_id` INNER JOIN `product_category` ON `product_category`.`id` = `products`.`product_category_id`";
            String name = jTextField1.getText();
            qquery += " WHERE `product_category_id` = '" + x + "' ";
            String query = buildQuery(name, qquery);
            ResultSet resultSet = MySQL.executeSearch(query);
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.setRowCount(0);
            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("stock.id"));
                vector.add(resultSet.getString("products.id"));
                vector.add(resultSet.getString("name"));
                vector.add(resultSet.getString("price"));
                vector.add(resultSet.getString("quantity"));
                vector.add(resultSet.getString("mfd"));
                vector.add(resultSet.getString("exp"));
                model.addRow(vector);
            }
        } catch (Exception e) {
            logger.log(java.util.logging.Level.WARNING, "error in loading loadMilkshake in stock", e);
        }
    }

    public void loadIceCones(int x) {
        try {
            String qquery = "SELECT * FROM `stock` INNER JOIN `products` ON `products`.`id`=`stock`.`products_id` INNER JOIN `product_category` ON `product_category`.`id` = `products`.`product_category_id`";
            String name = jTextField1.getText();
            qquery += " WHERE `product_category_id` = '" + x + "' ";
            String query = buildQuery(name, qquery);
            ResultSet resultSet = MySQL.executeSearch(query);
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.setRowCount(0);
            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("stock.id"));
                vector.add(resultSet.getString("products.id"));
                vector.add(resultSet.getString("name"));
                vector.add(resultSet.getString("price"));
                vector.add(resultSet.getString("quantity"));
                vector.add(resultSet.getString("mfd"));
                vector.add(resultSet.getString("exp"));
                model.addRow(vector);
            }
        } catch (Exception e) {
            logger.log(java.util.logging.Level.WARNING, "error in loading loadIcecone in stock", e);
        }
    }

    public void loadSundea(int x) {
        try {
            String qquery = "SELECT * FROM `stock` INNER JOIN `products` ON `products`.`id`=`stock`.`products_id` INNER JOIN `product_category` ON `product_category`.`id` = `products`.`product_category_id`";
            String name = jTextField1.getText();
            qquery += " WHERE `product_category_id` = '" + x + "' ";
            String query = buildQuery(name, qquery);
            ResultSet resultSet = MySQL.executeSearch(query);
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.setRowCount(0);
            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("stock.id"));
                vector.add(resultSet.getString("products.id"));
                vector.add(resultSet.getString("name"));
                vector.add(resultSet.getString("price"));
                vector.add(resultSet.getString("quantity"));
                vector.add(resultSet.getString("mfd"));
                vector.add(resultSet.getString("exp"));
                model.addRow(vector);
            }
        } catch (Exception e) {
            logger.log(java.util.logging.Level.WARNING, "error in loading loadSundae in stock", e);
        }
    }

    public void loadFloat(int x) {
        try {
            String qquery = "SELECT * FROM `stock` INNER JOIN `products` ON `products`.`id`=`stock`.`products_id` INNER JOIN `product_category` ON `product_category`.`id` = `products`.`product_category_id`";
            String name = jTextField1.getText();
            qquery += " WHERE `product_category_id` = '" + x + "' ";
            String query = buildQuery(name, qquery);
            ResultSet resultSet = MySQL.executeSearch(query);
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.setRowCount(0);
            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("stock.id"));
                vector.add(resultSet.getString("products.id"));
                vector.add(resultSet.getString("name"));
                vector.add(resultSet.getString("price"));
                vector.add(resultSet.getString("quantity"));
                vector.add(resultSet.getString("mfd"));
                vector.add(resultSet.getString("exp"));
                model.addRow(vector);
            }
        } catch (Exception e) {
            logger.log(java.util.logging.Level.WARNING, "error in loading loadFloat in stock", e);
        }
    }

    public void loadBeverages(int x) {
        try {
            String qquery = "SELECT * FROM `stock` INNER JOIN `products` ON `products`.`id`=`stock`.`products_id` INNER JOIN `product_category` ON `product_category`.`id` = `products`.`product_category_id`";
            String name = jTextField1.getText();
            qquery += " WHERE `product_category_id` = '" + x + "' ";
            String query = buildQuery(name, qquery);
            ResultSet resultSet = MySQL.executeSearch(query);
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.setRowCount(0);
            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("stock.id"));
                vector.add(resultSet.getString("products.id"));
                vector.add(resultSet.getString("name"));
                vector.add(resultSet.getString("price"));
                vector.add(resultSet.getString("quantity"));
                vector.add(resultSet.getString("mfd"));
                vector.add(resultSet.getString("exp"));
                model.addRow(vector);
            }
        } catch (Exception e) {
            logger.log(java.util.logging.Level.WARNING, "error in loading loadBeverages in stock", e);
        }
    }

    public void loadIceRolls(int x) {
        try {
            String qquery = "SELECT * FROM `stock` INNER JOIN `products` ON `products`.`id`=`stock`.`products_id` INNER JOIN `product_category` ON `product_category`.`id` = `products`.`product_category_id`";
            String name = jTextField1.getText();
            qquery += " WHERE `product_category_id` = '" + x + "' ";
            String query = buildQuery(name, qquery);
            ResultSet resultSet = MySQL.executeSearch(query);
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.setRowCount(0);
            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("stock.id"));
                vector.add(resultSet.getString("products.id"));
                vector.add(resultSet.getString("name"));
                vector.add(resultSet.getString("price"));
                vector.add(resultSet.getString("quantity"));
                vector.add(resultSet.getString("mfd"));
                vector.add(resultSet.getString("exp"));
                model.addRow(vector);
            }
        } catch (Exception e) {
            logger.log(java.util.logging.Level.WARNING, "error in loading loadIceRolls in stock", e);
        }
    }

    public void loadScoops(int x) {
        try {
            String qquery = "SELECT * FROM `stock` INNER JOIN `products` ON `products`.`id`=`stock`.`products_id` INNER JOIN `product_category` ON `product_category`.`id` = `products`.`product_category_id`";
            String name = jTextField1.getText();
            qquery += " WHERE `product_category_id` = '" + x + "' ";
            String query = buildQuery(name, qquery);
            ResultSet resultSet = MySQL.executeSearch(query);
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.setRowCount(0);
            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("stock.id"));
                vector.add(resultSet.getString("products.id"));
                vector.add(resultSet.getString("name"));
                vector.add(resultSet.getString("price"));
                vector.add(resultSet.getString("quantity"));
                vector.add(resultSet.getString("mfd"));
                vector.add(resultSet.getString("exp"));
                model.addRow(vector);
            }
        } catch (Exception e) {
            logger.log(java.util.logging.Level.WARNING, "error in loading loadScoops in stock", e);
        }
    }

    public void loadToppings(int x) {
        try {
            String qquery = "SELECT * FROM `stock` INNER JOIN `products` ON `products`.`id`=`stock`.`products_id` INNER JOIN `product_category` ON `product_category`.`id` = `products`.`product_category_id`";
            String name = jTextField1.getText();
            qquery += " WHERE `product_category_id` = '" + x + "' ";
            String query = buildQuery(name, qquery);
            ResultSet resultSet = MySQL.executeSearch(query);
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.setRowCount(0);
            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("stock.id"));
                vector.add(resultSet.getString("products.id"));
                vector.add(resultSet.getString("name"));
                vector.add(resultSet.getString("price"));
                vector.add(resultSet.getString("quantity"));
                vector.add(resultSet.getString("mfd"));
                vector.add(resultSet.getString("exp"));
                model.addRow(vector);
            }
        } catch (Exception e) {
            logger.log(java.util.logging.Level.WARNING, "error in loading loadToppings in stock", e);
        }
    }

    private void filter() {

        boolean isMilkshake = true;
        boolean isIceCone = true;
        boolean isSundae = true;
        boolean isFloat = true;
        boolean isBeverage = true;
        boolean isIceRolls = true;
        boolean isScoops = true;
        boolean isToppings = true;

        if (isMilkshake) {
            loadMilkShake(4);
        } else if (isIceCone) {
            loadIceCones(1);
        } else if (isSundae) {
            loadSundea(5);
        } else if (isFloat) {
            loadFloat(7);
        } else if (isBeverage) {
            loadBeverages(8);
        } else if (isIceRolls) {
            loadIceRolls(2);
        } else if (isScoops) {
            loadScoops(3);
        } else if (isToppings) {
            loadToppings(6);
        } else {
            loadStock();
        }

    }
    
    public void disableButtons(){
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        roundPanel1 = new gui.RoundPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Stocks");
        setAlwaysOnTop(true);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 36)); // NOI18N
        jLabel1.setText("Stocks");

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setMinimumSize(new java.awt.Dimension(50, 20));
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 20));

        jButton2.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-plus-20.png"))); // NOI18N
        jButton2.setText("Add New Offer");
        jButton2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stock Id", "Product Id", "Product Name", "Selling Price", "Stock Quantity", "MFD", "EXP", "Offer Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setRowHeight(25);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
        );

        jButton3.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jButton3.setText("Print Report");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 204));
        jLabel6.setText("Date :");

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 204));
        jLabel3.setText("Selling Price :");

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 204));
        jLabel2.setText("Sort By :");

        jComboBox1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Stock Id ASC", "Stock Id DESC", "Oldest Product", "Newest Product", "Selling Price ASC", "Selling Price DESC", "Quantity ASC", "Quantity DESC" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel4.setText("From");

        jLabel5.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel5.setText("To");

        jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        jFormattedTextField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jFormattedTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField2ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel7.setText("From");

        jLabel8.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel8.setText("To");

        jDateChooser1.setDateFormatString("yyyy-MM-dd");

        jDateChooser2.setDateFormatString("yyyy-MM-dd");

        jButton5.setBackground(new java.awt.Color(0, 204, 255));
        jButton5.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        jButton5.setText("Search");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reset11.png"))); // NOI18N
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(225, 225, 225)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(448, 448, 448))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(72, 72, 72)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22))))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addComponent(jLabel6))
                        .addGap(11, 11, 11)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(roundPanel1Layout.createSequentialGroup()
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(roundPanel1Layout.createSequentialGroup()
                                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel8)))))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1031, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(roundPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        Offers offers = new Offers();
        offers.setVisible(true);

        this.dispose();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jFormattedTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        reset();

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged

        loadStock();
//        loadMilkShake(3);
//        filter();

    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

//        filter();
        loadStock();


    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
//        filter();
        loadStock();

    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked

        int row = jTable2.getSelectedRow();

//        if (evt.getClickCount() == 2) {
//            if (grn !=null) {
//                grn.getjTextField1().setText(String.valueOf(jTable2.getValueAt(row, 1)));
//                grn.getjLabel41().setText(String.valueOf(jTable2.getValueAt(row, 2)));
//                this.dispose();
//            }
//        }
        if (evt.getClickCount() == 2) {

            if (posdashboard != null) {

                posdashboard.proName().setText(String.valueOf(jTable2.getValueAt(row, 2)));
                posdashboard.stockId().setText(String.valueOf(jTable2.getValueAt(row, 0)));
                posdashboard.sellPrice().setText(String.valueOf(jTable2.getValueAt(row, 3)));
                posdashboard.stockQty().setText(String.valueOf(jTable2.getValueAt(row, 4)));
                posdashboard.mfd().setText(String.valueOf(jTable2.getValueAt(row, 5)));
                posdashboard.exp().setText(String.valueOf(jTable2.getValueAt(row, 6)));
//                   cashier.jFormattedTextField9().grabFocus();
//                POSDashboard.roundedTextfields4.

                this.dispose();

            }

        }

    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        try {

            String path = "src\\reports\\cherry_cone_stock.jasper";

            HashMap<String, Object> params = new HashMap<>();
            params.put("Parameter1", jLabel1.getText());

            JRTableModelDataSource dataSource1 = new JRTableModelDataSource(jTable2.getModel());

            JasperPrint jasperprint = JasperFillManager.fillReport(path, params, dataSource1);

            JasperViewer.viewReport(jasperprint, false);

        } catch (Exception e) {
            logger.log(java.util.logging.Level.WARNING, "error in Stock report", e);
        }

    }//GEN-LAST:event_jButton3ActionPerformed

//    public static void main(String args[]) {
//        FlatMacLightLaf.setup();
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Stock().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private gui.RoundPanel roundPanel1;
    // End of variables declaration//GEN-END:variables

    private void reset() {
        jTextField1.setText("");
        jComboBox1.setSelectedIndex(0);
        jFormattedTextField1.setText("");
        jFormattedTextField2.setText("");
        jDateChooser1.setDate(null);
        jDateChooser2.setDate(null);
        loadStock();
    }
}
