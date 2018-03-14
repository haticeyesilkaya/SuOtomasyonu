
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class AnaForm extends javax.swing.JFrame {

    static int kayiteklendi = 0;
    DB db = new DB();

    public AnaForm() {
        initComponents();
        // db.baglan();
        musteriBilgisiGetir();
        // db.kapat();
        siparisBilgisiGetir();
        //  db.kapat();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblMusteriAdi = new javax.swing.JLabel();
        lblMusteriSoyadi = new javax.swing.JLabel();
        txtMusteriAdi = new javax.swing.JTextField();
        txtMusteriSoyadi = new javax.swing.JTextField();
        btnAra = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnSeciliSil = new javax.swing.JButton();
        btnTumunuSil = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMusteriler = new javax.swing.JTable();
        btnYeniKaydet = new javax.swing.JButton();
        btnDuzenle = new javax.swing.JButton();
        btnSil = new javax.swing.JButton();
        btnYenile = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSiparisler = new javax.swing.JTable();
        btnYeniSiparis = new javax.swing.JButton();
        btnYolaCikti = new javax.swing.JButton();
        btnTeslimEdildi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 51, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Arama", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 13), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMusteriAdi.setForeground(new java.awt.Color(255, 255, 255));
        lblMusteriAdi.setText("Müşteri Adı :");
        jPanel2.add(lblMusteriAdi, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 46, -1, -1));

        lblMusteriSoyadi.setBackground(new java.awt.Color(255, 255, 255));
        lblMusteriSoyadi.setForeground(new java.awt.Color(255, 255, 255));
        lblMusteriSoyadi.setText("Müşteri Soyadı :");
        jPanel2.add(lblMusteriSoyadi, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 84, -1, -1));
        jPanel2.add(txtMusteriAdi, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 41, 111, -1));
        jPanel2.add(txtMusteriSoyadi, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 79, 111, -1));

        btnAra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/if_Search-Male-User_49620.png"))); // NOI18N
        btnAra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAraActionPerformed(evt);
            }
        });
        jPanel2.add(btnAra, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 70, 70));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 480, 150));

        jPanel3.setBackground(new java.awt.Color(0, 51, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "İşlemler", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 13), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSeciliSil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/if_edit-delete_23231.png"))); // NOI18N
        btnSeciliSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeciliSilActionPerformed(evt);
            }
        });
        jPanel3.add(btnSeciliSil, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, -1, 76));

        btnTumunuSil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/if_edit-clear_118917.png"))); // NOI18N
        btnTumunuSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTumunuSilActionPerformed(evt);
            }
        });
        jPanel3.add(btnTumunuSil, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, 470, 150));

        jPanel4.setBackground(new java.awt.Color(0, 51, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Müşteriler", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 13), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblMusteriler.setBackground(new java.awt.Color(0, 51, 102));
        tblMusteriler.setForeground(new java.awt.Color(255, 255, 255));
        tblMusteriler.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblMusteriler.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMusterilerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMusteriler);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 180));

        btnYeniKaydet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/if_Accept-Male-User_49575.png"))); // NOI18N
        btnYeniKaydet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYeniKaydetActionPerformed(evt);
            }
        });
        jPanel4.add(btnYeniKaydet, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 90, 84));

        btnDuzenle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/if_Edit-Male-User_49585.png"))); // NOI18N
        btnDuzenle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDuzenleActionPerformed(evt);
            }
        });
        jPanel4.add(btnDuzenle, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 83, 84));

        btnSil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/if_Male-User-Warning_49595.png"))); // NOI18N
        btnSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSilActionPerformed(evt);
            }
        });
        jPanel4.add(btnSil, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, 81, 84));

        btnYenile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/if_repeat_23535-2.png"))); // NOI18N
        btnYenile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYenileActionPerformed(evt);
            }
        });
        jPanel4.add(btnYenile, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, 92, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 480, 340));

        jPanel5.setBackground(new java.awt.Color(0, 51, 102));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Siparişler", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 13), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblSiparisler.setBackground(new java.awt.Color(0, 51, 102));
        tblSiparisler.setForeground(new java.awt.Color(255, 255, 255));
        tblSiparisler.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblSiparisler.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSiparislerMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSiparisler);

        jPanel5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 180));

        btnYeniSiparis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/if_resolutions-18_897234.png"))); // NOI18N
        btnYeniSiparis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYeniSiparisActionPerformed(evt);
            }
        });
        jPanel5.add(btnYeniSiparis, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 97, 85));

        btnYolaCikti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/if_autoship_47976.png"))); // NOI18N
        btnYolaCikti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYolaCiktiActionPerformed(evt);
            }
        });
        jPanel5.add(btnYolaCikti, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 91, 85));

        btnTeslimEdildi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/if_button_23_61454.png"))); // NOI18N
        btnTeslimEdildi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTeslimEdildiActionPerformed(evt);
            }
        });
        jPanel5.add(btnTeslimEdildi, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 240, 92, 85));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 190, 470, 340));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //yeni kayıt ekranına geçiş yapıyoruz.
    private void btnYeniKaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYeniKaydetActionPerformed
        KayitEkrani ke = new KayitEkrani();
        ke.setVisible(true);
        dispose();

    }//GEN-LAST:event_btnYeniKaydetActionPerformed

    //sipariş siliyoruz
    String sid = "";
    private void btnSeciliSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeciliSilActionPerformed
        if (sid.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen seçim yapınız");
        } else {
            int secim = JOptionPane.showConfirmDialog(rootPane, "silmek istediğinize emin misiniz ? ", "uyarı", JOptionPane.YES_NO_OPTION);
            try {
                if (secim == 0) {
                    String silQuery = "delete from siparisler where sid = '" + sid + "' ";
                    int silSonuc = db.baglan().executeUpdate(silQuery);
                    if (silSonuc > 0) {
                        db.kapat();
                        siparisBilgisiGetir();
                        JOptionPane.showMessageDialog(rootPane, "Silme işlemi başarılı :)");
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Silme hatası!!");
                    }
                }

            } catch (Exception e) {
                System.err.println("Silme hatası: " + e);
            } finally {
                db.kapat();
            }
        }
    }//GEN-LAST:event_btnSeciliSilActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked


    }//GEN-LAST:event_jPanel1MouseClicked
    //müşteri siliyoruz

    private void tblMusterilerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMusterilerMouseClicked
        int row = tblMusteriler.getSelectedRow(); //tıklanan satırı seçer
        if (row > -1) {
            kid = "" + tblMusteriler.getValueAt(row, 0); //önce satır sonra sütun yazmalıyız!
            // System.out.println("kid : " + kid);
        }
    }//GEN-LAST:event_tblMusterilerMouseClicked

    private void tblSiparislerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSiparislerMouseClicked
        int row = tblSiparisler.getSelectedRow();
        sid = "" + tblSiparisler.getValueAt(row, 0);
        System.out.println("sid : " + sid);

    }//GEN-LAST:event_tblSiparislerMouseClicked
    //Müşteri siliyoruz
    String kid = "";
    private void btnSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSilActionPerformed

        if (kid.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen seçim yapınız!");
        } else {

            int secim = JOptionPane.showConfirmDialog(rootPane, "Silmek istediğinize emin misiniz ? ", "UYARI", JOptionPane.YES_NO_OPTION);
            try {
                if (secim == 0) {
                    String silQuery = "delete from musteriler where kid = '" + kid + "' ";
                    int silSonuc = db.baglan().executeUpdate(silQuery);
                    
                    if (silSonuc > 0) {
                        db.kapat();
                        musteriBilgisiGetir();
                        JOptionPane.showMessageDialog(rootPane, "Müşteri kaydı silindi.");
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Silme hatası!");
                    }
                }

            } catch (Exception e) {
                System.err.println("Silme hatası: " + e);
            } finally {
                db.kapat();
            }
        }
    }//GEN-LAST:event_btnSilActionPerformed

    YeniSiparis ys = null;
    private void btnYeniSiparisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYeniSiparisActionPerformed
        //  ys.setVisible(true);

        if (kid.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen seçim yapınız.");
        } else {
            if (!YeniSiparis.drm) {
                ys = new YeniSiparis();
                int row = tblMusteriler.getSelectedRow();
                ys.setVisible(true);
                dispose();

                TableModel model = tblMusteriler.getModel();

                String sid = model.getValueAt(row, 0).toString();
                String adi = model.getValueAt(row, 1).toString();
                String soyadi = model.getValueAt(row, 2).toString();
                String adres = model.getValueAt(row, 4).toString();

                ys.setVisible(true);
                ys.pack();
                ys.setLocationRelativeTo(null);

                ys.txtAdi.setText(adi);
                ys.txtSoyadi.setText(soyadi);
                ys.txtAdres.setText(adres);

            }

        }

    }//GEN-LAST:event_btnYeniSiparisActionPerformed

    private void btnTumunuSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTumunuSilActionPerformed
        int secim = JOptionPane.showConfirmDialog(rootPane, "Tüm siparişleri silmek istediğinize emin misiniz ?", "DİKKAT", JOptionPane.YES_NO_OPTION);
        try {
            if (secim == 0) {
                String tumunusilQuery = "delete from siparisler";
                int tumunusil = db.baglan().executeUpdate(tumunusilQuery);
                db.kapat();
                siparisBilgisiGetir();
                JOptionPane.showMessageDialog(rootPane, "Tüm siparişler silindi.");
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            db.kapat();
        }

    }//GEN-LAST:event_btnTumunuSilActionPerformed

    private void btnAraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAraActionPerformed
        String musteriadi = txtMusteriAdi.getText().trim();
        String musterisoyadi = txtMusteriSoyadi.getText().trim();

        if (musteriadi.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen kullanıcı adını giriniz.");
            txtMusteriAdi.requestFocus();

        } else if (musterisoyadi.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen kullanıcı soyadını giriniz giriniz.");
            txtMusteriSoyadi.requestFocus();

        } else {
            try {
                String araQuery = "select * from musteriler where kadi = '" + musteriadi + "' and ksoyadi = '" + musterisoyadi + "'";
                ResultSet rs = db.baglan().executeQuery(araQuery);
                
                    DefaultTableModel dt = new DefaultTableModel();
                    dt.addColumn("ID");
                    dt.addColumn("Adı");
                    dt.addColumn("Soyadı");
                    dt.addColumn("Telefon");
                    dt.addColumn("Adres");

                    while (rs.next()) {
                        System.out.println("hjAD");
                        dt.addRow(new String[]{(rs.getString("kid")), rs.getString("kadi"), rs.getString("ksoyadi"), rs.getString("ktelefon"), rs.getString("kadres")});
                    }
                    tblMusteriler.setModel(dt);

                txtMusteriAdi.setText("");
                txtMusteriSoyadi.setText("");

            } catch (Exception e) {
                System.err.println("Arama hatası = " + e);
            } finally {
                db.kapat();
            }
        }


    }//GEN-LAST:event_btnAraActionPerformed

    private void btnDuzenleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDuzenleActionPerformed
        //Diğer forma geçiş yapıyoruz
         if (kid.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen seçim yapınız.");
         } else {
               MusteriDuzenle md = new MusteriDuzenle(kid);
               md.setVisible(true);
               dispose();
         }
      

    }//GEN-LAST:event_btnDuzenleActionPerformed

    private void btnYolaCiktiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYolaCiktiActionPerformed
        if (sid.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen seçim yapınız.");
        } else {
            try {
                String yolQuery = "update siparisler set sdurum = 'Yola çıktı.' where sid='" + sid + "'";
                int siparisSonuc = db.baglan().executeUpdate(yolQuery);
                if (siparisSonuc > 0) {
                    db.kapat();
                    new AnaForm().siparisBilgisiGetir();

                  //  JOptionPane.showMessageDialog(rootPane, "Yazma işlemi başarılı");
                    AnaForm af = new AnaForm();
                    af.setVisible(true);
                    dispose();
                }
            } catch (Exception e) {
                System.err.println(e);
            } finally {
                db.kapat();
            }
        }
    }//GEN-LAST:event_btnYolaCiktiActionPerformed

    private void btnTeslimEdildiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTeslimEdildiActionPerformed
        if (sid.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen seçim yapınız.");
        } else {
            try {
                String yolQuery = "update siparisler set sdurum = 'Teslim edildi.' where sid='" + sid + "'";
                int siparisSonuc = db.baglan().executeUpdate(yolQuery);
                if (siparisSonuc > 0) {
                    db.kapat();
                    new AnaForm().siparisBilgisiGetir();

                 //   JOptionPane.showMessageDialog(rootPane, "Yazma işlemi başarılı");
                    AnaForm af = new AnaForm();
                    af.setVisible(true);
                    dispose();
                }
            } catch (Exception e) {
                System.err.println(e);
            } finally {
                db.kapat();
            }
        }
    }//GEN-LAST:event_btnTeslimEdildiActionPerformed

    private void btnYenileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYenileActionPerformed
       musteriBilgisiGetir();
    }//GEN-LAST:event_btnYenileActionPerformed

    public void musteriBilgisiGetir() {
        try {

            String musteriQuery = "Select * from musteriler";
            ResultSet rs = db.baglan().executeQuery(musteriQuery);
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("ID");
            dtm.addColumn("Adı");
            dtm.addColumn("Soyadı");
            dtm.addColumn("Telefon");
            dtm.addColumn("Adres");

            while (rs.next()) {
                dtm.addRow(new String[]{rs.getString("kid"), rs.getString("kadi"), rs.getString("ksoyadi"), rs.getString("ktelefon"), rs.getString("kadres")});

            }
            tblMusteriler.setModel(dtm); //Bizim yazdığımız tabloyu getirir

        } catch (Exception e) {
            System.err.println("Data getirme hatası: " + e);
        } finally {
            db.kapat();
        }
    }

    public void siparisBilgisiGetir() {

        String siparisQuery = "Select * from siparisler";
        try {

            ResultSet rs = db.baglan().executeQuery(siparisQuery);
            DefaultTableModel dtm = new DefaultTableModel();

            dtm.addColumn("Müşteri ID");
            dtm.addColumn("Adı: ");
            dtm.addColumn("Soyadı: ");
            dtm.addColumn("Adres");
            dtm.addColumn("Ucret");
            dtm.addColumn("Durum");

            while (rs.next()) {
                dtm.addRow(new String[]{rs.getString("sid"), rs.getString("sadi"), rs.getString("ssoyadi"), rs.getString("sadres"), rs.getString("stutar"), rs.getString("sdurum")});
            }

            tblSiparisler.setModel(dtm);

        } catch (Exception e) {
            System.err.println("Sipariş getirme hatası: " + e);
        } finally {
            db.kapat();
        }
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
            java.util.logging.Logger.getLogger(AnaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AnaForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAra;
    private javax.swing.JButton btnDuzenle;
    private javax.swing.JButton btnSeciliSil;
    private javax.swing.JButton btnSil;
    private javax.swing.JButton btnTeslimEdildi;
    private javax.swing.JButton btnTumunuSil;
    private javax.swing.JButton btnYeniKaydet;
    private javax.swing.JButton btnYeniSiparis;
    private javax.swing.JButton btnYenile;
    private javax.swing.JButton btnYolaCikti;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblMusteriAdi;
    private javax.swing.JLabel lblMusteriSoyadi;
    private javax.swing.JTable tblMusteriler;
    private javax.swing.JTable tblSiparisler;
    private javax.swing.JTextField txtMusteriAdi;
    private javax.swing.JTextField txtMusteriSoyadi;
    // End of variables declaration//GEN-END:variables
}
