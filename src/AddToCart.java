
import java.util.ArrayList;


public class AddToCart extends javax.swing.JFrame {
 
    public String item;
    public int id;
    public int quantity;
    public double price;
    public ArrayList<Cart> CF;
   
    public AddToCart (int id, String item, double price, ArrayList<Cart> CF)
    {
        initComponents();
        this.id = id;
        this.setVisible(true);
        CountField.setEditable(false);
        this.setLocationRelativeTo(null);
        this.item = item;
        this.price = price;  
        this.CF = CF;
    }
    
    public int GetQuantity ()
    {
        return quantity;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AddToCartPanel = new javax.swing.JPanel();
        QuantityPanel = new javax.swing.JPanel();
        QuantityLabel = new javax.swing.JLabel();
        QuantityConfirmButton = new javax.swing.JButton();
        CountPos = new javax.swing.JButton();
        CountNeg = new javax.swing.JButton();
        CountField = new javax.swing.JTextField();

        AddToCartPanel.setBackground(new java.awt.Color(172, 172, 172));

        QuantityPanel.setBackground(new java.awt.Color(137, 180, 177));

        QuantityLabel.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        QuantityLabel.setForeground(new java.awt.Color(51, 51, 51));
        QuantityLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        QuantityLabel.setText("Select Item Quantity");

        javax.swing.GroupLayout QuantityPanelLayout = new javax.swing.GroupLayout(QuantityPanel);
        QuantityPanel.setLayout(QuantityPanelLayout);
        QuantityPanelLayout.setHorizontalGroup(
            QuantityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, QuantityPanelLayout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addComponent(QuantityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );
        QuantityPanelLayout.setVerticalGroup(
            QuantityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QuantityPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(QuantityLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        QuantityConfirmButton.setBackground(new java.awt.Color(137, 180, 177));
        QuantityConfirmButton.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        QuantityConfirmButton.setText("CONFIRM");
        QuantityConfirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuantityConfirmButtonActionPerformed(evt);
            }
        });

        CountPos.setBackground(new java.awt.Color(137, 180, 177));
        CountPos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ArrowRight.png"))); // NOI18N
        CountPos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CountPosActionPerformed(evt);
            }
        });

        CountNeg.setBackground(new java.awt.Color(137, 180, 177));
        CountNeg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ArrowLeft.png"))); // NOI18N
        CountNeg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CountNegActionPerformed(evt);
            }
        });

        CountField.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        CountField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CountField.setText("0");
        CountField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CountFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AddToCartPanelLayout = new javax.swing.GroupLayout(AddToCartPanel);
        AddToCartPanel.setLayout(AddToCartPanelLayout);
        AddToCartPanelLayout.setHorizontalGroup(
            AddToCartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(QuantityPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(AddToCartPanelLayout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(QuantityConfirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddToCartPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CountNeg, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CountField, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CountPos, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153))
        );
        AddToCartPanelLayout.setVerticalGroup(
            AddToCartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddToCartPanelLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(QuantityPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AddToCartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CountPos, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CountNeg, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CountField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(QuantityConfirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AddToCartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(AddToCartPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void QuantityConfirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuantityConfirmButtonActionPerformed
        
        if (quantity >= 1)
        {
            CF.add (new Cart (id, item, quantity, price));
            setVisible (false); 
            CartConfirmation.main(null);
        }
        
        else 
        {
            
            Error.main(null);
        }
    }//GEN-LAST:event_QuantityConfirmButtonActionPerformed

    private void CountPosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CountPosActionPerformed
        CountField.setText(Integer.toString(++quantity));
    }//GEN-LAST:event_CountPosActionPerformed

    private void CountNegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CountNegActionPerformed
        if (quantity != 0)
        {
            CountField.setText(Integer.toString(--quantity));
        }
    }//GEN-LAST:event_CountNegActionPerformed

    private void CountFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CountFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CountFieldActionPerformed

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
            java.util.logging.Logger.getLogger(AddToCart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddToCart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddToCart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddToCart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new AddToCart().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AddToCartPanel;
    private javax.swing.JTextField CountField;
    private javax.swing.JButton CountNeg;
    private javax.swing.JButton CountPos;
    private javax.swing.JButton QuantityConfirmButton;
    private javax.swing.JLabel QuantityLabel;
    private javax.swing.JPanel QuantityPanel;
    // End of variables declaration//GEN-END:variables
}
