
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class YoneticiGirisi extends javax.swing.JFrame {

    DB db = new DB();

    public YoneticiGirisi() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        btnCikis = new javax.swing.JButton();
        btnGiris = new javax.swing.JButton();
        lblKullaniciAdi = new javax.swing.JLabel();
        txtKullaniciGirisi = new javax.swing.JTextField();
        lblKullaniciSifresi = new javax.swing.JLabel();
        txtKullaniciSifresi = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        jPasswordField1.setText("jPasswordField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "YÖNETİCİ GİRİŞİ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 13), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCikis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/if_Delete_27842.png"))); // NOI18N
        btnCikis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCikisActionPerformed(evt);
            }
        });
        jPanel1.add(btnCikis, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 350, 80, 70));

        btnGiris.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/if_Login_73221.png"))); // NOI18N
        btnGiris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGirisActionPerformed(evt);
            }
        });
        jPanel1.add(btnGiris, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 260, -1, -1));

        lblKullaniciAdi.setText("Kullanıcı Adı : ");
        jPanel1.add(lblKullaniciAdi, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 126, 26));

        txtKullaniciGirisi.setText("hatice");
        jPanel1.add(txtKullaniciGirisi, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, 138, -1));

        lblKullaniciSifresi.setText("Şifre : ");
        jPanel1.add(lblKullaniciSifresi, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 87, 27));

        txtKullaniciSifresi.setText("12345");
        txtKullaniciSifresi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKullaniciSifresiKeyPressed(evt);
            }
        });
        jPanel1.add(txtKullaniciSifresi, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, 138, -1));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/7803_makale15-2.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 610, 440));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCikisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCikisActionPerformed
   int secim= JOptionPane.showConfirmDialog(rootPane,"Çıkmak istediğinize emin misiniz?","DİKKAT",JOptionPane.YES_NO_OPTION);
    if(secim == 0) {
        dispose();
    }
    }//GEN-LAST:event_btnCikisActionPerformed

    private void btnGirisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGirisActionPerformed

        String kullaniciGirisi = txtKullaniciGirisi.getText().trim();
        String kullaniciSifresi = txtKullaniciSifresi.getText().trim();
        
        if (kullaniciGirisi.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen kullanıcı adını giriniz.");
            txtKullaniciGirisi.requestFocus();
        } else if (kullaniciSifresi.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen sifreyi giriniz.");
            txtKullaniciSifresi.requestFocus();
        } else {
            try {
                
                String adminQuery = "select adm from yonetici where adminadi = '" + kullaniciGirisi + "' and adminsifre = '" + kullaniciSifresi + "'   ";
               // System.out.println(adminQuery);
                ResultSet rs = db.baglan().executeQuery(adminQuery);
                if (rs.next()) {
                    AnaForm fm = new AnaForm();
                    fm.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Kullanıcı bilgileri hatalıdır. Lütfen tekrar deneyiniz.");
                    txtKullaniciGirisi.setText("");
                    txtKullaniciSifresi.setText("");
                }
            } catch (Exception e) {
            } finally {
                db.kapat();
            }
        }
    }//GEN-LAST:event_btnGirisActionPerformed

    private void txtKullaniciSifresiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKullaniciSifresiKeyPressed
       if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
           btnGirisActionPerformed(null);
       }
    }//GEN-LAST:event_txtKullaniciSifresiKeyPressed

    public YoneticiGirisi(JButton btnCikis, JButton btnGiris, JLabel jLabel1, JLabel jLabel2, JPanel jPanel1, JTextField txtKullaniciGirisi, JPasswordField txtKullaniciSifresi) throws HeadlessException {
        this.btnCikis = btnCikis;
        this.btnGiris = btnGiris;
        this.lblKullaniciAdi = jLabel1;
        this.lblKullaniciSifresi = jLabel2;
        this.jPanel1 = jPanel1;
        this.txtKullaniciGirisi = txtKullaniciGirisi;
        this.txtKullaniciSifresi = txtKullaniciSifresi;
    }

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
            java.util.logging.Logger.getLogger(YoneticiGirisi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(YoneticiGirisi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(YoneticiGirisi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(YoneticiGirisi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new YoneticiGirisi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCikis;
    private javax.swing.JButton btnGiris;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JLabel lblKullaniciAdi;
    private javax.swing.JLabel lblKullaniciSifresi;
    private javax.swing.JTextField txtKullaniciGirisi;
    private javax.swing.JPasswordField txtKullaniciSifresi;
    // End of variables declaration//GEN-END:variables
}
