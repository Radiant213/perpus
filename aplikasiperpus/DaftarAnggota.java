/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mycompany.aplikasiperpus;

import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DaftarAnggota extends javax.swing.JInternalFrame {

    /**
     * Creates new form DaftarAnggota
     */
    
    private void tampilData() {
    // Model tabel dengan kolom No, ID (disembunyikan), dan data anggota
    DefaultTableModel model = new DefaultTableModel(
        new Object[]{"No", "ID", "Nama", "Kelas", "Alamat", "No Telp"}, 0
    ) {
        @Override
        public boolean isCellEditable(int row, int column) {
            // kolom 0 (No) dan 1 (ID) tidak bisa diedit
            return column != 0 && column != 1;
        }
    };

    try (Connection conn = Koneksi.getConnection();
         Statement st = conn.createStatement();
         ResultSet rs = st.executeQuery("SELECT * FROM anggota")) {

        int no = 1;
        while (rs.next()) {
            model.addRow(new Object[]{
                no++, // nomor urut tampil di kolom pertama
                rs.getInt("id_anggota"), // ID tetap disimpan tapi disembunyikan
                rs.getString("nama"),
                rs.getString("kelas"),
                rs.getString("alamat"),
                rs.getString("no_telp")
            });
        }

        PanelAnggota.setModel(model);

        // Sembunyikan kolom ID biar gak keliatan di tabel
        if (PanelAnggota.getColumnModel().getColumnCount() > 1) {
            PanelAnggota.getColumnModel().getColumn(1).setMinWidth(0);
            PanelAnggota.getColumnModel().getColumn(1).setMaxWidth(0);
            PanelAnggota.getColumnModel().getColumn(1).setPreferredWidth(0);
        }

        // Kolom No biar kecil dikit
        PanelAnggota.getColumnModel().getColumn(0).setPreferredWidth(40);

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Gagal menampilkan data: " + e.getMessage());
    }
}

    public DaftarAnggota() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        PanelAnggota = new javax.swing.JTable();
        btnHapus = new javax.swing.JButton();
        btnTambahAnggota = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(810, 580));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Daftar Anggota");

        PanelAnggota.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(PanelAnggota);

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnTambahAnggota.setText("Tambah Anggota");
        btnTambahAnggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahAnggotaActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(4, 4, 4)
                            .addComponent(btnTambahAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(141, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTambahAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        tampilData();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnTambahAnggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahAnggotaActionPerformed
        // TODO add your handling code here:
        String nama = JOptionPane.showInputDialog("Masukkan Nama:");
        String kelas = JOptionPane.showInputDialog("Masukkan Kelas:");
        String alamat = JOptionPane.showInputDialog("Masukkan Alamat:");
        String noTelp = JOptionPane.showInputDialog("Masukkan No Telp:");

        try {
            Connection conn = Koneksi.getConnection();
            String sql = "INSERT INTO anggota (nama, kelas, alamat, no_telp) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, nama);
            pst.setString(2, kelas);
            pst.setString(3, alamat);
            pst.setString(4, noTelp);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan!");
            tampilData();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal menambah data: " + e.getMessage());
        }
    }//GEN-LAST:event_btnTambahAnggotaActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        int viewRow = PanelAnggota.getSelectedRow();
        if (viewRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin diedit dulu!");
            return;
        }

        // kalau nanti ada sorter/filter, convert ke model row
        int modelRow = PanelAnggota.convertRowIndexToModel(viewRow);
        javax.swing.table.TableModel model = PanelAnggota.getModel();

        // ambil data dari model
        int id = (int) model.getValueAt(modelRow, 1); // kolom 1 = ID anggota
        String nama = (String) model.getValueAt(modelRow, 2);
        String kelas = (String) model.getValueAt(modelRow, 3);
        String alamat = (String) model.getValueAt(modelRow, 4);
        String noTelp = (String) model.getValueAt(modelRow, 5);

        // dialog edit
        String newNama = JOptionPane.showInputDialog(this, "Nama baru:", nama);
        String newKelas = JOptionPane.showInputDialog(this, "Kelas baru:", kelas);
        String newAlamat = JOptionPane.showInputDialog(this, "Alamat baru:", alamat);
        String newNoTelp = JOptionPane.showInputDialog(this, "No Telp baru:", noTelp);

        // kalau batal di salah satu input, cancel semua
        if (newNama == null || newKelas == null || newAlamat == null || newNoTelp == null) {
            return;
        }

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement pst = conn.prepareStatement(
                 "UPDATE anggota SET nama=?, kelas=?, alamat=?, no_telp=? WHERE id_anggota=?")) {

            pst.setString(1, newNama);
            pst.setString(2, newKelas);
            pst.setString(3, newAlamat);
            pst.setString(4, newNoTelp);
            pst.setInt(5, id);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "Data berhasil diperbarui!");
            tampilData(); // refresh tabel
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal mengedit data: " + e.getMessage());
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        int viewRow = PanelAnggota.getSelectedRow();
        if (viewRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin dihapus dulu!");
            return;
        }

        int modelRow = PanelAnggota.convertRowIndexToModel(viewRow);
        javax.swing.table.TableModel model = PanelAnggota.getModel();
        int id = (int) model.getValueAt(modelRow, 1); // kolom 1 = ID anggota

        int confirm = JOptionPane.showConfirmDialog(this, "Yakin mau hapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try (Connection conn = Koneksi.getConnection();
                 PreparedStatement pst = conn.prepareStatement("DELETE FROM anggota WHERE id_anggota=?")) {

                pst.setInt(1, id);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");
                tampilData(); // refresh tabel
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Gagal menghapus data: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnHapusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable PanelAnggota;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnTambahAnggota;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
