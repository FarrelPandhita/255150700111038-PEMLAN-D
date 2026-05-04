import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;

public class gui extends JFrame {
    JMenuBar mb = new JMenuBar();
    JMenu file = new JMenu("File");
    JMenu edit = new JMenu("Edit");
    JMenu help = new JMenu("Help");
    
    JMenuItem open = new JMenuItem("Open");
    JMenuItem close = new JMenuItem("Close");
    JMenuItem quit = new JMenuItem("Quit");
    JMenuItem about = new JMenuItem("About");
    JMenuItem copy = new JMenuItem("Copy");
    JMenuItem paste = new JMenuItem("Paste");
    JMenuItem cut = new JMenuItem("Cut");
    
    JLabel lblnama = new JLabel("Nama");
    JTextField txnama = new JTextField(30);
    JLabel lblnim = new JLabel("NIM");
    JTextField txnim = new JTextField(7);
    JLabel lblkelamin = new JLabel("Jenis Kelamin");
    String[] pilihanKelamin = {"Belum dipilih", "Pria", "Wanita"};
    JComboBox<String> cbKelamin = new JComboBox<>(pilihanKelamin);
    
    JLabel lblhobi = new JLabel("Hobi");
    JRadioButton baca = new JRadioButton("shoping"); // Sesuai teks di gambar
    JRadioButton mancing = new JRadioButton("Futsal");
    JRadioButton jalan = new JRadioButton("musik");
    ButtonGroup grupHobi = new ButtonGroup();
    
    JLabel label1 = new JLabel("Nilai UTS");
    JTextField tx1 = new JTextField(20);
    JLabel label2 = new JLabel("Nilai UAS");
    JTextField tx2 = new JTextField(20);
    JLabel label3 = new JLabel("Rata-Rata");
    JTextField tx3 = new JTextField(20);
    
    JButton cetak = new JButton("Cetak");
    JTextArea hasil = new JTextArea();

    gui() {
        setTitle("DATA MAHASISWA");
        setLocation(300, 100);
        setSize(300, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void KomponenVisual() {
        setJMenuBar(mb);
        mb.add(file);
        mb.add(edit);
        mb.add(help);
        
        file.add(open);
        file.add(close);
        edit.add(copy);
        edit.add(paste);
        edit.add(cut);
        
        close.setEnabled(false);
        file.add(quit);
        help.add(about);
        
        getContentPane().setLayout(null);
        
        getContentPane().add(lblnama);
        lblnama.setBounds(10, 10, 80, 20);
        getContentPane().add(txnama);
        txnama.setBounds(105, 10, 175, 20);
        
        getContentPane().add(lblnim);
        lblnim.setBounds(10, 33, 80, 20);
        getContentPane().add(txnim);
        txnim.setBounds(105, 33, 70, 20);
        
        getContentPane().add(lblkelamin);
        lblkelamin.setBounds(10, 56, 80, 20);
        getContentPane().add(cbKelamin);
        cbKelamin.setBounds(105, 56, 125, 20);
        
        getContentPane().add(lblhobi);
        lblhobi.setBounds(10, 80, 70, 20);
        grupHobi.add(baca);
        grupHobi.add(mancing);
        grupHobi.add(jalan);
        getContentPane().add(baca);
        baca.setBounds(105, 80, 100, 20);
        getContentPane().add(mancing);
        mancing.setBounds(105, 103, 100, 20);
        getContentPane().add(jalan);
        jalan.setBounds(105, 126, 100, 20);
        
        getContentPane().add(label1);
        label1.setBounds(10, 146, 80, 20);
        getContentPane().add(tx1);
        tx1.setBounds(105, 146, 175, 20);
        
        getContentPane().add(label2);
        label2.setBounds(10, 169, 80, 20);
        getContentPane().add(tx2);
        tx2.setBounds(105, 169, 175, 20);
        
        getContentPane().add(label3);
        label3.setBounds(10, 192, 80, 20);
        getContentPane().add(tx3);
        tx3.setBounds(105, 192, 175, 20);
        tx3.setEditable(false);
        
        getContentPane().add(cetak);
        cetak.setBounds(10, 215, 270, 20);
        
        getContentPane().add(hasil);
        hasil.setBounds(10, 238, 270, 140);
        
        setVisible(true);
    }

    void AksiReaksi() {
        cetak.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                hasil.setText("");
                hasil.append(lblnama.getText() + " : " + txnama.getText() + "\n");
                hasil.append(lblnim.getText() + " : " + txnim.getText() + "\n");
                
                String kelaminTerpilih = (String) cbKelamin.getSelectedItem();
                hasil.append(lblkelamin.getText() + " : " + kelaminTerpilih + "\n");
                
                if (baca.isSelected()) {
                    hasil.append(lblhobi.getText() + " : " + baca.getText() + "\n");
                } else if (mancing.isSelected()) {
                    hasil.append(lblhobi.getText() + " : " + mancing.getText() + "\n");
                } else if (jalan.isSelected()) {
                    hasil.append(lblhobi.getText() + " : " + jalan.getText() + "\n");
                } else {
                    hasil.append(lblhobi.getText() + " : Belum dipilih\n");
                }
                
                hasil.append(label1.getText() + " : " + tx1.getText() + "\n");
                hasil.append(label2.getText() + " : " + tx2.getText() + "\n");
                
                double a = 0.0, b = 0.0, c = 0.0;
                try {
                    a = Double.parseDouble(tx1.getText());
                    b = Double.parseDouble(tx2.getText());
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(null, "Input nilai harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                JButton btn = (JButton) event.getSource();
                if (btn == cetak) {
                    c = ((a + b) / 2);
                    tx3.setText(String.valueOf(c));
                }
                hasil.append(String.valueOf("Nilai Akhir : " + c) + "\n");
            }
        });
        
        about.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String pesan = "Aplikasi Data Mahasiswa\n\n"
                             + "Aplikasi ini dirancang untuk mempermudah pencatatan profil\n"
                             + "mahasiswa (meliputi Nama, NIM, Jenis Kelamin, dan Hobi).\n"
                             + "Aplikasi ini juga secara otomatis akan menghitung nilai\n"
                             + "rata-rata akhir berdasarkan input Nilai UTS dan Nilai UAS.\n\n"
                             + "Dibuat untuk memenuhi tugas praktikum Pemrograman Lanjut.";
                JOptionPane.showMessageDialog(null, pesan, "About Program", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    public static void main(String args[]) {
        gui e5 = new gui();
        e5.KomponenVisual();
        e5.AksiReaksi();
    }
}