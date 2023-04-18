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
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author rsgm
 */
public class Frmpermintaan extends javax.swing.JDialog {

    /**
     * Creates new form Frmpermintaan
     *
     * @param parent
     * @param modal
     */
    rsgm.PetugasSession PetugasSession = new rsgm.PetugasSession();
    rsgm.koneksi konek = new rsgm.koneksi();

    public Frmpermintaan(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initUI();

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();

        txttgl.setText(dateFormat.format(cal.getTime()));
        txtnm_petugas.setText(PetugasSession.getU_nama());
        txtid_petugas.setText(Integer.toString(PetugasSession.getU_id()));
        txtnm_ruangan.setText(PetugasSession.getU_ruangan());

        SelectBarang();
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

    private void SelectBarang() {
        try {
            Connection conn = konek.openkoneksi();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet rs = stm.executeQuery("SELECT * FROM tb_barang");

            cmbid_barang.addItem("Pilih");
            while (rs.next()) {
                cmbid_barang.addItem(rs.getString("nm_barang"));
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
        txtid_selected.setText("");
        txtid_petugas.setVisible(false);
        txtid_barang.setVisible(false);
        txtnm_barang.setVisible(false);
        txtsatuan.setVisible(false);
        cmbid_barang.setSelectedItem("Pilih");
        cmbid_barang.requestFocus();
    }

    private void TableEmpty() {
        DefaultTableModel model = (DefaultTableModel) datatable.getModel();
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }

    private void BtnEnabled(boolean x) {
        btnDelRow.setEnabled(x);
    }

    private void GetData_View() {
        String row = Integer.toString(datatable.getSelectedRow());
        txtid_selected.setText(row);
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
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtjumlah_barang = new javax.swing.JTextField();
        btnok = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        datatable = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        btnTableEmpty = new javax.swing.JButton();
        btnDelRow = new javax.swing.JButton();
        txtid_selected = new javax.swing.JTextField();
        cmbid_barang = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtketerangan = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtstok = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txttgl = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtnm_petugas = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnsave = new javax.swing.JButton();
        txtid_petugas = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtnm_ruangan = new javax.swing.JTextField();
        txtnm_barang = new javax.swing.JTextField();
        txtid_barang = new javax.swing.JTextField();
        txtsatuan = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("RS Gading Medika :: Permintaan");

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(4, 149, 56));

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 0, 22)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Permintaan");

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

        jLabel4.setText("Pilih Barang");

        jLabel6.setText("Jumlah Diminta");

        txtjumlah_barang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtjumlah_barangKeyTyped(evt);
            }
        });

        btnok.setText("OK");
        btnok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnokActionPerformed(evt);
            }
        });

        datatable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Barang", "Nama Barang", "Stok", "Satuan", "Jumlah", "Keterangan"
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

        btnTableEmpty.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        btnTableEmpty.setText("Hapus Semua");
        btnTableEmpty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTableEmptyActionPerformed(evt);
            }
        });

        btnDelRow.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        btnDelRow.setText("Hapus Yang Terpilih");
        btnDelRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelRowActionPerformed(evt);
            }
        });

        txtid_selected.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtid_selected.setEnabled(false);

        cmbid_barang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbid_barangItemStateChanged(evt);
            }
        });
        cmbid_barang.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmbid_barangFocusLost(evt);
            }
        });
        cmbid_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbid_barangActionPerformed(evt);
            }
        });

        jLabel9.setText("Keterangan");

        txtketerangan.setText("-");

        jLabel10.setText("Stok Ruangan");

        txtstok.setText("0");
        txtstok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtstokActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(565, 565, 565)
                                .addComponent(txtid_selected, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(cmbid_barang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtjumlah_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtstok, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtketerangan, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnok, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnTableEmpty)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelRow)
                                .addGap(387, 387, 387)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(txtjumlah_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbid_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(txtstok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtketerangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnok, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTableEmpty)
                    .addComponent(btnDelRow))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtid_selected, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("Tanggal");

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
        btnsave.setText("Simpan Permintaan");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });

        jLabel7.setText("Bersihkan inputan permintaan");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        txtnm_ruangan.setEnabled(false);
        txtnm_ruangan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnm_ruanganActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel7)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnsave, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtnm_petugas, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnm_ruangan, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtid_petugas, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtnm_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(txtsatuan, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtid_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txttgl, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(txtid_petugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnm_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtid_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtsatuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtnm_ruangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsave, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(44, 44, 44)
                .addComponent(jLabel5)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnokActionPerformed
        // TODO add your handling code here:
        String data1 = txtid_barang.getText();
        String data2 = txtnm_barang.getText();
        String data3 = txtstok.getText();
        String data4 = txtsatuan.getText();
        String data5 = txtjumlah_barang.getText();
        String data6 = txtketerangan.getText();

        String[] nama_kategori = cmbid_barang.getSelectedItem().toString().split("\\s+");
        String kode = nama_kategori[0];

        Integer same_kode = 0;
        DefaultTableModel model2 = (DefaultTableModel) datatable.getModel();
        int rowCount = model2.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            if (kode.equals(datatable.getModel().getValueAt(i, 1).toString())) {
                same_kode = 1;
            }
        }

        if (!(data1.equals("")) && !(data2.equals("")) && !(data3.equals("")) && !(data4.equals("")) && !(data5.equals("")) && !(data6.equals(""))) {
            Object[] row = {data1, data2, data3, data4, data5, data6};
            DefaultTableModel model = (DefaultTableModel) datatable.getModel();
            model.addRow(row);
            txtid_barang.setText("");
            txtnm_barang.setText("");
            txtstok.setText("");
            txtsatuan.setText("");
            txtjumlah_barang.setText("");
            txtketerangan.setText("");

        } else if (same_kode != 0) {
            JOptionPane.showMessageDialog(null, "Barang sudah pernah ditambah.");
        } else {
            JOptionPane.showMessageDialog(null, "Terdapat inputan yang kosong.");
            cmbid_barang.getSelectedItem();
        }
    }//GEN-LAST:event_btnokActionPerformed

    private void cmbid_barangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbid_barangItemStateChanged
        // TODO add your handling code here:
        String[] nama_kategori = cmbid_barang.getSelectedItem().toString().split("\\s+");
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
                    java.sql.ResultSet sql = stm.executeQuery("SELECT * FROM tb_barang WHERE nm_barang='" + kode + "'");
                    if (sql.next()) {
                        txtid_barang.setText(sql.getString("id_barang"));
                        txtsatuan.setText(sql.getString("satuan"));
                        txtnm_barang.setText(sql.getString("nm_barang"));
                    }
                    konek.closekoneksi();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error " + e);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Frmpermintaan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            txtid_barang.setText("");
            txtsatuan.setText("");
            txtnm_barang.setText("");
        }
    }//GEN-LAST:event_cmbid_barangItemStateChanged

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        // TODO add your handling code here:
        String row_tgl = txttgl.getText();
        String row_idpetugas = txtid_petugas.getText();

        String id, stok, keterangan;
        Integer id_permintaan = 0, jumlah, not_found;

        DefaultTableModel model = (DefaultTableModel) datatable.getModel();
        int rowCount = model.getRowCount();

        if (rowCount > 0 && !"".equals(row_tgl) && !"".equals(row_idpetugas)) {

            //------- Memasukan pada tabel transaksi lihat [trbarang_] dan mengeluarkan id terakhir
            try {
                Connection conn = konek.openkoneksi();
                java.sql.Statement stm = conn.createStatement();
                stm.executeUpdate("INSERT INTO tb_permintaan(tanggal, id_petugas) VALUES ('" + row_tgl + "', '" + row_idpetugas + "')");
                konek.closekoneksi();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error " + e);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Frmbarang.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                Connection conn = konek.openkoneksi();
                java.sql.Statement stm = conn.createStatement();
                java.sql.ResultSet sql = stm.executeQuery("SELECT MAX(id_permintaan) as max FROM tb_permintaan");
                sql.next();
                id_permintaan = sql.getInt("max");
                konek.closekoneksi();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error " + e);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Frmbarang.class.getName()).log(Level.SEVERE, null, ex);
            }

            for (int i = 0; i < rowCount; i++) {
                not_found = 0;
                id = (datatable.getModel().getValueAt(i, 0).toString());
                stok = (datatable.getModel().getValueAt(i, 2).toString());
                keterangan = (datatable.getModel().getValueAt(i, 5).toString());
                jumlah = Integer.valueOf((String) datatable.getModel().getValueAt(i, 4));

                if (not_found == 0) {

                    //------- Memasukan pada table transaksi detail
                    try {
                        Connection conn = konek.openkoneksi();
                        java.sql.Statement stm = conn.createStatement();
                        stm.executeUpdate("INSERT INTO tb_permintaan_detail(id_barang, stok_ruangan, id_permintaan, jumlah_diminta, keterangan) VALUES ('" + id + "', '" + stok + "', '" + id_permintaan + "', '" + jumlah + "', '" + keterangan + "')");
                        konek.closekoneksi();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Error " + e);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Frmbarang.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Sistem tidak menemukan barang " + id, "Barang Gagal Disimpan", JOptionPane.ERROR_MESSAGE);
                }
            }
            JOptionPane.showMessageDialog(null, "Berhasil menyimpan data barang.");
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

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        TxtEmpty();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void btnTableEmptyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTableEmptyActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null, "Anda yakin ingin menghapus semua baris ini?", "Konfirmasi", JOptionPane.OK_CANCEL_OPTION);
        if (ok == 0) {
            TableEmpty();
        }
    }//GEN-LAST:event_btnTableEmptyActionPerformed

    private void datatableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datatableMouseClicked
        // TODO add your handling code here:
        GetData_View();
    }//GEN-LAST:event_datatableMouseClicked

    private void btnDelRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelRowActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null, "Anda yakin ingin menghapus baris ini?", "Konfirmasi", JOptionPane.OK_CANCEL_OPTION);
        if (ok == 0) {
            int row = Integer.parseInt(txtid_selected.getText());
            DefaultTableModel model = (DefaultTableModel) datatable.getModel();
            model.removeRow(row);
            BtnEnabled(false);
        }
    }//GEN-LAST:event_btnDelRowActionPerformed

    private void datatableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datatableMouseReleased
        // TODO add your handling code here:
        GetData_View();
    }//GEN-LAST:event_datatableMouseReleased

    private void datatableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_datatableKeyReleased
        // TODO add your handling code here:
        GetData_View();
    }//GEN-LAST:event_datatableKeyReleased

    private void txtjumlah_barangKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtjumlah_barangKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c)) && !(c == KeyEvent.VK_BACK_SPACE)) {
            JOptionPane.showMessageDialog(null, "Inputan hanya boleh angka", "Ilegal Input", JOptionPane.ERROR_MESSAGE);
            evt.consume();
        }
    }//GEN-LAST:event_txtjumlah_barangKeyTyped

    private void cmbid_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbid_barangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbid_barangActionPerformed

    private void txtnm_petugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnm_petugasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnm_petugasActionPerformed

    private void txtnm_ruanganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnm_ruanganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnm_ruanganActionPerformed

    private void cmbid_barangFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbid_barangFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbid_barangFocusLost

    private void txtstokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtstokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtstokActionPerformed

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
            java.util.logging.Logger.getLogger(Frmpermintaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frmpermintaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frmpermintaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frmpermintaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
            Frmpermintaan dialog = new Frmpermintaan(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnDelRow;
    private javax.swing.JButton btnTableEmpty;
    private javax.swing.JButton btnok;
    private javax.swing.JButton btnsave;
    private javax.swing.JComboBox<String> cmbid_barang;
    private javax.swing.JTable datatable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtid_barang;
    private javax.swing.JTextField txtid_petugas;
    private javax.swing.JTextField txtid_selected;
    private javax.swing.JTextField txtjumlah_barang;
    private javax.swing.JTextField txtketerangan;
    private javax.swing.JTextField txtnm_barang;
    private javax.swing.JTextField txtnm_petugas;
    private javax.swing.JTextField txtnm_ruangan;
    private javax.swing.JTextField txtsatuan;
    private javax.swing.JTextField txtstok;
    private javax.swing.JTextField txttgl;
    // End of variables declaration//GEN-END:variables
}
