/*
 * Copyright Alocoifindo 2021®
 * GitHub with ♥︎ for sharing purposes
 * https://alocosite.w3spaces.com
 */
package com.alocoifindo.ecommerce;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

/**
 *
 * @author facundoferreyra
 */
public class PasswordUI extends javax.swing.JFrame implements WindowListener {

    static PasswordUI passUI = new PasswordUI();
    /**
     * Creates new form PasswordUI
     */
    public PasswordUI() {
        initComponents();
        setLocationRelativeTo(null);
        getRootPane().setDefaultButton(setPasswordButton);
        addWindowListener(this);
        oldPasswordLabel.setVisible(false);
        oldPasswordField.setVisible(false);
        errorPanel.setVisible(false);
        errorPassLabel.setVisible(false);
        errorOldPassLabel.setVisible(false);
        errorEmailLabel.setVisible(false);
        
        // dispose by ESCAPE_KEY
        InputMap im = getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = getRootPane().getActionMap();
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "cancel");
        am.put("cancel", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
    
    @Override
    public void windowClosing(WindowEvent e) {
        if (RentMyStuff.DEBUGwin) {
            System.out.println("passUI: windowClosing.");
        }
        
    }
    
    @Override
    public void windowClosed(WindowEvent e) {
        if (RentMyStuff.DEBUGwin) {
            //This will only be seen on standard output.
            System.out.println("passUI: windowClosed.");
            errorPanel.setVisible(false);
            errorPassLabel.setVisible(false);
            errorOldPassLabel.setVisible(false);
            errorEmailLabel.setVisible(false);
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        if (RentMyStuff.DEBUGwin) {
           System.out.println("passUI: windowOpened.");
        }
    }

    @Override
    public void windowIconified(WindowEvent e) {
        if (RentMyStuff.DEBUGwin) {
            System.out.println("passUI: windowIconified.");
        }
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        if (RentMyStuff.DEBUGwin) {
            System.out.println("passUI: windowDeiconified.");
        }
    }

    @Override
    public void windowActivated(WindowEvent e) {
        if (RentMyStuff.DEBUGwin) {
            System.out.println("passUI: windowActivated.");
        }
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        if (RentMyStuff.DEBUGwin) {
            System.out.println("passUI: windowDeactivated.");
        }
    }

    public static void showOldPassword() {
        emailLabel.setVisible(false);
        emailField.setVisible(false);
        oldPasswordLabel.setVisible(true);
        oldPasswordField.setVisible(true);
    }
    
    public static void showEmail() {
        emailLabel.setVisible(true);
        emailField.setVisible(true);
    }
    
    public boolean setPasswordInto(char[] newPass, int idUserChange) throws SQLException{
        Connection con = RentMyStuff.startConnection();

        // Password Check && Applying to DataBase
        try {
            UserUI.passwordValidator(newPass);

            String updtPassSQL = "UPDATE Users SET password= MD5(?) WHERE id_user=?";
            PreparedStatement stmtUpdtPass = con.prepareStatement(updtPassSQL);
            stmtUpdtPass.setString(1, String.valueOf(newPass));
            stmtUpdtPass.setInt(2, idUserChange);
            stmtUpdtPass.executeUpdate();

            RentMyStuff.closeStatement(stmtUpdtPass);
            RentMyStuff.stopConnection(con); 
            
            System.out.println("Password Updated");
            setVisible(false);
            return true;

        } catch (UserUI.InvalidPasswordException ipe) {
            System.out.println("Invalid password: " + String.valueOf(newPass));
            ipe.showMessage();
            return false;
        } 
    }
    
    public void removeMessages() {
        PasswordUI.passUI.newPasswordField.setText("");
        PasswordUI.passUI.repeatedPasswordField.setText("");
        PasswordUI.passUI.emailField.setText("");
        errorPassLabel.setVisible(false);
        errorOldPassLabel.setVisible(false);
        errorEmailLabel.setVisible(false);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        newPasswordField = new javax.swing.JPasswordField();
        newPasswordLabel = new javax.swing.JLabel();
        reNewPasswordLabel = new javax.swing.JLabel();
        repeatedPasswordField = new javax.swing.JPasswordField();
        cancelButton = new javax.swing.JButton();
        setPasswordButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        emailField = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        oldPasswordField = new javax.swing.JPasswordField();
        oldPasswordLabel = new javax.swing.JLabel();
        errorPanel = new javax.swing.JPanel();
        errorOldPassLabel = new javax.swing.JLabel();
        errorEmailLabel = new javax.swing.JLabel();
        errorPassLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Set New Password");
        setPreferredSize(new java.awt.Dimension(315, 200));

        newPasswordLabel.setText("New Password:");

        reNewPasswordLabel.setText("Repeat New Password:");

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        setPasswordButton.setText("Set Password");
        setPasswordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setPasswordButtonActionPerformed(evt);
            }
        });

