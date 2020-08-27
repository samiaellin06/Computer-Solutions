
public class UserFrame extends javax.swing.JFrame {
    
    public String name = "user";
     public String password = "12345";
    
    public UserFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CardPanel = new javax.swing.JPanel();
        LogInPane = new javax.swing.JPanel();
        LogPane = new javax.swing.JPanel();
        SignInLabel = new javax.swing.JLabel();
        UserNameLabel = new javax.swing.JLabel();
        UserNameField = new javax.swing.JTextField();
        PasswordLabel = new javax.swing.JLabel();
        PasswordField = new javax.swing.JPasswordField();
        LogInButton = new javax.swing.JButton();
        jLabel = new javax.swing.JLabel();
        SignUpButton = new javax.swing.JButton();
        SignUpPane = new javax.swing.JPanel();
        SignPane = new javax.swing.JPanel();
        CreateAccountLabel = new javax.swing.JLabel();
        SignNameLabel = new javax.swing.JLabel();
        SignUpUserNameField = new javax.swing.JTextField();
        SignUpPasswordLabel = new javax.swing.JLabel();
        PasswordField1 = new javax.swing.JPasswordField();
        SignUpLogInButton = new javax.swing.JButton();
        EmailField = new javax.swing.JTextField();
        EmailLabel = new javax.swing.JLabel();
        PasswordField2 = new javax.swing.JPasswordField();
        SignUpConfirmPasswordLabel = new javax.swing.JLabel();
        NamePanel = new javax.swing.JPanel();
        miniLogoPanel = new javax.swing.JLabel();
        LogoNameLabel = new javax.swing.JLabel();
        TopPane = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1300, 697));
        setMinimumSize(new java.awt.Dimension(1300, 697));

        CardPanel.setBackground(new java.awt.Color(172, 172, 172));
        CardPanel.setLayout(new java.awt.CardLayout());

        LogInPane.setBackground(new java.awt.Color(172, 172, 172));
        LogInPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LogPane.setBackground(new java.awt.Color(137, 180, 177));

        SignInLabel.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        SignInLabel.setForeground(new java.awt.Color(51, 51, 51));
        SignInLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SignInLabel.setText("SIGN IN");

        UserNameLabel.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        UserNameLabel.setForeground(new java.awt.Color(51, 51, 51));
        UserNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        UserNameLabel.setText("User Name:");

        UserNameField.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        UserNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserNameFieldActionPerformed(evt);
            }
        });

        PasswordLabel.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        PasswordLabel.setForeground(new java.awt.Color(51, 51, 51));
        PasswordLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        PasswordLabel.setText("Password:");

        PasswordField.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        PasswordField.setForeground(new java.awt.Color(51, 51, 51));
        PasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordFieldActionPerformed(evt);
            }
        });

        LogInButton.setBackground(new java.awt.Color(137, 180, 177));
        LogInButton.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        LogInButton.setForeground(new java.awt.Color(51, 51, 51));
        LogInButton.setText("Log In");
        LogInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogInButtonActionPerformed(evt);
            }
        });

        jLabel.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel.setForeground(new java.awt.Color(51, 51, 51));
        jLabel.setText("Don't have an account?");

        SignUpButton.setText("Sign up");
        SignUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignUpButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LogPaneLayout = new javax.swing.GroupLayout(LogPane);
        LogPane.setLayout(LogPaneLayout);
        LogPaneLayout.setHorizontalGroup(
            LogPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogPaneLayout.createSequentialGroup()
                .addGroup(LogPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LogPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(LogPaneLayout.createSequentialGroup()
                            .addGap(150, 150, 150)
                            .addComponent(SignInLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LogPaneLayout.createSequentialGroup()
                            .addGap(65, 65, 65)
                            .addGroup(LogPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(UserNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(PasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(LogPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(PasswordField, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                .addComponent(UserNameField))))
                    .addGroup(LogPaneLayout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addComponent(LogInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(LogPaneLayout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addComponent(jLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SignUpButton)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        LogPaneLayout.setVerticalGroup(
            LogPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogPaneLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(SignInLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(LogPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UserNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UserNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(LogPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(LogInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LogPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SignUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        LogInPane.add(LogPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(311, 29, -1, -1));

        CardPanel.add(LogInPane, "card3");

        SignUpPane.setBackground(new java.awt.Color(172, 172, 172));

        SignPane.setBackground(new java.awt.Color(137, 180, 177));

        CreateAccountLabel.setFont(new java.awt.Font("Trebuchet MS", 1, 28)); // NOI18N
        CreateAccountLabel.setForeground(new java.awt.Color(51, 51, 51));
        CreateAccountLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CreateAccountLabel.setText("Create Account");

        SignNameLabel.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        SignNameLabel.setForeground(new java.awt.Color(51, 51, 51));
        SignNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        SignNameLabel.setText("User Name:");

        SignUpUserNameField.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        SignUpUserNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignUpUserNameFieldActionPerformed(evt);
            }
        });

        SignUpPasswordLabel.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        SignUpPasswordLabel.setForeground(new java.awt.Color(51, 51, 51));
        SignUpPasswordLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        SignUpPasswordLabel.setText("Password:");

        PasswordField1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        PasswordField1.setForeground(new java.awt.Color(51, 51, 51));
        PasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordField1ActionPerformed(evt);
            }
        });

        SignUpLogInButton.setBackground(new java.awt.Color(137, 180, 177));
        SignUpLogInButton.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        SignUpLogInButton.setForeground(new java.awt.Color(51, 51, 51));
        SignUpLogInButton.setText("Log In");
        SignUpLogInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignUpLogInButtonActionPerformed(evt);
            }
        });

        EmailField.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        EmailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailFieldActionPerformed(evt);
            }
        });

        EmailLabel.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        EmailLabel.setForeground(new java.awt.Color(51, 51, 51));
        EmailLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        EmailLabel.setText("Email:");

        PasswordField2.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        PasswordField2.setForeground(new java.awt.Color(51, 51, 51));
        PasswordField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordField2ActionPerformed(evt);
            }
        });

        SignUpConfirmPasswordLabel.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        SignUpConfirmPasswordLabel.setForeground(new java.awt.Color(51, 51, 51));
        SignUpConfirmPasswordLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        SignUpConfirmPasswordLabel.setText("Confirm Password:");

        javax.swing.GroupLayout SignPaneLayout = new javax.swing.GroupLayout(SignPane);
        SignPane.setLayout(SignPaneLayout);
        SignPaneLayout.setHorizontalGroup(
            SignPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SignPaneLayout.createSequentialGroup()
                .addGroup(SignPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SignPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(SignPaneLayout.createSequentialGroup()
                            .addGap(150, 150, 150)
                            .addComponent(CreateAccountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SignPaneLayout.createSequentialGroup()
                            .addGap(54, 54, 54)
                            .addGroup(SignPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(SignNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(SignUpPasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(EmailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(SignUpConfirmPasswordLabel))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(SignPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(EmailField)
                                .addComponent(PasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                .addComponent(SignUpUserNameField)
                                .addComponent(PasswordField2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))))
                    .addGroup(SignPaneLayout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(SignUpLogInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        SignPaneLayout.setVerticalGroup(
            SignPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SignPaneLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(CreateAccountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(SignPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SignUpUserNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SignNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SignPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EmailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EmailField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SignPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SignUpPasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SignPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SignUpConfirmPasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(SignUpLogInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout SignUpPaneLayout = new javax.swing.GroupLayout(SignUpPane);
        SignUpPane.setLayout(SignUpPaneLayout);
        SignUpPaneLayout.setHorizontalGroup(
            SignUpPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1300, Short.MAX_VALUE)
            .addGroup(SignUpPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SignUpPaneLayout.createSequentialGroup()
                    .addContainerGap(325, Short.MAX_VALUE)
                    .addComponent(SignPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(325, Short.MAX_VALUE)))
        );
        SignUpPaneLayout.setVerticalGroup(
            SignUpPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 535, Short.MAX_VALUE)
            .addGroup(SignUpPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(SignPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        CardPanel.add(SignUpPane, "card4");

        NamePanel.setBackground(new java.awt.Color(137, 180, 177));
        NamePanel.setInheritsPopupMenu(true);
        NamePanel.setPreferredSize(new java.awt.Dimension(1380, 100));

        miniLogoPanel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        miniLogoPanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LOGO.png"))); // NOI18N

        LogoNameLabel.setFont(new java.awt.Font("Trebuchet MS", 1, 48)); // NOI18N
        LogoNameLabel.setForeground(new java.awt.Color(51, 51, 51));
        LogoNameLabel.setText("COMPUTER SOLUTIONS");

        javax.swing.GroupLayout NamePanelLayout = new javax.swing.GroupLayout(NamePanel);
        NamePanel.setLayout(NamePanelLayout);
        NamePanelLayout.setHorizontalGroup(
            NamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NamePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(miniLogoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LogoNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        NamePanelLayout.setVerticalGroup(
            NamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NamePanelLayout.createSequentialGroup()
                .addComponent(miniLogoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(NamePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LogoNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        TopPane.setBackground(new java.awt.Color(172, 172, 172));

        javax.swing.GroupLayout TopPaneLayout = new javax.swing.GroupLayout(TopPane);
        TopPane.setLayout(TopPaneLayout);
        TopPaneLayout.setHorizontalGroup(
            TopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        TopPaneLayout.setVerticalGroup(
            TopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1300, Short.MAX_VALUE)
            .addComponent(TopPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(CardPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TopPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(NamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(CardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UserNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserNameFieldActionPerformed

    private void PasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordFieldActionPerformed

    private void SignUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignUpButtonActionPerformed
        CardPanel.removeAll();
        CardPanel.add(SignUpPane);
        CardPanel.repaint();
        CardPanel.revalidate();
    }//GEN-LAST:event_SignUpButtonActionPerformed

    private void SignUpUserNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignUpUserNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SignUpUserNameFieldActionPerformed

    private void PasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordField1ActionPerformed

    private void EmailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailFieldActionPerformed

    private void PasswordField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordField2ActionPerformed

    private void SignUpLogInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignUpLogInButtonActionPerformed
        if (SignUpUserNameField.getText().isEmpty() || PasswordField1.getText().isEmpty() || PasswordField2.getText().isEmpty() || EmailField.getText().isEmpty()) 
        {
            Error.main(null);
        } 
        
        else
        {
             MainFrame.main(null);
        }
    }//GEN-LAST:event_SignUpLogInButtonActionPerformed

    private void LogInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogInButtonActionPerformed
        if (UserNameField.getText().isEmpty() || PasswordField.getText().isEmpty()) 
        {
            Error.main(null);
        } 
        
        else if ((UserNameField.getText().equals("user")) && (PasswordField.getText().equals( "12345"))) 
        {
             MainFrame.main(null);
        }
    }//GEN-LAST:event_LogInButtonActionPerformed

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
            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CardPanel;
    private javax.swing.JLabel CreateAccountLabel;
    private javax.swing.JTextField EmailField;
    private javax.swing.JLabel EmailLabel;
    private javax.swing.JButton LogInButton;
    private javax.swing.JPanel LogInPane;
    private javax.swing.JPanel LogPane;
    private javax.swing.JLabel LogoNameLabel;
    private javax.swing.JPanel NamePanel;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JPasswordField PasswordField1;
    private javax.swing.JPasswordField PasswordField2;
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JLabel SignInLabel;
    private javax.swing.JLabel SignNameLabel;
    private javax.swing.JPanel SignPane;
    private javax.swing.JButton SignUpButton;
    private javax.swing.JLabel SignUpConfirmPasswordLabel;
    private javax.swing.JButton SignUpLogInButton;
    private javax.swing.JPanel SignUpPane;
    private javax.swing.JLabel SignUpPasswordLabel;
    private javax.swing.JTextField SignUpUserNameField;
    private javax.swing.JPanel TopPane;
    private javax.swing.JTextField UserNameField;
    private javax.swing.JLabel UserNameLabel;
    private javax.swing.JLabel jLabel;
    private javax.swing.JLabel miniLogoPanel;
    // End of variables declaration//GEN-END:variables
}
