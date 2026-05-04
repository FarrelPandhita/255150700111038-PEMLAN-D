import java.awt.*;
import java.awt.event.*;

public class NilaiFrame extends Frame {
    Label lbJudul, lbTugas, lbKuis, lbUTS, lbUAS, lbHasil;
    TextField txtTugas, txtKuis, txtUTS, txtUAS, txtHasil;
    Button btnHitung, btnTampilkan;
    TextArea taHasil;
    CheckboxGroup cbgMatkul;
    Checkbox cbPemlan, cbASD, cbMatkomlan, cbProbstat;

    // Objek mata kuliah
    MataKuliah pemlan, asd, matkomlan, probstat;
    MataKuliah matkulAktif;

    // Menyimpan status apakah matkul sudah dihitung
    boolean pemlanDihitung, asdDihitung, matkomlanDihitung, probstatDihitung;

    public NilaiFrame() {
        setLayout(null);

        // Inisialisasi objek mata kuliah
        pemlan = new Pemlan();
        asd = new ASD();
        matkomlan = new Matkomlan();
        probstat = new Probstat();
        matkulAktif = pemlan;

        // Judul
        lbJudul = new Label("Hitung Nilai Akhir");
        lbJudul.setFont(new Font("Arial", Font.BOLD, 14));
        add(lbJudul);
        lbJudul.setBounds(120, 30, 170, 20);

        // Radio button mata kuliah
        cbgMatkul = new CheckboxGroup();
        cbASD = new Checkbox("ASD", cbgMatkul, false);
        cbPemlan = new Checkbox("Pemlan", cbgMatkul, true);
        cbMatkomlan = new Checkbox("Matkomlan", cbgMatkul, false);
        cbProbstat = new Checkbox("Probstat", cbgMatkul, false);

        add(cbASD);
        cbASD.setBounds(20, 55, 70, 20);
        add(cbPemlan);
        cbPemlan.setBounds(100, 55, 80, 20);
        add(cbMatkomlan);
        cbMatkomlan.setBounds(190, 55, 90, 20);
        add(cbProbstat);
        cbProbstat.setBounds(290, 55, 80, 20);

        // Listener untuk pergantian matkul
        ItemListener matkulListener = new PilihMatkulAction();
        cbASD.addItemListener(matkulListener);
        cbPemlan.addItemListener(matkulListener);
        cbMatkomlan.addItemListener(matkulListener);
        cbProbstat.addItemListener(matkulListener);

        // Label input
        lbTugas = new Label("Tugas :");
        add(lbTugas);
        lbTugas.setBounds(80, 85, 70, 20);

        lbKuis = new Label("Kuis :");
        add(lbKuis);
        lbKuis.setBounds(80, 115, 70, 20);

        lbUTS = new Label("UTS :");
        add(lbUTS);
        lbUTS.setBounds(80, 145, 70, 20);

        lbUAS = new Label("UAS :");
        add(lbUAS);
        lbUAS.setBounds(80, 175, 70, 20);

        lbHasil = new Label("Hasil :");
        add(lbHasil);
        lbHasil.setBounds(80, 205, 70, 20);

        // TextField input
        txtTugas = new TextField();
        add(txtTugas);
        txtTugas.setBounds(200, 85, 80, 20);

        txtKuis = new TextField();
        add(txtKuis);
        txtKuis.setBounds(200, 115, 80, 20);

        txtUTS = new TextField();
        add(txtUTS);
        txtUTS.setBounds(200, 145, 80, 20);

        txtUAS = new TextField();
        add(txtUAS);
        txtUAS.setBounds(200, 175, 80, 20);

        txtHasil = new TextField();
        txtHasil.setEditable(false);
        add(txtHasil);
        txtHasil.setBounds(200, 205, 80, 20);

        // Tombol hitung
        btnHitung = new Button("Hitung");
        add(btnHitung);
        btnHitung.setBounds(140, 235, 100, 25);
        btnHitung.addActionListener(new HitungAction());

        // TextArea untuk menampilkan semua nilai
        taHasil = new TextArea("", 5, 30, TextArea.SCROLLBARS_VERTICAL_ONLY);
        taHasil.setEditable(false);
        add(taHasil);
        taHasil.setBounds(30, 275, 320, 120);

        // Tombol tampilkan semua nilai
        btnTampilkan = new Button("Tampilkan nilai semua matkul");
        add(btnTampilkan);
        btnTampilkan.setBounds(60, 405, 260, 25);
        btnTampilkan.addActionListener(new TampilkanAction());

        // Listener untuk menutup window
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });
    }

    // Aksi saat radio button matkul dipilih
    class PilihMatkulAction implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() != ItemEvent.SELECTED) return;

            Object source = e.getItemSelectable();
            if (source == cbPemlan) {
                matkulAktif = pemlan;
            } else if (source == cbASD) {
                matkulAktif = asd;
            } else if (source == cbMatkomlan) {
                matkulAktif = matkomlan;
            } else if (source == cbProbstat) {
                matkulAktif = probstat;
            }

            // Kosongkan semua TextField saat berpindah matkul
            txtTugas.setText("");
            txtKuis.setText("");
            txtUTS.setText("");
            txtUAS.setText("");
            txtHasil.setText("");
        }
    }

    // Aksi saat tombol Hitung diklik
    class HitungAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int tugas = Integer.parseInt(txtTugas.getText().trim());
            int kuis = Integer.parseInt(txtKuis.getText().trim());
            int uts = Integer.parseInt(txtUTS.getText().trim());
            int uas = Integer.parseInt(txtUAS.getText().trim());

            matkulAktif.setNilai(tugas, kuis, uts, uas);
            double hasil = matkulAktif.hitungNilaiAkhir();
            txtHasil.setText(String.valueOf(hasil));

            // Tandai matkul sudah dihitung
            if (matkulAktif == pemlan) pemlanDihitung = true;
            else if (matkulAktif == asd) asdDihitung = true;
            else if (matkulAktif == matkomlan) matkomlanDihitung = true;
            else if (matkulAktif == probstat) probstatDihitung = true;
        }
    }

    // Aksi saat tombol Tampilkan diklik
    class TampilkanAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            StringBuilder sb = new StringBuilder();
            sb.append("HASIL NILAI SEMUA MATA KULIAH\n");

            if (pemlanDihitung)
                sb.append("Pemlan\t\t: " + pemlan.getNilaiAkhir() + "\n");
            if (asdDihitung)
                sb.append("ASD\t\t: " + asd.getNilaiAkhir() + "\n");
            if (matkomlanDihitung)
                sb.append("Matkomlan\t: " + matkomlan.getNilaiAkhir() + "\n");
            if (probstatDihitung)
                sb.append("Probstat\t\t: " + probstat.getNilaiAkhir() + "\n");

            if (!pemlanDihitung && !asdDihitung && !matkomlanDihitung && !probstatDihitung)
                sb.append("Belum ada nilai yang dihitung.");

            taHasil.setText(sb.toString());
        }
    }
}
