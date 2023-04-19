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
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author rsgm
 */
public class Frmpersetujuan extends javax.swing.JDialog {

    /**
     * Creates new form Frmpersetujuan
     *
     * @param parent
     * @param modal
     */
    rsgm.koneksi konek = new rsgm.koneksi();

    public Frmpersetujuan(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initUI();

//        GetData();
        BtnEnabled(false);
        SelectPermintaan();
        btnsave.setText("Simpan");
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
        txtid.setText("");
        txtnama.setText("");
        txtsatuan.setText("");
        txtharga.setText("");
        txtstok.setText("");
    }

    private void BtnEnabled(boolean x) {
        btnedit.setEnabled(x);
    }

    private void GetData() {
        try {
            Connection conn = konek.openkoneksi();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet sql = stm.executeQuery("SELECT tb_barang.id_barang, tb_barang.nm_barang, tb_barang.satuan, tb_barang.harga, tb_barang.stok_gudang FROM tb_barang");

            datatable.setModel(DbUtils.resultSetToTableModel(sql));

            JTableHeader th = datatable.getTableHeader();
            TableColumnModel tcm = th.getColumnModel();
            TableColumn tc;

            tc = tcm.getColumn(0);
            tc.setHeaderValue("ID");
            tc.setPreferredWidth(7);

            tc = tcm.getColumn(1);
            tc.setHeaderValue("Nama Barang");
            tc.setPreferredWidth(90);

            tc = tcm.getColumn(2);
            tc.setHeaderValue("Satuan");
            tc.setPreferredWidth(20);

            tc = tcm.getColumn(3);
            tc.setHeaderValue("Harga");
            tc.setPreferredWidth(60);

            tc = tcm.getColumn(4);
            tc.setHeaderValue("Stok Barang");
            th.repaint();

            //sql.last();
            String count_rows = String.valueOf(datatable.getRowCount());
            lblcount_rows.setText("Jumlah Data : " + count_rows);
            konek.closekoneksi();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Frmpersetujuan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void GetData_View() {
//        int baris = datatable.getRowCount();
//        for (int a = 0; a < baris; a++) {
//            String nomor = String.valueOf(a + 1);
//            datatable.setValueAt(nomor, a, 0);
//        }

        int row = datatable.getSelectedRow();
//        String row_id = (datatable.getModel().getValueAt(row, 0).toString());
        for (int a = 0; a < row; a++) {
            String row_id = String.valueOf(a + 1);
            datatable.setValueAt(row_id, a, 0);
            txtid.setText(row_id);
            BtnEnabled(true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnedit = new javax.swing.JButton();
        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnsave = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtnama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtsatuan = new javax.swing.JTextField();
        btncancel = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtstok = new javax.swing.JTextField();
        txtharga = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        datatable = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtid = new javax.swing.JTextPane();
        lbl_action = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lblcount_rows = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        cmbid_permintaan = new javax.swing.JComboBox<>();
        btnok = new javax.swing.JButton();
        txtid_permintaan = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("RS GADING MEDIKA  :: Data Barang");

        btnedit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rsgm/img/edit.png"))); // NOI18N
        btnedit.setText("Persetujuan");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });

        panel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        panel.setForeground(new java.awt.Color(245, 245, 245));
        panel.setEnabled(false);

        jLabel1.setLabelFor(txtnama);
        jLabel1.setText("Nama Barang");

        btnsave.setText("Simpan");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });

        jLabel2.setLabelFor(txtsatuan);
        jLabel2.setText("Satuan");

        txtnama.setEnabled(false);
        txtnama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamaActionPerformed(evt);
            }
        });

        jLabel4.setLabelFor(txtharga);
        jLabel4.setText("Harga");

        txtsatuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsatuanActionPerformed(evt);
            }
        });
        txtsatuan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtsatuanKeyTyped(evt);
            }
        });

        btncancel.setText("Batal");
        btncancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelActionPerformed(evt);
            }
        });

        jLabel3.setText("Stok Gudang");

        txtstok.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtstokKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3))
                        .addGap(30, 30, 30)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtharga, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtsatuan)
                            .addComponent(txtnama, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtstok))
                        .addGap(14, 14, 14))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(0, 105, Short.MAX_VALUE)
                        .addComponent(btncancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnsave, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtsatuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtharga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtstok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(37, 37, 37)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsave)
                    .addComponent(btncancel))
                .addGap(502, 502, 502))
        );

        datatable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nama Barang", "Satuan", "Harga", "Stok Gudang"
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
            public void keyPressed(java.awt.event.KeyEvent evt) {
                datatableKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                datatableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(datatable);

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N

        txtid.setBorder(null);
        txtid.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtid.setForeground(new java.awt.Color(43, 152, 240));
        txtid.setToolTipText("");
        txtid.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtid.setEnabled(false);
        txtid.setFocusable(false);
        jScrollPane2.setViewportView(txtid);

        lbl_action.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lbl_action.setText("Data Persetujuan");

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel7.setLabelFor(txtid);
        jLabel7.setText("Terpilih : ");

        jPanel1.setBackground(new java.awt.Color(4, 149, 56));

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 0, 22)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Persetujuan Barang");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblcount_rows.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        lblcount_rows.setText("Jumlah Data ");

        jButton1.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rsgm/img/reload.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbid_permintaan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnok)
                        .addGap(12, 12, 12)
                        .addComponent(btnedit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblcount_rows, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_action)
                    .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtid_permintaan, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnedit)
                        .addComponent(cmbid_permintaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnok))
                    .addComponent(txtid_permintaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_action)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(245, 245, 245)
                                .addComponent(jLabel5))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblcount_rows)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        // TODO add your handling code here:
        String row_id = txtid.getText();
        int c_kode = 0;

        if (!"0".equals(row_id)) {

            if (c_kode == 0 || row_id.equals(row_id)) {
                try {
                    Connection conn = konek.openkoneksi();
                    java.sql.Statement stm = conn.createStatement();
                    java.sql.ResultSet sql = stm.executeQuery("SELECT tb_barang.id_barang, tb_barang.nm_barang, tb_barang.satuan, tb_barang.harga, tb_barang.stok_gudang FROM tb_barang");
                    if (sql.next()) {
                        lbl_action.setForeground(new Color(4, 149, 56));
                        lbl_action.setText("Data Persetujuan");
                        txtid.setText(sql.getString("id_barang"));
                        txtnama.setText(sql.getString("nm_barang"));
                        txtsatuan.setText(sql.getString("satuan"));
                        txtharga.setText(sql.getString("harga"));
                        txtstok.setText(sql.getString("stok_gudang"));
                    }
                    konek.closekoneksi();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error " + e);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Frmpersetujuan.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Terdapat kesalahan id null!", "Gagal Disimpan", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btneditActionPerformed

    private void txtnamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnamaActionPerformed

    private void txtsatuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsatuanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsatuanActionPerformed

    private void datatableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datatableMouseClicked
        // TODO add your handling code here:
        GetData_View();
    }//GEN-LAST:event_datatableMouseClicked

    private void datatableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_datatableKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_datatableKeyPressed

    private void datatableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_datatableKeyReleased
        // TODO add your handling code here:
        GetData_View();
    }//GEN-LAST:event_datatableKeyReleased

    private void datatableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datatableMouseReleased
        // TODO add your handling code here:
        GetData_View();
    }//GEN-LAST:event_datatableMouseReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        GetData();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtsatuanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsatuanKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsatuanKeyTyped

    private void txtstokKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtstokKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c)) && !(c == KeyEvent.VK_BACK_SPACE)) {
            JOptionPane.showMessageDialog(null, "Inputan tidak boleh menganduk spasi", "Ilegal Input", JOptionPane.ERROR_MESSAGE);
            evt.consume();
        }
    }//GEN-LAST:event_txtstokKeyTyped

    private void cmbid_permintaanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbid_permintaanItemStateChanged
        String[] nama_kategori = cmbid_permintaan.getSelectedItem().toString().split("\\s+");
        String kode = nama_kategori[0];
        if (!kode.equals("Pilih")) {

//            //--------- Cek In jtable
//            Integer same_kode = 0;
//            DefaultTableModel model = (DefaultTableModel) datatable.getModel();
//            int rowCount = model.getRowCount();
//            for (int i = 0; i < rowCount; i++) {
//                if (kode.equals(datatable.getModel().getValueAt(i, 1).toString())) {
//                    same_kode = 1;
//                }
//            }
//            if (same_kode == 0) {
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
//        }
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
        tabel.addColumn("No Barang");
        tabel.addColumn("Nama Barang");
        tabel.addColumn("Jumlah Barang");
        tabel.addColumn("Terbilang");
        tabel.addColumn("Keterangan");
        tabel.addColumn("Keterangan");
        tabel.addColumn("Keterangan");
        tabel.addColumn("Keterangan");

//        Connection conn = konek.openkoneksi();
//            java.sql.Statement stm = conn.createStatement();
//            java.sql.ResultSet sql = stm.executeQuery("SELECT tb_permintaan_detail.stok_ruangan, tb_barang.nm_barang as nama, tb_permintaan_detail.jumlah_diminta,tb_permintaan_detail.jumlah_disetujui, tb_permintaan_detail.keterangan, tb_permintaan_detail.p_manager, tb_permintaan_detail.p_direktur, tb_permintaan_detail.p_spi WHERE id_permintaan='" + kode + "'");
//
        //menampilkan data database kedalam tabel
        try {
            Connection conn = konek.openkoneksi();
//            String sql = "SELECT tb_permintaan.id_permintaan, tb_permintaan.tanggal, tb_petugas.nama as nama FROM tb_permintaan JOIN tb_petugas ON tb_petugas.id = tb_permintaan.id_petugas";
            String sql = "SELECT tb_permintaan_detail.stok_ruangan, tb_barang.nm_barang as nama, tb_permintaan_detail.jumlah_diminta,tb_permintaan_detail.jumlah_disetujui, tb_permintaan_detail.keterangan, tb_permintaan_detail.p_manager, tb_permintaan_detail.p_direktur, tb_permintaan_detail.p_spi FROM tb_permintaan_detail JOIN tb_barang ON tb_barang.id_barang = tb_permintaan_detail.id_barang WHERE tb_permintaan_detail.id_permintaan='" + kode + "'";
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                tabel.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3), res.getString(4),
                    res.getString(5),
                    res.getString(6),
                    res.getString(7),
                    res.getString(8)});
            }
            datatable.setModel(tabel);
            String count_rows = String.valueOf(datatable.getRowCount());
            lblcount_rows.setText("Jumlah Data : " + count_rows);
            konek.closekoneksi();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Frmpersetujuan.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnokActionPerformed

    private void btncancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelActionPerformed
        // TODO add your handling code here:
        //        btnadd.doClick();
    }//GEN-LAST:event_btncancelActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        // TODO add your handling code here:

        String row_id = txtid.getText();
        int c_kode = 0;

        if (!"0".equals(row_id)) {

            if (c_kode == 0 || row_id.equals(row_id)) {
                try {
                    Connection conn = konek.openkoneksi();
                    java.sql.Statement stm = conn.createStatement();
                    java.sql.ResultSet sql = stm.executeQuery("SELECT tb_barang.id_barang, tb_barang.nm_barang, tb_barang.satuan, tb_barang.harga, tb_barang.stok_gudang FROM tb_barang");
                    if (sql.next()) {
                        lbl_action.setForeground(new Color(4, 149, 56));
                        lbl_action.setText("Data Persetujuan");
                        txtid.setText(sql.getString("id_barang"));
                        txtnama.setText(sql.getString("nm_barang"));
                        txtsatuan.setText(sql.getString("satuan"));
                        txtharga.setText(sql.getString("harga"));
                        txtstok.setText(sql.getString("stok_gudang"));
                    }
                    konek.closekoneksi();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error " + e);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Frmpersetujuan.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Terdapat kesalahan id null!", "Gagal Disimpan", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnsaveActionPerformed

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
            java.util.logging.Logger.getLogger(Frmpersetujuan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frmpersetujuan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frmpersetujuan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frmpersetujuan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
            Frmpersetujuan dialog = new Frmpersetujuan(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btncancel;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnok;
    private javax.swing.JButton btnsave;
    private javax.swing.JComboBox<String> cmbid_permintaan;
    private javax.swing.JTable datatable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_action;
    private javax.swing.JLabel lblcount_rows;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField txtharga;
    private javax.swing.JTextPane txtid;
    private javax.swing.JTextField txtid_permintaan;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtsatuan;
    private javax.swing.JTextField txtstok;
    // End of variables declaration//GEN-END:variables

}
