
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;


public class YeniSiparis extends javax.swing.JFrame {
    DB db=new DB();
    
    static boolean drm=false;
    
    public YeniSiparis() {
        initComponents();
        
        drm=true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblAdi = new javax.swing.JLabel();
        lblSoyadi = new javax.swing.JLabel();
        lblAdres = new javax.swing.JLabel();
        lblUcret = new javax.swing.JLabel();
        txtAdi = new javax.swing.JTextField();
        txtSoyadi = new javax.swing.JTextField();
        txtAdres = new javax.swing.JTextField();
        txtUcret = new javax.swing.JTextField();
        btnSiparisGonder = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sipariş Ekranı", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 13), new java.awt.Color(204, 204, 255))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAdi.setText("ADI:");
        jPanel1.add(lblAdi, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, -1, -1));

        lblSoyadi.setText("SOYADI:");
        jPanel1.add(lblSoyadi, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, -1, -1));

        lblAdres.setText("ADRES:");
        jPanel1.add(lblAdres, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, -1, -1));

        lblUcret.setText("ÜCRET:");
        jPanel1.add(lblUcret, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, -1, -1));

        txtAdi.setBackground(new java.awt.Color(51, 153, 255));
        jPanel1.add(txtAdi, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 133, -1));

        txtSoyadi.setBackground(new java.awt.Color(51, 153, 255));
        jPanel1.add(txtSoyadi, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 133, -1));

        txtAdres.setBackground(new java.awt.Color(51, 153, 255));
        jPanel1.add(txtAdres, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 133, -1));

        txtUcret.setBackground(new java.awt.Color(51, 153, 255));
        txtUcret.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUcretKeyPressed(evt);
            }
        });
        jPanel1.add(txtUcret, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, 133, -1));

        btnSiparisGonder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/if_resolutions-18_897234.png"))); // NOI18N
        btnSiparisGonder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiparisGonderActionPerformed(evt);
            }
        });
        jPanel1.add(btnSiparisGonder, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/SU.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 370, 440));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSiparisGonderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiparisGonderActionPerformed
        String adi = txtAdi.getText().trim();
        String soyadi=txtSoyadi.getText().trim();
        String adres = txtAdres.getText().trim();
        String ucret=txtUcret.getText().trim();
        
        
        boolean kontrol = false;
        
        for (char harf:ucret.toCharArray()) {
            if(!(Character.isDigit(harf))) {
                kontrol=true;
                JOptionPane.showMessageDialog(rootPane, "Lütfen sayısal değer giriniz !");
                txtUcret.setText("");
                txtUcret.requestFocus();
                break;
            }
        } if(ucret.equals("")) {
             JOptionPane.showMessageDialog(rootPane, "Lütfen sipariş tutarını giriniz !");
        } else if(!kontrol) {
          try {
              String siparis = ucret;
              String teslimDurum = "sipariş alındı";
              String siparisAlQuery="insert into siparisler values (null , '"+adi+"','"+soyadi+"','"+adres+"','"+ucret+"' , '"+teslimDurum+"')";
            
              int siparisSonuc=db.baglan().executeUpdate(siparisAlQuery);
              
              if(siparisSonuc >  0) {
                  db.kapat();
                  new AnaForm().musteriBilgisiGetir();
                  
                  JOptionPane.showMessageDialog(rootPane, "Sipariş alındı.");
                  AnaForm af=new AnaForm();
                  af.setVisible(true);
                  dispose();
                          
              } else {
                  JOptionPane.showMessageDialog(rootPane, "Sipariş kaydı yapılamadı.");
              }
              
              
          } catch (Exception e) {
              System.err.println("Sipariş hatası : " + e);
          } finally {
              db.kapat();
          }
      }
      
    }//GEN-LAST:event_btnSiparisGonderActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        new AnaForm().setVisible(true);
        drm=false;
    }//GEN-LAST:event_formWindowClosed

    private void txtUcretKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUcretKeyPressed

        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnSiparisGonderActionPerformed(null);
        }
    }//GEN-LAST:event_txtUcretKeyPressed

    
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
            java.util.logging.Logger.getLogger(YeniSiparis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(YeniSiparis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(YeniSiparis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(YeniSiparis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new YeniSiparis().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSiparisGonder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAdi;
    private javax.swing.JLabel lblAdres;
    private javax.swing.JLabel lblSoyadi;
    private javax.swing.JLabel lblUcret;
    public javax.swing.JTextField txtAdi;
    public javax.swing.JTextField txtAdres;
    public javax.swing.JTextField txtSoyadi;
    public javax.swing.JTextField txtUcret;
    // End of variables declaration//GEN-END:variables
}
