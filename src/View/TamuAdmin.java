/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.TamuController;
import Model.TamuModel;

import javax.swing.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
/**
 *
 * @author Acer
 */
public class TamuAdmin extends javax.swing.JFrame {
    

     private TamuController tamuController;
    /**
     * Creates new form User
     */
    public TamuAdmin() {
        initComponents();
        tamuController = new TamuController();
        showAllTamu();
        
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTamu = new javax.swing.JTable();
        btnTambah = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnKembali = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Data Tamu");

        tblTamu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblTamu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTamuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTamu);

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnKembali.setText("Kembali");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnKembali)
                        .addGap(227, 227, 227)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(btnTambah)
                        .addGap(18, 18, 18)
                        .addComponent(btnEdit)
                        .addGap(18, 18, 18)
                        .addComponent(btnHapus))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 762, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnKembali))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah)
                    .addComponent(btnEdit)
                    .addComponent(btnHapus))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        String nama = JOptionPane.showInputDialog(this, "Masukkan Nama:");
        String alamat = JOptionPane.showInputDialog(this, "Masukkan Alamat:");
        String jenisKelamin = JOptionPane.showInputDialog(this, "Masukkan Jenis Kelamin:");
        String kartuKredit = JOptionPane.showInputDialog(this, "Masukkan Kartu Kredit:");
        String nomorTelepon = JOptionPane.showInputDialog(this, "Masukkan Nomor Telepon:");
        
         // Membuat objek TamuModel
        TamuModel tamu = new TamuModel(0, nama, alamat, jenisKelamin, kartuKredit, nomorTelepon);

        // Menambahkan tamu ke dalam database melalui TamuController
        tamuController.addUser(tamu);

        // Menampilkan ulang semua Tamu setelah penambahan
        showAllTamu();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblTamu.getSelectedRow();
    if (selectedRow >= 0) {
        int tamuId = (int) tblTamu.getValueAt(selectedRow, 0);
        
        // Mendapatkan data tamu yang dipilih
        String nama = JOptionPane.showInputDialog(this, "Masukkan Nama:");
        String alamat = JOptionPane.showInputDialog(this, "Masukkan Alamat:");
        String jenisKelamin = JOptionPane.showInputDialog(this, "Masukkan Jenis Kelamin:");
        String kartuKredit = JOptionPane.showInputDialog(this, "Masukkan Kartu Kredit:");
        String nomorTelepon = JOptionPane.showInputDialog(this, "Masukkan Nomor Telepon:");
        
        // Membuat objek TamuModel dengan data yang diperbarui
        TamuModel tamu = new TamuModel(tamuId, nama, alamat, jenisKelamin, kartuKredit, nomorTelepon);

        // Memperbarui tamu dalam database melalui TamuController
        tamuController.updateUser(tamu);

        // Menampilkan ulang semua Tamu setelah perubahan
        showAllTamu();
    } else {
        JOptionPane.showMessageDialog(this, "Pilih salah satu tamu untuk diedit.");
    }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblTamu.getSelectedRow();
        if (selectedRow >= 0) {
            int tamuId = (int) tblTamu.getValueAt(selectedRow, 0);
            tamuController.deleteUser(tamuId);
            showAllTamu();
        } else {
            JOptionPane.showMessageDialog(this, "Pilih salah satu tamu untuk dihapus.");
        }
        
        
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        // TODO add your handling code here:
          MainMenu mnu = new MainMenu ();
        TamuAdmin ad = new TamuAdmin ();
        ad.setVisible(false);
        mnu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void tblTamuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTamuMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tblTamuMouseClicked
    private void showAllTamu() {
        // Mengambil semua Tamu dari database melalui TamuController
        List<TamuModel> tamuList = tamuController.getAllUsers();

        // Membuat array dua dimensi untuk menampung data Tamu
        Object[][] data = new Object[tamuList.size()][6];

        // Mengisi array dua dimensi dengan data Tamu
        for (int i = 0; i < tamuList.size(); i++) {
            TamuModel tamu = tamuList.get(i);
            data[i][0] = tamu.getId();
            data[i][1] = tamu.getNama();
            data[i][2] = tamu.getAlamat();
            data[i][3] = tamu.getJenisKelamin();
            data[i][4] = tamu.getKartuKredit();
            data[i][5] = tamu.getNomorTelepon();
        }

        // Membuat model tabel
        javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(
                data,
                new String[]{"ID", "Nama", "Alamat", "Jenis Kelamin", "Kartu Kredit", "Nomor Telepon"}
        );

        // Menampilkan model tabel pada JTable
        tblTamu.setModel(model);
    }
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
            java.util.logging.Logger.getLogger(TamuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TamuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TamuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TamuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TamuAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnTambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTamu;
    // End of variables declaration//GEN-END:variables
}
