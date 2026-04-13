import java.time.LocalDate;

public class Pekerja extends Manusia {
    private double gaji;
    private LocalDate tahunMasuk;
    private int jumlahAnak;

    public Pekerja(double gaji, int tahun, int bulan, int hari, int jumlahAnak, String nama, String nik, boolean jenisKelamin, boolean menikah) {
        super(nama, nik, jenisKelamin, menikah);
        this.gaji = gaji;
        this.tahunMasuk = LocalDate.of(tahun, bulan, hari);
        this.jumlahAnak = jumlahAnak;
    }

    public double getGaji() { return gaji; }
    public void setGaji(double gaji) { this.gaji = gaji; }
    public LocalDate getTahunMasuk() { return tahunMasuk; }
    public void setTahunMasuk(LocalDate tahunMasuk) { this.tahunMasuk = tahunMasuk; }
    public int getJumlahAnak() { return jumlahAnak; }
    public void setJumlahAnak(int jumlahAnak) { this.jumlahAnak = jumlahAnak; }

    // 0-5 thn = 5%, 5-10 thn = 10%, >10 thn = 15%
    public double getBonus() {
        int lamaBekerja = LocalDate.now().getYear() - tahunMasuk.getYear();
        if (lamaBekerja <= 5) return gaji * 0.05;
        if (lamaBekerja <= 10) return gaji * 0.10;
        return gaji * 0.15;
    }

    @Override
    public double getTunjangan() {
        return super.getTunjangan() + (jumlahAnak * 20);
    }

    @Override
    public double getPendapatan() {
        return gaji + getBonus() + getTunjangan();
    }

    @Override
    public String toString() {
        return super.toString() +
               "\ntahun masuk : " + tahunMasuk.getDayOfMonth() + " " + tahunMasuk.getMonthValue() + " " + tahunMasuk.getYear() +
               "\njumlah anak : " + jumlahAnak +
               "\ngaji : " + gaji;
    }
}
