/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsgm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rsgm
 */
public class Frmspb extends javax.swing.JDialog {

    /**
     * Creates new form Frmspb
     *
     * @param parent
     * @param modal
     */
    rsgm.PetugasSession PetugasSession = new rsgm.PetugasSession();
    rsgm.koneksi konek = new rsgm.koneksi();

    public Frmspb(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initUI();

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();

        txttgl.setText(dateFormat.format(cal.getTime()));
        txtnm_petugas.setText(PetugasSession.getU_nama());
        txtid_petugas.setText(Integer.toString(PetugasSession.getU_id()));
        txtnm_ruangan.setText(PetugasSession.getU_ruangan());

        SelectPermintaan();
        TxtEmpty();
        TableEmpty();
    }

    private void initUI() {
        getContentPane().setBackground(new Color(245, 245, 245));

        Dimension windowSize = getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();
        int dx = centerPoint.x - windowSize.width / 2;
        int dy = centerPoint.y - windowSize.height / 2;
        setLocation(dx, dy);
    }

    private void SelectPermintaan() {
        try {
            Connection conn = konek.openkoneksi();
            java.sql.Statement stm = conn.createStatement();

            java.sql.ResultSet rs = stm.executeQuery("SELECT tb_permintaan.id_permintaan, tb_permintaan.tanggal, tb_petugas.nama as nama FROM tb_permintaan JOIN tb_petugas ON tb_petugas.id = tb_permintaan.id_petugas");

            cmbid_permintaan.addItem("Pilih");
            while (rs.next()) {
                cmbid_permintaan.addItem(rs.getString("id_permintaan") + " [" + rs.getString("tanggal") + "] " + rs.getString("nama"));
            }
            konek.closekoneksi();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Frmbarang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void TxtEmpty() {
        TableEmpty();
        BtnEnabled(false);
        txtid_petugas.setVisible(false);
        txtid_permintaan.setVisible(false);
        cmbid_permintaan.setSelectedItem("Pilih");
        cmbid_permintaan.requestFocus();
    }

    private void TableEmpty() {
        DefaultTableModel model = (DefaultTableModel) datatable.getModel();
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }

    private void BtnEnabled(boolean x) {
    }

    private void GetData_View() {
        String row = Integer.toString(datatable.getSelectedRow());
        BtnEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        datatable = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        jLabel1 = new javax.swing.JLabel();
        txttgl = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtnm_petugas = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnsave = new javax.swing.JButton();
        txtid_petugas = new javax.swing.JTextField();
        txtnm_ruangan = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cmbid_permintaan = new javax.swing.JComboBox<>();
        btnok = new javax.swing.JButton();
        txtid_permintaan = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("RS Gading Medika :: SPB");

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(4, 149, 56));

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 0, 22)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("SPB");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel3.setForeground(new java.awt.Color(245, 245, 245));

        datatable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Permintaan", "Nama Barang", "Stok", "Satuan", "Jumlah Barang", "Estimasi Harga", "Jumlah", "Keterangan"
            }
        ));
        datatable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        datatable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                datatableMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                datatableMouseReleased(evt);
            }
        });
        datatable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                datatableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(datatable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setText("Tanggal SPB");

        txttgl.setEnabled(false);

        jLabel2.setText("Nama Petugas");

        txtnm_petugas.setEnabled(false);
        txtnm_petugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnm_petugasActionPerformed(evt);
            }
        });

        jLabel3.setText("Ruangan");

        btnsave.setBackground(new java.awt.Color(4, 149, 56));
        btnsave.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        btnsave.setForeground(new java.awt.Color(255, 255, 255));
        btnsave.setText("Simpan SPB");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });

        txtnm_ruangan.setEnabled(false);
        txtnm_ruangan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnm_ruanganActionPerformed(evt);
            }
        });

        jLabel11.setText("Permintaan");

        jLabel12.setText("Total = Rp. ");

        cmbid_permintaan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbid_permintaanItemStateChanged(evt);
            }
        });
        cmbid_permintaan.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmbid_permintaanFocusLost(evt);
            }
        });
        cmbid_permintaan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbid_permintaanActionPerformed(evt);
            }
        });

        btnok.setText("Tampilkan Permintaan");
        btnok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnokActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnsave, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel11))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtnm_petugas, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtnm_ruangan, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtid_petugas, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtid_permintaan, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txttgl, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(cmbid_permintaan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(btnok)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txttgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtnm_petugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtid_petugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtnm_ruangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtid_permintaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cmbid_permintaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnok))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(jLabel4))
                    .addComponent(btnsave, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        // TODO add your handling code here:
        String row_tgl = txttgl.getText();
        String row_idpetugas = txtid_petugas.getText();
        String row_total = jLabel4.getText();

//        int sum = 0;
//            for (int i = 0; i < datatable.getRowCount(); i++) {
//                sum = sum + Integer.parseInt(datatable.getValueAt(i, 6).toString());
//            }
//            Integer.toString(sum);
        String id, id_barang;
        Integer id_spb = 0, jumlah, not_found;

        DefaultTableModel model = (DefaultTableModel) datatable.getModel();
        int rowCount = model.getRowCount();

        if (rowCount > 0 && !"".equals(row_tgl) && !"".equals(row_idpetugas)) {

            //------- Memasukan pada tabel spb lihat [tb_spb] dan mengeluarkan id terakhir
            try {
                Connection conn = konek.openkoneksi();
                java.sql.Statement stm = conn.createStatement();
                stm.executeUpdate("INSERT INTO tb_spb(tanggal, id_petugas, total) VALUES ('" + row_tgl + "', '" + row_idpetugas + "', '" + row_total + "')");

                konek.closekoneksi();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error " + e);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Frmbarang.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                Connection conn = konek.openkoneksi();
                java.sql.Statement stm = conn.createStatement();
                java.sql.ResultSet sql = stm.executeQuery("SELECT MAX(id_spb) as max FROM tb_spb");
                sql.next();
                id_spb = sql.getInt("max");
                konek.closekoneksi();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error " + e);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Frmbarang.class.getName()).log(Level.SEVERE, null, ex);
            }

            for (int i = 0; i < rowCount; i++) {
                not_found = 0;
                id = (datatable.getModel().getValueAt(i, 0).toString());
                id_barang = (datatable.getModel().getValueAt(i, 10).toString());
                jumlah = Integer.valueOf((String) datatable.getModel().getValueAt(i, 6));

                if (not_found == 0) {

                    //------- Memasukan pada table spb detail
                    try {
                        Connection conn = konek.openkoneksi();
                        java.sql.Statement stm = conn.createStatement();
                        stm.executeUpdate("INSERT INTO tb_spb_detail(id_permintaan_detail, id_barang, id_spb, jumlah_harga) VALUES ('" + id + "', '" + id_barang + "', '" + id_spb + "', '" + jumlah + "')");
                        konek.closekoneksi();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Error " + e);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Frmbarang.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Sistem tidak menemukan permintaan " + id, "SPB Gagal Disimpan", JOptionPane.ERROR_MESSAGE);
                }
            }
            JOptionPane.showMessageDialog(null, "Berhasil menyimpan SPB.");
            TableEmpty();

//            try {
//                HashMap hash = new HashMap();
//                hash.put("nm_supplier", cmbid_barang.getSelectedItem().toString());
//                hash.put("id", id_barang_masuk);
//
//                File file = new File("src/report/report_transaksiMasuk.jrxml");
//                JasperDesign jasperDesign = JRXmlLoader.load(file);
//                JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
//                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hash, konek.openkoneksi());
//                JasperViewer.viewReport(jasperPrint, false);
//            } catch (ClassNotFoundException | JRException e) {
//                JOptionPane.showMessageDialog(null, "Error " + e);
//            }
//            this.hide();
        } else {
            JOptionPane.showMessageDialog(null, "Terdapat inputan yang kosong.");
        }
    }//GEN-LAST:event_btnsaveActionPerformed

    private void datatableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datatableMouseClicked
        // TODO add your handling code here:
        GetData_View();
    }//GEN-LAST:event_datatableMouseClicked

    private void datatableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datatableMouseReleased
        // TODO add your handling code here:
        GetData_View();
    }//GEN-LAST:event_datatableMouseReleased

    private void datatableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_datatableKeyReleased
        // TODO add your handling code here:
        GetData_View();
    }//GEN-LAST:event_datatableKeyReleased

    private void txtnm_petugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnm_petugasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnm_petugasActionPerformed

    private void txtnm_ruanganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnm_ruanganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnm_ruanganActionPerformed

    private void cmbid_permintaanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbid_permintaanItemStateChanged
        // TODO add your handling code here:
        String[] nama_kategori = cmbid_permintaan.getSelectedItem().toString().split("\\s+");
        String kode = nama_kategori[0];
        if (!kode.equals("Pilih")) {

            //--------- Cek In jtable
            Integer same_kode = 0;
            DefaultTableModel model = (DefaultTableModel) datatable.getModel();
            int rowCount = model.getRowCount();
            for (int i = 0; i < rowCount; i++) {
                if (kode.equals(datatable.getModel().getValueAt(i, 1).toString())) {
                    same_kode = 1;
                }
            }
            if (same_kode == 0) {

                try {
                    Connection conn = konek.openkoneksi();
                    java.sql.Statement stm = conn.createStatement();
                    java.sql.ResultSet sql = stm.executeQuery("SELECT * FROM tb_permintaan WHERE id_permintaan='" + kode + "'");
                    if (sql.next()) {
                        txtid_permintaan.setText(sql.getString("id_permintaan"));
                    }
                    konek.closekoneksi();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error " + e);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Frmpermintaan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_cmbid_permintaanItemStateChanged

    private void cmbid_permintaanFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbid_permintaanFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbid_permintaanFocusLost

    private void cmbid_permintaanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbid_permintaanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbid_permintaanActionPerformed

    private void btnokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnokActionPerformed
        // TODO add your handling code here:
        String[] nama_kategori = cmbid_permintaan.getSelectedItem().toString().split("\\s+");
        String kode = nama_kategori[0];

        DefaultTableModel tabel = new DefaultTableModel();
        tabel.addColumn("ID Permintaan");
        tabel.addColumn("Nama Barang");
        tabel.addColumn("Stok");
        tabel.addColumn("Satuan");
        tabel.addColumn("Jumlah Barang");
        tabel.addColumn("Estimasi Harga");
        tabel.addColumn("Jumlah");
        tabel.addColumn("Keterangan");
        tabel.addColumn("Manager");
        tabel.addColumn("Direktur");
        tabel.addColumn("");

        //menampilkan data database kedalam tabel
        try {
            Connection conn = konek.openkoneksi();
            String sql = "SELECT tb_permintaan_detail.id_permintaan_detail, tb_barang.nm_barang as nama, tb_barang.stok_gudang as stok, tb_barang.satuan as satuan,tb_permintaan_detail.jumlah_disetujui, tb_barang.harga as harga, (tb_permintaan_detail.jumlah_disetujui*tb_barang.harga) as total, tb_permintaan_detail.keterangan, tb_permintaan_detail.p_manager, tb_permintaan_detail.p_direktur, tb_permintaan_detail.id_barang FROM tb_permintaan_detail JOIN tb_barang ON tb_barang.id_barang = tb_permintaan_detail.id_barang WHERE tb_permintaan_detail.id_permintaan='" + kode + "' AND tb_permintaan_detail.p_manager='" + "Setuju" + "' AND tb_permintaan_detail.p_direktur='" + "Setuju" + "'";
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                tabel.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3), res.getString(4),
                    res.getString(5),
                    res.getString(6),
                    res.getString(7),
                    res.getString(8),
                    res.getString(9),
                    res.getString(10),
                    res.getString(11)});
            }
            datatable.setModel(tabel);
            int sum = 0;
            for (int i = 0; i < datatable.getRowCount(); i++) {
                sum = sum + Integer.parseInt(datatable.getValueAt(i, 6).toString());
            }
            jLabel4.setText(Integer.toString(sum));
            konek.closekoneksi();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmpersetujuanPermintaan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnokActionPerformed

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
            java.util.logging.Logger.getLogger(Frmspb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frmspb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frmspb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frmspb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            Frmspb dialog = new Frmspb(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnok;
    private javax.swing.JButton btnsave;
    private javax.swing.JComboBox<String> cmbid_permintaan;
    private javax.swing.JTable datatable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtid_permintaan;
    private javax.swing.JTextField txtid_petugas;
    private javax.swing.JTextField txtnm_petugas;
    private javax.swing.JTextField txtnm_ruangan;
    private javax.swing.JTextField txttgl;
    // End of variables declaration//GEN-END:variables
}