        emailLabel.setText("Email:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(emailLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLabel)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        oldPasswordLabel.setText("Old Password:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(oldPasswordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(oldPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oldPasswordLabel)
                    .addComponent(oldPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        errorPanel.setLayout(new java.awt.BorderLayout());

        errorOldPassLabel.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        errorOldPassLabel.setForeground(new java.awt.Color(255, 0, 51));
        errorOldPassLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorOldPassLabel.setText("Old Password incorrect");
        errorPanel.add(errorOldPassLabel, java.awt.BorderLayout.PAGE_END);

        errorEmailLabel.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        errorEmailLabel.setForeground(new java.awt.Color(255, 0, 51));
        errorEmailLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorEmailLabel.setText("Email doesn't exist in our records");
        errorEmailLabel.setPreferredSize(new java.awt.Dimension(300, 13));
        errorPanel.add(errorEmailLabel, java.awt.BorderLayout.LINE_START);

        errorPassLabel.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        errorPassLabel.setForeground(new java.awt.Color(255, 0, 51));
        errorPassLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorPassLabel.setText("Password doesn't match");
        errorPanel.add(errorPassLabel, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(errorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(cancelButton)
                            .addGap(97, 97, 97)
                            .addComponent(setPasswordButton))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(64, 64, 64)
                                    .addComponent(newPasswordLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(newPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(reNewPasswordLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(repeatedPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newPasswordLabel)
                    .addComponent(newPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reNewPasswordLabel)
                    .addComponent(repeatedPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(errorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cancelButton)
                    .addComponent(setPasswordButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setPasswordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setPasswordButtonActionPerformed
        int idUserChange = 0;
        char[] oldPassword = oldPasswordField.getPassword();
        char[] newPassword = newPasswordField.getPassword();
        char[] repeatedPassword = repeatedPasswordField.getPassword();
        String email = emailField.getText();
        char[] emptyArray = new char[0];
        boolean newPassCorrect = false;
        
        // if oldPassword is not null
        if (!String.valueOf(oldPassword).equals("")) {
            try {
                    Connection con = RentMyStuff.startConnection();

                    // if oldPassword entered
                    if (!String.valueOf(oldPassword).equals("")) {
                        String oldPassSQL = "SELECT id_user FROM Users WHERE username=? AND password=?";
                        PreparedStatement stmtOldPass = con.prepareStatement(oldPassSQL);
                        stmtOldPass.setString(1, RentMyStuff.customer.getUsername());
                        stmtOldPass.setString(2, String.valueOf(oldPasswordField.getPassword()));
                        ResultSet rsOldPass = stmtOldPass.executeQuery();
                        if (rsOldPass.next()) {
                            idUserChange = rsOldPass.getInt("id_user");
                            
                            // Method to check & set password
                            if (setPasswordInto(newPassword, idUserChange)) {
                                setVisible(false);
                            }
                            
                        } else {
                            errorPanel.setVisible(true);
                            errorOldPassLabel.setVisible(true);
                        }
                        RentMyStuff.closeResultSet(rsOldPass);
                        RentMyStuff.closeStatement(stmtOldPass);
                    }
                    RentMyStuff.stopConnection(con);
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Couldn't set new password");
            }
            
        // if email exists
        } else if (UserUI.emailExist(email)) {
            // check newPassword and repeatedPassword
            if (String.valueOf(newPassword).equals(String.valueOf(repeatedPassword)) && !String.valueOf(newPassword).equals("")) {
                
                try {
                    Connection con = RentMyStuff.startConnection();

                    String oldPassSQL = "SELECT Customers.id_user, discount FROM Customers INNER JOIN Users WHERE username=? AND email=?";
                    PreparedStatement stmtEmail = con.prepareStatement(oldPassSQL);
                    stmtEmail.setString(1, RentMyStuff.customer.getUsername());
                    stmtEmail.setString(2, emailField.getText());
                    ResultSet rsEmail = stmtEmail.executeQuery();
                    if (rsEmail.next()) {
                        idUserChange = rsEmail.getInt("id_user");
                        int discount = rsEmail.getInt("discount");
                        
                        // Method to check & set password
                        if (setPasswordInto(newPassword, idUserChange)) {
                            RentMyStuff.customer.setId(idUserChange);
                            RentMyStuff.customer.setDiscount(discount);
                            LoginUI.setCustomerData(idUserChange);
                            
                            setVisible(false);
                            LoginUI.loginUI.setVisible(false);
                            ApplicationUI.appUI.setVisible(true);
                        }
                        
                        RentMyStuff.closeResultSet(rsEmail);
                        RentMyStuff.closeStatement(stmtEmail);
                    } else {
                        errorPanel.setVisible(true);
                        errorEmailLabel.setVisible(true);
                    }
                    RentMyStuff.stopConnection(con);
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Password Recovery couldn't be made");
                }
                
            } else {
                errorPanel.setVisible(true);
                errorPassLabel.setVisible(true);
            }
        } else {
            errorPanel.setVisible(true);
            errorEmailLabel.setVisible(true);
        }
        
    }//GEN-LAST:event_setPasswordButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        passUI.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("System".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PasswordUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PasswordUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PasswordUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PasswordUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                passUI.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    public static javax.swing.JTextField emailField;
    private static javax.swing.JLabel emailLabel;
    private javax.swing.JLabel errorEmailLabel;
    private javax.swing.JLabel errorOldPassLabel;
    private javax.swing.JPanel errorPanel;
    private javax.swing.JLabel errorPassLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    public javax.swing.JPasswordField newPasswordField;
    private javax.swing.JLabel newPasswordLabel;
    private static javax.swing.JPasswordField oldPasswordField;
    private static javax.swing.JLabel oldPasswordLabel;
    private javax.swing.JLabel reNewPasswordLabel;
    public javax.swing.JPasswordField repeatedPasswordField;
    private javax.swing.JButton setPasswordButton;
    // End of variables declaration//GEN-END:variables
}
