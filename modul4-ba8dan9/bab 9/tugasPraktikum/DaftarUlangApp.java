package tugasPraktikum;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DaftarUlangApp extends JFrame {
    private JTextField txtNama, txtTanggalLahir, txtNoDaftar, txtNoTelp, txtEmail;
    private JTextArea txtAlamat;
    private JButton btnSubmit;

    public DaftarUlangApp() {
        // Konfigurasi Frame Utama
        setTitle("Form Daftar Ulang Mahasiswa Baru");
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Panel utama untuk latar belakang
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(238, 238, 238));
        
        // Panel form dengan border (menyerupai gambar pertama)
        JPanel formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBackground(new Color(238, 238, 238));
        formPanel.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 255), 3));
        formPanel.setBounds(20, 20, 445, 360);
        mainPanel.add(formPanel);

        String[] labels = {
            "Nama Lengkap", "Tanggal Lahir", "Nomor Pendaftaran", 
            "No. Telp", "Alamat", "E-mail"
        };
        
        int y = 20;
        int xLabel = 20;
        int xField = 170;
        int wField = 250;
        int hField = 25;

        // Komponen Nama Lengkap
        JLabel lblNama = new JLabel(labels[0]);
        lblNama.setBounds(xLabel, y, 140, hField);
        formPanel.add(lblNama);
        txtNama = new JTextField();
        txtNama.setBounds(xField, y, wField, hField);
        formPanel.add(txtNama);
        
        y += 40;
        // Komponen Tanggal Lahir
        JLabel lblTgl = new JLabel(labels[1]);
        lblTgl.setBounds(xLabel, y, 140, hField);
        formPanel.add(lblTgl);
        txtTanggalLahir = new JTextField();
        txtTanggalLahir.setBounds(xField, y, wField, hField);
        formPanel.add(txtTanggalLahir);
        
        y += 40;
        // Komponen Nomor Pendaftaran
        JLabel lblNoDaftar = new JLabel(labels[2]);
        lblNoDaftar.setBounds(xLabel, y, 140, hField);
        formPanel.add(lblNoDaftar);
        txtNoDaftar = new JTextField();
        txtNoDaftar.setBounds(xField, y, wField, hField);
        formPanel.add(txtNoDaftar);
        
        y += 40;
        // Komponen No. Telp
        JLabel lblNoTelp = new JLabel(labels[3]);
        lblNoTelp.setBounds(xLabel, y, 140, hField);
        formPanel.add(lblNoTelp);
        txtNoTelp = new JTextField();
        txtNoTelp.setBounds(xField, y, wField, hField);
        formPanel.add(txtNoTelp);
        
        y += 40;
        // Komponen Alamat
        JLabel lblAlamat = new JLabel(labels[4]);
        lblAlamat.setBounds(xLabel, y, 140, hField);
        formPanel.add(lblAlamat);
        txtAlamat = new JTextArea();
        txtAlamat.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        txtAlamat.setBounds(xField, y, wField, 60);
        formPanel.add(txtAlamat);
        
        y += 75;
        // Komponen E-mail
        JLabel lblEmail = new JLabel(labels[5]);
        lblEmail.setBounds(xLabel, y, 140, hField);
        formPanel.add(lblEmail);
        txtEmail = new JTextField();
        txtEmail.setBounds(xField, y, wField, hField);
        formPanel.add(txtEmail);
        
        y += 45;
        // Tombol Submit
        btnSubmit = new JButton("submit");
        btnSubmit.setBounds(xField + wField - 80, y, 80, 25);
        formPanel.add(btnSubmit);
        
        // Aksi ketika tombol submit ditekan
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prosesSubmit();
            }
        });
        
        add(mainPanel);
    }
    
    private void prosesSubmit() {
        // Validasi jika ada kolom yang kosong
        if (txtNama.getText().trim().isEmpty() ||
            txtTanggalLahir.getText().trim().isEmpty() ||
            txtNoDaftar.getText().trim().isEmpty() ||
            txtNoTelp.getText().trim().isEmpty() ||
            txtAlamat.getText().trim().isEmpty() ||
            txtEmail.getText().trim().isEmpty()) {
            
            // Peringatan jika belum terisi semua
            JOptionPane.showMessageDialog(this, 
                "Semua kolom harus terisi!", 
                "Peringatan", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Memunculkan panel konfirmasi
        int pilihan = JOptionPane.showConfirmDialog(this, 
            "Apakah anda yakin data yang Anda isi sudah benar?", 
            "Konfirmasi", 
            JOptionPane.OK_CANCEL_OPTION, 
            JOptionPane.QUESTION_MESSAGE);
            
        // Jika user memilih OK, maka jendela baru ditampilkan
        if (pilihan == JOptionPane.OK_OPTION) {
            tampilkanData();
        }
    }
    
    private void tampilkanData() {
        // Membuat jendela baru
        JFrame frameData = new JFrame("Data Mahasiswa Baru");
        frameData.setSize(420, 320);
        frameData.setLocationRelativeTo(this);
        frameData.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Tutup jendela ini saja
        
        // Panel utama data
        JPanel panelUtama = new JPanel(new BorderLayout(10, 10));
        panelUtama.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelUtama.setBackground(new Color(215, 225, 235));
        
        // Label Judul
        JLabel judul = new JLabel("Data Mahasiswa", SwingConstants.CENTER);
        judul.setFont(new Font("SansSerif", Font.PLAIN, 14));
        panelUtama.add(judul, BorderLayout.NORTH);
        
        // Panel isi dengan border biru seperti di gambar kedua
        JPanel panelIsi = new JPanel(new GridBagLayout());
        panelIsi.setBorder(BorderFactory.createLineBorder(new Color(100, 150, 220), 2));
        panelIsi.setBackground(Color.WHITE);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(3, 10, 3, 10);
        
        String[] labelArray = {"Nama", "Tanggal Lahir", "No.Pendaftaran", "No.Telp", "Alamat", "E-mail"};
        String[] nilaiArray = {
            txtNama.getText(), 
            txtTanggalLahir.getText(), 
            txtNoDaftar.getText(), 
            txtNoTelp.getText(), 
            txtAlamat.getText(), 
            txtEmail.getText()
        };
        
        // Menampilkan label dan value secara terstruktur menggunakan GridBagLayout
        for (int i = 0; i < labelArray.length; i++) {
            gbc.gridy = i;
            
            gbc.gridx = 0;
            panelIsi.add(new JLabel(labelArray[i]), gbc);
            
            gbc.gridx = 1;
            panelIsi.add(new JLabel(":"), gbc);
            
            gbc.gridx = 2;
            gbc.weightx = 1.0;
            panelIsi.add(new JLabel(nilaiArray[i]), gbc);
            gbc.weightx = 0.0;
        }
        
        panelUtama.add(panelIsi, BorderLayout.CENTER);
        frameData.add(panelUtama);
        frameData.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DaftarUlangApp().setVisible(true);
        });
    }
}
