
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class CartFrame extends javax.swing.JFrame {
    
    public ArrayList<Cart> CF;
    public double sum = 0;
    public int confirm = 0;
    
    public Connection con;
    public Statement st;
    public ResultSet rs;
    public PreparedStatement pst;
    
    public CartFrame(ArrayList<Cart> CF) {
        initComponents();
        this.setVisible(true);
        
        TotalPriceField.setEditable(false);
        
        this.CF = CF;
        
        DefaultTableModel model = (DefaultTableModel) CartTable.getModel();
        Object[] row = new Object[3];
      
        for (int i = 0; i < CF.size(); i++)
        {
            row[0] = CF.get(i).item;
            row[1] = CF.get(i).quantity;
            row[2] = CF.get(i).price;
            model.addRow(row);
        }
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        LabelPanel = new javax.swing.JPanel();
        MainCartLogo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        TotalPriceField = new javax.swing.JTextField();
        TotalPriceLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        CartTable = new javax.swing.JTable();
        ConfirmPrice = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(172, 172, 172));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setToolTipText("");

        LabelPanel.setBackground(new java.awt.Color(137, 180, 177));

        MainCartLogo.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        MainCartLogo.setText("CART");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainCartLogo.png"))); // NOI18N

        javax.swing.GroupLayout LabelPanelLayout = new javax.swing.GroupLayout(LabelPanel);
        LabelPanel.setLayout(LabelPanelLayout);
        LabelPanelLayout.setHorizontalGroup(
            LabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LabelPanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MainCartLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        LabelPanelLayout.setVerticalGroup(
            LabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LabelPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MainCartLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TotalPriceField.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        TotalPriceField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        TotalPriceField.setText("0.0");
        TotalPriceField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalPriceFieldActionPerformed(evt);
            }
        });

        TotalPriceLabel.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        TotalPriceLabel.setForeground(new java.awt.Color(51, 51, 51));
        TotalPriceLabel.setText("Total Price:");

        CartTable.setAutoCreateRowSorter(true);
        CartTable.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        CartTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Quantity", "Price (Tk)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        CartTable.setSelectionBackground(new java.awt.Color(137, 180, 177));
        CartTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(CartTable);
        if (CartTable.getColumnModel().getColumnCount() > 0) {
            CartTable.getColumnModel().getColumn(0).setResizable(false);
            CartTable.getColumnModel().getColumn(0).setPreferredWidth(160);
            CartTable.getColumnModel().getColumn(0).setHeaderValue("Item");
            CartTable.getColumnModel().getColumn(1).setResizable(false);
            CartTable.getColumnModel().getColumn(1).setPreferredWidth(50);
            CartTable.getColumnModel().getColumn(1).setHeaderValue("Quantity");
            CartTable.getColumnModel().getColumn(2).setResizable(false);
            CartTable.getColumnModel().getColumn(2).setPreferredWidth(60);
            CartTable.getColumnModel().getColumn(2).setHeaderValue("Price (Tk)");
        }

        ConfirmPrice.setBackground(new java.awt.Color(137, 180, 177));
        ConfirmPrice.setText("CONFIRM");
        ConfirmPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmPriceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LabelPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(TotalPriceLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TotalPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(107, 107, 107)
                                .addComponent(ConfirmPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(LabelPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ConfirmPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TotalPriceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TotalPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TotalPriceFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalPriceFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TotalPriceFieldActionPerformed

    private void ConfirmPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmPriceActionPerformed
        
        if (CartTable.getModel().getRowCount() == 0)
        {
            Error.main(null);
        }
        
        else if (confirm == 0)
        {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Database is Connecting.....");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/computer_solutions", "root", "");
                System.out.println("Database is connected !");
                
                int x = 0;
                int y = 0;
                
                for (int i = 0; i < CF.size(); i++) {
                        if (CF.get(i).getId() >= 301 && CF.get(i).getId() <= 316)
                        {
                            x = CF.get(i).getId();
                        }
                        
                        if (CF.get(i).getId() >= 1201 && CF.get(i).getId() <= 1211)
                        {
                            y = CF.get(i).getId();
                        }
                        
                    }

                String sql1 = "SELECT CPU_ID from cpu WHERE (MBoard_ID =" + y + " and RAM_ID =" + x + ")";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();

                if (rs.next() && x != 0 && y != 0) {

                    for (int i = 0; i < CF.size(); i++) {
                        sum = sum + (CF.get(i).quantity * CF.get(i).price);
                    }

                    TotalPriceField.setText(String.valueOf(sum + " Tk"));
                    confirm = 1;
                }
                
                else if (!rs.next() && x == 0 && y == 0)
                {
                    for (int i = 0; i < CF.size(); i++) {
                        sum = sum + (CF.get(i).quantity * CF.get(i).price);
                    }

                    TotalPriceField.setText(String.valueOf(sum + " Tk"));
                    confirm = 1;
                }
                
                else
                {
                    Compatibility.main(null);
                }
                
            } catch (Exception ex) {
                System.out.println("Error:" + ex);
            }  
        }  
    }//GEN-LAST:event_ConfirmPriceActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new CartFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable CartTable;
    private javax.swing.JButton ConfirmPrice;
    private javax.swing.JPanel LabelPanel;
    private javax.swing.JLabel MainCartLogo;
    private javax.swing.JTextField TotalPriceField;
    private javax.swing.JLabel TotalPriceLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
