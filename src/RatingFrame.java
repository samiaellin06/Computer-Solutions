
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class RatingFrame extends javax.swing.JFrame {
    
    public Connection con;
    public Statement st;
    public ResultSet rs;
    public int rating;
    public double s1;
    public double n_rating;
    String i;
    public String q1;
    public int ID;
        
    public RatingFrame(double s1, String query, String i, int id) {
        this.n_rating = 0;
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.s1 = s1;
        this.q1 = query;
        this.ID = id;
        this.i = i;
        
    }
    
    public double getRating ()
    {
        n_rating = (rating + s1)/2; 
        return n_rating;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RatingPanel = new javax.swing.JPanel();
        RateLogoPanel = new javax.swing.JPanel();
        RatingLabel = new javax.swing.JLabel();
        RatingConfirmButton = new javax.swing.JButton();
        CountPos = new javax.swing.JButton();
        CountNeg = new javax.swing.JButton();
        CountField = new javax.swing.JTextField();

        RatingPanel.setBackground(new java.awt.Color(172, 172, 172));

        RateLogoPanel.setBackground(new java.awt.Color(137, 180, 177));

        RatingLabel.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        RatingLabel.setForeground(new java.awt.Color(51, 51, 51));
        RatingLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RatingLabel.setText("Rate the Item Out Of 5");

        javax.swing.GroupLayout RateLogoPanelLayout = new javax.swing.GroupLayout(RateLogoPanel);
        RateLogoPanel.setLayout(RateLogoPanelLayout);
        RateLogoPanelLayout.setHorizontalGroup(
            RateLogoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RateLogoPanelLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(RatingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );
        RateLogoPanelLayout.setVerticalGroup(
            RateLogoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RateLogoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(RatingLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        RatingConfirmButton.setBackground(new java.awt.Color(137, 180, 177));
        RatingConfirmButton.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        RatingConfirmButton.setText("CONFIRM");
        RatingConfirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RatingConfirmButtonActionPerformed(evt);
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

        javax.swing.GroupLayout RatingPanelLayout = new javax.swing.GroupLayout(RatingPanel);
        RatingPanel.setLayout(RatingPanelLayout);
        RatingPanelLayout.setHorizontalGroup(
            RatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(RateLogoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(RatingPanelLayout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(RatingConfirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RatingPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CountNeg, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CountField, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CountPos, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153))
        );
        RatingPanelLayout.setVerticalGroup(
            RatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RatingPanelLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(RateLogoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(RatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CountPos, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CountNeg, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CountField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(RatingConfirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(RatingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(RatingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RatingConfirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RatingConfirmButtonActionPerformed

        double star = getRating();
        
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/computer_solutions", "root", "");
                st = con.createStatement();
                DecimalFormat df = new DecimalFormat("#.00");
                String q = q1 + df.format(star) + i + ID + "'";
                PreparedStatement pst = con.prepareStatement(q);
                pst.execute();

            } catch (Exception ex) {
                System.out.println("Error:" + ex);
            }
            
        setVisible (false);
        Confirmation.main(null);
    }//GEN-LAST:event_RatingConfirmButtonActionPerformed

    private void CountPosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CountPosActionPerformed
        if (rating != 5)
        {
            CountField.setText(Integer.toString(++rating));
        }
    }//GEN-LAST:event_CountPosActionPerformed

    private void CountNegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CountNegActionPerformed
        if (rating != 0)
        {
            CountField.setText(Integer.toString(--rating));
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
            java.util.logging.Logger.getLogger(RatingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RatingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RatingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RatingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new RatingFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CountField;
    private javax.swing.JButton CountNeg;
    private javax.swing.JButton CountPos;
    private javax.swing.JPanel RateLogoPanel;
    private javax.swing.JButton RatingConfirmButton;
    private javax.swing.JLabel RatingLabel;
    private javax.swing.JPanel RatingPanel;
    // End of variables declaration//GEN-END:variables
}
