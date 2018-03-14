
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;


public class KayitEkrani extends javax.swing.JFrame {
     DB db=new DB();
     MyValidator my=new MyValidator();
     public KayitEkrani() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtAdi = new javax.swing.JTextField();
        txtSoyadi = new javax.swing.JTextField();
        txtTelefon = new javax.swing.JTextField();
        txtAdres = new javax.swing.JTextField();
        btnYeniKayit = new javax.swing.JButton();
        lblAdi = new javax.swing.JLabel();
        lblSoyadi = new javax.swing.JLabel();
        lblAdres = new javax.swing.JLabel();
        lblTelefon = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Müşteri Kayıt Ekranı", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 13), new java.awt.Color(204, 204, 255))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtAdi.setBackground(new java.awt.Color(51, 153, 255));
        txtAdi.setOpaque(true);
        jPanel1.add(txtAdi, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 140, 20));

        txtSoyadi.setBackground(new java.awt.Color(51, 153, 255));
        jPanel1.add(txtSoyadi, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 146, -1));

        txtTelefon.setBackground(new java.awt.Color(51, 153, 255));
        jPanel1.add(txtTelefon, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, 146, -1));

        txtAdres.setBackground(new java.awt.Color(51, 153, 255));
        txtAdres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAdresKeyPressed(evt);
            }
        });
        jPanel1.add(txtAdres, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, 146, -1));

        btnYeniKayit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/if_Accept-Male-User_49575.png"))); // NOI18N
        btnYeniKayit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYeniKayitActionPerformed(evt);
            }
        });
        jPanel1.add(btnYeniKayit, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, -1, -1));

        lblAdi.setText("ADI :");
        jPanel1.add(lblAdi, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 70, 17));

        lblSoyadi.setText("SOYADI :");
        jPanel1.add(lblSoyadi, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 90, 20));

        lblAdres.setText("ADRES :");
        jPanel1.add(lblAdres, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 80, 20));

        lblTelefon.setText("TELEFON : ");
        jPanel1.add(lblTelefon, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 90, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/SU.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 360, 420));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnYeniKayitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYeniKayitActionPerformed
      
        String adi = txtAdi.getText().trim();
        String soyadi=txtSoyadi.getText().trim();
        String telefon=txtTelefon.getText().trim();
        String adres = txtAdres.getText().trim();
        
        if(adi.equals("")) {
            JOptionPane.showMessageDialog(rootPane,"Müşteri Adını Giriniz !");
            txtAdi.requestFocus();
        } else if(soyadi.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Müşteri Soyadını Giriniz !");
            txtSoyadi.requestFocus();
        } else if (telefon.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Müşteri Telefon Numarasını Giriniz !");
            txtTelefon.requestFocus();
        } else if (adres.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen Adresi Giriniz !");
        }
           else {
            if(my.adSoyadValidator(adi)==1 && my.adSoyadValidator(soyadi)==1 && my.telefonValidator(telefon)==1 && my.adSoyadValidator(adres)==1 ){
            
             try {
               String yazQuery = "insert into musteriler values(null, ' " +adi +" ',' " +soyadi +" ',' " +telefon +" ',' " +adres +" ')";
               //System.out.println("yazQuery: "+yazQuery);
               int musterikayit = db.baglan().executeUpdate(yazQuery);
                System.out.println("Müsteri kayıt: "+musterikayit);
              
                 if(musterikayit > 0) {
                    db.kapat();
                    new AnaForm().musteriBilgisiGetir();
                    JOptionPane.showMessageDialog(rootPane, "Müşteri Kaydı Tamamlandı.");
                     AnaForm an = new AnaForm();
                     an.setVisible(true);
                     dispose();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Kayıt başarısız oldu.");
                }
                
            } catch (Exception e) {
                 System.err.println("Kayıt hatası: " + e);
            } finally {
                db.kapat();
                }
          
            }else{
                if(my.adSoyadValidator(adi)==-1){
                
                    JOptionPane.showMessageDialog(rootPane, "Ad alanı sadece harf içermelidir");
                    txtAdi.setText("");
                    txtAdi.requestFocus();
                    
                } else if(my.adSoyadValidator(soyadi)==-1){
                
                    JOptionPane.showMessageDialog(rootPane, "Soyadı alanı sadece harf içermelidir.");
                    txtSoyadi.setText("");
                    txtSoyadi.requestFocus();
                    
            }  else if(my.telefonValidator(telefon)==-2){
                
                    JOptionPane.showMessageDialog(rootPane, "Telefon numarası 10 haneli olmalıdır.");
                    txtTelefon.setText("");
                    txtTelefon.requestFocus();
                    
           }else if(my.telefonValidator(telefon)==-1){
                
                    JOptionPane.showMessageDialog(rootPane, "Telefon numarasındaki tüm karakterler rakam olmalıdır ");
                    txtTelefon.setText("");
                    txtTelefon.requestFocus();
                    
           }else if(my.telefonValidator(telefon)==0){
                
                    JOptionPane.showMessageDialog(rootPane, "Telefon numarası 5 ile başlamalıdır");
                    txtTelefon.setText("");
                    txtTelefon.requestFocus();
                    
           }else if(my.adSoyadValidator(adres)==-1){
                
                    JOptionPane.showMessageDialog(rootPane, "Adres alanı sadece harf içermelidir");
                    txtAdres.setText("");
                    txtAdres.requestFocus();
           }
        }
    }//GEN-LAST:event_btnYeniKayitActionPerformed
 }
    private void txtAdresKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAdresKeyPressed

        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnYeniKayitActionPerformed(null);
        }
        
    }//GEN-LAST:event_txtAdresKeyPressed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

        new AnaForm().setVisible(true);
        
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(KayitEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KayitEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KayitEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KayitEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KayitEkrani().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnYeniKayit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAdi;
    private javax.swing.JLabel lblAdres;
    private javax.swing.JLabel lblSoyadi;
    private javax.swing.JLabel lblTelefon;
    private javax.swing.JTextField txtAdi;
    private javax.swing.JTextField txtAdres;
    private javax.swing.JTextField txtSoyadi;
    private javax.swing.JTextField txtTelefon;
    // End of variables declaration//GEN-END:variables
}
