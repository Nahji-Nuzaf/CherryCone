package gui;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import static gui.SignInDep.logger;
import jakarta.activation.CommandMap;
import jakarta.activation.DataHandler;
import jakarta.activation.DataSource;
import jakarta.activation.MailcapCommandMap;
import jakarta.activation.MimeType;
import jakarta.activation.MimeTypeParseException;
import jakarta.mail.Message;
import jakarta.mail.Multipart;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import jakarta.mail.util.ByteArrayDataSource;
import java.awt.Desktop;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import model.InvoiceItem;
import model.MySQL;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class CheckOut extends javax.swing.JDialog {

    HashMap<String, String> paymentMethodMap = new HashMap<>();

    private String invoiceId;
    private String cusMobile;
    private int totalProducts;
    private String totalAmount;
    private String empmail;
    private String points;
    private String setRefundAmt;

    private HashMap<String, InvoiceItem> invoiceItemsMap;

    private POSDashboard posdashboard;

    private String refundDiscount;

    public JFormattedTextField getRefundAmt() {
        return jFormattedTextField1;
    }

    public CheckOut(java.awt.Frame parent, boolean modal, HashMap<String, InvoiceItem> invoiceItemsMap, String invoiceId, String cusMobile, int totalProducts, String totalAmount, String empmail, String points, String setRefundAmt) {
        super(parent, modal);
        initComponents();

        System.out.println("Initial HashMap: " + invoiceItemsMap);

        this.invoiceId = invoiceId;
        this.cusMobile = cusMobile;
        this.totalProducts = totalProducts;
        this.totalAmount = totalAmount;
        this.empmail = empmail;
        this.points = points;
        this.setRefundAmt = setRefundAmt;
        this.invoiceItemsMap = invoiceItemsMap;
        this.posdashboard = (POSDashboard) parent;

        loadData();
        loadPaymentMethod();
//        calculate();

    }

    private void loadData() {

        String dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        jLabel24.setText(invoiceId);
        jLabel25.setText(cusMobile);
        jLabel28.setText("(" + totalProducts + ")");
        jLabel31.setText(totalAmount);
        jLabel26.setText(dateTime);
        jLabel36.setText(points);
        jFormattedTextField1.setText(setRefundAmt);
    }

    private double total = 0;
    private double discount = 0;
    private double payment = 0;
    private double balance = 0;
    private String paymentMethod = "Select";
    private boolean withdrawPoints = false;
    private double pointss = 0;

    private void calculate() {

        if (jFormattedTextField1.getText().isEmpty()) {
            discount = 0;
        } else {
            discount = Double.parseDouble(jFormattedTextField1.getText());
        }
//
        if (jFormattedTextField2.getText().isEmpty()) {
            payment = 0;
        } else {
            payment = Double.parseDouble(jFormattedTextField2.getText());
        }
//
        total = Double.parseDouble(String.valueOf(jLabel31.getText()));

//        JOptionPane.showMessageDialog(this, total, "Warning", JOptionPane.WARNING_MESSAGE);
//
        if (jCheckBox1.isSelected()) {
            withdrawPoints = true;
        }

        total -= discount;
//
        paymentMethod = String.valueOf(jComboBox1.getSelectedItem());
//

        if (paymentMethod.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Select a Payment Method", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            if (withdrawPoints) {

                String point = jLabel36.getText();

                if (jLabel36.getText().equals("(.........)")) {
                    JOptionPane.showMessageDialog(this, "Customer NOT Selected", "Warning", JOptionPane.WARNING_MESSAGE);

                } else if (Double.parseDouble(point) == total) {
                    pointss = 0;
                    total = 0;
                    // no payment req

                } else if (Double.parseDouble(point) < total) {
                    pointss = 0;
                    total -= Double.parseDouble(point);
                    // no payment req

                } else {
                    pointss = Double.parseDouble(point) - total;
                    total = 0;
                }
            }

            if (paymentMethod.equals("Cash")) {
//            //cash
                jFormattedTextField2.setEditable(true);

                balance = payment - total;
                if (balance < 0) {
                    halfRoundedButton1.setEnabled(false);
//                roundedButton7.setEnabled(true);
                } else {
                    halfRoundedButton1.setEnabled(true);
//                roundedButton7.setEnabled(false);
                }
//
            } else {
//            //card
                payment = total;
                balance = 0;
                jFormattedTextField2.setText(String.valueOf(payment));
                jFormattedTextField2.setEditable(false);
                halfRoundedButton1.setEnabled(true);
            }

        }

//
        jFormattedTextField3.setText(String.valueOf(balance));
//
    }

    private void loadPaymentMethod() {

        try {

            ResultSet rs = MySQL.executeSearch("SELECT * FROM `payment_method`");

            Vector<String> vector = new Vector<>();
            vector.add("Select");

            while (rs.next()) {

                paymentMethodMap.put(rs.getString("name"), rs.getString("id"));

                vector.add(rs.getString("name"));
            }

            DefaultComboBoxModel model = new DefaultComboBoxModel(vector);
            jComboBox1.setModel(model);

        } catch (Exception e) {
            logger.log(java.util.logging.Level.WARNING, "error in loading loadPaymentMethod", e);
        }

    }

    private JasperPrint print;
    File tempFile;

    private void viewReport() {

        String invoiceId = jLabel24.getText();
        String customerMobile = jLabel25.getText();
        String employeeEmail = empmail;
        String dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String paidAmount = jFormattedTextField2.getText();
        String paymentMethodID = paymentMethodMap.get(String.valueOf(jComboBox1.getSelectedItem()));
        String discount = String.valueOf(jFormattedTextField1.getText());

        String emailToSend = "";
        String customerQuery = "SELECT * FROM `customer` WHERE `mobile` = '" + customerMobile + "' AND `ebill_id` ='" + 1 + "'";

        List<InvoiceItem> invoiceItems = new ArrayList<>(invoiceItemsMap.values());

        String path = "src\\reports\\cc_invoice.jasper";

        HashMap<String, Object> params = new HashMap<>();

        try {

            params.put("Parameter1", jLabel24.getText());   //invoice Id
            params.put("Parameter2", empmail);   //Employee Email
            params.put("Parameter3", jLabel25.getText());      //Customer or Emp Name
            params.put("Parameter4", jLabel31.getText());  //Grand Total
            params.put("Parameter5", jFormattedTextField2.getText()); //Payment
            params.put("Parameter6", jFormattedTextField1.getText());  //Discount
            params.put("Parameter7", jFormattedTextField3.getText()); //Balance
//

            try {

                ResultSet rs = MySQL.executeSearch(customerQuery);

                if (rs.next()) {
                    emailToSend = rs.getString("email");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(invoiceItems);
//
            JasperPrint jasperprint = JasperFillManager.fillReport(path, params, dataSource);
            JasperViewer.viewReport(jasperprint, false);

        } catch (Exception e) {
            logger.log(java.util.logging.Level.WARNING, "viewReport", e);
        }

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(invoiceItems);

        try {

            print = JasperFillManager.fillReport(path, params, dataSource);

            if (!emailToSend.isEmpty()) {
                sendEmailWithReport(emailToSend, print);
            } else {

                // Export to PDF as a byte array
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                JasperExportManager.exportReportToPdfStream(print, baos);

                byte[] pdfData = baos.toByteArray();

                try {
                    tempFile = File.createTempFile("Invoice_", ".pdf");
                    tempFile.deleteOnExit(); // Ensure it gets deleted on exit
                } catch (IOException ex) {
//                    Logger.getLogger(Invoice.class.getName()).log(Level.SEVERE, null, ex);
                }

                // Write the bytes to the temporary file
                try (FileOutputStream fos = new FileOutputStream(tempFile)) {
                    fos.write(pdfData);
                    fos.flush(); // Ensure all data is written
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // Open the PDF with the default PDF viewer
                if (Desktop.isDesktopSupported()) {
                    try {
                        Desktop.getDesktop().open(tempFile);
                    } catch (IOException ex) {
//                        Logger.getLogger(Invoice.class.getName()).log(Level.SEVERE, "Failed to open PDF: " + ex.getMessage(), ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Desktop is not supported. Please open the PDF manually.");
                }

            }

        } catch (Exception e) {
            logger.log(java.util.logging.Level.WARNING, "error in sending receipt emails (view Reoport)", e);
        }

    }

    static {
        MailcapCommandMap mc = (MailcapCommandMap) CommandMap.getDefaultCommandMap();
        try {
            MimeType mt = new MimeType("multipart/mixed");
            mc.addMailcap("multipart/mixed;; x-java-content-handler=com.sun.activation.registries.MimeTypeRegistry");
        } catch (MimeTypeParseException e) {
            logger.log(java.util.logging.Level.WARNING, "error in sending receipt emails (static)", e);
        }
        CommandMap.setDefaultCommandMap(mc);
    }

    private static final String FROM = "nahji1101@gmail.com";
    private static final String PASSWORD = "fkaqzgrzqalcdqgb";
    private static final Properties PROPERTIES = new Properties();

    static {
        PROPERTIES.put("mail.smtp.auth", "true");
        PROPERTIES.put("mail.smtp.starttls.enable", "true");
        PROPERTIES.put("mail.smtp.host", "smtp.gmail.com");
        PROPERTIES.put("mail.smtp.port", "587");
    }

    private static final Session SESSION = Session.getInstance(PROPERTIES, new jakarta.mail.Authenticator() {

        @Override
        protected jakarta.mail.PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(FROM, PASSWORD);
        }
    });

    private static final ExecutorService executor = Executors.newSingleThreadExecutor();

    public void sendEmailWithReport(String email, JasperPrint print) {
        executor.submit(() -> {
            try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
                JasperExportManager.exportReportToPdfStream(print, baos);
                byte[] pdfData = baos.toByteArray();

                // Create email message
                Message message = new MimeMessage(SESSION);
                message.setFrom(new InternetAddress(FROM));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
                message.setSubject("CherryCone Invoice");

                // Create the message body part
                MimeBodyPart messageBodyPart = new MimeBodyPart();
                messageBodyPart.setText("Your Invoice is attached below");

                // Create the attachment part
                MimeBodyPart attachmentPart = new MimeBodyPart();
                DataSource dataSource = new ByteArrayDataSource(pdfData, "application/pdf");
                attachmentPart.setDataHandler(new DataHandler(dataSource));
                attachmentPart.setFileName("Invoice.pdf");

                // Create a multipart message for combining body and attachment
                Multipart multipart = new MimeMultipart("mixed"); // Explicitly specify the MIME type
                multipart.addBodyPart(messageBodyPart);  // Add the text message part
                multipart.addBodyPart(attachmentPart);   // Add the attachment part

                // Set the complete message parts
                message.setContent(multipart);

                // Send the email
                Transport.send(message);
//                Notifications.getInstance().show(Notifications.Type.SUCCESS,
//                        Notifications.Location.TOP_RIGHT, 3000L, "Email Sent Successfully");

            } catch (Exception e) {
                logger.log(java.util.logging.Level.WARNING, "error in sending receipt emails (Send email with report) ", e);
            }
//            executor.shutdown();
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new gui.RoundPanel();
        jLabel21 = new javax.swing.JLabel();
        roundPanel2 = new gui.RoundPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        roundPanel3 = new gui.RoundPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        halfRoundedButton1 = new gui.HalfRoundedButton();
        halfRoundedButton2 = new gui.HalfRoundedButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jFormattedTextField3 = new javax.swing.JFormattedTextField();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Payments");

        roundPanel1.setBackground(new java.awt.Color(255, 204, 255));

        jLabel21.setFont(new java.awt.Font("Poppins", 0, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 0, 0));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Continue Transaction");

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel21)
                .addGap(15, 15, 15))
        );

        roundPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel5.setText("Invoice ID                   :");

        jLabel22.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel22.setText("Customer Mobile    :");

        jLabel23.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel23.setText("Process Date            :");

        jLabel24.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel24.setText("Order ID Here");
        jLabel24.setToolTipText("");

        jLabel25.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel25.setText("Cus... Mobile Here");

        jLabel26.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel26.setText("Cus... Mobile Here");

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        roundPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setBackground(new java.awt.Color(153, 255, 255));
        jLabel8.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Payments");
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel8.setOpaque(true);

        jLabel27.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel27.setText("Total Items");

        jLabel28.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel28.setText("(.........)");

        jLabel29.setFont(new java.awt.Font("Poppins", 0, 24)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 0, 255));
        jLabel29.setText("Total");

        jLabel30.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel30.setText("Discount");

        jLabel31.setFont(new java.awt.Font("Poppins", 0, 24)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 0, 255));
        jLabel31.setText("Total Here");

        jLabel32.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel32.setText("Payment");

        jLabel33.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 0, 0));
        jLabel33.setText("Balance");

        jLabel34.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel34.setText("Payment Method");

        halfRoundedButton1.setBackground(new java.awt.Color(102, 255, 102));
        halfRoundedButton1.setText("Pay");
        halfRoundedButton1.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        halfRoundedButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                halfRoundedButton1ActionPerformed(evt);
            }
        });

        halfRoundedButton2.setBackground(new java.awt.Color(204, 255, 255));
        halfRoundedButton2.setText("Credit");
        halfRoundedButton2.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        halfRoundedButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                halfRoundedButton2ActionPerformed(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jFormattedTextField1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jFormattedTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jFormattedTextField1KeyReleased(evt);
            }
        });

        jFormattedTextField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jFormattedTextField2.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jFormattedTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jFormattedTextField2KeyReleased(evt);
            }
        });

        jFormattedTextField3.setEditable(false);
        jFormattedTextField3.setForeground(new java.awt.Color(255, 0, 0));
        jFormattedTextField3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jFormattedTextField3.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jFormattedTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField3ActionPerformed(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel35.setText("Total Points");

        jLabel36.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 51, 51));
        jLabel36.setText("(.........)");

        jCheckBox1.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jCheckBox1.setText("Withdraw Points");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jFormattedTextField2)
                            .addComponent(jFormattedTextField3)
                            .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(81, Short.MAX_VALUE))
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(roundPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel35)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(roundPanel3Layout.createSequentialGroup()
                                .addComponent(jCheckBox1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(halfRoundedButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(halfRoundedButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(46, 46, 46))))
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(jFormattedTextField2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jFormattedTextField3))
                .addGap(40, 40, 40)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(halfRoundedButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(halfRoundedButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void halfRoundedButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_halfRoundedButton1ActionPerformed

        try {

            if (jFormattedTextField1.getText().isEmpty()) {
                jFormattedTextField1.setText("0");
            }

            String invoiceId = jLabel24.getText();
            String customerMobile = jLabel25.getText();
            String employeeEmail = empmail;
            String dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            String paidAmount = jFormattedTextField2.getText();
            String paymentMethodID = paymentMethodMap.get(String.valueOf(jComboBox1.getSelectedItem()));
            String discount = String.valueOf(jFormattedTextField1.getText());

            if (customerMobile.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Customer not Selected", "Warning", JOptionPane.WARNING_MESSAGE);

            } else if (jComboBox1.getSelectedItem() == "Select") {
                JOptionPane.showMessageDialog(this, "Select Payment Method", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (paidAmount.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Enter Paying Amount", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {

                if (customerMobile.trim().isEmpty()) {
                    //insert to invoice
//                    JOptionPane.showMessageDialog(this, "its null", "Warning", JOptionPane.WARNING_MESSAGE);

                    MySQL.executeIUD("INSERT INTO `invoice` (`id`,`discount`,`employee_email`,`date`,`paid_amount`,`payment_method_id`) VALUES('" + invoiceId + "','" + discount + "','" + employeeEmail + "',"
                            + "'" + dateTime + "','" + paidAmount + "','" + paymentMethodID + "')");

                } else {
                    //insert to invoice
//                JOptionPane.showMessageDialog(this, "its not null", "Warning", JOptionPane.WARNING_MESSAGE);
                    MySQL.executeIUD("INSERT INTO `invoice` (`id`,`customer_mobile`,`employee_email`,`date`,`paid_amount`,`payment_method_id`,`discount`) VALUES('" + invoiceId + "','" + customerMobile + "','" + employeeEmail + "',"
                            + "'" + dateTime + "','" + paidAmount + "','" + paymentMethodID + "','" + discount + "')");
                }

                for (InvoiceItem invoiceItem : invoiceItemsMap.values()) {

                    //insert to invoiceItem
                    MySQL.executeIUD("INSERT INTO `invoice_item`(`stock_id`,`qty`,`invoice_id` )"
                            + "VALUES('" + invoiceItem.getStockId() + "','" + invoiceItem.getQty() + "','" + invoiceId + "')");
                    //insert to invoiceItem

                    //stock update
                    MySQL.executeIUD("UPDATE `stock` SET `quantity`=`quantity`-'" + invoiceItem.getQty() + "' WHERE `id`='" + invoiceItem.getStockId() + "'");
                    //stock update

//                    JOptionPane.showMessageDialog(this, " success", "Warning", JOptionPane.WARNING_MESSAGE);
                }

                double updatePoints = Double.parseDouble(jFormattedTextField2.getText()) / 100;

                Math.round(updatePoints);

                //withdraw points
                if (withdrawPoints) {
                    pointss += updatePoints;
                    MySQL.executeIUD("UPDATE `customer` SET `points` = '" + updatePoints + "' WHERE `mobile` = '" + customerMobile + "'");
                } else {
                    MySQL.executeIUD("UPDATE `customer` SET `points` = `points` + '" + updatePoints + "' WHERE `mobile` = '" + customerMobile + "'");
                }

                viewReport();

                if (getRefundAmt() != null && !getRefundAmt().getText().equals("0")) {
                    System.out.println("Refund Amount: " + getRefundAmt().getText());
                    posdashboard.dispose();
                    this.dispose();
                } else {
                    System.out.println("Refund Amount is null");
                    posdashboard.refreshPOS();
                    this.dispose();
                }

//            JOptionPane.showMessageDialog(this, " items not inserted", "Warning", JOptionPane.WARNING_MESSAGE);
            }

        } catch (Exception e) {
            logger.log(java.util.logging.Level.WARNING, "error in processing full paid payments", e);
        }

    }//GEN-LAST:event_halfRoundedButton1ActionPerformed

    private void halfRoundedButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_halfRoundedButton2ActionPerformed

        try {

            if (jFormattedTextField1.getText().isEmpty()) {
                jFormattedTextField1.setText("0");
            }

            if (jFormattedTextField2.getText().isEmpty()) {
                jFormattedTextField2.setText("0");
            }

            String invoiceId = jLabel24.getText();
            String customerMobile = jLabel25.getText();
            String employeeEmail = empmail;
            String dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            String paidAmount = jFormattedTextField2.getText();
            String paymentMethodID = paymentMethodMap.get(String.valueOf(jComboBox1.getSelectedItem()));
            String discount = String.valueOf(jFormattedTextField1.getText());
            String balance = String.valueOf(jFormattedTextField3.getText());

            if (customerMobile.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Customer not Selected", "Warning", JOptionPane.WARNING_MESSAGE);

            } else if (jComboBox1.getSelectedItem() == "Select") {
                JOptionPane.showMessageDialog(this, "Select Payment Method", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (paidAmount.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Enter Paying Amount", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {

                if (customerMobile.trim().equals("0000")) {
                    //insert to invoice
                    JOptionPane.showMessageDialog(this, "Credit Payment is not Availbale for Walking Customers", "Warning", JOptionPane.WARNING_MESSAGE);

//                    MySQL.executeIUD("INSERT INTO `invoice` (`id`,`discount`,`employee_email`,`date`,`paid_amount`,`payment_method_id`) VALUES('" + invoiceId + "','" + discount + "','" + employeeEmail + "',"
//                            + "'" + dateTime + "','" + paidAmount + "','" + paymentMethodID + "')");
                } else {

                    //insert into invoice table as a due payment
                    MySQL.executeIUD("INSERT INTO `invoice` (`id`,`customer_mobile`,`employee_email`,`date`,`paid_amount`,`payment_method_id`,`discount`,`due_amount`) "
                            + "VALUES('" + invoiceId + "','" + customerMobile + "','" + employeeEmail + "','" + dateTime + "',"
                            + "'" + paidAmount + "','" + paymentMethodID + "','" + discount + "','" + balance + "')");

                    for (InvoiceItem invoiceItem : invoiceItemsMap.values()) {

                        //insert to invoiceItem
                        MySQL.executeIUD("INSERT INTO `invoice_item`(`stock_id`,`qty`,`invoice_id` )"
                                + "VALUES('" + invoiceItem.getStockId() + "','" + invoiceItem.getQty() + "','" + invoiceId + "')");
                        //insert to invoiceItem

                        //stock update
                        MySQL.executeIUD("UPDATE `stock` SET `quantity`=`quantity`-'" + invoiceItem.getQty() + "' WHERE `id`='" + invoiceItem.getStockId() + "'");
                        //stock update

//                    JOptionPane.showMessageDialog(this, " success", "Warning", JOptionPane.WARNING_MESSAGE);
                    }

                    double updatePoints = Double.parseDouble(jFormattedTextField2.getText()) / 100;

                    Math.round(updatePoints);

                    //withdraw points
                    if (withdrawPoints) {
                        pointss += updatePoints;
                        MySQL.executeIUD("UPDATE `customer` SET `points` = '" + updatePoints + "' WHERE `mobile` = '" + customerMobile + "'");
                    } else {
                        MySQL.executeIUD("UPDATE `customer` SET `points` = `points` + '" + updatePoints + "' WHERE `mobile` = '" + customerMobile + "'");
                    }

                    viewReport();

                    if (!getRefundAmt().equals("0") && !getRefundAmt().getText().equals("0")) {
                        System.out.println("Refund Amount: " + getRefundAmt().getText());
                        posdashboard.dispose();
                        this.dispose();
                    } else {
                        System.out.println("Refund Amount is null");
                        posdashboard.refreshPOS();
                        this.dispose();
                    }

                }

            }

        } catch (Exception e) {
            logger.log(java.util.logging.Level.WARNING, "error in processing credit payments", e);
        }


    }//GEN-LAST:event_halfRoundedButton2ActionPerformed

    private void jFormattedTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField3ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged

        String total = jLabel31.getText();

        if (total.equals("Total Here")) {

        } else {
            calculate();
        }

    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jFormattedTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextField2KeyReleased
        
        String total = jLabel31.getText();
        String payment = jFormattedTextField2.getText();

        if (total.equals("Total Here")) {
            JOptionPane.showMessageDialog(this, "Select a Product", "Warning", JOptionPane.WARNING_MESSAGE);
            jFormattedTextField2.setText("");
        } else if (payment.isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Payment Cannot be Empty", "Warning", JOptionPane.WARNING_MESSAGE);
            jFormattedTextField2.setText("");
        } else if (!payment.matches("-?\\d*\\.?\\d+")) {
            JOptionPane.showMessageDialog(this, "Cannot use letter or symbols", "Warning", JOptionPane.WARNING_MESSAGE);
            jFormattedTextField2.setText("");
        } else if (payment.equals("-")) {
            JOptionPane.showMessageDialog(this, "Payment Cannot be in Minus", "Warning", JOptionPane.WARNING_MESSAGE);
            jFormattedTextField2.setText("");
        } else if (Double.parseDouble(payment) < 0) {
            JOptionPane.showMessageDialog(this, "Payment Cannot be in Minus", "Warning", JOptionPane.WARNING_MESSAGE);
            jFormattedTextField1.setText("");
        } else if (payment.equals("+")) {
            JOptionPane.showMessageDialog(this, "Cannot use symbol or letters", "Warning", JOptionPane.WARNING_MESSAGE);
            jFormattedTextField1.setText("0");
        } else if (payment.equals("/")) {
            JOptionPane.showMessageDialog(this, "Cannot use symbol or letters", "Warning", JOptionPane.WARNING_MESSAGE);
            jFormattedTextField1.setText("0");
        } else {
            calculate();
        }
    }//GEN-LAST:event_jFormattedTextField2KeyReleased

    private void jFormattedTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextField1KeyReleased

        String total = jLabel31.getText();
        String discount = jFormattedTextField1.getText();

        if (total.equals("Total Here")) {
            JOptionPane.showMessageDialog(this, "No Product has been Selected", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (discount.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Discount field is Empty", "Warning", JOptionPane.WARNING_MESSAGE);
            jFormattedTextField1.setText("0");
        } else if (!discount.matches("-?\\d*\\.?\\d+")) {
            JOptionPane.showMessageDialog(this, "Invalid Discount Amount", "Warning", JOptionPane.WARNING_MESSAGE);
            jFormattedTextField1.setText("0");
        } else if (Double.parseDouble(discount) < 0) {
            JOptionPane.showMessageDialog(this, "Dicount Cannot be in Minus", "Warning", JOptionPane.WARNING_MESSAGE);
            jFormattedTextField1.setText("0");
        } else {
            calculate();
        }

    }//GEN-LAST:event_jFormattedTextField1KeyReleased

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged

        if (jLabel36.getText().equals("(.........)")) {
            JOptionPane.showMessageDialog(this, "Customer NOT Selected", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            if (jCheckBox1.isSelected()) {
                calculate();
            }
        }

    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        FlatMacLightLaf.setup();
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                CheckOut dialog = new CheckOut(new javax.swing.JFrame(), true);
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
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JFormattedTextField jFormattedTextField3;
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private gui.RoundPanel roundPanel1;
    private gui.RoundPanel roundPanel2;
    private gui.RoundPanel roundPanel3;
    // End of variables declaration//GEN-END:variables
}
